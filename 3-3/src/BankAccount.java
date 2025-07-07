public class BankAccount {
    int balance;

    public int getBalance(){
        return this.balance;
    }

    public void deposit(int amount){
        this.balance += amount;
        System.out.println(amount + "円預けました");
    }

    public void withdraw(int amount){
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println(amount + "円引き出しました");
        } else {
            System.out.println("残高が不足しています");
        }
    }
}
