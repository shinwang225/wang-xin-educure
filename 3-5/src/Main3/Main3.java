package Main3;

public class Main3 {
    public static void main(String[] args) {
        
        BankAccount account1 = new BankAccount();
        account1.balance = 5000;

        BankAccount account2 = account1;
        account1.withdraw();

        System.out.println("口座1の残高: " + account1.balance);
        System.out.println("口座2の残高: " + account2.balance);

    }
}
