package LibraryManagementSystem.Model;

import LibraryManagementSystem.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MainSignModel  {
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    DataBase DB = DataBase.getInstance();

    public MainSignModel(String id) throws SQLException {
        preparedStatement = DB.getConnection().prepareStatement("select * from librarians where id=?");
        preparedStatement.setString(1,id);
        resultSet = DB.getData(preparedStatement);
    }
    public boolean checkLibrarian () throws SQLException {
        boolean test = false;
        if (resultSet.next()) {
                test = true;
        }
        return test;
    }


}
