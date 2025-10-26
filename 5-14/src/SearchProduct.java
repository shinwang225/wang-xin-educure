import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchProduct {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/educure_db"; // データベースURL
        String user = "postgres"; 
        String password = "CYV94XpcfV"; 
        
        String query = "SELECT product_name, price FROM products WHERE price >= ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(query)) {

            
            ps.setInt(1, 100000);

            try (ResultSet rs = ps.executeQuery()) {
                boolean any = false;
                while (rs.next()) {
                    any = true;
                    String name = rs.getString("product_name");
                    int price = rs.getInt("price");
                    System.out.printf("商品名：%s、価格：%d%n", name, price);
                }
                if (!any) {
                    System.out.println("条件に合致する商品はありません。");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
