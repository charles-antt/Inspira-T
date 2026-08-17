/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.imagen;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author berth
 */
public class Avatar extends JComponent {

    private BufferedImage imagen;
    private int borderWidth = 3;
    private Color borderColor = Colores.AZUL_TECNOLOGICO;
    private boolean mostrarBorde = true;
    private boolean mostrarSombra = true;
    private Color shadowColor = new Color(0, 0, 0, 45);
    private int shadowSize = 6;

    public Avatar() {
        setOpaque(false);
        setPreferredSize(new Dimension(120, 120));
    }

    public Avatar(String ruta) {
        this();
        cargarImagen(ruta);
    }

    // Cargar imagen
    public final void cargarImagen(String ruta) {
        try {
            URL url = getClass().getResource(ruta);
            if (url != null) {
                imagen = ImageIO.read(url);
                repaint();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
        repaint();
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        int size = Math.min(getWidth(), getHeight());

        int x = (getWidth() - size) / 2;

        int y = (getHeight() - size) / 2;

        // Sombra
        if (mostrarSombra) {
            g2.setColor(shadowColor);
            g2.fillOval(
                    x + shadowSize,
                    y + shadowSize,
                    size - shadowSize,
                    size - shadowSize);
        }

        // Clip circular
        Shape clip = new Ellipse2D.Double(
                x,
                y,
                size - borderWidth,
                size - borderWidth);
        g2.setClip(clip);

        // Imagen
        if (imagen != null) {
            double escala = Math.max(
                    (double) size / imagen.getWidth(),
                    (double) size / imagen.getHeight()
            );
            int nuevoAncho = (int) (imagen.getWidth() * escala);
            int nuevoAlto = (int) (imagen.getHeight() * escala);
            int imgX = x + (size - nuevoAncho) / 2;
            int imgY = y + (size - nuevoAlto) / 2;

            g2.drawImage(
                    imagen,
                    imgX,
                    imgY,
                    nuevoAncho,
                    nuevoAlto,
                    null
            );

        } else {

            g2.setColor(new Color(230, 230, 230));

            g2.fillOval(x, y, size, size);

        }

        g2.setClip(null);

        // Borde
        if (mostrarBorde) {
            g2.setStroke(new BasicStroke(borderWidth));
            g2.setColor(borderColor);
            g2.drawOval(
                    x,
                    y,
                    size - borderWidth,
                    size - borderWidth
            );
        }
        g2.dispose();
    }

    // Getters y Setters
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        repaint();
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setMostrarBorde(boolean mostrarBorde) {
        this.mostrarBorde = mostrarBorde;
        repaint();
    }

    public boolean isMostrarBorde() {
        return mostrarBorde;
    }

    public void setMostrarSombra(boolean mostrarSombra) {
        this.mostrarSombra = mostrarSombra;
        repaint();
    }

    public boolean isMostrarSombra() {
        return mostrarSombra;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        repaint();
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
        repaint();
    }

    public int getShadowSize() {
        return shadowSize;
    }
}
