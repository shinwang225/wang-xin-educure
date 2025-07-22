package Main2;

public class Main2 {
    public static void main(String[] args) {
       // ここにコードを書いてください
    Student s1 = new Student();

    try {
            s1.setName("田中太郎");
            s1.setScore(85);
            System.out.println(s1.getName() + "さんの点数：" + s1.getScore() + "点");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            s1.setScore(990);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            s1.setName("");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}