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
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Michal
 */
public class BaseField implements Painter {

    protected BasePlace _place;
    protected int _number;
    protected int width;
    protected int hight;
    protected int xOffset;
    protected int yOffset;
    protected String _align;
    protected int rotate;

    //Ractangel Dimension
    public BaseField(BasePlace place, int number, int x, int y, String align) {
        _place = place;
        _number = number;
        xOffset = x;
        yOffset = y;
        _align = align;

//        setToolTipText(place.toString());       
        if (_align.equals("up") || _align.equals("down")) {
            width = 175;
            hight = 280;
            if (_align.equals("up")) {
                rotate = 0;
            } else {
                rotate = 2;
            }

        } else if (_align.equals("left") || _align.equals("right")) {
            width = 280;
            hight = 175;
            if (_align.equals("left")) {
                rotate = 1;
            } else {
                rotate = 3;
            }

        }

    }

    @Override
    public void paint(Graphics2D g, AffineTransform worldToScreen, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
