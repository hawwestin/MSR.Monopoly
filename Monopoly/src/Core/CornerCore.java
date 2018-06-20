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
import UI.CornerField;
import java.awt.Color;

/**
 * Corner field logic Class. 
 * @author Michal
 */
public abstract class CornerCore extends BasePlace {

    /**
     * Create new CornerCore object
     * @param name
     */
    public CornerCore(String name) {
        super(name);
    }

    @Override
    public String StepAction(Player guest) {
     return "";
    }

    @Override
    public void MoveOver(Player guest) {
        _baseFiled.DrawPlayer(guest);
    }

    @Override
    public Color BorderColor() {
        return Color.BLACK;
    }

    @Override
    public BaseField makeField(int number, int x, int y, FieldAlign align) {
        if (_baseFiled == null) {
            _baseFiled = new CornerField(this, number, x, y, align);

            return _baseFiled;
        } else {
            return _baseFiled;
        }
    }


}
