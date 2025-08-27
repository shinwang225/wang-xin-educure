import java.io.FileWriter;
import java.io.IOException;

public class Main1 {
    public static void main(String[] args) {
        
        try(FileWriter writer = new FileWriter("exercise.txt")){
            writer.write("Hello, World!");
            System.out.println("ファイルに書き込みが完了しました。");
        }catch(IOException exception){
            System.out.println("ファイルの書き込み中にエラーが発生しました。");
            exception.printStackTrace();
        }
    }
}
