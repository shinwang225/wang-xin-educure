package Main4;

public class Main4 {
    public static void main(String[] args) {
       
       Book book1 = new Book("Java入門");
       Library library = new Library();

       library.lendBook(book1);  
       library.lendBook(book1); 
       library.returnBook(book1); 
       library.lendBook(book1);   
    }
}  
