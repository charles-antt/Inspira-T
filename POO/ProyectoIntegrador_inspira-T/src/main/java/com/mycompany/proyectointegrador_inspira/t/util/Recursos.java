/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.util;

import java.net.URL;

/**
 *
 * @author berth
 */
public final class Recursos {

    private Recursos() {
    }

    public static URL obtener(String ruta) {
        return Recursos.class.getResource(ruta);
    }
}
