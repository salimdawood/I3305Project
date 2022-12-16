package LibraryManagementSystem.Controller;

import LibraryManagementSystem.Model.LibrarianContainerModel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.SVGPath;

public class LibrarianContainerController {
    private boolean count=false;
    @FXML
    private BorderPane main_pain_screen;
    @FXML
    private SVGPath go_light,go_dark;
    LibrarianContainerModel librarianContainerModel = new LibrarianContainerModel();

    @FXML
    public void addAccount() {
        librarianContainerModel.setBorderPane(main_pain_screen);
        librarianContainerModel.setFilename("admin-add-user");
        librarianContainerModel.Inflate();
    }
    @FXML
    public void modifyBarrow() {
        librarianContainerModel.setBorderPane(main_pain_screen);
        librarianContainerModel.setFilename("librarian-barrow-book");
        librarianContainerModel.Inflate();
    }
    @FXML
    public void modifyBookList() {
        librarianContainerModel.setBorderPane(main_pain_screen);
        librarianContainerModel.setFilename("admin-add-book");
        librarianContainerModel.Inflate();
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
