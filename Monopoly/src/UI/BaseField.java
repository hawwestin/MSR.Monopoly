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
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Michal
 */
public class BaseField implements Painter {

    public static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 20);

    protected BasePlace _place;
    protected int _number;
    protected int width;
    protected int height;
    protected int xOffset;
    protected int yOffset;
    protected String _align;
    protected int rotate;

    //Ractangel Dimension

    /**
     *
     * @param place
     * @param number
     * @param x
     * @param y
     * @param align
     */
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
        Font oldFont = g.getFont();
        g.setRenderingHint(
                RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.BLACK);
        g.setFont(DEFAULT_FONT);
        DrawMultiLineString(g, _place.toString(), xOffset + 20, yOffset + 95);
        g.setFont(oldFont);
    }

    protected void SetPrice(Graphics2D g) {
        Font oldFont = g.getFont();
        g.setRenderingHint(
                RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.BLACK);
        g.setFont(DEFAULT_FONT);
        String price = "cena $" + _place.Price();
        g.drawString(price, xOffset + 20, yOffset + 260);
        g.setFont(oldFont);
    }

    /**
     * Draw a String centered in the middle of a Rectangle.
     *
     * @param g The Graphics instance.
     * @param text The String to draw.
     * @param rect The Rectangle2D to center the text in.
     * @param font The Font class for text.
     */
    public static void DrawCenteredString(Graphics2D g, String text, Rectangle2D rect, Font font) {
        FontRenderContext frc = new FontRenderContext(null, true, true);
        g.setRenderingHint(
                RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Rectangle2D textBoundry = font.getStringBounds(text, frc);
        int textBoundryWidth = (int) Math.round(textBoundry.getWidth());
        int textBoundryHeight = (int) Math.round(textBoundry.getHeight());
        int textBoundryX = (int) Math.round(textBoundry.getX());
        int textBoundryY = (int) Math.round(textBoundry.getY());

        int xOffset = (int) Math.round((rect.getWidth() / 2) - (textBoundryWidth / 2) - textBoundryX);
        int yOffset = (int) Math.round((rect.getHeight() / 2) - (textBoundryHeight / 2) - textBoundryY);

        g.setFont(font);
        g.drawString(text, Math.round(rect.getX() + xOffset), Math.round(rect.getY() + yOffset));
    }

    void DrawMultiLineString(Graphics2D g, String text, int x, int y) {
        for (String line : text.split(" ")) {
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
        }
    }

    @Override
    public void paint(Graphics2D g, AffineTransform worldToScreen, double w, double h) {
        Rectangle2D border = new Rectangle2D.Double(xOffset, yOffset, width, height);
        g.rotate((Math.PI / 2) * rotate, xOffset, yOffset);
        g.setStroke(new BasicStroke(3));
        g.draw(border);
    }

}
