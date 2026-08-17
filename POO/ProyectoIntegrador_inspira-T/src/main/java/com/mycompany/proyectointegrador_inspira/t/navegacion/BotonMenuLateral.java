/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.navegacion;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author berth
 */
public class BotonMenuLateral extends JButton {

    private boolean selected = false;
    private boolean hovered = false;

    private Color normalColor = new Color(31, 60, 136);
    private Color hoverColor = new Color(171, 237, 229);
    private Color selectedColor = Colores.TURQUESA;
    private Color textColor = Color.WHITE;

    private int radius = 16;

    public BotonMenuLateral(Icon icono, String texto) {
        super(texto, icono);
        configurar();
    }

    private void configurar() {
        setFont(Fuentes.medium(18f));
        setForeground(textColor);
        setHorizontalAlignment(SwingConstants.LEFT);
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setIconTextGap(12);

        setVerticalTextPosition(SwingConstants.CENTER);
        setMargin(new Insets(0, 0, 0, 0));
        setBorder(new EmptyBorder(12, 30, 12, 8));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Color fondo = normalColor;

        if (selected) {
            fondo = selectedColor;
        } else if (hovered) {
            fondo = hoverColor;
        }
        g2.setColor(fondo);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(220, 50);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(220, 50);
    }

    public void setSelectedMenu(boolean value) {
        selected = value;
        repaint();
    }

    public boolean isSelectedMenu() {
        return selected;
    }
}
