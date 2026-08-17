/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.vistas;

import com.mycompany.proyectointegrador_inspira.t.panels.PanelPrincipal;
import com.mycompany.proyectointegrador_inspira.t.componentes.BotonRedondeado;
import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
import com.mycompany.proyectointegrador_inspira.t.util.Iconos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author berth
 */
public class LandingPageView extends JFrame {

    // Componentes
    private JLabel lblLogo;
    private JButton btnInicio;
    private JButton btnOferta;
    private JButton btnConocenos;
    private BotonRedondeado btnLogin;
    private PanelPrincipal principal;
    private JScrollPane scroll;

    public LandingPageView() {
        //setSize(1300,798);
        construir();
    }

    private void construir() {
        setTitle("inspira-T");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        // MENÚ 
        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setBackground(Color.WHITE);
        setContentPane(contenedor);

        JPanel barra = new JPanel(new BorderLayout());
        barra.setBackground(Color.WHITE);
        barra.setBorder(new EmptyBorder(10, 30, 10, 30));

        // LOGO 
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(Color.WHITE);
        panelLogo.setLayout(new BoxLayout(panelLogo, BoxLayout.Y_AXIS));

        lblLogo = new JLabel();
        FlatSVGIcon logo = new FlatSVGIcon("imagenes/logoSlogan.svg", 170, 130);

        lblLogo.setIcon(logo);
        panelLogo.add(lblLogo);
        barra.add(panelLogo, BorderLayout.WEST);

        JPanel menu = new JPanel();
        menu.setOpaque(false);
        menu.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

        btnInicio = crearBotonMenu("Inicio");
        btnInicio.setFont(Fuentes.bold(18f));

        btnOferta = crearBotonMenu("Oferta Educativa");
        btnOferta.setFont(Fuentes.bold(18f));

        btnConocenos = crearBotonMenu("Conócenos");
        btnConocenos.setFont(Fuentes.bold(18f));

        menu.add(btnInicio);
        menu.add(btnOferta);
        menu.add(btnConocenos);
        barra.add(menu, BorderLayout.CENTER);

        // BOTÓN LOGIN 
        btnLogin = new BotonRedondeado("Iniciar sesión", Color.WHITE, 25);
        btnLogin.setFont(Fuentes.bold(18f));

        btnLogin.setForeground(Colores.AZUL_TECNOLOGICO);
        btnLogin.setColor(Color.WHITE);
        btnLogin.setColorTexto(Colores.AZUL_TECNOLOGICO);
        btnLogin.setColorBorde(Colores.AZUL_TECNOLOGICO);
        btnLogin.setIcon(Iconos.cargar(Iconos.USER, 20, Colores.AZUL_TECNOLOGICO));
        btnLogin.setIconTextGap(10);
        btnLogin.setPreferredSize(new Dimension(200, 45));

        JPanel contenedorLogin = new JPanel(new GridBagLayout());
        contenedorLogin.setOpaque(false);
        contenedorLogin.add(btnLogin);
        barra.add(contenedorLogin, BorderLayout.EAST);
        contenedor.add(barra, BorderLayout.NORTH);

        principal = new PanelPrincipal();

        scroll = new JScrollPane(principal);

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        contenedor.add(scroll, BorderLayout.CENTER);

        btnInicio.addActionListener(e -> {

            seleccionar("Inicio");

            desplazarA(
                    principal.getPanelHero()
            );
        });

        btnOferta.addActionListener(e -> {

            seleccionar("Oferta");

            desplazarA(
                    principal.getPanelOferta()
            );
        });

        btnConocenos.addActionListener(e -> {

            seleccionar("Conocenos");

            desplazarA(
                    principal.getPanelConocenos()
            );
        });
    }

    private void desplazarA(JComponent componente) {
        if (componente == null || scroll == null) {
            return;
        }

        SwingUtilities.invokeLater(() -> {
            int posicionYTarget = componente.getY();
            scroll.getVerticalScrollBar().setValue(posicionYTarget);
        });
    }

    // Crear botones del menú 
    private JButton crearBotonMenu(String texto) {
        JButton boton = new JButton(texto);
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.setForeground(Colores.GRAFITO);
        boton.addMouseListener(
                new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(
                    java.awt.event.MouseEvent e
            ) {

                boton.setForeground(
                        Colores.AZUL_TECNOLOGICO
                );
            }

            @Override
            public void mouseExited(
                    java.awt.event.MouseEvent e
            ) {
                if (!estaSeleccionado(boton)) {

                    boton.setForeground(
                            Colores.GRAFITO
                    );
                }
            }
        }
        );
        return boton;

    }

    private boolean estaSeleccionado(JButton boton) {

        return boton.getForeground()
                .equals(
                        Colores.AZUL_TECNOLOGICO
                );
    }

    public JButton getBtnOferta() {
        return btnOferta;
    }

    public JButton getBtnConocenos() {
        return btnConocenos;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    //Resaltar la opción seleccionada. 
    public void seleccionar(String opcion) {
        btnInicio.setForeground(Colores.GRAFITO);
        btnOferta.setForeground(Colores.GRAFITO);
        btnConocenos.setForeground(Colores.GRAFITO);
        switch (opcion) {
            case "Inicio" ->
                btnInicio.setForeground(Colores.AZUL_TECNOLOGICO);

            case "Oferta" ->
                btnOferta.setForeground(Colores.AZUL_TECNOLOGICO);

            case "Conocenos" ->
                btnConocenos.setForeground(Colores.AZUL_TECNOLOGICO);

        }

    }
}
