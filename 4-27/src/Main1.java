import java.io.*;
import java.net.*;

public class Main1 {
    public static void main(String[] args) throws IOException {
        String keyword = "Java";
        
        String searchURL = "https://www.google.com/search?q=" + URLEncoder.encode(keyword, "UTF-8");
        
        URL url = new URL(searchURL);
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is,"UTF-8");

        int i = isr.read();
        while(i != -1){
            System.out.print((char)i);
            i = isr.read();
        }
        isr.close();
        is.close();
        
    }
}