package com.g2sky.pgd.intf.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimplePool<T> {
	private static final Logger logger = LoggerFactory.getLogger(SimplePool.class);
	private int minSize;
	private int maxSize;
	private int queueSize;
	private final AtomicInteger createCnt = new AtomicInteger(0);
	private final AtomicInteger needCnt = new AtomicInteger(0);
	private ArrayBlockingQueue<T> nowQueue;
	private PoolObjFactory<T> factory;

	public SimplePool(PoolObjFactory<T> factory) {
		this(factory, 15, 10);
	}

	public SimplePool(PoolObjFactory<T> factory, int maxSize, int minSize) {
		logger.debug("UUUUDSUDUS");
		try {
			this.minSize = minSize;
			this.maxSize = maxSize;
			this.factory = factory;
			queueSize = minSize;
			nowQueue = new ArrayBlockingQueue<T>(queueSize);
		} catch (Exception e) {
			logger.error("CREATE SimplePool ERROR!", e);
		}

	}

	public T borrowObj() throws Exception {
		needCnt.incrementAndGet();
		checkQueueCap();
		return nowQueue.take();
	}

	public void returnObj(T t) throws Exception {
		needCnt.decrementAndGet();
		try {
			nowQueue.add(t);
		} catch (IllegalStateException ise) {
			factory.destroyObj(t);
		}
		checkQueueCap();
	}

	private void checkQueueCap() throws Exception {
		if (needCnt.get() > queueSize * 2) {
			int newQueueSize = queueSize * 3 / 2;
			if (newQueueSize <= maxSize) {
				queueSize = newQueueSize;
				nowQueue = new ArrayBlockingQueue<T>(queueSize);
			}
		} else if (needCnt.get() * 2 < queueSize) {
			int newQueueSize = queueSize * 2 / 3;
			if (newQueueSize > minSize) {
				queueSize = newQueueSize;
				nowQueue = new ArrayBlockingQueue<T>(queueSize);
			}
		}
		if (createCnt.get() < queueSize) {
			createCnt.incrementAndGet();
			nowQueue.put(factory.createObj());
		}
		logger.debug(String.format("QS:%d,NC:%d", queueSize, needCnt.get()));
	}
}
