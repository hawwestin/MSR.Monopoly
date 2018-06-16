/*
 * The MIT License
 *
 * Copyright 2018 Michal.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package UI;

import Core.BoardCore;
import Core.Player;
import GameMechanics.PlayersLoop;
import GameMechanics.Settings;
import Viewer.Painter;
import Viewer.Viewer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Main grapihics of board game initializer
 *
 * @author Michal
 */
public class Board {

    private Viewer _viewer;
    private int _innerBoardLength;

    /**
     * Create ne board instance
     *
     * @param view
     */
    public Board(Viewer view) {
        _viewer = view;

        makeTiles(1);
        makeInnerBoard(1);
        //szablon
//        ImagePanel map = new ImagePanel(_innerBoardLength - 280, _innerBoardLength - 280, "img/Monopoly-Board.jpg");
//        _viewer.addPainter(map, 0); //ToDO Board Image as option as thing to by played or clean graphics.
        // Player Icons should be top layer np 9.  All graphics is 1 so to board by on to set 2

        ResetWorldView();        
    }

    /**
     * return width of inner board field square
     *
     * @return
     */
    public int getInnerBoardLength() {
        return _innerBoardLength;
    }
    
    /**
     * Reset world camera to defaul view
     */
    public void ResetWorldView(){
        _viewer.resetTransform();
        _viewer.setDisplayedWorldArea(_innerBoardLength-300, _innerBoardLength-300, 300-_innerBoardLength, 300-_innerBoardLength);
    }

    /**
     * Force Repaint of the board after element was changed.
     */
    public void Repaint() {
        _viewer.repaint();
    }

    private void makeTiles(int layer) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < 10; i++) {
            _viewer.addPainter(BoardCore.getFieldsOnBoard().get(i).makeField(i, x, y, "up"), layer);
            x -= 175;
        }
        x += 175;
        _innerBoardLength = x;
        for (int i = 10; i < 20; i++) {
            _viewer.addPainter(BoardCore.getFieldsOnBoard().get(i).makeField(i, x, y, "left"), layer);
            y -= 175;
        }
        y += 175;
        for (int i = 20; i < 30; i++) {
            _viewer.addPainter(BoardCore.getFieldsOnBoard().get(i).makeField(i, x, y, "down"), layer);
            x += 175;
        }
        x -= 175;
        for (int i = 30; i < 40; i++) {
            _viewer.addPainter(BoardCore.getFieldsOnBoard().get(i).makeField(i, x, y, "right"), layer);
            y += 175;
        }

    }

    private void makeInnerBoard(int layer) {
        _viewer.addPainter(new Painter() {
            @Override
            public void paint(Graphics2D g, AffineTransform worldToScreen, double w, double h) {
                Rectangle2D innerField = new Rectangle2D.Double(_innerBoardLength, _innerBoardLength, -_innerBoardLength, -_innerBoardLength);
                Rectangle2D innerFieldCommunity = new Rectangle2D.Double(_innerBoardLength, _innerBoardLength, -_innerBoardLength / 2, -_innerBoardLength / 2);
                Rectangle2D innerFieldChance = new Rectangle2D.Double(_innerBoardLength / 2, _innerBoardLength / 2, -_innerBoardLength / 2, -_innerBoardLength / 2);

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

                g.rotate((Math.PI / 2) * -0.5, _innerBoardLength / 2, _innerBoardLength / 2);
                BaseField.DrawCenteredString(g, "MONOPOLY", innerField, Settings.DEFAULT_FONT.deriveFont(250.0f));
                g.setTransform(worldToScreen);

                g.rotate((Math.PI / 2) * 1.5, _innerBoardLength - _innerBoardLength / 4, _innerBoardLength - _innerBoardLength / 4);
                BaseField.DrawCenteredString(g, "COMMUNITY CHEST", innerFieldCommunity, Settings.DEFAULT_FONT.deriveFont(40.0f));
                g.setTransform(worldToScreen);

                g.rotate((Math.PI / 2) * -0.5, _innerBoardLength / 4, _innerBoardLength / 4);
                BaseField.DrawCenteredString(g, "CHANCE", innerFieldChance, Settings.DEFAULT_FONT.deriveFont(40.0f));

                g.setTransform(oldAT);
            }

        }, layer);
    }

    /**
     * After players was persist in PlayersLoop draw thier corepsonding counters
     * on game board
     *
     * @param layer
     */
    public void makePlayersLayer(int layer) {
        for (Player player : PlayersLoop.getPlayers()) {
            _viewer.addPainter(player.getCounterPanel(), layer);
        }
    }

}
