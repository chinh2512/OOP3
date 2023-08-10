import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConnectJDBC connect = new ConnectJDBC();
        connect.connect();
    }

}