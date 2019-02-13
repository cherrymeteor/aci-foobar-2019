package com.aciw.foobar.challenge4;

import com.aciw.foobar.utility.RESTClient;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
public class Challenge4 {
    private static final String username = "McDonalds"; // !!! ADD YOUR TEAM NAME HERE     !!!
    private static final String password = "2VrqJ66lkq"; // !!! ADD YOUR TEAM PASSWORD HERE !!!

    public static void main(String[] args) throws IOException, ParseException {
        // set login credentials
        RESTClient.setUsername(username);
        RESTClient.setPassword(password);

        /**
         * The user must read in the file from files/MsgIDAndDates.txt to begin the challenge
         */
        String txt = FileUtils.readFile(Paths.get("").toAbsolutePath() + "\\challenge-4\\files\\MsgIDAndDates.txt");

        String[] split = txt.split("[,\n]");
        List<String> list = Arrays.asList(split);

        HashMap<String, Date> msg = new HashMap<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        for (int i = 0; i < list.size(); i+=2) {
            Date date = simpleDateFormat.parse(list.get(i+1));
            msg.put(list.get(i), date);
        }
        System.out.println(msg);

        LinkedHashMap<String, Date> sorted = msg.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(sorted);

        List<String> keys = new ArrayList<>(sorted.keySet());

        System.out.println(keys.get(127));
        System.out.println(keys.get(387));
        System.out.println(keys.get(711));
        System.out.println(keys.get(899));


        RESTClient.sendOutput(new int[]{13000,
                13294,
                13339,
                12564}); // Send the Answer. Type: int[]
    }
}
