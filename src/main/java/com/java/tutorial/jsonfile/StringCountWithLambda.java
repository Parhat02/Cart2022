package com.java.tutorial.jsonfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCountWithLambda {
    public static void main(String[] args) {
        String s = "ksglkdshagikhweituwopuvna";
//        int l = s.length();
//        while (l>0){
//            int count = 0;
//            for (int i = 0; i < l; i++) {
//                if (s.charAt(0) == s.charAt(i)) {
//                    count += 1;
//                }
//            }
//            System.out.println(count + " " + s.charAt(0) + " in total in this string");
//            s = s.replaceAll(String.valueOf(s.charAt(0)), "");
//            System.out.println(s);
//            l=s.length();
//        }

        //writing with lambda
        List<String> strings=new ArrayList<>();
        for (int i=0;i<s.length();i++){
            strings.add(String.valueOf(s.charAt(i)));
        }
        Map<String, Long> result=strings.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(result);
    }
}
