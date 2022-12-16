package LibraryManagementSystem;

import javafx.beans.property.*;


public class Book {
    private StringProperty title , genre , author ,location,publish;
    private IntegerProperty copies , id;



    public Book(String title, String genre, String author, String location,String publish, int copies, int id){
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);
        this.author = new SimpleStringProperty(author);
        this.location = new SimpleStringProperty(location);
        this.publish = new SimpleStringProperty(publish);
        this.copies = new SimpleIntegerProperty(copies);
        this.id = new SimpleIntegerProperty(id);
    }


    public int getId() {
        return id.get();
    }
    public IntegerProperty idProperty() {
        return id;
    }
    public void setId(int id) {
        this.id.set(id);
    }

    public String getTitle() {
        return title.get();
    }
    public StringProperty titleProperty() {
        return title;
    }
    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getGenre() {
        return genre.get();
    }
    public StringProperty genreProperty() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public String getAuthor() {
        return author.get();
    }
    public StringProperty authorProperty() {
        return author;
    }
    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getLocation() {
        return location.get();
    }
    public StringProperty locationProperty() {
        return location;
    }
    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getPublish() { return publish.get(); }
    public StringProperty publishProperty() {
        return publish;
    }
    public void setPublish(String publish) { this.publish.set(publish);}

    public int getCopies() {return copies.get();}
    public IntegerProperty copiesProperty() {
        return copies;
    }
    public void setCopies(int copies) { this.copies.set(copies);
    }


}
