// Ethan Thao 
// Week 1 Assignment One 
// 11/7/2021

// Now to add the actual application or program for putting everything together

// Import the scanner to allow the user to make an input
import java.util.Scanner;

// Now to create the class and main method 
public class AssignmentOnePetsDatabaseApplication {

    public static void main(String[] args) {
        // This is what the user is going to see
        System.out.println("Pet Database Program.\n");

        // Incorporate the scanner
        Scanner scanner = new Scanner(System.in);

        // New pets database
        AssignmentOnePetsDatabase petsDatabase = new AssignmentOnePetsDatabase();


        int userNumber;
        // Use a do loop here to allow the loop to continue till the user has decided to end the program
        do {

            // Now to print out the actual menu
            printMenu();

            // Then to skip that integer to the next line and take the user input to make a decision
            userNumber = Integer.parseInt(scanner.nextLine().trim());
            switch (userNumber) {

            // 1 is for viewing the pets
            case 1: {

                petsDatabase.viewAllPets();
                break;

            }

            // 2 is for adding more pets
            case 2: {

                petsDatabase.addMorePets();
                break;

            }

            // 3 is for updating any pet profile
            case 3: {

                petsDatabase.updatePet();
                break;

            }

            // 4 is removing any pets
            case 4: {

                petsDatabase.removePet();
                break;

            }

            // 5 is for searching pet by names
            case 5: {

                petsDatabase.searchPetsByName();
                break;

            }

            // 6 is for searching pets by age
            case 6: {
                petsDatabase.searchPetsByAge();
                break;
            }

            // 7 is to end the program
            case 7: {

                System.out.println("Goodbye!");
                System.exit(0);

            }

            // Then a default message to cover any mistakes from the user
            default:

                System.out.println("Invalid choice!");

            }

        } 

        // This loop will continue as long as the user input is not equal to 7
        while (userNumber != 7);

    }

    // Then to create the sentences of the program
    private static void printMenu() {
        System.out.print("What would you like to do?\n" + 
        "1. View all pets\n" + 
        "2. Add more pets\n" + 
        "3. Update an existing pet\n" + 
        "4. Remove an existing pet\n" + 
        "5. Search pets by name\n" + 
        "6. Search pet by age\n" + 
        "7. Exit\n" + "Your choice: ");
    }
}