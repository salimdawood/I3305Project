package LibraryManagementSystem.Model;

import LibraryManagementSystem.DataBase;
import LibraryManagementSystem.Problem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminProblemsModel  {
    private DataBase database = DataBase.getInstance() ;

    public ObservableList<Problem> GetProblem(){
        ObservableList<Problem> problems = FXCollections.observableArrayList();
        Problem problem ;
        try {
            ResultSet resultSet = database.getData("SELECT * FROM suggestion");
            while (resultSet.next()){
                problem = new Problem(resultSet.getString(1));
                problems.add(problem);
            }
            return problems ;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return null ;
    }
    public void DeleteProblem(Problem problem) {
        try {
            PreparedStatement preparedStatement = database
                    .getConnection()
                    .prepareStatement("DELETE FROM suggestion WHERE problem = ?");

            preparedStatement.setString(1, problem.getProblem());

            database.modifyData(preparedStatement);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
