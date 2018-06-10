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
 *
 * @author michal
 */
public class UtielietiesCore extends BasePlace {

    //todo lista kart Chance i comunity chest. 
    // dworce 
    //obrazek
    // elektrownia/ wodociągi. 
    private int _price;

    public UtielietiesCore(String name, int price) {
        super(name);
        _price = price;
    }

    @Override
    public void StepAction(Player guest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void MoveOver(Player guest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color BorderColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public int Price() {
        return _price;
    }

}
