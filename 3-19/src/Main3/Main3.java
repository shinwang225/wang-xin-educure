package Main3;

import static Main3.Library.*;

public class Main3 {
    public static void main(String[] args) {
    
       System.out.println("貸出可能な本: " + getAvailableBooks() + "冊");

       borrowBook(1);
       System.out.println("貸出可能な本: " + getAvailableBooks() + "冊");

       returnBook();
       System.out.println("貸出可能な本: " + getAvailableBooks() + "冊");

    }
}  