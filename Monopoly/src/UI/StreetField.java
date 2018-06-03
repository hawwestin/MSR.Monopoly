/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.BasePlace;
import Core.StreetCore;
import Viewer.Painter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

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
        Rectangle2D border = new Rectangle2D.Double(xOffset, yOffset, width, hight);
        AffineTransform oldAT = g.getTransform();
        g.transform(worldToScreen);        
        g.draw(border);
        g.drawRect(xOffset, yOffset, width, 40);
        g.setColor(_place.color);
        g.fillRect(xOffset, yOffset, width, 40);
        g.setColor(Color.BLACK);
        g.drawString(_place.toString(), xOffset + 20, yOffset + 75);
        g.rotate((Math.PI / 2) * rotate);        
        g.setTransform(oldAT);
    }
}
