package week3code;
import java.util.Date;

public class MyProgram
{
    public static void main(String[] args)
    {
        //For the Person Class
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Jane", "Smith");

        // Testing the methods
        System.out.println(person1.getFirstName()); // Output: John
        System.out.println(person1.getLastName());  // Output: Doe
        System.out.println(person2.getFirstName()); // Output: Jane
        System.out.println(person2.getLastName());  // Output: Smith

        //For the Member Class
        Date joinDate1 = new Date(2023, 1, 10); // Example date (Jan 10, 2023)
        Date joinDate2 = new Date(2022, 5, 20); // Example date (May 20, 2022)

        Member member1 = new Member("Alice", "Brown", "M001", joinDate1);
        Member member2 = new Member("Bob", "Johnson", "M002", joinDate2);

        // Testing the methods
        System.out.println(member1.getFirstName());        // Output: Alice
        System.out.println(member1.getLastName());         // Output: Brown
        System.out.println(member1.getMembershipNumber()); // Output: M001
        System.out.println(member1.getJoinDate());         // Output: Date for Jan 10, 2023

        System.out.println(member2.getFirstName());        // Output: Bob
        System.out.println(member2.getLastName());         // Output: Johnson
        System.out.println(member2.getMembershipNumber()); // Output: M002
        System.out.println(member2.getJoinDate());         // Output: Date for May 20, 2022

        //For membership 2

        Date joinDate3 = new Date(2021, 7, 15); // Example date (July 15, 2021)
        Date joinDate4 = new Date(2020, 12, 5); // Example date (Dec 5, 2020)

        Member2 member3 = new Member2("Charlie", "Davis", "M003", joinDate3);
        Member2 member4 = new Member2("Diana", "Wilson", "M004", joinDate4);

        // Testing the methods
        System.out.println(member3.getFirstName());        // Output: Charlie
        System.out.println(member3.getLastName());         // Output: Davis
        System.out.println(member3.getMembershipNumber()); // Output: M003
        System.out.println(member3.getJoinDate());         // Output: Date for July 15, 2021

        System.out.println(member4.getFirstName());        // Output: Diana
        System.out.println(member4.getLastName());         // Output: Wilson
        System.out.println(member4.getMembershipNumber()); // Output: M004
        System.out.println(member4.getJoinDate());         // Output: Date for Dec 5, 2020


    }
}
