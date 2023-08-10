import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private String hostName = "localhost:3306";
    private String dbName = "BaiTapOOP";
    private String username = "root";
    private String password = "5";

    public String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;

    public Connection connect() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionURL, username, password);
        System.out.println("Connected");

        return conn;
    }
}
