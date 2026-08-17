/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author berth
 */
public class PanelVideosSugeridos extends JPanel {

    //Componentes
    private JLabel lblTitulo;
    private JPanel panelLista;
    private JScrollPane scroll;

    public PanelVideosSugeridos() {
        construir();
    }

    private void construir() {
        setOpaque(false);
        //setBackground(new Color(31, 60, 136, 18));
        setLayout(new BorderLayout());
        // Panel principal
        JPanel contenido = new JPanel(new MigLayout(
                "fillx,insets 10",
                "[grow]",
                "[][grow]"));
        contenido.setOpaque(false);
        // Título
        lblTitulo = new JLabel("Videos sugeridos");
        lblTitulo.setFont(Fuentes.bold(18f));
        lblTitulo.setForeground(Colores.GRAFITO);
        contenido.add(lblTitulo, "wrap");
        // Lista
        panelLista = new JPanel();
        panelLista.setOpaque(false);
        panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
        // Ejemplos
        panelLista.add(new VideoItem(
                "/imagenes/alfareria.png",
                "Alfarería tradicional",
                "María Hernández",
                "2 540 vistas • hace 2 días"));
        panelLista.add(Box.createVerticalStrut(2));
        panelLista.add(new VideoItem(
                "/imagenes/plantasM.png",
                "Plantas medicinales de nuestra tierra",
                "Juan Pérez",
                "8 214 vistas • hace 5 días"));
        panelLista.add(Box.createVerticalStrut(2));
        panelLista.add(new VideoItem(
                "/imagenes/cocinaT.png",
                "Cocina tradicional",
                "Pepe Ramírez",
                "4 025 vistas • hace 1 semana"));
        panelLista.add(Box.createVerticalStrut(2));
        panelLista.add(new VideoItem(
                "/imagenes/remediosH.png",
                "Remedios herbales",
                "Elia Martínez",
                "6 815 vistas • hace 3 días"));
        panelLista.add(Box.createVerticalStrut(2));
        panelLista.add(new VideoItem(
                "/imagenes/remediosH.png",
                "Remedios herbales",
                "Lizbeth Cruz",
                "6 815 vistas • hace 3 días"));
        panelLista.add(Box.createVerticalStrut(2));
        panelLista.add(new VideoItem(
                "/imagenes/remediosH.png",
                "Remedios herbales",
                "Ilda Ruiz",
                "6 815 vistas • hace 3 días"));
        panelLista.add(Box.createVerticalStrut(2));
        panelLista.add(new VideoItem(
                "/imagenes/remediosH.png",
                "Remedios herbales",
                "Lore Santos",
                "6 815 vistas • hace 3 días"));
        panelLista.add(Box.createVerticalStrut(2));
        panelLista.add(new VideoItem(
                "/imagenes/remediosH.png",
                "Remedios herbales",
                "Ana Portés",
                "6 815 vistas • hace 3 días"));
        // Scroll
        scroll = new JScrollPane(panelLista);
        scroll.setBorder(null);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(18);
        contenido.add(scroll, "grow,push");
        add(contenido, BorderLayout.CENTER);
    }

    // API pública
    public void agregarVideo(VideoItem item) {
        if (panelLista.getComponentCount() > 0) {
            panelLista.add(Box.createVerticalStrut(12));
        }
        panelLista.add(item);
        panelLista.revalidate();
        panelLista.repaint();
    }

    public void limpiar() {
        panelLista.removeAll();
        panelLista.revalidate();
        panelLista.repaint();
    }

    // Getters
    public JPanel getPanelLista() {
        return panelLista;
    }

    public JScrollPane getScrollPane() {
        return scroll;
    }
}
