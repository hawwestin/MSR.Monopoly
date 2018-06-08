/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Michal
 */
public class Start extends JFrame {

    public static void main(String[] args) {
        new Start();
    }

    public Start() {
        setTitle("Monopoly");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new GameWindow());
        pack();
        setVisible(true);
        setSize(new Dimension(800,600));
    }

}
