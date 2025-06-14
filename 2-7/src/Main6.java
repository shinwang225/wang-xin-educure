import java.util.Scanner;  
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("現在の経験値を入力してください：");
        String exp = scanner.nextLine();
        int currentExp = Integer.parseInt(exp);

        int bonusExp = (int)(currentExp*1.25);
        
        System.out.println("ボーナス後の経験値：" + bonusExp);
        scanner.close();
    }    
}
