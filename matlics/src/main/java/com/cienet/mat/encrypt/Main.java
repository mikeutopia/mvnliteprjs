package com.cienet.mat.encrypt;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			System.out.println("Please input file name as first parameter!");
		}
		try {
			// String fileName = "./" + args[0];
			String fileName = "/home/cz/tmp/testmatlics/server.txt";

			List<String> fileContents = GenSqlUtil.readFileByLines(fileName);
			List<String> sqls = GenSqlUtil.buildSqls(fileContents);
			GenSqlUtil.writeSqlFile(sqls, fileName + ".sql");
		} catch (Exception e) {
			System.out.println("Exception!");
			e.printStackTrace();
		}

	}
}
