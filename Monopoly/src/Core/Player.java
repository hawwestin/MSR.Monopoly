/*
 * The MIT License
 *
 * Copyright 2018 Michal.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package Core;

import GameMechanics.Settings;
import GameMechanics.Start;
import UI.ImagePanel;
import UI.PlayerWalletBox;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Instance of a single player.
 *
 * @author Michal
 */
public class Player {

    private int _money;
    private int _totalWealth;
    private Color _color;
    private ArrayList<BuyAble> _possession = new ArrayList<BuyAble>();
    private final BoardCore _boardCore;
    private final int _playerNumber;
    private String _name;
    private BufferedImage _playerCounter;
    private final ImagePanel _counterPanel;
    private boolean _jailBreak;
    private int _jailEscapeRetry;

    private PlayerWalletBox walletBox;

    /**
     * Create new object of Player.
     *
     * @param number
     * @param name
     * @param color
     * @param icon
     */
    public Player(int number, String name, Color color, BufferedImage icon) {
        _money = Settings.StartAmountOfMoney;
        _totalWealth = 0;
        _playerNumber = number;
        _playerCounter = icon;
        _name = name;
        _color = color;
        _boardCore = new BoardCore(0);
        _counterPanel = new ImagePanel(0, 0, icon, name);
        _counterPanel.Resize(Settings.SizeOfIconOnBoard, Settings.SizeOfIconOnBoard);
        _counterPanel.setyOffset(number * Settings.SizeOfIconOnBoard);
    }

    public int getTotalWealth() {
        return _totalWealth;
    }

    /**
     * Get player property wallet {@link Viewer.Painter} instnace
     *
     * @return
     */
    public PlayerWalletBox getWalletBox() {
        return walletBox;
    }

    /**
     * Set player property wallet {@link Viewer.Painter} instnace
     *
     * @param walletBox
     */
    public void setWalletBox(PlayerWalletBox walletBox) {
        this.walletBox = walletBox;
    }

    /**
     * Get current vaule of jail break retry
     *
     * @return
     */
    public int getJailEscapeRetry() {
        return _jailEscapeRetry;
    }

    /**
     * Set new value for jabil break atempt escape
     *
     * @param jailEscapeRetry
     */
    public void setJailEscapeRetry(int jailEscapeRetry) {
        _jailEscapeRetry = jailEscapeRetry;
    }

    /**
     * Return owned by player fields
     *
     * @return
     */
    public ArrayList<BuyAble> getPossession() {
        return _possession;
    }

    /**
     * Give color to the player. Color should not be changed after game began
     *
     * @param color
     */
    public void setColor(Color color) {
        _color = color;
    }

    /**
     * Pass current color of the player
     *
     * @return
     */
    public Color getColor() {
        return _color;
    }

    /**
     * Set new value of player name. Name should not be changed after game
     * began.
     *
     * @param name
     */
    public void setName(String name) {
        _name = name;
    }

    /**
     * Get graphics instance of player counter
     *
     * @return
     */
    public ImagePanel getCounterPanel() {
        return _counterPanel;
    }

    /**
     * Return player number. This is may not be player order value.
     *
     * @return
     */
    public int getPlayerNumber() {
        return _playerNumber;
    }

    /**
     * Is player in Jail
     *
     * @return
     */
    public boolean IsInJail() {
        return _jailBreak;
    }

    /**
     * Change the player's state of residence in Jail
     *
     * @param _jailBreak
     */
    public void setJailBreak(boolean _jailBreak) {
        this._jailBreak = _jailBreak;
    }

    @Override
    public String toString() {
        return _name;
    }

    /**
     * Return current value of player money
     *
     * @return
     */
    public int GetMoney() {
        return _money;
    }

    public void setMoney(int money) {
        _money = money;
        Start.getGame().EnableBuyButton();
    }

    /**
     * Add place to player possesion list at a given price.
     *
     * @param place
     * @param price
     */
    public void Buy(BuyAble place, int price) {
        _possession.add(place);
        place.setOwner(this);
        setMoney(_money - price);
        _totalWealth += price;
    }

    /**
     * Sell given place back to bank for a given price that will be added to
     * player account.
     *
     * @param place
     * @param income
     */
    public void Sell(BuyAble place, int income) {
        _possession.remove(place);
        setMoney(_money + income);
        _totalWealth -= income;
    }

    /**
     * Increase the value of player money
     *
     * @param salary
     */
    public void EarnMoney(int salary) {
        setMoney(_money + salary);
    }

    /**
     * Increase the value of player money. Decrease player wealth
     *
     * @param salary
     * @param building
     */
    public void EarnMoney(int salary, int building) {
        setMoney(_money + salary);
        _totalWealth -= building;
    }

    /**
     * Decrease player money
     *
     * @param amount
     */
    public void Pay(int amount) {
        setMoney(_money - amount);
    }

    /**
     * Decrease player money. Increase player wealth
     *
     * @param amount
     * @param building
     */
    public void Pay(int amount, int building) {
        setMoney(_money - amount);
        _totalWealth += building;
    }

    /**
     * Image of chosen player counter
     *
     * @return
     */
    public BufferedImage getPlayerCounter() {
        return _playerCounter;
    }

    /**
     * Set new value of counter
     *
     * @param playerIcon
     */
    public void setPlayerIcon(BufferedImage playerIcon) {
        this._playerCounter = playerIcon;
    }

    /**
     * Return current player place on board
     *
     * @return
     */
    public int getBoardPlace() {
        return _boardCore.getCursor();
    }

    /**
     * Move player counter directly to requested place on game board
     *
     * @param placeId
     * @return
     */
    public String MoveToField(int placeId) {
        _boardCore.setCursor(placeId);
        BoardCore.getFieldsOnBoard().get(placeId).MoveOver(this);
        return BoardCore.getFieldsOnBoard().get(_boardCore.getCursor()).StepAction(this);
    }

    /**
     * Move player counter to a given place on game board
     *
     * @param diceValue
     * @return
     */
    public String Move(int diceValue) {
        String msg = "";
        for (int i = 0; i < diceValue; i++) {
            _boardCore.iterator().next().MoveOver(this);
            if (getBoardPlace() == 0) {
                msg = "Pass Go! Collect 200$\n";
            }
        }
        msg = msg.concat(BoardCore.getFieldsOnBoard().get(_boardCore.getCursor()).StepAction(this));
        return msg;
    }
}
