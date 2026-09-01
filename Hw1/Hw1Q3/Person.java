// Step 1: Create a data type Person with three string fields: firstName, 
// lastname and id. The field id is unique to each person. Add accessor 
// methods, a constructor with three parameters, and the toString() method.
public class Person {
    private String firstName;
    private String lastName;
    private String id;

    // Create a constructor with three parameters.
    public Person(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    // Create accessor methods.
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    // Create the toString() method.
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + id;
    }
}