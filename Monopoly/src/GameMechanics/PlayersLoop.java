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

import Core.BuyAble;
import Core.Player;
import UI.Board;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Players tour movement loop.
 *
 * @author Michal
 */
public class PlayersLoop {

    //todo re order players after initial Dice throw.
    private static ArrayList<Player> _players;
    private static Player _currentPlayer;

    /**
     * Persist player list.
     *
     * @param players
     */
    public static void setPlayers(ArrayList<Player> players) {
        PlayersLoop._players = players;

    }

    /**
     * Current players' in game. 
     *
     * @return
     */
    public static ArrayList<Player> getPlayers() {
        return _players;
    }

    /**
     * return current player for its tourn on board
     *
     * @return
     */
    public static Player getCurrentPlayer() {
        return _currentPlayer;
    }

    /**
     * Set new player for it's tour on board
     *
     * @param currentPlayer
     */
    public static void setCurrentPlayer(Player currentPlayer) {
        PlayersLoop._currentPlayer = currentPlayer;
    }

    /**
     * Re-Order players based on initial dice throw.
     */
    public static void ShufflePlayersOrder() {
        //todo shuffle players order based on initial dice throw 
    }

    /**
     * Remove Player who run out of money
     *
     * @param player
     */
    public static void RemoveBankrupt(Player player) {
        if (getPlayers().indexOf(player) > 0) {
            _currentPlayer = getPlayers().get(getPlayers().indexOf(_currentPlayer) - 1);
        }
        _players.remove(player);
        for (BuyAble prop : player.getPossession()) {
            prop.setOwner(null);
        }
        player.getPossession().clear();
        Board.getSingleton().Repaint();
        if (_players.size() == 1) {
            Start.changeGameState(GameState.GAME_END);            
        }

    }

    /**
     * Iterate over static player list in loop.
     *
     * @return
     */
    public static Iterator<Player> iterator() {
        return new Iterator<Player>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Player next() {
                if (getPlayers().indexOf(_currentPlayer) + 1 == getPlayers().size()) {
                    _currentPlayer = getPlayers().get(0);
                } else {
                    _currentPlayer = getPlayers().get(getPlayers().indexOf(_currentPlayer) + 1);
                }
                return _currentPlayer;
            }
        };
    }

}
