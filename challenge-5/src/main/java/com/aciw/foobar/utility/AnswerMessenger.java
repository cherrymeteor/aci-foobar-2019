package com.aciw.foobar.utility;

/**
 * DO NOT MODIFY
 * 
 * @author Administrator
 *
 */
public class AnswerMessenger {
	private String file;
	private String hash;
	public AnswerMessenger(String file, String hash) {
		super();
		this.file = file;
		this.hash = hash;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
}
