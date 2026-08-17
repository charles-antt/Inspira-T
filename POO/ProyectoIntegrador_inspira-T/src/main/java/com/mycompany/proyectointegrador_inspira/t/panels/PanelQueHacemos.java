/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author berth
 */
public class PanelQueHacemos extends JPanel {

    public PanelQueHacemos() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Colores.BLANCO);
        setBorder(new EmptyBorder(30, 40, 30, 40));

        //TÍTULO PRINCIPAL
        JLabel titulo = new JLabel("¿Qué hacemos?");
        titulo.setFont(Fuentes.bold(28f));
        titulo.setForeground(Colores.GRAFITO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(titulo);
        add(Box.createVerticalStrut(30));

        // BLOQUES DE INFORMACIÓN
        JPanel tarjetas = new JPanel(new GridLayout(1, 4, 0, 0));
        tarjetas.setBackground(Color.WHITE);

        tarjetas.add(crearBloque(
                "educamos.svg",
                "Educamos",
                "Ofrecemos cursos, lecciones<br>y materiales sobre saberes<br>ancestrales y cultura.",
                new Color(47, 128, 237),
                true
        ));

        tarjetas.add(crearBloque(
                "preservamos.svg",
                "Preservamos",
                "Documentamos y protegemos<br>lenguas, tradiciones y<br>conocimientos comunitarios.",
                new Color(45, 212, 191),
                true
        ));

        tarjetas.add(crearBloque(
                "compartimos.svg",
                "Compartimos",
                "Difundimos historias<br>y recursos para<br>inspirar al mundo.",
                new Color(123, 97, 255),
                true
        ));

        tarjetas.add(crearBloque(
                "fortalecemos.svg",
                "Fortalecemos",
                "Impulsamos a las comunidades<br>a través de la colaboración y el respeto.",
                new Color(31, 60, 136),
                false
        ));
        add(tarjetas);
    }

    // MÉTODO PARA CREAR CADA BLOQUE CENTRADO VERTICALMENTE
    private JPanel crearBloque(String rutaIcono, String titulo, String texto, Color colorTitulo, boolean conLineaDivisoria) {

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Línea divisoria vertical
        if (conLineaDivisoria) {
            panel.setBorder(new CompoundBorder(
                    new MatteBorder(0, 0, 0, 2, new Color(46, 52, 64, 60)),
                    new EmptyBorder(10, 15, 10, 15)
            ));
        } else {
            panel.setBorder(new EmptyBorder(10, 15, 10, 15));
        }

        //ÍCONO SUPERIOR
        JLabel icono = new JLabel();
        icono.setAlignmentX(Component.CENTER_ALIGNMENT);

        try {
            FlatSVGIcon iconoSvg = new FlatSVGIcon("imagenes/" + rutaIcono, 50, 50);

            if (iconoSvg.getIconWidth() > 0) {
                FlatSVGIcon.ColorFilter filtro = new FlatSVGIcon.ColorFilter();
                filtro.add(Color.BLACK, colorTitulo);
                iconoSvg.setColorFilter(filtro);
                icono.setIcon(iconoSvg);
            } else {
                throw new Exception("Error al procesar el archivo SVG");
            }
        } catch (Exception e) {
            System.err.println("No se pudo cargar el SVG en: " + rutaIcono);
            icono.setText("★");
            icono.setForeground(colorTitulo);
        }

        //TÍTULO
        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(Fuentes.bold(22f));
        lblTitulo.setForeground(colorTitulo);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //TEXTO DESCRIPTIVO
        JLabel lblTexto = new JLabel("<html><center>" + texto + "<center></html>");
        lblTexto.setFont(Fuentes.regular(13f));
        lblTexto.setForeground(Colores.GRAFITO);
        lblTexto.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTexto.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(icono);
        panel.add(Box.createVerticalStrut(15));
        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblTexto);

        return panel;
    }
}
