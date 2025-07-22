package Main3;

public class Main3 {
    public static void main(String[] args) {
    
        Product p1 = new Product("りんご", 100);

        System.out.println("商品名：" + p1.getName());
        System.out.println("在庫数：" + p1.getStock() + "個");

        p1.removeStock(50);
        System.out.println("商品名：" + p1.getName());
        System.out.println("在庫数：" + p1.getStock() + "個");

        p1.addStock(10);
        System.out.println("商品名：" + p1.getName());
        System.out.println("在庫数：" + p1.getStock() + "個");

        p1.removeStock(120); 

    }
}     