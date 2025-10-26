import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStock {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/educure_db"; // データベースURL
        String user = "your_username"; // データベースのユーザー名
        String password = "your_password"; // データベースのパスワード

        
        String checkStockSQL = "SELECT COUNT(*) FROM products WHERE stock > 0";
        String updateSQL = "UPDATE products SET stock = CASE WHEN stock >= 10 THEN stock - 10 ELSE 0 END";

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps1 = con.prepareStatement(checkStockSQL);
            ResultSet rs = ps1.executeQuery();

            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);   // `stock > 0` の件数
            }
            rs.close();
            ps1.close();

            if (count == 0) {
                System.out.println("更新対象の在庫がありません。（全て在庫0）");
                return; 
            }

            PreparedStatement ps2 = con.prepareStatement(updateSQL);
            int updatedRows = ps2.executeUpdate();
            System.out.println("在庫数を更新しました。更新行数: " + updatedRows);
            ps2.close();

        } catch (SQLException e) {
            System.out.println("在庫更新でエラーが発生しました。");
            e.printStackTrace();
        } finally {
            if (con != null) {
                try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }
}
