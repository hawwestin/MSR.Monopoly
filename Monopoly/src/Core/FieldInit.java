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
package Core;

import GameMechanics.Constructions;
import java.util.HashMap;
import java.util.Map;

/**
 * A set of values for payments that can be made on the.
 *
 * @author Michal
 */
public class FieldInit {

    private final int price;
    private final int rent;
    private final int house1;
    private final int house2;
    private final int house3;
    private final int house4;
    private final int hotel;
    private final int building;
    private final Map<Constructions, Integer> constructionRentMap;

    private Constructions _constructionLevel = Constructions.GROUND;

    /**
     * Init values of payments.
     *
     * @param price
     * @param groundRent
     * @param house1
     * @param house2
     * @param house3
     * @param house4
     * @param hotel
     * @param building
     */
    public FieldInit(int price, int groundRent, int house1, int house2, int house3, int house4, int hotel, int building) {
        this.price = price;
        this.rent = groundRent;
        this.house1 = house1;
        this.house2 = house2;
        this.house3 = house3;
        this.house4 = house4;
        this.hotel = hotel;
        this.building = building;

        constructionRentMap = new HashMap<Constructions, Integer>() {
            {
                put(Constructions.GROUND, groundRent * 2);
                put(Constructions.HOUSE1, house1);
                put(Constructions.HOUSE2, house2);
                put(Constructions.HOUSE3, house3);
                put(Constructions.HOUSE4, house4);
                put(Constructions.HOTEL, hotel);
            }
        };
    }

    /**
     * Get Agregated Payments map
     *
     * @return
     */
    public Map<Constructions, Integer> getConstructionRentMap() {
        return constructionRentMap;
    }

    /**
     * Get Field price
     *
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * Get Field Defaul ground rent value.
     *
     * @return
     */
    public int getRent() {
        return rent;
    }

    /**
     * get price of single building construcion.
     *
     * @return
     */
    public int getBuilding() {
        return building;
    }

    public boolean hasNext() {
        return _constructionLevel.ordinal() < Constructions.HOTEL.ordinal();
    }

    /**
     * * Get next Construction level
     *
     * @return
     */
    public Constructions getNext() {
        if (hasNext()) {
            _constructionLevel = Constructions.values()[_constructionLevel.ordinal() + 1];
        }
        return _constructionLevel;
    }

    private boolean hasPrev() {
        return _constructionLevel.ordinal() > Constructions.GROUND.ordinal();
    }

    /**
     * Get previous Construction level
     *
     * @return
     */
    public Constructions getPrev() {
        if (hasPrev()) {
            _constructionLevel = Constructions.values()[_constructionLevel.ordinal() - 1];
        }
        return _constructionLevel;
    }

}
