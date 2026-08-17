/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.componentes.BotonRedondeado;
import com.mycompany.proyectointegrador_inspira.t.util.Colores;
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
public class PanelInformacionVideo extends JPanel {
    //Componentes

    private JLabel lblCategoria;
    private JLabel lblTitulo;
    private JLabel lblFoto;
    private JLabel lblInstructor;
    private JLabel lblRol;
    private BotonRedondeado btnSeguir;
    private JButton btnLike;
    private JButton btnDislike;
    private JButton btnMas;
    private JTextArea txtDescripcion;
    private JButton btnMostrarMas;

    public PanelInformacionVideo() {
        construir();
    }

    private void construir() {
        setOpaque(false);
        setLayout(new MigLayout(
                "fillx,insets 0",
                "[grow][right]",
                "[][]5[]5[]"));

        // Categoría
        lblCategoria = new JLabel("ARTESANÍAS");
        lblCategoria.setFont(Fuentes.bold(14f));
        lblCategoria.setForeground(Colores.MORADO);
        add(lblCategoria, "span 2,wrap");

        // Título
        lblTitulo = new JLabel("Tejido ancestral en telar de cintura paso a paso");
        lblTitulo.setFont(Fuentes.bold(28f));
        lblTitulo.setForeground(Colores.GRAFITO);
        add(lblTitulo, "span 2,wrap");

        // Instructor
        JPanel panelInstructor = crearPanelInstructor();
        JPanel panelAcciones = crearPanelAcciones();
        add(panelInstructor, "growx");
        add(panelAcciones, "right,wrap");

        // Descripción
        txtDescripcion = new JTextArea();
        txtDescripcion.setOpaque(false);
        txtDescripcion.setEditable(false);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setFont(Fuentes.regular(15f));
        txtDescripcion.setForeground(Colores.GRAFITO);
        txtDescripcion.setBorder(null);
        txtDescripcion.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                + "Vestibulum in nisl nisi. Curabitur finibus iaculis purus "
                + "eu sagittis. Sed condimentum lacus ac metus luctus accumsan. "
                + "Vivamus bibendum lorem quis libero vulputate, sed convallis "
                + "eros pretium.");

        add(txtDescripcion, "span 2,growx,h 70!,wrap");

        // Mostrar más
        btnMostrarMas = new JButton("Mostrar más");
        btnMostrarMas.setBorderPainted(false);
        btnMostrarMas.setContentAreaFilled(false);
        btnMostrarMas.setFocusPainted(false);
        btnMostrarMas.setForeground(Colores.MORADO);
        btnMostrarMas.setFont(Fuentes.medium(15f));
        btnMostrarMas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnMostrarMas, "span 2,left");
    }

    // Panel Instructor
    private JPanel crearPanelInstructor() {
        JPanel panel = new JPanel(new MigLayout(
                "insets 0",
                "[]10[grow]15[]",
                "[][]"));
        panel.setOpaque(false);
        //JLabel lblFoto = new JLabel(new FlatSVGIcon("/imagenes/user.svg",50,50));
        lblFoto = new JLabel();
        lblFoto.setIcon(Iconos.cargar(Iconos.USER, 50, Colores.GRAFITO));
        //lblFoto.setPreferredSize(new Dimension(50,50));

        /**
         * lblFoto.setIcon(new FlatSVGIcon( "/imagenes/user.svg", 52,
                52));*
         */
        lblInstructor = new JLabel("Antonia Gómez");
        lblInstructor.setFont(Fuentes.medium(16f));
        lblRol = new JLabel("Instructor(a)");
        lblRol.setFont(Fuentes.bold(14f));
        lblRol.setForeground(Colores.MORADO);

        JPanel datos = new JPanel(new GridLayout(2, 1));
        datos.setOpaque(false);
        datos.add(lblInstructor);
        datos.add(lblRol);
        btnSeguir = new BotonRedondeado("Seguir", Colores.AZUL_TECNOLOGICO, 40);
        btnSeguir.setPreferredSize(new Dimension(100, 30));

        panel.add(lblFoto);
        panel.add(datos, "growx");
        panel.add(btnSeguir);
        return panel;
    }

    // Panel acciones
    private JPanel crearPanelAcciones() {
        JPanel panel = new JPanel(
                new FlowLayout(
                        FlowLayout.RIGHT,
                        10,
                        0));
        panel.setOpaque(false);

        btnLike = crearBoton(Iconos.cargar(Iconos.LIKE, 20, Colores.GRAFITO));
        btnDislike = crearBoton(Iconos.cargar(Iconos.DISLIKE, 20, Colores.GRAFITO));
        btnMas = crearBoton(Iconos.cargar(Iconos.MORE, 20, Colores.GRAFITO));
        btnMas.setBorderPainted(false);
        btnMas.setContentAreaFilled(false);
        btnMas.setFocusPainted(false);
        panel.add(btnLike);
        panel.add(btnDislike);
        panel.add(btnMas);
        return panel;
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
                //boton.setOpaque(true);
                boton.setBackground(new Color(255, 255, 255, 40));
                //boton.repaint();
            }

            /**
             * @Override public void mouseExited(java.awt.event.MouseEvent e) {
             * boton.setOpaque(false); boton.setBackground(null);
             * //boton.repaint();
        }*
             */
        });
        return boton;
    }

    // Getters
    public JButton getBtnSeguir() {
        return btnSeguir;
    }

    public JButton getBtnLike() {
        return btnLike;
    }

    public JButton getBtnDislike() {
        return btnDislike;
    }

    public JButton getBtnMas() {
        return btnMas;
    }

    public JButton getBtnMostrarMas() {
        return btnMostrarMas;
    }

    // Setters
    public void setCategoria(String categoria) {
        lblCategoria.setText(categoria.toUpperCase());
    }

    public void setTitulo(String titulo) {
        lblTitulo.setText(titulo);
    }

    public void setInstructor(String nombre) {
        lblInstructor.setText(nombre);
    }

    public void setRol(String rol) {
        lblRol.setText(rol);
    }

    public void setDescripcion(String descripcion) {
        txtDescripcion.setText(descripcion);
    }
}
