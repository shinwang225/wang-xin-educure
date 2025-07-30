import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        // 発見したモンスターを管理するHashSet（重複なし）
        HashSet<String>discoveredMonsters = new HashSet<>();

        // 戦闘履歴を管理するArrayList（重複あり）
        ArrayList<String>battleHistory = new ArrayList<>();
        
        // 全モンスターのリスト
        List<String> allMonsters = Arrays.asList("スライム", "ドラゴン", "ゴブリン", "フェニックス", "ユニコーン");
        
        // モンスターとの遭遇をシミュレート
        // 戦闘履歴を記録
        addBattles(battleHistory, "スライム", 5);
        addBattles(battleHistory, "ドラゴン", 2);
        addBattles(battleHistory, "ゴブリン", 2);
        
        // 発見済みモンスターを表示
        for (String monster : battleHistory) {
            discoveredMonsters.add(monster);
        }
        System.out.println("発見済みモンスター: " + discoveredMonsters);
        System.out.println("発見済みモンスター数: " + discoveredMonsters.size());

        // スライムとの戦闘回数を計算
        String targetMonster = "スライム";
        int count = 0;
        for (String m : battleHistory) {
            if (m.equals(targetMonster)) {
                count++;
            }
        }
        System.out.println(targetMonster + "との戦闘回数: " + count);

        // 未発見のモンスターを計算
        ArrayList<String> undiscovered = new ArrayList<>();
        for (String name : allMonsters) {
            if (!discoveredMonsters.contains(name)) {
                undiscovered.add(name);
            }
        }
        System.out.println("未発見のモンスター: " + undiscovered);
    }

    public static void addBattles(ArrayList<String> list, String monster, int times) {
        for (int i = 0; i < times; i++) {
            list.add(monster);
        }
    }
}
