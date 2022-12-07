package com.java.tutorial.configutility.classtutorial;

public class BankDemo {
    public static void main(String[] args) {
        BankAccount.setAccountNumber(123456789);
        BankAccount.setAccountName("Ferhat");
        BankAccount.setAccountBalance(1000000);
        BankAccount.getAccountInfo();
        BankAccount.withdrawMoney(200000);
        BankAccount.depositMoney(300000);
        BankAccount.getAccountInfo();

        BankAccount bank1=new BankAccount();
        bank1.welcomeMessage("US Bank");
    }
}
