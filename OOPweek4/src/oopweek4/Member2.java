package oopweek4;
import java.util.Date;

public class Member2
{
    //Attributes
    private Person person;
    private String membershipNumber;
    private Date joinDate;

    //Constructor
    public Member2(Person person, String membershipNumber, Date joinDate)
    {
        this.person = person;
        this.membershipNumber = membershipNumber;
        this.joinDate = joinDate;
    }

    //Getters
    //Using Aggregation rather than extension
    public Person getPerson() {
        return person;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public Date getJoinDate() {
        return joinDate;
    }
}
