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
import Core.Player;
import GameMechanics.Settings;
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
 * Base graphics for field on game board.
 *
 * @author Michal
 */
public abstract class BaseField implements Painter {

    /**
     * Base Place instance for core logic.
     */
    protected BasePlace _place;

    /**
     * Field number.
     */
    protected int _number;

    /**
     * Width of element on board.
     */
    protected int width;

    /**
     * Height of element on board.
     */
    protected int height;

    /**
     * X offset of top left corner of the field in game board Viewer.
     */
    protected int xOffset;

    /**
     * Y offset of top left corner of the field in game board Viewer.
     */
    protected int yOffset;

    /**
     * Field tilt on game board.
     */
    protected String _align;

    /**
     * Field tilt on game board. 0 - 0 degres upwards 1 - 90 geres left 2 - 180
     * degres , upside down 3 - 270 degres right
     */
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

    //todo movement animation
    /**
     * Draw player counter on field
     *
     * @param player
     */
    public void DrawPlayer(Player player) {
        player.getCounterPanel().setRotate(rotate);
        switch (rotate) {
            case 0:
                player.getCounterPanel().setxOffset(xOffset);
                player.getCounterPanel().setyOffset(yOffset + player.getPlayerNumber() * Settings.SizeOfIconOnBoard + 50);
                break;
            case 1:
                player.getCounterPanel().setxOffset(xOffset - player.getPlayerNumber() * Settings.SizeOfIconOnBoard - 50);
                player.getCounterPanel().setyOffset(yOffset);
                break;
            case 2:
                player.getCounterPanel().setxOffset(xOffset);
                player.getCounterPanel().setyOffset(yOffset - player.getPlayerNumber() * Settings.SizeOfIconOnBoard - 50);
                break;
            case 3:
                player.getCounterPanel().setxOffset(xOffset + player.getPlayerNumber() * Settings.SizeOfIconOnBoard + 50);
                player.getCounterPanel().setyOffset(yOffset);
                break;
        }
    }

    /**
     * Write field name below street color rectangle.
     *
     * @param g
     */
    protected void SetFieldName(Graphics2D g) {
        Font oldFont = g.getFont();
        g.setRenderingHint(
                RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.BLACK);
        g.setFont(Settings.DEFAULT_FONT);
        DrawMultiLineString(g, _place.toString(), xOffset + 20, yOffset + 95);
        g.setFont(oldFont);
    }

    /**
     * Draw place price in bottom line of field.
     * @param g
     * @param price
     */
    protected void SetPrice(Graphics2D g, int price) {
        Font oldFont = g.getFont();
        g.setRenderingHint(
                RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.BLACK);
        g.setFont(Settings.DEFAULT_FONT);
        g.drawString(String.format("cena %s$", price), xOffset + 20, yOffset + 260);
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
        g.setStroke(new BasicStroke(5));
        g.setColor(_place.BorderColor());
        g.draw(border);
    }

}
