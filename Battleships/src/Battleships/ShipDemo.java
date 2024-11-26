package Battleships;

import Battleships.ships.Battleship;
import Battleships.ships.Destroyer;
import Battleships.ships.Submarine;
import Battleships.ships.Aeroplane;
import Battleships.ships.AircraftCarrier;

public class ShipDemo {
    public static void main(String[] args) {
        Ship[] ships = new Ship[] {
                new Battleship(), new Destroyer(), new Submarine(), new Aeroplane(), new AircraftCarrier()
        };

        for (Ship s : ships) {
            System.out.println(s.getName());
            System.out.println(s);
            s.rotate();
            System.out.println(s);
        }
    }
}
