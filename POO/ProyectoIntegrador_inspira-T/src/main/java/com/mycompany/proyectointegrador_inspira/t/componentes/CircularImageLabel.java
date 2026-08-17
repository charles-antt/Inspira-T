/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author berth
 */
public class CircularImageLabel extends JComponent {

    private BufferedImage image;
    private int size;

    public CircularImageLabel(String ruta, int size) {

        this.size = size;

        try {
            image = ImageIO.read(getClass().getResource(ruta));
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        setPreferredSize(new Dimension(size, size));
        setMaximumSize(new Dimension(size, size));
        setMinimumSize(new Dimension(size, size));
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Shape clip = new Ellipse2D.Double(0, 0, size, size);
        g2.setClip(clip);

        if (image != null) {
            g2.drawImage(image, 0, 0, size, size, this);
        }

        g2.dispose();
    }
}
