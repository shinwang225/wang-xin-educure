package Main3;

public class ScoreOverflowException extends GameScoreException {
    
     public ScoreOverflowException(int score) {
        super("Score cannot exceed 100", score);
    }
}