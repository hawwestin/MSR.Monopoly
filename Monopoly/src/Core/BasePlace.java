/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import UI.BaseField;
import java.awt.Color;

/**
 *
 * @author Michal 
 *
 */
public abstract class BasePlace {

    private final String _name;
    protected BaseField _baseFiled;

    public BasePlace(String name) {
        _name = name;
    }

    /**
     * When a player ends his movement on the field run individual field action.
     * @param guest
     */
    public abstract void StepAction(Player guest);

    /**
     * Action when player crossing over the field.
     * @param guest
     */
    public abstract void MoveOver(Player guest);

    /**
     * If field is owned by a player it's border is painted in players color.
     * @return
     */
    public abstract Color BorderColor();

    /**
     * Create graphics of this field.
     * @param number
     * @param x
     * @param y
     * @param align
     * @return
     */
    public abstract BaseField makeField(int number, int x, int y, String align);    
    
    @Override
    public String toString() {
        return _name;
    }

}
