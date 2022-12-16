package LibraryManagementSystem.Controller;

import LibraryManagementSystem.Barrow;
import LibraryManagementSystem.Model.LibrarianBarrowBookModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class LibrarianBarrowBookController implements Initializable {
    @FXML
    public TextField text_book_id,text_user_id;
    @FXML
    public TableColumn<Barrow,Integer> col_book_id,col_user_id;
    @FXML
    public TableColumn<Barrow, Date> col_time;
    @FXML
    public TableView<Barrow> tbl_borrow;

    private static ObservableList<Barrow> barrows;
    private LibrarianBarrowBookModel librarianBarrowBookModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        librarianBarrowBookModel = new LibrarianBarrowBookModel();

        barrows = librarianBarrowBookModel.GetBarrow() ;


        //initializing the table adn the table columns
        col_user_id.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        col_book_id.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        col_time.setCellValueFactory(new PropertyValueFactory<>("barrow_Time"));
        tbl_borrow.setItems(barrows);


    }


    private Barrow getSelectedRow(){ return tbl_borrow.getSelectionModel().getSelectedItem(); }

    public void addBorrow() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-DD HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        int A = Integer.parseInt(text_book_id.getText());
        int B = Integer.parseInt(text_user_id.getText());
        Barrow barrow = new Barrow(A,B,formattedDate);
        librarianBarrowBookModel.AddBarrow(barrow);
        barrows.add(barrow);
        text_book_id.setText("");
        text_user_id.setText("");
    }

    public void deleteBorrow() {
        Barrow barrow = getSelectedRow() ;
        librarianBarrowBookModel.RemoveBarrow(barrow);
        barrows.remove(barrow);
    }

}
