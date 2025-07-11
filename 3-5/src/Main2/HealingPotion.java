package Main2;

public class HealingPotion {
    
    public void heal(Player player){
        player.hp += 50;
        System.out.println("回復ポーションを使用しました");
        System.out.println("プレイヤーのHP: " + player.hp);
    }
}
