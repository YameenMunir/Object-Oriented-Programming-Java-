package Battleships.gui;

import Battleships.Board;
import Battleships.BoardFactory;

import javax.swing.*;
import java.awt.*;

public class BoardPanel1 extends JPanel
{

    private final Board board;
    private final BoardButton1[][] squares;

    public BoardPanel1(final Board board) {
        super(new GridLayout(board.getHeight(), board.getWidth()));
        this.board = board;
        this.squares = new BoardButton1[board.getHeight()][board.getWidth()];
        for (int y = 0; y < this.squares.length; y++) {
            final int finalY = y;
            for (int x = 0; x < this.squares[y].length; x++) {
                final int finalX = x;
                final BoardButton1 button = new BoardButton1(board.getSquare(x, y));
                button.addActionListener((ev)->handleButton(finalX,finalY));
                this.squares[y][x] = button;
                add(button);
            }
        }
    }
    private void handleButton(final int x, final int y) {
        if (!this.board.getSquare(x,y).getTried()) {
            System.out.println( "Player clicked " + x + ", " + y);
        }
    }

    public void setShowShips(final boolean showShips) {
        for (int y = 0; y < this.squares.length; y++) {
            for (int x = 0; x < this.squares[y].length; x++) {
                this.squares[y][x].setShowShips(showShips);
            }
        }
    }

    @Override
    public void setEnabled(final boolean enabled) {
        for (int y = 0; y < this.squares.length; y++) {
            for (int x = 0; x < this.squares[y].length; x++) {
                this.squares[y][x].setEnabled(enabled);
            }
        }
    }

    public static void launch(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Board board = BoardFactory.getBigBoard();

        board.dropBomb(5, 6);

        BoardPanel1 bp = new BoardPanel1(board);
        bp.setShowShips(true);

        f.add(bp);
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> launch(args));
    }
}
