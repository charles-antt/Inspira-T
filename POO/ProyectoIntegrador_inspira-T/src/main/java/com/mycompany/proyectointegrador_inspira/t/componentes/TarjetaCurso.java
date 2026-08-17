/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author yairs
 */
public class TarjetaCurso extends RoundedPanel {

    private final JLabel lblTitulo;
    private final JLabel lblDescripcion;
    private final String titulo;
    private final String descripcion;
    private int anchoTextoActual = -1;

    public TarjetaCurso(String titulo, String descripcion, String cursos,
            String rutaIcono, String rutaImagen,
            Color colorFondo, Color colorBoton) {

        super(25, colorFondo);
        this.titulo = titulo;
        this.descripcion = descripcion;

        setPreferredSize(new Dimension(360, 320));
        setLayout(new GridBagLayout());

        // PANEL IZQUIERDO
        JPanel izquierda = new JPanel(new BorderLayout());
        izquierda.setOpaque(false);

        JPanel superior = new JPanel();
        superior.setOpaque(false);
        superior.setLayout(new BoxLayout(superior, BoxLayout.Y_AXIS));
        superior.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 10));

        JPanel inferior = new JPanel();
        inferior.setOpaque(false);
        inferior.setLayout(new BoxLayout(inferior, BoxLayout.Y_AXIS));
        inferior.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));

        // PANEL DERECHO
        JPanel derecha = new JPanel(new BorderLayout());
        derecha.setOpaque(false);

        // ICONO
        /**
         * ImageIcon iconoOriginal = new
         * ImageIcon(getClass().getResource(rutaIcono)); Image imgIcono =
         * iconoOriginal.getImage().getScaledInstance(32, 32,
         * Image.SCALE_SMOOTH); JLabel icono = new JLabel(new
         * ImageIcon(imgIcono)); icono.setAlignmentX(Component.LEFT_ALIGNMENT);*
         */
        // Carga segura del ÍCONO
        JLabel icono;
        java.net.URL urlIcono = getClass().getResource(rutaIcono);
        if (urlIcono != null) {
            Image imgIcono = new ImageIcon(urlIcono).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
            icono = new JLabel(new ImageIcon(imgIcono));
        } else {
            icono = new JLabel(); // Evita el desplome si falta la imagen
            System.err.println("No se encontró el ícono: " + rutaIcono);
        }
        icono.setAlignmentX(Component.LEFT_ALIGNMENT);

// Carga segura de la IMAGEN DERECHA
        // TITULO / DESCRIPCION 
        lblTitulo = new JLabel();
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 24));
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblDescripcion = new JLabel();
        lblDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblDescripcion.setAlignmentX(Component.LEFT_ALIGNMENT);

        actualizarAnchoTexto(190);

        superior.add(icono);
        superior.add(Box.createVerticalStrut(5));
        superior.add(lblTitulo);
        superior.add(Box.createVerticalStrut(8));
        superior.add(lblDescripcion);
        superior.add(Box.createVerticalStrut(10));

        // IMAGEN DERECHA
        /**
         * ImageIcon iconoImagen = new
         * ImageIcon(getClass().getResource(rutaImagen)); Image img =
         * iconoImagen.getImage().getScaledInstance(150, 185,
         * Image.SCALE_SMOOTH); JLabel imagen = new JLabel(new ImageIcon(img));
         * derecha.add(imagen, BorderLayout.NORTH);*
         */
        JLabel imagen;
        java.net.URL urlImagen = getClass().getResource(rutaImagen);
        if (urlImagen != null) {
            Image img = new ImageIcon(urlImagen).getImage().getScaledInstance(150, 185, Image.SCALE_SMOOTH);
            imagen = new JLabel(new ImageIcon(img));
        } else {
            imagen = new JLabel();
            System.err.println("No se encontró la imagen: " + rutaImagen);
        }
        derecha.add(imagen, BorderLayout.NORTH);

        // CURSOS
        RoundedButton botondos = new RoundedButton(cursos);
        botondos.setAlignmentX(Component.LEFT_ALIGNMENT);

        // BOTÓN INSCRIBIRME
        RoundedButton boton = new RoundedButton("Inscribirme");
        boton.setAlignmentX(Component.LEFT_ALIGNMENT);

        inferior.add(botondos);
        inferior.add(Box.createVerticalStrut(15));
        inferior.add(boton);

        izquierda.add(superior, BorderLayout.CENTER);
        izquierda.add(inferior, BorderLayout.SOUTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        gbc.weighty = 1.0;

        gbc.gridx = 0;
        gbc.weightx = 0.58;
        add(izquierda, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.42;
        add(derecha, gbc);
    }

    public void actualizarAnchoTexto(int anchoPx) {
        if (anchoPx <= 0 || anchoPx == anchoTextoActual) {
            return;
        }
        anchoTextoActual = anchoPx;
        lblTitulo.setText(
                "<html><body style='width:" + anchoPx + "px'>" + titulo + "</body></html>"
        );
        lblDescripcion.setText(
                "<html><body style='width:" + anchoPx + "px'>" + descripcion + "</body></html>"
        );
        revalidate();
        repaint();
    }
}
