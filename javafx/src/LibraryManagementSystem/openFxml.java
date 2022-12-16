package LibraryManagementSystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class openFxml {
    private static openFxml openFxml ;
    private Pane view;
    private openFxml(){}

    public static openFxml getInstance(){
        if(openFxml == null)
            openFxml = new openFxml() ;

        return openFxml ;
    }

    public Pane getPage(String filename) {
        try{
            URL fileURL = Main.class.getResource("View/" + filename + ".fxml");
            if(fileURL==null){
                throw new java.io.FileNotFoundException("FXML file could'nt been found!");
            }
            view = new FXMLLoader().load(fileURL);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return view;
    }
}
