package LibraryManagementSystem.Model;

import LibraryManagementSystem.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminStatisticsModel {
    DataBase DB= DataBase.getInstance();
    ResultSet resultSet;

    public  AdminStatisticsModel(String Query,PieChart chart,String title) throws SQLException {
        resultSet =DB.getData(Query);
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        while(resultSet.next()) {
            list.add(new PieChart.Data(resultSet.getString(2), resultSet.getInt(1)));
        }
        chart.setData(list);
        chart.setTitle(title);
    }

}
