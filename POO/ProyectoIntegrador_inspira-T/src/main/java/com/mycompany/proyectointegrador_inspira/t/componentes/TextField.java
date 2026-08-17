/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
import com.mycompany.proyectointegrador_inspira.t.componentes.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author berth
 */
public class TextField extends JTextField {

    private int radius = 18;
    private String placeholder = "";
    private Color borderColor = new Color(220, 220, 220);
    private Color focusColor = Colores.AZUL_TECNOLOGICO;
    private Color backgroundColor = Color.WHITE;
    private Color placeholderColor = new Color(150, 150, 150);
    private Color currentBorder = borderColor;
    private FlatSVGIcon iconoIzquierdo = null;
    private FlatSVGIcon iconoDerecho = null;

    // Constructores
    public TextField() {
        this("");
    }

    public TextField(String placeholder) {
        this.placeholder = placeholder;
        configurar();
    }

    private void configurar() {
        setFont(Fuentes.regular(13f));
        setOpaque(false);
        actualizarMargenes();

        setForeground(Colores.GRAFITO);
        instalarEventos();
    }

    private void actualizarMargenes() {
        int margenIzquierdo = (iconoIzquierdo != null) ? 32 : 12;
        int margenDerecho = (iconoDerecho != null) ? 32 : 12; // Nuevo espacio para el ojo

        setBorder(BorderFactory.createEmptyBorder(10, margenIzquierdo, 10, 10));
    }

    public void setIconoIzquierdo(String ruta) {
        if (ruta != null && !ruta.isEmpty()) {
            // Inicializa el SVG con tamaño 16x16
            this.iconoIzquierdo = new FlatSVGIcon(ruta, 16, 16);
        } else {
            this.iconoIzquierdo = null;
        }
        actualizarMargenes();
        repaint();
    }

    public void setIconoDerecho(String ruta) {
        if (ruta != null && !ruta.isEmpty()) {
            this.iconoDerecho = new com.formdev.flatlaf.extras.FlatSVGIcon(ruta, 16, 16);
        } else {
            this.iconoDerecho = null;
        }
        actualizarMargenes();
        repaint();
    }

    private void instalarEventos() {
        addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                currentBorder = focusColor;
                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
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
        if (iconoIzquierdo != null) {
            // Centrar verticalmente el icono de 16x16
            int yIcono = (getHeight() - 16) / 2;
            // Posicionar a 10 píxeles del borde izquierdo del componente
            iconoIzquierdo.paintIcon(this, g2, 10, yIcono);
        }
        if (iconoDerecho != null) {
            int yIcono = (getHeight() - 16) / 2;
            // Calculamos la posición X restando el ancho del componente menos 26 píxeles
            int xIcono = getWidth() - 26;
            iconoDerecho.paintIcon(this, g2, xIcono, yIcono);
        }
        super.paintComponent(g);

        if (getText().isEmpty()
                && !isFocusOwner()
                && placeholder != null) {

            g2.setFont(getFont());

            g2.setColor(placeholderColor);

            FontMetrics fm = g2.getFontMetrics();

            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

            g2.drawString(
                    placeholder,
                    getInsets().left,
                    y);

        }
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
        return new Dimension(250, 40);
    }

    // Getters / Setters
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        repaint();
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public int getRadius() {
        return radius;
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

    public void setPlaceholderColor(Color color) {
        placeholderColor = color;
        repaint();
    }
}
