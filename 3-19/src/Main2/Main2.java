package Main2;

public class Main2 {
    public static void main(String[] args) {
       // ここにコードを書いてください
       Student student1 = new Student(1001, "田中太郎");
       Student student2 = new Student(1001, "田中たろう");
       Student student3 = new Student(1002,"佐藤花子");

        if (student1.equals(student2)) {
            System.out.println("同一の学生です");
        } else {
            System.out.println("違う学生です");
        }

         if (student2.equals(student3)) {
            System.out.println("同一の学生です");
        } else {
            System.out.println("違う学生です");
        }

    }
}   