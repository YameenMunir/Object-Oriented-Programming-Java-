package week3code;
import java.util.Date;

public class Member extends Person
{
    //Attributes of the Memeber class
    private String membershipNumber;
    private Date joinDate;

    //Constructor method
    public Member(String firstName, String lastName, String membershipNumber, Date joinDate)
    {
        super(firstName, lastName);
        this.membershipNumber = membershipNumber;
        this.joinDate = joinDate;
    }
    //Getter method for membership number
    public String getMembershipNumber()
    {
        return membershipNumber;
    }
    //Getter method for joindate
    public Date getJoinDate() {
        return joinDate;
    }
}
