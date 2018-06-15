/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

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
    public BaseField makeField(int number, int x, int y, String align) {
        if (_baseFiled == null) {
            _baseFiled = new CornerField(this, number, x, y, align);

            return _baseFiled;
        } else {
            return _baseFiled;
        }
    }


}
