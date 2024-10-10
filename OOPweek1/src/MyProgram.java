package oopweek1;

public class MyProgram
{
    public static void main(String[] args)
    {
        //Creating objects of students
        Student s1 = new Student(1234567890, "Mickey", "Mouse");
        Student s2 = new Student(1234524890, "Minnie", "Mouse");

        //For the student 1 object
        System.out.println(s1.getFullName());
        System.out.println(s1.getSortName());
        System.out.println(s1.toString());
        System.out.println(s1);

        //For the student 2 object
        System.out.println(s2.getFullName());
        System.out.println(s2.getSortName());
        System.out.println(s2.toString());
        System.out.println(s2);
    }
}
