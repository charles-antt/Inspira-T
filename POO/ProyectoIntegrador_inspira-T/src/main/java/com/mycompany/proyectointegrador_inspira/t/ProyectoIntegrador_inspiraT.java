/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectointegrador_inspira.t;

import com.mycompany.proyectointegrador_inspira.t.vistas.LandingPageView;
import com.mycompany.proyectointegrador_inspira.t.vistas.VistaPerfilAprendiente;
import com.mycompany.proyectointegrador_inspira.t.vistas.VistaPerfilInstructor;
import com.mycompany.proyectointegrador_inspira.t.vistas.VistaSubirNuevoContenido;
import com.mycompany.proyectointegrador_inspira.t.vistas.VistaReproductorVideo;
import com.mycompany.proyectointegrador_inspira.t.vistas.VistaInicioSesion;
import com.mycompany.proyectointegrador_inspira.t.vistas.VistaRegistro;
import com.mycompany.proyectointegrador_inspira.t.vistas.VistaMisCursos;

/**
 *
 * @author berth
 */
public class ProyectoIntegrador_inspiraT {

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        com.mycompany.proyectointegrador_inspira.t.util.Fuentes.cargar();
        java.awt.EventQueue.invokeLater(() -> {
            new LandingPageView().setVisible(true);
            // new VistaInicioSesion().setVisible(true);
            // new VistaRegistro().setVisible(true);
            // new VistaPerfilAprendiente().setVisible(true);
            // new VistaSubirNuevoContenido().setVisible(true);
            // new VistaReproductorVideo().setVisible(true);
            // new VistaMisCursos().setVisible(true);
            // new VistaPerfilInstructor().setVisible(true);
        });
    }
}
