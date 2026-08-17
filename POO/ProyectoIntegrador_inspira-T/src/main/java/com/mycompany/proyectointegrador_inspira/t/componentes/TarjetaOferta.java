/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.formdev.flatlaf.extras.FlatSVGIcon;

public class TarjetaOferta extends JPanel {

    public TarjetaOferta(String titulo, String rutaImagen) {
        setOpaque(false);

        setPreferredSize(new Dimension(200, 250));
        setLayout(new BorderLayout());

        setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel imagen = new JLabel();
        imagen.setHorizontalAlignment(SwingConstants.CENTER);
        imagen.setBorder(new EmptyBorder(10, 10, 10, 10));

        try {
            FlatSVGIcon iconoSvg = new FlatSVGIcon("imagenes/" + rutaImagen, 170, 140);

            if (iconoSvg.getIconWidth() > 0) {
                imagen.setIcon(iconoSvg);
            } else {
                throw new Exception("No se encontró el archivo SVG");
            }

        } catch (Exception e) {
            System.err.println("Error al cargar SVG: imagenes/" + rutaImagen);
            imagen.setText("Imagen");
            imagen.setFont(Fuentes.regular(16f));
            imagen.setForeground(Colores.GRAFITO);
        }

        JLabel texto = new JLabel(titulo);
        texto.setHorizontalAlignment(SwingConstants.CENTER);

        texto.setFont(Fuentes.bold(16f));
        texto.setForeground(Colores.GRAFITO);
        texto.setBorder(new EmptyBorder(0, 10, 15, 10));

        add(imagen, BorderLayout.CENTER);
        add(texto, BorderLayout.SOUTH);
    }

    // ESTE MÉTODO DIBUJA EL FONDO Y BORDE REDONDEADO
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setColor(new Color(47, 128, 237, 10));
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, 25, 25);

        g2.setColor(new Color(245, 245, 245));
        g2.setStroke(new BasicStroke(1));
        g2.drawRoundRect(2, 2, getWidth() - 4, getHeight() - 4, 25, 25);
        g2.dispose();
    }
}
