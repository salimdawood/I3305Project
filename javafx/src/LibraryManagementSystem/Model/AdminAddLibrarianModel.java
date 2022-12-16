package LibraryManagementSystem.Model;

import LibraryManagementSystem.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminAddLibrarianModel extends TableController {
    ResultSet resultSet;
    DataBase dataBase = DataBase.getInstance();
    PreparedStatement preparedStatement;


    public ObservableList<Librarian> GetLibrarians() {

        ObservableList<Librarian> librarians = FXCollections.observableArrayList();
        Librarian librarian;

        try {
            resultSet = dataBase.getData("SELECT * FROM Librarians");

            while (resultSet.next()) {
                librarian = new Librarian(
                        resultSet.getString(2),
                        resultSet.getString(1),
                        resultSet.getString(3));
                librarians.add(librarian);
            }

            return librarians;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return null;
    }

    public void UpdateLibrarian(Librarian librarian) {

        try {
            preparedStatement = dataBase.getConnection().prepareStatement("UPDATE LIBRARIANS SET fname=? , id=? , phone = ? WHERE fname = ?");
            preparedStatement.setString(2, librarian.getId());
            preparedStatement.setString(1, librarian.getName());
            preparedStatement.setString(3, librarian.getPhone());
            preparedStatement.setString(4, librarian.getName());

            dataBase.modifyData(preparedStatement);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

    public void RemoveLibrarian(Librarian librarian) {
        try {
            preparedStatement = dataBase.getConnection().prepareStatement("DELETE FROM LIBRARIANS WHERE id = ?");
            preparedStatement.setString(1, librarian.getId());

            dataBase.modifyData(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddLibrarian(Librarian librarian) {

        try {
            preparedStatement = dataBase.getConnection().prepareStatement("INSERT INTO LIBRARIANS VALUES ( ? , ? , ?)");
            preparedStatement.setString(1, librarian.getName());
            preparedStatement.setString(2, librarian.getId());
            preparedStatement.setString(3, librarian.getPhone());

            dataBase.modifyData(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
