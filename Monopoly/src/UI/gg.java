/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.StreetCore;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Michal
 */
public class gg {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Monopoly");
        Board board = new Board();                

        frame.add(board);
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
