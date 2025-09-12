import java.util.Scanner;

public class VocabularyApp {
    private WordManager wordManager;
    private Quiz quiz;
    private FileHandler fileHandler;
    private Scanner scanner;

    public VocabularyApp() {
        wordManager = new WordManager();
        quiz = new Quiz(wordManager);
        fileHandler = new FileHandler();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    registerWord();
                    break;
                case 2:
                    startQuiz();
                    break;
                case 3:
                    importWords();
                    break;
                case 4:
                    exportWords();
                    break;
                case 5:
                    System.out.println("アプリを終了します。");
                    return;
                default:
                    System.out.println("1〜5の数字を入力してください。");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n=== 英単語暗記アプリ ===");
        System.out.println("1: 単語を登録する");
        System.out.println("2: クイズを受ける");
        System.out.println("3: CSVファイルから単語をインポート");
        System.out.println("4: CSVファイルに単語をエクスポート");
        System.out.println("5: 終了する");
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void registerWord() {
        if (wordManager.getWordCount() >= 1000) {
            System.out.println("単語数が上限に達しました（1000語）。新しい単語は登録できません。");
            return;
        }

        System.out.print("英単語を入力してください: ");
        String english = scanner.nextLine().trim();
        System.out.print("日本語訳を入力してください: ");
        String japanese = scanner.nextLine().trim();

        if (english.isEmpty() || japanese.isEmpty()) {
        System.out.println("エラー: 空の情報は入力できません。");
        return;
    }

        Word word = new Word(english, japanese);
        wordManager.addWord(word);
        System.out.println("単語を登録しました。");
    }

    private void startQuiz() {
        if (wordManager.getWordCount() == 0) {
            System.out.println("登録された単語がありません。");
            return;
        }

        System.out.println("=== クイズを開始します ===");
        System.out.println("途中で終了したい場合は '終了' を入力してください。");

        int questionNumber = 1; 

        for (Word word : wordManager.getWords()) {
            System.out.println("問題" + questionNumber + ": " + word.getEnglish() + " の意味は？");
            String answer = scanner.nextLine();

            if (answer.equals("終了")) {
                System.out.println("クイズを中断しました。");
                break;
            }

            if (quiz.checkAnswer(word, answer)) {
                System.out.println("正解です！");
            } else {
                System.out.println("不正解です。正解は " + word.getJapanese() + " でした。");
            }

            questionNumber++;
        }

        System.out.println("=== クイズ終了！ ===");
        System.out.println(quiz.getTotalQuestions() + "問中" + quiz.getScore() + "問正解でした！");
    }


    private void importWords() {
        System.out.print("CSVファイル名を入力してください: ");
        String filename = scanner.nextLine();
        fileHandler.importFromCSV(filename, wordManager);
    }

    private void exportWords() {
        System.out.print("CSVファイル名を入力してください: ");
        String filename = scanner.nextLine();
        fileHandler.exportToCSV(wordManager.getWords(), filename);
    }

    public static void main(String[] args) {
        VocabularyApp app = new VocabularyApp();
        app.start();
    }
}
