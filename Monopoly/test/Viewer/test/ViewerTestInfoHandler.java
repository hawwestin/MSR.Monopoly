/*
 * www.javagl.de - Viewer
 *
 * Copyright (c) 2013-2015 Marco Hutter - http://www.javagl.de
 */
package Viewer.test;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Locale;

import javax.swing.JLabel;

import Viewer.Viewer;

/**
 * A mouse motion listener for the viewer test
 */
class ViewerTestInfoHandler implements
    MouseMotionListener
{
    /**
     * The label showing screen- and world coordinates
     */
    private final JLabel infoLabel;
    
    /**
     * The {@link Viewer} to which this listener is attached
     */
    private final Viewer viewer;

    /**
     * Default constructor
     * 
     * @param infoLabel The label showing screen- and world coordinates
     * @param viewer The {@link Viewer} to which this listener is attached
     */
    ViewerTestInfoHandler(JLabel infoLabel, Viewer viewer)
    {
        this.infoLabel = infoLabel;
        this.viewer = viewer;
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        updateInfo(e.getPoint());
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        updateInfo(e.getPoint());
    }

    /**
     * Update the info label depending on the given screen point
     * @param screenPoint The screen point
     */
    private void updateInfo(Point screenPoint)
    {
        AffineTransform screenToWorld = 
            viewer.getScreenToWorld();
        Point2D worldPoint = screenToWorld.transform(screenPoint, null);
        infoLabel.setText(
            "Screen: "+format(screenPoint)+
            " World: "+format(worldPoint));
    }

    /**
     * Create a simple string representation of the given point
     *
     * @param p The point
     * @return The string representation
     */
    private String format(Point2D p)
    {
        String xs = String.format(Locale.ENGLISH, "%.2f", p.getX());
        String ys = String.format(Locale.ENGLISH, "%.2f", p.getY());
        return "("+xs+","+ys+")";
    }
}