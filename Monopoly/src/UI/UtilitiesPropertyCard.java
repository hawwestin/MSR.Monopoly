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

import Core.UtilitiesCore;
import GameMechanics.FieldAlign;
import GameMechanics.Settings;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Michal
 */
public class UtilitiesPropertyCard implements IPropCard {

    private UtilitiesCore _place;
    private String _propMsg;

    private Rectangle2D SellButton;
    /**
     * X offset of top left corner of the field in game board Viewer.
     */
    protected int xOffset;

    /**
     * Y offset of top left corner of the field in game board Viewer.
     */
    protected int yOffset;

    /**
     * Field tilt on game board. 0 - 0 degres upwards 1 - 90 geres left 2 - 180
     * degres , upside down 3 - 270 degres right
     */
    protected FieldAlign rotate;
    /**
     * Width of element on board.
     */
    protected int width = 175;

    /**
     * Height of element on board.
     */
    protected int height = 280;

    private Point2D _cardAnchor;

    public UtilitiesPropertyCard(UtilitiesCore place) {
        _place = place;
    }

    public void setPropMsg(String propMsg) {
        _propMsg = propMsg;
    }

    @Override
    public IPropCard MakePropertyCard(FieldAlign align, int x, int y, Point2D cardAnchor) {
        rotate = align;
        xOffset = x;
        yOffset = y;

        _cardAnchor = cardAnchor;
        return this;
    }

    public void paint(Graphics2D g) {

        Rectangle2D border = new Rectangle2D.Double(xOffset, yOffset, width, height);
        Rectangle2D txtBorder = new Rectangle2D.Double(xOffset, yOffset, width, (height - 35));

        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(5));
        g.draw(border);

        g.setStroke(new BasicStroke(3));
        g.drawRect(xOffset, yOffset, width, 50);
        g.fillRect(xOffset + 1, yOffset + 1, width - 3, 48);

        BaseField.DrawMultiLineString(g, _place.toString(), xOffset, yOffset, width, (height - 35) / 2, Settings.DEFAULT_FONT);
        BaseField.DrawMultiLineString(g, _propMsg, txtBorder, Settings.DEFAULT_FONT.deriveFont(12f));

        SellButton = new Rectangle2D.Double(xOffset, yOffset + height - 35, width, 35);
        g.setStroke(new BasicStroke(3f));
        g.setColor(Color.BLACK);
        g.draw(SellButton);
        BaseField.DrawCenteredString(g, "Sell", SellButton, Settings.DEFAULT_FONT.deriveFont(12f));

    }

    @Override
    public void SetXOffset(int x) {
        xOffset = x;

    }

    @Override
    public void SetYOffset(int y) {
        yOffset = y;

    }

    @Override
    public void setRotate(FieldAlign align) {
        rotate = align;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (_place.getOwner() == null) {
            return;
        }
        Point2D worldPoint = Board.getSingleton().ScreenToWorldPoint(e.getPoint());

        Rectangle2D transformClick = new Rectangle2D.Double(worldPoint.getX(),
                worldPoint.getY(), 1, 1);

        AffineTransform at = AffineTransform.getRotateInstance((Math.PI / 2) * -rotate.ordinal(), _cardAnchor.getX(), _cardAnchor.getY());
        Shape s = at.createTransformedShape(transformClick);
        transformClick = s.getBounds2D();

        if (SellButton != null) {
            if ((e.getButton() == 1) && SellButton.contains(transformClick.getX(), transformClick.getY())) {
                System.err.println(String.format("Sell Street %s", _place.toString()));
                System.err.println(String.format("x %d", e.getX()));
                System.err.println(String.format("y %d", e.getY()));
            }
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
