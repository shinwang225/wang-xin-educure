public class Main8 {
    public static void main(String[] args) {
        int score = 100;  // ここに点数を入力
        int range = score / 10;

        switch (range) {
            case 9:
            case 10:
                System.out.println("A");
                break;    
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
                System.out.println("F");
                break;
        }
    }
}