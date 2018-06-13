/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import UI.ActionField;
import UI.BaseField;
import java.awt.Color;

/**
 *
 * @author michal
 */
public class ActionCore extends BasePlace {

    public ActionCore(String name) {
        super(name);
    }

    @Override
    public void StepAction(Player guest) {

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
            _baseFiled = new ActionField(this, number, x, y, align);

            return _baseFiled;
        } else {
            return _baseFiled;
        }
    }

}
