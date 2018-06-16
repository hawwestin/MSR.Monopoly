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

import java.util.Random;

/**
 * Double dice logic from board game.
 *
 * @author Michal
 */
public class Dice {

    private static boolean _throwed;
    private static int strikeCounter;
    private static int _dice1;
    private static int _dice2;

    /**
     * get value of first die after it was thrown
     *
     * @return
     */
    public static int getDice1() {
        return _dice1;
    }

    /**
     * get value of second die after it was thrown
     *
     * @return
     */
    public static int getDice2() {
        return _dice2;
    }

    /**
     * Return false if current player can throw the dice.
     *
     * @return
     */
    public static boolean isThrowed() {
        return _throwed;
    }

    /**
     * If player should not be able to throw the dice again set throwed to true.
     *
     * @param throwed
     */
    public static void setThrowed(boolean throwed) {
        _throwed = throwed;
    }

    /**
     * Get value of series double throw
     *
     * @return
     */
    public static int getStrikeCounter() {
        return strikeCounter;
    }

    /**
     * Update value od series of double throw
     *
     * @param strikeCounter
     */
    public static void setStrikeCounter(int strikeCounter) {
        Dice.strikeCounter = strikeCounter;
    }

    /**
     * Draw by lot the value for both die
     *
     * @return sum of both dice value.
     * @throws DiceThrowed if player cannot throw the die again
     * @throws DiceJail if player series of double reach three occurence. 
     */
    public static int Throw() throws DiceThrowed, DiceJail {
        if (isThrowed()) {
            throw new DiceThrowed("You have already throw the dice in turn\n");
        }

        Random rand = new Random();
        _dice1 = rand.nextInt(6) + 1;
        _dice2 = rand.nextInt(6) + 1;
        if (_dice1 == _dice2) {
            setStrikeCounter(getStrikeCounter() + 1);
            if (getStrikeCounter() == 3) {
                setThrowed(true);
                throw new DiceJail("Bad Luck with three dublets in a row\n");
            }
            setThrowed(false);
            return _dice1 + _dice2;
        }
        setThrowed(true);
        return _dice1 + _dice2;
    }

    /**
     * Reset both dice and boolean static flags for next player tour.
     */
    public static void Reset() {

        setThrowed(false);
        setStrikeCounter(0);
        _dice1 = 0;
        _dice2 = 0;
    }
}
