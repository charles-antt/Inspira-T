/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.vistas;

import com.mycompany.proyectointegrador_inspira.t.navegacion.MenuLateral;
import com.mycompany.proyectointegrador_inspira.t.panels.PanelPerfilAprendiente;
import com.mycompany.proyectointegrador_inspira.t.util.Iconos;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author berth
 */
public class VistaPerfilAprendiente extends BaseView {

    public VistaPerfilAprendiente() {
        super("Mi Perfil");
        // Subtítulo que aparece debajo del título
        getBarraSuperior().setSubtitulo("");

        // Ej.Seleccionando "Mi aprendizaje" si el perfil pertenece a esa sección.
        //getSideMenu().seleccionar(4);
    }

    @Override
    protected MenuLateral crearMenu() {

        MenuLateral menu = new MenuLateral("/imagenes/Logo.png", "/imagenes/MacetaMenu.png");
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
                e -> abrirMiAprendizaje()
        );

        menu.addMenuItem(
                Iconos.cargar(Iconos.CURSOS, 22, Color.WHITE),
                "Mis cursos",
                e -> abrirMisCursos()
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
        return new PanelPerfilAprendiente();
    }

    private void abrirInicio() {
        System.out.println("Abrir Inicio");
    }

    private void abrirExplorar() {
        System.out.println("Abrir Explorar");
    }

    private void abrirMiAprendizaje() {
        System.out.println("Abrir Mi Aprendizaje");
    }

    private void abrirMisCursos() {
        System.out.println("Abrir Mis Cursos");
    }
}
