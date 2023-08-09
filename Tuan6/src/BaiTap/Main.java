package BaiTap;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.connect();
//        addRecord(connection);
//        UpdateRecord(connectJDBC);
//        deleteRecord(connection);
        showAll(connection);
    }

    private static void showAll(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet =  statement.executeQuery("select * from products");
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+ " - "+resultSet.getString(2)+" - "+resultSet.getDouble(3) + " - "+resultSet.getString(4)+" - "+resultSet.getString(5)+" - "+resultSet.getInt(6)+" - "+resultSet.getBoolean(7));
        }
        connection.close();
    }

    public static void deleteRecord(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from products where name = 'iPhone 7'");
        connection.close();
    }

    private static void UpdateRecord(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        statement.executeUpdate("update products set name = 'iPhone 14' where id = 1");
        connection.close();
    }

    public static void addRecord(Connection connection) throws SQLException {
        String query = "insert into products (name,price,detail,manufacturer,number,status) value (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, "iPhone 7");
        preparedStatement.setDouble(2, 5000000);
        preparedStatement.setString(3, "vien tron");
        preparedStatement.setString(4, "Apple");
        preparedStatement.setInt(5, 10);
        preparedStatement.setBoolean(6, true);
        int row = preparedStatement.executeUpdate();
        if (row != 0) {
            System.out.println("complete");

        }
        connection.close();
    }
}