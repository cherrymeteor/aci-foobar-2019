package com.aciw.foobar.utility;

public class Message {
	
	int msgID;
	int date;
	
	//Constructor Declaration for Message
	public Message(int msgID, int date) {
		this.msgID = msgID;
		this.date = date;
	}
	
	public int getMsgID() {
		return msgID;
	}
	
	public void setDate(int date) {
		 this.date = date;
	}
	
	public int getDate() {
		return date;
	}

}
