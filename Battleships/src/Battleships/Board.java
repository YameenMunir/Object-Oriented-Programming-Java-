package Battleships;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board
{
    /*Attribute of the Board Class
    The height and width of the board*/
    private int height;
    private int width;
    //A 2D array representing the board, where the cell is an object of the Square class
    private Square board[][];
    private List<Ship> ships;

    //The constructor for the Board class
    public Board(int height, int width)
    {
        //Initialising the attributes with null values by default
        this.height = height;
        this.width = width;
        this.board = new Square[height][width];
        this.ships = new ArrayList<>();

        // Loop through each row and column to initialize each Square object.
        for(int i = 0; i < this.board.length; i++)
        {
            Square[] row = this.board[i];
            for(int j = 0; j < row.length; j++) {
                row[j] = new Square();
            }
        }
    }

    //Getter method to retrieve the height of the board
    public int getHeight() {
        return height;
    }
    //Getter method to retrieve the width of the board
    public int getWidth() {
        return width;
    }
    // Getter method to retrieve a Square object at a specific coordinate (x, y)
    public Square getSquare(int x, int y)
    {
        return this.board[y][x];
    }

    public void setup(Fleet fleet)
    {
        for(Ship s : fleet.getShips())
        {
            placeShip(s);
        }
    }
    // Method for placing ships

    public void placeShip(Ship ship)
    {
        final int BREAK_THRESHOLD = 1000;

        Random random = new Random();

        //rotate the ship a random number of times
        final int rotations = random.nextInt(4);
        for(int i = 0; i < rotations; i++)
        {
            ship.rotate();
        }
        int breakCount = 0;
        boolean collision = true;
        while(collision)
        {
            if(breakCount >= BREAK_THRESHOLD)
            {
                for(int i = 0; i < this.board.length; i++)
                {
                    Square[] row = this.board[i];
                    for(int j = 0; j < row.length; j++)
                    {
                        row[j].setShip(null);
                    }
                }

                for(Ship s : this.ships)
                {
                    s.setLocation(0,0);
                }
                this.ships.clear();

                throw new FailedToPlaceShipException();
            }

            ship.rotate();
            int x = random.nextInt(this.width - ship.getWidth());
            int y = random.nextInt(this.height - ship.getHeight());
            ship.setLocation(x,y);

            collision = false;
            for(final Ship s: this.ships)
            {
                if(s.overlap(ship))
                {
                    collision = true;
                    break;
                }
            }

            if(!collision)
            {
                ship.addToBoard(this);
                this.ships.add(ship);
            }
            breakCount++;
        }
    }

    //Method for checking whether the given coordinate is given within the board's bounds
    public boolean inBounds(int x, int y)
    {
        return x >= 0 && y >= 0 && x < this.width && y < this.height;
    }
    /* Method to drop a bomb on the board at the specified coordinates.
     Returns true if the bomb hits a ship; otherwise, returns false. */
    public Outcome dropBomb(final int x, final int y) {
        Square square = getSquare(x, y);
        if (!square.getTried()) {
            square.setTried(true);
            Ship sunkShip = null;
            boolean gameWon = false;
            if (square.isHit()) {
                if (square.getShip().isSunk()) {
                    sunkShip = square.getShip();
                    gameWon = true;
                    for(Ship ship : this.ships) {
                        if (!ship.isSunk()) {
                            gameWon = false;
                            break;
                        }
                    }
                }
            }
            return new Outcome(x, y, square.isHit(), sunkShip, gameWon);
        } else {
            // this is a wasted turn - perhaps an exception would be a better idea?
            throw new IllegalStateException("Square already played!");
        }
    }

    //Method for converting the board to a String array representation, each row is represented as a String in the array
    public String[] toStringArray(final boolean showShips)
    {
        final String[] array = new String[this.height];
        for(int y = 0; y < this.height; y++)
        {
            final StringBuilder builder = new StringBuilder(this.width);
            for(int x = 0; x < this.width; x++)
            {
                Square square = getSquare(x, y);
                builder.append(square.getCodeCharacter(showShips));
            }
            array[y] = builder.toString();
        }
        return array;
    }

    // Override toString to provide a complete string representation of the board
    @Override
    public String toString()
    {
        final String[] array = toStringArray(true);
        final StringBuilder builder = new StringBuilder();
        for(int y = 0; y < this.height; y++)
        {
            builder.append(array[y]);
            builder.append("\n");
        }
        return builder.toString();
    }
}