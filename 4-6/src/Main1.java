import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {
        // 学生の名簿を管理するArrayListを作成
        ArrayList<String>students = new ArrayList<String>();
        
        // 学生を追加
        students.add("田中");
        students.add("佐藤");
        students.add("鈴木");

        // 学生リストを表示
        System.out.println("学生リスト: " + students);
        
        // 2番目の学生を取得（インデックスは0から始まるので1を指定）
        int index = 1; 
        System.out.println((index + 1)+ "番目の学生: " + students.get(index));
        
        // 学生数を取得
        System.out.println("学生数: " + students.size());

        // 特定の学生が含まれているか確認
        String nameCheck = "鈴木";
        System.out.println(nameCheck + "さんは含まれていますか？: " + students.contains(nameCheck));
    }
}




