/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Iconos;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author berth
 */
public class PanelReproductorVideo extends JPanel {
    //Paneles
    private PanelVideo panelVideo;
    //private ControlesVideoPanel panelControles;
    private PanelInformacionVideo panelInformacion;
    private PanelComentarios panelComentarios;
    private PanelVideosSugeridos panelSugeridos;

    public PanelReproductorVideo() {
        construir();
    }

    private void construir() {

        setOpaque(false);

        setLayout(new MigLayout(
                "fill,insets 25",
                "[grow 75,fill][grow 25,fill]",
                "[grow]"
        ));
        //Columna izquierda
        JPanel izquierda = new JPanel();
        izquierda.setOpaque(false);
        izquierda.setLayout(new MigLayout(
                "fillx,insets 0",
                "[grow]",
                "[][pref!][]"
        ));
        panelVideo = new PanelVideo();
        //panelControles = new ControlesVideoPanel();
        panelInformacion = new PanelInformacionVideo();
        panelComentarios = new PanelComentarios();

        izquierda.add(panelVideo, "growx,h 420!,wrap");
        //izquierda.add(panelControles, "growx,wrap");
        izquierda.add(panelInformacion, "growx,wrap");
        izquierda.add(panelComentarios, "grow,pushy");
        //Columna derecha
        System.out.println(Iconos.class.getResource("/imagenes/play.svg"));
        panelSugeridos = new PanelVideosSugeridos();
        add(izquierda, "grow");

        add(panelSugeridos, "growy,wmin 300,wmax 360");
    }

    //Getters
    public PanelVideo getPanelVideo() {
        return panelVideo;
    }

    /**
     * public ControlesVideoPanel getPanelControles() { return panelControles;
     * }*
     */
    public PanelInformacionVideo getPanelInformacion() {
        return panelInformacion;
    }

    public PanelComentarios getPanelComentarios() {
        return panelComentarios;
    }

    public PanelVideosSugeridos getPanelSugeridos() {
        return panelSugeridos;
    }
}
