/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.layouts;

import com.mycompany.proyectointegrador_inspira.t.navegacion.MenuLateral;
import com.mycompany.proyectointegrador_inspira.t.navegacion.BarraSuperior;

import javax.swing.*;
import java.awt.*;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;

/**
 *
 * @author berth
 */
public class DisenoPrincipal extends JPanel {

    private final MenuLateral menuLateral;
    private final BarraSuperior barraSuperior;

    private final JPanel content;

    public DisenoPrincipal(MenuLateral menu, BarraSuperior bar) {
        this.menuLateral = menu;
        this.barraSuperior = bar;

        setLayout(new BorderLayout());
        //setBackground(Colores.FONDO);
        setBackground(Colores.BLANCO);
        // Menú
        add(menuLateral, BorderLayout.WEST);
        // Área derecha
        JPanel right = new JPanel(new BorderLayout());
        right.setOpaque(false);
        right.add(barraSuperior, BorderLayout.NORTH);

        // Contenido
        content = new JPanel(new BorderLayout());
        content.setOpaque(false);
        content.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        //content.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        JScrollPane scroll = new JScrollPane(content);
        scroll.setBorder(null);
        scroll.getViewport().setOpaque(false);
        scroll.getViewport().setBackground(Colores.FONDO);
        scroll.setBackground(Colores.BLANCO);
        scroll.getVerticalScrollBar().setUnitIncrement(18);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        right.add(scroll);
        add(right);
    }

    public void setContent(Component component) {
        content.removeAll();
        content.add(component, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    public JPanel getContentPanel() {
        return content;
    }

    public MenuLateral getMenuLateral() {
        return menuLateral;
    }

    public BarraSuperior getBarraSuperior() {
        return barraSuperior;
    }
}
