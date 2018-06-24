/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameMechanics;

import UI.Windows.WelcomeWindow;
import UI.Windows.GameWindow;
import GameMechanics.GameState;
import Core.Player;
import GameMechanics.PlayersLoop;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Startup class for entire board game. Hosts game JFrame window and obtain
 * change of game state
 *
 * @author Michal
 */
public class Start extends JFrame {

    private static GameWindow _gameWindow;
    private static GameState gameState;
    private static JPanel mainPanel;
    private static WelcomeWindow _welcome;
    private static PlayersLoop _gameLoop;

    /**
     * Return Game window JPanel instance.
     *
     * @return
     */
    public static GameWindow getGame() {
        return _gameWindow;
    }

    /**
     * Run the Game.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Start();
    }

    /**
     * Create backbone of the game class instance.
     */
    public Start() {
        super();
        setTitle("Monopoly");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        _gameWindow = new GameWindow();
        _welcome = new WelcomeWindow();
        _gameLoop = new PlayersLoop();

        changeGameState(GameState.START_STATE);

        setContentPane(mainPanel);

        pack();
        setVisible(true);
        setSize(new Dimension(800, 600));
    }

    /**
     * Change current game state.
     *
     * @param state
     */
    public static void changeGameState(GameState state) {
        gameState = state;

        switch (state) {
            case START_STATE:
                mainPanel.removeAll();
                mainPanel.add(_welcome);
                mainPanel.revalidate();
                mainPanel.repaint();
                break;
            case GAME_STATE:
                mainPanel.removeAll();
                mainPanel.add(_gameWindow);
                mainPanel.revalidate();
                mainPanel.repaint();
                break;
            case GAME_END:
                _gameWindow.TextLog(String.format("\n\nThe winner is %s !!!!\nThe End", PlayersLoop.getPlayers().get(0)));
                _gameWindow.EndGame();
                break;
            default:
                System.out.println("UNKNOWN STATE!");
                //todo logger.
                break;
        }
    }

    /**
     * Persist players object list obtained on welcome screen.
     *
     * @param players
     */
    public static void InitGame(ArrayList<Player> players) {
        PlayersLoop.setPlayers(players);
        _gameWindow.getBoard().makePlayersLayer();
        PlayersLoop.setCurrentPlayer(players.get(0));
        Dice.Reset();
        // todo Dice player order 

    }
}
