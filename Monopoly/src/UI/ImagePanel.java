/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

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
 *
 * @author Michal
 */
public class ImagePanel extends JComponent implements Painter {

    private BufferedImage _image;
    private int _xOffset;
    private int _yOffset;
    private int _rotate;

    public void setRotate(int _rotate) {
        this._rotate = _rotate;
    }

    public void setxOffset(int _xOffset) {
        this._xOffset = _xOffset;
    }

    public void setyOffset(int _yOffset) {
        this._yOffset = _yOffset;
    }

    public int getxOffset() {
        return _xOffset;
    }

    public int getyOffset() {
        return _yOffset;
    }

    public ImagePanel(int xOffset, int yOffset, String imagePath) {
        _xOffset = xOffset;
        _yOffset = yOffset;
        _rotate = 0;

        try {
            _image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {

        }
    }

    public ImagePanel(int xOffset, int yOffset, BufferedImage image, String toolTipText) {
        _xOffset = xOffset;
        _yOffset = yOffset;
        _image = image;
        _rotate = 0;
        setToolTipText(toolTipText);
    }

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
        g.rotate((Math.PI / 2) * _rotate, _xOffset, _yOffset);
        g.drawImage(_image, _xOffset, _yOffset, this);
        g.setTransform(oldAT);
    }
}
