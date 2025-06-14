public class Main4 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 10;
        //まず三角形が成り立つかどうかを判定する
        if (a + b > c && a + c > b && b + c > a) {

            if (a == b && b == c) {
               System.out.println("正三角形");
            }else if((a == b || b == c || c==a) && 
                     (a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a)){
               System.out.println("二等辺直角三角形");
            }else if(a == b || b == c || c==a) {
               System.out.println("二等辺三角形");
            }else if (a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a) {
               System.out.println("直角三角形");
            }else if (a != b && b != c && a != c) {
               System.out.println("不等辺三角形");
            }
        
        }else{System.out.println("三角形ではない");
        }
    }
}