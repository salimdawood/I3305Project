package LibraryManagementSystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class TableController {


    private DataBase database = DataBase.getInstance();
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public ObservableList<User> GetUsers() {
        ObservableList<User> users = FXCollections.observableArrayList();
        User user;

        try {
            resultSet = database.getData("SELECT * FROM USER");
            while (resultSet.next()) {

                user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(5),
                        resultSet.getString(4),
                        resultSet.getString(6),
                        resultSet.getString(7)
                );
                users.add(user);
            }

            return users;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return null;
    }

    public void AddUser(User user) {

        try {
            preparedStatement = database
                    .getConnection()
                    .prepareStatement("INSERT INTO USER(fname,lname,gender,email,phone) VALUES (? , ? , ? , ? , ?) ");

            preparedStatement.setString(1, user.getFname());
            preparedStatement.setString(2, user.getLname());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPhone());

            database.modifyData(preparedStatement);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void UpdateUser(User user) {

        try {
            preparedStatement = database
                    .getConnection()
                    .prepareStatement(
                            "UPDATE USER SET " +
                                    "id = ? , " +
                                    "fname = ? ," +
                                    "lname = ? ," +
                                    "gender = ? ," +
                                    "email = ? ," +
                                    "phone = ? " +
                                    "WHERE id = ? ");

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getFname());
            preparedStatement.setString(3, user.getLname());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setInt(7, user.getId());

            database.modifyData(preparedStatement);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void RemoveUser(User user) {
        try {
            preparedStatement = database
                    .getConnection()
                    .prepareStatement("DELETE FROM USER WHERE id = ?");

            preparedStatement.setInt(1, user.getId());

            database.modifyData(preparedStatement);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public ObservableList<Book> GetBook() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        Book book;

        try {
            resultSet = database.getData("SELECT * FROM BOOK");
            while (resultSet.next()) {

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

            return books;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return null;
    }

    public void AddBook(Book book) {
        try {
            preparedStatement = database
                    .getConnection()
                    .prepareStatement("INSERT INTO BOOK(title,author,genre,publish,copies,location) VALUES (?, ? ,? ,? ,? ,? )");

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setString(4, book.getPublish());
            preparedStatement.setInt(5, book.getCopies());
            preparedStatement.setString(6, book.getLocation());

            database.modifyData(preparedStatement);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void UpdateBook(Book book) {
        try {
            preparedStatement = database
                    .getConnection()
                    .prepareStatement(
                            "UPDATE BOOK SET " +
                                    "id = ? , " +
                                    "title = ? ," +
                                    "author = ? ," +
                                    "genre = ? ," +
                                    "publish = ? ," +
                                    "copies = ? ," +
                                    "location = ? " +
                                    "WHERE id = ? ");

            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getGenre());
            preparedStatement.setString(5, book.getPublish());
            preparedStatement.setInt(6, book.getCopies());
            preparedStatement.setString(7, book.getLocation());
            preparedStatement.setInt(8, book.getId());

            database.modifyData(preparedStatement);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void DeleteBook(Book book) {
        try {
            preparedStatement = database
                    .getConnection()
                    .prepareStatement("DELETE FROM BOOK WHERE id = ?");

            preparedStatement.setInt(1, book.getId());

            database.modifyData(preparedStatement);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }


}
