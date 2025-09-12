import java.util.ArrayList;

public class WordManager {
    private ArrayList<Word> words;
    private static final int MAX_WORDS = 1000;

    public WordManager(){
        words = new ArrayList<>();
    }

    public boolean addWord(Word word) {
        if (words.size() >= MAX_WORDS) {
            System.out.println("これ以上単語を登録できません。（最大 " + MAX_WORDS + " 単語まで登録可能です）");
            return false;
        }
        words.add(word);
        return true;
    }

    public ArrayList<Word> getWords(){
        return words;
    }

    public int getWordCount(){
        return words.size();
    }

    public int size() {
        return words.size();
    }

    public Word getRandomWord() {
        if (words.isEmpty()) return null;
        int index = (int)(Math.random() * words.size());
        return words.get(index);
    }
}
