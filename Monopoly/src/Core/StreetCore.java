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
import GameMechanics.FieldAlign;
import GameMechanics.Start;
import UI.BaseField;
import UI.Board;
import UI.PropCard;
import UI.StreetField;
import UI.StreetPropertyCard;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Street instance. Street can be buy and sold by a player form bank or other
 * player. If player have _color set of the street he can buy some houses or
 * hotel on it. If other player step on the field he will pay rent to the onwer.
 * Rent is calculated based on current construcion and street pricing
 *
 * @author Michal
 */
public class StreetCore extends BasePlace implements BuyAble {

    private Player _owner;
    private final FieldInit _pricing;
    private Color _color;
    private static List<StreetCore> _streets = new ArrayList<>();
    private Constructions _rentLevel;
    private final StreetPropertyCard _propertyCard;

    /**
     * Create new object of streetCore
     *
     * @param name
     * @param color
     * @param pricing
     */
    public StreetCore(String name, Color color, FieldInit pricing) {
        super(name);
        BoardCore.AddToBuyAbleStreets(this);
        _color = color;
        _pricing = pricing;
        _streets.add(this);
        _rentLevel = Constructions.GROUND;

        _propertyCard = new StreetPropertyCard(this);
        SetPropMsg();

    }

    /**
     * Set message for bought street card in player wallet Box. Indicate current
     * rent level with a + on curretn rent level
     *
     */
    public void SetPropMsg() {
        StringBuilder propmsg = new StringBuilder();
        propmsg.append(String.format("%-32s", "RENT"));
        if (_rentLevel == Constructions.GROUND && !HasColorSet()) {
            propmsg.append("+");
        }
        propmsg.append(String.format("%5d $</br>", _pricing.getRent()));
        propmsg.append(String.format("%-26s", "Rent with colour set"));
        if (_rentLevel == Constructions.GROUND && HasColorSet()) {
            propmsg.append("+");
        }
        propmsg.append(String.format("%5d $</br>", _pricing.getConstructionRentMap().get(Constructions.GROUND)));
        propmsg.append(String.format("%-25s", "Rent with 1 house"));
        if (_rentLevel == Constructions.HOUSE1) {
            propmsg.append("+");
        }
        propmsg.append(String.format("%6d $</br>", _pricing.getConstructionRentMap().get(Constructions.HOUSE1)));
        propmsg.append(String.format("%-25s", "Rent with 2 house"));
        if (_rentLevel == Constructions.HOUSE2) {
            propmsg.append("+");
        }
        propmsg.append(String.format("%6d $</br>", _pricing.getConstructionRentMap().get(Constructions.HOUSE2)));
        propmsg.append(String.format("%-24s", "Rent with 3 house"));
        if (_rentLevel == Constructions.HOUSE3) {
            propmsg.append("+");
        }
        propmsg.append(String.format("%6d $</br>", _pricing.getConstructionRentMap().get(Constructions.HOUSE3)));
        propmsg.append(String.format("%-24s", "Rent with 4 house"));
        if (_rentLevel == Constructions.HOUSE4) {
            propmsg.append("+");
        }
        propmsg.append(String.format("%6d $</br>", _pricing.getConstructionRentMap().get(Constructions.HOUSE4)));
        propmsg.append(String.format("%-28s", "Rent with hotel"));
        if (_rentLevel == Constructions.HOTEL) {
            propmsg.append("+");
        }
        propmsg.append(String.format("%5d $</br>", _pricing.getConstructionRentMap().get(Constructions.HOTEL)));
        propmsg.append("-----------------------------</br>");
        propmsg.append(String.format("%-25s", "Construction cost"));
        propmsg.append(String.format("%5d $</br>", _pricing.getBuilding()));

        _propertyCard.setPropMsg(propmsg.toString());

    }

    @Override
    public String StepAction(Player guest) {
        if (_owner != guest && _owner != null) {
            guest.Pay(getRent());
            _owner.EarnMoney(getRent());
            return String.format("Pay %d$ to player %s who owns %s", getRent(), _owner.toString(), this.toString());
        }
        if (_owner == guest) {
            return String.format("Steped on your property %s", this.toString());
        }
        return String.format("Steped on unowned %s", this.toString());
    }

    /**
     * Get street tile _color
     *
     * @return
     */
    public Color getColor() {
        return _color;
    }

    /**
     * Set street tile _color
     *
     * @param color
     */
    public void setColor(Color color) {
        this._color = color;
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
    public Player getOwner() {
        return _owner;
    }

    @Override
    public PropCard getPropCard() {
        return _propertyCard;
    }

    @Override
    public void setOwner(Player buyer) {
        _owner = buyer;
        for (StreetCore street : _streets) {
            if (street.getColor() == this._color) {
                street.SetPropMsg();
            }
        }
    }

    @Override
    public int getRent() {
        if (HasColorSet()) {
            return _pricing.getConstructionRentMap().get(_rentLevel);
        }
        return _pricing.getRent();
    }

    private boolean HasColorSet() {
        for (StreetCore street : _streets) {
            if (street.getColor() == this._color && (street._owner != this._owner || street._owner == null)) {
                return false;
            }
        }
        return true;
    }

    private boolean CanSell() {
        for (StreetCore street : _streets) {
            if (street.getColor() == this._color && street._rentLevel.ordinal() > Constructions.GROUND.ordinal()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Color BorderColor() {
        if (_owner != null) {
            return _owner.getColor();
        } else {
            return Color.BLACK;
        }
    }

    @Override
    public BaseField makeField(int number, int x, int y, FieldAlign align) {
        if (_baseFiled == null) {
            _baseFiled = new StreetField(this, number, x, y, align);
            return _baseFiled;
        } else {
            return _baseFiled;
        }
    }

    @Override
    public void Sell() {

        if (_rentLevel == Constructions.GROUND) {
            if (CanSell()) {
                _owner.Sell(this, getPrice());
                setOwner(null);

                Board.getSingleton().Repaint();
                Start.getGame().TextLog(String.format("You Sold %s and earn %d", this.toString(), getPrice()));
            } else {
                Start.getGame().TextLog("Other steet in this colour has some Building on It.\nYou cannot sell this street now.");
            }
        } else { //deconstruct a house.
            _owner.EarnMoney(_pricing.getBuilding(), _pricing.getBuilding());

            StreetField baseFiled = (StreetField) _baseFiled;
            baseFiled.getBuildings().get(_rentLevel).ToogleVisibility(false);

            _rentLevel = _pricing.getPrev();
            Start.getGame().TextLog(String.format("You Sold building on %s and earn %d", this.toString(), _pricing.getBuilding()));
            Board.getSingleton().Repaint();
            SetPropMsg();
        }

    }

    @Override
    public void Sell(Player buyer, int price) {
        if (_rentLevel == Constructions.GROUND && CanSell()) {
            _owner.Sell(this, price);
            buyer.Buy(this, price);
            _owner = buyer;

            for (StreetCore street : _streets) {
                if (street.getColor() == this._color) {
                    street.SetPropMsg();
                }
            }
        }
    }

    /**
     * If player can build new building it raise current rent level and place
     * new builidng on board game.
     */
    public void ConstructBuilding() {
        if (HasColorSet() && _pricing.hasNext() && getOwner().GetMoney() > _pricing.getBuilding()) {
            _rentLevel = _pricing.getNext();

            StreetField baseFiled = (StreetField) _baseFiled;
            baseFiled.getBuildings().get(_rentLevel).ToogleVisibility(true);

            _owner.Pay(_pricing.getBuilding(), _pricing.getBuilding());
            SetPropMsg();
            Board.getSingleton().Repaint();
            Start.getGame().TextLog(String.format("You build on %s for %d", this.toString(), _pricing.getBuilding()));
        }
    }

}
