package com.java.tutorial.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReadFromUrlDemo {
    public static void main(String[] args) throws IOException {
        List<String> websites=new ArrayList<>();
        websites.add("https://www.google.com/");
        websites.add("https://www.unitedcoder.com/");
        for (String website:websites){
            System.out.println("Reading from "+website);
            URL url = new URL(website);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        }

    }
}
