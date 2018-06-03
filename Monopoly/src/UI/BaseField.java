/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.BasePlace;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Michal
 */
public abstract class BaseField extends JPanel{

    protected BasePlace _place;
    protected int _number;
    protected int width;
    protected int hight;
    protected int xOffset;
    protected int yOffset;
    protected String _align;
    protected int rotate;
    

    //Ractangel Dimension
    public BaseField(BasePlace place, int number, int x, int y, String align) {
        _place = place;
        _number = number;
        xOffset = x;
        yOffset = y;
        _align = align;
        if (_align.equals("up") || _align.equals("down")) {
            width = 175;
            hight = 280;
            if (_align.equals("up") )
                rotate = 0;
            else 
                rotate = 2;
                       
        } else if (_align.equals("left") || _align.equals("right")) {
            width = 280;
            hight = 175;
            if (_align.equals("left") )
               rotate = 1;
            else
                rotate =3;
                       
        }
        
        
    }

    public ArrayList<Integer> SeedCorner(){
        ArrayList<Integer> out = new ArrayList<Integer>();
         if (_number % 10 == 0) {
             out.add(_number*175);
             out.add(0);
         }
         else{
             out.add(_number*175);
             out.add(0);
                     
         }
        
        return out;
    }       
    

}
