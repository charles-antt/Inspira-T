/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.vistas;

import com.mycompany.proyectointegrador_inspira.t.util.Iconos;
import com.mycompany.proyectointegrador_inspira.t.navegacion.MenuLateral;
import com.mycompany.proyectointegrador_inspira.t.panels.PanelSubirNuevoContenido;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author berth
 */
public class VistaSubirNuevoContenido extends BaseView {

    public VistaSubirNuevoContenido() {
        super("Subir nuevo contenido");
        //Texto abajo del título
        getBarraSuperior().setSubtitulo("Compartir tus conocimientos ancestrales con nuestra comunidad");
    }

    @Override
    protected MenuLateral crearMenu() {
        MenuLateral menu = new MenuLateral("/imagenes/Logo.png", "/imagenes/MacetaMenu.png");
        menu.addMenuItem(
                Iconos.cargar(Iconos.HOME, 22, Color.WHITE),
                "Inicio",
                e -> abrirInicio()
        );
        return menu;
    }

    @Override
    protected JPanel createContent() {
        return new PanelSubirNuevoContenido();
    }

    // Navegación (temporal)
    private void abrirInicio() {
        System.out.println("Abrir Inicio");
    }
}
