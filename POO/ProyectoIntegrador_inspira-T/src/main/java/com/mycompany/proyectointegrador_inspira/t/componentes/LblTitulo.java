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
public class LblTitulo extends JLabel {

    //Tamaño por defecto
    public static final float DEFAULT_SIZE = 28f;

    //Constructores
    public LblTitulo() {
        this("");
    }

    public LblTitulo(String texto) {
        this(texto, DEFAULT_SIZE);
    }

    public LblTitulo(String texto, float size) {
        super(texto);
        configurar(size);
    }

    private void configurar(float size) {
        setFont(Fuentes.bold(size));
        setForeground(Colores.GRAFITO);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);
        setOpaque(false);
    }

    public void setTitleSize(float size) {
        setFont(Fuentes.bold(size));
    }

    public void setTitleColor(Color color) {
        setForeground(color);
    }

    public void setTitleStyle(int style) {
        setFont(getFont().deriveFont(style));
    }

    public void center() {
        setHorizontalAlignment(CENTER);
    }

    public void left() {
        setHorizontalAlignment(LEFT);
    }

    public void right() {
        setHorizontalAlignment(RIGHT);
    }
}
