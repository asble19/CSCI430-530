import java.io.*;

public class MyMain {

    public static void main(String[] args) {

        // Step 3b: Instantiate the PersonList object in the main program 
        // and invoke its methods (as per the appropriate syntax), so that 
        // the program produces the same output.
        PersonList personList = new PersonList();

        try {
            // Open the data file.
            FileInputStream input = new FileInputStream("persons.txt");

            // Store the people in the PersonList.
            personList.storePersons(input);

            // Display all people.
            System.out.println("People in the list:");
            personList.displayPersons(System.out);

            // Search for an existing person.
            System.out.println("\nSearching for ID 1002:");
            System.out.println("Index: " + personList.findPerson("1002"));

            // Search for another existing person.
            System.out.println("\nSearching for ID 1004:");
            System.out.println("Index: " + personList.findPerson("1004"));

            // Search for a person who does not exist.
            System.out.println("\nSearching for ID 9999:");
            System.out.println("Index: " + personList.findPerson("9999"));

            // Close the input file.
            input.close();

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}