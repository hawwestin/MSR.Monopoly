/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import UI.BaseField;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Michal aka street or other monument to by own by a player
 *
 */
public abstract class BasePlace {

    //Decorator of IPLaces ... jakos obkleic place budynkami.. i jakos je zdjac 
    //jak ktos sprzeda parcele 
    protected ArrayList<Player> guests = new ArrayList<Player>();
    private String _name;    

    public BasePlace(String name) {
        _name = name;
    }

    public abstract void StepAction(Player guest);

    public abstract void MoveOver(Player guest, int distance);

    public abstract Color BorderColor();
    
    public abstract BaseField makeField(int number, int x, int y, String align);

    @Override
    public String toString() {
        return _name;
    }

}
