import java.util.Scanner;

public class Quiz {
    public static void runQuiz(WordBank wordBank, Scanner scanner){
        if (wordBank.count == 0) {
        System.out.println("単語が登録されていません");
        return;
        }

        int correctAnswer = 0;
        
        for(int i = 0; i < wordBank.count; i++){
            String question = wordBank.englishWord[i];
            String answer = wordBank.japaneseWord[i];

            System.out.println(question + "の意味は？");
            String userAnswer = scanner.nextLine();

            if(userAnswer.equals(answer)){
                System.out.println("正解です！");
                correctAnswer++;
            }else {
                System.out.println("不正解です！");
            }
        System.out.println();
        }
    
    System.out.println("クイズ終了！");
    System.out.println(wordBank.count + "問中" + correctAnswer + "問正解でした！");

    }
}
