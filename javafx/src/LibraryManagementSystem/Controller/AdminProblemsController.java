package LibraryManagementSystem.Controller;


import LibraryManagementSystem.Model.AdminProblemsModel;
import LibraryManagementSystem.Problem;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminProblemsController implements Initializable {

    @FXML
    public TableColumn<Problem,String> col_problem;
    @FXML
    public TableView<Problem> tbl_problem;
    private AdminProblemsModel adminProblemsModel;
    private ObservableList<Problem> problem;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminProblemsModel = new AdminProblemsModel();
        problem = adminProblemsModel.GetProblem();
        col_problem.setCellValueFactory( new PropertyValueFactory<>("problem"));
        tbl_problem.setItems(problem);
        col_problem.setCellFactory(TextFieldTableCell.forTableColumn());
        tbl_problem.setEditable(true);

    }
    private Problem getSelectedRow(){ return tbl_problem.getSelectionModel().getSelectedItem(); }
    public void removeProblem() {
        Problem b = getSelectedRow();
        adminProblemsModel.DeleteProblem(b);
        problem.remove(b);
    }
}
