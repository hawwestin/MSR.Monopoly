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
import GameMechanics.GameLoop;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Michal
 */
public class Start extends JFrame {

    private static GameWindow _gameWindow;
    private static GameState gameState;
    private static JPanel mainPanel;
    private static WelcomeWindow _welcome;
    private static GameLoop _gameLoop;

    public static GameWindow getGame() {
        return _gameWindow;
    }

    public static void main(String[] args) {
        new Start();
    }

    public Start() {
        super();
        setTitle("Monopoly");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        _gameWindow = new GameWindow();
        _welcome = new WelcomeWindow();
        _gameLoop = new GameLoop();

        changeGameState(GameState.START_STATE);

        setContentPane(mainPanel);

        pack();
        setVisible(true);
        setSize(new Dimension(800, 600));
    }

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
            //todo WinnerState with new Sth! ?
            default:
                System.out.println("UNKNOWN STATE!");
                break;
        }
    }

    public static void InitGame(ArrayList<Player> players) {
        _gameLoop.setPlayers(players);
        _gameWindow.getBoard().makePlayersLayer(5);
        GameLoop.setCurrentPlayer(players.get(0));        
        
        // todo Dice player order 

    }
}
