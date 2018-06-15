/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import UI.BaseField;
import UI.UtilitiesField;
import java.awt.Color;

/**
 * Special field on game board with difrent rent calculation.
 *
 * @author michal
 */
public abstract class UtilitiesCore extends BasePlace implements BuyAble {

    /**
     * The owner of this game board field.
     */
    protected Player owner;
    private int _price;

    /**
     * Value of field rent.
     */
    protected int _rent;

    /**
     * Create new abstract object of utilites common logic.
     * @param name
     * @param price
     */
    public UtilitiesCore(String name, int price) {
        super(name);
        _price = price;
    }

    @Override
    public String StepAction(Player guest) {
        if (owner != guest && owner != null) {
            guest.Pay(getRent());
            owner.EarnMoney(getRent());
            return String.format("Pay %d to player %s who owns %s", getRent(), owner.toString(), this.toString());
        }
        return String.format("Steped on unowned %s", this.toString());
    }

    @Override
    public void MoveOver(Player guest) {
        _baseFiled.DrawPlayer(guest);
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
            _baseFiled = new UtilitiesField(this, number, x, y, align);

            return _baseFiled;
        } else {
            return _baseFiled;
        }
    }

    @Override
    public int getPrice() {
        return _price;
    }

    @Override
    public void Sell() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Sell(Player buyer, int price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Buy(Player buyer) {
        owner = buyer;
        buyer.Buy(this, _price);
    }

}
