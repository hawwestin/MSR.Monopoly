/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import UI.BaseField;
import UI.UtilitiesPlace;
import java.awt.Color;

/**
 *
 * @author michal
 */
public class UtielietiesCore extends BasePlace{

    //todo lista kart Chance i comunity chest. 
    // dworce 
    //obrazek
    // elektrownia/ wodociągi. 
        
    public UtielietiesCore(String name) {
        super(name);
    }

    @Override
    public void StepAction(Player guest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void MoveOver(Player guest, int distance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color BorderColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BaseField makeField(int number, int x, int y, String align) {
        return new UtilitiesPlace(this, number, x, y, align);        
    }
    
}
