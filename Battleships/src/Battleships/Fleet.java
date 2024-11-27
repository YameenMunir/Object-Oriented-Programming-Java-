package Battleships;

import Battleships.ships.*;

import java.util.ArrayList;
import java.util.List;

public class Fleet
{
    private final List<Ship> ships = new ArrayList<>();

    public Fleet(final int battleships, final int destroyers, final int submarines, final int aeroplanes, final int aircraftCarriers)
    {
        for (int i = 0; i < battleships; i++) {
            this.ships.add(new Battleship());
        }
        for (int i = 0; i < destroyers; i++) {
            this.ships.add(new Destroyer()); // Corrected to add a Destroyer
        }
        for (int i = 0; i < submarines; i++) {
            this.ships.add(new Submarine());
        }
        for (int i = 0; i < aeroplanes; i++) {
            this.ships.add(new Aeroplane());
        }
        for (int i = 0; i < aircraftCarriers; i++) {
            this.ships.add(new AircraftCarrier());
        }
    }

    public List<Ship> getShips()
    {
        return this.ships;
    }
}
