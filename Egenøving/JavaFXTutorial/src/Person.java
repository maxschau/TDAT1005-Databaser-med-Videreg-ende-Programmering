import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    //Returns the firstName value (ie. "Max")
    public String getFirstName() {
        return firstName.get();
    }

    //Returns the StringProperty object
    public StringProperty firstNameProperty() {
        return firstName;
    }

    //Sets the firstName value
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
