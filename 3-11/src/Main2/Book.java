package Main2;

import Main1.Product;

public class Book extends Product{
    protected String author;
    protected int stockQuantity;


    public Book(String name, String author, int price, int stockQuantity){
        super(name,price);
        this.author = author;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public void displayInfo() {
        System.out.println("書籍名：" + name);
        System.out.println("著者：" + author);
        System.out.println("価格：" + price + "円");
    }
    
    @Override
    public boolean checkStock(){
        if (stockQuantity >= 1) {
            System.out.println("在庫あり");
            return true;
        }else{
            System.out.println("在庫なし");
            return false;
        }

    }
}
