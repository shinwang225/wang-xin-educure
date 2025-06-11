public class Main3 {
    public static void main(String[] args){
        int attack = 15;
        int defense = 5;
        int damage = (attack * 2 - defense)/3;
         /*ダメージ =（攻撃力 × 2 − 防御力） ÷ 3
        整数同士の除算は小数点以下が切り捨てられる（例：25 / 3 = 8）*/

        System.out.println("与えるダメージ：" + damage);
    }
}
