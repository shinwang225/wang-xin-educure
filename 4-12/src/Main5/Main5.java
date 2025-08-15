package Main5;

public class Main5 {
    public static void main(String[] args) {
        GameCharacter hero = new GameCharacter("勇者A");

        Equipment sword  = new Equipment("伝説の剣", 100, 0);
        Equipment shield = new Equipment("光の盾", 0, 80);
        Equipment boots  = new Equipment("魔法の靴", 10, 20);

        hero.addEquipment(sword);
        hero.addEquipment(shield);
        hero.addEquipment(boots);

        System.out.println("--- キャラクター装備情報 ---");
        System.out.println(hero.getName() + "の装備:");
        hero.showEquipments();

        System.out.println("\n装備の複製テスト: " + (sword.equals(sword.clone()) ? "OK" : "NG"));

        System.out.println("装備の比較テスト: " + (sword.compareTo(shield) < 0 ? "OK" : "NG"));

        hero.sortEquipments();
        System.out.println("装備の強さソート: " + (hero.getEquipments().get(0).equals(sword) ? "OK" : "NG"));
    }
} 
