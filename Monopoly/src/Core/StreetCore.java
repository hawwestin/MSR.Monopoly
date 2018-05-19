/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.awt.Color;

public class StreetCore extends BasePlace {

    private Player owner;
    private int _price;
    private int _rent;
    private Color _color;

    public StreetCore(String name, Color color) {
        super(name);
        _color = color;
    }

    @Override
    public void StepAction(Player guest) {
        if (owner != guest && owner != null) {
            guest.Pay(_rent);
            owner.EarnMoney(_rent);
        }
        guests.add(guest);
        //todo after dice throw have to be removed

        //todo make Buttons Availabele for Boy etc. 
    }

    @Override
    public void MoveOver(Player guest, int distance) {
        //display circle of a player over field . 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int Price() {
        return _price;
    }

    public void Buy(Player buyer) {
        owner = buyer;
        buyer.Buy(this, _price);
    }

    public void SetValue(int value) {
        _rent += value;
    }

    public void Sell() {
        owner.Sell(this, _price);
        owner = null;
        _rent = 0;
    }

}
