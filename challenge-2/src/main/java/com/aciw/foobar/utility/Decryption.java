package com.aciw.foobar.utility;
import java.io.Serializable;

/**
 * DO NOT MODIFY
 * 
 * @author MaherK
 *
 */
public class Decryption implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	

	
	public Decryption() {
	
	}
	
	public Decryption(String name) {
		super();
		this.name = name;
	}
	
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return name;
	}
	
	
	
}
