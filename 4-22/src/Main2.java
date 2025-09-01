import java.io.IOException;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main2 {
    public static void main(String[] args) {
        
        String filePath = "excersise.properties";
        File file = new File(filePath);
        Properties properties = new Properties();

        try {
            if (!file.exists()) {
                try (FileOutputStream output = new FileOutputStream(file)) {
                    properties.setProperty("username", "tanaka");
                    properties.setProperty("password", "12345");
                    properties.store(output, null); 
                }
            }

            try (FileInputStream input = new FileInputStream(filePath)) {
                properties.load(input);
                System.out.println("username=" + properties.getProperty("username"));
                System.out.println("password=" + properties.getProperty("password"));
            } 
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}