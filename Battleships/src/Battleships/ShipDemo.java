package Battleships;

public class ShipDemo
{
    public static void main(String[] args)
    {
        Ship s = new Ship("submarine", "S", 3);

        System.out.println(s);
        s.rotate();
        System.out.println(s);
    }
}
