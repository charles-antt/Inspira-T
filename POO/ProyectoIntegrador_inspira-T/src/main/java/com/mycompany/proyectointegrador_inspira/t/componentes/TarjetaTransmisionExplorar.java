/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author berth
 */
public class TarjetaTransmisionExplorar extends JPanel {

    private static final double PROPORCION = 170.0 / 300.0;
    private static final int PADDING_LATERAL = 5;
    private static final int ALTO_MINIMO_IMAGEN = 120;

    private final BufferedImage imagenOriginal;
    private final JLabel imagen = new JLabel();
    private final JLabel lblTitulo;
    private final JLabel lblPresentador;

    private final String titulo;
    private final String presentador;

    private int anchoActual = -1;

    public TarjetaTransmisionExplorar(String titulo, String presentador, String hora, String rutaImagen) {
        this.titulo = titulo;
        this.presentador = presentador;

        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(0, PADDING_LATERAL, 0, PADDING_LATERAL));

        imagen.setAlignmentX(Component.LEFT_ALIGNMENT);

        BufferedImage cargada = null;
        try {
            cargada = ImageIO.read(getClass().getResource(rutaImagen));
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("No se pudo cargar la imagen: " + rutaImagen);
            e.printStackTrace();
        }
        imagenOriginal = cargada;

        // TÍTULO 
        lblTitulo = new JLabel();
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblPresentador = new JLabel();
        lblPresentador.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblPresentador.setForeground(Color.DARK_GRAY);
        lblPresentador.setAlignmentX(Component.LEFT_ALIGNMENT);

        // HORA     
        JLabel lblHora = new JLabel(hora);
        lblHora.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblHora.setForeground(Color.GRAY);
        lblHora.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(imagen);
        add(Box.createVerticalStrut(12));
        add(lblTitulo);
        add(Box.createVerticalStrut(6));
        add(lblPresentador);
        add(Box.createVerticalStrut(2));
        add(lblHora);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                actualizarContenido();
            }
        });
    }

    private void actualizarContenido() {
        int ancho = getWidth() - (PADDING_LATERAL * 2);
        if (ancho <= 0 || ancho == anchoActual) {
            return;
        }
        anchoActual = ancho;

        int alto = Math.max(ALTO_MINIMO_IMAGEN, (int) (ancho * PROPORCION));

        imagen.setPreferredSize(new Dimension(ancho, alto));
        imagen.setMaximumSize(new Dimension(ancho, alto));

        if (imagenOriginal != null) {
            BufferedImage conEtiqueta = crearImagenConEtiqueta(imagenOriginal, ancho, alto, "En vivo");
            imagen.setIcon(new ImageIcon(conEtiqueta));
        }

        lblTitulo.setText(
                "<html><body style='width:" + ancho + "px; text-align:left'>" + titulo + "</body></html>"
        );
        lblPresentador.setText(
                "<html><body style='width:" + ancho + "px; text-align:left'>con " + presentador + "</body></html>"
        );

        revalidate();
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {

        Dimension pref = super.getPreferredSize();
        if (pref.width <= 0) {
            pref.width = 250;
        }
        return pref;
    }

    private BufferedImage crearImagenConEtiqueta(BufferedImage original, int ancho, int alto, String texto) {
        double escalaOriginal = (double) original.getWidth() / original.getHeight();
        double escalaDestino = (double) ancho / alto;

        int cropAncho = original.getWidth();
        int cropAlto = original.getHeight();
        int cropX = 0;
        int cropY = 0;

        if (escalaOriginal > escalaDestino) {
            cropAncho = (int) (original.getHeight() * escalaDestino);
            cropX = (original.getWidth() - cropAncho) / 2;
        } else {
            cropAlto = (int) (original.getWidth() / escalaDestino);
            cropY = (original.getHeight() - cropAlto) / 2;
        }

        BufferedImage recortada = original.getSubimage(cropX, cropY, cropAncho, cropAlto);

        BufferedImage resultado = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resultado.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setClip(new RoundRectangle2D.Float(0, 0, ancho, alto, 14, 14));
        g2.drawImage(recortada, 0, 0, ancho, alto, null);

        g2.setClip(null);
        Font fontEtiqueta = new Font("SansSerif", Font.BOLD, 12);
        g2.setFont(fontEtiqueta);
        int textoAncho = g2.getFontMetrics().stringWidth(texto);

        int margen = 10;
        int paddingH = 10;
        int paddingV = 6;
        int etiquetaAncho = textoAncho + paddingH * 2;
        int etiquetaAlto = g2.getFontMetrics().getHeight() - 2;

        g2.setColor(new Color(210, 45, 45));
        g2.fill(new RoundRectangle2D.Float(margen, margen, etiquetaAncho, etiquetaAlto, 6, 6));

        g2.setColor(Color.WHITE);
        g2.drawString(texto, margen + paddingH, margen + etiquetaAlto - paddingV + 2);

        g2.dispose();
        return resultado;
    }
}
