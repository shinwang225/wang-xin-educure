public class Main3 {
    public static void main(String[] args) {
        int month = 4;

        if (month <= 5 && month >= 3) {
            System.out.println("春");
        }else if (month <= 8 && month >= 6) {
            System.out.println("夏");
        }else if(month <= 11 && month >= 9) {
            System.out.println("秋");
        }else if(month == 12 || month  == 1 || month == 2) {
            System.out.println("冬");
        }else{System.out.println("無効な月です");}     
    }  
}