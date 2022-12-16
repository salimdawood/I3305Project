package LibraryManagementSystem.Controller;

import LibraryManagementSystem.Model.UserBookRandomModel;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import java.sql.SQLException;

public class UserBookRandomController {
    @FXML
    public Text tf_random_book;
    UserBookRandomModel userBookRandomModel;

    public void generate() throws SQLException {
        userBookRandomModel = new UserBookRandomModel(tf_random_book);
    }
}
