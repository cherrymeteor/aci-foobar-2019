package com.aciw.foobar.challenge3;

import com.aciw.foobar.utility.RESTClient;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Administrator
 */
public class Challenge3 {
    private static final String username = "McDonalds"; // !!! ADD YOUR TEAM NAME HERE     !!!
    private static final String password = "2VrqJ66lkq"; // !!! ADD YOUR TEAM PASSWORD HERE !!!

    // Starting list of dependencies
    private static final String[] Selections = {"ACI", "FooBar", "Challenge", "2019"};

    private static HashMap<String, List<String>> dict;
    private static Set<String> result;

    public static void main(String[] args) throws IOException {
        // set login credentials
        RESTClient.setUsername(username);
        RESTClient.setPassword(password);


        /**
         * The user must read in the file from files/ListOfWords.txt to begin the challenge
         */

        String libs = FileUtils.readFile(Paths.get("").toAbsolutePath() + "\\challenge-3\\files\\ListOfWords.txt");

        String[] split = libs.split("[,\n]");
        List<String> wordList = Arrays.asList(split);

        dict = new HashMap<>();
        result = new HashSet<>();

        for (int i = 0; i < wordList.size(); i += 4) {
            List<String> deps = new ArrayList<>();
            deps.add(wordList.get(i + 1));
            deps.add(wordList.get(i + 2));
            deps.add(wordList.get(i + 3));
            dict.put(wordList.get(i), deps);
        }

        Arrays.asList(Selections).forEach(Challenge3::recursive);

        ArrayList<String> list = new ArrayList<>(result);
        Collections.sort(list);

        System.out.println(list);

    	RESTClient.sendOutput(list.toArray(new String[result.size()])); // Send the answer. Type: String[]
    }

    public static void recursive(String lib) {
        List<String> deps = dict.get(lib);
        if (deps != null) {
            deps.forEach(s -> {
                if(!result.contains(s)){
                    result.add(s);
                    recursive(lib);
                }
            });
        }
    }

}
