/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author berth
 */
public class LblSubtitulo extends JLabel {

    //Tamaño por defecto
    public static final float DEFAULT_SIZE = 18f;

    //Constructores
    public LblSubtitulo() {
        this("");
    }

    public LblSubtitulo(String texto) {
        this(texto, DEFAULT_SIZE);
    }

    public LblSubtitulo(String texto, float size) {
        super(texto);
        configurar(size);
    }

    private void configurar(float size) {
        setFont(Fuentes.medium(size));
        setForeground(Colores.GRAFITO);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);
        setOpaque(false);
    }

    public void setSubtitleSize(float size) {
        setFont(Fuentes.medium(size));
    }

    public void setSubtitleColor(Color color) {
        setForeground(color);
    }

    public void setSubtitleStyle(int style) {
        setFont(getFont().deriveFont(style));
    }

    public void left() {
        setHorizontalAlignment(LEFT);
    }

    public void center() {
        setHorizontalAlignment(CENTER);
    }

    public void right() {
        setHorizontalAlignment(RIGHT);
    }
}
