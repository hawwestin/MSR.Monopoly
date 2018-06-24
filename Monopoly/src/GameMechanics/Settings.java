/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameMechanics;

import java.awt.Font;

/**
 * Game application settings constants.
 * @author Michal
 */
public class Settings {
    //todo read settings from file

    /**
     * Maximum player limit
     */
    
    public static int PlayersLimit = 4;

    /**
     * Base amount of money
     */
    public static int StartAmountOfMoney = 1500;

    /**
     * Size of player counter image on board. 
     */
    public static int SizeOfIconOnBoard = 55;
    
    /**
     * Dafault in game font for on board text.
     */
    public static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 20);
    
}
