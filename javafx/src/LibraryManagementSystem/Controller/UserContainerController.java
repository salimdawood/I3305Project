package LibraryManagementSystem.Controller;

import LibraryManagementSystem.Model.UserContainerModel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.SVGPath;

public class UserContainerController {
    private boolean count=false;
    @FXML
    private BorderPane main_pain_screen;
    @FXML
    private SVGPath go_light,go_dark;
    UserContainerModel userContainerModel = new UserContainerModel();
    @FXML
    public void viewSearch() {
        userContainerModel.setBorderPane(main_pain_screen);
        userContainerModel.setFilename("user-search-book");
        userContainerModel.Inflate();
    }

    @FXML
    public void darkTheme(MouseEvent event) {
        Node node = (Node) event.getSource();
        Scene thisScene = node.getScene();
        if (count =!count) {
            thisScene.getStylesheets().add(getClass().getResource("../stylesheet/dark.css").toExternalForm());
            go_dark.setVisible(false);
            go_light.setVisible(true);
        }
        else{
            thisScene.getStylesheets().remove(getClass().getResource("../stylesheet/dark.css").toExternalForm());
            thisScene.getStylesheets().add(getClass().getResource("../stylesheet/light.css").toExternalForm());
            go_dark.setVisible(true);
            go_light.setVisible(false);
        }

    }
    @FXML
    public void viewRandomBook() {
        userContainerModel.setBorderPane(main_pain_screen);
        userContainerModel.setFilename("user-book-random");
        userContainerModel.Inflate();
    }
    @FXML
    public void closeOption() { System.exit(0); }
    @FXML
    public void viewProblem() {

        userContainerModel.setBorderPane(main_pain_screen);
        userContainerModel.setFilename("user-send-problem");
        userContainerModel.Inflate();
    }
}
