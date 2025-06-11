public class Main8 {
    public static void main(String[] args){
        int attack = 50;
        int denfense = 20;
        int normalDamage = 30;
        double criticalDamage = 1.5 * normalDamage;

        System.out.println("攻撃力を入力してください：" + attack);
        System.out.println("防御力を入力してください：" + denfense);
        System.out.println("通常ダメージ：" + normalDamage);
        System.out.println("クリティカルダメージ：" + (int)criticalDamage);
    }
}
