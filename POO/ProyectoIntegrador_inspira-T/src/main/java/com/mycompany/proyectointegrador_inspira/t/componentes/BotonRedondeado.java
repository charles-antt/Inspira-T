/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;
//import example.util.Colores;

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
public class BotonRedondeado extends JButton {
    private Color colorNormal;
    private Color colorHover;
    private Color colorTexto;
    private Color colorBorde = null;
    private int radio = 18;

    //Constructor principal
    public BotonRedondeado(String texto, Color fondo) {

        super(texto);

        this.colorNormal = fondo;
        this.colorHover = fondo.brighter();
        this.colorTexto = Color.WHITE;

        inicializar();
    }

    //Constructor con radio personalizado
    public BotonRedondeado(String texto, Color fondo, int radio) {

        super(texto);

        this.radio = radio;

        this.colorNormal = fondo;
        this.colorHover = fondo.brighter();
        this.colorTexto = Color.WHITE;

        inicializar();
    }

    //Configuración inicial
    private void inicializar() {
        setFont(Fuentes.medium(15f));
        setForeground(colorTexto);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setRolloverEnabled(true);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setMargin(new Insets(10, 18, 10, 18));
        setBorder(new EmptyBorder(10, 20, 10, 20));
        agregarEventos();
    }

    // Eventos del mouse
    private void agregarEventos() {

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

    //Dibujar botón personalizado
    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2
                = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Color pintar = getModel().isRollover()
                ? colorHover
                : colorNormal;

        g2.setColor(pintar);

        g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                radio,
                radio);

        g2.dispose();

        super.paintComponent(g);

    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (colorBorde != null) {

            g2.setColor(colorBorde);

        } else {

            g2.setColor(colorNormal.darker());

        }

        g2.drawRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                radio,
                radio);

        g2.dispose();

    }

    //Cambiar color principal
    public void setColor(Color color) {
        this.colorNormal = color;
        this.colorHover = color.brighter();
        repaint();
    }

    //Cambiar color del texto
    public void setColorTexto(Color color) {
        this.colorTexto = color;
        setForeground(color);
    }

    public void setColorBorde(Color color) {
        this.colorBorde = color;
        repaint();
    }

    public void setColorHover(Color color) {
        this.colorHover = color;
        repaint();
    }
}
