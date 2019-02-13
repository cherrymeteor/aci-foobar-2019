package com.aciw.foobar.utility;

import java.util.ArrayList;

public class LibsAndDepsAnswer {
	
	String Library; //name of Library
	ArrayList<String> Dependencies = new ArrayList<String>();
	
	public LibsAndDepsAnswer(){
	}
	
	public LibsAndDepsAnswer(String Library, ArrayList<String> Dependencies) {
		this.Library = Library;
		this.Dependencies = Dependencies;
	}

	public String getLibrary() {
		return Library;
	}

	public ArrayList<String> getDependencies() {
		return Dependencies;
	}

}
