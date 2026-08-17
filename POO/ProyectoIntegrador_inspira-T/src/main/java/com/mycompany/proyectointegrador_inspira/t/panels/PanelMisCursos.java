/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Iconos;
import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
import com.mycompany.proyectointegrador_inspira.t.componentes.BotonRedondeado;
import com.mycompany.proyectointegrador_inspira.t.imagen.ImagenEscalable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.net.URL;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author berth
 */
public class PanelMisCursos extends JPanel {

    private enum EstadoLeccion {
        COMPLETADO, EN_PROGRESO, PENDIENTE
    }

    private static final Color FONDO = new Color(0xFCFBFA);
    private static final Color TEAL = new Color(0x2DD4BF);
    private static final Color GRIS_BORDE = new Color(0xE5E7EB);
    private static final Color AZUL_BARRA = new Color(0x4F67A4);
    private static final Color AZUL_ICONO = new Color(0x164B9B);
    private static final Color NARANJA_TEXTO = new Color(0xE89B27);
    private static final Color TEXTO = new Color(0x202020);
    private static final Color TEXTO_SECUNDARIO = new Color(0x626262);

    public PanelMisCursos() {
        setBackground(Colores.BLANCO);
        setLayout(new BorderLayout());

        JPanel contenido = new PanelScrolleable();
        contenido.setOpaque(false);
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
        contenido.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));

        JPanel filtros = construirFiltros();
        JPanel carrusel = construirCarrusel();
        JPanel detalle = construirDetalleCurso();

        filtros.setAlignmentX(Component.LEFT_ALIGNMENT);
        carrusel.setAlignmentX(Component.LEFT_ALIGNMENT);
        detalle.setAlignmentX(Component.LEFT_ALIGNMENT);

        filtros.setMaximumSize(new Dimension(Integer.MAX_VALUE, filtros.getPreferredSize().height));
        carrusel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 380));
        detalle.setMaximumSize(new Dimension(Integer.MAX_VALUE, detalle.getPreferredSize().height));

        contenido.add(Box.createVerticalStrut(10));
        contenido.add(filtros);
        contenido.add(Box.createVerticalStrut(10));
        contenido.add(carrusel);
        contenido.add(Box.createVerticalStrut(10));
        contenido.add(detalle);

        JScrollPane scroll = new JScrollPane(contenido);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(15);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);

        add(scroll, BorderLayout.CENTER);
    }

    private JPanel construirFiltros() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panel.setOpaque(false);

        String[] categorias = {
            "Todos",
            "Agricultura",
            "Medicina",
            "Artesanías",
            "Lenguas",
            "Gastronomía",
            "Deportes y juegos"
        };

        for (String cat : categorias) {
            panel.add(crearPastilla(cat, cat.equals("Todos")));
        }

        return panel;
    }

    private JButton crearPastilla(String texto, boolean activa) {
        JButton btn = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (activa) {
                    g2.setColor(Colores.TURQUESA);
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
                } else {
                    g2.setColor(Colores.BLANCO);
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
                    g2.setColor(GRIS_BORDE);
                    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 40, 40);
                }

                g2.dispose();
                super.paintComponent(g);
            }
        };

        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(9, 22, 9, 22));
        btn.setForeground(activa ? Colores.BLANCO : Colores.GRAFITO);
        btn.setFont(Fuentes.bold(14f));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return btn;
    }

    private JPanel construirCarrusel() {
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        wrapper.setOpaque(false);
        wrapper.setAlignmentX(Component.LEFT_ALIGNMENT);
        wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, 340));

        JPanel encabezadoCarrusel = new JPanel(new BorderLayout());
        encabezadoCarrusel.setBorder(
                BorderFactory.createEmptyBorder(10, 0, 10, 0)
        );
        encabezadoCarrusel.setOpaque(false);
        encabezadoCarrusel.setAlignmentX(Component.LEFT_ALIGNMENT);
        encabezadoCarrusel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 55)
        );
        JLabel lblLecciones = new JLabel("Lecciones");
        lblLecciones.setFont(Fuentes.bold(26f));
        lblLecciones.setForeground(Colores.GRAFITO);

        JLabel verTodos = new JLabel("Ver todos");
        verTodos.setFont(Fuentes.bold(14f));
        verTodos.setForeground(Colores.GRAFITO);
        verTodos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        encabezadoCarrusel.add(lblLecciones, BorderLayout.WEST);
        encabezadoCarrusel.add(verTodos, BorderLayout.EAST);
        //encabezadoCarrusel.setMaximumSize(new Dimension(Integer.MAX_VALUE, encabezadoCarrusel.getPreferredSize().height));

        JPanel fila = new FilaTarjetas();
        fila.setOpaque(false);
        fila.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        fila.setAlignmentX(Component.LEFT_ALIGNMENT);

        fila.add(crearTarjetaCurso(
                "GASTRONOMÍA",
                "Mole tradicional de mi comunidad",
                "Juana Pérez",
                "9:42",
                "5.4k vistas",
                "hace 1 día",
                true,
                new String[]{"/imagenes/moleMC.svg"}
        ));

        fila.add(crearTarjetaCurso(
                "TRADICIONES",
                "Rituales de agradecimiento a la tierra",
                "Consejo de Ancianos",
                "14:18",
                "9.8k vistas",
                "hace 3 días",
                false,
                new String[]{"/imagenes/ritualMC.svg"}
        ));

        fila.add(crearTarjetaCurso(
                "ARTESANÍAS",
                "Alfarería tradicional desde el origen",
                "Francisco Díaz",
                "9:42",
                "4.3k vistas",
                "hace 4 días",
                false,
                new String[]{"/imagenes/alfaMC.svg"}
        ));

        fila.add(crearTarjetaCurso(
                "ARTESANÍAS",
                "Cestería con palma paso a paso",
                "Rosa Martínez",
                "9:42",
                "3.2k vistas",
                "hace 5 días",
                false,
                new String[]{"/imagenes/tejidoMC.svg"}
        ));

        fila.add(crearTarjetaCurso(
                "DEPORTES Y JUEGOS",
                "Juego de pelota prehispánico",
                "Carlos Xolotl",
                "9:42",
                "6.7k vistas",
                "hace 1 semana",
                false,
                new String[]{"/imagenes/juegoMC.svg"}
        ));

        fila.add(crearTarjetaCurso(
                "AGRICULTURA",
                "Cultivo del maíz tradicional",
                "María López",
                "9:42",
                "7.1k vistas",
                "hace 1 semana",
                false,
                new String[]{"/imagenes/cosechaMC.svg"}
        ));

        JScrollPane scrollFila = new JScrollPane(fila);

        scrollFila.setBorder(null);
        scrollFila.setOpaque(false);
        scrollFila.getViewport().setOpaque(false);

        scrollFila.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_NEVER
        );

        scrollFila.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );

        scrollFila.getHorizontalScrollBar().setUnitIncrement(16);

        scrollFila.setAlignmentX(Component.LEFT_ALIGNMENT);
        scrollFila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 320));

        //fila.setAlignmentX(Component.LEFT_ALIGNMENT);
        wrapper.add(encabezadoCarrusel);
        wrapper.add(scrollFila);

        return wrapper;
    }

    class FilaTarjetas extends JPanel {

        /**
         * FilaTarjetas() { super(new GridLayout(1, 6, 14, 0)); }*
         */
        public FilaTarjetas() {

            setLayout(
                    new BoxLayout(
                            this,
                            BoxLayout.X_AXIS
                    )
            );

            setOpaque(false);
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension d = super.getPreferredSize();
            return new Dimension(d.width, 250);
        }
    }

    private JPanel crearTarjetaCurso(String categoria, String titulo, String instructor,
            String duracion, String vistas, String tiempo, boolean seleccionada, String[] rutasImagen) {

        JPanel tarjeta = new JPanel(new BorderLayout());
        tarjeta.setPreferredSize(new Dimension(160, 250));
        tarjeta.setMinimumSize(new Dimension(160, 250));
        tarjeta.setMaximumSize(new Dimension(160, 250));
        tarjeta.setBackground(Colores.BLANCO);

        tarjeta.setBorder(BorderFactory.createLineBorder(
                seleccionada ? TEAL : Colores.BLANCO,
                seleccionada ? 3 : 1,
                true
        ));

        JLayeredPane imagen = new JLayeredPane();
        imagen.setPreferredSize(new Dimension(160, 130));
        imagen.setMinimumSize(new Dimension(160, 130));
        imagen.setMaximumSize(new Dimension(160, 130));
        ImagenEscalable imagenCurso = crearImagenEscalable(rutasImagen);
        imagen.add(imagenCurso, JLayeredPane.DEFAULT_LAYER);

        JLabel duracionLbl = new JLabel(duracion, SwingConstants.CENTER);
        duracionLbl.setForeground(Colores.BLANCO);
        duracionLbl.setOpaque(true);
        duracionLbl.setBackground(new Color(0, 0, 0, 150));
        duracionLbl.setFont(Fuentes.bold(12f));
        imagen.add(duracionLbl, JLayeredPane.PALETTE_LAYER);

        int anchoEtiqueta = 37;
        int altoEtiqueta = 20;

        imagen.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int w = imagen.getWidth();
                int h = imagen.getHeight();
                imagenCurso.setBounds(0, 0, w, h);
                duracionLbl.setBounds(w - anchoEtiqueta - 7, h - altoEtiqueta - 7, anchoEtiqueta, altoEtiqueta);
            }
        });

        JPanel info = new JPanel();
        info.setOpaque(false);
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));

        JLabel cat = new JLabel(categoria);
        Color colorCategoria;
        if (categoria.equals("DEPORTES Y JUEGOS")) {
            colorCategoria = Colores.TURQUESA;
        } else if (categoria.equals("ARTESANÍAS") || categoria.equals("TRADICIONES")) {
            colorCategoria = new Color(0xC06643);
        } else {
            colorCategoria = NARANJA_TEXTO;
        }
        cat.setForeground(colorCategoria);
        cat.setFont(Fuentes.bold(12f));
        cat.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea tit = new JTextArea(titulo);
        tit.setFont(Fuentes.bold(14f));
        tit.setForeground(Colores.GRAFITO);
        tit.setAlignmentX(Component.LEFT_ALIGNMENT);
        tit.setLineWrap(true);
        tit.setWrapStyleWord(true);
        tit.setEditable(false);
        tit.setFocusable(false);
        tit.setOpaque(false);
        tit.setBorder(null);
        tit.setPreferredSize(new Dimension(140, 40));
        tit.setMinimumSize(new Dimension(140, 40));
        tit.setMaximumSize(new Dimension(140, 40));

        FlatSVGIcon iconoSvg = new FlatSVGIcon("imagenes/user.svg", 16, 16);

        JLabel autor = new JLabel(instructor);
        autor.setIcon(iconoSvg);
        autor.setHorizontalTextPosition(SwingConstants.RIGHT);
        autor.setIconTextGap(4);
        autor.setFont(Fuentes.bold(12f));
        autor.setForeground(Colores.GRAFITO);
        autor.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel meta = new JLabel(vistas + "  ·  " + tiempo);
        meta.setFont(Fuentes.bold(12f));
        meta.setForeground(TEXTO_SECUNDARIO);
        meta.setAlignmentX(Component.LEFT_ALIGNMENT);

        info.add(cat);
        info.add(Box.createVerticalStrut(4));
        info.add(tit);
        info.add(Box.createVerticalStrut(4));
        info.add(autor);
        info.add(Box.createVerticalStrut(4));
        info.add(meta);

        tarjeta.add(imagen, BorderLayout.NORTH);
        tarjeta.add(info, BorderLayout.CENTER);

        return tarjeta;
    }

    private JPanel construirDetalleCurso() {
        JPanel completo = new JPanel();
        completo.setOpaque(false);
        completo.setLayout(new BoxLayout(completo, BoxLayout.Y_AXIS));

        JPanel panelSuperior = new JPanel(new BorderLayout(30, 0));

        panelSuperior.setOpaque(false);
        //panelSuperior.setBackground(Color.RED);
        panelSuperior.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelSuperior.setPreferredSize(new Dimension(960, 220));

        panelSuperior.setMaximumSize(new Dimension(Integer.MAX_VALUE, 220));
        ImagenEscalable imagenGrande = crearImagenEscalable(
                new String[]{"/imagenes/moleMC.svg"}
        );
        imagenGrande.setPreferredSize(new Dimension(260, 210));
        imagenGrande.setMinimumSize(new Dimension(260, 210));

        JPanel descripcion = new JPanel();
        descripcion.setOpaque(false);
        descripcion.setLayout(new BoxLayout(descripcion, BoxLayout.Y_AXIS));
        descripcion.setPreferredSize(new Dimension(400, 215));
        descripcion.setMinimumSize(new Dimension(300, 215));

        JLabel cat = new JLabel("GASTRONOMÍA");
        cat.setForeground(NARANJA_TEXTO);
        cat.setFont(Fuentes.bold(16f));
        cat.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel titulo = new JLabel("Mole tradicional de mi comunidad");
        titulo.setForeground(Colores.GRAFITO);
        titulo.setFont(Fuentes.bold(19f));
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel desc = new JLabel(
                "<html><body style='width:250px'>Aprende las técnicas, ingredientes y procesos "
                + "que dan vida a una de las recetas más representativas de la gastronomía "
                + "tradicional.</body></html>"
        );
        desc.setForeground(Colores.GRAFITO);
        desc.setFont(Fuentes.regular(14f));
        desc.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel progresoTxt = new JLabel("Tu progreso");
        progresoTxt.setFont(Fuentes.bold(14f));
        progresoTxt.setForeground(Colores.GRAFITO);
        progresoTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel progresoPanel = new JPanel(new BorderLayout(10, 0));
        progresoPanel.setOpaque(false);
        progresoPanel.setMaximumSize(new Dimension(430, 16));
        progresoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JProgressBar barraProgreso = crearBarraProgreso(75);
        barraProgreso.setPreferredSize(new Dimension(390, 9));

        JLabel porcentaje = new JLabel("75%");
        porcentaje.setFont(Fuentes.bold(12f));
        porcentaje.setForeground(Colores.GRAFITO);

        progresoPanel.add(barraProgreso, BorderLayout.CENTER);
        progresoPanel.add(porcentaje, BorderLayout.EAST);

        JLabel lecciones = new JLabel("8 de 12 lecciones completadas");
        lecciones.setFont(Fuentes.regular(12f));
        lecciones.setForeground(Colores.GRAFITO);
        lecciones.setAlignmentX(Component.LEFT_ALIGNMENT);

        descripcion.add(Box.createVerticalStrut(8));
        descripcion.add(cat);
        descripcion.add(Box.createVerticalStrut(8));
        descripcion.add(titulo);
        descripcion.add(Box.createVerticalStrut(8));
        descripcion.add(desc);
        descripcion.add(Box.createVerticalStrut(8));
        descripcion.add(progresoTxt);
        descripcion.add(Box.createVerticalStrut(8));
        descripcion.add(progresoPanel);
        descripcion.add(Box.createVerticalStrut(8));
        descripcion.add(lecciones);

        JPanel infoCurso = construirInfoCurso();

        panelSuperior.add(imagenGrande, BorderLayout.WEST);
        panelSuperior.add(descripcion, BorderLayout.CENTER);
        panelSuperior.add(infoCurso, BorderLayout.EAST);

        CardLayout cards = new CardLayout();
        JPanel panelContenido = new JPanel(cards);
        panelContenido.setOpaque(false);
        panelContenido.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelContenido.setMaximumSize(new Dimension(Integer.MAX_VALUE, 520));

        JPanel leccionesPanel = construirLecciones();
        JPanel unidadesPanel = construirUnidades();

        panelContenido.add(leccionesPanel, "lecciones");
        panelContenido.add(unidadesPanel, "unidades");

        JPanel pestanas = construirPestanas(cards, panelContenido);
        pestanas.setAlignmentX(Component.LEFT_ALIGNMENT);
        pestanas.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));

        cards.show(panelContenido, "lecciones");

        completo.add(panelSuperior);
        completo.add(Box.createVerticalStrut(18));
        completo.add(pestanas);
        completo.add(Box.createVerticalStrut(20));
        completo.add(panelContenido);

        return completo;
    }

    private JPanel construirPestanas(CardLayout cards, JPanel panelContenido) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 45, 0));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, GRIS_BORDE));

        JLabel lecciones = new JLabel("Lecciones");
        JLabel unidades = new JLabel("Unidades");

        lecciones.setFont(Fuentes.medium(16f));
        unidades.setFont(Fuentes.medium(16f));
        lecciones.setForeground(Colores.GRAFITO);
        unidades.setForeground(Colores.GRAFITO);
        lecciones.setCursor(new Cursor(Cursor.HAND_CURSOR));
        unidades.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // "Lecciones" activa por defecto
        lecciones.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Colores.AZUL_CONFIANZA));
        unidades.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));

        lecciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cards.show(panelContenido, "lecciones");
                lecciones.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Colores.AZUL_CONFIANZA));
                unidades.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));
            }
        });

        unidades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cards.show(panelContenido, "unidades");
                unidades.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Colores.AZUL_CONFIANZA));
                lecciones.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));
            }
        });

        panel.add(lecciones);
        panel.add(unidades);

        return panel;
    }

    private JPanel construirInfoCurso() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Colores.BLANCO);
        panel.setPreferredSize(new Dimension(230, 215));
        panel.setMinimumSize(new Dimension(230, 215));
        panel.setMaximumSize(new Dimension(230, 215));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GRIS_BORDE, 1, true),
                BorderFactory.createEmptyBorder(14, 8, 14, 8)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titulo = new JLabel("Información del curso");
        titulo.setFont(Fuentes.bold(14f));
        titulo.setForeground(Colores.GRAFITO);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(12, 0, 0, 0);

        JPanel filas = new JPanel();
        filas.setOpaque(false);
        filas.setLayout(new BoxLayout(filas, BoxLayout.Y_AXIS));

        filas.add(crearFilaInfo("imagenes/assignment.svg", "12 Lecciones"));
        filas.add(crearFilaInfo("imagenes/bookmark.svg", "6 unidades"));
        filas.add(crearFilaInfo("imagenes/schedule.svg", "2h 35m de contenido"));
        filas.add(crearFilaInfo("imagenes/star.svg", "Nivel: Principiante"));

        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(filas, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(14, 0, 0, 0);

        BotonRedondeado continuar = new BotonRedondeado("Continuar aprendiendo", Colores.AZUL_TECNOLOGICO);
        continuar.setColorTexto(Colores.BLANCO);
        continuar.setFont(Fuentes.bold(13f));
        continuar.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(continuar, gbc);

        return panel;
    }

    private JPanel crearFilaInfo(String icono, String texto) {
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        fila.setOpaque(false);
        fila.setAlignmentX(Component.LEFT_ALIGNMENT);
        fila.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));

        JLabel lblIcono = new JLabel();
        try {
            FlatSVGIcon iconoSvg = new FlatSVGIcon(icono, 16, 16);
            iconoSvg.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Colores.AZUL_CONFIANZA));
            lblIcono.setIcon(iconoSvg);
        } catch (Exception e) {
            System.err.println("No se pudo cargar el SVG: " + icono);
        }

        JLabel lblTexto = new JLabel(texto);
        lblTexto.setFont(Fuentes.regular(12f));
        lblTexto.setForeground(Colores.GRAFITO);

        fila.add(lblIcono);
        fila.add(lblTexto);

        return fila;
    }

    private JPanel construirUnidades() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Colores.BLANCO);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GRIS_BORDE, 1, true),
                BorderFactory.createEmptyBorder(16, 24, 16, 24)
        ));

        JPanel encabezado = new JPanel();
        encabezado.setOpaque(false);
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Unidades del curso");
        titulo.setFont(Fuentes.bold(16f));
        titulo.setForeground(Colores.GRAFITO);
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitulo = new JLabel("Organiza tu aprendizaje por temas");
        subtitulo.setFont(Fuentes.regular(13f));
        subtitulo.setForeground(Colores.GRAFITO);
        subtitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        encabezado.add(titulo);
        encabezado.add(Box.createVerticalStrut(4));
        encabezado.add(subtitulo);

        JPanel lista = new JPanel();
        lista.setOpaque(false);
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));
        lista.setBorder(BorderFactory.createEmptyBorder(22, 100, 0, 100));

        lista.add(crearUnidad(
                "Unidad 1",
                "Conociendo nuestras raíces culinarias",
                3,
                3,
                "imagenes/u1.svg"
        ));
        lista.add(Box.createVerticalStrut(12));

        lista.add(crearUnidad(
                "Unidad 2",
                "Sabores que nacen de la tierra",
                2,
                3,
                "imagenes/u2.svg"
        ));
        lista.add(Box.createVerticalStrut(12));

        lista.add(crearUnidad(
                "Unidad 3",
                "Técnicas de la cocina ancestral",
                2,
                3,
                "imagenes/u3.svg"
        ));
        lista.add(Box.createVerticalStrut(12));

        lista.add(crearUnidad(
                "Unidad 4",
                "El arte de cocinar el mole",
                1,
                3,
                "imagenes/u4.svg"
        ));
        lista.add(Box.createVerticalStrut(12));

        lista.add(crearUnidad(
                "Unidad 5",
                "Compartiendo nuestra tradición",
                0,
                3,
                "imagenes/u5.svg"
        ));

        JScrollPane scrollUnidades = new JScrollPane(
                lista,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollUnidades.setBorder(null);
        scrollUnidades.setOpaque(false);
        scrollUnidades.getViewport().setOpaque(false);
        scrollUnidades.getVerticalScrollBar().setUnitIncrement(16);
        scrollUnidades.setPreferredSize(new Dimension(100, 480));

        panel.add(encabezado, BorderLayout.NORTH);
        panel.add(scrollUnidades, BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearUnidad(String numero, String nombre, int completadas, int total, String rutaIcono) {
        JPanel panel = new JPanel(new BorderLayout(25, 0));
        panel.setOpaque(false);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 78));
        panel.setPreferredSize(new Dimension(100, 78));

        FlatSVGIcon svgIcon = new FlatSVGIcon(rutaIcono, 72, 70);
        JLabel icono = new JLabel(svgIcon);
        icono.setPreferredSize(new Dimension(72, 72));
        icono.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel informacion = new JPanel();
        informacion.setOpaque(false);
        informacion.setLayout(new BoxLayout(informacion, BoxLayout.Y_AXIS));

        JPanel fila = new JPanel(new BorderLayout());
        fila.setOpaque(false);
        fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 39));
        fila.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel textoIzq = new JLabel(
                "<html><body style='width:500px'><b>" + numero + "</b><br>"
                + nombre + "</body></html>"
        );
        textoIzq.setFont(Fuentes.regular(12f));
        textoIzq.setForeground(Colores.GRAFITO);

        JLabel textoDer = new JLabel(completadas + "/" + total + " lecciones");
        textoDer.setFont(Fuentes.regular(12f));
        textoDer.setForeground(Colores.GRAFITO);
        textoDer.setHorizontalAlignment(SwingConstants.RIGHT);

        fila.add(textoIzq, BorderLayout.WEST);
        fila.add(textoDer, BorderLayout.EAST);

        JProgressBar barra = crearBarraProgreso((completadas * 100) / total);
        barra.setPreferredSize(new Dimension(100, 9));
        barra.setMaximumSize(new Dimension(Integer.MAX_VALUE, 9));
        barra.setAlignmentX(Component.LEFT_ALIGNMENT);

        informacion.add(fila);
        informacion.add(Box.createVerticalStrut(10));
        informacion.add(barra);

        panel.add(icono, BorderLayout.WEST);
        panel.add(informacion, BorderLayout.CENTER);

        return panel;
    }

    private JPanel construirLecciones() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Colores.BLANCO);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GRIS_BORDE, 1, true),
                BorderFactory.createEmptyBorder(16, 24, 16, 24)
        ));

        JPanel encabezado = new JPanel();
        encabezado.setOpaque(false);
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Lecciones");
        titulo.setFont(Fuentes.bold(16f));
        titulo.setForeground(Colores.GRAFITO);
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitulo = new JLabel("Continúa donde lo dejaste");
        subtitulo.setFont(Fuentes.regular(13f));
        subtitulo.setForeground(Colores.GRAFITO);
        subtitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        encabezado.add(titulo);
        encabezado.add(Box.createVerticalStrut(4));
        encabezado.add(subtitulo);

        JPanel lista = new JPanel();
        lista.setOpaque(false);
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));
        lista.setBorder(BorderFactory.createEmptyBorder(18, 0, 0, 0));

        lista.add(crearLeccion(1, "Origen e historia del mole tradicional",
                "Conoce el significado cultural del mole y su importancia dentro de la comunidad.",
                "8-10 min", EstadoLeccion.COMPLETADO, "/imagenes/leccion1.svg"));
        lista.add(Box.createVerticalStrut(14));

        lista.add(crearLeccion(2, "Ingredientes y su selección",
                "Aprende a identificar y seleccionar los chiles, especias, semillas y demás ingredientes tradicionales.",
                "10-12 min", EstadoLeccion.COMPLETADO, "/imagenes/leccion2.svg"));
        lista.add(Box.createVerticalStrut(14));

        lista.add(crearLeccion(3, "Preparación de los ingredientes",
                "Descubre cómo limpiar, tostar, freír y moler correctamente cada ingrediente antes de la cocción.",
                "12-15 min", EstadoLeccion.EN_PROGRESO, "/imagenes/leccion3.svg"));
        lista.add(Box.createVerticalStrut(14));

        lista.add(crearLeccion(4, "Elaboración del mole paso a paso",
                "Sigue el proceso completo para obtener la textura, aroma y sabor característicos del mole tradicional.",
                "16-19 min", EstadoLeccion.PENDIENTE, "/imagenes/leccion4.svg"));
        lista.add(Box.createVerticalStrut(14));

        lista.add(crearLeccion(5, "Presentación y conservación del mole", "Aprende cómo servir el mole, los acompañamientos tradicionales y las mejores prácticas de conservación.",
                "8-12 min", EstadoLeccion.PENDIENTE, "/imagenes/leccion5.svg" // <-- Solo cambias la extensión aquí
        ));

        JScrollPane scrollLecciones = new JScrollPane(
                lista,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollLecciones.setBorder(null);
        scrollLecciones.setOpaque(false);
        scrollLecciones.getViewport().setOpaque(false);
        scrollLecciones.getVerticalScrollBar().setUnitIncrement(16);
        scrollLecciones.setPreferredSize(new Dimension(100, 480));

        panel.add(encabezado, BorderLayout.NORTH);
        panel.add(scrollLecciones, BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearLeccion(int numero, String titulo, String descripcion, String duracion,
            EstadoLeccion estado, String rutaImagen) {

        JPanel fila = new JPanel(new BorderLayout(16, 0));
        fila.setOpaque(false);
        fila.setAlignmentX(Component.LEFT_ALIGNMENT);
        fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 74));
        fila.setPreferredSize(new Dimension(100, 74));

        JComponent iconoEstado = crearIconoEstado(estado);

        ImagenEscalable miniatura = crearImagenEscalable(new String[]{rutaImagen});
        miniatura.setPreferredSize(new Dimension(90, 60));

        JPanel izquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 14, 0));
        izquierda.setOpaque(false);
        izquierda.add(iconoEstado);
        izquierda.add(miniatura);

        JPanel texto = new JPanel();
        texto.setOpaque(false);
        texto.setLayout(new BoxLayout(texto, BoxLayout.Y_AXIS));

        JLabel tit = new JLabel(numero + ". " + titulo);
        tit.setFont(Fuentes.bold(13f));
        tit.setForeground(Colores.GRAFITO);
        tit.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel desc = new JLabel(
                "<html><body style='width:340px'>" + descripcion + "</body></html>"
        );
        desc.setFont(Fuentes.regular(13f));
        desc.setForeground(Colores.GRAFITO);
        desc.setAlignmentX(Component.LEFT_ALIGNMENT);

        texto.add(tit);
        texto.add(Box.createVerticalStrut(4));
        texto.add(desc);

        JPanel derecha = new JPanel(new BorderLayout());
        derecha.setOpaque(false);
        derecha.setPreferredSize(new Dimension(230, 40));

        JLabel duracionLbl = new JLabel(duracion, SwingConstants.LEFT);
        duracionLbl.setFont(Fuentes.regular(13f));
        duracionLbl.setForeground(Colores.GRAFITO);

        JComponent badge = crearBadgeEstado(estado);

        JPanel contenedorBadge = new JPanel(new GridBagLayout());
        contenedorBadge.setOpaque(false);
        contenedorBadge.setPreferredSize(new Dimension(130, 40));

        GridBagConstraints gbcBadge = new GridBagConstraints();
        gbcBadge.anchor = GridBagConstraints.CENTER;
        contenedorBadge.add(badge, gbcBadge);

        derecha.add(duracionLbl, BorderLayout.CENTER);
        derecha.add(contenedorBadge, BorderLayout.EAST);

        fila.add(izquierda, BorderLayout.WEST);
        fila.add(texto, BorderLayout.CENTER);
        fila.add(derecha, BorderLayout.EAST);

        return fila;
    }

    private JComponent crearIconoEstado(EstadoLeccion estado) {
        JPanel circulo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
                int w = getWidth();
                int h = getHeight();

                g2.setColor(Colores.BLANCO);
                g2.fillRect(0, 0, w, h);

                if (estado == EstadoLeccion.PENDIENTE) {
                    g2.setColor(Colores.BLANCO);
                    g2.fillOval(1, 1, w - 2, h - 2);
                    g2.setStroke(new BasicStroke(1.4f));
                    g2.setColor(GRIS_BORDE);
                    g2.drawOval(1, 1, w - 2, h - 2);
                } else {
                    g2.setColor(estado == EstadoLeccion.COMPLETADO ? AZUL_ICONO : new Color(0x6FA3E8));
                    g2.fillOval(0, 0, w, h);
                    g2.setColor(Colores.BLANCO);

                    if (estado == EstadoLeccion.COMPLETADO) {
                        g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                        Path2D check = new Path2D.Double();
                        check.moveTo(w * 0.27, h * 0.52);
                        check.lineTo(w * 0.43, h * 0.68);
                        check.lineTo(w * 0.74, h * 0.32);
                        g2.draw(check);
                    } else {
                        int[] xs = {(int) (w * 0.40), (int) (w * 0.40), (int) (w * 0.66)};
                        int[] ys = {(int) (h * 0.30), (int) (h * 0.70), h / 2};
                        g2.fillPolygon(xs, ys, 3);
                    }
                }
                g2.dispose();
            }
        };
        circulo.setOpaque(false);
        circulo.setPreferredSize(new Dimension(22, 22));
        return circulo;
    }

    private JComponent crearBadgeEstado(EstadoLeccion estado) {
        String texto;
        Color fondo;
        Color letra;
        boolean borde = false;

        switch (estado) {
            case COMPLETADO:
                texto = "Completado";
                fondo = Colores.AZUL_TECNOLOGICO;
                letra = Colores.BLANCO;
                break;
            case EN_PROGRESO:
                texto = "En progreso";
                fondo = new Color(0x6FA3E8);
                letra = Colores.BLANCO;
                break;
            default:
                texto = "Pendiente";
                fondo = Colores.BLANCO;
                letra = TEXTO_SECUNDARIO;
                borde = true;
        }

        final boolean bordeFinal = borde;
        final Color fondoFinal = fondo;

        JLabel badge = new JLabel(texto, SwingConstants.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(Colores.BLANCO);
                g2.fillRect(0, 0, getWidth(), getHeight());

                g2.setColor(fondoFinal);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
                if (bordeFinal) {
                    g2.setColor(GRIS_BORDE);
                    g2.setStroke(new BasicStroke(1.2f));
                    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, getHeight(), getHeight());
                }
                g2.dispose();
                super.paintComponent(g);
            }
        };

        badge.setOpaque(false);
        badge.setForeground(letra);

        badge.setFont(Fuentes.bold(13f));

        FontMetrics fm = badge.getFontMetrics(badge.getFont());
        int anchoTexto = fm.stringWidth(texto);
        int ancho = anchoTexto + 12;
        int alto = 30;
        badge.setPreferredSize(new Dimension(ancho, alto));

        return badge;
    }

    private JProgressBar crearBarraProgreso(int valor) {
        JProgressBar barra = new JProgressBar(0, 100);
        barra.setValue(valor);
        barra.setForeground(AZUL_BARRA);
        barra.setBackground(new Color(0xE9EDF7));
        barra.setBorderPainted(false);
        barra.setStringPainted(false);

        return barra;
    }

    private JLabel crearImagen(String[] rutas, int ancho, int alto) {
        URL recurso = buscarRecurso(rutas);

        JLabel etiqueta = new JLabel();
        etiqueta.setOpaque(true);
        etiqueta.setBackground(new Color(0xD1D5DB));
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setVerticalAlignment(SwingConstants.CENTER);

        if (recurso != null) {
            ImageIcon iconoOriginal = new ImageIcon(recurso);
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                    ancho,
                    alto,
                    Image.SCALE_SMOOTH
            );
            etiqueta.setIcon(new ImageIcon(imagenEscalada));
        }

        return etiqueta;
    }

    // Asegúrate de que tu método auxiliar haga algo como esto:
    private ImagenEscalable crearImagenEscalable(String[] rutasImagen) {
        ImagenEscalable img = new ImagenEscalable();
        if (rutasImagen != null && rutasImagen.length > 0) {
            img.cargarImagen(rutasImagen[0]);
        }
        return img;
    }

    private URL buscarRecurso(String[] rutas) {
        URL recurso = null;
        for (String ruta : rutas) {
            recurso = getClass().getResource(ruta);
            if (recurso != null) {
                break;
            }
        }
        return recurso;
    }

    class PanelScrolleable extends JPanel implements Scrollable {

        public PanelScrolleable() {
            super();
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return true; // Obliga al panel a no superar el ancho de la ventana
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return getPreferredSize();
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle r, int o, int d) {
            return 16;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle r, int o, int d) {
            return 50;
        }
    }
}
