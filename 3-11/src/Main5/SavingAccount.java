package Main5;

import java.util.ArrayList;

public class SavingAccount implements BankAccount{
    private String name;
    private int balance;
    private ArrayList<String> transactionHistory;

    public SavingAccount(String name,int initialBalance){
        this.name = name;
        this.balance = initialBalance;
        transactionHistory = new ArrayList<>();
        transactionHistory.add("口座作成: 初期残高 = " + initialBalance);
    }

    @Override
    public void deposit(int amount){
        balance += amount;
        transactionHistory.add("入金: " + amount);
    }

    @Override
    public void withdraw(int amount){
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("出金: " + amount);
        }else{
            transactionHistory.add("出金: " + amount + " - 出金失敗（残高不足）");
        }
    }

    @Override
    public int getBalance(){
        return balance;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("口座名義人： " + name);
        System.out.println("残高： " + balance);
        System.out.println("取引履歴：");
        for(String record : transactionHistory){
            System.out.println(record);
        }
    }
}
