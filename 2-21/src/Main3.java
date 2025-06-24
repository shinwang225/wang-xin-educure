public class Main3 {
    public static void showCurrentTime() {
        // ここにコードを書いてください
       java.util.Date now = new java.util.Date(); 
        System.out.println("現在の日時: " + now.toString());
    }

    public static void main(String[] args) {
        showCurrentTime();
    }
}