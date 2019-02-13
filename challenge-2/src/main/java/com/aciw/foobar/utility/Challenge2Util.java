package com.aciw.foobar.utility;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Challenge2Util {

	public static String sha256(String base) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();
	
	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }
	
	        return hexString.toString();
	    } catch(Exception ex){
	        throw new RuntimeException(ex);
	    }
	}

	public static String Decrypt(String text, String key) throws Exception {
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    byte[] keyBytes= new byte[16];
	    byte[] b= key.getBytes("UTF-8");
	    int len= b.length;
	    if (len > keyBytes.length) len = keyBytes.length;
	    System.arraycopy(b, 0, keyBytes, 0, len);
	    SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
	    IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
	    cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);
	
	    byte [] results = cipher.doFinal(DatatypeConverter.parseBase64Binary(text));
	    
	    return new String(results,"UTF-8");
			    
	}

}
