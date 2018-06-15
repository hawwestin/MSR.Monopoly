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
import java.util.Random;

/**
 *
 * @author Michal
 */
public class ChanceCards implements ICardCollection {

    private ArrayList<ICard> list;
    private Random rand;
    private final String name = "Chance";

    public ChanceCards() {
        this.list = makeList();
        rand = new Random();
    }

    @Override
    public String MakeAction(Player guest) {

        int r = rand.nextInt(list.size());
        return list.get(r).actionPerformed(guest);

    }

    private ArrayList<ICard> makeList() {
        ArrayList<ICard> innerList;
        innerList = new ArrayList<>();

        innerList.add(GoToGO);
        innerList.add(GoToRandom);
        innerList.add(GoToNextStation);

        return innerList;
    }

    @Override
    public String toString() {
        return name;
    }

    private final ICard GoToGO = new ICard() {
        @Override
        public String actionPerformed(Player player) {
            player.MoveToField(0);
            return "Go to GO collect $$$\n";
        }
    };

    private final ICard GoToRandom = new ICard() {
        @Override
        public String actionPerformed(Player player) {
            int r = rand.nextInt(BoardCore.getFieldsOnBoard().size());
            player.MoveToField(r);
            return String.format("Go to %s\n", BoardCore.getFieldsOnBoard().get(r).toString());
        }
    };

    private final ICard GoToNextStation = new ICard() {
        @Override
        public String actionPerformed(Player player) {
            int remainder = Math.floorMod(player.getBoardPlace(), 10);
            int modulo = Math.floorDiv(player.getBoardPlace(), 10);
            int newPlace;
            if (remainder < 5) {
                newPlace = modulo * 10 + Math.abs(5 - remainder);
            } else {
                newPlace = modulo * 10 + Math.abs(15 - remainder);
            }
            player.Move(newPlace);
            return String.format("Advance To %s", BoardCore.getFieldsOnBoard().get(newPlace).toString());
        }
    };

}
