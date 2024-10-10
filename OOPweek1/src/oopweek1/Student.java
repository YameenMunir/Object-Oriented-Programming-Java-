package oopweek1;

public class Student
{
    //Attributes of the student class
    private int idNumber;
    private String firstName;
    private String lastName;

    //Constructor
    public Student(int idNumber, String first, String last)
    {
        this.idNumber = idNumber;
        this.firstName = first;
        this.lastName = last;
    }

    //Method for returning the fullname
    public String getFullName()
    {
        return this.firstName + " " + this.lastName;
    }

    //Method for returning the sorted name
    public String getSortName()
    {
        return this.lastName + ", " + this.firstName;
    }

    //Method for returning the id number as well as the sorted name
    public String toString()
    {
        return this.idNumber + getSortName();
    }
}
