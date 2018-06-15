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

/**
 * Streets Order based on theirs Names.
 * @author Michal
 */
public class StreetsNames {
    
    /**
     * Street names in order on the game board
     */
    private static final ArrayList<String> StreetName = InitNameList();    

    /**
     * Names of the street of current game version
     * @return
     */
    public static ArrayList<String> getStreetName() {
        return StreetName;
    }    
    
    private static ArrayList<String> InitNameList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Go");
        list.add("mediter");
        list.add("Comunity Chest");
        list.add("Balitc");
        list.add("Income Tax");
        list.add("Railroad 1");

        list.add("Ortinal");
        list.add("Chance");
        list.add("Vermount");
        list.add("Connect");
        list.add("In Jail");

        list.add("St.Charles");
        list.add("Electric");
        list.add("States");
        list.add("Virginia");
        list.add("Reilroad 2");//15

        list.add("St. James");
        list.add("ComunityChest");
        list.add("Tennessee");
        list.add("New York");
        list.add("Free");//20

        list.add("Kentucky");
        list.add("Chance");
        list.add("Indiana");
        list.add("Illinois");
        list.add("Railroad 3");//25

        list.add("Atlantic");
        list.add("Venteor");
        list.add("Water");
        list.add("Marvin");
        list.add("Go TO Jail");

        list.add("Pacific");
        list.add("N Cor");
        list.add("Comunity Chest");
        list.add("Pennsylvania");
        list.add("Railroad 4");

        list.add("Chance");
        list.add("Park");
        list.add("Tax");
        list.add("Board");
        return list;
    }

}
