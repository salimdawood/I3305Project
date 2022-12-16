package LibraryManagementSystem.Model;

import LibraryManagementSystem.Barrow;
import LibraryManagementSystem.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibrarianBarrowBookModel {
    private DataBase dataBase = DataBase.getInstance();
    private PreparedStatement preparedStatement;
    private  ResultSet resultSet;
    public ObservableList<Barrow> GetBarrow(){
        ObservableList<Barrow> barrows = FXCollections.observableArrayList();
        Barrow barrow ;

        try {

            resultSet = dataBase.getData("SELECT * FROM user_has_book;");
            while(resultSet.next()){

                barrow = new Barrow(
                        resultSet.getInt(2),
                        resultSet.getInt(1),
                        resultSet.getString(3)
                );
                barrows.add(barrow);
            }

            return barrows ;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null ;
    }

    public void AddBarrow(Barrow barrow){

        try {
            preparedStatement = dataBase
                    .getConnection()
                    .prepareStatement("INSERT INTO user_has_book(user_id,book_id) VALUES (? , ?); ");

            preparedStatement.setInt(1, barrow.getUser_id());
            preparedStatement.setInt(2, barrow.getBook_id());

            dataBase.modifyData(preparedStatement);


        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void RemoveBarrow(Barrow barrow){
        try {
            preparedStatement = dataBase
                    .getConnection()
                    .prepareStatement("DELETE FROM user_has_book WHERE user_id = ? and book_id = ? ;");

            preparedStatement.setInt(1, barrow.getUser_id());
            preparedStatement.setInt(2, barrow.getBook_id());

            dataBase.modifyData(preparedStatement);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
