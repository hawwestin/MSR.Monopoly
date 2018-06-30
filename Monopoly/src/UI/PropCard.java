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

import GameMechanics.FieldAlign;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Abstract property card of an buyable place to be displayed in player wallet
 * box after he buy the place. Implements Mouse listner for mock button area for
 * player interaction with property card like sell or construct.
 *
 * @author Michal
 */
public abstract class PropCard implements MouseListener {

    /**
     * Card pricing text
     */
    protected String _propMsg;

    /**
     *
     */
    protected Rectangle2D SellButton;

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

    /**
     * Top left corner of point around which card should be rotate. For prperty
     * Card should be top left corner of player wallet box.
     */
    protected Point2D _cardAnchor;

    /**
     * Set message to be dispalyed on property card.
     *
     * @param propMsg
     */
    public void setPropMsg(String propMsg) {
        _propMsg = propMsg;
    }

    /**
     * Set x offset of top left corner of place in player wallet box
     *
     * @param x
     */
    public void SetXOffset(int x) {
        xOffset = x;

    }

    /**
     * Set y offset of top left corner of place in player wallet box
     *
     * @param y
     */
    public void SetYOffset(int y) {
        yOffset = y;

    }

    /**
     * Set property alignment in the game world.
     *
     * @param align
     */
    public void setRotate(FieldAlign align) {
        rotate = align;

    }

    /**
     * Get graphics to draw property card around game borad.
     *
     * @param align
     * @param x
     * @param cardAnchor
     * @param y
     * @return
     */
    public PropCard MakePropertyCard(FieldAlign align, int x, int y, Point2D cardAnchor) {
        rotate = align;
        xOffset = x;
        yOffset = y;
        _cardAnchor = cardAnchor;
        return this;
    }

    /**
     * Draw property card in game world for given Graphics painter
     *
     * @param g
     */
    public abstract void paint(Graphics2D g);

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
