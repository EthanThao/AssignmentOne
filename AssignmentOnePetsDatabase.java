// Ethan Thao 
// Week 1 Assignment One 
// 11/7/2021

// Import an arraylist and scanner
import java.util.ArrayList;
import java.util.Scanner;

// Create the pet database
// I will call this AssignmentOnePetsDatabase
public class AssignmentOnePetsDatabase {

    // Make a private ArrayList
    private ArrayList<AssignmentOnePet> pet;

    // Assign the new array list
    // And return it as well 
    public AssignmentOnePetsDatabase() {
        this.pet = new ArrayList<>();
    }
    public ArrayList<AssignmentOnePet> getPets() {
        return pet;
    }

    // Then we can create the commands that will allow the user to pick from the database and decide 
    // The first one is to view all pets
    // We shall call this viewAllPets
    public void viewAllPets() {

        // If it is empty, we need to portray an error message
        if (this.pet.isEmpty()) {
            System.out.println("\nThere are no pets to show.\n");
            return;
        }

        // But if they were to add a pet we need to let the user create the option to 
        // The pet id has only 3 characters
        // The pet name has only 10 characters
        // And the age is only 4 characters
        // Then to print out the string
        System.out.printf("\n%3s %10s %4s\n", "ID", "Name", "Age");

        // Then to put it in a for loop and assign it to the get called tags
        // getId for id, getName for names, getAge for age
        for (AssignmentOnePet pet : this.pet) {
            System.out.printf("%3d %10s %4d\n", pet.getId(), pet.getName(), pet.getAge());
        }

        System.out.println();

    }

    // Now for the second option of adding pets
    public void addMorePets() {

        // To incorprate the scanner and lines to name and age
        Scanner scanner = new Scanner(System.in);
        String addPet;
        String name;
        int age;

        int userNumber = 0;

        // Then to print it out
        System.out.println();

        // A do loop is used here until the user is done 
        do {
            System.out.print("Add pet (name, age): ");

            addPet = scanner.nextLine().trim();

            // If the user is done, break the code
            if (addPet.equalsIgnoreCase("done"))

                break;

            // Otherwise continue the code 
            else {

                String[] data = addPet.split(" ");
                name = data[0];
                age = Integer.parseInt(data[1]);

                this.pet.add(new AssignmentOnePet(name, age));
                userNumber++;

            }

        }
        // All while under the condition that addPet is not equal to done
         while (!addPet.equalsIgnoreCase("done"));
        System.out.println(userNumber + " pets added.\n");
    }

    // Now to updatePet feature
    public void updatePet() {

        viewAllPets();

        // Incorporate the scanner
        // pass petId as the next int
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the pet ID you can update: ");
        int petId = Integer.parseInt(scanner.nextLine().trim());

        // A while loop is used here to ensure there is a valid id entered
        while (petId < 0 || petId > this.pet.size()) {

            System.out.println("Please enter a valid existing Id: ");
            petId = Integer.parseInt(scanner.nextLine().trim());

        }

        // Then to assign the previous names and age as the past values
        String initialName = this.pet.get(petId).getName();
        int initialAge = this.pet.get(petId).getAge();


        // Have the pop up message for the new names and age after being updated by the user
        System.out.print("\nEnter new name and new age: ");
        String addPet = scanner.nextLine().trim();
        String[] data = addPet.split(" ");
        String name = data[0];

        int age = Integer.parseInt(data[1]);

        this.pet.get(petId).setName(name);
        this.pet.get(petId).setAge(age);

        // Then to print it all out 
        System.out.println("\n" + initialName + " " + initialAge + " changed to " + this.pet.get(petId).getName() + " "
                + this.pet.get(petId).getAge() + "\n");
    }


    // Now for the remove pet feature 
    public void removePet() {
        viewAllPets();

        // Ask the user for the id of the pet they wanna remove
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the pet ID to remove: ");
        int petId = Integer.parseInt(scanner.nextLine().trim());

        // If it is not true, make sure the id is true 
        // Here I used a while loop to ensure that the user enters a valid id
        while (petId < 0 || petId > this.pet.size()) {
            System.out.println("Please enter a valid existing Id: ");
            petId = Integer.parseInt(scanner.nextLine().trim());
        }

        String initialName = this.pet.get(petId).getName();
        int initialAge = this.pet.get(petId).getAge();

        // Then to remove the pet id and show the pop up message
        this.pet.remove(petId);
        System.out.println("\n" + initialName + " " + initialAge + " is removed.\n");
    }


    // Now to add the search by pets name feature 
    public void searchPetsByName() {
        // Ask the user for a name to search
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a name to search: ");
        String nameSearch = scanner.nextLine().trim();
        ArrayList<AssignmentOnePet> tempPets = new ArrayList<>();


        for (int i = 0; i < this.pet.size(); i++) {
            if (this.pet.get(i).getName().equalsIgnoreCase(nameSearch))
                tempPets.add(this.pet.get(i));
        }


        // If the user does not enter the right name, then have the user get the correct name
        if (tempPets.isEmpty())

            System.out.println("\nNo pets with name " + nameSearch + " was found!\n");

        else {
            System.out.printf("\n%3s %10s %4s\n", "ID", "Name", "Age");
            for (AssignmentOnePet pet : tempPets) {
                System.out.printf("%3d %10s %4d\n", pet.getId(), pet.getName(), pet.getAge());
            }
            System.out.println();
        }
    }

    // Then to search the pets by their age
    public void searchPetsByAge() {

        // Get the user input for the age to search up a pet
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter age to search: ");
        int ageSearch = Integer.parseInt(scanner.nextLine().trim());
        ArrayList<AssignmentOnePet> tempPets = new ArrayList<>();

        for (int i = 0; i < this.pet.size(); i++) {
            if (this.pet.get(i).getAge() == ageSearch)
                tempPets.add(this.pet.get(i));
        }

        // If the user enters a wrong age then show a pop up message
        if (tempPets.isEmpty())
            System.out.println("\nNo pets with age " + ageSearch + " was found!\n");

        // Otherwise, provide the pet that was searched by their age
        else {
            // Print out the pet via their age
            System.out.printf("\n%3s %10s %4s\n", "ID", "Name", "Age");
            for (AssignmentOnePet pet : tempPets) {
                System.out.printf("%3d %10s %4d\n", pet.getId(), pet.getName(), pet.getAge());
            }
            System.out.println();
        }
    }
}