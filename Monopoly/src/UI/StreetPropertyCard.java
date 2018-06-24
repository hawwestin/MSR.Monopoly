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

import Core.StreetCore;
import GameMechanics.FieldAlign;
import GameMechanics.Settings;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

/**
 *
 * @author Michal
 */
public class StreetPropertyCard extends JComponent implements IPropCard {

    private final StreetCore _place;

    private Rectangle2D SellButton;
    private Rectangle2D ConstructButton;
    private AffineTransform screenToWorld;

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

    private Point2D cardAnchor;

    /**
     *
     * @param place
     */
    public StreetPropertyCard(StreetCore place) {
        this._place = place;
//        this.addMouseListener(this);
    }

    @Override
    public IPropCard MakePropertyCard(FieldAlign align, int x, int y, AffineTransform worldToScreen) {
        rotate = align;
        xOffset = x;
        yOffset = y;
        screenToWorld = worldToScreen;
        //additional offset for street allignment in Property Box of a player. 
        //for each in player property and print them ? With separate .. and color grouping ?
        return this;
    }

    public void paint(Graphics2D g) {
        screenToWorld = g.getTransform();
        Rectangle2D border = new Rectangle2D.Double(xOffset, yOffset, width, height);
        g.setStroke(new BasicStroke(5f));
        g.setColor(Color.BLACK);
        g.draw(border);

        g.setStroke(new BasicStroke(3f));
        g.drawRect(xOffset, yOffset, width, 50);
        g.setColor(_place.getColor());
        g.fillRect(xOffset + 1, yOffset + 1, width - 3, 48);

        g.setColor(Color.BLACK);
        BaseField.DrawMultiLineString(g, _place.toString(), xOffset, yOffset, width, height / 2, Settings.DEFAULT_FONT);

        SellButton = new Rectangle2D.Double(xOffset, yOffset + height - 35, width / 2, 35);
        g.setStroke(new BasicStroke(3f));
        g.setColor(Color.BLACK);
        g.draw(SellButton);
        BaseField.DrawCenteredString(g, "Sell", SellButton, Settings.DEFAULT_FONT.deriveFont(12f));

        ConstructButton = new Rectangle2D.Double(xOffset + (width / 2), yOffset + height - 35, width / 2, 35);
        g.setStroke(new BasicStroke(3f));
        g.setColor(Color.BLACK);
        g.draw(ConstructButton);
        BaseField.DrawCenteredString(g, "Construct", ConstructButton, Settings.DEFAULT_FONT.deriveFont(12f));

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

    private Point2D PressedPointToWorld(Point2D point) {
        Point2D worldPoint = Board.getSingleton().ScreenToWorldPoint(point);
        return screenToWorld.transform(worldPoint, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //click in sell & is owner & Construcion is grtoud else textLog
        //click in COnstruct & is owner & has whole color else textLog      
        if (_place.getOwner() == null) {
            return;
        }
        Point2D worldPoint = Board.getSingleton().ScreenToWorldPoint(e.getPoint());

        if (SellButton != null) {
            if ((e.getButton() == 1) && SellButton.contains(worldPoint.getX(), worldPoint.getY())) {
                System.err.println(String.format("x %d", e.getX()));
                System.err.println(String.format("y %d", e.getY()));
            }
        }
        if (ConstructButton != null) {
            if ((e.getButton() == 1) && ConstructButton.contains(worldPoint.getX(), worldPoint.getY())) {
                System.err.println(String.format("x %d", e.getX()));
                System.err.println(String.format("y %d", e.getY()));
            }
        }
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
