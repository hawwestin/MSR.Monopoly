/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Michal aka street or other monument to by own by a player
 *
 */
public class BasePlace {

    //Decorator of IPLaces ... jakos obkleic place budynkami.. i jakos je zdjac 
    //jak ktos sprzeda parcele 
    private Player owner;
    private ArrayList<Player> guests = new ArrayList<Player>();
    private int _price;
    private int _rent;
    private String _name;
    private BasePlace _nextStreet;
    private Color _color;

    public BasePlace() {
    }

    public BasePlace(int price, String name, int rent) {
        owner = null;
        _price = price;
        _rent = rent;
        _name = name;
    }

    private int Price() {
        return _price;
    }

    public void Buy(Player buyer) {
        owner = buyer;
        buyer.Buy(this, _price);
    }

    public void SetValue(int value){
        _rent += value;
    }
    
    public void PlayerStep(Player guest) {
        if (owner != guest && owner != null) {
            guest.Pay(_rent);
            owner.EarnMoney(_rent);
        }
    }

    public void Sell() {
        owner.Sell(this, _price);
        owner = null;
        _rent = 0;
    }

    @Override
    public String toString() {
        return _name;
    }

}
