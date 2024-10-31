package Battleships;

public class BoardDemo
{

    public static void main(String[] args)
    {

        //Creating a 10x10 Board
        Board b1 = new Board(10,10);

        Fleet fleet = new Fleet(1, 2, 3);
        b1.setup(fleet);

        System.out.println(b1);


        System.out.println("NOW BOMBING TWO WHOLE ROWS TO TRY AND SINK SOMETHING");

        for(int y = 3; y < 5; y++)
        {
            for(int x = 0; x < b1.getWidth(); x++)
            {
                System.out.println("Bombing square x=" + x + ", y=" + y);
                b1.dropBomb(x, y);
                System.out.println(b1);
                System.out.println();
            }
        }



    }
}
