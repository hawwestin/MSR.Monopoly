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

import GameMechanics.Constructions;
import UI.BaseField;
import UI.StreetField;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class StreetCore extends BasePlace implements BuyAble {

    private Player owner;
    private final FieldInit _pricing;
    public Color color;
    private static List<StreetCore> _streets = new ArrayList<>();
    private Constructions _construction;

    public StreetCore(String name, Color color, FieldInit pricing) {
        super(name);
        this.color = color;
        _pricing = pricing;
        _streets.add(this);
        _construction = Constructions.GROUND;
    }

    @Override
    public void StepAction(Player guest) {
        if (owner != guest && owner != null) {
            guest.Pay(getRent());
            owner.EarnMoney(getRent());
        }
    }

    @Override
    public void MoveOver(Player guest) {
        _baseFiled.DrawPlayer(guest);
    }

    @Override
    public int getPrice() {
        return _pricing.getPrice();
    }

    @Override
    public void Buy(Player buyer) {
        owner = buyer;
        buyer.Buy(this, getPrice());
    }

    @Override
    public int getRent() {
        if (HasColorSet()) {
            return _pricing.getRentMap().get(_construction);
        }
        return _pricing.getRent();
    }

    private boolean HasColorSet() {
        for (StreetCore street : _streets) {
            if (street.color == this.color && street.owner != this.owner) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void Sell() {
        owner.Sell(this, getPrice());
        owner = null;
    }

    @Override
    public Color BorderColor() {
        if (owner != null) {
            return owner.getColor();
        } else {
            return Color.BLACK;
        }
    }

    @Override
    public BaseField makeField(int number, int x, int y, String align) {
        if (_baseFiled == null) {
            _baseFiled = new StreetField(this, number, x, y, align);

            return _baseFiled;
        } else {
            return _baseFiled;
        }
    }    

    @Override
    public void Sell(Player buyer, int price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
