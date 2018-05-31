/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Viewer.Viewer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Michal
 */
public class gg {

    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    private static Viewer ViewerBoard;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Monopoly");
        ViewerBoard = new Viewer();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        
        ImagePanel map = new ImagePanel();
        
        ViewerBoard.addPainter(new Board(),1);        
        ViewerBoard.addPainter(map,0);        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

   
        frame.setSize(1024, 1024);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(ViewerBoard, BorderLayout.CENTER);
        frame.getContentPane().add(jScrollPane1, BorderLayout.EAST);
        
        

        //Game Loop. 
    }
}
