package Main1;

public class GameItem {
    String itemName;
    int price;

    public GameItem(String itemName, int price){
        this.itemName = itemName;
        this.price = price;
    }

    @Override
    public String toString(){
        return "[" + itemName + "] 価格：" + price + "G";
    }

    
    
}
