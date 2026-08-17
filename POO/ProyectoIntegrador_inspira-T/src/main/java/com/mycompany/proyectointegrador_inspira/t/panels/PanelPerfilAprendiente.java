/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.panels.RoundedPanel;
import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Iconos;
import com.mycompany.proyectointegrador_inspira.t.componentes.LblSubtitulo;
import com.mycompany.proyectointegrador_inspira.t.componentes.BotonRedondeado;
import com.mycompany.proyectointegrador_inspira.t.componentes.CircularImageLabel;
import com.mycompany.proyectointegrador_inspira.t.componentes.TextField;
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
public class PanelPerfilAprendiente extends JPanel {

    private RoundedPanel profileCard;
    private RoundedPanel informationCard;
    private BotonRedondeado btnEditar;
    private BotonRedondeado btnGuardar;
    private BotonRedondeado btnCerrarSesion;

    public PanelPerfilAprendiente() {
        initComponents();
    }

    private void initComponents() {
        setOpaque(false);

        setLayout(null);
        //Inicializar la tarjeta de fondo
        profileCard = createProfileCard();
        // Posición y tamaño: (x, y, ancho, alto)
        profileCard.setBounds(0, 0, 1020, 571);

        //Inicializar la tarjeta de enfrente
        informationCard = createInformationCard();
        // La colocamos dentro de la tarjeta de fondo 
        int xAmarilla = 20 + ((980 - 970) / 2); // Centrada respecto al ancho de la del fondo
        int yAmarilla = 205; // Subirla o bajarla sobre la del fondo
        informationCard.setBounds(xAmarilla, yAmarilla, 970, 250);

        // Agregamos primero la de frente para que quede justo al frente
        add(informationCard);
        add(profileCard);

        // Tamaño al panel contenedor principal:
        setPreferredSize(new Dimension(320, 580));
    }

    private RoundedPanel createProfileCard() {

        RoundedPanel card = new RoundedPanel();
        card.setRadius(0);
        card.setBackground(Color.WHITE);
        card.setLayout(new BorderLayout());

        card.setMaximumSize(new Dimension(300, 800));
        card.setPreferredSize(new Dimension(280, 571));
        card.setBorder(BorderFactory.createEmptyBorder(1, 30, 1, 1));

        //==================== PANEL SUPERIOR ====================
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
                        16,
                        Colores.GRAFITO));

        btnEditarFoto.setDiameter(34);

        btnEditarFoto.setButtonColor(Colores.BLANCO);

        btnEditarFoto.setHoverColor(new Color(74, 165, 255));

        btnEditarFoto.setPressedColor(new Color(20, 110, 210));

        btnEditarFoto.setBorderColor(Color.WHITE);

        // Posición sobre la esquina inferior derecha de la foto
        btnEditarFoto.setBounds(98, 98, 34, 34);

        fotoPanel.add(foto, Integer.valueOf(0));
        //topPanel.add(tituloPerfil);
        //topPanel.add(Box.createVerticalStrut(10));
        //topPanel.add(fotoPanel);
        fotoPanel.add(btnEditarFoto, Integer.valueOf(1));

        topPanel.add(fotoPanel);

        card.add(topPanel, BorderLayout.NORTH);
        // Subtítulo
        LblSubtitulo subtituloNombre = new LblSubtitulo("Nombre de usuario");
        subtituloNombre.setSubtitleColor(Colores.GRAFITO);
        subtituloNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(subtituloNombre);
        LblSubtitulo subtituloTipo = new LblSubtitulo("Aprendiente");
        subtituloTipo.setSubtitleColor(Colores.GRAFITO);
        subtituloTipo.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(subtituloTipo);
        //topPanel.add(Box.createVerticalStrut(42));
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setOpaque(false);

        //card.add(layeredPane, BorderLayout.CENTER);
        JLabel right = new JLabel(
                new FlatSVGIcon("imagenes/imgRight.svg", 135, 135));

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

        layeredPane.add(right, Integer.valueOf(0));
        layeredPane.add(top, Integer.valueOf(1));
        layeredPane.add(left, Integer.valueOf(2));
        layeredPane.add(bottom, Integer.valueOf(3));
        layeredPane.add(btnGuardar, Integer.valueOf(4));
        layeredPane.add(btnCerrarSesion, Integer.valueOf(4));
        layeredPane.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {

                int w = layeredPane.getWidth();
                int h = layeredPane.getHeight();

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
                int margenInferior = 78;
                int btnX = w - btnAncho - margenDerecho;
                int btnY = h - btnAlto - margenInferior;

                btnGuardar.setBounds(btnX, btnY, btnAncho, btnAlto);

                //Botón Cerrar Sesión
                int margenDerechoC = 55;
                int margenInferiorC = 20;
                int btnXC = w - btnAnchoC - margenDerechoC;
                int btnYC = h - btnAltoC - margenInferiorC;

                btnCerrarSesion.setBounds(btnXC, btnYC, btnAnchoC, btnAltoC);
            }
        });
        card.add(layeredPane, BorderLayout.CENTER);

        return card;
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
                "[][][][][]"));
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
        JLabel lblNombre = new JLabel("Nombre completo *");
        JLabel lblUsuario = new JLabel("Nombre de usuario *");
        lblNombre.setForeground(Colores.GRAFITO);
        lblUsuario.setForeground(Colores.GRAFITO);
        card2.add(lblNombre);
        card2.add(lblUsuario, "wrap");

        // TextFields
        TextField txtNombre = new TextField("Nombre completo");
        TextField txtUsuario = new TextField("Nombre de usuario");
        txtNombre.setRadius(22);
        txtUsuario.setRadius(22);

        card2.add(txtNombre, "growx");
        card2.add(txtUsuario, "growx, wrap 15");
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
        card2.add(txtCorreo, "growx");
        card2.add(txtTelefono, "growx");

        return card2;

    }
}
