/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Graphics2D;

/**
 *
 * @author berth
 */
public class PanelTarjeta extends JPanel {
    //Propiedades

    private int radius = 24;
    //private Color backgroundColor = Color.WHITE;
    private Color backgroundColor = new Color(255, 255, 255, 50);
    private Color borderColor = new Color(228, 228, 228);
    private int borderWidth = 1;
    private Insets padding = new Insets(10, 10, 10, 10);

    // Constructor
    public PanelTarjeta() {
        configurar();
        setPreferredSize(new Dimension(360, 250));
    }

    private void configurar() {
        setOpaque(false);
        setBorder(new EmptyBorder(padding));
    }

    // Pintado
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Fondo
        g2.setColor(backgroundColor);
        g2.fillRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                radius,
                radius);
        // Borde
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(borderWidth));
        int bw = borderWidth;
        g2.drawRoundRect(
                bw / 2,
                bw / 2,
                getWidth() - bw,
                getHeight() - bw,
                radius,
                radius);
        g2.dispose();
    }

    // Setters
    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public void setCardBackground(Color color) {
        this.backgroundColor = color;
        repaint();
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    public void setBorderWidth(int width) {
        this.borderWidth = width;
        repaint();
    }

    public void setPadding(int top, int left, int bottom, int right) {
        padding = new Insets(top, left, bottom, right);
        setBorder(new EmptyBorder(padding));
        revalidate();
        repaint();
    }

    // Getters
    public int getRadius() {
        return radius;
    }

    public Color getCardBackground() {
        return backgroundColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(Integer.MAX_VALUE, getPreferredSize().height);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    public void setCardSize(int width, int height) {
        Dimension d = new Dimension(width, height);
        setPreferredSize(d);
        revalidate();
    }
}
