/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.imagen;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.net.URL;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author berth
 */
public class ImagenEscalable extends JComponent {

    public enum ModoEscalado {
        CONTAIN,
        COVER
    }

    private BufferedImage imagen;
    private FlatSVGIcon iconoSVG;
    private ModoEscalado modo = ModoEscalado.CONTAIN;

    public ImagenEscalable() {
        setOpaque(false);
    }

    public ImagenEscalable(String ruta) {
        this();
        cargarImagen(ruta);
    }

    public final void cargarImagen(String ruta) {
        try {
            if (ruta.toLowerCase().endsWith(".svg")) {
                imagen = null;
                // Cargamos el SVG usando el ClassLoader
                URL url = getClass().getResource(ruta);
                if (url != null) {
                    iconoSVG = new FlatSVGIcon(url);
                } else {
                    System.err.println("No se encontró el SVG: " + ruta);
                }
            } else {
                iconoSVG = null;
                URL url = getClass().getResource(ruta);
                if (url != null) {
                    imagen = ImageIO.read(url);
                } else {
                    System.err.println("No se encontró la imagen: " + ruta);
                }
            }
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
        this.iconoSVG = null;
        repaint();
    }

    public void setModo(ModoEscalado modo) {
        this.modo = modo;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Si no hay ninguna imagen cargada, salimos
        if (imagen == null && iconoSVG == null) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int panelW = getWidth();
        int panelH = getHeight();

        // Obtener dimensiones originales según el tipo de archivo
        int imgW = (iconoSVG != null) ? iconoSVG.getIconWidth() : imagen.getWidth();
        int imgH = (iconoSVG != null) ? iconoSVG.getIconHeight() : imagen.getHeight();

        // Evitar divisiones por cero si el componente no se ha renderizado o el SVG está vacío
        if (imgW <= 0 || imgH <= 0 || panelW <= 0 || panelH <= 0) {
            g2.dispose();
            return;
        }

        double escala = (modo == ModoEscalado.CONTAIN)
                ? Math.min((double) panelW / imgW, (double) panelH / imgH)
                : Math.max((double) panelW / imgW, (double) panelH / imgH);

        int nuevoAncho = (int) (imgW * escala);
        int nuevoAlto = (int) (imgH * escala);
        int x = (panelW - nuevoAncho) / 2;
        int y = (panelH - nuevoAlto) / 2;

        if (iconoSVG != null) {
            // Derivamos el icono SVG al nuevo tamaño escalado para que FlatLaf lo rasterice vectorialmente
            FlatSVGIcon iconoEscalado = iconoSVG.derive(nuevoAncho, nuevoAlto);
            iconoEscalado.paintIcon(this, g2, x, y);
        } else {
            g2.drawImage(imagen, x, y, nuevoAncho, nuevoAlto, null);
        }

        g2.dispose();
    }
}
