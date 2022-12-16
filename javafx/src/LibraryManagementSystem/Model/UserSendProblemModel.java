package LibraryManagementSystem.Model;

import LibraryManagementSystem.DataBase;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserSendProblemModel {

    public  UserSendProblemModel(String problem) throws SQLException {
        DataBase dataBase = DataBase.getInstance();
        PreparedStatement preparedStatement = dataBase.getConnection().prepareStatement("insert into suggestion values(?)");
        preparedStatement.setString(1,problem);
        dataBase.modifyData(preparedStatement);
    }
}
