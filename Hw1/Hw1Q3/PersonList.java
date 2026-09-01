import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

// Step 1: Create a new data type PersonList.
// PersonList uses a Java LinkedList to store Person objects.
public class PersonList {

    // Step 2: Create a LinkedList inside PersonList.
    private LinkedList<Person> persons;

    // Step 3: Create a constructor for PersonList.
    public PersonList() {
        persons = new LinkedList<Person>();
    }

    // Step 4: Create storePersons().
    // This reads person data from an input stream
    // and stores it in the LinkedList.
    public void storePersons(InputStream input) {
        Scanner scanner = new Scanner(input);

        // Step 5: Read each person's information.
        while (scanner.hasNext()) {
            String firstName = scanner.next();
            String lastName = scanner.next();
            String id = scanner.next();

            // Step 6: Create a Person object.
            Person person = new Person(firstName, lastName, id);

            // Step 7: Add the Person to the LinkedList.
            persons.add(person);
        }

        scanner.close();
    }

    // Step 8: Create displayPersons().
    // This displays all Person objects in the list.
    public void displayPersons(OutputStream output) {
        PrintWriter writer = new PrintWriter(output);

        // Step 9: Go through each Person in the LinkedList.
        for (Person person : persons) {
            writer.println(person);
        }

        writer.flush();
    }

    // Step 10: Create findPerson().
    // This searches for a Person based on their ID.
    public int findPerson(String sid) {

        // Step 11: Search through the LinkedList sequentially.
        for (int i = 0; i < persons.size(); i++) {

            // Step 12: Compare the current person's ID with sid.
            if (persons.get(i).getId().equals(sid)) {
                return i;
            }
        }

        // Step 13: Return -1 if the ID was not found.
        return -1;
    }
}