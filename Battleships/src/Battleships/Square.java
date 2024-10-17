package Battleships;

public class Square
{
    //Attributes of the Square Class
    private boolean tried = false; // Indicates whether this square has been targeted by a bomb
    private Ship ship; // The ship placed on this square, if any

    //Setter method to place a ship on this square
    public void setShip(Ship ship)
    {
        this.ship = ship;
    }
    //Getter method to retrieve the ship placed on this square
    public Ship getShip()
    {
        return this.ship;
    }
    // Setter Method. Marks this square as "tried," meaning it has been bombed
    public void setTried()
    {
        this.tried = true;
    }
    //Getter Method. Returns whether this square has been tried (bombed)
    public boolean getTried()
    {
        return this.tried;
    }
    //Returns true if the square has been tried and a ship is present (in other words, a hit)
    public boolean isHit()
    {
        return this.tried && this.ship != null;
    }
    //Returns true if the square has been tried and no ship is present (in other words, a miss)
    public boolean isMiss()
    {
        return this.tried && this.ship == null;
    }
    // Returns a character representation of the square depending on its status
    // If showShips is true, the method reveals ship positions
    public String getCodeCharacter(boolean showShips)
    {
        if(this.tried) //If the square has been tried
        {
            if(this.isHit())
            {
                return "*";// Returns "*" for a hit
            }
            else if(this.isMiss())
            {
                return "'"; // Returns "'" for a miss
            }

        }
        else //If the square has not been tried
        {
            if(showShips && this.ship != null)
            {
                return this.ship.getCode(); // Displays the ship's code if ships are visible
            }
        }
        return "~"; // Returns "~" for an untouched (water) square
    }

}
