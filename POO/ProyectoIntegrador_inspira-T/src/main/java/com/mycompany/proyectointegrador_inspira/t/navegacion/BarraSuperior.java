/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.navegacion;

import com.mycompany.proyectointegrador_inspira.t.componentes.BtnIcon;
import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author berth
 */
public class BarraSuperior extends JPanel {

    private final JLabel lblTitulo;
    private final JLabel lblSubtitulo;
    private final BtnIcon btnNotification;
    private final BtnIcon btnProfile;

    public BarraSuperior(String titulo) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(255, 255, 255)));
        setPreferredSize(new Dimension(0, 80));

        // Panel izquierdo
        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setBorder(new EmptyBorder(15, 52, 15, 20));
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(Fuentes.bold(28f));
        lblTitulo.setForeground(Colores.GRAFITO);
        lblSubtitulo = new JLabel("");
        lblSubtitulo.setFont(Fuentes.regular(14f));
        lblSubtitulo.setForeground(Colores.GRAFITO);

        left.add(lblTitulo);
        left.add(lblSubtitulo);

        // Panel derecho
        JPanel right = new JPanel(
                new FlowLayout(
                        FlowLayout.RIGHT,
                        20,
                        18));

        right.setOpaque(false);

        FlatSVGIcon iconBell = new FlatSVGIcon("imagenes/bell.svg", 22, 22);
        iconBell.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Colores.GRAFITO));
        FlatSVGIcon iconUser = new FlatSVGIcon("imagenes/user.svg", 22, 22);
        iconUser.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Colores.GRAFITO));

        btnNotification = new BtnIcon(iconBell);
        btnProfile = new BtnIcon(iconUser);

        right.add(btnNotification);
        right.add(btnProfile);

        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);
    }

    public void setTitulo(String titulo) {
        lblTitulo.setText(titulo);
    }

    public String getTitulo() {
        return lblTitulo.getText();
    }

    public void setSubtitulo(String texto) {
        lblSubtitulo.setText(texto);
    }

    public String getSubtitulo() {
        return lblSubtitulo.getText();
    }

    public BtnIcon getNotificationButton() {
        return btnNotification;
    }

    public BtnIcon getProfileButton() {
        return btnProfile;
    }

    private ImageIcon cargarIcono(String ruta, int ancho, int alto) {
        java.net.URL url = getClass().getResource(ruta);
        if (url != null) {
            ImageIcon iconoOriginal = new ImageIcon(url);
            // Escalar la imagen de forma suave (Smooth)
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            return new ImageIcon(imagenEscalada);
        } else {
            System.err.println("No se pudo encontrar el recurso: " + ruta);
            return null;
        }
    }
}
