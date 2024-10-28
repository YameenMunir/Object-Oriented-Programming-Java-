package oopweek4;
import java.util.Date;
import java.util.Objects;

// The Member class extends the Person class, adding membership-specific attributes
public class Member extends Person {

    // Attributes for membership
    private String membershipNumber;  // Unique identifier for a Member
    private Date joinDate;            // Date the member joined

    // Constructor to initialize Member attributes, including inherited Person attributes
    public Member(String firstName, String lastName, String membershipNumber,
                  Date joinDate) {
        super(firstName, lastName);   // Initialize firstName and lastName using Person's constructor
        this.membershipNumber = membershipNumber;
        this.joinDate = joinDate;
    }

    // Getter for membershipNumber
    public String getMembershipNumber() {
        return this.membershipNumber;
    }

    // Getter for joinDate
    public Date getJoinDate() {
        return this.joinDate;
    }

    // Overriding hashCode to generate a hash code based on Member attributes
    @Override
    public int hashCode() {
        int result = super.hashCode();  // Start with hash code from superclass (Person)
        result = 31 * result + Objects.hash(this.joinDate, this.membershipNumber); // Include joinDate and membershipNumber
        return result;                  // Return the final hash code
    }

    // Overriding equals to compare Member objects based on attributes
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {       // First, check if Person attributes are equal
            return false;               // If they aren't equal, return false
        }
        Member other = (Member) obj;    // Safe to cast obj to Member after superclass check
        return Objects.equals(this.joinDate, other.joinDate) &&
                Objects.equals(this.membershipNumber, other.membershipNumber); // Compare Member-specific fields
    }

    // Overriding toString to provide a string representation of a Member object
    @Override
    public String toString() {
        return super.toString() + " " + this.membershipNumber + " " + this.joinDate; // Include Person and Member details
    }
}
