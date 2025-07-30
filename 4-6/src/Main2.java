import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main2 {
    public static void main(String[] args) {
        // Integer型のArrayListを作成
        // 点数を追加
        ArrayList<Integer>score = new ArrayList<Integer>(Arrays.asList(85, 92, 78, 55, 43));
        
        // 点数リストを表示
        System.out.println("点数リスト: " + score);
        
        // 平均点を計算
        int sum = 0;
        for(int s:score){
            sum += s;
        }
        double average = (double)sum/score.size();
        System.out.println("平均点: " + average);

        // 最高点を取得
        int max = Collections.max(score);
        System.out.println("最高点: " + max);
        
        // 不合格者数（60点以下）を計算
        int failCount = 0;
        for (int s : score) {
            if (s <= 60) {
            failCount++;
            }  
        }
        System.out.println("不合格者数: " + failCount);
    }
}