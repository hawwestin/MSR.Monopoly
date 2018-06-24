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
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Michal
 */
public class StreetPropertyCard implements IPropCard {

    private final StreetCore _place;

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
    }

    @Override
    public IPropCard MakePropertyCard(FieldAlign align, int x, int y) {
        rotate = align;
        xOffset = x;
        yOffset = y;

        //additional offset for street allignment in Property Box of a player. 
        //for each in player property and print them ? With separate .. and color grouping ?
        return this;
    }

    public void paint(Graphics2D g) {
        Rectangle2D border = new Rectangle2D.Double(xOffset, yOffset, width, height);
        g.setStroke(new BasicStroke(5));
        g.setColor(Color.BLACK);
        g.draw(border);

        g.setStroke(new BasicStroke(3));
        g.drawRect(xOffset, yOffset, width, 50);
        g.setColor(_place.getColor());
        g.fillRect(xOffset + 1, yOffset + 1, width - 3, 48);
        g.setColor(Color.BLACK);
        BaseField.DrawMultiLineString(g, _place.toString(), xOffset, yOffset, width, height / 2, Settings.DEFAULT_FONT);
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
}
