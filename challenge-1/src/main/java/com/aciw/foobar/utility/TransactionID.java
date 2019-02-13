package com.aciw.foobar.utility;
import java.io.Serializable;

/**
 * DO NOT MODIFY
 * 
 * @author Maherk
 *
 */
public class TransactionID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String trans_id;
	private String type;
	

	
	public TransactionID() {
	
	}
	
	public TransactionID(String trans_id, String type) {
		super();
		this.trans_id = trans_id;
		this.type = type;
	}
	
	public String gettrans_id() {
		return trans_id;
	}

	public void settrans_id(String trans_id) {
		this.trans_id = trans_id;
	}
	
	public String gettype() {
		return type;
	}

	public void settype(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return trans_id+ ","+type;
	}
	
	
	
}
