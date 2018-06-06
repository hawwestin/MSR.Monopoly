/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.BoardCore;
import Viewer.Painter;
import Viewer.Viewer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Michal
 */
public class Board {

    private Viewer _viewer;
    private BoardCore _boardCore;
    private int _innerBoardLength;

    public Board(Viewer view) {
        _viewer = view;
        _boardCore = new BoardCore();

        //szablon
//        ImagePanel map = new ImagePanel(-1860, -1860);
//        _viewer.addPainter(map, 0);
        makeTiles();
        makeInnerBoard();

        _viewer.setDisplayedWorldArea(-1000, -1000, 500, 500);
    }

    private void makeTiles() {
        int x = 0;
        int y = 0;

        for (int i = 0; i < 10; i++) {
            _viewer.addPainter(_boardCore.streets.get(i).makeField(i, x, y, "up"));
            x -= 175;
        }
        x += 175;
        _innerBoardLength = x;
        for (int i = 10; i < 20; i++) {
            _viewer.addPainter(_boardCore.streets.get(i).makeField(i, x, y, "left"));
            y -= 175;
        }
        y += 175;
        for (int i = 20; i < 30; i++) {
            _viewer.addPainter(_boardCore.streets.get(i).makeField(i, x, y, "down"));
            x += 175;
        }
        x -= 175;
        for (int i = 30; i < 40; i++) {
            _viewer.addPainter(_boardCore.streets.get(i).makeField(i, x, y, "right"));
            y += 175;
        }

    }

    private void makeInnerBoard() {
        _viewer.addPainter(new Painter() {
            @Override
            public void paint(Graphics2D g, AffineTransform worldToScreen, double w, double h) {
                Rectangle2D innerField = new Rectangle2D.Double(_innerBoardLength, _innerBoardLength, -_innerBoardLength, -_innerBoardLength);
                Rectangle2D innerFieldCommunity = new Rectangle2D.Double(_innerBoardLength, _innerBoardLength, -_innerBoardLength/2, -_innerBoardLength/2);
                Rectangle2D innerFieldChance = new Rectangle2D.Double(_innerBoardLength/2, _innerBoardLength/2, -_innerBoardLength/2, -_innerBoardLength/2);

                AffineTransform oldAT = g.getTransform();

                g.setColor(Color.BLACK);
                g.setRenderingHint(
                        RenderingHints.KEY_FRACTIONALMETRICS,
                        RenderingHints.VALUE_FRACTIONALMETRICS_ON);
                g.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g.transform(worldToScreen);

                g.setStroke(new BasicStroke(5));
                g.draw(innerField);
                
                g.rotate((Math.PI / 2) * -0.5, _innerBoardLength/2, _innerBoardLength/2);
                BaseField.DrawCenteredString(g, "MONOPOLY", innerField, BaseField.DEFAULT_FONT.deriveFont(250.0f));
                g.setTransform(worldToScreen);
                
                g.rotate((Math.PI / 2) * 1.5, _innerBoardLength - _innerBoardLength/4, _innerBoardLength - _innerBoardLength/4);
                BaseField.DrawCenteredString(g, "COMMUNITY CHEST", innerFieldCommunity, BaseField.DEFAULT_FONT.deriveFont(40.0f));
                g.setTransform(worldToScreen);
                
                g.rotate((Math.PI / 2) * -0.5, _innerBoardLength/4, _innerBoardLength/4);
                BaseField.DrawCenteredString(g, "CHANCE", innerFieldChance, BaseField.DEFAULT_FONT.deriveFont(40.0f));
                
                g.setTransform(oldAT);
            }

        });

    }
}
