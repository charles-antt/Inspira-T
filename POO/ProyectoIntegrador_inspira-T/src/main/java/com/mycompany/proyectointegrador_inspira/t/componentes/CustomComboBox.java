/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
import com.mycompany.proyectointegrador_inspira.t.util.Iconos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

/**
 *
 * @author berth
 */
public class CustomComboBox<E> extends JComboBox<E> {

    private Color borderColor = new Color(220, 220, 220);
    private Color focusColor = Colores.AZUL_TECNOLOGICO;
    private Color currentBorder = borderColor;

    private Color backgroundColor = Color.WHITE;

    private int radius = 18;

    public CustomComboBox() {

        configurar();

    }

    public CustomComboBox(E[] elementos) {

        super(elementos);

        configurar();

    }

    private void configurar() {

        setOpaque(false);

        setFocusable(true);

        setFont(Fuentes.regular(15f));

        setForeground(Colores.GRAFITO);

        setBackground(backgroundColor);

        setBorder(new EmptyBorder(8, 12, 8, 12));

        setRenderer(new Renderer());

        setUI(new ComboUI());

        addFocusListener(new java.awt.event.FocusAdapter() {

            @Override
            public void focusGained(java.awt.event.FocusEvent e) {

                currentBorder = focusColor;

                repaint();

            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {

                currentBorder = borderColor;

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

        g2.setColor(backgroundColor);

        g2.fillRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                radius,
                radius);

        super.paintComponent(g);

        g2.dispose();

    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setStroke(new BasicStroke(2));

        g2.setColor(currentBorder);

        g2.drawRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                radius,
                radius);

        g2.dispose();

    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(250, 45);

    }

    private class Renderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(
                JList<?> list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list,
                    value,
                    index,
                    isSelected,
                    cellHasFocus);

            label.setBorder(new EmptyBorder(8, 12, 8, 12));

            label.setFont(Fuentes.regular(15f));

            if (isSelected) {

                label.setBackground(Colores.AZUL_TECNOLOGICO);

                label.setForeground(Color.WHITE);

            } else {

                label.setBackground(Color.WHITE);

                label.setForeground(Colores.GRAFITO);

            }

            return label;

        }

    }

    private class ComboUI extends BasicComboBoxUI {

        @Override
        protected JButton createArrowButton() {

            JButton button = new JButton();
            button.setIcon(Iconos.cargar(
                    Iconos.ARROW_DOWN,
                    18,
                    Colores.GRAFITO));
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setFocusable(false);
            button.setForeground(Colores.GRAFITO);
            button.setFont(Fuentes.bold(12f));
            return button;
        }

    }

    // API Pública
    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public void setBorderColor(Color color) {
        borderColor = color;
        currentBorder = color;
        repaint();
    }

    public void setFocusColor(Color color) {
        focusColor = color;
    }

    public void setBackgroundColor(Color color) {
        backgroundColor = color;
        repaint();
    }
}
