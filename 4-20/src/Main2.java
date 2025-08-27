import java.io.FileReader;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {
        
        try{
            FileReader reader = new FileReader("exercise.txt");
            int data;
            while((data = reader.read())!=-1){
                System.out.println((char)data);
            }reader.close();
        }catch(IOException exception){
            exception.printStackTrace();
        }
    }
}