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
import Viewer.Painter;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 * Street field graphics on game board
 *
 * @author Michal
 */
public class StreetField extends BaseField implements Painter {

    private StreetCore _place;

    /**
     * New graphics of street field
     * @param place
     * @param number
     * @param x
     * @param y
     * @param align
     */
    public StreetField(StreetCore place, int number, int x, int y, String align) {
        super(place, number, x, y, align);
        this._place = place;
    }

    @Override
    public void paint(Graphics2D g, AffineTransform worldToScreen, double w, double h) {
        AffineTransform oldAT = g.getTransform();
        g.transform(worldToScreen);
        super.paint(g, worldToScreen, w, h);

        g.setStroke(new BasicStroke(3));
        g.drawRect(xOffset, yOffset, width, 50);
        g.setColor(_place.getColor());
        g.fillRect(xOffset + 1, yOffset + 1, width - 3, 48);

        SetFieldName(g);
        SetPrice(g, _place.getPrice());

        g.setTransform(oldAT);

    }
}
