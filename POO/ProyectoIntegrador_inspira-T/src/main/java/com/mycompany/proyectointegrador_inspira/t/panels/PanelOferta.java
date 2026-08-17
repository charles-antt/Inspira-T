/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
import com.mycompany.proyectointegrador_inspira.t.componentes.TarjetaOferta;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.extras.FlatSVGIcon.ColorFilter;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author berth
 */
public class PanelOferta extends JPanel {

    public PanelOferta() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(30, 40, 30, 40));

        // PANEL PRINCIPAL
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);

        JPanel filaTitulo = new JPanel();
        filaTitulo.setLayout(new BoxLayout(filaTitulo, BoxLayout.X_AXIS));
        filaTitulo.setBackground(Color.WHITE);
        filaTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JSeparator lineaIzquierda = new JSeparator(JSeparator.HORIZONTAL);
        lineaIzquierda.setForeground(Colores.MORADO); // Color de la línea
        lineaIzquierda.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2)); // Altura de la línea

        // Título Principal
        JLabel titulo = new JLabel("Oferta Educativa");
        titulo.setFont(Fuentes.bold(32f));
        titulo.setForeground(Colores.GRAFITO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JSeparator lineaDerecha = new JSeparator(JSeparator.HORIZONTAL);
        lineaDerecha.setForeground(Colores.MORADO);
        lineaDerecha.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));

        filaTitulo.add(Box.createHorizontalStrut(5));
        filaTitulo.add(lineaIzquierda);
        filaTitulo.add(titulo);
        filaTitulo.add(lineaDerecha);
        filaTitulo.add(Box.createHorizontalStrut(5));

        panel.add(filaTitulo);
        //panel.add(Box.createVerticalStrut(25));

        // TARJETAS DE OFERTA
        JPanel tarjetas = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        tarjetas.setBackground(Color.WHITE);

        tarjetas.add(new TarjetaOferta("<html><center><p style='margin-bottom: 20px;'>Agricultura</p></center></html>", "agricultura.svg"));
        tarjetas.add(new TarjetaOferta("<html><center>Artesanías y técnicas<br>ancestrales</center></html>", "artesanias.svg"));
        tarjetas.add(new TarjetaOferta("<html><center>Medicina tradicional<br>y herbolaria</center></html>", "medicina.svg"));
        tarjetas.add(new TarjetaOferta("<html><center>Lenguas y<br>tradición oral</center></html>", "lenguas.svg"));
        tarjetas.add(new TarjetaOferta("<html><center>Deportes y juegos<br>tradicionales</center></html>", "deportes.svg"));

        panel.add(tarjetas);
        panel.add(Box.createVerticalStrut(30));

        // PANEL DE INFORMACIÓN
        Color fondoAzulClaro = new Color(47, 128, 237, 10);
        //Color bordeAzul = new Color(0, 10, 15, 10);
        Color bordeAzul = new Color(215, 210, 238);

        JPanel informacion = new JPanel(new GridLayout(1, 4, 0, 0)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();

                //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_GRAPHICS);
                g2.setColor(getBackground());
                g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);

                g2.setColor(bordeAzul);
                g2.setStroke(new BasicStroke(1));
                g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);

                g2.dispose();
            }
        };
        informacion.setBackground(fondoAzulClaro);
        informacion.setOpaque(false);
        informacion.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        //BLOQUES CON SUS RESPECTIVAS IMÁGENES ASIGNADAS
        informacion.add(crearBloqueConIcono("Aprende", "Accede a clases y videos<br>desde cualquier lugar.", new Color(47, 128, 237), "aprende.svg", true));
        informacion.add(crearBloqueConIcono("Comparte", "Sé parte de una comunidad<br>que valora nuestras raíces.", new Color(123, 97, 255), "comparte.svg", true));
        informacion.add(crearBloqueConIcono("Preserva", "Ayudamos a que los saberes<br>ancestrales no se pierdan.", new Color(45, 212, 191), "preserva.svg", true));
        informacion.add(crearBloqueConIcono("+2,500", "Guardianes del<br>conocimiento ya son parte.", new Color(31, 60, 136), "guardianes.svg", false));
        //informacion.setForeground(Colores.AZUL_CONFIANZA);
        panel.add(informacion);
        add(panel, BorderLayout.CENTER);
    }

    private JPanel crearBloqueConIcono(String titulo, String texto, Color colorTitulo, String nombreImagenSvg, boolean conLineaDivisoria) {
        JPanel bloque = new JPanel(new BorderLayout(12, 0));
        bloque.setOpaque(false);
        if (conLineaDivisoria) {
            bloque.setBorder(new CompoundBorder(
                    new MatteBorder(0, 0, 0, 1, new Color(215, 210, 238)),
                    new EmptyBorder(10, 15, 10, 15)
            ));
        } else {
            bloque.setBorder(new EmptyBorder(10, 15, 10, 15));
        }

        //ICONO SVG (IZQUIERDA)
        JLabel lblIcono = new JLabel();
        lblIcono.setHorizontalAlignment(SwingConstants.CENTER);

        try {
            FlatSVGIcon iconoSvg = new FlatSVGIcon("imagenes/" + nombreImagenSvg, 45, 45);
            ColorFilter filtro = new ColorFilter();
            filtro.add(Color.BLACK, colorTitulo);
            iconoSvg.setColorFilter(filtro);

            if (iconoSvg.getIconWidth() > 0) {
                lblIcono.setIcon(iconoSvg);
            } else {
                throw new Exception("No se pudo cargar el recurso SVG");
            }
        } catch (Exception e) {
            System.err.println("Error al cargar icono SVG: imagenes/" + nombreImagenSvg);
            lblIcono.setText("★");
            lblIcono.setForeground(Colores.GRAFITO);
        }

        lblIcono.setPreferredSize(new Dimension(45, 45));
        bloque.add(lblIcono, BorderLayout.WEST);

        //PANEL DE TEXTO (DERECHA)
        JPanel panelTexto = new JPanel();
        panelTexto.setOpaque(false);
        panelTexto.setLayout(new BoxLayout(panelTexto, BoxLayout.Y_AXIS));

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(Fuentes.bold(18f));
        lblTitulo.setForeground(colorTitulo);
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblTexto = new JLabel("<html>" + texto + "</html>");
        lblTexto.setFont(Fuentes.medium(14f));
        lblTexto.setForeground(Colores.GRAFITO);
        lblTexto.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelTexto.add(lblTitulo);
        panelTexto.add(Box.createVerticalStrut(3));
        panelTexto.add(lblTexto);
        bloque.add(panelTexto, BorderLayout.CENTER);
        return bloque;
    }
}
