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

import Core.BasePlace;
import GameMechanics.FieldAlign;
import Viewer.Painter;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 * Graphics for action firled on game board.
 * @author michal
 */
public class ActionField extends BaseField implements Painter {    

    /**
     * Initialize action field for game board.
     * @param place
     * @param number
     * @param x
     * @param y
     * @param align
     */
    public ActionField(BasePlace place, int number, int x, int y, FieldAlign align) {
        super(place, number, x, y, align);
        
    }
        
    @Override
    public void paint(Graphics2D g, AffineTransform worldToScreen, double w, double h) {       
        AffineTransform oldAT = g.getTransform();
        g.transform(worldToScreen);
        super.paint(g, worldToScreen, w, h);
        SetFieldName(g);               
        
        g.setTransform(oldAT);
    }

}
