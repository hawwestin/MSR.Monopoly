/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.Windows.WelcomeWindow;
import UI.Windows.GameWindow;
import Core.GameState;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Michal
 */
public class Start extends JFrame {

    private static GameWindow game;
    private static GameState gameState;
    private static JPanel mainPanel;
    private static WelcomeWindow welcome;

    public static GameWindow getGame() {
        return game;
    }

    public static void main(String[] args) {
        new Start();
    }

    public Start() {
        setTitle("Monopoly");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        game = new GameWindow(this);
        welcome = new WelcomeWindow(this);

        changeState(GameState.START_STATE);

        setContentPane(mainPanel);

        pack();
        setVisible(true);
        setSize(new Dimension(800, 600));
    }

    public static void changeState(GameState state) {
        gameState = state;

        switch (state) {
            case START_STATE:
                mainPanel.removeAll();
                mainPanel.add(welcome);
                mainPanel.revalidate();
                mainPanel.repaint();
                break;
            case GAME_STATE:
                mainPanel.removeAll();
                mainPanel.add(game);
                mainPanel.revalidate();
                mainPanel.repaint();
                break;
               //todo WinnerState with new Sth! ?
            default:
                System.out.println("UNKNOWN STATE!");
                break;
        }
    }
}
