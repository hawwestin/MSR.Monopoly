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
import GameMechanics.Constructions;
import GameMechanics.FieldAlign;
import GameMechanics.Icon;
import Viewer.Painter;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.HashMap;

/**
 * Street field graphics on game board
 *
 * @author Michal
 */
public class StreetField extends BaseField implements Painter {

    private final StreetCore _place;
    private final HashMap<Constructions, ImagePanel> _buildings = MakeBuildingMap();

    /**
     * New graphics of street field
     *
     * @param place
     * @param number
     * @param x
     * @param y
     * @param align
     */
    public StreetField(StreetCore place, int number, int x, int y, FieldAlign align) {
        super(place, number, x, y, align);
        this._place = place;
    }

    public HashMap<Constructions, ImagePanel> getBuildings() {
        return _buildings;
    }

    private HashMap<Constructions, ImagePanel> MakeBuildingMap() {
        Point buildingDimension = new Point(35, 40);

        HashMap<Constructions, ImagePanel> map = new HashMap<Constructions, ImagePanel>() {
            {
                put(Constructions.HOUSE1, new ImagePanel(xOffset, yOffset, Icon.getBuildingIconMap().get("House"), "House1"));
                put(Constructions.HOUSE2, new ImagePanel(xOffset, yOffset, Icon.getBuildingIconMap().get("House"), "House2"));
                put(Constructions.HOUSE3, new ImagePanel(xOffset, yOffset, Icon.getBuildingIconMap().get("House"), "House3"));
                put(Constructions.HOUSE4, new ImagePanel(xOffset, yOffset, Icon.getBuildingIconMap().get("House"), "House4"));
                put(Constructions.HOTEL, new ImagePanel(xOffset, yOffset, Icon.getBuildingIconMap().get("Hotel"), "Hotel"));
            }
        };

        map.forEach((x, ipanel) -> {
            ipanel.Resize((int) buildingDimension.getX(), (int) buildingDimension.getY());
        });
        map.forEach((x, ipanel) -> {
            ipanel.setRotate(rotate);
        });

        map.forEach((x, ipanel) -> {
            int index = x.ordinal() - 1;
            switch (rotate) {
                case UP:
                    ipanel.setxOffset(xOffset + index * (int) buildingDimension.getX());
                    ipanel.setyOffset(yOffset);
                    break;
                case LEFT:
                    ipanel.setxOffset(xOffset);
                    ipanel.setyOffset(yOffset + index * (int) buildingDimension.getX());
                    break;
                case DOWN:
                    ipanel.setxOffset(xOffset - index * (int) buildingDimension.getX());
                    ipanel.setyOffset(yOffset);
                    break;
                case RIGHT:
                    ipanel.setxOffset(xOffset);
                    ipanel.setyOffset(yOffset - index * (int) buildingDimension.getX());
                    break;
            }
        });

        return map;
    }

    @Override
    public void paint(Graphics2D g, AffineTransform worldToScreen, double w, double h) {
        AffineTransform oldAT = g.getTransform();
        g.transform(worldToScreen);
        super.paint(g, worldToScreen, w, h);

        g.setStroke(new BasicStroke(3));
        g.drawRect(xOffset, yOffset, width, 50);
        g.setColor(_place.getColor());
        g.fillRect(xOffset + 1, yOffset + 1, width - 3, 48);

        SetFieldName(g);
        SetPrice(g, _place.getPrice());

        g.setTransform(oldAT);

    }
}
