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
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Michal
 */
public class gg { //TODO Deprecated , will be deleted

    private static javax.swing.JScrollPane _JSPTextLog;
    private static javax.swing.JTextArea _JTALog;
    private static Viewer ViewerBoard;
    private static Board board;    
    private static GameWindow gameWindow;    

    public static void main(String[] args) {
        JFrame frame = new JFrame("Monopoly");
        ViewerBoard = new Viewer();
        _JSPTextLog = new javax.swing.JScrollPane();
        _JTALog = new javax.swing.JTextArea();
        board = new Board(ViewerBoard);
        
        gameWindow = new GameWindow();
//        JPanel _actionButtons = MakeActionButtons(ViewerBoard);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
//        _JTALog.setColumns(20);
//        _JTALog.setRows(5);
//        _JSPTextLog.setViewportView(_JTALog);   
                
        
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(gameWindow);

//        frame.getContentPane().add(ViewerBoard);
//        frame.getContentPane().add(_JSPTextLog, BorderLayout.EAST);
//        frame.getContentPane().add(_actionButtons, BorderLayout.SOUTH);

//        JLabel infoLabel = new JLabel(" ");
//        frame.getContentPane().add(infoLabel, BorderLayout.SOUTH);
//        ViewerBoard.addMouseMotionListener(
//                new ViewerInfoHandler(infoLabel, ViewerBoard));

//        ViewerBoard.setPreferredSize(new Dimension(500, 500));
        frame.pack();
//        ViewerBoard.setPreferredSize(null);
//        frame.setLocationRelativeTo(null);
//        frame.setSize(1024, 1024);
        frame.setVisible(true);

        //Game Loop. 
        //What is the difrence paint a PaintCOmponent ??
        
        //Main Class with instaces of boiard , players etc. 
    
    //All Actions performed on Board nad So on... 
    //UI will be subscribing for this actions to be performed 
    }
    
    private static JPanel MakeActionButtons(Viewer viewer){
        JPanel panel = new JPanel();
         panel.add(
            new JLabel("<html>"
                + "Right mouse drags: Translate<br> "
                + "Left mouse drags: Rotate<br>"
                + "Mouse wheel: Zoom uniformly<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp; +shift: zoom along x<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp; +ctrl: zoom along y<br>"
                + "</html>"),
            BorderLayout.NORTH);
        
        JButton resetTransformButton = new JButton("Reset transform");
        resetTransformButton.addActionListener(
                e -> viewer.setDisplayedWorldArea(
                new Rectangle2D.Double(board.InnerBoardLength(),board.InnerBoardLength(),-board.InnerBoardLength(),-board.InnerBoardLength())));
        
        panel.add(resetTransformButton);
        
        return panel;
    }
}
