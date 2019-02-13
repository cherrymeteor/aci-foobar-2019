package com.aciw.foobar.challenge2;

import java.io.IOException;
import java.util.*;

import com.aciw.foobar.utility.Challenge2Util;
import com.aciw.foobar.utility.Decryption;
import com.aciw.foobar.utility.RESTClient;

import javax.crypto.BadPaddingException;

/**
 * @author Administrator
 */
public class Challenge2 {
    private static final String username = "McDonalds"; // !!! ADD YOUR TEAM NAME HERE     !!!
    private static final String password = "2VrqJ66lkq"; // !!! ADD YOUR TEAM PASSWORD HERE !!!

    public static void main(String[] args) {
        // set login credentials
        RESTClient.setUsername(username);
        RESTClient.setPassword(password);

        ArrayList<Decryption> quote = RESTClient.getInput(1);// Gets the 5 String of Simpsons quotes.
        ArrayList<Decryption> encryptedQuote = RESTClient.getInput(2); // Gets the encrypted quote with a random hashed password.
        ArrayList<Decryption> passwords = RESTClient.getInput(3); // Gets 50000 passwords.

        ArrayList<String> hashed = new ArrayList<>();
        passwords.forEach(decryption -> {
            hashed.add(Challenge2Util.sha256(decryption.getname()));
        });

        Map<Integer, String> pwd = new HashMap<>();

        //every encrypted text
        for (int i = 0; i < encryptedQuote.size(); i++) {
            String decrypted = encryptedQuote.get(i).getname();

            for (int j = 0; j < hashed.size(); j++) {
                try {
                    String plainText = Challenge2Util.Decrypt(decrypted, hashed.get(j));
                    if (plainText.equals(quote.get(i).getname())) {
                        pwd.put(i, passwords.get(j).getname());
                        break;
                    }
                } catch (Exception ignored) {
                }
            }
        }

        System.out.println(pwd);

//        RESTClient.sendOutput(pwd); // Send the answer! type: ArrayList<String>

    }
}
