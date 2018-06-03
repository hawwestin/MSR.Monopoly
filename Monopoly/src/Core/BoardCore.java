/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.HashMap;
import java.util.Iterator;
import Core.StreetsNames;
import java.awt.Color;

/**
 *
 * @author Michal
 */
public class BoardCore implements Iterable<BasePlace> {

    private StreetsNames game;
    //board hold info about player possition.
    //Lista ulic na zasadzie pętlii. po powrocie na poczatek petli inkasacja kasy 
    public final HashMap<Integer, BasePlace> streets = MakeStreets();
    //make Each Border like JumpManager hashmap () One list with lota constructors . 

    public BoardCore() {
        game = new StreetsNames();
    }

    @Override
    public Iterator<BasePlace> iterator() {
        return new Iterator<BasePlace>() {
            @Override
            public boolean hasNext() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public BasePlace next() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

    }

    private HashMap<Integer, BasePlace> MakeStreets() {
        HashMap<Integer, BasePlace> map = new HashMap<Integer, BasePlace>();

        map.put(0, new CornerCore("Go"));
        map.put(10, new CornerCore("In Jail"));
        map.put(20, new CornerCore("Free"));
        map.put(30, new CornerCore("Go to Jail"));

        //railroad
        map.put(5, new UtielietiesCore("RailRoad 1"));
        map.put(15, new UtielietiesCore("RailRoad 2"));
        map.put(25, new UtielietiesCore("RailRoad 3"));
        map.put(35, new UtielietiesCore("RailRoad 4"));

        //chance & others
        map.put(2, new UtielietiesCore("Comunity Chest"));
        map.put(4, new UtielietiesCore("Income Tax"));
        map.put(7, new UtielietiesCore("Chance"));
        map.put(12, new UtielietiesCore("Electric"));
        map.put(17, new UtielietiesCore("Comunity Chest"));
        map.put(22, new UtielietiesCore("Chance"));
        map.put(28, new UtielietiesCore("Water"));
        map.put(33, new UtielietiesCore("Comunity Chest"));
        map.put(36, new UtielietiesCore("Chance"));
        map.put(38, new UtielietiesCore("TAX"));
        
        
        //Brown street
        map.put(1,new StreetCore("mediter", Color.darkGray));
        map.put(3,new StreetCore("Balitc", Color.darkGray));

        //white 
        map.put(6,new StreetCore("Ortinal", Color.WHITE));
        map.put(8,new StreetCore("Vermount", Color.WHITE));
        map.put(9,new StreetCore("Connect", Color.WHITE));
        
        //purple
        map.put(11,new StreetCore("St.Charles", Color.PINK));
        map.put(13,new StreetCore("States", Color.PINK));
        map.put(14,new StreetCore("Virginia", Color.PINK));
        
        //orange
        map.put(16,new StreetCore("St. James", Color.ORANGE));
        map.put(18,new StreetCore("Tennessee", Color.ORANGE));
        map.put(19,new StreetCore("New York", Color.ORANGE));
        
        //red
        map.put(21,new StreetCore("Kentucky", Color.RED));
        map.put(23,new StreetCore("Indiana", Color.RED));
        map.put(24,new StreetCore("Illinois", Color.RED));
        
        //yellow
        map.put(26,new StreetCore("Atlantic", Color.YELLOW));
        map.put(27,new StreetCore("Venteor", Color.YELLOW));
        map.put(29,new StreetCore("Marvin", Color.YELLOW));
        
        //green
        map.put(31,new StreetCore("Pacific", Color.GREEN));
        map.put(32,new StreetCore("N Cor", Color.GREEN));
        map.put(34,new StreetCore("Pennsylvania", Color.GREEN));
        
        //blue
        map.put(37,new StreetCore("Park", Color.BLUE));
        map.put(39,new StreetCore("Board", Color.BLUE));
        
        
        return map;
    }

}
