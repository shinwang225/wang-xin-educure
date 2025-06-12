import java.util.Scanner;  
public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("攻撃力を入力してください：");
        String attack = scanner.nextLine(); 
        int attackValue = Integer.parseInt(attack);

        System.out.println("防御力を入力してください：");
        String denfense = scanner.nextLine(); 
        int denfenseValue = Integer.parseInt(denfense);

        int normalDamage = attackValue - denfenseValue;
        double criticalDamage1 = 1.5 * normalDamage;
        int criticalDamage2 = (int)criticalDamage1;
        
        System.out.println("通常ダメージ：" + normalDamage);
        System.out.println("クリティカルダメージ：" + criticalDamage2);

        scanner.close();
    }
}
