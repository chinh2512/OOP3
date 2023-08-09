package ThucHanh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToJDBC {
    private String hostName = "localhost:3306";
    private String dbName = "demo_jdbc";
    private String username = "root";
    private String password = "5";

    private String connectionURL = "jdbc:mysql://"+hostName+"/"+dbName;

    public Connection connect(){
        //Tạo đối tượng Connection
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

}
