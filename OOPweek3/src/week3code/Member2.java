package week3code;
import java.util.Date;

public class Member2
{
    //Attributes of Member 2 class
    private String firstName;
    private String lastName;
    private String membershipNumber;
    private Date joinDate;

    //Constructor
    public Member2(String firstName, String lastName, String membershipNumber, Date joinDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.membershipNumber = membershipNumber;
        this.joinDate = joinDate;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public Date getJoinDate() {
        return joinDate;
    }
}
