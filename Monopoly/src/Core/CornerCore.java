/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import UI.BaseField;
import UI.CornerField;
import java.awt.Color;

public class CornerCore extends BasePlace {

    public CornerCore(String name) {
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
            _baseFiled = new CornerField(this, number, x, y, align);

            return _baseFiled;
        } else {
            return _baseFiled;
        }
    }

    @Override
    public int Price() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
