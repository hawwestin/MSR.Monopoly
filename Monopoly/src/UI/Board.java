/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.BoardCore;
import Core.CornerCore;

import Core.StreetCore;
import Viewer.Viewer;
import java.awt.Color;

/**
 *
 * @author Michal
 */
public class Board {

    private Viewer _viewer;
    private BoardCore _boardCore;

    public Board(Viewer view) {
        _viewer = view;
        _boardCore = new BoardCore();

//        ImagePanel map = new ImagePanel(0, 0);
//        _viewer.addPainter(map, 0);
        
    }

    private void make() {
        int x = 0;
        int y = 0;

        for (int i = 0; i < 10; i++) {
            if (i % 10 == 0) {
                Corner tmp = new Corner(_boardCore.streets.get(i), i, x, y, "up");
                x -=tmp.width;                
                _viewer.addPainter(tmp, 1);
                continue;
            }
            if(i<10){
                
            }
            

            
        }

    }
}
