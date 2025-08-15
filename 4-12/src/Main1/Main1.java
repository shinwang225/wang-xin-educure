package Main1;

public class Main1 {
    public static void main(String[] args) {
        
        System.out.println("アイテム情報:");
        GameItem item1 = new GameItem("回復薬", 100);
        GameItem item2 = new GameItem("魔法の杖", 150);

        System.out.println(item1);
        System.out.println(item2);

    }
}
