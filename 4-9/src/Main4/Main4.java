package Main4;

public class Main4 {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();

            try {
                sm.addStudent("アリス");
                sm.addStudent("ボブ");
                sm.addStudent("チャーリー");
                sm.addStudent(null);
                sm.addStudent("イヴ");

            //６人目の学生を追加
            try {
                sm.addStudent("フランク");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // 学生ID 2の学生を表示
            try {
                System.out.println("学生ID 2: " + sm.getStudent(2));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // 学生ID 3の学生を表示
            try {
                System.out.println("学生ID 3: " + sm.getStudent(3));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // 学生ID 10の学生を表示
            try {
                System.out.println("学生ID 10: " + sm.getStudent(10));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // 更新ID 0 and 1
            try {
                sm.updateStudent(0, "フランク");
                sm.updateStudent(1, "ボビー");
                System.out.println("更新後の学生ID 1: " + sm.getStudent(1));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // 更新ID 10
            try {
                sm.updateStudent(10, "田中");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("予期しないエラー: " + e.getMessage());
        }
    }
}

