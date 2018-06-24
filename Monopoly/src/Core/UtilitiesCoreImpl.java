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

import GameMechanics.Dice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for Fields like Water and electricity utilities Rent calculatiuon based
 * on dice thrown value.
 *
 * @author Michal
 */
public class UtilitiesCoreImpl extends UtilitiesCore {

    private static ArrayList<UtilitiesCoreImpl> _utilities = new ArrayList<UtilitiesCoreImpl>();

    /**
     * create new utilities object
     *
     * @param name
     * @param price
     */
    public UtilitiesCoreImpl(String name, int price) {
        super(name, price);
        _utilities.add(this);
        
        _propertyCard.setPropMsg("If one utility is owned</br>"
                + "rent is 4 times amount</br>"
                + "shown on dice</br></br>"
                + "If both utilites are owned</br>"
                + "rent is 10 timeas amount</br>"
                + "shown on dice");

    }

    @Override
    public int getRent() {

        Map< Player, Integer> map = new HashMap<>();
        for (UtilitiesCoreImpl util : _utilities) {
            if (map.containsKey(util.owner)) {
                map.put(util.owner, map.get(util.owner) + 1);
            } else {
                map.put(util.owner, 1);
            }
        }
        return ((Dice.getDice1() + Dice.getDice2()) *( map.get(owner) == 2 ? 10 : 4));

    }

    @Override
    public Player getOwner() {
        return owner;
    }
}

