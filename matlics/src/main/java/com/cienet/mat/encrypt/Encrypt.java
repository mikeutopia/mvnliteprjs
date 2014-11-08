package com.cienet.mat.encrypt;

public class Encrypt {
	// private static String code = "dsfafsdafds";
	//
	// public static void main(String[] args) throws Exception {
	// // testPr2Pu();
	// String mm = encryptByPrivateKey(code);
	// System.out.println(mm);
	//
	// String oo = decryptByPublicKey(mm);
	// System.out.println(oo);
	// }

	public static String encryptByPrivateKey(String src) throws Exception {
		byte[] encodedData = CoderUtil.encryptByPrivateKey(src.getBytes("utf8"), Const.PRIVATE_KEY);
		return CoderUtil.bytesToStr(encodedData);
	}

	public static String decryptByPublicKey(String src) throws Exception {
		byte[] srcBytes = CoderUtil.strToBytes(src);
		byte[] decodedData = CoderUtil.decryptByPublicKey(srcBytes, Const.PUBLIC_KEY);
		return new String(decodedData, "utf8");
	}

	public static String encryptByPublicKey(String src) throws Exception {
		byte[] encodedData = CoderUtil.encryptByPublicKey(src.getBytes("utf8"), Const.PUBLIC_KEY);
		return CoderUtil.bytesToStr(encodedData);
	}

	public static String decryptByPrivateKey(String src) throws Exception {
		byte[] srcBytes = CoderUtil.strToBytes(src);
		byte[] decodedData = CoderUtil.decryptByPrivateKey(srcBytes, Const.PRIVATE_KEY);
		return new String(decodedData, "utf8");
	}

	public static void testPr2Pu() throws Exception {
		String code = "dsfafsdafds";
		byte[] encodedData = CoderUtil.encryptByPrivateKey(code.getBytes("utf8"), Const.PRIVATE_KEY);
		CoderUtil.printBytes(encodedData);
		String ss = CoderUtil.bytesToStr(encodedData);
		System.out.println(ss);
		byte[] encodedData1 = CoderUtil.strToBytes(ss);
		CoderUtil.printBytes(encodedData1);
		byte[] decodedData = CoderUtil.decryptByPublicKey(encodedData1, Const.PUBLIC_KEY);
		System.out.println(new String(decodedData, "utf8"));
	}

}
