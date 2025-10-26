import java.sql.*;

public class ProductMaintenance {

    public static void main(String[] args) {
        // データベース接続情報
        String url = "jdbc:postgresql://localhost:5432/educure_db";  // データベースURL
        String username = "your_username";                           // データベースのユーザー名
        String password = "your_password";                           // データベースのパスワード
        // ここにコードを書いてください

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false); 

            // 在庫数0の商品 → 価格を0に
            String sql1 = "UPDATE products SET price = 0 WHERE stock = 0";
            int r1;
            try (PreparedStatement ps = con.prepareStatement(sql1)) {
                r1 = ps.executeUpdate();
            }
            System.out.println("影響を受けた行数（在庫数0の商品を価格0に設定）: " + r1);

            // 価格200000以上の商品を削除
            String sql2 = "DELETE FROM products WHERE price >= 200000";
            int r2;
            try (PreparedStatement ps = con.prepareStatement(sql2)) {
                r2 = ps.executeUpdate();
            }
            System.out.println("影響を受けた行数（価格が200000以上の商品削除）: " + r2);

            // ③ 価格100000以上 かつ 在庫10以下 → 在庫を20に
            String sql3 = "UPDATE products SET stock = 20 WHERE price >= 100000 AND stock <= 10";
            int r3;
            try (PreparedStatement ps = con.prepareStatement(sql3)) {
                r3 = ps.executeUpdate();
            }
            System.out.println("影響を受けた行数（価格100000以上、在庫10以下の商品を在庫20に更新）: " + r3);

            con.commit();

            String selectAll = "SELECT product_id, product_name, price, stock FROM products ORDER BY product_id";
            try (PreparedStatement ps = con.prepareStatement(selectAll);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                        rs.getInt("product_id") + " " +
                        rs.getString("product_name") + " " +
                        rs.getInt("price") + " " +
                        rs.getInt("stock")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("エラーが発生したためロールバックします。");
            if (con != null) {
                try { con.rollback(); } catch (SQLException ignore) {}
            }
            e.printStackTrace();
        } finally {
            if (con != null) {
                try { con.setAutoCommit(true); con.close(); } catch (SQLException ignore) {}
            }
        }
    }
}

