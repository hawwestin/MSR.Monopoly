/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.ArrayList;

/**
 * Streets Order based on theirs Names.
 * @author Michal
 */
public class StreetsNames {
    
    /**
     * Street names array for order
     */
    private static final ArrayList<String> StreetName = InitNameList();    

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
