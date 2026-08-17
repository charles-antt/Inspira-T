/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Iconos;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;

import java.awt.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author berth
 */
public class PanelVideo extends PanelTarjeta {

    //Componentes
    private JLabel lblMiniatura;
    private JPanel barraControles;
    private JButton btnPlay;
    private JButton btnVolumen;
    private JButton btnSkipNext;
    private JLabel lblTiempo;

    public PanelVideo() {
        construir();
    }

    private void construir() {
        setPadding(0, 0, 0, 0);
        setLayout(new BorderLayout());
        crearMiniatura();
        crearControles();
    }

    //Miniatura
    private void crearMiniatura() {
        lblMiniatura = new JLabel();
        lblMiniatura.setOpaque(false);
        lblMiniatura.setHorizontalAlignment(SwingConstants.CENTER);
        lblMiniatura.setVerticalAlignment(SwingConstants.CENTER);
        lblMiniatura.setLayout(new BorderLayout());
        //Imagen de prueba
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/imgVideo.png"));
        Image img = icon.getImage().getScaledInstance(
                920,
                520,
                Image.SCALE_SMOOTH);
        //Image imgRedondeada = redondearEsquinas(img, 25);
        lblMiniatura.setIcon(new ImageIcon(img));
        add(lblMiniatura, BorderLayout.CENTER);
    }

    //Barra inferior
    private void crearControles() {

        barraControles = new JPanel(
                new MigLayout(
                        "fillx,insets 8 8 8 8",
                        "[][][][][grow]",
                        "[]"));

        barraControles.setOpaque(true);

        barraControles.setBackground(new Color(35, 35, 35, 215));

        //Play
        btnPlay = crearBoton(Iconos.cargar(Iconos.PLAY, 20, Color.WHITE));
        btnSkipNext = crearBoton(Iconos.cargar(Iconos.SKIP_NEXT, 20, Color.WHITE));

        //Volumen
        btnVolumen = crearBoton(Iconos.cargar(Iconos.VOLUME, 20, Color.WHITE));
        //Barra de tiempo
        /**
         * JPanel centro = new JPanel(new BorderLayout(0, 0));
         * centro.setOpaque(false);*
         */

        /**
         * sliderTiempo = new JSlider(); sliderTiempo.setValue(28);
         * sliderTiempo.setOpaque(false);*
         */
        lblTiempo = new JLabel("05:24 / 18:42");
        lblTiempo.setForeground(Color.WHITE);
        lblTiempo.setFont(Fuentes.medium(14f));

        //centro.add(sliderTiempo, BorderLayout.CENTER);
        //centro.add(lblTiempo, BorderLayout.EAST);
        //Configuración
        //Pantalla completa
        //btnPantallaCompleta = crearBoton(Iconos.cargar(Iconos.FULLSCREEN,20,Color.WHITE));
        barraControles.add(btnPlay);
        barraControles.add(btnSkipNext);
        barraControles.add(btnVolumen);
        barraControles.add(lblTiempo);
        //barraControles.add(centro, "growx");
        //barraControles.add(btnPantallaCompleta);
        JPanel pushPanel = new JPanel();
        pushPanel.setOpaque(false);
        barraControles.add(pushPanel, "growx");
        add(barraControles, BorderLayout.SOUTH);

    }
    //Botones transparentes

    private JButton crearBoton(String icono) {

        JButton boton = new JButton();

        boton.setIcon(
                new FlatSVGIcon(
                        icono,
                        20,
                        20));

        boton.setBorder(
                new EmptyBorder(5, 5, 5, 5));

        boton.setBorderPainted(false);

        boton.setContentAreaFilled(false);

        boton.setFocusPainted(false);

        boton.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR));

        return boton;

    }

    private JButton crearBoton(Icon icono) {
        JButton boton = new JButton();
        boton.setIcon(icono);
        boton.setFocusable(false);
        boton.setOpaque(false);
        boton.setBorder(new EmptyBorder(5, 5, 5, 5));
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                boton.setOpaque(true);
                boton.setBackground(new Color(255, 255, 255, 40));
                boton.repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                boton.setOpaque(false);
                boton.setBackground(null);
                boton.repaint();
            }
        });
        return boton;
    }

    public void setImagen(String ruta) {
        ImageIcon icon = new ImageIcon(
                getClass().getResource(ruta));

        Image img = icon.getImage().getScaledInstance(
                getWidth(),
                getHeight(),
                Image.SCALE_SMOOTH);

        lblMiniatura.setIcon(new ImageIcon(img));
    }
}
