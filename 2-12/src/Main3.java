public class Main3 {
    public static void main(String[] args) {
        int height = 5; 

        for(int i = 1; i <= height; i++){

            for(int space = 1 ; space <= height - i; space++){
                System.out.print(" ");
            }

            for(int star = 1; star <= 2 * i- 1; star++){
                System.out.print("*");
            }
        System.out.println();
        }
    }
}