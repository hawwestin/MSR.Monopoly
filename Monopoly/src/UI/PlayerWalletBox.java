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

import Core.BuyAble;
import Core.Player;
import GameMechanics.FieldAlign;
import GameMechanics.Settings;
import Viewer.Painter;
import java.awt.BasicStroke;
import java.awt.Color;

/**
 *
 * @author Michal
 */
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

/**
 *
 * @author Michal
 */
public class PlayerWalletBox extends JComponent implements Painter {

    private final Player _owner;

    /**
     * X offset of top left corner of the field in game board Viewer.
     */
    private int xOffset;

    /**
     * Y offset of top left corner of the field in game board Viewer.
     */
    private int yOffset;

    private FieldAlign rotate;

    public PlayerWalletBox(Player owner, int x, int y) {
        _owner = owner;
        xOffset = x;
        yOffset = y;
        rotate = FieldAlign.values()[owner.getPlayerNumber()];
    }

    private void DrawPlayerName(Graphics2D g) {
        g.setColor(Color.BLACK);
        BaseField.DrawCenteredString(g, _owner.toString(),
                xOffset,
                yOffset,
                Math.abs(Board.getSingleton().getInnerBoardLength()) / 2,
                100,
                Settings.DEFAULT_FONT.deriveFont(40f));
    }

    private void DrawPlayerMonye(Graphics2D g) {
        g.setColor(Color.BLACK);
        BaseField.DrawCenteredString(g, String.format("%d$", _owner.GetMoney()),
                xOffset + Math.abs(Board.getSingleton().getInnerBoardLength()) / 2,
                yOffset,
                Math.abs(Board.getSingleton().getInnerBoardLength()) / 2,
                100,
                Settings.DEFAULT_FONT.deriveFont(40f));
    }

    private void DrawPlayerOwnedPossession(Graphics2D g) {
        int x = xOffset;
        int y = yOffset + 100;
        for (BuyAble ba : _owner.getPossession()) {
            ba.getPropCard().MakePropertyCard(rotate, x, y, new Point2D.Double(xOffset, yOffset)).paint(g);
            x += 175;
        }
    }

    private void SellAction(Graphics2D g) {

    }

    @Override
    public void paint(Graphics2D g, AffineTransform worldToScreen, double w, double h) {
        AffineTransform oldAT = g.getTransform();
        g.transform(worldToScreen);
        //Box
        Rectangle2D border = new Rectangle2D.Double(xOffset,
                yOffset,
                Math.abs(Board.getSingleton().getInnerBoardLength()),
                400);
        g.rotate((Math.PI / 2) * rotate.ordinal(), xOffset, yOffset);
        g.setStroke(new BasicStroke(10));
        g.setColor(_owner.getColor());
        g.draw(border);
        //Backgroud 

        DrawPlayerMonye(g);
        DrawPlayerName(g);
        DrawPlayerOwnedPossession(g);
        g.setColor(Color.BLACK);
        g.setTransform(oldAT);
    }

}
