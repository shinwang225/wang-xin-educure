package Main6;

public class Main6 {
    public static void main(String[] args) {
        
        Account account = new Account(12345);
        System.out.println("口座番号：" + account.accountNumber);

        account.deposit(1000);
        account.withdraw(500);

    }
}