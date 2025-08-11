package Main3;

public class Main3 {
    public static void main(String[] args) {
        ScoreManager manager = new ScoreManager();
        
        System.out.println("得点: 50");
        try {
            manager.validateScore(50);
            System.out.println("OK");
        } catch (GameScoreException e) {
            System.out.println("エラー: " + e.getMessage() + " (" + e.getScore() + ")");
        }
        
        System.out.println("\n得点: -10");
        try {
            manager.validateScore(-10);
            System.out.println("OK");
        } catch (GameScoreException e) {
            System.out.println("エラー: " + e.getMessage() + " (" + e.getScore() + ")");
        }
        
        System.out.println("\n得点: 150");
        try {
            manager.validateScore(150);
            System.out.println("OK");
        } catch (GameScoreException e) {
            System.out.println("エラー: " + e.getMessage() + " (" + e.getScore() + ")");
        }
    }
}
