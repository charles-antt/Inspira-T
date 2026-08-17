/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author yairs
 */
public class RoundedButton extends JButton {

    private Color colorNormal = new Color(33, 122, 255);
    private Color colorHover = new Color(25, 95, 210);
    private Color colorTexto = Color.WHITE;
    private int radio = 30;

    public RoundedButton(String texto) {

        super(texto);

        setForeground(colorTexto);
        setBackground(colorNormal);

        setFont(new Font("Segoe UI", Font.BOLD, 16));

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                setBackground(colorHover);
                repaint();

            }

            @Override
            public void mouseExited(MouseEvent e) {

                setBackground(colorNormal);
                repaint();

            }

        });

    }

    public void setColorNormal(Color color) {

        this.colorNormal = color;
        setBackground(color);

    }

    public void setColorHover(Color color) {

        this.colorHover = color;

    }

    public void setRadio(int radio) {

        this.radio = radio;
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());

        g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
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

        g2.setColor(getBackground().darker());

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
