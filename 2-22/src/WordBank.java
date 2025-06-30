import java.util.Scanner;

public class WordBank {
    
    String[] englishWord = new String[20];
    String[] japaneseWord = new String[20];
    int count = 0;

    public void addWord(Scanner scanner) {
        if (count >= 20) {
            System.out.println("エラー!登録可能の単語は20個までです。");
            return;
        }

        System.out.println("英単語を入力してください：");
        String english = scanner.nextLine();

        System.out.println("日本語訳を入力してください：");
        String japanese = scanner.nextLine();
        
        englishWord[count] = english;
        japaneseWord[count] = japanese;
        count++;

        System.out.println("単語が正しく保存されます!");
        System.out.println(count + "個単語が登録しました。");

    }
}