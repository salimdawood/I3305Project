package LibraryManagementSystem.Model;

import LibraryManagementSystem.openFxml;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class LibrarianContainerModel {
    String filename;
    BorderPane borderPane;

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    public void Inflate() {
        openFxml frame = openFxml.getInstance();
        Pane view = frame.getPage(this.filename);
        this.borderPane.setCenter(view);
    }
}
