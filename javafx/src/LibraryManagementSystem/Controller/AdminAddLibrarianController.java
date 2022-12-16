package LibraryManagementSystem.Controller;

import LibraryManagementSystem.Librarian;
import LibraryManagementSystem.Model.AdminAddLibrarianModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminAddLibrarianController implements Initializable {

    @FXML
    private TextField text_name , text_id , text_phone ;

    @FXML
    TableView<Librarian> tbl_librarian;
    @FXML
    private TableColumn<Librarian ,String> col_id , col_name ;
    @FXML
    private TableColumn<Librarian ,String> col_phone ;

    private AdminAddLibrarianModel adminAddLibrarianModel;

    //The list that will contain the librarians
    private static ObservableList<Librarian> librarians;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        adminAddLibrarianModel = new AdminAddLibrarianModel();

        //Get librarians from the  database
        librarians = adminAddLibrarianModel.GetLibrarians();


        //initializing the table adn the table columns
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        col_id.setCellFactory(TextFieldTableCell.forTableColumn());
        col_name.setCellFactory(TextFieldTableCell.forTableColumn());
        col_phone.setCellFactory(TextFieldTableCell.forTableColumn());

        tbl_librarian.setItems(librarians);
        tbl_librarian.setEditable(true);


        /*        Onclick Listeners On the table data    */
        col_id.setOnEditCommit(userStringCellEditEvent -> {
            Librarian librarian = getSelectedRow() ;
            librarian.setId(userStringCellEditEvent.getNewValue());
            adminAddLibrarianModel.UpdateLibrarian(librarian);
        });

        col_name.setOnEditCommit(userStringCellEditEvent -> {
            Librarian librarian = getSelectedRow() ;
            librarian.setName(userStringCellEditEvent.getNewValue());
            adminAddLibrarianModel.UpdateLibrarian(librarian);
        });

        col_phone.setOnEditCommit(userStringCellEditEvent -> {
            Librarian librarian = getSelectedRow() ;
            librarian.setPhone(userStringCellEditEvent.getNewValue());
            adminAddLibrarianModel.UpdateLibrarian(librarian);
        });
        /*    End    Onclick Listeners On the table data    */

    }

    private Librarian getSelectedRow(){ return tbl_librarian.getSelectionModel().getSelectedItem(); }

    public void AddLibrarian() {
        Librarian librarian = new Librarian(text_id.getText() , text_name.getText() , text_phone.getText()) ;
        adminAddLibrarianModel.AddLibrarian(librarian);
        tbl_librarian.getItems().add(librarian);
        text_name.setText("");
        text_id.setText("");
        text_phone.setText("");
    }

    public void RemoveLibrarian() {
        Librarian librarian = getSelectedRow();
        adminAddLibrarianModel.RemoveLibrarian(librarian);
        librarians.remove(librarian);
    }

}
