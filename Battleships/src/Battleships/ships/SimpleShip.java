package Battleships.ships;

import Battleships.Board;
import Battleships.Ship;

public class SimpleShip extends Ship
{
    private boolean horizontal;

    public SimpleShip(String name, String code, int squareCount)
    {
        super(name, code, squareCount);
    }


    //Method to rotate the ship
    public void rotate()
    {
        this.horizontal = !this.horizontal;
    }

    // Getter method for determining the width of the ship based on its orientation
    public int getWidth()
    {
        if(this.horizontal)
        {
            return this.squareCount;
        }
        else
        {
            return 1;
        }
    }



    // Getter method to determine the height of the ship based on its orientation
    public int getHeight()
    {
        if(!this.horizontal)
        {
            return this.squareCount;
        }
        else
        {
            return 1;
        }
    }

    //Method to add the ship to the board, marking squares occupied by the ship.
    public void addToBoard(final Board board)
    {
        if(this.horizontal)
        {
            for(int x = 0; x < this.squareCount; x++)
            {
                board.getSquare(x + this.x, this.y).setShip(this);
            }
        }
        else
        {
            for(int y = 0; y < this.squareCount; y++)
            {
                board.getSquare(this.x, y + this.y).setShip(this);
            }
        }
    }

    // Override of toString to provide a visual representation of the ship's layout
    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        if(this.horizontal)
        {
            for(int x = 0; x < this.squareCount; x++)
            {
                builder.append("0");
            }
            builder.append("\n");
        }
        else
        {
            for(int y = 0; y < this.squareCount; y++)
            {
                builder.append("0\n");
            }
        }
        return builder.toString();
    }
}
