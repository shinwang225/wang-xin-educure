import java.util.HashMap;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        // 商品名と在庫数を管理するHashMapを作成
        Map<String,Integer>stock = new HashMap<>();
        
        // 商品を入荷（在庫を追加）
        stock.put("おにぎり", 15);
        stock.put("サンドイッチ",8);
        stock.put("お弁当", 5);
        
        // 現在の在庫状況を表示
        System.out.println("在庫状況: " + stock);
        
        // おにぎりを1個販売
        int sellCount = 1;
        int currentStock = stock.get("おにぎり");
        stock.put("おにぎり", currentStock - sellCount);
        System.out.println("おにぎりを" + sellCount + "個販売しました");

        // 更新後の在庫状況を表示
        System.out.println("在庫状況: " + stock);
        
        // アイスクリームの在庫確認
        String item = "アイスクリーム";

        if (!stock.containsKey(item)) {
        // 取り扱ってない商品
            System.out.println(item + "は在庫がありますか？: false");
        } else {
        // 取り扱っている商品に在庫確認
            int quantity = stock.get(item);
            if (quantity > 0) {
                System.out.println(item + "は在庫がありますか？: true");
            } else {
                System.out.println(item + "は在庫がありますか？: false");
            }
        }
    }
} 
