package Main1;

public class Main1 {
    public static void main(String[] args) {

    BankAccount account = new BankAccount(1000);
    System.out.println("現在の残高：" + account.getBalance() + "円");
    account.deposit(2000);
    System.out.println("現在の残高：" + account.getBalance() + "円");
    account.withdraw(1500);
    System.out.println("現在の残高：" + account.getBalance() + "円");
    account.withdraw(5000);

    }
}     
