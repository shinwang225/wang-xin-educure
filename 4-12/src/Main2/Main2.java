package Main2;

public class Main2 {
    public static void main(String[] args) {
        Monster monster1 = new Monster("スライム", 5);
        Monster monster2 = new Monster("スライム", 5);
        Monster monster3 = new Monster("スライム", 10);

        printCompare(monster1, monster2);
        printCompare(monster1, monster3);
    }

    private static void printCompare(Monster a, Monster b) {
        if (a.equals(b)) {
            System.out.println(a + " と " + b + " は同じモンスターです");
        } else {
            System.out.println(a + " と " + b + " は違うモンスターです");
        }
    }
}
