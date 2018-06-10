/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Viewer.Painter;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Michal
 */
public class ImagePanel extends JPanel implements Painter {

    private BufferedImage _image;
    private int _xOffset;
    private int _yOffset;

    public void setxOffset(int _xOffset) {
        this._xOffset = _xOffset;
    }

    public void setyOffset(int _yOffset) {
        this._yOffset = _yOffset;
    }

    public ImagePanel(int xOffset, int yOffset, String imagePath) {
        _xOffset = xOffset;
        _yOffset = yOffset;

        try {
            _image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {

        }
    }

    public ImagePanel(int xOffset, int yOffset, BufferedImage image) {
        _xOffset = xOffset;
        _yOffset = yOffset;
        _image = image;
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
        g.drawImage(_image, _xOffset, _yOffset, this);
        g.setTransform(oldAT);
    }
}
