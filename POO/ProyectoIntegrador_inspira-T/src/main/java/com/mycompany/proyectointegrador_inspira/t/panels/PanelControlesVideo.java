/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
import com.mycompany.proyectointegrador_inspira.t.util.Iconos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author berth
 */
public class PanelControlesVideo extends JPanel {

    //Componentes
    private JButton btnPlay;
    private JButton btnVolumen;
    private JButton btnConfiguracion;
    private JButton btnPantallaCompleta;

    private JSlider sliderTiempo;
    private JLabel lblTiempo;

    public PanelControlesVideo() {
        construir();
    }

    private void construir() {
        setOpaque(true);
        setBackground(new Color(35, 35, 35, 220));
        setPreferredSize(new Dimension(0, 55));
        setLayout(new MigLayout(
                "fillx,insets 8 12 8 12",
                "[][][grow][][]",
                "[]"));
        // Play
        btnPlay = crearBoton(Iconos.PLAY);
        // Volumen
        btnVolumen = crearBoton(Iconos.VOLUME);
        // Slider
        sliderTiempo = new JSlider(0, 100, 28);
        sliderTiempo.putClientProperty("JComponent.roundRect", true);
        sliderTiempo.setOpaque(false);
        sliderTiempo.setFocusable(false);
        sliderTiempo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        // Tiempo
        lblTiempo = new JLabel("05:24 / 18:42");
        lblTiempo.setForeground(Color.WHITE);
        lblTiempo.setFont(Fuentes.medium(14f));
        // Panel central
        JPanel centro = new JPanel(new BorderLayout(10, 0));
        centro.setOpaque(false);
        centro.add(sliderTiempo, BorderLayout.CENTER);
        centro.add(lblTiempo, BorderLayout.EAST);
        // Configuración
        btnConfiguracion = crearBoton(Iconos.SKIP_NEXT);
        // Pantalla completa
        btnPantallaCompleta = crearBoton(Iconos.FULLSCREEN);

        // Agregar componentes
        add(btnPlay);
        add(btnVolumen);
        add(centro, "growx");
        add(btnConfiguracion);
        add(btnPantallaCompleta);
    }

    // Crear botones
    private JButton crearBoton(String rutaIcono) {
        JButton boton = new JButton();
        boton.setIcon(
                new FlatSVGIcon(
                        rutaIcono,
                        20,
                        20));
        boton.setFocusable(false);
        boton.setOpaque(false);
        boton.setBorder(new EmptyBorder(5, 5, 5, 5));
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setCursor(Cursor.getPredefinedCursor(
                Cursor.HAND_CURSOR));
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

    // Getters
    public JButton getBtnPlay() {
        return btnPlay;
    }

    public JButton getBtnVolumen() {
        return btnVolumen;
    }

    public JButton getBtnConfiguracion() {
        return btnConfiguracion;
    }

    public JButton getBtnPantallaCompleta() {
        return btnPantallaCompleta;
    }

    public JSlider getSliderTiempo() {
        return sliderTiempo;
    }

    public JLabel getLblTiempo() {
        return lblTiempo;
    }

    public void setTiempoActual(String texto) {
        lblTiempo.setText(texto);
    }

    public void setProgreso(int valor) {
        sliderTiempo.setValue(valor);
    }
}
