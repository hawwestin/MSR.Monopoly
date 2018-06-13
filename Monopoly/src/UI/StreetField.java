/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.StreetCore;
import Viewer.Painter;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Michal
 */
public class StreetField extends BaseField implements Painter {

    private StreetCore _place;

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
        g.setColor(_place.color);
        g.fillRect(xOffset+1, yOffset+1, width-2, 48);

        SetFieldName(g);
        SetPrice(g,_place.getPrice());

        g.setTransform(oldAT);
        
    }
}
