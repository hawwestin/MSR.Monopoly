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

/**
 *
 * @author michal
 */
public class ActionField extends BaseField implements Painter {    

    public ActionField(BasePlace place, int number, int x, int y, String align) {
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
