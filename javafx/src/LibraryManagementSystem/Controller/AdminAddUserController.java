package LibraryManagementSystem.Controller;

import LibraryManagementSystem.Model.AdminAddUserModel;
import LibraryManagementSystem.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AdminAddUserController implements Initializable {
    @FXML
    private TableView<User> tbl_user ;
    @FXML
    private TableColumn<User, String> col_fname , col_lname , col_gender , col_email , col_phone ;
    @FXML
    private TableColumn<User, Integer> col_id ;
    @FXML
    private TableColumn<User, Date> col_create_time ;

    @FXML
    private TextField text_fname , text_lname , text_gender , text_email , text_phone;


    private static ObservableList<User> users;
    private AdminAddUserModel adminAddUserModel = new AdminAddUserModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        users = adminAddUserModel.GetUsers() ;


        //initializing the table adn the table columns
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        col_lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        col_create_time.setCellValueFactory(new PropertyValueFactory<>("createTime") );


        //enabling table cell editing
        col_lname.setCellFactory(TextFieldTableCell.forTableColumn());
        col_fname.setCellFactory(TextFieldTableCell.forTableColumn());
        col_email.setCellFactory(TextFieldTableCell.forTableColumn());
        col_gender.setCellFactory(TextFieldTableCell.forTableColumn());
        col_phone.setCellFactory(TextFieldTableCell.forTableColumn());
        tbl_user.setItems(users);
        tbl_user.setEditable(true);


        /*                   On click Listeners               */
        col_phone.setOnEditCommit(userStringCellEditEvent -> {
            User user = getSelectedRow() ;
            user.setPhone(userStringCellEditEvent.getNewValue());
            adminAddUserModel.UpdateUser(user);
        });

        col_gender.setOnEditCommit(userStringCellEditEvent -> {
           User user = getSelectedRow() ;
            user.setGender(userStringCellEditEvent.getNewValue());
            adminAddUserModel.UpdateUser(user);
        });

        col_email.setOnEditCommit(userStringCellEditEvent -> {
            User user = getSelectedRow() ;
            user.setEmail(userStringCellEditEvent.getNewValue());
            adminAddUserModel.UpdateUser(user);
        });

        col_lname.setOnEditCommit(userStringCellEditEvent -> {
            User user = getSelectedRow() ;
            user.setLname(userStringCellEditEvent.getNewValue());
            adminAddUserModel.UpdateUser(user);
        });

        col_fname.setOnEditCommit(userStringCellEditEvent -> {
            User user = getSelectedRow() ;
            user.setFname(userStringCellEditEvent.getNewValue());
            adminAddUserModel.UpdateUser(user);
        });

        /*              ENd     On click Listeners               */
    }


    private User getSelectedRow(){ return tbl_user.getSelectionModel().getSelectedItem(); }

    public void AddUser() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-DD HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        int userId = users.get( users.size() - 1 ).getId() + 1;
        User user = new User(userId , text_fname.getText() , text_lname.getText() , text_email.getText() , text_gender.getText() , text_phone.getText(),formattedDate);
        adminAddUserModel.AddUser(user);
        users.add(user);
        text_fname.setText("");
        text_lname.setText("");
        text_gender.setText("");
        text_email.setText("");
        text_phone.setText("");
    }

    public void RemoveUser() {
        User user = getSelectedRow() ;
        adminAddUserModel.RemoveUser(user);
        users.remove(user);
    }

}
