package cz.mvn.db.util;

import java.sql.ResultSet;

public interface QueryCb<T> {
	T dataToObj(ResultSet rs) throws Exception;
}
