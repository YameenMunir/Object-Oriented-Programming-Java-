package Battleships;

import java.awt.geom.Rectangle2D;

public abstract class Ship
{
    //Attributes of the Ship Class
    private final String name;
    private final String code;
    protected int squareCount;
    protected int x;
    protected int y;
    private boolean isTried;

    private int hits;

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
    public abstract void rotate();


    // Getter method for determining the width of the ship based on its orientation
    public abstract int getWidth();


    // Getter method to determine the height of the ship based on its orientation
    public abstract int getHeight();


    //Method to check if this ship overlaps with another ship on the board.
    public boolean overlap(final Ship other)
    {
        final Rectangle2D rectThis = new Rectangle2D.Double(this.x , this.y, this.getWidth(),this.getHeight());
        final Rectangle2D  rectOther = new Rectangle2D.Double(other.x, other.y, other.getWidth(), other.getHeight());
        final Rectangle2D intersection = rectThis.createIntersection(rectOther);
        return (intersection.getWidth() >= 0) && (intersection.getHeight() >= 0);
    }

    //Method to add the ship to the board, marking squares occupied by the ship.
    public abstract void addToBoard(final Board board);

    public boolean incrementHitCount()
    {
        if(this.hits < this.squareCount)
        {
            this.hits++;
        }
        return this.hits == this.squareCount;
    }

    public boolean isSunk()
    {
        return (this.hits == this.squareCount);
    }





}
