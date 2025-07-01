import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    WordBank wordBank = new WordBank();  

    mainLoop:while (true) {
        System.out.println("1:単語を登録する");
        System.out.println("2:クイズを受ける");
        System.out.println("3:終了する");
        String input = scanner.nextLine();  

        switch (input) {
            case "1":
                wordBank.addWord(scanner);
                break;
            case"2":
                Quiz.runQuiz(wordBank, scanner);
                break;
            case"3":
                break mainLoop;
            default:
                System.out.println("1-3の数字を入力してください");
                break;
        }
    }
    System.out.println("プログラムが終了します");
    }
}
