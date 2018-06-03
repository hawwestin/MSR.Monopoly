/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.BasePlace;
import Viewer.Painter;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author michal
 */
public class UtilitiesPlace extends BaseField implements Painter{
    
    public UtilitiesPlace(BasePlace place, int number, int x, int y, String align) {
        super(place, number, x, y, align);
    }

    @Override
    public void paint(Graphics2D g, AffineTransform worldToScreen, double w, double h) {
        Rectangle2D border = new Rectangle2D.Double(xOffset, yOffset, width, hight);
        AffineTransform oldAT = g.getTransform();
        g.transform(worldToScreen);
        g.draw(border);
        g.drawString(super._place.toString(), xOffset + 10, yOffset + 30);
        g.rotate((Math.PI / 2) * rotate, super.SeedCorner().get(0), super.SeedCorner().get(1));
        g.setTransform(oldAT);
    }
    
}
