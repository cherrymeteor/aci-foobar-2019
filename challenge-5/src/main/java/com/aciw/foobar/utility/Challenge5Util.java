package com.aciw.foobar.utility;

import java.security.MessageDigest;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class Challenge5Util {
	public static String hash(String transactions) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] serialized = transactions.getBytes("UTF-8");
			md.update(serialized);
			byte[] digest = md.digest();
			String result = (new HexBinaryAdapter()).marshal(digest).toLowerCase();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
