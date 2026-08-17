/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author berth
 */
public final class Fuentes {

    // Constructor privado
    private Fuentes() {
    }

    // Fuentes cargadas
    private static Font regular;
    private static Font medium;
    private static Font bold;
    private static Font italic;
    private static Font extraBoldItalic;
    private static Font boldItalic;
    private static boolean cargadas = false;

    // Inicialización
    public static void cargar() {
        if (cargadas) {
            return;
        }
        regular = cargarFuente("/fuentes/Nunito/Nunito-Regular.ttf", Font.PLAIN);
        medium = cargarFuente("/fuentes/Nunito/Nunito-Medium.ttf", Font.PLAIN);
        bold = cargarFuente("/fuentes/Nunito/Nunito-Bold.ttf", Font.BOLD);
        italic = cargarFuente("/fuentes/Nunito/Nunito-Italic.ttf", Font.ITALIC);
        extraBoldItalic = cargarFuente("/fuentes/Nunito/Nunito-ExtraBoldItalic.ttf", Font.ITALIC);
        boldItalic = cargarFuente("/fuentes/Nunito/Nunito-BoldItalic.ttf", Font.BOLD);
        cargadas = true;
    }

    // Cargar una fuente
    private static Font cargarFuente(String ruta, int estilo) {
        try {
            InputStream is = Fuentes.class.getResourceAsStream(ruta);
            if (is == null) {
                System.out.println("No se encontró: " + ruta);
                return new Font(
                        "Arial",
                        estilo,
                        14);
            }
            Font fuente = Font.createFont(Font.TRUETYPE_FONT, is);
            Font fuenteBase = fuente.deriveFont(estilo, 12f);
            GraphicsEnvironment
                    .getLocalGraphicsEnvironment()
                    .registerFont(fuenteBase);
            return fuenteBase;
        } catch (IOException | FontFormatException ex) {
            ex.printStackTrace();
            return new Font("Arial", estilo, 14);
        }
    }

    // Métodos públicos
    public static Font regular(float size) {
        return regular.deriveFont(size);
    }

    public static Font medium(float size) {
        return medium.deriveFont(size);
    }

    public static Font bold(float size) {
        return bold.deriveFont(size);
    }

    public static Font italic(float size) {
        return italic.deriveFont(size);
    }

    public static Font extraBoldItalic(float size) {
        return extraBoldItalic.deriveFont(size);
    }

    public static Font boldItalic(float size) {
        return boldItalic.deriveFont(size);
    }
}
