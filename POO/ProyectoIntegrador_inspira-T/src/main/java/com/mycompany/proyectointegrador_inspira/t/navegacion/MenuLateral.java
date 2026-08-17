/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.navegacion;

import com.mycompany.proyectointegrador_inspira.t.imagen.ImagenEscalable;
import com.mycompany.proyectointegrador_inspira.t.util.Colores;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author berth
 */
public class MenuLateral extends JPanel {

    // Constantes
    private static final int MENU_WIDTH = 250;
    private static final int LOGO_WIDTH = 180;
    private static final int LOGO_HEIGHT = 120;
    private static final int IMAGE_WIDTH = 180;
    private static final int IMAGE_HEIGHT = 170;
    private static final int GAP = 7;

    // Componentes
    private JPanel content;
    private JPanel menuPanel;
    private JScrollPane scroll;
    private ImagenEscalable logo;
    private ImagenEscalable imagenInferior;

    private final List<BotonMenuLateral> buttons;

    // Constructor
    public MenuLateral(String logoPath, String imagenPath) {
        buttons = new ArrayList<>();
        configurarPanel();
        crearContenedor();
        crearLogo(logoPath);
        crearPanelBotones();
        crearImagenInferior(imagenPath);
        crearScroll();
    }

    // Configuración general
    private void configurarPanel() {
        setBackground(Colores.AZUL_CONFIANZA);
        setLayout(new BorderLayout());
        Dimension size = new Dimension(MENU_WIDTH, 0);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(new Dimension(MENU_WIDTH, Integer.MAX_VALUE));
    }

    // Contenedor
    private void crearContenedor() {
        content = new JPanel();
        content.setOpaque(false);
        content.setBorder(new EmptyBorder(20, 15, 20, 15));
        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS));

    }

    // Logo
    private void crearLogo(String ruta) {
        if (ruta == null || ruta.isBlank()) {
            ruta = "/imagenes/Logo.png";
        }

        logo = new ImagenEscalable(ruta);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        Dimension d = new Dimension(
                LOGO_WIDTH,
                LOGO_HEIGHT);
        logo.setPreferredSize(d);
        logo.setMaximumSize(d);
        logo.setMinimumSize(d);

        content.add(logo);
        content.add(Box.createVerticalStrut(25));
    }

    // Panel botones
    private void crearPanelBotones() {
        menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        content.add(menuPanel);
        content.add(Box.createVerticalGlue());
    }

    // Imagen inferior
    private void crearImagenInferior(String ruta) {
        if (ruta == null || ruta.isBlank()) {
            ruta = "/imagenes/Menu.png";
        }

        imagenInferior = new ImagenEscalable(ruta);
        imagenInferior.setAlignmentX(Component.CENTER_ALIGNMENT);
        Dimension d = new Dimension(
                IMAGE_WIDTH,
                IMAGE_HEIGHT);
        imagenInferior.setPreferredSize(d);
        imagenInferior.setMaximumSize(d);
        imagenInferior.setMinimumSize(d);

        content.add(imagenInferior);
    }

    // Scroll
    private void crearScroll() {
        scroll = new JScrollPane(content);
        scroll.setBorder(null);
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(18);

        add(scroll, BorderLayout.CENTER);
    }

    // Agregar botón
    public BotonMenuLateral addMenuItem(Icon icono, String texto, ActionListener listener) {
        BotonMenuLateral button = new BotonMenuLateral(icono, texto);
        button.addActionListener(e -> {
            seleccionar(button);
            if (listener != null) {
                listener.actionPerformed(e);
            }
        });

        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        menuPanel.add(button);
        menuPanel.add(Box.createVerticalStrut(GAP));

        buttons.add(button);
        //System.out.println(button.getInsets());
        //System.out.println(button.getMargin());

        menuPanel.add(button);
        menuPanel.add(Box.createVerticalStrut(GAP));
        menuPanel.revalidate();
        menuPanel.repaint();

        return button;
    }

    // Seleccionar botón
    private void seleccionar(
            BotonMenuLateral seleccionado) {
        for (BotonMenuLateral b : buttons) {
            b.setSelectedMenu(false);
        }
        seleccionado.setSelectedMenu(true);
    }

    // Seleccionar por índice
    public void seleccionar(int index) {
        if (index < 0 || index >= buttons.size()) {
            return;
        }
        seleccionar(buttons.get(index));
    }

    // Seleccionar por texto
    public void seleccionar(String texto) {
        for (BotonMenuLateral b : buttons) {
            if (b.getText().equalsIgnoreCase(texto)) {
                seleccionar(b);
                break;
            }
        }
    }

    // Limpiar menú
    public void clear() {
        buttons.clear();
        menuPanel.removeAll();
        menuPanel.revalidate();
        menuPanel.repaint();
    }

    // Habilitar / Deshabilitar
    public void setMenuEnabled(boolean enabled) {
        for (BotonMenuLateral b : buttons) {
            b.setEnabled(enabled);
        }
    }

    // Getters
    public BotonMenuLateral getButton(int index) {
        return buttons.get(index);
    }

    public int getButtonCount() {
        return buttons.size();
    }

    public List<BotonMenuLateral> getButtons() {
        return List.copyOf(buttons);
    }
}
