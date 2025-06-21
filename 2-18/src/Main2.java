public class Main2 {
    public static void main(String[] args) {
        int score = 85;  // 学生の得点
        
        String result = studentScore(score);

        System.out.println("得点: " + score);
        System.out.println("成績: " + result);
    }

    public static String studentScore(int score){
        if (score >= 80) {
            return"優";
        }else if (score >=70 && score < 80) {
            return"良";
        }else if (score >=60 && score < 70) {
            return"可";
        }else{return"不可";
        }
    }
}