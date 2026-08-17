/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author berth
 */
public class RoundedPanel extends JPanel {
    // Propiedades

    private int radius = 20;
    private boolean shadow = false;
    private int shadowSize = 8;
    private Color shadowColor = new Color(0, 0, 0, 45);
    private Color borderColor = new Color(225, 225, 225);
    private int borderWidth = 1;

    // Constructor
    public RoundedPanel() {
        setOpaque(true);
    }

    public RoundedPanel(LayoutManager layout) {
        super(layout);
        setOpaque(false);
    }

    // Pintado
    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setRenderingHint(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        int x = 0;
        int y = 0;
        int width = getWidth();
        int height = getHeight();

        // Dibujar sombra
        if (shadow) {

            g2.setColor(shadowColor);

            for (int i = 0; i < shadowSize; i++) {

                g2.fillRoundRect(
                        i,
                        i,
                        width - i * 2,
                        height - i * 2,
                        radius,
                        radius);

            }

            x = 0;
            y = 0;

        }

        // Fondo
        g2.setColor(getBackground());

        g2.fillRoundRect(
                x,
                y,
                width - shadowSize,
                height - shadowSize,
                radius,
                radius);

        // Borde
        if (borderWidth > 0) {
            g2.setStroke(new BasicStroke(borderWidth));
            g2.setColor(borderColor);
            g2.drawRoundRect(
                    x,
                    y,
                    width - shadowSize - 1,
                    height - shadowSize - 1,
                    radius,
                    radius);

        }

        g2.dispose();

        super.paintComponent(g);

    }

    // Getters
    public int getRadius() {
        return radius;
    }

    public boolean hasShadow() {
        return shadow;
    }

    public int getShadowSize() {
        return shadowSize;
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public Color getBorderColor() {

        return borderColor;

    }

    public int getBorderWidth() {
        return borderWidth;
    }

    // Setters
    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public void setShadow(boolean shadow) {
        this.shadow = shadow;
        repaint();
    }

    public void setShadowSize(int shadowSize) {

        this.shadowSize = shadowSize;

        repaint();

    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        repaint();
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        repaint();
    }
}
