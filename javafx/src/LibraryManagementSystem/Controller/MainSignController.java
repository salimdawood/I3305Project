package LibraryManagementSystem.Controller;

import LibraryManagementSystem.Model.MainSignModel;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainSignController implements Initializable {
    @FXML
    private Text admin_warning,librarian_warning;
    @FXML
    private PasswordField librarian_id,admin_id;
    @FXML
    private Button user_sign,librarian_sign,admin_sign;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    @FXML
    private void librarianSign() throws IOException, SQLException {
        String id = librarian_id.getText();
        MainSignModel mainSignModel = new MainSignModel(id);
        if(mainSignModel.checkLibrarian()) {
            Parent root = FXMLLoader.load(getClass().getResource("../View/librarian-container.fxml"));
            Stage window = (Stage) librarian_sign.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("../stylesheet/light.css").toExternalForm());
            window.setScene(scene);
            window.setFullScreen(true);
        }
        else{
            librarian_id.setText("");
            Timeline timeline = new Timeline(
                    new KeyFrame(
                            Duration.seconds(0),
                            new KeyValue(librarian_warning.textProperty(),"Wrong id")
                    ),
                    new KeyFrame(
                            Duration.seconds(1),
                            new KeyValue(librarian_warning.textProperty(),"")
                    ));
            timeline.play();
        }
    }

    public void adminSign() throws IOException {
        if(admin_id.getText().equals("00000")) {
            Parent root = FXMLLoader.load(getClass().getResource("../View/admin-container.fxml"));
            Stage window = (Stage) admin_sign.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("../stylesheet/light.css").toExternalForm());
            window.setScene(scene);
            window.setFullScreen(true);
        }
        else{
            admin_id.setText("");
            Timeline timeline = new Timeline(
                    new KeyFrame(
                            Duration.seconds(0),
                            new KeyValue(admin_warning.textProperty(),"Wrong password")
                    ),
                    new KeyFrame(
                            Duration.seconds(1),
                            new KeyValue(admin_warning.textProperty(),"")
                    ));
            timeline.play();
        }

    }

    public void userSign() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/user-container.fxml"));
        Stage window = (Stage) user_sign.getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../stylesheet/light.css").toExternalForm());
        window.setScene(scene);
        window.setFullScreen(true);
    }
}
