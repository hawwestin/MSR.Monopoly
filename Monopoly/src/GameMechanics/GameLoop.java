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
package GameMechanics;

import Core.BoardCore;
import Core.Player;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Michal
 */
public class GameLoop {

    //todo re order players after initial Dice throw.
    private static ArrayList<Player> _players;
    private static HashMap<Player, Integer> _positions = new HashMap<>();

    public static void setPlayers(ArrayList<Player> players) {
        GameLoop._players =  players;        
        players.forEach(player -> _positions.put(player, 0));
        
        //todo display players icon on board
//        BoardCore.getStreets()
    }

    public static ArrayList<Player> getPlayers() {
        return _players;
    }        
    
    public static HashMap<Player, Integer> getPositions() {
        return _positions;
    }
    

}
