package week3code;

public class Person
{
    //Attributes of the Person Class
    private String firstName;
    private String lastName;

    //Constructor
    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //Getter for firstname
    public String getFirstName() {
        return firstName;
    }
    //Getter for lastname
    public String getLastName() {
        return lastName;
    }
}
