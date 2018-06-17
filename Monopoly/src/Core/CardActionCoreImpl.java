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

import GameMechanics.Card.ICardCollection;

/**
 * Specialize implementation of ActionCore. This place holds list of cards for
 * player to be randomly selected after playe Step on it. 
 *
 * @author Michal
 */
public class CardActionCoreImpl extends ActionCore {

    private final ICardCollection _cards;

    /**
     * Create new CardAction core logic class.
     * @param name name to be displayed on board
     * @param cards ICardCollcetion with cards list.
     */
    public CardActionCoreImpl(String name, ICardCollection cards) {
        super(name);
        _cards = cards;
    }

    @Override
    public String StepAction(Player guest) {
        return String.format("%s: %s", _cards.toString(), _cards.MakeAction(guest));
    }

}
