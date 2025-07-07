public class Main2 {
    public static void main(String[] args) {
    
        Book book = new Book();
        book.setTitle("「Java入門」");

        System.out.println(book.getTitle()+"を登録しました");

        book.lend();
        book.lend();
        book.returnBook();
        book.lend();
        
    }
}
