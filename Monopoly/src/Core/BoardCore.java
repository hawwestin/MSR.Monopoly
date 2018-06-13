/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.HashMap;
import java.util.Iterator;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michal
 */
public class BoardCore implements Iterable<BasePlace> {

    //board hold info about player possition.
    //Lista ulic na zasadzie pętlii. po powrocie na poczatek petli inkasacja kasy 
    private int _cursor;
    private static final HashMap<Integer, BasePlace> fieldsOnBoard = MakeStreets();
    
    public BoardCore(int cursor) {
        _cursor = cursor;
    }
    
    public static HashMap<Integer, BasePlace> getFieldsOnBoard() {
        return fieldsOnBoard;
    }

    /**
     * Get Current player postion.
     *
     * @return
     */
    public int getCursor() {
        return _cursor;
    }
    
    public void setCursor(int cursor) {
        _cursor = cursor;
    }
    
    @Override
    public Iterator<BasePlace> iterator() {
        return new Iterator<BasePlace>() {
            @Override
            public boolean hasNext() {
                return true;
            }
            
            @Override
            public BasePlace next() {
                _cursor++;
                if (_cursor == getFieldsOnBoard().size()) {
                    _cursor = 0;
                }
                return getFieldsOnBoard().get(_cursor);
            }
        };
        
    }
    
    private static HashMap<Integer, BasePlace> MakeStreets() {
        HashMap<Integer, BasePlace> map = new HashMap<Integer, BasePlace>();
        
        map.put(0, new GoCornerCoreImpl("Go"));
        map.put(10, new CornerCoreImpl("In Jail"));
        map.put(20, new CornerCoreImpl("Free"));
        map.put(30, new GoToJailCornerCoreImpl("Go to Jail"));

        //railroad
        map.put(5, new RailRoadUtilitiesCoreImpl("RailRoad 1", 200));
        map.put(15, new RailRoadUtilitiesCoreImpl("RailRoad 2", 200));
        map.put(25, new RailRoadUtilitiesCoreImpl("RailRoad 3", 200));
        map.put(35, new RailRoadUtilitiesCoreImpl("RailRoad 4", 200));
        
        map.put(12, new UtilitiesCoreImpl("Electric", 150));
        map.put(28, new UtilitiesCoreImpl("Water", 150));

        //chance & others
        map.put(2, new CardActionCoreImpl("Comunity Chest"));
        map.put(4, new TaxActionCoreImpl("Income Tax 200", 200));
        map.put(7, new CardActionCoreImpl("Chance"));
        map.put(17, new CardActionCoreImpl("Comunity Chest"));
        map.put(22, new CardActionCoreImpl("Chance"));
        map.put(33, new CardActionCoreImpl("Comunity Chest"));
        map.put(36, new CardActionCoreImpl("Chance"));
        map.put(38, new TaxActionCoreImpl("TAX 100",100));

        //todo move pricing init to csv config or some Json
        //Brown street        
        map.put(1, new StreetCore("mediter", Color.darkGray,
                new FieldInit(60, 2, 10, 30, 90, 160, 250, 50)));
        map.put(3, new StreetCore("Balitc", Color.darkGray,
                new FieldInit(60, 4, 20, 60, 180, 320, 450, 50)));

        //white 
        FieldInit whiteField = new FieldInit(100, 6, 30, 90, 270, 400, 550, 50);
        map.put(6, new StreetCore("Ortinal", Color.GRAY, whiteField));
        map.put(8, new StreetCore("Vermount", Color.GRAY, whiteField));
        map.put(9, new StreetCore("Connect", Color.GRAY,
                new FieldInit(120, 8, 40, 100, 300, 450, 600, 50)));

        //purple
        FieldInit purpleField = new FieldInit(140, 10, 50, 150, 450, 625, 750, 100);
        map.put(11, new StreetCore("St.Charles", Color.PINK, purpleField));
        map.put(13, new StreetCore("States", Color.PINK, purpleField));
        map.put(14, new StreetCore("Virginia", Color.PINK,
                new FieldInit(160, 12, 60, 180, 500, 700, 900, 100)));

        //orange
        FieldInit orangeField = new FieldInit(180, 14, 70, 200, 550, 750, 950, 100);
        map.put(16, new StreetCore("St. James", Color.ORANGE, orangeField));
        map.put(18, new StreetCore("Tennessee", Color.ORANGE, orangeField));
        map.put(19, new StreetCore("New York", Color.ORANGE,
                new FieldInit(200, 16, 80, 220, 600, 800, 1000, 100)));

        //red
        FieldInit redField = new FieldInit(220, 18, 90, 250, 700, 875, 1050, 150);
        map.put(21, new StreetCore("Kentucky", Color.RED, redField));
        map.put(23, new StreetCore("Indiana", Color.RED, redField));
        map.put(24, new StreetCore("Illinois", Color.RED,
                new FieldInit(240, 20, 100, 300, 750, 925, 1100, 150)));

        //yellow
        FieldInit yellowField = new FieldInit(260, 22, 110, 330, 800, 975, 1150, 150);
        map.put(26, new StreetCore("Atlantic", Color.YELLOW, yellowField));
        map.put(27, new StreetCore("Venteor", Color.YELLOW, yellowField));
        map.put(29, new StreetCore("Marvin", Color.YELLOW,
                new FieldInit(280, 24, 120, 360, 850, 1025, 1200, 150)));

        //green
        FieldInit greenField = new FieldInit(300, 26, 130, 390, 900, 1100, 1275, 200);
        map.put(31, new StreetCore("Pacific", Color.GREEN, greenField));
        map.put(32, new StreetCore("N Cor", Color.GREEN, greenField));
        map.put(34, new StreetCore("Pennsylvania", Color.GREEN, new FieldInit(320, 28, 150, 450, 1000, 1200, 1400, 200)));

        //blue
        map.put(37, new StreetCore("Park", Color.BLUE, new FieldInit(350, 35, 175, 500, 1100, 1300, 1500, 200)));
        map.put(39, new StreetCore("Board", Color.BLUE, new FieldInit(400, 50, 200, 600, 1400, 1700, 2000, 200)));
        
        return map;
    }
    
//    private List<BasePlace> Make() {
//        List<BasePlace> list = new ArrayList<>(40);
//        
//        for (int i = 0; i < 40; i++) {
//            list.add(i, new CornerCoreImpl("PlaceHolder"));
//        }
//        
//        list.set(0, new GoCornerCoreImpl("Go"));
//        list.set(10, new CornerCoreImpl("In Jail"));
//        list.set(20, new CornerCoreImpl("Free"));
//        list.set(30, new GoToJailCornerCoreImpl("Go to Jail"));
//
//        //railroad
//        list.set(5, new RailRoadUtilitiesCoreImpl("RailRoad 1", 200));
//        list.set(15, new RailRoadUtilitiesCoreImpl("RailRoad 2", 200));
//        list.set(25, new RailRoadUtilitiesCoreImpl("RailRoad 3", 200));
//        list.set(35, new RailRoadUtilitiesCoreImpl("RailRoad 4", 200));
//        
//        list.set(12, new UtilitiesCoreImpl("Electric", 150));
//        list.set(28, new UtilitiesCoreImpl("Water", 150));
//
//        //chance & others
//        list.set(2, new ActionCore("Comunity Chest"));
//        list.set(4, new ActionCore("Income Tax"));
//        list.set(7, new ActionCore("Chance"));
//        list.set(17, new ActionCore("Comunity Chest"));
//        list.set(22, new ActionCore("Chance"));
//        list.set(33, new ActionCore("Comunity Chest"));
//        list.set(36, new ActionCore("Chance"));
//        list.set(38, new ActionCore("TAX"));
//
//        //Brown street
//        list.set(1, new StreetCore("mediter", Color.darkGray, 60));
//        list.set(3, new StreetCore("Balitc", Color.darkGray, 60));
//
//        //white 
//        list.set(6, new StreetCore("Ortinal", Color.GRAY, 100));
//        list.set(8, new StreetCore("Vermount", Color.GRAY, 100));
//        list.set(9, new StreetCore("Connect", Color.GRAY, 120));
//
//        //purple
//        list.set(11, new StreetCore("St.Charles", Color.PINK, 140));
//        list.set(13, new StreetCore("States", Color.PINK, 140));
//        list.set(14, new StreetCore("Virginia", Color.PINK, 160));
//
//        //orange
//        list.set(16, new StreetCore("St. James", Color.ORANGE, 180));
//        list.set(18, new StreetCore("Tennessee", Color.ORANGE, 180));
//        list.set(19, new StreetCore("New York", Color.ORANGE, 200));
//
//        //red
//        list.set(21, new StreetCore("Kentucky", Color.RED, 220));
//        list.set(23, new StreetCore("Indiana", Color.RED, 220));
//        list.set(24, new StreetCore("Illinois", Color.RED, 240));
//
//        //yellow
//        list.set(26, new StreetCore("Atlantic", Color.YELLOW, 260));
//        list.set(27, new StreetCore("Venteor", Color.YELLOW, 260));
//        list.set(29, new StreetCore("Marvin", Color.YELLOW, 280));
//
//        //green
//        list.set(31, new StreetCore("Pacific", Color.GREEN, 300));
//        list.set(32, new StreetCore("N Cor", Color.GREEN, 300));
//        list.set(34, new StreetCore("Pennsylvania", Color.GREEN, 320));
//
//        //blue
//        list.set(37, new StreetCore("Park", Color.BLUE, 350));
//        list.set(39, new StreetCore("Board", Color.BLUE, 400));
//        
//        return list;
//    }
    
}
