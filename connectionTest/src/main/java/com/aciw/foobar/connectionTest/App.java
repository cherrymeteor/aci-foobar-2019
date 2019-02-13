package com.aciw.foobar.connectionTest;

import com.aciw.foobar.utility.RESTClient;

/**
 * Sample class to test connectivity with central server for challenges.
 * 
 * 
 * @author Administrator
 *
 *
 */

public class App 
{
	private static final String username = "McDonalds"; // !!! ADD YOUR TEAM NAME HERE     !!!
	private static final String password = "2VrqJ66lkq"; // !!! ADD YOUR TEAM PASSWORD HERE !!!
	

    public static void main( String[] args )
    {
    	// Set credentials
    	RESTClient.setUsername(username);
    	RESTClient.setPassword(password);


    	
    	String input = RESTClient.getInput();
    	System.out.println(input);
    	RESTClient.sendOutput("Hello World!");
    }
}
