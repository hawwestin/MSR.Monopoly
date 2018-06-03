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
 * @author Michal
 */
public class Player {

    private int money;
    public Color color;
    private ArrayList<BasePlace> posse = new ArrayList<BasePlace>();
    //Symbol
    //Colot of the player  
    private int _playerNumber;

    public Player(int number, Color color) {
        money = 1500; //todo Some Config FIle to setup Base amount of money
        _playerNumber = number;
        this.color = color;
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

}
