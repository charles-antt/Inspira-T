/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author berth
 */
public class BtnIcon extends JButton {

    // Propiedades
    private int diameter = 42;

    private Color backgroundColor = Color.WHITE;
    private Color hoverColor = new Color(240, 245, 255);
    private Color pressedColor = new Color(225, 235, 250);
    private Color borderColor = new Color(220, 220, 220);
    private Color iconColor = Colores.AZUL_CONFIANZA;
    private Color currentColor = backgroundColor;

    // Constructores
    public BtnIcon() {
        this(null);
    }

    public BtnIcon(Icon icon) {
        super(icon);
        configurar();
    }

    private void configurar() {
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        setForeground(iconColor);
        currentColor = backgroundColor;
        instalarEventos();
    }

    // Eventos
    private void instalarEventos() {

        MouseAdapter adapter = new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                if (isEnabled()) {
                    currentColor = hoverColor;
                    repaint();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (isEnabled()) {
                    currentColor = backgroundColor;
                    repaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (isEnabled()) {
                    currentColor = pressedColor;
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isEnabled()) {
                    currentColor = contains(e.getPoint())
                            ? hoverColor
                            : backgroundColor;
                    repaint();
                }
            }
        };
        addMouseListener(adapter);
    }

    // Pintado
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(isEnabled()
                ? currentColor
                : new Color(235, 235, 235));

        g2.fillOval(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1);

        g2.setColor(borderColor);

        g2.drawOval(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1);

        g2.dispose();

        super.paintComponent(g);

    }

    // Tamaño
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(diameter, diameter);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    // Getters y Setters
    public void setDiameter(int diameter) {
        this.diameter = diameter;
        revalidate();
        repaint();
    }

    public int getDiameter() {
        return diameter;
    }

    public void setButtonColor(Color color) {
        backgroundColor = color;
        currentColor = color;
        repaint();
    }

    public void setHoverColor(Color color) {
        hoverColor = color;
    }

    public void setPressedColor(Color color) {
        pressedColor = color;
    }

    public void setBorderColor(Color color) {
        borderColor = color;
        repaint();
    }

    public void setIconColor(Color color) {
        iconColor = color;
        setForeground(color);
    }
}
