/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

public class BoughtPlace extends BasePlace {

    private BasePlace _place;

    public BoughtPlace(BasePlace place) {
         
    }
    @Override
    public void SetValue(int value){
        _place.SetValue(value);
    }

}
