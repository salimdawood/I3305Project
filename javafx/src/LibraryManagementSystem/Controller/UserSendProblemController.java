package LibraryManagementSystem.Controller;

import LibraryManagementSystem.Model.UserSendProblemModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.sql.SQLException;

public class UserSendProblemController {
    @FXML
    public TextArea text_problem;
    UserSendProblemModel userSendProblemModel;
    public void sendProblem() throws SQLException {
        userSendProblemModel = new UserSendProblemModel(text_problem.getText());
        text_problem.setText("");
    }
}
