package com.java.tutorial.Basic;

import org.joda.time.DateTime;

import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class tem {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int month = scanner.nextInt();
//        int day = scanner.nextInt();
//        int year = scanner.nextInt();
//        String time = year + "-" + month + "-" + day;
//        DateTime date = new DateTime("" + time);
//        DateTime.Property day1 = date.dayOfWeek();
//        String dayName = day1.getAsText();
//        System.out.println(dayName);
//
//        Date date1=new Date(2023/02/17);
//        System.out.println(date1.getDay());
//        LocalDate time1=LocalDate.of(year,month,day);
//        DayOfWeek day3=time1.getDayOfWeek();
//        System.out.println(time1.getDayOfMonth());
//        System.out.println(time1.getDayOfWeek());
//        String day5=day3.name();
//        System.out.println(day5);
//        Scanner scanner=new Scanner(System.in);
//        String dateM=scanner.next();
//        String dateD=scanner.next();
//        String dateY=scanner.next();
//        int month=Integer.parseInt(dateM);
//        int day=Integer.parseInt(dateD);
//        int year=Integer.parseInt(dateY);
//        LocalDate time=LocalDate.of(year,month,day);
//        System.out.println(time.getDayOfWeek());
//
//        double payment=12324.134;
//        NumberFormat numberFormatUS=NumberFormat.getCurrencyInstance(Locale.US);
//        String us=numberFormatUS.format(payment);
//        NumberFormat numberFormatIndia=NumberFormat.getCurrencyInstance(new Locale("en","IN"));
//        String india=numberFormatIndia.format(payment);
//        System.out.println(us);
//        System.out.println(india);
//        Add(1,2,3,4);
//    }
//    public static void Add(int... a){
//        int s=0;
//        String n="";
//        for(int i=0;i<a.length;i++){
//            s=s+a[i];
//            if (i==0){
//                n=""+a[i];
//            }else {
//                n=n+"+"+a[i];
//            }
//            if (i==a.length-1){
//                System.out.println(n+"="+s);
//            }
//        }
//        String a = "Hello";
//        String b = "hello";
//        if (a.length() != b.length()) {
//            System.out.println("False");
//        } else {
//            Map<String, Integer> mapA = new HashMap<>();
//            while (a.length() >= 1) {
//                int countOfA = 0;
//                String a1 = String.valueOf(a.charAt(0));
//                for (int e = 1; e < a.length(); e++) {
//                    String ae = String.valueOf(a.charAt(e));
//                    if (a1.equalsIgnoreCase(ae)) {
//                        countOfA += 1;
//                    }
//                }
//                String a2=a1.toLowerCase();
//                mapA.put(a2, countOfA);
//                a = a.replaceAll(a1, "");
//            }
//            System.out.println(mapA);
//            Map<String, Integer> mapB = new HashMap<>();
//            while (b.length() >= 1) {
//                int countOfB = 0;
//                String b1 = String.valueOf(b.charAt(0));
//                for (int e = 1; e < b.length(); e++) {
//                    String be = String.valueOf(b.charAt(e));
//                    if (b1.equalsIgnoreCase(be)) {
//                        countOfB += 1;
//                    }
//                }
//                String b2=b1.toLowerCase();
//                mapB.put(b2, countOfB);
//                b = b.replaceAll(b1, "");
//            }
//            Set<String> setKeys=mapB.keySet();
//            System.out.println(mapB);
//            if (mapA.equals(mapB)){
//                System.out.println("True");
//            }
//            else {
//                System.out.println("False");
//            }
//        }
//        String s="                                        ";
//        s=s.trim();
//        s=s.replace("."," ");
//        s=s.replace("'"," ");
//        s=s.replace("!"," ");
//        s=s.replace("_"," ");
//        s=s.replace("?"," ");
//        s=s.replace("@"," ");
//        s=s.replace(","," ");
//        s=s.replaceAll("\\s+"," ");
//        System.out.println(s.length());
//        if (s.length()==0){
//            System.out.println("0");
//        }else {
//            String[] s2=s.split(" ");
//            System.out.println(s2.length);
//            for (String i:s2){
//                System.out.println(i);
//            }
//        }
//        List<String> s1=new ArrayList<>();
//        s1=Arrays.asList(s2);
//        String s3=s1.toString();
//        System.out.println(s3);
//        System.out.println(s1.size());


        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String pattern = in.nextLine();
            //Write your code
            try {
                Pattern p=Pattern.compile(pattern);
                System.out.println("Valid");
            }catch (PatternSyntaxException e){
                System.out.println("Invalid");
            }
            testCases-=1;
        }
        Scanner in1 = new Scanner(System.in);
        while(in1.hasNext()){
            String IP = in1.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
        in1.close();
    }

}
class MyRegex{
    final String pattern="(([01]?\\d{1,2})|(2[0-4]\\d)|(25[0-5]))." +
            "(([01]?\\d{1,2})|(2[0-4]\\d)|(25[0-5]))." +
            "(([01]?\\d{1,2})|(2[0-4]\\d)|(25[0-5]))." +
            "(([01]?\\d{1,2})|(2[0-4]\\d)|(25[0-5]))";
}
