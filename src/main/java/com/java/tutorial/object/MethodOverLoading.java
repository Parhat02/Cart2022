package com.java.tutorial.object;

import org.apache.commons.lang3.StringUtils;

public class MethodOverLoading {
    private int accountId;
    private String accountName;
    private double accountBalance;
    private String accountAddress;

    public MethodOverLoading(int accountId, String accountName, double accountBalance, String accountAddress) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.accountAddress = accountAddress;
    }
    public void printAccountInfo(int accountId){
        System.out.println("Account Id: "+accountId);
    }
    public void printAccountInfo(int accountId, String accountName){
        System.out.println("Account Id: "+accountId);
        System.out.println("Account Name: "+accountName);
    }
    public void printAccountInfo(int accountId, String accountName, double accountBalance){
        System.out.println("Account Id: "+accountId);
        System.out.println("Account Name: "+accountName);
        System.out.println("Account Balance: "+accountBalance);
    }

    public int addTwoNumbers(int i1, int i2){
        int sum=i1+i2;
        System.out.println(i1+"+"+i2+"="+sum);
        return sum;
    }
    //method overloading
    public long addTwoNumbers(long i1, long i2){
        long sum=i1+i2;
        System.out.println(i1+"+"+i2+"="+sum);
        return sum;
    }
    //method overLoading
    public int addTwoNumbers(String i1, String i2){
        if (StringUtils.isNumeric(i1)&StringUtils.isNumeric(i2)){
            int sum=Integer.parseInt(i1)+Integer.parseInt(i2);
            System.out.println(i1+"+"+i2+"="+sum);
            return sum;
        }
        else {
            System.out.println("Please Only Enter Numbers");
            return 0;
        }
    }
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    @Override
    public String toString() {
        return "MethodOverLoading{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountBalance=" + accountBalance +
                ", accountAddress='" + accountAddress + '\'' +
                '}';
    }


    public static void main(String[] args) {
        MethodOverLoading demo=new MethodOverLoading(1234,"user1",100000,"USA");
        demo.printAccountInfo(demo.getAccountId());
        System.out.println();
        demo.printAccountInfo(demo.getAccountId(), demo.getAccountName());
        System.out.println();
        demo.printAccountInfo(demo.getAccountId(), demo.getAccountName(),demo.getAccountBalance());
        demo.printAccountInfo(890);
        demo.printAccountInfo(98765,"user3",19000);
        System.out.println(demo.toString());
        System.out.println(demo.accountId);
    }


}
