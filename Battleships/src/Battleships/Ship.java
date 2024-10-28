package Battleships;

import org.w3c.dom.css.Rect;

import java.awt.geom.Rectangle2D;

public class Ship
{
    //Attributes of the Ship Class
    private final String name;
    private final String code;
    private int squareCount;
    private int x;
    private int y;

    private boolean horizontal;

    //Constructor of the Ship Class
    public Ship(String name, String code, int squareCount)
    {
        this.name = name;
        this.code = code;
        this.squareCount = squareCount;
    }

    //Getters for the x and y coordinates
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Getter method of retrieving the Name of the Ship
    public String getName() {
        return name;
    }

    //Getter method of retrieving the Code of the Ship
    public String getCode()
    {
        return code;
    }

    //Setter method for setting the location of the board
    public void setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
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

    //Method to check if this ship overlaps with another ship on the board.
    public boolean overlap(final Ship other)
    {
        final Rectangle2D rectThis = new Rectangle2D.Double(this.x , this.y, this.getWidth(),this.getHeight());
        final Rectangle2D  rectOther = new Rectangle2D.Double(other.x, other.y, other.getWidth(), other.getHeight());
        final Rectangle2D intersection = rectThis.createIntersection(rectOther);
        return (intersection.getWidth() >= 0) && (intersection.getHeight() >= 0);
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
