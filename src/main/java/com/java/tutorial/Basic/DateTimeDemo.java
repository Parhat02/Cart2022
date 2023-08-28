package com.java.tutorial.Basic;

import com.java.tutorial.Exercises.DataType;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.text.ParseException;
import java.text.DateFormat;
import java.util.Scanner;


public class DateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime localTime=LocalDateTime.now();
        System.out.println("Day of the month:"+localTime.getDayOfMonth());
        System.out.println("Month :"+localTime.getMonth());
        System.out.println("Week :"+localTime.getDayOfWeek());
        System.out.println("Year :"+localTime.getYear());
        System.out.println("Day of the year :"+localTime.getDayOfYear());

        // Use Joda time with JDK
        DateTime dt=new DateTime(DateTimeZone.UTC);
        //get current date time using JDK
        //Date jdkDate=dt.toDate();
        //dt=new DateTime(jdkDate);
        System.out.println("Current Universal date time is "+dt.toString());
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);

        //Returns the current value of the running Java Virtual Machine's high-resolution time source in nanoseconds
        System.out.println("Current time by nanoseconds : "+System.currentTimeMillis());
        //Java Date utility
        Date date=new Date();
        String pattern="yyyy-MM-dd-hh-mm-sss";
        SimpleDateFormat format1=new SimpleDateFormat(pattern);
        System.out.println(format1.format(date));
        System.out.println();
        //from Joda to JDK
        DateTime dateT=new DateTime();
        System.out.println(dateT);
        // get current date time
        Date jdkDate=dateT.toDate();
        System.out.println(jdkDate);
        //from JDR to Joda
        dateT=new DateTime(jdkDate);
        System.out.println("Current date time is "+dateT.toString());
        //get day, month, year
        System.out.println("Day: "+dateT.getDayOfMonth()+" Year: "+dateT.getYear()+" Month: "+dateT.getMonthOfYear());
        System.out.println();

        //add 1 month, add 10 days
        System.out.println("Current date time is: "+dateT.toString());
        System.out.println("Add 1 month: "+dateT.plusMonths(1));
        System.out.println("Add 10 days: "+dateT.plusDays(10));

        //get date time difference
        DateTime d1=new DateTime("2017-10-05");
        DateTime d2=new DateTime("2017-12-05");
        Duration duration=new Duration(d1,d2);
        System.out.println("Difference is "+duration.getStandardDays()+" days");
        Period period=new Period(d1,d2, PeriodType.days());
        Period period1=new Period(d1,d2,PeriodType.weeks());
        System.out.println("Total days: " +period.getDays());
        System.out.println("Total weeks: "+period1.getWeeks());

        //define joda date time
        DateTime dt1=new DateTime();
        //get current date time
        //from Joda to JDK
        Date currentTime=dt1.toDate();
        //print out current date time in simple date time format
        System.out.println(currentTime);
        //convert jdk date to joda time
        dt1=new DateTime(currentTime);
        int day=dt1.dayOfMonth().get();
        System.out.println(day);
        int daysToAdd=5;
        int newDay=dt1.plusDays(daysToAdd).getDayOfMonth();
        System.out.println(newDay);
        //get day time property
        dt1=new DateTime(dt1.plusDays(daysToAdd));
        DateTime.Property dayName=dt1.dayOfWeek();
        String shortDayName=dayName.getAsShortText();
        System.out.println("Short day name: " +shortDayName);
        String fullDayName=dayName.getAsText();
        System.out.println("Full day name: "+fullDayName);
        //get month info
        String month=dt1.monthOfYear().getAsText();
        System.out.println("Month is: "+month);
        int maxDay=dt1.dayOfMonth().getMaximumValue();
        System.out.println("Maximum days: "+maxDay);
        boolean leapYear=dt1.yearOfEra().isLeap();
        System.out.println("Is leap year: "+leapYear);
        System.out.println("Era is: "+dt1.getEra());
        System.out.println("Year is: "+dt1.getYear());
        System.out.println("Week is: "+dt1.getWeekOfWeekyear());
        System.out.println("Century is: "+dt1.getCenturyOfEra());
        System.out.println("Year of Era is: "+dt1.getYearOfEra());
        System.out.println("Year of century is: "+dt1.getYearOfCentury());
        System.out.println("Month of year: "+dt1.getMonthOfYear());
        System.out.println("Day of year: "+dt1.getDayOfYear());
        System.out.println("Day of month: "+dt1.getDayOfMonth());
        System.out.println("Day of week: "+dt1.getDayOfWeek());
        System.out.println("week of year: "+dt1.getWeekyear());

        //format date time
        DateTimeFormatter fmt= DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm");
        String d= dt1.toString(fmt);
        System.out.println(d);
        //Date time zone
        DateTime dt2=new DateTime();
        Date current=dt2.toDate();
        dt2=new DateTime(current);
        DateTimeZone zoneLondon=DateTimeZone.forID("Europe/London");
        DateTime dtZoneLondon=new DateTime(dt2.withZone(zoneLondon));
        System.out.println("Date time in London zone: "+dtZoneLondon);
        DateTimeZone zoneTokyo=DateTimeZone.forID("Asia/Tokyo");
        DateTime dtZoneTokyo=new DateTime(dt2.withZone(zoneTokyo));
        System.out.println("Date time in Tokyo zone: "+dtZoneTokyo);

        //define simple date time format
        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //define Joda time
        DateTime dt3=new DateTime();
        //get current date time
        Date currentDate=dt3.toDate();
        System.out.println(currentDate);
        try{
            //convert current date time to unix format
            long currentDateEpoch=dateFormat.parse(dateFormat.format(currentDate)).getTime();
            System.out.println("Current Date Time Unix Format: "+currentDateEpoch);
        }catch (ParseException e){
            e.printStackTrace();
        }
        //initialize days to add
        int daysToAdd1=30;
        //add days to current date
        Date newDate=dt3.plusDays(daysToAdd1).toDate();
        System.out.println("New date after adding days: "+newDate);
        try {
            long newDateEpoch=dateFormat.parse(dateFormat.format(newDate)).getTime();
            System.out.println("New date time unix format: "+newDateEpoch);
        }catch (ParseException e){
            e.printStackTrace();
        }
        System.out.println("------------------------");



        //define a new Joda date time
        DateTime dt5=new DateTime();
        System.out.println(dt5);
        //use formatter to print the date time
        DateTimeFormatter formatter=DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm");
        System.out.println(dt5.toString(formatter));

        //get universal time
        DateTime universalTime=new DateTime(DateTimeZone.UTC);
        System.out.println("Universal time: "+universalTime);
        //Time zone
        DateTimeZone londonTimeZone=DateTimeZone.forID("Europe/London");
        DateTime londonTime=new DateTime(londonTimeZone);
        System.out.println("London Time: "+londonTime);


        Scanner scanner=new Scanner(System.in);
        int month1=scanner.nextInt();
        int day2=scanner.nextInt();
        int year=scanner.nextInt();
        String time=year+"-"+month1+"-"+day2;
        DateTime date1=new DateTime(""+year+"-"+month1+"-"+day2);
        DateTime.Property day7=date1.dayOfWeek();
        String dayName2=day7.getAsText();
        System.out.println(dayName2);
    }
}
