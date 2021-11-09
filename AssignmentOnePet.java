// Ethan Thao 
// Week 1 Assignment One 
// 11/7/2021

// Then to create the pet program for returning all the values and ids
public class AssignmentOnePet {
    // Here is the list of private variables that we have created
    private static int userNumber = 0;
    private int id;
    private String name;
    private int age;

    // Followed by the assignment of their ids
    public AssignmentOnePet(String name, int age) {
        this.id = userNumber;
        this.name = name;
        this.age = age;
        userNumber++;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Then to return the values
    // Return the id
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Return the name
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Return the age
    public int getAge() {
        return age;
    }
}