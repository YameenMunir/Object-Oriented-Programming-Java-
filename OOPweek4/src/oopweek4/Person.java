package oopweek4;
import java.util.Objects;

public class Person
{
    //Attributes of the Person class
    private String firstName;
    private String lastName;

    //Constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //Getters
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }

    //Method for retrieving the hashcode
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }



    public boolean equals(Object object) {
        // Check if the object being compared is the same instance as this object
        if (this == object) {
            return true; // If they are the same instance, they are equal
        }

        // Check if the object being compared is null
        if (object == null) {
            return false; // If object is null, they are not equal
        }

        // Check if the object is of the same class as this object
        if (getClass() != object.getClass()) {
            return false; // If classes are different, they are not equal
        }

        // Cast the object to a Person type, now that we know it's a Person
        Person other = (Person) object;

        // Compare the firstName and lastName fields of both objects
        // Using Objects.equals to handle potential null values
        return Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName);
        // Return true only if both firstName and lastName match
    }


    //Method for converting firstname and lastname into string
    public String toString()
    {
        return this.firstName + " " + this.lastName;
    }

}
