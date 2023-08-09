package ThucHanh;

import BaiTap.ConnectJDBC;

import java.sql.*;




public class main {
    public static void main(String[] args) throws SQLException {
        ConnectToJDBC connectToJDBC = new ConnectToJDBC();
        Connection conn = connectToJDBC.connect();
//        selectRecord(conn);
//        addRecord(conn);
//        updateRecord(conn);
//       deleteRecord(conn);
    }
    private static void deleteRecord(Connection conn){
        String query = "DELETE FROM users WHERE id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setInt(1, 5);

            int row = pstm.executeUpdate();
            if(row != 0){
                System.out.println("Xóa thành công " + row);
            }

            //Đóng kết nối
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private static void updateRecord(Connection conn) {
        String query = "UPDATE users SET password = ? WHERE id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setString(1, "bichthuan123");
            pstm.setInt(2, 5);

            int row = pstm.executeUpdate();
            if(row != 0){
                System.out.println("Cập nhật thành công " + row);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void addRecord(Connection conn) throws SQLException {
        String query = "INSERT INTO users(username, password, email) " +
                "VALUES (?,?,?)";

        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);

        pstm.setString(1, "Do Bich Thuan");
        pstm.setString(2, "123456789");
        pstm.setString(3, "thuan.do@codegym.vn");

        int row = pstm.executeUpdate();
        if (row != 0) {
            System.out.println("Thêm thành công ");
        }

        conn.close();


    }

    private static void selectRecord(Connection conn) throws SQLException {
        String query = "SELECT * FROM users";

        Statement stm = null;

        stm = conn.createStatement();

        ResultSet rs = stm.executeQuery(query);

        while (rs.next()) {  //Di chuyển con trỏ xuống bản ghi kế tiếp
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String email = rs.getString("email");
            System.out.println(id + " - " + username + " - " + password + " - " + email);
        }

        conn.close();

    }


}
