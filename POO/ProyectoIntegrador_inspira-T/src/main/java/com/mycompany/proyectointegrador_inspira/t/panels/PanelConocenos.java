/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author berth
 */
public class PanelConocenos extends JPanel {

    public PanelConocenos() {
        setLayout(new BorderLayout());
        setBackground(Colores.BLANCO);
        setBorder(new EmptyBorder(10, 40, 10, 40));

        // PANEL PRINCIPAL
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);

        JPanel filaTitulo = new JPanel();
        filaTitulo.setLayout(new BoxLayout(filaTitulo, BoxLayout.X_AXIS));
        filaTitulo.setBackground(Color.WHITE);
        filaTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JSeparator lineaIzquierda = new JSeparator(JSeparator.HORIZONTAL);
        lineaIzquierda.setForeground(Colores.MORADO); // Color de la línea
        lineaIzquierda.setPreferredSize(new Dimension(100, 2));
        lineaIzquierda.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2)); // Altura de la línea

        // Título principal
        JLabel titulo = new JLabel("Conócenos");
        titulo.setFont(Fuentes.bold(32f));
        titulo.setForeground(Colores.GRAFITO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JSeparator lineaDerecha = new JSeparator(JSeparator.HORIZONTAL);
        lineaDerecha.setForeground(Colores.MORADO);
        lineaDerecha.setPreferredSize(new Dimension(100, 2));
        lineaDerecha.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));

        filaTitulo.add(Box.createHorizontalStrut(5));
        filaTitulo.add(lineaIzquierda);
        filaTitulo.add(titulo);
        filaTitulo.add(lineaDerecha);
        filaTitulo.add(Box.createHorizontalStrut(5));

        panel.add(filaTitulo);
        panel.add(Box.createVerticalStrut(20));
        add(panel, BorderLayout.NORTH);
        // Panel que contiene Misión y Visión
        JPanel contenido = new JPanel(new GridLayout(1, 2, 30, 0));
        contenido.setBackground(Color.WHITE);

        // Misión
        contenido.add(crearTarjeta(
                "Misión",
                "<html><div style='text-align:justify; width:360px;height:80px'>"
                + "Desarrollar un ejecutable innovador que preserve, difunda y transmita "
                + "los conocimientos tradicionales, culturales y ancestrales mediante cursos, "
                + "videos, tutoriales y clases en línea impartidos por expertos y portadores "
                + "de estos saberes."
                + "</div></html>",
                "mision.svg"
        ));

        // Visión
        contenido.add(crearTarjeta(
                "Visión",
                "<html><div style='text-align:justify; width:360px;height:80px'>"
                + "Convertir el proyecto en un sistema para la preservación y enseñanza de "
                + "conocimientos tradicionales y patrimonio cultural, reconocido por conectar "
                + "a personas de diferentes regiones y generaciones mediante el uso de la tecnología."
                + "</div></html>",
                "vision.svg"
        ));

        add(contenido, BorderLayout.CENTER);
    }

    private JPanel crearTarjeta(String titulo, String descripcion, String rutaImagen) {

        // 1. SOLUCIÓN: Sobrescribir paintComponent para dibujar el fondo y borde redondo
        JPanel tarjeta = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();

                // Pintar fondo
                g2.setColor(getBackground());
                g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 25, 25); // 25 es el radio del redondeo

                // Pintar la línea del borde redondeado
                g2.setColor(new Color(220, 220, 250));
                g2.setStroke(new BasicStroke(1));
                g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 25, 25);

                g2.dispose();
            }
        };

        tarjeta.setBackground(new Color(235, 230, 250, 70));
        tarjeta.setOpaque(false);
        tarjeta.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel contenidoInterno = new JPanel();
        contenidoInterno.setLayout(new BoxLayout(contenidoInterno, BoxLayout.X_AXIS));
        contenidoInterno.setOpaque(false);

        JLabel icono = new JLabel();
        icono.setBorder(new EmptyBorder(10, 10, 10, 15));

        try {
            FlatSVGIcon iconoSvg = new FlatSVGIcon("imagenes/" + rutaImagen, 50, 50);

            if (iconoSvg.getIconWidth() > 0) {
                icono.setIcon(iconoSvg);
            } else {
                throw new Exception("No se pudo cargar el recurso SVG");
            }
        } catch (Exception e) {
            System.err.println("Error al cargar icono SVG: imagenes/" + rutaImagen);
            icono.setText("★");
            icono.setForeground(Colores.GRAFITO);
        }

        JPanel texto = new JPanel();
        texto.setLayout(new BoxLayout(texto, BoxLayout.Y_AXIS));
        texto.setOpaque(false);

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(Fuentes.bold(19f));
        lblTitulo.setForeground(Colores.GRAFITO);

        JLabel lblDescripcion = new JLabel(descripcion);
        lblDescripcion.setFont(Fuentes.medium(13f));
        lblDescripcion.setForeground(Colores.GRAFITO);

        texto.add(lblTitulo);
        texto.add(Box.createVerticalStrut(8));
        texto.add(lblDescripcion);

        contenidoInterno.add(icono);
        contenidoInterno.add(texto);

        tarjeta.add(contenidoInterno, BorderLayout.CENTER);

        return tarjeta;
    }
}
