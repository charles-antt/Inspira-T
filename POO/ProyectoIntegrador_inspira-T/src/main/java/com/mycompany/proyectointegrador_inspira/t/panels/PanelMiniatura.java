/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.componentes.ImageDropZone;
import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
import com.mycompany.proyectointegrador_inspira.t.componentes.BotonRedondeado;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author berth
 */
public class PanelMiniatura extends PanelTarjeta {

    //Componentes
    //private JLabel lblPreview;
    private ImageDropZone dropZone;
    private BotonRedondeado btnSeleccionar;

    public PanelMiniatura() {
        construir();
    }

    private void construir() {
        setLayout(new MigLayout(
                "fillx,insets 1",
                "[grow,fill]",
                "[]3[]1[][]"));
        setCardSize(330, 250);
        // Título
        JLabel titulo = new JLabel("Miniatura");

        titulo.setFont(Fuentes.bold(18f));

        add(titulo, "center,wrap");

        JLabel descripcion = new JLabel("Selecciona una imagen que represente tu video.");
        descripcion.setFont(Fuentes.regular(16f));

        descripcion.setForeground(Colores.GRAFITO);

        add(descripcion, "center,wrap");

        dropZone = new ImageDropZone();
        add(dropZone, "grow,pushx,h 100!,wrap");

        btnSeleccionar = new BotonRedondeado("Subir miniatura", Colores.AZUL_TECNOLOGICO);

        //btnSeleccionar.addActionListener(e -> dropZone.abrirSelector());
        btnSeleccionar.addActionListener(e -> {
            //javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();

            //Filtro para imágenes comunes
            javax.swing.filechooser.FileNameExtensionFilter filtroImagenes
                    = new javax.swing.filechooser.FileNameExtensionFilter("Imágenes (JPG, PNG, GIF, WEBP)", "jpg", "jpeg", "png", "gif", "webp");

            // Si tu clase ImageDropZone tiene un método para recibir el filtro, pásalo aquí:
            dropZone.abrirSelector(filtroImagenes);
        });
        JLabel formatos = new JLabel("Recomendado: 1280x720px (16:9)");
        formatos.setForeground(Colores.MORADO);
        formatos.setFont(Fuentes.regular(12f));
        add(btnSeleccionar, "center,w 190!,h 40!, wrap");
        add(formatos, "center,wrap");
    }

    public File getArchivoSeleccionado() {
        return dropZone.getImagenSeleccionada();
    }
}
