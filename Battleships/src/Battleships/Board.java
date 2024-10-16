package Battleships;

public class Board
{
    //Attribute of the Board Class
    // The height and width of the board
    private int height;
    private int width;
    //A 2D array representing the board, where the cell is an object of the Aquare class
    private Square board[][];

    //The constructor for the Board class
    public Board(int height, int width)
    {
        this.height = height;
        this.width = width;
        this.board = new Square[height][width];

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

    // Method to set up the board with ships at predefined locations
    public void setup()
    {
        // a battleship
        Ship s = new Ship("battleship", "B");
        getSquare(1,1).setShip(s);
        getSquare(2,1).setShip(s);
        getSquare(3,1).setShip(s);
        getSquare(4,1).setShip(s);
        getSquare(5,1).setShip(s);

        // a destroyer
        s = new Ship("destroyer", "D");
        getSquare(7,4).setShip(s);
        getSquare(7,5).setShip(s);
        getSquare(7,6).setShip(s);
        getSquare(7,7).setShip(s);

        // a submarine
        s = new Ship("submarine", "S");
        getSquare(3,3).setShip(s);
        getSquare(4,3).setShip(s);
        getSquare(5,3).setShip(s);
    }

    //Method for checking whether the given coordinate is given within the board's bounds
    public boolean inBounds(int x, int y)
    {
        return x >= 0 && y >= 0 && x < this.width && y < this.height;
    }
    /* Method to drop a bomb on the board at the specified coordinates.
     Returns true if the bomb hits a ship; otherwise, returns false. */
    public boolean dropBomb(final int x, final int y)
    {
        Square square = getSquare(x, y);
        if(!square.getTried())
        {
            square.setTried();
            return square.isHit();
        }
        else
        {
            //this is a wasted turn
            return false;
        }
    }

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

    @Override
    public String toString()
    {
        final String[] array = toStringArray(true);
        final StringBuilder builder = new StringBuilder(); // Corrected this line
        for(int y = 0; y < this.height; y++)
        {
            builder.append(array[y]);
            builder.append("\n");
        }
        return builder.toString();
    }
}
