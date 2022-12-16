package LibraryManagementSystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Problem {
    private StringProperty problem = new SimpleStringProperty();

    public Problem(String problem){
        this.setProblem(problem);
    }

    public String getProblem() {
        return problem.get();
    }

    public void setProblem(String problem) {
        this.problem.set(problem);
    }


    public StringProperty problemProperty() {
        return problem;
    }
}
