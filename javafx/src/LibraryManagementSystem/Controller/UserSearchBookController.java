package LibraryManagementSystem.Controller;

import LibraryManagementSystem.Book;
import LibraryManagementSystem.Model.UserSearchBookModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserSearchBookController {

    @FXML
    public TextField text_search;
    @FXML
    private TableColumn<Book, Integer> col_id , col_available ;
    @FXML
    private TableColumn<Book, String> col_title ,col_author , col_genre , col_location , col_publishTime ;
    @FXML
    public TableView<Book> tbl_books;

    private UserSearchBookModel userSearchBookModel = new UserSearchBookModel();


    public void searchGenre() {
        ObservableList<Book> books = userSearchBookModel.GetBookByGenre(text_search.getText());

        //initializing the table adn the table columns
        col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        col_location.setCellValueFactory(new PropertyValueFactory<>("location"));
        col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_publishTime.setCellValueFactory(new PropertyValueFactory<>("publish"));
        col_available.setCellValueFactory(new PropertyValueFactory<>("Copies"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        tbl_books.setItems(books);
    }

    public void searchAll() {
        ObservableList<Book> books = userSearchBookModel.GetBook();

        //initializing the table adn the table columns
        col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        col_location.setCellValueFactory(new PropertyValueFactory<>("location"));
        col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_publishTime.setCellValueFactory(new PropertyValueFactory<>("publish"));
        col_available.setCellValueFactory(new PropertyValueFactory<>("Copies"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        tbl_books.setItems(books);
    }

    public void searchTitle() {
        ObservableList<Book> books = userSearchBookModel.GetBookByTitle(text_search.getText());

        //initializing the table adn the table columns
        col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        col_location.setCellValueFactory(new PropertyValueFactory<>("location"));
        col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_publishTime.setCellValueFactory(new PropertyValueFactory<>("publish"));
        col_available.setCellValueFactory(new PropertyValueFactory<>("Copies"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        tbl_books.setItems(books);
    }
}
