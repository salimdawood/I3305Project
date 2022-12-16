package LibraryManagementSystem;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Barrow {

    private IntegerProperty book_id = new SimpleIntegerProperty() ;
    private IntegerProperty user_id = new SimpleIntegerProperty() ;
    private StringProperty barrow_Time = new SimpleStringProperty();


    public Barrow(int book_id,int user_id, String barrow_Time) {
        this.setBook_id(book_id);
        this.setUser_id(user_id);
        this.setBarrow_Time(barrow_Time);
    }


    public int getBook_id() {
        return book_id.get();
    }

    public IntegerProperty book_idProperty() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id.set(book_id);
    }

    public int getUser_id() {
        return user_id.get();
    }

    public IntegerProperty user_idProperty() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id.set(user_id);
    }

    public String getBarrow_Time() {
        return barrow_Time.get();
    }

    public StringProperty barrow_TimeProperty() {
        return barrow_Time;
    }

    public void setBarrow_Time(String barrow_Time) {
        this.barrow_Time.set(barrow_Time);
    }


}
