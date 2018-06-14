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
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 *
 * @author Michal
 */
public class ComunityCard implements ICard {

    private ArrayList<Action> list;
    private Random rand;

    public ComunityCard() {
        this.list = makeList();
        rand = new Random();
    }

    @Override
    public void MakeAction(Player guest) {
        ActionEvent aaa = new ActionEvent(guest, 0, "");
        int r = rand.nextInt(list.size());
        list.get(r).actionPerformed(aaa);
    }

    private ArrayList<Action> makeList() {
        ArrayList<Action> innerList;
        innerList = new ArrayList<>();

        innerList.add(LotteryWiner);
        innerList.add(LotteryWiner);
        innerList.add(LotteryWiner);

        return innerList;
    }

    private final Action LotteryWiner = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof Player) {
                Player player = (Player) e.getSource();
                player.EarnMoney(25);

            } else {
                throw new ClassCastException("Action has got not a player"); //To change body of generated methods, choose Tools | Templates.
            }
        }
    };

}
