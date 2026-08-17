/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author berth
 */
public class PanelSubirNuevoContenido extends JPanel {

    //Layout principal
    private CardLayout cardLayout;
    private JPanel panelContenido;
    private PanelCursoGrabado panelCursoGrabado;
    private PanelTransmision panelTransmision;
    //Paneles laterales
    private PanelVisibilidad panelVisibilidad;
    private PanelMiniatura panelMiniatura;
    private PanelPublicar panelPublicar;
    //Selector
    private JRadioButton rbCursoGrabado;
    private JRadioButton rbTransmision;
    private ButtonGroup grupo;

    //Constructor
    public PanelSubirNuevoContenido() {
        //JLayeredPane layeredPane = new JLayeredPane();
        //layeredPane.setOpaque(false);
        //construir();
        //Configuración del panel base con BorderLayout para expandir el fondo
        setLayout(new BorderLayout());
        setOpaque(false);

        //JLayeredPane encargado de las profundidades visuales
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setOpaque(false);

        //SVG de fondo
        JLabel right = new JLabel(new FlatSVGIcon("imagenes/imgRight.svg", 135, 135));
        JLabel top = new JLabel(new FlatSVGIcon("imagenes/imgTop.svg", 110, 110));
        JLabel left = new JLabel(new FlatSVGIcon("imagenes/imgLeft.svg", 115, 115));
        JLabel bottom = new JLabel(new FlatSVGIcon("imagenes/imgBottom.svg", 160, 100));

        layeredPane.add(right, Integer.valueOf(0));
        layeredPane.add(top, Integer.valueOf(1));
        layeredPane.add(left, Integer.valueOf(2));
        layeredPane.add(bottom, Integer.valueOf(3));

        JPanel panelFormularios = new JPanel();
        panelFormularios.setOpaque(false);
        panelFormularios.setLayout(new MigLayout(
                "fill,insets 20",
                "[grow 75, fill][grow 25, fill]",
                "[][grow]"
        ));

        construir(panelFormularios);

        layeredPane.add(panelFormularios, Integer.valueOf(4));

        // 8. Listener para ajustar tanto el tamaño de la cuadrícula como el de las marcas de agua
        layeredPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int w = layeredPane.getWidth();
                int h = layeredPane.getHeight();
                Dimension dimensionFormularios = panelFormularios.getPreferredSize();
                int altoFinal = Math.max(h, dimensionFormularios.height);

                // El panel de formularios siempre llena la pantalla
                panelFormularios.setBounds(0, 0, w, altoFinal);
                setPreferredSize(new Dimension(w, altoFinal));
                revalidate();

                right.setBounds(w - 79, h - 90, 90, 90);
                top.setBounds(w - 117, h - 230, 180, 180);
                left.setBounds(w - 240, h - 235, 270, 270);
                bottom.setBounds(w - 300, h - 185, 360, 360);
            }
        });
        add(layeredPane, BorderLayout.CENTER);
    }

    //Construcción general
    private void construir(JPanel contenedor) {
        contenedor.add(crearSelector(), "span 2,growx,wrap");

        // Columna izquierda
        cardLayout = new CardLayout();

        panelContenido = new JPanel(cardLayout);
        panelContenido.setOpaque(false);

        panelCursoGrabado = new PanelCursoGrabado();
        panelTransmision = new PanelTransmision();
        panelContenido.add(panelCursoGrabado, "CURSO");
        panelContenido.add(panelTransmision, "LIVE");

        // Columna derecha
        JPanel derecha = crearPanelDerecho();

        contenedor.add(panelContenido, "grow, wmin 500, wmax 600");
        contenedor.add(derecha, "growy, wmin 320, wmax 360");

        cardLayout.show(panelContenido, "CURSO");
        rbCursoGrabado.setSelected(true);
    }

    private JPanel crearSelector() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        JLabel titulo = new JLabel("Tipo de publicación");
        titulo.setFont(Fuentes.bold(20f));

        panel.add(titulo, BorderLayout.NORTH);

        JPanel botones = new JPanel(new FlowLayout(
                FlowLayout.CENTER,
                35,
                15));

        botones.setOpaque(false);

        grupo = new ButtonGroup();

        rbCursoGrabado = crearRadioButton("Curso grabado");
        rbTransmision = crearRadioButton("Transmisión en vivo");

        grupo.add(rbCursoGrabado);
        grupo.add(rbTransmision);

        botones.add(rbCursoGrabado);
        botones.add(rbTransmision);

        panel.add(botones, BorderLayout.CENTER);

        rbCursoGrabado.addActionListener(e
                -> cardLayout.show(panelContenido, "CURSO"));

        rbTransmision.addActionListener(e
                -> cardLayout.show(panelContenido, "LIVE"));

        rbCursoGrabado.setSelected(true);

        return panel;
    }

    //Botón selector
    private JRadioButton crearRadioButton(String texto) {
        JRadioButton radio = new JRadioButton(texto);
        radio.setOpaque(false);
        radio.setFont(Fuentes.medium(16f));
        radio.setForeground(Colores.GRAFITO);
        radio.setFocusPainted(false);
        radio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        radio.setIcon(new RadioIcon(false));
        radio.setSelectedIcon(new RadioIcon(true));
        return radio;
    }

    public class RadioIcon implements Icon {

        private final boolean seleccionado;
        private final int size = 18;

        public RadioIcon(boolean seleccionado) {
            this.seleccionado = seleccionado;
        }

        @Override
        public int getIconWidth() {
            return size;
        }

        @Override
        public int getIconHeight() {
            return size;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            if (seleccionado) {
                g2.setColor(Colores.TURQUESA);
                g2.setStroke(new BasicStroke(2));
                g2.drawOval(x, y, size - 1, size - 1);
                // Punto central
                g2.fillOval(
                        x + 5,
                        y + 5,
                        size - 10,
                        size - 10);
            } else {
                g2.setColor(new Color(170, 170, 170));
                g2.setStroke(new BasicStroke(2));
                g2.drawOval(x, y, size - 1, size - 1);
            }
            g2.dispose();
        }
    }

    //Panel derecho
    private JPanel crearPanelDerecho() {
        JPanel panel = new JPanel(
                new MigLayout(
                        "fillx,insets 0",
                        "[grow,fill]",
                        "[]20[]20[]push"));
        panel.setOpaque(false);

        panelVisibilidad = new PanelVisibilidad();
        panelMiniatura = new PanelMiniatura();
        panelPublicar = new PanelPublicar();
        panel.add(panelVisibilidad, "growx,wrap");
        panel.add(panelMiniatura, "growx,wrap");
        panel.add(panelPublicar, "grow,pushy");
        //Ancho fijo al panel derecho
        panel.setPreferredSize(new Dimension(340, 0));
        panel.setMinimumSize(new Dimension(320, 0));
        panel.setMaximumSize(new Dimension(360, Integer.MAX_VALUE));
        return panel;
    }

    //Getters
    public PanelCursoGrabado getPanelCursoGrabado() {
        return panelCursoGrabado;
    }

    public PanelTransmision getPanelTransmision() {
        return panelTransmision;
    }

    public PanelVisibilidad getPanelVisibilidad() {
        return panelVisibilidad;
    }

    public PanelMiniatura getPanelMiniatura() {
        return panelMiniatura;
    }

    public PanelPublicar getPanelPublicar() {
        return panelPublicar;
    }
}
