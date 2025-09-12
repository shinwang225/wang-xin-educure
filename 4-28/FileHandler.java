import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandler {
    public void exportToCSV(List<Word>words,String filename){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for(Word word : words){
                writer.write(word.getEnglish()+ "," + word.getJapanese());
                writer.newLine();
            }
            System.out.println("単語をCSVファイルに保存しました: " + filename);
        }catch(IOException e){
            System.out.println("CSVファイルへの保存中にエラーが発生しました。");
            e.printStackTrace();
        }
    }

    public void importFromCSV(String filename, WordManager wordManager) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;
            boolean invalidFormat = false; 

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
            if (parts.length != 2) {
                invalidFormat = true;
                break; 
            }
            String english = parts[0].trim();
            String japanese = parts[1].trim();
            wordManager.addWord(new Word(english, japanese));
            count++;
            }

            if (invalidFormat) {
                System.out.println("エラー: CSVファイルの形式が正しくありません: " + filename);
            } else {
                System.out.println(count + "個の単語を読み込みました: " + filename);
            }
        } catch (IOException e) {
            System.out.println("エラー: ファイルを読み込めませんでした: " + filename);
        }
    }
}