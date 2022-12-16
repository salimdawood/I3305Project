package LibraryManagementSystem.Controller;

import LibraryManagementSystem.Book;
import LibraryManagementSystem.Model.AdminAddBookModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminAddBookController implements Initializable {
    @FXML
    public TextField text_available,text_publish_time,text_location,text_genre,text_author,text_title;
    @FXML
    public Button btn_add,btn_remove;
    @FXML
    private TableColumn<Book , Integer> col_id , col_available ;
    @FXML
    private TableColumn<Book, String> col_title ,col_author , col_genre , col_location , col_publishTime ;
    @FXML
    public TableView<Book> tbl_books;

    private AdminAddBookModel adminAddBookModel = new AdminAddBookModel() ;
    private static ObservableList<Book> books ;
    
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        books = adminAddBookModel.GetBook() ;

        //initializing the table adn the table columns
        col_author.setCellValueFactory( new PropertyValueFactory<>("author"));
        col_genre.setCellValueFactory( new PropertyValueFactory<>("genre"));
        col_location.setCellValueFactory( new PropertyValueFactory<>("location"));
        col_title.setCellValueFactory( new PropertyValueFactory<>("title"));
        col_publishTime.setCellValueFactory( new PropertyValueFactory<>("publish"));
        col_available.setCellValueFactory(new PropertyValueFactory<>("Copies"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        //enabling table cell editing
        col_author.setCellFactory(TextFieldTableCell.forTableColumn());
        col_genre.setCellFactory(TextFieldTableCell.forTableColumn());
        col_location.setCellFactory(TextFieldTableCell.forTableColumn());
        col_title.setCellFactory(TextFieldTableCell.forTableColumn());
        col_publishTime.setCellFactory(TextFieldTableCell.forTableColumn());
        col_available.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        tbl_books.setItems(books);
        tbl_books.setEditable(true);


        /*                   On click Listeners               */

        col_available.setOnEditCommit(event -> {
            Book b = getSelectedRow() ;
            b.setCopies(event.getNewValue());
            adminAddBookModel.UpdateBook(b);
        });

        col_location.setOnEditCommit(event -> {
            Book b = getSelectedRow() ;
            b.setLocation(event.getNewValue());
            adminAddBookModel.UpdateBook(b);
        });

        col_genre.setOnEditCommit(event -> {
            Book b = getSelectedRow() ;
            b.setGenre(event.getNewValue());
            adminAddBookModel.UpdateBook(b);
        });

        col_author.setOnEditCommit(event -> {
            Book b = getSelectedRow() ;
            b.setAuthor(event.getNewValue());
            adminAddBookModel.UpdateBook(b);
        });

        col_title.setOnEditCommit(event -> {
            Book b = getSelectedRow() ;
            b.setTitle(event.getNewValue());
            adminAddBookModel.UpdateBook(b);
        });

        col_publishTime.setOnEditCommit(event -> {
            Book b = getSelectedRow() ;
            b.setPublish(event.getNewValue());
            adminAddBookModel.UpdateBook(b);
        });

        /*              ENd     On click Listeners               */

    }


    private Book getSelectedRow(){ return tbl_books.getSelectionModel().getSelectedItem(); }


    public void RemoveBook() {
        Book b = getSelectedRow();
        adminAddBookModel.DeleteBook(b);
        books.remove(b);
    }

    public void AddBook() {
        int bookId = books.get( books.size() - 1 ).getId() + 1;
        Book b = new Book(text_title.getText() , text_genre.getText(),text_author.getText(),text_location.getText(),text_publish_time.getText(),Integer.parseInt(text_available.getText()),bookId ) ;
        adminAddBookModel.AddBook(b);
        books.add(b);
        text_available.setText("");
        text_publish_time.setText("");
        text_location.setText("");
        text_genre.setText("");
        text_author.setText("");
        text_title.setText("");
    }
}
