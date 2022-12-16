package LibraryManagementSystem;
import java.sql.*;

public class DataBase {
    public static DataBase dataBase;

    ResultSet resultSet = null;
    Statement statement ;
    String url="";
    String username="";
    String password="";
    private Connection connection;
    private DataBase() {

        try {
            url = "jdbc:mysql://localhost:3307/database";
            username = "root";
            password = "ui1klzx0";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Driver loading failed...");
        }
    }

    public ResultSet getData(String Query) throws SQLException{
        resultSet = statement.executeQuery(Query);
        return resultSet;
    }
    public ResultSet getData(PreparedStatement preparedStatement) throws SQLException{
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public void modifyData(String Query) throws SQLException {
        statement.executeUpdate(Query);
    }
    public void modifyData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.executeUpdate();
    }
    public Connection getConnection(){
        return connection;
    }
    public static DataBase getInstance(){
        if(dataBase==null){
            dataBase = new DataBase();
        }
        return dataBase;
    }

}

