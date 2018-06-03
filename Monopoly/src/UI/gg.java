/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Viewer.Viewer;
import Viewer.ViewerInfoHandler;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Michal
 */
public class gg {

    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    private static Viewer ViewerBoard;
    private static Board board;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Monopoly");
        ViewerBoard = new Viewer();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        board = new Board(ViewerBoard);

       
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(ViewerBoard, BorderLayout.CENTER);
        frame.getContentPane().add(jScrollPane1, BorderLayout.EAST);

        JLabel infoLabel = new JLabel(" ");
        frame.getContentPane().add(infoLabel, BorderLayout.SOUTH);
        ViewerBoard.addMouseMotionListener(
                new ViewerInfoHandler(infoLabel, ViewerBoard));

//        ViewerBoard.setPreferredSize(new Dimension(500, 500));
        frame.pack();
//        ViewerBoard.setPreferredSize(null);
        frame.setLocationRelativeTo(null);
        frame.setSize(1024, 1024);
        frame.setVisible(true);

        //Game Loop. 
        //What is the difrence paint a PaintCOmponent ??
    }
}
