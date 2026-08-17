/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.util;

import com.formdev.flatlaf.extras.FlatSVGIcon;
//import javax.swing.*;
//import java.awt.*;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author berth
 */
public final class Iconos {

    private Iconos() {
    }

    // Menú
    public static final String HOME = "/imagenes/home.svg";
    public static final String EXPLORAR = "/imagenes/explorar.svg";
    public static final String APRENDIZAJE = "/imagenes/aprendizaje.svg";
    public static final String CURSOS = "/imagenes/book.svg";

    // Barra superior
    public static final String PERFIL = "/imagenes/user.svg";
    public static final String NOTIFICACION = "/imagenes/bell.svg";
    public static final String EDIT = "/imagenes/edit.svg";
    public static final String LIKE = "/imagenes/like.svg";
    public static final String DISLIKE = "/imagenes/dislike.svg";
    public static final String ARROW_DOWN = "/imagenes/arrowDown.svg";
    public static final String UP = "/imagenes/up.svg";

    //Iconos de vídeo
    public static final String PLAY = "/imagenes/play.svg";
    public static final String VOLUME = "/imagenes/volume.svg";
    public static final String SKIP_NEXT = "/imagenes/skipNext.svg";
    public static final String FULLSCREEN = "/imagenes/fullscreen.svg";
    public static final String MORE = "/imagenes/more.svg";
    public static final String USER = "/imagenes/user.svg";

    //Principal
    public static final String PRESERVAR = "/imagenes/preservar.svg";
    public static final String APRENDE = "/imagenes/aprende.svg";
    public static final String COMPARTE = "/imagenes/comparte.svg";
    public static final String PRESERVA = "/imagenes/preserva.svg";
    public static final String GUARDIANES = "/imagenes/guardianes.svg";

    /**
     * public static ImageIcon cargar(String ruta, int size, Color color){
     * FlatSVGIcon icon = new FlatSVGIcon(ruta, size, size);
     *
     * icon.setColorFilter(new FlatSVGIcon.ColorFilter(c -> color)); return
     * icon; }*
     */

    public static ImageIcon cargar(String ruta, int size, Color color) {
        // 1. Buscamos el recurso de manera segura usando el Classloader de la clase 'Iconos'
        java.net.URL urlRecurso = Iconos.class.getResource(ruta);

        // 2. Si no se encuentra, imprimimos un mensaje para saber en qué falló exactamente la ruta
        if (urlRecurso == null) {
            System.err.println("¡ERROR CRÍTICO!: No se encontró el archivo SVG en la ruta: " + ruta);
            return null;
        }

        // 3. Le pasamos la URL segura de Java a FlatSVGIcon en vez del String de texto directo
        FlatSVGIcon icon = new FlatSVGIcon(urlRecurso);

        // 4. Redimensionamos el icono al tamaño deseado de forma explícita antes de retornar
        icon = icon.derive(size, size);

        // 5. Aplicamos el filtro de color dinámico
        icon.setColorFilter(new FlatSVGIcon.ColorFilter(c -> color));

        return icon;
    }
}
