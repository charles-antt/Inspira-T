/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Iconos;
import com.mycompany.proyectointegrador_inspira.t.componentes.LblSubtitulo;
import com.mycompany.proyectointegrador_inspira.t.componentes.BotonRedondeado;
import com.mycompany.proyectointegrador_inspira.t.componentes.CircularImageLabel;
import com.mycompany.proyectointegrador_inspira.t.componentes.TextField;
import com.mycompany.proyectointegrador_inspira.t.componentes.JTextAreaRedondeado;
import com.mycompany.proyectointegrador_inspira.t.componentes.BtnIcon;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import net.miginfocom.swing.MigLayout;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author berth
 */
public class PanelPerfilInstructor extends JPanel {

    private RoundedPanel profileCard;
    private RoundedPanel informationCard;
    private BotonRedondeado btnEditar;
    private BotonRedondeado btnGuardar;
    private BotonRedondeado btnCerrarSesion;

    public PanelPerfilInstructor() {
        initComponents();
        //setLayout(null);
        RoundedPanel card = new RoundedPanel();
        //card.setRadius(0);
        card.setBackground(Colores.BLANCO);
        card.setLayout(new BorderLayout());
        //card.setBorder(BorderFactory.createEmptyBorder(1, 30, 1, 1));
        card.setBounds(0, 0, 1020, 830);
        //card.setMaximumSize(new Dimension(700, 1000));
        //card.setPreferredSize(new Dimension(580, 871));
        //topPanel.add(Box.createVerticalStrut(42));
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setOpaque(false);

        //card.add(layeredPane, BorderLayout.CENTER);
        JLabel right = new JLabel(
                new FlatSVGIcon("imagenes/ImgRight.svg", 135, 135));

        JLabel top = new JLabel(
                new FlatSVGIcon("imagenes/imgTop.svg", 110, 110));
        JLabel left = new JLabel(
                new FlatSVGIcon("imagenes/imgLeft.svg", 115, 115));
        JLabel bottom = new JLabel(
                new FlatSVGIcon("imagenes/imgBottom.svg", 160, 100));

        btnGuardar = new BotonRedondeado("Guardar", Colores.AZUL_TECNOLOGICO);
        //btnGuardar.setPreferredSize(new Dimension(110, 40));
        int btnAncho = 110;
        int btnAlto = 40;
        btnGuardar.setSize(btnAncho, btnAlto);

        btnCerrarSesion = new BotonRedondeado("Cerrar Sesión", Colores.MORADO);
        //btnGuardar.setPreferredSize(new Dimension(110, 40));
        int btnAnchoC = 150;
        int btnAltoC = 40;
        btnCerrarSesion.setSize(btnAnchoC, btnAltoC);

        layeredPane.add(right, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(top, Integer.valueOf(1));
        layeredPane.add(left, Integer.valueOf(2));
        layeredPane.add(bottom, Integer.valueOf(3));
        layeredPane.add(btnGuardar, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(btnCerrarSesion, JLayeredPane.PALETTE_LAYER);
        layeredPane.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {

                int w = layeredPane.getWidth();
                int h = layeredPane.getHeight();
                if (w == 0 || h == 0) {
                    return;
                }
                // ImgRight
                right.setBounds(
                        w - 69,
                        h - 95,
                        90,
                        90);
                // ImgTop
                top.setBounds(
                        w - 107,
                        h - 230,
                        180,
                        180);
                // ImgLeft
                left.setBounds(
                        w - 220,
                        h - 235,
                        270,
                        270);
                // ImgBottom
                bottom.setBounds(
                        w - 290,
                        h - 185,
                        360,
                        360);
                //Botón Guardar
                int margenDerecho = 55;
                int margenInferior = 72;
                int btnX = w - btnAncho - margenDerecho;
                int btnY = h - btnAlto - margenInferior;

                btnGuardar.setBounds(btnX, btnY, btnAncho, btnAlto);

                //Botón Cerrar Sesión
                int margenDerechoC = 55;
                int margenInferiorC = 16;
                int btnXC = w - btnAnchoC - margenDerechoC;
                int btnYC = h - btnAltoC - margenInferiorC;

                btnCerrarSesion.setBounds(btnXC, btnYC, btnAnchoC, btnAltoC);
            }
        });
        card.add(layeredPane, BorderLayout.CENTER);
        add(card);
        revalidate();
        repaint();
    }

    private void initComponents() {
        setOpaque(false);

        setLayout(null);

        setPreferredSize(new Dimension(1320, 830));

        RoundedPanel card = new RoundedPanel();
        card.setRadius(0);
        card.setBackground(Colores.BLANCO);
        card.setLayout(new BorderLayout());

        card.setMaximumSize(new Dimension(300, 800));
        card.setPreferredSize(new Dimension(280, 571));
        card.setBorder(BorderFactory.createEmptyBorder(1, 30, 1, 1));
        //
        card.setBounds(0, 0, 1030, 215);
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        // Imagen redonda
        CircularImageLabel foto = new CircularImageLabel("/imagenes/photo.png", 125);
        foto.setBounds(7, 7, 125, 125);
        JLayeredPane fotoPanel = new JLayeredPane();
        fotoPanel.setOpaque(false);
        fotoPanel.setPreferredSize(new Dimension(140, 140));
        fotoPanel.setMaximumSize(new Dimension(140, 140));
        fotoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //fotoPanel.add(foto, Integer.valueOf(0));
        foto.setAlignmentX(Component.CENTER_ALIGNMENT);

        //BtnEditar
        BtnIcon btnEditarFoto = new BtnIcon(
                Iconos.cargar(
                        Iconos.EDIT,
                        20,
                        Colores.GRAFITO));

        btnEditarFoto.setDiameter(42);

        btnEditarFoto.setButtonColor(Colores.BLANCO);

        btnEditarFoto.setHoverColor(new Color(74, 165, 255));

        btnEditarFoto.setPressedColor(new Color(20, 110, 210));

        btnEditarFoto.setBorderColor(Color.WHITE);

        // Posición sobre la esquina inferior derecha de la foto
        btnEditarFoto.setBounds(98, 98, 34, 34);
        fotoPanel.add(foto, JLayeredPane.DEFAULT_LAYER);
        //------------fotoPanel.add(foto, Integer.valueOf(0));
        //topPanel.add(tituloPerfil);
        //topPanel.add(Box.createVerticalStrut(10));
        //topPanel.add(fotoPanel);
        fotoPanel.add(btnEditarFoto, JLayeredPane.PALETTE_LAYER);
        //fotoPanel.add(btnEditarFoto, Integer.valueOf(1));

        topPanel.add(fotoPanel);
        card.add(topPanel, BorderLayout.NORTH);
        // Subtítulo
        LblSubtitulo subtituloNombre = new LblSubtitulo("Nombre de usuario");
        subtituloNombre.setSubtitleColor(Colores.GRAFITO);
        subtituloNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(subtituloNombre);
        LblSubtitulo subtituloTipo = new LblSubtitulo("Instructor");
        subtituloTipo.setSubtitleColor(Colores.GRAFITO);
        subtituloTipo.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(subtituloTipo);
        //topPanel.add(Box.createVerticalStrut(42));
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setOpaque(false);

        // 2. Inicializar la tarjeta de enfrente (AMARILLA)
        informationCard = createInformationCard();
        // La colocamos dentro de la tarjeta roja. 
        // Ejemplo: centrada horizontalmente y un poco desfasada hacia abajo
        int xAmarilla = 20 + ((980 - 970) / 2); // Centrada respecto al ancho de la roja (140px)
        int yAmarilla = 210; // Ajusta este valor para subirla o bajarla sobre la roja
        informationCard.setBounds(xAmarilla, yAmarilla, 970, 507);

        // IMPORTANTE: El orden de adición define las capas en layout nulo.
        // Agregamos primero la amarilla para que quede al frente, o usamos setComponentZOrder
        add(informationCard);
        add(card);
    }

    private RoundedPanel createInformationCard() {
        RoundedPanel card2 = new RoundedPanel();
        card2.setOpaque(false);//*********
        card2.setRadius(25);
        card2.setBackground(new Color(255, 255, 255, 125));
        //card2.setLayout(new BorderLayout());
        card2.setLayout(new MigLayout(
                "fillx, insets 10,gapx 30, gapy 10",
                "[50%,grow,fill][50%, grow,fill]",
                "[]"));
        //card2.setMaximumSize(new Dimension(150,400));
        //card2.setPreferredSize(new Dimension(140, 251));
        card2.setBorder(BorderFactory.createEmptyBorder(1, 20, 1, 20));

        LblSubtitulo lblTitulo = new LblSubtitulo("Información personal");
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(java.awt.Font.BOLD));

        lblTitulo.setSubtitleColor(Colores.GRAFITO);
        //lblTitulo.setSubtitleSize(18f);
        //JButton btnEditar = new JButton("Editar");
        btnEditar = new BotonRedondeado("Editar", Colores.TURQUESA);
        btnEditar.setPreferredSize(new Dimension(110, 40));
        btnEditar.setForeground(Color.black);

        card2.add(lblTitulo, "left");
        card2.add(btnEditar, "right,w 100!, h 40!, wrap 20");

        // Etiquetas
        JLabel lblNombre = new JLabel("Nombre completo*");
        JLabel lblUsuario = new JLabel("Nombre de usuario*");
        lblNombre.setForeground(Colores.GRAFITO);
        lblUsuario.setForeground(Colores.GRAFITO);
        card2.add(lblNombre);
        card2.add(lblUsuario, "wrap");

        // TextFields
        TextField txtNombre = new TextField("Nombre completo");
        TextField txtUsuario = new TextField("Nombre de usuario");
        txtNombre.setRadius(22);
        txtUsuario.setRadius(22);

        card2.add(txtNombre);
        card2.add(txtUsuario, "wrap 15");

        // Etiquetas
        JLabel lblCorreo = new JLabel("Correo electrónico*");
        JLabel lblTelefono = new JLabel("Número de teléfono*");
        lblCorreo.setForeground(Colores.GRAFITO);
        lblTelefono.setForeground(Colores.GRAFITO);
        card2.add(lblCorreo);
        card2.add(lblTelefono, "wrap");

        // TextFields
        TextField txtCorreo = new TextField("Correo electrónico");
        TextField txtTelefono = new TextField("Número de teléfono");
        txtCorreo.setRadius(22);
        txtTelefono.setRadius(22);
        card2.add(txtCorreo);
        card2.add(txtTelefono, "wrap 30");

        txtCorreo.setRadius(22);
        txtTelefono.setRadius(22);
        //INFORMACIÓN ADICIONAL
        LblSubtitulo lblAdicional = new LblSubtitulo("Información adicional");
        lblAdicional.setFont(lblAdicional.getFont().deriveFont(java.awt.Font.BOLD));

        lblAdicional.setSubtitleColor(Colores.GRAFITO);
        //lblAdicional.setSubtitleSize(18f);        

        card2.add(lblAdicional, "span 2, left, wrap 20");
        // Etiquetas
        //====================================================

        JLabel lblAnios = new JLabel("Años de experiencia*");
        JLabel lblCiudad = new JLabel("Ciudad*");
        lblAnios.setForeground(Colores.GRAFITO);
        lblCiudad.setForeground(Colores.GRAFITO);
        card2.add(lblAnios);
        card2.add(lblCiudad, "wrap");
        // TextFields
        //====================================================

        TextField txtAnios = new TextField("Ej. 6 años");
        TextField txtCiudad = new TextField("Nombre de la ciudad");
        txtAnios.setRadius(22);
        txtCiudad.setRadius(22);

        card2.add(txtAnios);
        card2.add(txtCiudad, "wrap 15");
        //====================================================
        // Etiquetas
        //====================================================

        JLabel lblBibliografia = new JLabel("Bibliografía*");
        JLabel lblFrase = new JLabel("Frase personal*");
        lblBibliografia.setForeground(Colores.GRAFITO);
        lblFrase.setForeground(Colores.GRAFITO);
        card2.add(lblBibliografia);
        card2.add(lblFrase, "wrap");

        // TextFields
        JTextArea jBibliografia = new JTextArea(2, 20);
        jBibliografia.setLineWrap(true);
        jBibliografia.setWrapStyleWord(true);
        jBibliografia.setOpaque(false);
        JScrollPane spBibliografia = new JScrollPane(jBibliografia);
        spBibliografia.setBorder(
                new JTextAreaRedondeado(
                        22,
                        new Color(210, 210, 210)));

        spBibliografia.getViewport().setOpaque(false);
        spBibliografia.setOpaque(false);

        JTextArea jFrase = new JTextArea(2, 20);
        jFrase.setLineWrap(true);
        jFrase.setWrapStyleWord(true);
        jBibliografia.setOpaque(false);
        //jBibliografia.setBorder(BorderFactory.createEmptyBorder(2,2,3,10));
        JScrollPane spFrase = new JScrollPane(jFrase);
        spFrase.setBorder(
                new JTextAreaRedondeado(
                        22,
                        new Color(210, 210, 210)));

        spFrase.getViewport().setOpaque(false);
        spFrase.setOpaque(false);

        card2.add(spBibliografia, "growx");
        card2.add(spFrase, "growx");

        return card2;
    }
}
