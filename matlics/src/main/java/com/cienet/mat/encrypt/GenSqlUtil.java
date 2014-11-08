package com.cienet.mat.encrypt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GenSqlUtil {
	private static final String updatePubkeyFmt = "update mat_SvcCfg set pubKey='%s';";

	private static final String updateMacFmt = "update mat_SvcCfg set serverInfo='%s';";

	private static final String updateNodeLicsFmt = "update mat_NodeLics set licsContent='%s' where licsId='%s';";

	private static final String createNodeLicsFmt = "insert into mat_NodeLics (licsId,licsContent) values('%s','%s');";

	public static List<String> buildSqls(List<String> fileContents) throws Exception {
		List<String> sqls = new ArrayList<String>();
		sqls.add(String.format(updatePubkeyFmt, Const.PUBLIC_KEY));
		sqls.add(String.format(updateMacFmt, Encrypt.encryptByPrivateKey(fileContents.remove(0))));
		for (String content : fileContents) {
			int len = content.length();
			String licsId = content.substring(0, len - 9).trim();
			String dataStr = content.substring(len - 9, len - 1);
			String licsContent = licsId + dataStr;
			System.out.println(licsContent);
			if (content.endsWith("c")) {
				sqls.add(String.format(createNodeLicsFmt, licsId, Encrypt.encryptByPrivateKey(licsContent)));
			} else if (content.endsWith("u")) {
				sqls.add(String.format(updateNodeLicsFmt, Encrypt.encryptByPrivateKey(licsContent), licsId));
			}
		}
		return sqls;
	}

	public static List<String> readFileByLines(String fileName) {
		File file = new File(fileName);
		System.out.println(file.exists());
		BufferedReader reader = null;
		List<String> fileContents = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempStr = null;
			while ((tempStr = reader.readLine()) != null) {
				tempStr = tempStr.trim();
				if (tempStr.length() > 0) {
					System.out.println(tempStr);
					fileContents.add(tempStr);
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Can not parse input file!");
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					System.out.println("Close file error!");
					e1.printStackTrace();
				}
			}
		}
		return fileContents;
	}

	public static void writeSqlFile(List<String> sqls, String fileName) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(fileName);
			for (String sql : sqls) {
				pw.write(sql + "\n");
			}
			pw.flush();
		} catch (Exception e) {
			System.out.println("Write Sql file error!");
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

	}
}
