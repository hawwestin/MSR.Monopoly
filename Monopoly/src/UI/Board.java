/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.BoardCore;
import Viewer.Viewer;

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

        //szablon
//        ImagePanel map = new ImagePanel(-1860, -1860);
//        _viewer.addPainter(map, 0);
        
        make();
    }

    private void make() {
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < 10; i++) {
            _viewer.addPainter( _boardCore.streets.get(i).makeField(i, x, y, "up"));
            x-=175;
        }
        x+=175;
        for (int i = 10; i < 20; i++) {
            _viewer.addPainter( _boardCore.streets.get(i).makeField(i, x, y, "left"));
            y-=175;
        }
        y+=175;
        for (int i = 20; i <30; i++) {
            _viewer.addPainter( _boardCore.streets.get(i).makeField(i, x, y, "down"));
            x+=175;
        }
        x-=175;
        for (int i = 30; i <40; i++) {
            _viewer.addPainter( _boardCore.streets.get(i).makeField(i, x, y, "right"));
            y+=175;
        }

    }
}
