/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author yairs
 */
public class RoundedPanel extends JPanel {

    private int radio;
    private Color colorFondo;

    public RoundedPanel() {
        this(25, Color.WHITE);
    }

    public RoundedPanel(int radio) {
        this(radio, Color.WHITE);
    }

    public RoundedPanel(int radio, Color colorFondo) {
        this.radio = radio;
        this.colorFondo = colorFondo;
        setOpaque(false);
    }

    public void setRadio(int radio) {
        this.radio = radio;
        repaint();
    }

    public int getRadio() {
        return radio;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
        repaint();
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(colorFondo);

        g2.fillRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                radio,
                radio);

        super.paintComponent(g2);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(220, 220, 220));

        g2.drawRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                radio,
                radio);

        g2.dispose();
    }

}
