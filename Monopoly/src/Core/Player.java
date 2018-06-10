/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Michal
 */
public class Player {

    private int money;
    public Color color;
    private ArrayList<BasePlace> posse = new ArrayList<BasePlace>();

    public void setColor(Color color) {
        this.color = color;
    }

    public void setName(String _name) {
        this._name = _name;
    }
    //Symbol    
    private final int _playerNumber;
    private String _name;    
    private BufferedImage playerIcon;

    public Player(int number,String name, Color color, BufferedImage icon) {
        money = Settings.StartAmountOfMoney; 
        _playerNumber = number;
        playerIcon = icon;
        _name= name;
        this.color = color;
    }

    @Override
    public String toString() {
        return _name;
    }
    

    public int GetMoney() {
        return money;
    }

    public void EarnMoney(int salary) {
        money += salary;
    }

    public void Buy(BasePlace place, int price) {
        posse.add(place);
        money -= price;
    }

    public void Sell(BasePlace place, int income) {
        posse.remove(place);
        money += income;
    }

    public void Pay(int amount) {
        money -= amount;
    }

    public BufferedImage getPlayerIcon() {
        return playerIcon;
    }

    public void setPlayerIcon(BufferedImage playerIcon) {
        this.playerIcon = playerIcon;
    }       

}
