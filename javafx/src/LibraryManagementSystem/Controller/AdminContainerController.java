package LibraryManagementSystem.Controller;


import LibraryManagementSystem.Model.AdminContainerModel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.SVGPath;

public class AdminContainerController {
    private boolean count=false;
    @FXML
    private BorderPane main_pain_screen;
    @FXML
    private SVGPath go_light,go_dark;
    AdminContainerModel adminContainerModel = new AdminContainerModel();
    @FXML
    public void viewBugs() {
        adminContainerModel.setBorderPane(main_pain_screen);
        adminContainerModel.setFilename("admin-problems");
        adminContainerModel.Inflate();
    }
    @FXML
    public void viewBooks() {

        adminContainerModel.setBorderPane(main_pain_screen);
        adminContainerModel.setFilename("admin-add-book");
        adminContainerModel.Inflate();
    }
    @FXML
    public void viewLibrarians() {
        adminContainerModel.setBorderPane(main_pain_screen);
        adminContainerModel.setFilename("admin-add-librarian");
        adminContainerModel.Inflate();
    }
    @FXML
    public void viewStat() {

        adminContainerModel.setBorderPane(main_pain_screen);
        adminContainerModel.setFilename("admin-statistics");
        adminContainerModel.Inflate();
    }
    public void viewUser() {
        adminContainerModel.setBorderPane(main_pain_screen);
        adminContainerModel.setFilename("admin-add-user");
        adminContainerModel.Inflate();
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
    public void closeOption() { System.exit(0); }

}
