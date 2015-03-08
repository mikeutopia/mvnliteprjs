package com.g2sky.pgd.intf.test;

public interface PoolObjFactory<T> {
	T createObj() throws Exception;

	void destroyObj(T t) throws Exception;
}
