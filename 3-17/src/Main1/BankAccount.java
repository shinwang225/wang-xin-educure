package Main1;

public class BankAccount {
    private int balance;
    
    public BankAccount(int initialBalance){
        this.balance = initialBalance;
    }

    public int getBalance(){
        return balance;
    }

    public void deposit(int amount){
        if (amount <= 0) {
            System.out.println("エラー! 入金額は1円以上を入力してください。");
        } else {
            balance += amount;
            System.out.println(amount + "円入金しました");
        }
    }

    public void withdraw(int amount){
        if (amount > balance) {
            System.out.println("引き出しに失敗しました。残高が不足しています。");
        }else if(amount <= 0){
            System.out.println("エラー! 0以下の金額は引き出せません。");
        }else{
            balance -= amount;
            System.out.println(amount + "円引き出しました");
        }
       
    }
}
