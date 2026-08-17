/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author berth
 */
public class PanelVisibilidad extends PanelTarjeta {

    //Componentes
    private JRadioButton rbPublico;
    private JRadioButton rbNoListado;
    private JRadioButton rbPrivado;
    private ButtonGroup grupo;

    public PanelVisibilidad() {
        construir();
    }

    private void construir() {
        setLayout(new MigLayout(
                "fillx,insets 5,gap 5",
                "[grow,fill]",
                "[][]5[]5[]5[]push"));
        //setCardSize(350, 250);

        JLabel titulo = new JLabel("Visibilidad");
        titulo.setFont(Fuentes.bold(18f));

        JLabel subtitulo = new JLabel("Elige quién puede ver tu vídeo");
        subtitulo.setFont(Fuentes.regular(16f));
        subtitulo.setForeground(Colores.GRAFITO);

        add(titulo, "growx,wrap");
        add(subtitulo, "growx,wrap");

        grupo = new ButtonGroup();

        rbPublico = crearOpcion("Público", "Cualquiera puede ver este contenido");

        rbNoListado = crearOpcion("No listado", "Solo quien tenga el enlace puede verlo");

        rbPrivado = crearOpcion("Privado", "Solo tú puedes ver este contenido");
        grupo.add(rbPublico);
        grupo.add(rbNoListado);
        grupo.add(rbPrivado);

        rbPublico.setSelected(true);

        add(rbPublico, "growx,wrap");
        add(rbNoListado, "growx,wrap");
        add(rbPrivado, "growx");
        add(Box.createVerticalGlue(), "pushy,growy");
    }

    // Crear opción
    private JRadioButton crearOpcion(String titulo, String descripcion) {
        String html
                = "<html>"
                + "<div style='width:220px'>"
                + "<b>" + titulo + "</b><br>"
                + "<span style='color:#2E3440;'>"
                + descripcion
                + "</span>"
                + "</div></html>";

        JRadioButton radio = new JRadioButton(html);
        radio.setOpaque(false);
        radio.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        radio.setFont(Fuentes.medium(16f));
        radio.setForeground(Colores.GRAFITO);
        radio.setIconTextGap(16);
        radio.setFocusPainted(false);
        radio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        radio.setPreferredSize(new Dimension(0, 50));
        radio.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        Color verdeSeleccionado = new Color(45, 212, 191);
        // Icono cuando NO está seleccionado (Gris Grafito)
        radio.setIcon(new RadioIcon(false, Colores.GRAFITO));
        // Icono cuando SÍ está seleccionado (Verde)
        radio.setSelectedIcon(new RadioIcon(true, verdeSeleccionado));
        return radio;
    }

    // Getters
    public JRadioButton getPublico() {
        return rbPublico;
    }

    public JRadioButton getNoListado() {
        return rbNoListado;
    }

    public JRadioButton getPrivado() {
        return rbPrivado;
    }

    public String getVisibilidadSeleccionada() {
        if (rbPublico.isSelected()) {
            return "PUBLICO";
        }

        if (rbNoListado.isSelected()) {
            return "NO_LISTADO";
        }
        return "PRIVADO";
    }

    private static class RadioIcon implements Icon {

        private final boolean seleccionado;
        private final Color colorCírculo;

        public RadioIcon(boolean seleccionado, Color colorCírculo) {
            this.seleccionado = seleccionado;
            this.colorCírculo = colorCírculo;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // 1. Dibujar círculo exterior
            g2.setColor(colorCírculo);
            g2.setStroke(new java.awt.BasicStroke(2f));
            g2.drawOval(x + 2, y + 2, 16, 16);

            // 2. Si está seleccionado, dibujar el punto central relleno del mismo color
            if (seleccionado) {
                g2.fillOval(x + 6, y + 6, 8, 8);
            }

            g2.dispose();
        }

        @Override
        public int getIconWidth() {
            return 20;
        }

        @Override
        public int getIconHeight() {
            return 20;
        }
    }
}
