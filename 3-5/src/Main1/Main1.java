package Main1;

public class Main1 {
    public static void main(String[] args) {
    
        Weapon w = new Weapon();
        w.name = "魔法の剣";
        w.power = 50;
        
        GameCharacter gc = new GameCharacter();
        gc.name = "剣士アレックス";
        gc.hp = 100;
        gc.weapon = w;

        System.out.println(gc.name + "は" + w.name + "を装備しています");
    }
}