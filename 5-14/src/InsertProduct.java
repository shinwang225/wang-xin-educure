import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertProduct {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/educure_db"; 
        String user = "postgres"; 
        String password = "CYV94XpcfV"; 
        
        String insertSQL = "INSERT INTO products (product_name, price, stock) VALUES (?, ?, ?)";
        
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(url, user, password); 
            pstmt = con.prepareStatement(insertSQL); 

            pstmt.setString(1, "スマートフォン");
            pstmt.setInt(2, 80000);
            pstmt.setInt(3, 30);

            int r = pstmt.executeUpdate();

            if (r > 0) {
                System.out.println("商品が正常に追加されました。");
            } else {
                System.out.println("商品の追加に失敗しました。");
            }

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
            try { if (con != null)   con.close();   } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
    }
}