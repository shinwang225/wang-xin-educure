package Main6;
public class Account {
    int accountNumber;
    int balance;

    public Account(int accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void deposit(int amount){
        this.balance += amount;
        System.out.println("残高：" + balance + "円");
    }

    public void withdraw(int amount){
        this.balance -= amount;
        System.out.println("出金後残高：" + balance + "円");
    }
}
