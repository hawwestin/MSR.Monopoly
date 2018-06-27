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

import Core.StreetCore;
import GameMechanics.FieldAlign;
import GameMechanics.PlayersLoop;
import GameMechanics.Settings;
import GameMechanics.Start;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Michal
 */
public class StreetPropertyCard extends PropCard {

    private final StreetCore _place;

    private Rectangle2D ConstructButton;

    /**
     *
     * @param place
     */
    public StreetPropertyCard(StreetCore place) {
        super();
        this._place = place;
    }

    @Override
    public void paint(Graphics2D g) {
        Rectangle2D border = new Rectangle2D.Double(xOffset, yOffset, width, height);
        Rectangle2D txtBorder = new Rectangle2D.Double(xOffset, yOffset, width, height * 0.65);

        g.setStroke(new BasicStroke(5f));
        g.setColor(Color.BLACK);
        g.draw(border);

        g.setStroke(new BasicStroke(3f));
        g.drawRect(xOffset, yOffset, width, 50);
        g.setColor(_place.getColor());
        g.fillRect(xOffset + 1, yOffset + 1, width - 3, 48);

        g.setColor(Color.BLACK);
        BaseField.DrawMultiLineString(g, _place.toString(), xOffset, yOffset, width, (int) (height * 0.5), Settings.DEFAULT_FONT);
        BaseField.DrawMultiLineString(g, _propMsg, txtBorder, Settings.DEFAULT_FONT.deriveFont(12f));

        SellButton = new Rectangle2D.Double(xOffset, yOffset + height - 35, width / 2, 35);
        g.setStroke(new BasicStroke(3f));
        g.setColor(Color.BLACK);
        g.draw(SellButton);
        BaseField.DrawCenteredString(g, "Sell", SellButton, Settings.DEFAULT_FONT.deriveFont(12f));

        ConstructButton = new Rectangle2D.Double(xOffset + (width / 2), yOffset + height - 35, width / 2, 35);
        g.setStroke(new BasicStroke(3f));
        g.setColor(Color.BLACK);
        g.draw(ConstructButton);
        BaseField.DrawCenteredString(g, "Construct", ConstructButton, Settings.DEFAULT_FONT.deriveFont(12f));

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //click in COnstruct & is owner & has whole color else textLog      
        if (_place.getOwner() == null) {
            return;
        }
        Point2D worldPoint = Board.getSingleton().ScreenToWorldPoint(e.getPoint());

        Rectangle2D transformClick = new Rectangle2D.Double(worldPoint.getX(),
                worldPoint.getY(), 1, 1);

        AffineTransform at = AffineTransform.getRotateInstance((Math.PI / 2) * -super.rotate.ordinal(), super._cardAnchor.getX(), super._cardAnchor.getY());
        Shape s = at.createTransformedShape(transformClick);
        transformClick = s.getBounds2D();

        if (SellButton != null) {
            if ((e.getButton() == 1) && SellButton.contains(transformClick.getX(), transformClick.getY())) {                
                if (PlayersLoop.getCurrentPlayer() == _place.getOwner()) {                    
                    if (_place.getOwner().getBoardPlace() == _place.getBaseFiled().getNumber()) {
                        _place.Sell();
                        if (_place.getOwner() == null) {
                            Start.getGame().EnableBuyButton();
                        }
                    } else {
                        _place.Sell();
                    }
                }
            }
        }
        if (ConstructButton != null) {
            if ((e.getButton() == 1) && ConstructButton.contains(transformClick.getX(), transformClick.getY())) {
                System.err.println(String.format("Construct Street %s", _place.toString()));
                System.err.println(String.format("x %d", e.getX()));
                System.err.println(String.format("y %d", e.getY()));
            }
        }
    }

}
