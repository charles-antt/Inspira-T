/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.vistas;

import com.mycompany.proyectointegrador_inspira.t.navegacion.MenuLateral;
import com.mycompany.proyectointegrador_inspira.t.panels.PanelPerfilInstructor;
import com.mycompany.proyectointegrador_inspira.t.util.Iconos;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author berth
 */
public class VistaPerfilInstructor extends BaseView {

    public VistaPerfilInstructor() {
        super("Mi Perfil");
        // Texto debajo del título
        getBarraSuperior().setSubtitulo("");
    }

    @Override
    protected MenuLateral crearMenu() {

        MenuLateral menu = new MenuLateral("/imagenes/Logo.png", "/imagenes/MacetaMenu.png");
        menu.addMenuItem(
                Iconos.cargar(Iconos.HOME, 22, Color.WHITE),
                "Inicio",
                e -> abrirInicio()
        );

        /**
         * menu.addMenuItem( Iconos.cargar(Iconos.PERFIL,22,Color.WHITE), "Mi
         * perfil", e -> {}
        );*
         */
        return menu;

    }

    @Override
    protected JPanel createContent() {

        return new PanelPerfilInstructor();
    }

    // Navegación (temporal)
    private void abrirInicio() {
        System.out.println("Abrir Inicio");
    }
}
