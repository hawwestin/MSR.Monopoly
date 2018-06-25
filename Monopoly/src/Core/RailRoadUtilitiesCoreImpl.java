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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Railroad context for all 4 fields to compute rent
 *
 * @author Michal
 */
public class RailRoadUtilitiesCoreImpl extends UtilitiesCore {

    private static ArrayList<RailRoadUtilitiesCoreImpl> _railroad = new ArrayList<RailRoadUtilitiesCoreImpl>();

    /**
     * create new Railroad object with given name and base price.
     *
     * @param name
     * @param price
     */
    public RailRoadUtilitiesCoreImpl(String name, int price) {
        super(name, price);
        _railroad.add(this);        
        _rent = 25;
        
        StringBuilder propmsg = new StringBuilder();
        propmsg.append(String.format("%-35s", "RENT"));
        propmsg.append(String.format("%5d$</br>", 25));
        propmsg.append(String.format("%-27s", "If 2 Stations are owned"));
        propmsg.append(String.format("%5d$</br>", 50));
        propmsg.append(String.format("%-25s", "If 3 Stations are owned"));
        propmsg.append(String.format("%5d$</br>", 100));
        propmsg.append(String.format("%-25s", "If 4 Stations are owned"));
        propmsg.append(String.format("%5d$</br>", 200));
        
        _propertyCard.setPropMsg(propmsg.toString());
        
    }

    @Override
    public int getRent() {
        Map< Player, Integer> map = new HashMap<>();
        for (RailRoadUtilitiesCoreImpl rail : _railroad) {
            if (map.containsKey(rail.owner)) {
                map.put(rail.owner, map.get(rail.owner) + 1);
            } else {
                map.put(rail.owner, 1);
            }
        }
        return (int) (_rent * Math.pow(2, map.get(owner) - 1));

    }

}
