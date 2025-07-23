package Main3;

public class Library {
    static int availableBooks = 100;
    
    public static void borrowBook(int amount){
        if (amount <= 0) {
            System.out.println("エラー：1冊以上を指定してください。");
        }else if (availableBooks <= 0) {
            System.out.println("貸出可能の本がありません");
        }else if (availableBooks < amount) {
            System.out.println("貸出可能な本が足りません（残り: " + availableBooks + "冊）");
        }else{
            availableBooks -= amount;
            System.out.println(amount + "冊借りました");
        }
    }

    public static void returnBook(){
        availableBooks ++ ;
        System.out.println("本を返却しました"); 
    }

    public static int getAvailableBooks(){
        return availableBooks;
    }
}
