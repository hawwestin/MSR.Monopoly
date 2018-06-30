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
package GameMechanics.Card;

import Core.BuyAble;
import Core.Player;
import Core.StreetCore;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.util.HashMap;

/**
 * Collection of ICard. Implements Comunity chest card logic witch you can find
 * in original board game Monopoly.Chance to draw a card is maintain in quntity
 * of similar ICard in cardList.
 *
 * @author Michal
 */
public class ComunityCard implements ICardCollection {

    private ArrayList<ICard> list;
    private Random rand;
    private final String name = "Comunit Chest";

    /**
     * New Comunity CHest Card object.
     */
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
        innerList.add(LegacyTax);
        innerList.add(LegacyTax);
        innerList.add(Budimex);
        innerList.add(Budimex);
        innerList.add(Renovation);
        innerList.add(Renovation);
        innerList.add(Renovation);

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

    private final ICard LegacyTax = new ICard() {
        @Override
        public String actionPerformed(Player player) {
            player.Pay(500);
            return "Your ancestor left you with 500 unpaid tax";
        }
    };

    private final ICard Budimex = new ICard() {
        @Override
        public String actionPerformed(Player player) {
            ArrayList<StreetCore> al = new ArrayList<>();
            for (BuyAble ba : player.getPossession()) {
                if (ba instanceof StreetCore) {
                    StreetCore sc = (StreetCore) ba;
                    if (sc.HasColorSet()) {
                        al.add(sc);
                    }
                }
            }
            if (al.size() > 0) {
                String msg = "";
                Random r = new Random();
                Color ccc = al.get(r.nextInt(al.size())).getColor();
                for (StreetCore sc : al) {
                    if (sc.getColor() == ccc) {
                        player.EarnMoney(sc.getBuildingPrice(), sc.getBuildingPrice());
                        sc.ConstructBuilding();
                        msg = msg.concat(", " + sc.toString());
                    }
                }
                return String.format("Developer raise on level of housing on streets:\n%s", msg);

            }
            player.EarnMoney(500);
            return "Developer give you 500$ for your incoming constructions!";
        }
    };

    private final ICard Renovation = new ICard() {
        @Override
        public String actionPerformed(Player player) {
            int amount = 0;
            for (BuyAble ba : player.getPossession()) {
                if (ba instanceof StreetCore) {
                    StreetCore sc = (StreetCore) ba;
                    if (sc.getRentLevel().ordinal() > 0) {
                        player.Pay(20 * sc.getRentLevel().ordinal());
                        amount += 20 * sc.getRentLevel().ordinal();
                    }
                }
            }
            return String.format("City housing check. Pay 20$ for each builidng.\nPays : %d", amount);
        }
    };

}
