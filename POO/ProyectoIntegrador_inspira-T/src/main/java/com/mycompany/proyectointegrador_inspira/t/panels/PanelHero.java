/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
import com.mycompany.proyectointegrador_inspira.t.util.Iconos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author berth
 */
public class PanelHero extends JPanel {

    private JLabel lblTitulo;
    private JLabel lblDescripcion;

    public PanelHero() {
        construir();
    }

    private void construir() {
        setLayout(new BorderLayout(10, 0));
        setBackground(Colores.BLANCO);
        setBorder(new EmptyBorder(10, 30, 10, 30));

        JPanel texto = new JPanel();
        texto.setBackground(Colores.BLANCO);

        texto.setPreferredSize(new Dimension(480, 300));
        texto.setLayout(new BoxLayout(texto, BoxLayout.Y_AXIS));

        lblTitulo = new JLabel(
                "<html>"
                + "<div style='width:360px;'>"
                + "<b>"
                + "<span style='color:#2E3440;'>Aprende, </span>"
                + "<span style='color:#7B61FF;'>comparte </span>"
                + "<span style='color:#2E3440;'>y </span>"
                + "<span style='color:#2F80ED;'>preserva </span>"
                + "<span style='color:#2E3440;'>nuestros saberes ancestrales</span>"
                + "</b>"
                + "</span>"
                + "</div>"
                + "</html>"
        );
        lblTitulo.setFont(Fuentes.extraBoldItalic(43));
        lblTitulo.setBorder(new EmptyBorder(50, 0, 0, 0));
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblDescripcion = new JLabel(
                "<html>"
                + "<div style='width:340px;margin-left: 10px;'>"
                + "<b>Conecta con culturas, protege tradiciones</b>"
                + "<br>"
                + "<b>y construye un futuro sostenible.</b>"
                + "</div>"
                + "</html>",
                Iconos.cargar(Iconos.PRESERVAR, 50, Colores.TURQUESA),
                SwingConstants.LEFT
        );

        lblDescripcion.setFont(Fuentes.medium(15f));
        lblDescripcion.setForeground(Color.DARK_GRAY);
        lblDescripcion.setVerticalTextPosition(SwingConstants.CENTER);
        lblDescripcion.setHorizontalTextPosition(SwingConstants.RIGHT);

        texto.add(lblTitulo);
        texto.add(Box.createVerticalStrut(30));
        texto.add(lblDescripcion);

        // PANEL DE IMAGEN
        JLabel imagen = new JLabel();
        imagen.setHorizontalAlignment(SwingConstants.CENTER);
        imagen.setBorder(new EmptyBorder(-19, 0, 0, -80));
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/principal.png"));
            Image img = icon.getImage().getScaledInstance(650, 380, Image.SCALE_SMOOTH);
            imagen.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            imagen.setText("Imagen no encontrada");
            imagen.setFont(Fuentes.regular(15f));
        }
        add(texto, BorderLayout.WEST);
        add(imagen, BorderLayout.CENTER);
    }
}
