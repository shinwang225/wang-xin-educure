package app;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import db.DBManager;

public class VocabularyApp {
    private static final String TABLE_NAME = "words";
    private static final String COL_EN = "english";
    private static final String COL_JA = "japanese";

    private final Scanner sc = new Scanner(System.in);
    private final DBManager dbm = new DBManager();
    private final WordManager wm = new WordManager(dbm);
    private final Quiz quiz = new Quiz(wm);
    private final FileHandler fh = new FileHandler();

    public static void main(String[] args) {

        VocabularyApp app = new VocabularyApp();

        if (args.length > 0 && args[0].equalsIgnoreCase("perf")) {
            try {
                app.runPerfMenu();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        app.start();
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("=== 英単語暗記アプリ ===");
            System.out.println("1: 単語を登録する");
            System.out.println("2: クイズを受ける");
            System.out.println("3: CSVファイルから単語をインポート");
            System.out.println("4: CSVファイルに単語をエクスポート");
            System.out.println("5: 単語を削除する");
            System.out.println("6: 単語を更新する");
            System.out.println("7: 終了する");
            System.out.print("\n番号を選んでください: ");
            String c = sc.nextLine().trim();

            try {
                switch (c) {
                    case "1": registerWord(); break;
                    case "2": startQuiz(); break;
                    case "3": importWords(); break;
                    case "4": exportWords(); break;
                    case "5": deleteWord(); break;
                    case "6": updateWord(); break;
                    case "7": System.out.println("終了します。"); return;
                    default:  System.out.println("1～7を選択してください。");
                }
            } catch (Exception e) {
                System.out.println("エラーが発生しました。詳細は以下をご確認ください。");
                e.printStackTrace();
            }
        }
    }


    private void registerWord() throws Exception {
        System.out.print("英単語を入力してください：\n");
        String en = sc.nextLine();
        System.out.print("日本語訳を入力してください：\n");
        String ja = sc.nextLine();

        WordManager.AddResult res = wm.addWord(new Word(en, ja));
        switch (res) {
            case OK -> {
                int after = wm.getWordCount();
                System.out.println("単語を登録しました。(" + after + " / " + WordManager.MAX_RECORDS + ")");
            }
            case DUPLICATE -> System.out.println("単語はすでに登録されています。");
            case INVALID   -> System.out.println("入力が正しくありません。もう一度入力してください。");
            case LIMIT     -> System.out.println("登録上限（1000件）に達しました。これ以上登録できません。");
        }
    }

    private void startQuiz() throws Exception {
        int total = wm.getWordCount();
        if (total == 0) {
            System.out.println("登録された単語がありません。");
            return;
        }

        System.out.println("=== クイズを開始します ===");
        System.out.println("※ 終了したいときは「q」を入力してください。\n");

        int correct = quiz.run(sc);
        int asked = quiz.getAskedCount();

        System.out.println("\nクイズ終了！");
        System.out.println(asked + "問中" + correct + "問正解でした！");
    }

    private void importWords() throws Exception {
        System.out.print("CSVファイル名を入力してください：\n");
        String path = sc.nextLine();
        var res = fh.importFromCSV(path, wm);
        System.out.println("取り込み結果：登録 " + res.success + " 個 / スキップ " + res.skipped + " 個");
    }

    private void exportWords() throws Exception {
        System.out.print("\nCSVファイル名を入力してください：\n");
        String path = sc.nextLine();
        List<Word> words = wm.getWords();
        int n = fh.exportToCSV(words, path);
        System.out.println(n + "個の単語を保存しました。");
        System.out.println("保存先：" + path);
    }

    private void deleteWord() throws Exception {
        System.out.print("削除する英単語を入力してください：\n");
        String target = sc.nextLine();
        int cnt = wm.deleteWord(target);
        System.out.println(cnt > 0 ? "単語を削除しました。" : "対象の単語が見つかりません。");
    }

    private void updateWord() throws Exception {
        System.out.print("更新する英単語を入力してください：\n");
        String target = sc.nextLine();
        System.out.print("新しい日本語訳を入力してください：\n");
        String newJa = sc.nextLine();
        int cnt = wm.updateWord(target, newJa);
        System.out.println(cnt > 0 ? "単語を更新しました。" : "対象の単語が見つかりません。");
    }


    private void runPerfMenu() throws Exception {
        System.out.println("\n=== パフォーマンステスト ===");
        System.out.println("a) 4-1 単語登録の応答時間");
        System.out.println("b) 4-2 クイズ出題の応答時間");
        System.out.println("c) 4-3 CSVインポート");
        System.out.println("x) 終了");
        System.out.print("選択してください: ");
        String s = sc.nextLine().trim().toLowerCase();

        switch (s) {
            case "a" -> perfRegisterOne();
            case "b" -> perfQuizOne();
            case "c" -> {
                System.out.print("CSVファイル名を入力してください：\n");
                String path = sc.nextLine();
                perfImportCsv(path);
            }
            case "x" -> { return; }
            default -> System.out.println("a/b/c/x を選択してください。");
        }
    }

    private void perfRegisterOne() throws Exception {
        String w = "perf_" + System.currentTimeMillis();
        measureMs("4-1 単語登録の応答時間", () -> wm.addWord(new Word(w, "テスト用")));
    }

    private void perfQuizOne() throws Exception {
        measureMs("4-2 クイズ出題の応答時間", () -> {
            try (Connection c = dbm.getConnection();
                 Statement st = c.createStatement();
                 var rs = st.executeQuery("SELECT " + COL_EN + "," + COL_JA + " FROM " + TABLE_NAME + " ORDER BY RANDOM() LIMIT 1")) {
                if (rs.next()) {}
            }
        });
    }

    private void perfImportCsv(String csvPath) throws Exception {
        System.out.println("既存データ削除中...");
        clearAllWords();
        measureMs("4-3 CSVインポートの応答時間", () -> {
            fh.importFromCSV(csvPath, wm);
        });
    }

    private void clearAllWords() throws Exception {
        try (Connection conn = dbm.getConnection();
             Statement st = conn.createStatement()) {
            st.execute("TRUNCATE TABLE " + TABLE_NAME + " RESTART IDENTITY CASCADE");
        }
    }

    @FunctionalInterface
    private interface ThrowingRunnable { void run() throws Exception; }

    private static void measureMs(String label, ThrowingRunnable task) throws Exception {
        long t0 = System.nanoTime();
        task.run();
        long ms = (System.nanoTime() - t0) / 1_000_000;
        System.out.printf("%s : %d ms%n", label, ms);
    }
}
