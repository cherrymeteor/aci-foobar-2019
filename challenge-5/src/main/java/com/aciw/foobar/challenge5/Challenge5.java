package com.aciw.foobar.challenge5;

import com.aciw.foobar.utility.Challenge5Util;
import com.aciw.foobar.utility.RESTClient;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 */
public class Challenge5 {
    private static final String username = "McDonalds"; // !!! ADD YOUR TEAM NAME HERE     !!!
    private static final String password = "2VrqJ66lkq"; // !!! ADD YOUR TEAM PASSWORD HERE !!!

    public static void main(String[] args) throws IOException {
        // set login credentials
        RESTClient.setUsername(username);
        RESTClient.setPassword(password);

        String amountsText = FileUtils.readFile(Paths.get("").toAbsolutePath() + "\\challenge-5\\files\\Amounts.txt");
        String countriesText = FileUtils.readFile(Paths.get("").toAbsolutePath() + "\\challenge-5\\files\\Countries.txt");
        String cvvsText = FileUtils.readFile(Paths.get("").toAbsolutePath() + "\\challenge-5\\files\\CVVs.txt");
        String pansText = FileUtils.readFile(Paths.get("").toAbsolutePath() + "\\challenge-5\\files\\PANs.txt");
        String ptText = FileUtils.readFile(Paths.get("").toAbsolutePath() + "\\challenge-5\\files\\Payment Types.txt");
        String tidsText = FileUtils.readFile(Paths.get("").toAbsolutePath() + "\\challenge-5\\files\\Transaction IDs.txt");

        List<String> amounts = Arrays.asList(amountsText.split("[,\n]"));
        List<String> countries = Arrays.asList(countriesText.split("[,\n]"));
        List<String> cvvs = Arrays.asList(cvvsText.split("[,\n]"));
        List<String> pans = Arrays.asList(pansText.split("[,\n]"));
        List<String> pts = Arrays.asList(ptText.split("[,\n]"));
        List<String> tids = Arrays.asList(tidsText.split("[,\n]"));

        List<String> amountsNew = new ArrayList<>();
        amounts.forEach(s -> amountsNew.add(String.valueOf((int) (Double.parseDouble(s) * 100))));

        System.out.println(amountsNew);
        StringBuilder fileString = new StringBuilder();
        fileString.append("VOL1").append("\n");
        DecimalFormat decimalformat = new DecimalFormat("000000");
        for (int i = 0; i < 100; i++) {
            fileString
                    .append(decimalformat.format(i + 1))
                    .append(tids.get(i))
                    .append(countries.get(i))
                    .append(amountsNew.get(i))
                    .append(pans.get(i))
                    .append(decimalformat.format(Integer.parseInt(cvvs.get(i))))
                    .append(pts.get(i))
                    .append("\n");
        }

        DecimalFormat df1 = new DecimalFormat("00000000");

        int totalE1 = 0;
        int totalE2 = 0;
        int total = 0;
        for (int i = 0; i < pts.size(); i++) {
            String pt = pts.get(i);
            if (pt.equals("E1")) {
                totalE1 += Integer.parseInt(amountsNew.get(i));
            } else {
                totalE2 += Integer.parseInt(amountsNew.get(i));
            }
            total += Integer.parseInt(amountsNew.get(i));
        }

        fileString
                .append("UTL1")
                .append(df1.format(100))
                .append(df1.format(pts.stream().filter(s -> s.equals("E1")).count()))
                .append(df1.format(pts.stream().filter(s -> s.equals("E2")).count()))
                .append(df1.format(total))
                .append(df1.format(totalE1))
                .append(df1.format(totalE2));

        System.out.println(fileString);
        String hash = Challenge5Util.hash(fileString.toString());
        System.out.println(hash);
        RESTClient.sendOutput(fileString.toString(), hash); // Send the Answer. Type: String, String
    }

}
