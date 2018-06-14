/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import GameMechanics.Settings;
import UI.ImagePanel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Michal
 */
public class Player {

    private int money;
    private Color _color;
    private ArrayList<BasePlace> possession = new ArrayList<BasePlace>();
    private BoardCore _boardCore;
    private final int _playerNumber;
    private String _name;
    private BufferedImage playerIcon;
    private ImagePanel _imagePanel;

    public void setColor(Color color) {
        _color = color;
    }

    public Color getColor() {
        return _color;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public ImagePanel getImagePanel() {
        return _imagePanel;
    }

    public int getPlayerNumber() {
        return _playerNumber;
    }
    
    

    public Player(int number, String name, Color color, BufferedImage icon) {
        money = Settings.StartAmountOfMoney;
        _playerNumber = number;
        playerIcon = icon;
        _name = name;
        _color = color;
        _boardCore = new BoardCore(0);
        _imagePanel = new ImagePanel(0, 0, icon, name);
        _imagePanel.Resize(Settings.SizeOfIconOnBoard, Settings.SizeOfIconOnBoard);
        _imagePanel.setyOffset(number*Settings.SizeOfIconOnBoard);
    }

    @Override
    public String toString() {
        return _name;
    }

    public int GetMoney() {
        return money;
    }

    public void EarnMoney(int salary) {
        money += salary;
        //todo end game if money<0;
    }

    public void Buy(BasePlace place, int price) {
        possession.add(place);
        money -= price;
    }

    public void Sell(BasePlace place, int income) {
        possession.remove(place);
        money += income;
    }

    public void Pay(int amount) {
        money -= amount;
    }

    public BufferedImage getPlayerIcon() {
        return playerIcon;
    }

    public void setPlayerIcon(BufferedImage playerIcon) {
        this.playerIcon = playerIcon;
    }
    
    public void MoveToField(int placeId){
        _boardCore.setCursor(placeId);
        BoardCore.getFieldsOnBoard().get(placeId).MoveOver(this);
        BoardCore.getFieldsOnBoard().get(_boardCore.getCursor()).StepAction(this);
    }

    public void Move(int diceValue) {
        for (int i = 0; i < diceValue; i++) {
            _boardCore.iterator().next().MoveOver(this);
        }
        BoardCore.getFieldsOnBoard().get(_boardCore.getCursor()).StepAction(this);
    }
}
