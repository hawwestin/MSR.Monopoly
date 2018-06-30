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
package UI;

import GameMechanics.FieldAlign;
import Viewer.Painter;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * Component managing image drawer for Viwer.Painter implementations.
 *
 * @author Michal
 */
public class ImagePanel extends JComponent implements Painter {

    private BufferedImage _image;
    private int _xOffset;
    private int _yOffset;
    private FieldAlign _rotate;

    /**
     * Set tilt of image
     *
     * @param rotate
     */
    public void setRotate(FieldAlign rotate) {
        _rotate = rotate;
    }

    /**
     * Move image on board setting new x offset .
     *
     * @param _xOffset
     */
    public void setxOffset(int xOffset) {
        _xOffset = xOffset;
    }

    /**
     * Move image on board setting new y offset .
     *
     * @param _yOffset
     */
    public void setyOffset(int yOffset) {
        _yOffset = yOffset;
    }

    /**
     * Current image x offset on game board
     *
     * @return
     */
    public int getxOffset() {
        return _xOffset;
    }

    /**
     * Current image y offset on game board
     *
     * @return
     */
    public int getyOffset() {
        return _yOffset;
    }

    /**
     * Create new Object ImagePanel form given path to file.
     *
     * @param xOffset
     * @param yOffset
     * @param imagePath
     */
    public ImagePanel(int xOffset, int yOffset, String imagePath) {
        _xOffset = xOffset;
        _yOffset = yOffset;
        _rotate = FieldAlign.UP;

        try {
            _image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {

        }
    }

    /**
     * Create new object ImagePanel from pre loaded Image.
     *
     * @param xOffset
     * @param yOffset
     * @param image
     * @param toolTipText
     */
    public ImagePanel(int xOffset, int yOffset, BufferedImage image, String toolTipText) {
        _xOffset = xOffset;
        _yOffset = yOffset;
        _image = image;
        _rotate = FieldAlign.UP;
        setToolTipText(toolTipText);
    }

    /**
     * Set visibility of this Painter on game board.
     *
     * @param view
     */
    public void ToogleVisibility(boolean view) {
        if (view) {
            Board.getSingleton().AddImagePanel(this);
        } else {
            Board.getSingleton().RemoveImagePanel(this);
        }

    }

    /**
     * Resize displayed image to new width and hight
     *
     * @param width
     * @param height
     */
    public void Resize(int width, int height) {
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Image tmp = _image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        Graphics2D transform = result.createGraphics();
        transform.drawImage(tmp, 0, 0, null);
        transform.dispose();
        _image = result;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(_image, _xOffset, _yOffset, this);
    }

    @Override
    public void paint(Graphics2D g, AffineTransform worldToScreen, double w, double h) {
        AffineTransform oldAT = g.getTransform();
        g.transform(worldToScreen);
        g.rotate((Math.PI / 2) * _rotate.ordinal(), _xOffset, _yOffset);
        g.drawImage(_image, _xOffset, _yOffset, this);
        g.setTransform(oldAT);
    }
}
