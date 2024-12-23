package Battleships.ships;

import Battleships.Ship;
import Battleships.Board;

public class TemplateShip extends Ship
{
    private int[][] template;

    public TemplateShip(String name, String code, int[][] template)
    {
        super(name, code, countSquares(template));
        this.template = template;
    }

    public static int countSquares(int[][] template)
    {
        int count = 0;
        for(int[] row : template)
        {
            for(int square : row)
            {
                if(square == 1)
                {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public void rotate()
    {
        transpose();
        mirror();
    }

    public void transpose()
    {
        final int[][] nextTemplate = new int[this.getWidth()][this.getHeight()];
        for(int y = 0; y < this.getHeight(); y++)
        {
            for(int x = 0; x < this.getWidth(); x++)
            {
                nextTemplate[x][y] = this.template[y][x];
            }
        }
        this.template = nextTemplate;
    }

    public void mirror()
    {
        for(int y = 0; y < this.getHeight(); y++)
        {
            final int[] row = this.template[y].clone();
            for(int x = 0; x < this.getWidth(); x++)
            {
                row[x] = this.template[y][(this.getWidth() - 1) - x];
            }
            this.template[y] = row;
        }

    }

    @Override
    public int getWidth()
    {
        return this.template[0].length;
    }
    @Override
    public int getHeight()
    {
        return this.template.length;
    }

    @Override
    public void addToBoard(final Board board)
    {
        int baseX = getX();
        int baseY = getY();
        for(int y = 0; y < this.getHeight(); y++)
        {
            for(int x = 0; x < this.getWidth(); x++)
            {
                if(this.template[y][x] == 1)
                {
                    board.getSquare(x + baseX, y + baseY).setShip(this);
                }
            }
        }
    }

    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        for(int y = 0; y < this.getHeight(); y++) {
            for(int x = 0; x < this.getWidth(); x++) {
                if (this.template[y][x] == 0) {
                    builder.append("~");
                } else {
                    builder.append("O");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}
