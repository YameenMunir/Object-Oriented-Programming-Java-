package Battleships.gui;

import Battleships.AbstractPlayer;
import Battleships.Board;

public abstract class GUIPlayer extends AbstractPlayer {
    protected GamePanel gamePanel;

    public GUIPlayer(final String name, final Board board) {
        super(name, board);
    }
    public void setGamePanel(final GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void quitGame() {
        this.gamePanel.playerQuit(this);
    }
}