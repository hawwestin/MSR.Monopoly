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

import Core.Player;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Michal
 */
public class ComunityCard implements ICardCollection {

    private ArrayList<ICard> list;
    private Random rand;
    private final String name = "Comunit Chest";

    public ComunityCard() {
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

        innerList.add(LottoWiner);
        innerList.add(LottoWiner);
        innerList.add(LottoWiner);

        return innerList;
    }

    @Override
    public String toString() {
        return name;
    }

    private final ICard LottoWiner = new ICard() {
        @Override
        public String actionPerformed(Player player) {
            player.EarnMoney(25);
            return "You won on Lottery 25$\n";
        }
    };

}
