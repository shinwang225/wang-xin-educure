package Main5;

public class Book {
    String title;
    String author;
    int pages;

    public Book(String title,String author,int pages){
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public Book(String title,String author){
        this.title = title;
        this.author = author;
        this.pages = 0;
    }

    public void displayInfo(int number){
        System.out.println("本" + number + ": " + title + " - " + author + " (" + pages +"ページ)");
    }
}