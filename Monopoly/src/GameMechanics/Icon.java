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
package GameMechanics;

import UI.Windows.WelcomeWindow;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Container for images of player counters
 *
 * @author Michal
 */
public class Icon {

    private static HashMap<String, BufferedImage> playerIconMap = makePlayerIconMap();
    private static HashMap<String, BufferedImage> buildngIconMap = makeBuildingMap();

    private static HashMap<String, BufferedImage> makePlayerIconMap() {
        HashMap<String, BufferedImage> map = new HashMap<String, BufferedImage>();
        try {
            //todo remake to directory content listing.
            map.put("Laptop", ImageIO.read(new File("img/laptop.gif")));
            map.put("Mouse", ImageIO.read(new File("img/mouse.gif")));
            map.put("Car", ImageIO.read(new File("img/car.png")));
            map.put("Iron", ImageIO.read(new File("img/iron.png")));
            map.put("Horse", ImageIO.read(new File("img/horseman.png")));
            map.put("Shoe", ImageIO.read(new File("img/shoe.png")));
            map.put("Bowler hat", ImageIO.read(new File("img/bowler_hat.png")));
            map.put("Canon", ImageIO.read(new File("img/canon.png")));
            map.put("Barrow", ImageIO.read(new File("img/barrow.png")));
            map.put("Ship", ImageIO.read(new File("img/ship.png")));
        } catch (IOException ex) {
            Logger.getLogger(WelcomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            //todo logger
        }
        return map;
    }

    private static HashMap<String, BufferedImage> makeBuildingMap() {
        HashMap<String, BufferedImage> map = new HashMap<String, BufferedImage>();
        try {
            //todo remake to directory content listing.
            map.put("House", ImageIO.read(new File("img/house.png")));
            map.put("Hotel", ImageIO.read(new File("img/hotel.png")));
        } catch (IOException ex) {
            Logger.getLogger(WelcomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            //todo logger
        }
        return map;
    }

    /**
     * Return map of in game supported counters image.
     *
     * @return
     */
    public static HashMap<String, BufferedImage> getPlayerIconMap() {
        return playerIconMap;
    }

    public static HashMap<String, BufferedImage> getBuildingIconMap() {
        return buildngIconMap;
    }

}
