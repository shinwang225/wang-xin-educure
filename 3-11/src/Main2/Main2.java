package Main2;

public class Main2 {
    public static void main(String[] args) {
        Book book = new Book("Java入門","山田太郎",2500,20);

        book.displayInfo();
        book.checkStock();
    }
}
