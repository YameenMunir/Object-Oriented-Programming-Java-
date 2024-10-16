package Battleships;

public class BoardDemo
{
    public static void main(String[] args)
    {
        Board b1 = new Board(10,10);

        System.out.println(b1.toString());
        System.out.println();

        b1.setup();

        System.out.println(b1);
        System.out.println();

        //Dropping some bombs

        System.out.println("Bombing square x=2, y=0");
        b1.dropBomb(2, 0);
        System.out.println(b1);
        System.out.println();

        System.out.println("Bombing square x=2, y=0");
        b1.dropBomb(2, 1);
        System.out.println(b1);
        System.out.println();

        System.out.println("Bombing square x=2, y=0");
        b1.dropBomb(2, 2);
        System.out.println(b1);
        System.out.println();

        //Printing the board without showing the ships
        System.out.println("Showing the board with the ships hidden:");
        String[] b = b1.toStringArray(false);
        for(String r : b)
        {
            System.out.println(r);
        }


    }
}
