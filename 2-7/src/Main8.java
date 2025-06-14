import java.util.Scanner;  
public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("攻撃力を入力してください：");
        int attack = Integer.parseInt(scanner.nextLine());

        System.out.println("防御力を入力してください：");
        int defense = Integer.parseInt(scanner.nextLine());

        int normalDamage = attack - defense;
        int criticalDamage = (int)(normalDamage*1.5);
        
        System.out.println("通常ダメージ：" + normalDamage);
        System.out.println("クリティカルダメージ：" + criticalDamage);

        scanner.close();
    }
}
