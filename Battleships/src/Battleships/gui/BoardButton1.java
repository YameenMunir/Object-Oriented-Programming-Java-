package Battleships.gui;

import Battleships.Square;

import javax.swing.*;
import java.awt.*;

public class BoardButton1 extends JButton {
    private Square square;
    private boolean showShips;

    // Constructor to initialize with a Square
    public BoardButton1(Square square) {
        this.square = square;
        this.showShips = false; // Default to not showing ships
        setPreferredSize(new Dimension(16, 16));
    }

    // Overriding the paintComponent method for custom rendering
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call parent class method
        g = g.create();
        final Color darkRed = new Color(192, 0, 0);

        if (square.getTried()) {
            if (square.isHit()) {
                // Hit ship
                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 0, getWidth(), getHeight());
                if (square.getShip().isSunk()) {
                    g.setColor(darkRed);
                } else {
                    g.setColor(Color.ORANGE);
                }
                g.fillOval(4, 4, getWidth() - 8, getHeight() - 8);
            } else if (square.isMiss()) {
                // Sea miss
                g.setColor(Color.BLUE);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.WHITE);
                g.drawOval(4, 4, getWidth() - 8, getHeight() - 8);
            }
        } else {
            if (showShips && (square.getShip() != null)) {
                // Ship
                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 0, getWidth(), getHeight());
            } else {
                // Sea
                g.setColor(Color.BLUE);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    }

    // Static method to launch a sample JFrame with the button
    public static void launch(String[] args) {
        JFrame frame = new JFrame("Board Button Test");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Sample Square instance
        Square sampleSquare = new Square(); // Ensure this is correctly implemented
        sampleSquare.setTried(true); // Example state, modify as needed

        BoardButton1 boardButton = new BoardButton1(sampleSquare);
        frame.add(boardButton);
        frame.pack();
        frame.setVisible(true);
    }

    // Main method to run the test
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> launch(args));
    }

    public void setShowShips(boolean showShips)
    {
        this.showShips = showShips;
    }
}
