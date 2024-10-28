package oopweek4;
import java.util.Date;

public class MyProgram
{
    public static void main(String[] args)
    {
        // Create Person objects
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Jane", "Smith");

        // Test toString and display Person objects
        System.out.println("Person 1: " + person1);
        System.out.println("Person 2: " + person2);

        // Check equality of two different Person objects
        System.out.println("Are person1 and person2 equal? " + person1.equals(person2));

        // Create Member objects
        Date joinDate1 = new Date();
        Member member1 = new Member("John", "Doe", "M123", joinDate1);
        Member member2 = new Member("Jane", "Smith", "M124", joinDate1);

        // Test toString and display Member objects
        System.out.println("Member 1: " + member1);
        System.out.println("Member 2: " + member2);

        // Check equality of two different Member objects
        System.out.println("Are member1 and member2 equal? " + member1.equals(member2));

        // Check hash codes
        System.out.println("Hash code of member1: " + member1.hashCode());
        System.out.println("Hash code of member2: " + member2.hashCode());

        // Test Member getters
        System.out.println("Member1's membership number: " + member1.getMembershipNumber());
        System.out.println("Member1's join date: " + member1.getJoinDate());

        // Create Member2 object using aggregation
        Member2 member2Aggregate = new Member2(person1, "M125", new Date());

        // Display Member2 details using aggregation
        System.out.println("Member2 (aggregation) - Person details: " + member2Aggregate.getPerson());
        System.out.println("Member2 (aggregation) - Membership number: " + member2Aggregate.getMembershipNumber());
        System.out.println("Member2 (aggregation) - Join date: " + member2Aggregate.getJoinDate());

        // Check equality of Member2's person with person1
        System.out.println("Is member2Aggregate's person equal to person1? " + member2Aggregate.getPerson().equals(person1));
    }
}

