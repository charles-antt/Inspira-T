/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.vistas;

import com.mycompany.proyectointegrador_inspira.t.navegacion.MenuLateral;
import com.mycompany.proyectointegrador_inspira.t.navegacion.BarraSuperior;
import com.mycompany.proyectointegrador_inspira.t.layouts.DisenoPrincipal;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author berth
 */
public abstract class BaseView extends JFrame {
    protected MenuLateral menuLateral;
    protected BarraSuperior barraSuperior;
    protected DisenoPrincipal layout;

    public BaseView(String titulo) {
        configurarVentana();
        crearComponentes(titulo);
        construirVista();
    }

    private void configurarVentana() {
        setTitle("inspira-T");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
    }

    private void crearComponentes(String titulo) {
        menuLateral = crearMenu();
        barraSuperior = new BarraSuperior(titulo);
        layout = new DisenoPrincipal(menuLateral, barraSuperior);
        setContentPane(layout);
    }

    private void construirVista() {
        layout.setContent(createContent());
    }

    // Métodos que implementarán las vistas hijas
    protected abstract MenuLateral crearMenu();

    protected abstract JPanel createContent();

    public MenuLateral getMenuLateral() {
        return menuLateral;
    }

    public BarraSuperior getBarraSuperior() {
        return barraSuperior;
    }

    public DisenoPrincipal getDisenoPrincipal() {
        return layout;
    }
}
