package app;

import java.util.*;

public class Quiz {
    private final WordManager wm;
    private int askedCount = 0;

    public Quiz(WordManager wm) { this.wm = wm; }

    public int getAskedCount() { return askedCount; } 

    public int run(Scanner sc) throws Exception {
        List<Word> words = wm.getWords();
        Collections.shuffle(words); 
        int correct = 0;
        askedCount = 0;

        for (Word w : words) {
            System.out.println(w.getEnglish() + " の意味は？");
            String ans = sc.nextLine().trim();

            if (ans.equalsIgnoreCase("q")) {
                break;
            }

            askedCount++;

            if (ans.equals(w.getJapanese())) {
                System.out.println("正解です！\n");
                correct++;
            } else {
                System.out.println("不正解です。正解は" + w.getJapanese() + "でした。\n");
            }
        }

        return correct;
    }
}