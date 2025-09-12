public class PerformanceTest {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();

        // テスト4-1 単語登録の応答時間
        WordManager wordManager1 = new WordManager();
        measure("単語登録の応答時間", () -> {
            wordManager1.addWord(new Word("apple", "りんご"));
        });

        // テスト4-2 クイズ出題の応答時間（100単語登録済み）
        WordManager wordManager2 = new WordManager();
        for (int i = 0; i < 100; i++) {
            wordManager2.addWord(new Word("word" + i, "意味" + i));
        }
            measure("クイズ出題の応答時間", () -> {
            wordManager2.getRandomWord();
        });

        // テスト4-3 CSVインポートの応答時間（1000単語）
        WordManager wordManager3 = new WordManager();
        measure("CSVインポートの応答時間", () -> {
            fileHandler.importFromCSV("words1000.csv", wordManager3);
        });

        // テスト4-4 大量データ登録可否（1000単語）
        WordManager wordManager4 = new WordManager();
        measure("大量データ登録", () -> {
            fileHandler.importFromCSV("words1000.csv", wordManager4);
            if (wordManager4.getWords().size() == 1000) {
                System.out.println(" → OK (1000単語登録成功)");
            } else {
                System.out.println(" → NG (登録数: " + wordManager4.getWords().size() + ")");
            }
        });

        // テスト4-5 大量データでのクイズ実行（1000単語登録済み）
        WordManager wordManager5 = new WordManager();
        fileHandler.importFromCSV("words1000.csv", wordManager5);
        measure("大量データでのクイズ実行", () -> {
            wordManager5.getRandomWord();
        });
    }

    // 処理時間測定
    private static void measure(String label, Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("[" + label + "] " + elapsed + " ms");
        if (elapsed <= 1000) {
            System.out.println(" → OK (1秒以内)\n");
        } else {
            System.out.println(" → NG (遅い: " + elapsed + " ms)\n");
        }
    }
}
