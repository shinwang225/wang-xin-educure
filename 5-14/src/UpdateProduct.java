import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProduct {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/educure_db"; // データベースURL
        String user = "your_username"; // データベースのユーザー名
        String password = "your_password"; // データベースのパスワード

        String updatePriceSQL = "UPDATE products SET price = price - 5000 WHERE product_name = 'タブレット'";
        String updateStockSQL = "UPDATE products SET stock = stock + 5 WHERE price < 50000";
        // ここにコードを書いてください

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);

            PreparedStatement ps1 = con.prepareStatement(updatePriceSQL);
            int r1 = ps1.executeUpdate();
            System.out.println("価格を値下げした行数: " + r1);
            ps1.close();

            PreparedStatement ps2 = con.prepareStatement(updateStockSQL);
            int r2 = ps2.executeUpdate();
            System.out.println("在庫を増やした行数: " + r2);
            ps2.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}