/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.BasePlace;
import Viewer.Painter;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Michal
 */
public class BaseField implements Painter {

    protected BasePlace _place;
    protected int _number;
    protected int width;
    protected int height;
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

        width = 175;
        height = 280;

        if (_align.equals("up") || _align.equals("down")) {
            if (_align.equals("up")) {
                rotate = 0;
            } else {
                rotate = 2;
            }

        } else if (_align.equals("left") || _align.equals("right")) {
            if (_align.equals("left")) {
                rotate = 1;
            } else {
                rotate = 3;
            }

        }
    }

    protected void SetFieldName(Graphics2D g) {
        Font fText = new Font("Arial", Font.PLAIN, 20);
        Font oldFont = g.getFont();

        g.setColor(Color.BLACK);
        g.setFont(fText);
        g.drawString(_place.toString(), xOffset + 20, yOffset + 95);
        g.setFont(oldFont);
    }
    
    protected void SetPrice(Graphics2D g) {
        Font fText = new Font("Arial", Font.PLAIN, 20);
        Font oldFont = g.getFont();

        g.setColor(Color.BLACK);
        g.setFont(fText);
        String price = "cena $" + _place.Price();
        g.drawString(price , xOffset + 20, yOffset + 260);
        g.setFont(oldFont);
    }


    @Override
    public void paint(Graphics2D g, AffineTransform worldToScreen, double w, double h) {
        Rectangle2D border = new Rectangle2D.Double(xOffset, yOffset, width, height);
        g.rotate((Math.PI / 2) * rotate, xOffset, yOffset);
        g.setStroke(new BasicStroke(3));
        g.draw(border);
    }

}
