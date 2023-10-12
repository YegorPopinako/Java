package org.example;



import java.util.ArrayList;
import java.util.List;

public class Bank {

    private static List<BankAccount> accounts = new ArrayList<>();

    public boolean createAccount(String accountName, double initialDeposit) {
        BankAccount account = new BankAccount(accountName, initialDeposit);
        account.setNumber(accounts.size() + 1);
        return accounts.add(account);
    }

    public BankAccount findAccount(int accountNumber) {
        try{
            for (BankAccount account : accounts) {
                if (account.getNumber() == accountNumber) {
                    return account;
                }
            }
            throw new AccountNotFoundException("Account not found!");
        }
        catch (AccountNotFoundException e) {
            throw new AccountNotFoundException(e.getMessage());
        }
    }

    public double transferMoney(int fromAccountNumber, int toAccountNumber, double amount){
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        return amount;
    }
}