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

import GameMechanics.FieldAlign;
import UI.BaseField;
import java.awt.Color;

/**
 * Base board tail core Logic class
 *
 * @author Michal
 *
 */
public abstract class BasePlace {

    private final String _name;    

    /**
     * Object of painted tail graphics on board.
     */
    protected BaseField _baseFiled;

    /**
     * Create new BasePlace
     * @param name the name of field used to display on board. 
     */
    public BasePlace(String name) {
        _name = name;
    }

    /**
     * When a player ends his movement on the field run individual field action.
     *
     * @param guest
     * @return 
     */
    public abstract String StepAction(Player guest);

    /**
     * Action when player crossing over the field.
     *
     * @param guest
     */
    public abstract void MoveOver(Player guest);

    /**
     * If field is owned by a player it's border is painted in players color.
     *
     * @return
     */
    public abstract Color BorderColor();

    /**
     * Create graphics of this field.
     *
     * @param number
     * @param x
     * @param y
     * @param align
     * @return
     */
    public abstract BaseField makeField(int number, int x, int y, FieldAlign align);

    @Override
    public String toString() {
        return _name;
    }

}
