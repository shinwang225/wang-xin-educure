public class Main6 {
    public static void main(String[] args){
        String currentExp1 ="1000";
        int currentExp2 = Integer.parseInt(currentExp1);
        int bounsExp = currentExp2 * 25 /100;

        System.out.println("現在の経験値を入力してください：" + currentExp2);
        System.out.println("ボーナス後の経験値：" + (currentExp2 + bounsExp) );
    }    
}
