package cz.mvn.db.mysql;

import java.util.Arrays;
import java.util.List;

public class ListToStrTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("aaa", "bbb", "ccc");
		System.out.println(list.toString().replace("[", "").replace("]", ""));
	}
}
