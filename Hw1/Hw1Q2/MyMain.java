import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {

    // Step 2a: Create storePersons(<input stream>, <linked list>) that reads 
    // the data for several persons from the input stream and stores the data
    // in the linked list.
    public static void storePersons(InputStream input, LinkedList<Person> persons) {
        Scanner scanner = new Scanner(input);

        // Read each person's first name, last name, and ID.
        while (scanner.hasNext()) {
            String firstName = scanner.next();
            String lastName = scanner.next();
            String id = scanner.next();

            //  Create a Person object.
            Person person = new Person(firstName, lastName, id);

            // Add the Person object to the linked list.
            persons.add(person);
        }

        scanner.close();
    }

    // Step 2b: Create displayPersons(<output stream>, <linked list>) that writes 
    // the data for all person objects in the linked list, on the output stream, 
    // one per line.
    public static void displayPersons(OutputStream output,
                                      LinkedList<Person> persons) {

        PrintWriter writer = new PrintWriter(output);

        // Go through the linked list one Person at a time.
        for (Person person : persons) {
            writer.println(person);
        }

        writer.flush();
    }

    // Step 2c: Create findPerson(string sid, <linked list>) that returns the 
    // index of the person object in the linked list that has the same id value 
    // as sid (return -1 if no such person exists). 
    // This is done as a simple search that goes sequentially through all the 
    // objects in the linked list.
    public static int findPerson(String sid, LinkedList<Person> persons) {

        // Search through the linked list sequentially.
        for (int i = 0; i < persons.size(); i++) {

            // Compare the person's ID with the searched ID.
            if (persons.get(i).getId().equals(sid)) {
                return i;
            }
        }

        // Return -1 if no matching person is found.
        return -1;
    }

    public static void main(String[] args) {

        // Step 2: Create a class MyMain for the main program. Within the 
        // main() program, instantiate a linked list using the Java 
        // LinkedList class.
        LinkedList<Person> persons = new LinkedList<Person>();

        try {
            // Step 2d: Create a data file with data for a few person objects 
            // and open the data file for reading.
            FileInputStream input = new FileInputStream("persons.txt");

            // Step 2e: In the main method, call storePersons() and 
            // displayPersons() methods to read the data and display it.
            storePersons(input, persons);

            // Display all people in the linked list.
            System.out.println("People in the list:");
            displayPersons(System.out, persons);

            // Test findPerson() with an existing ID.
            System.out.println("\nSearching for ID 1002:");
            System.out.println("Index: " + findPerson("1002", persons));

            // Test findPerson() with another existing ID.
            System.out.println("\nSearching for ID 1004:");
            System.out.println("Index: " + findPerson("1004", persons));

            // Test findPerson() with an ID that does not exist.
            System.out.println("\nSearching for ID 9999:");
            System.out.println("Index: " + findPerson("9999", persons));

            // Close the input file.
            input.close();

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}