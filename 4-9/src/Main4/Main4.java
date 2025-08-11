package Main4;

public class Main4 {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        
        //学生追加
        try {
            sm.addStudent("アリス");
            sm.addStudent("ボブ");
            sm.addStudent("チャーリー");
            sm.addStudent(null);
            sm.addStudent("イヴ");

            //６人目の学生を追加
            sm.addStudent("フランク");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // 学生ID 2の学生を表示
        System.out.println("学生ID 2: " + sm.getStudent(2));

        // 学生ID 3の学生を表示
        try {
            System.out.println("学生ID 3: " + sm.getStudent(3));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("学生ID 3: null");
        }
        
        // 学生ID 10の学生を表示
        try {
            System.out.println("学生ID 10: " + sm.getStudent(10));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("学生ID 10: null");
        }
        
        // 学生IDを更新
        try {
            // 正常な更新
            sm.updateStudent(0, "フランク"); 
            sm.updateStudent(1, "ボビー"); 
            System.out.println("更新後の学生ID 1: " + sm.getStudent(1));
        
            //無効なIDで更新を試みる
            sm.updateStudent(10, "田中");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}