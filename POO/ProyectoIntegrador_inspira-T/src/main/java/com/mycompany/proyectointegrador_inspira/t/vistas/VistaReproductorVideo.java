/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.vistas;

import com.mycompany.proyectointegrador_inspira.t.navegacion.MenuLateral;
import com.mycompany.proyectointegrador_inspira.t.panels.PanelReproductorVideo;
import com.mycompany.proyectointegrador_inspira.t.util.Iconos;
import com.mycompany.proyectointegrador_inspira.t.panels.PanelFondoDecorativo;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author berth
 */
public class VistaReproductorVideo extends BaseView {

    public VistaReproductorVideo() {
        super("");
        getBarraSuperior().setSubtitulo("");
    }

    @Override
    protected MenuLateral crearMenu() {
        MenuLateral menu = new MenuLateral(
                "/imagenes/Logo.png",
                "/imagenes/MacetaMenu.png"
        );
        menu.addMenuItem(
                Iconos.cargar(Iconos.HOME, 22, Color.WHITE),
                "Inicio",
                e -> abrirInicio()
        );
        menu.addMenuItem(
                Iconos.cargar(Iconos.EXPLORAR, 22, Color.WHITE),
                "Explorar",
                e -> abrirExplorar()
        );
        menu.addMenuItem(
                Iconos.cargar(Iconos.APRENDIZAJE, 22, Color.WHITE),
                "Mi aprendizaje",
                e -> abrirAprendizaje()
        );
        menu.addMenuItem(
                Iconos.cargar(Iconos.CURSOS, 22, Color.WHITE),
                "Mis cursos",
                e -> abrirCursos()
        );
        return menu;
    }

    @Override
    protected JPanel createContent() {
        PanelFondoDecorativo fondo = new PanelFondoDecorativo();

        fondo.setLayout(new BorderLayout());

        fondo.add(new PanelReproductorVideo(), BorderLayout.CENTER);

        return fondo;
    }

    // Navegación
    private void abrirInicio() {
        System.out.println("Inicio");
    }

    private void abrirExplorar() {
        System.out.println("Explorar");
    }

    private void abrirAprendizaje() {
        System.out.println("Mi aprendizaje");
    }

    private void abrirCursos() {
        System.out.println("Mis cursos");
    }
}
