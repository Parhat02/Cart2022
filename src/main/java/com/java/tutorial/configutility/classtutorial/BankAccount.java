package com.java.tutorial.configutility.classtutorial;

public class BankAccount {
    private static int accountNumber;
    private static String accountName;
    private static double accountBalance;

    public static void setAccountNumber(int accountNumber) {
        BankAccount.accountNumber = accountNumber;
    }

    public static void setAccountName(String accountName) {
        BankAccount.accountName = accountName;
    }

    public static void setAccountBalance(double accountBalance) {
        BankAccount.accountBalance = accountBalance;
    }

    //get bank account information
    public static void getAccountInfo(){
        System.out.println(accountNumber);
        System.out.println(accountName);
        System.out.println(accountBalance);
    }
    //withdraw money
    public static double withdrawMoney(double withdrawAmount){
        if (withdrawAmount<=accountBalance){
            accountBalance=accountBalance-withdrawAmount;
            System.out.println("Your current balance: "+accountBalance);
            return accountBalance;
        }else{
            System.out.println("You cannot withdraw more than your account balance");
            System.out.println("Your balance : "+accountBalance);
            return accountBalance;
        }
    }
    //deposit money
    public static double depositMoney(double depositAmount){
        accountBalance=accountBalance+depositAmount;
        System.out.println("Your current account balance: "+accountBalance);
        return accountBalance;
    }
    //none static method
    public void welcomeMessage(String bankName){
        System.out.println("Welcome to : "+bankName);
    }
}
