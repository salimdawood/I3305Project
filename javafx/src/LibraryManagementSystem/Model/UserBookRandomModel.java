package LibraryManagementSystem.Model;

import LibraryManagementSystem.DataBase;
import javafx.scene.text.Text;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


public class UserBookRandomModel {
    String Query;
    PreparedStatement preparedStatement;
    ResultSet resultSet1,resultSet2;
    DataBase DB = DataBase.getInstance();
    int count;
    int rand;
    String name,genre,location;
    Random random= new Random();
    public UserBookRandomModel(Text text) throws SQLException {
        Query =  ("SELECT id FROM book ORDER BY id DESC LIMIT 1;");
        resultSet1 = DB.getData(Query);
        resultSet1.next();
        count = resultSet1.getInt(1);
        rand = random.nextInt(count)+1;
        preparedStatement = DB.getConnection().prepareStatement("select title,genre,location from book where id=?");
        preparedStatement.setInt(1,rand);
        resultSet2 = DB.getData(preparedStatement);
        if(resultSet2.next()) {
            name = resultSet2.getString(1);
            genre = resultSet2.getString(2);
            location = resultSet2.getString(3);
            text.setText("Title : "+name+"\n"+
                    "Genre : "+genre+"\n"+
                    "Location : "+location);
        }
        else{
            new UserBookRandomModel(text);
        }
    }

}
