package LibraryManagementSystem.Controller;

import LibraryManagementSystem.Model.AdminStatisticsModel;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import java.sql.SQLException;


public class AdminStatisticsController {
    @FXML
    public PieChart chart1, chart2,chart3;

    AdminStatisticsModel adminStatisticsModel;
    String Query1="SELECT count(*),gender FROM database.user group by gender";
    String Query2="SELECT count(*),genre FROM database.book group by genre";
    String Query3="SELECT count(book.genre),book.genre from book inner join user_has_book on book.id=user_has_book.book_id group by book.genre";

    public void loadData() throws SQLException {
        adminStatisticsModel=new AdminStatisticsModel(Query1,chart1,"User's gender");
        adminStatisticsModel=new AdminStatisticsModel(Query2,chart2,"Genres we have ");
        adminStatisticsModel=new AdminStatisticsModel(Query3,chart3,"Borrowed genres");
    }

}
