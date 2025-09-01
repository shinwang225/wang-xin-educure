import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

class Book {
    private String title;
    private String author;
    private int price;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPrice() { return price; }
}

public class Main3 {
    public static void main(String[] args) {
        try{
            File xmlFile = new File("excersise.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            Element root = doc.getDocumentElement();

            String title = root.getElementsByTagName("title").item(0).getTextContent();
            String author = root.getElementsByTagName("author").item(0).getTextContent();
            int price = Integer.parseInt(root.getElementsByTagName("price").item(0).getTextContent());

            Book book = new Book(title, author, price);
            System.out.println("タイトル: " + book.getTitle());
            System.out.println("著者: " + book.getAuthor());
            System.out.println("価格: " + book.getPrice());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}