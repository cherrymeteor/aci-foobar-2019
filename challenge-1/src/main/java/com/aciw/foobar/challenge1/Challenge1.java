package com.aciw.foobar.challenge1;

import java.util.ArrayList;
import java.util.Scanner;

import com.aciw.foobar.utility.Challenge1Util;
import com.aciw.foobar.utility.RESTClient;
import com.aciw.foobar.utility.TransactionID;

/**
 * @author Administrator
 */
public class Challenge1 {
    private static final String username = "McDonalds"; // !!! ADD YOUR TEAM NAME HERE     !!!
    private static final String password = "2VrqJ66lkq"; // !!! ADD YOUR TEAM PASSWORD HERE !!!

    public static void main(String[] args) {
        // set login credentials
        RESTClient.setUsername(username);
        RESTClient.setPassword(password);

        ArrayList<TransactionID> transIds = RESTClient.getInput();

        ArrayList<String> arrayList = new ArrayList<>();
        transIds.forEach(transactionID ->{
            if(transactionID.gettype().equals("CR")){
                String str = transactionID.gettrans_id();
                StringBuffer sb = new StringBuffer(str);
                sb.reverse();

                if (sb.toString().equals(str)){
                    arrayList.add(Challenge1Util.sha256(transactionID.gettrans_id()));
                }
            }
        });

//        RESTClient.sendOutput(arrayList); // Send the Answer. Type: ArrayList<String>


    }

}
