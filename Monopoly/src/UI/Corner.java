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
 * @author Michal
 */
public class Corner extends BaseField implements Painter {

    private int rotate;

    public Corner(BasePlace place, int number, int x, int y, String align) {
        super(place, number, x, y, align);
        width = 280;
        height = 280;

    }

    @Override
    public void paint(Graphics2D g, AffineTransform worldToScreen, double w, double h) {
        Rectangle2D border = new Rectangle2D.Double(xOffset, yOffset, width, height);
        AffineTransform oldAT = g.getTransform();
        g.transform(worldToScreen);
        super.paint(g, worldToScreen, w, h);
        g.rotate((Math.PI / 2) * -0.5, xOffset+width/2, yOffset+height/2);
        DrawCenteredString(g, _place.toString(), border, DEFAULT_FONT.deriveFont(50f));
        
        g.setTransform(oldAT);
    }

}
