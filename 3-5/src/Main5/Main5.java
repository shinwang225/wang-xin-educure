package Main5;

public class Main5 {
    public static void main(String[] args) {
        Book book1 = new Book("Java入門", "山田太郎");
        Book book2 = new Book("Python実践","鈴木次郎",300);

        book1.displayInfo(1);
        book2.displayInfo(2);
    }
}
