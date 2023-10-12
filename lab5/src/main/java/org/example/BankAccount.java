package org.example;

import java.text.MessageFormat;

public class BankAccount {

    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount( String accountName, double balance){
        this.accountName = accountName;
        this.balance = balance;
    }

    public double deposit(double amount){
        try{
            if(amount > -1){
                this.balance += amount;
            }
            else {
                throw new NegativeAmountException("Negative amount");
            }
        }
        catch (NegativeAmountException e){
            System.out.println(e.getMessage());
        }
        return this.balance;
    }

    public double withdraw(double amount) {
        try {
            if (amount < 0) {
                throw new NegativeAmountException("Negative amount");
            } else if (amount > balance) {
                throw new InsufficientFundsException("Insufficient funds");
            } else {
                this.balance -= amount;
            }
        } catch (NegativeAmountException e) {
            throw new NegativeAmountException(e.getMessage());
        } catch (InsufficientFundsException e) {
            throw new InsufficientFundsException(e.getMessage());
        }
        return this.balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public String getAccountSummary(){
        return MessageFormat.format("Account number: {0}, Account name: {1}, Balance: " + balance, accountNumber, accountName);
    }

    public void setNumber(int number) {
        this.accountNumber = number;
    }

    public int getNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }
}
