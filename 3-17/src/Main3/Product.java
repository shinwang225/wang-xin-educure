package Main3;

public class Product {
    private String name;
    private int stock;

    public Product(String name,int initialStock){
        this.name = name;
        if (initialStock >= 0) {
            this.stock = initialStock;
        }else {
            throw new IllegalArgumentException("初期在庫は0以上で設定してください");
        }
    }

    public String getName(){
        return name;
    }

    public int getStock(){
        return stock;
    }

    public void addStock(int amount){
        stock += amount;
        System.out.println(amount + "個追加しました");
    }

    public void removeStock(int amount){
        if (amount <= 0) {
            System.out.println("エラー：正しい販売数（1個以上）を入力してください");
        } else if (amount > stock) {
            System.out.println("エラー：在庫が不足しています");
        } else {
            stock -= amount;
            System.out.println(amount + "個販売しました");
        }
    }
}
