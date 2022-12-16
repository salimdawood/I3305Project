package LibraryManagementSystem.Model;

import LibraryManagementSystem.Book;
import LibraryManagementSystem.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSearchBookModel {
    private DataBase database = DataBase.getInstance() ;

    public ObservableList<Book> GetBook(){
        ObservableList<Book> books = FXCollections.observableArrayList();
        Book book ;

        try {
            String query = "Select * from book";
            ResultSet resultSet = database.getData(query);
            while( resultSet.next()){

                book = new Book(
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getString(3),
                        resultSet.getString(7),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getInt(1)
                );
                books.add(book);
            }

            return books ;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return null ;
    }


    public ObservableList<Book> GetBookByGenre(String name){
        ObservableList<Book> books = FXCollections.observableArrayList();
        Book book ;

        try {
            PreparedStatement preparedStatement = database.getConnection().prepareStatement("Select * from book where genre=?");
            preparedStatement.setString(1,name);
            ResultSet resultSet = database.getData(preparedStatement);
            while( resultSet.next()){

                book = new Book(
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getString(3),
                        resultSet.getString(7),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getInt(1)
                );
                books.add(book);
            }

            return books ;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return null ;
    }
    public ObservableList<Book> GetBookByTitle(String name){
        ObservableList<Book> books = FXCollections.observableArrayList();
        Book book ;

        try {
            PreparedStatement preparedStatement = database.getConnection().prepareStatement("Select * from book where title=?");
            preparedStatement.setString(1,name);
            ResultSet resultSet = database.getData(preparedStatement);
            while( resultSet.next()){

                book = new Book(
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getString(3),
                        resultSet.getString(7),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getInt(1)
                );
                books.add(book);
            }

            return books ;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return null ;
    }
}
