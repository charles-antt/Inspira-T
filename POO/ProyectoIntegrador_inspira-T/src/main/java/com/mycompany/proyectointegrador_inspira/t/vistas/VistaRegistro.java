/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.vistas;

import com.mycompany.proyectointegrador_inspira.t.panels.PanelFondoDecorativo;
import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.componentes.TextField;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
import com.mycompany.proyectointegrador_inspira.t.util.Iconos;
import com.mycompany.proyectointegrador_inspira.t.util.Imagenes;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.extras.FlatSVGIcon.ColorFilter;
import com.formdev.flatlaf.FlatClientProperties; // Asegúrate de importar esto
import com.mycompany.proyectointegrador_inspira.t.componentes.BotonRedondeado;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author berth
 */
public class VistaRegistro extends JFrame {

    private Icon leftIcon;

    public VistaRegistro() {
        setTitle("inspira-T");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // CAPA PRINCIPAL
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setOpaque(true);
        layeredPane.setBackground(Color.WHITE);

        setContentPane(layeredPane);

        //FONDO DECORATIVO
        PanelFondoDecorativo fondoDecorativo = new PanelFondoDecorativo();

        fondoDecorativo.setBounds(
                0,
                0,
                getWidth(),
                getHeight()
        );

        layeredPane.add(
                fondoDecorativo,
                JLayeredPane.DEFAULT_LAYER
        );

        //CONTENIDO DE LA VISTA
        JPanel contenido = new JPanel(new GridBagLayout());
        contenido.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;

        // SECCIÓN IZQUIERDA
        gbc.gridx = 0;
        gbc.weightx = 0.50;
        //gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(15, 1, 1, 1);
        contenido.add(
                crearSeccionIzquierda(),
                gbc
        );

        // SECCIÓN DERECHA
        gbc.gridx = 1;
        gbc.weightx = 0.50;
        //gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(15, 1, 1, 1);
        contenido.add(
                crearSeccionDerecha(),
                gbc
        );

        JScrollPane scrollPane = new JScrollPane(contenido);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);

        // AGREGAR CONTENIDO ENCIMA DEL FONDO
        layeredPane.add(
                scrollPane,
                JLayeredPane.PALETTE_LAYER
        );

        // AJUSTAR TAMAÑOS AL CAMBIAR LA VENTANA
        addComponentListener(new java.awt.event.ComponentAdapter() {

            @Override
            public void componentResized(
                    java.awt.event.ComponentEvent e) {

                int ancho = getContentPane().getWidth();
                int alto = getContentPane().getHeight();

                fondoDecorativo.setBounds(
                        0,
                        0,
                        ancho,
                        alto
                );

                scrollPane.setBounds(
                        0,
                        0,
                        ancho,
                        alto
                );

                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        setVisible(true);
    }

    private JPanel crearSeccionIzquierda() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);
        panel.setBackground(Colores.BLANCO);
        panel.setPreferredSize(new Dimension(450, 750));

        JPanel pnlLogo = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pnlLogo.setOpaque(false);
        pnlLogo.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlLogo.setMaximumSize(new Dimension(450, 160));
        
        JLabel lblLogo = new JLabel();
        lblLogo.setAlignmentX(Component.LEFT_ALIGNMENT);
        cargarImagen(lblLogo, "imagenes/logoSlogan.svg", 270, 200);
        lblLogo.setBorder(new EmptyBorder(0, 150, 0, 0));
        pnlLogo.add(lblLogo);

        JLabel lblTitulo = new JLabel("<html><b>Únete a nuestra</b> <font color='#2DCEA8'>comunidad</font></html>");
        lblTitulo.setFont(Fuentes.bold(25f));
        lblTitulo.setForeground(Colores.GRAFITO);
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblTitulo.setBorder(new EmptyBorder(0, 30, 0, 0));

        JLabel lblDesc = new JLabel("<html>Crea tu cuenta y accede a cursos, videos y transmisiones sobre conocimientos ancestrales y tradiciones culturales.</html>");
        lblDesc.setFont(Fuentes.bold(14f));
        lblDesc.setForeground(Colores.GRAFITO);
        lblDesc.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblDesc.setMaximumSize(new Dimension(440, 45));
        lblDesc.setBorder(new EmptyBorder(0, 30, 0, 0));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 530));
        layeredPane.setMaximumSize(new Dimension(600, 530));
        layeredPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Imagen principal de las artesanas (bordado.png)
        JLabel lblArtesanas = new JLabel();
        //lblArtesanas.setHorizontalAlignment(SwingConstants.LEFT);
        //lblArtesanas.setVerticalAlignment(SwingConstants.BOTTOM);
        cargarImagen(lblArtesanas, "imagenes/imgRegistro.svg", 600, 530);
        lblArtesanas.setBounds(0, 0, 600, 530);

        JPanel cardBeneficios = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                g2.dispose();
            }
        };
        cardBeneficios.setLayout(new BoxLayout(cardBeneficios, BoxLayout.Y_AXIS));
        cardBeneficios.setOpaque(false);
        cardBeneficios.setBorder(new EmptyBorder(1, 1, 1, 1));
        cardBeneficios.setBounds(10, 10, 300, 200);

        /**
         * cardBeneficios.add(crearItemBeneficio("Aprende", "Accede a contenido
         * educativo creado por expertos y guardianes del conocimiento.",
         * "/imagenes/birrete.png", new Color(47, 128, 237)));
         * cardBeneficios.add(Box.createVerticalStrut(5));
         * cardBeneficios.add(crearItemBeneficio("Conecta", "Interactúa con
         * comunidades y comparte experiencias.", "/imagenes/conecta.png", new
         * Color(123, 97, 255)));
         * cardBeneficios.add(Box.createVerticalStrut(5));
         * cardBeneficios.add(crearItemBeneficio("Preserva", "Ayuda a preservar
         * nuestras raíces para futuras generaciones.", "/imagenes/hoja.png",
         * new Color(45, 206, 178)));
         *
         */
        // Ensamblar
        panel.add(pnlLogo);
        panel.add(Box.createVerticalStrut(15));
        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(6));
        panel.add(lblDesc);
        panel.add(lblArtesanas, Integer.valueOf(1));
        panel.add(Box.createVerticalStrut(10));

        panel.add(cardBeneficios, Integer.valueOf(2));

        panel.add(layeredPane);
        return panel;
    }

    private JPanel crearItemBeneficio(String titulo, String desc, String rutaIcono, Color color) {
        JPanel item = new JPanel(new BorderLayout(12, 0));
        item.setOpaque(false);

        JLabel icono = new JLabel();
        cargarImagen(icono, rutaIcono, 40, 40);

        JPanel pnlTexto = new JPanel();
        pnlTexto.setOpaque(false);
        pnlTexto.setLayout(new BoxLayout(pnlTexto, BoxLayout.Y_AXIS));

        JLabel lblT = new JLabel(titulo);
        lblT.setFont(Fuentes.bold(14f));
        lblT.setForeground(color);

        JLabel lblD = new JLabel("<html>" + desc + "</html>");
        lblD.setFont(Fuentes.regular(10f));
        lblD.setForeground(Colores.GRAFITO);

        pnlTexto.add(lblT);
        pnlTexto.add(lblD);

        item.add(icono, BorderLayout.WEST);
        item.add(pnlTexto, BorderLayout.CENTER);
        return item;
    }

    private JPanel crearSeccionDerecha() {
        JPanel contenedor = new JPanel(new GridBagLayout());

        contenedor.setLayout(
                new BoxLayout(
                        contenedor,
                        BoxLayout.Y_AXIS
                )
        );

        contenedor.setOpaque(false);

        contenedor.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );
        JPanel tarjeta = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(31, 60, 136, 20));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

                // Borde suave
                g2.setColor(new Color(31, 60, 136, 50));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
                g2.dispose();
            }
        };
        tarjeta.setOpaque(false);
        tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));
        tarjeta.setBorder(new EmptyBorder(10, 0, 10, 0));
        //tarjeta.setPreferredSize(new Dimension(410, 610));
        //tarjeta.setBounds(0, 0, 500, 730);
        tarjeta.setPreferredSize(
                new Dimension(500, 800)
        );

        tarjeta.setMaximumSize(
                new Dimension(450, 780)
        );

        tarjeta.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        /**
         * JLabel lblIconoUser = new JLabel();
         * lblIconoUser.setAlignmentX(Component.CENTER_ALIGNMENT);
         * cargarImagen(lblIconoUser, "imagenes/person.svg", 50, 50);*
         */
        JLabel lblTituloForm = new JLabel("Crear cuenta");
        lblTituloForm.setFont(Fuentes.bold(28f));
        lblTituloForm.setForeground(Colores.AZUL_CONFIANZA);
        lblTituloForm.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSub = new JLabel("Completa el formulario para registrarte");
        lblSub.setFont(Fuentes.bold(14f));
        lblSub.setForeground(Colores.AZUL_CONFIANZA);
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel pnlDivider = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Colores.AZUL_TECNOLOGICO);
                g.drawLine(20, getHeight() / 2, getWidth() - 20, getHeight() / 2);
            }
        };
        pnlDivider.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pnlDivider.setOpaque(false);
        pnlDivider.setMaximumSize(new Dimension(410, 20));
        pnlDivider.setAlignmentX(Component.CENTER_ALIGNMENT);
        /**
         * JLabel lblFlor = new JLabel(); cargarImagen(lblFlor,
         * "imagenes/flor.svg", 22, 22); pnlDivider.add(lblFlor);*
         */
        JPanel campoNombre = crearCampoTexto("Nombre completo", "Ingresa tu nombre completo", "imagenes/user.svg", false);
        JPanel campoCorreo = crearCampoTexto("Correo electronico", "Ingresa tu correo electrónico", "imagenes/mail.svg", false);
        JPanel campoUsuario = crearCampoTexto("Nombre de usuario", "Ingresa un nombre de usuario", "imagenes/alternateEmail.svg", false);
        JPanel campoPass = crearCampoTexto("Contraseña", "Ingresa tu contraseña", "imagenes/lock.svg", true);
        JPanel campoConfPass = crearCampoTexto("Confirmar contraseña", "Confirma tu contraseña", "imagenes/lock.svg", true);

        JLabel lblTipo = new JLabel("Tipo de usuario");
        lblTipo.setFont(Fuentes.bold(16f));
        lblTipo.setForeground(Colores.GRAFITO);

        JPanel pnlTipoWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT, 41, 0));
        pnlTipoWrapper.setOpaque(false);
        pnlTipoWrapper.setMaximumSize(new Dimension(410, 18));
        pnlTipoWrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlTipoWrapper.add(lblTipo);

        JPanel pnlTipos = new JPanel(new GridLayout(1, 2, 10, 10));
        pnlTipos.setOpaque(false);
        pnlTipos.setMaximumSize(new Dimension(330, 100));
        pnlTipos.setAlignmentX(Component.CENTER_ALIGNMENT);

        pnlTipos.add(crearCardTipoUsuario("Aprendiente", "Quiero aprender y explorar saberes ancestrales.", "imagenes/aprendiente.svg", true));
        pnlTipos.add(crearCardTipoUsuario("Instructor", "Quiero compartir mis conocimientos.", "imagenes/instructor.svg", false));

        BotonRedondeado btnCrear = new BotonRedondeado("Iniciar sesión", Colores.AZUL_TECNOLOGICO);
        com.formdev.flatlaf.extras.FlatSVGIcon iconoBoton = new com.formdev.flatlaf.extras.FlatSVGIcon("imagenes/personAdd.svg", 25, 25);
        iconoBoton.setColorFilter(new com.formdev.flatlaf.extras.FlatSVGIcon.ColorFilter(color -> Color.WHITE));
        btnCrear.setIcon(iconoBoton);
        btnCrear.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnCrear.setIconTextGap(10);

        btnCrear.setFont(Fuentes.bold(16f));
        btnCrear.setColorTexto(Colores.BLANCO);
        btnCrear.setMaximumSize(new Dimension(330, 44));
        btnCrear.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCrear.setColorBorde(Colores.AZUL_TECNOLOGICO);

        JPanel pnlRegister = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
        pnlRegister.setOpaque(false);

        JLabel lblPre = new JLabel("¿Ya tienes cuenta?");
        lblPre.setFont(Fuentes.bold(15f));
        lblPre.setForeground(Colores.GRAFITO);

        JLabel lblRegLink = new JLabel("Iniciar Sesión");
        lblRegLink.setFont(Fuentes.bold(15f));
        lblRegLink.setForeground(Colores.AZUL_TECNOLOGICO);
        lblRegLink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pnlRegister.add(lblPre);
        pnlRegister.add(lblRegLink);

        // Ensamblado de la tarjeta
        //tarjeta.add(lblIconoUser);
        tarjeta.add(Box.createVerticalStrut(5));
        tarjeta.add(lblTituloForm);
        tarjeta.add(lblSub);
        tarjeta.add(Box.createVerticalStrut(10));
        tarjeta.add(pnlDivider);
        tarjeta.add(Box.createVerticalStrut(10));
        tarjeta.add(campoNombre);
        tarjeta.add(Box.createVerticalStrut(10));
        tarjeta.add(campoCorreo);
        tarjeta.add(Box.createVerticalStrut(10));
        tarjeta.add(campoUsuario);
        tarjeta.add(Box.createVerticalStrut(10));
        tarjeta.add(campoPass);
        tarjeta.add(Box.createVerticalStrut(10));
        tarjeta.add(campoConfPass);
        tarjeta.add(Box.createVerticalStrut(10));
        tarjeta.add(pnlTipoWrapper);
        tarjeta.add(Box.createVerticalStrut(10));
        tarjeta.add(pnlTipos);
        tarjeta.add(Box.createVerticalStrut(20));
        tarjeta.add(btnCrear);
        tarjeta.add(Box.createVerticalStrut(10));
        tarjeta.add(pnlRegister);
        contenedor.add(tarjeta);
        return contenedor;
    }

    private JPanel crearCampoTexto(
            String label,
            String placeholder,
            String rutaIcono,
            boolean esPassword) {

        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        pnl.setOpaque(false);
        pnl.setMaximumSize(new Dimension(330, 70));
        pnl.setAlignmentX(Component.CENTER_ALIGNMENT);

        // LABEL
        JPanel pnlLabel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnlLabel.setOpaque(false);

        JLabel lbl = new JLabel(label);
        lbl.setFont(Fuentes.bold(16f));
        lbl.setForeground(Colores.GRAFITO);
        pnlLabel.add(lbl);

        TextField field = new TextField(placeholder);
        field.setPreferredSize(new Dimension(290, 50));

        // Asignamos el icono directamente al TextField
        field.setIconoIzquierdo(rutaIcono);
        if (esPassword) {
            field.setIconoDerecho("imagenes/invisible.svg");

            // (Opcional) Si quieres cambiar el cursor a mano al pasar sobre el campo de contraseña
            field.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        // ENSAMBLADO DIRECTO
        pnl.add(pnlLabel);
        pnl.add(Box.createVerticalStrut(5));
        pnl.add(field);

        return pnl;
    }

    private JPanel crearCardTipoUsuario(String titulo, String desc, String rutaIcono, boolean seleccionado) {
        JPanel card = new JPanel(new BorderLayout(8, 0)) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (seleccionado) {
                    g2.setColor(new Color(230, 248, 246));
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 16, 16);
                    g2.setColor(new Color(45, 206, 178));
                    g2.setStroke(new BasicStroke(1.5f));
                    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 16, 16);
                } else {
                    g2.setColor(new Color(245, 247, 250));
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 16, 16);
                    g2.setColor(new Color(210, 215, 225));
                    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 16, 16);
                }
                g2.dispose();
            }
        };
        card.setOpaque(false);
        card.setBorder(new EmptyBorder(8, 10, 8, 10));

        JLabel lblRadio = new JLabel();
        lblRadio.setPreferredSize(new Dimension(18, 18));
        cargarImagen(lblRadio, seleccionado ? "imagenes/check.svg" : "imagenes/uncheck.svg", 16, 16);

        JLabel lblIcono = new JLabel();
        cargarImagen(lblIcono, rutaIcono, 28, 28);

        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new BoxLayout(pnlCentro, BoxLayout.Y_AXIS));
        pnlCentro.setOpaque(false);

        JLabel lblT = new JLabel(titulo);
        lblT.setFont(Fuentes.bold(14f));
        lblT.setForeground(Colores.GRAFITO);

        JLabel lblD = new JLabel("<html><center>" + desc + "</center></html>");
        lblD.setFont(Fuentes.bold(12f));
        lblD.setForeground(Colores.GRAFITO);

        pnlCentro.add(lblT);
        pnlCentro.add(lblD);

        card.add(lblRadio, BorderLayout.WEST);

        JPanel contentIconAndText = new JPanel();
        contentIconAndText.setLayout(new BoxLayout(contentIconAndText, BoxLayout.Y_AXIS));
        contentIconAndText.setOpaque(false);
        lblIcono.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlCentro.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentIconAndText.add(lblIcono);
        contentIconAndText.add(Box.createVerticalStrut(3));
        contentIconAndText.add(pnlCentro);

        card.add(contentIconAndText, BorderLayout.CENTER);
        return card;
    }

    private void cargarImagen(JLabel label, String ruta, int ancho, int alto) {
        try {
            // Validación para imágenes tradicionales (PNG/JPG)
            java.net.URL url = getClass().getClassLoader().getResource(ruta);

            // Tratamiento especial para SVG con FlatLaf
            if (ruta.toLowerCase().endsWith(".svg")) {
                // Verificar primero si el recurso existe en el classpath
                if (getClass().getClassLoader().getResource(ruta) == null) {
                    label.setIcon(null);
                    System.err.println("No se encontró el archivo SVG: " + ruta);
                    return;
                }

                // Carga directa con FlatSVGIcon usando la ruta limpia
                FlatSVGIcon icon = new FlatSVGIcon(ruta, ancho, alto);
                label.setIcon(icon);

            } else {
                // Tratamiento para PNG, JPG, etc.
                if (url == null) {
                    label.setIcon(null);
                    System.err.println("No se encontró la imagen: " + ruta);
                    return;
                }

                ImageIcon img = new ImageIcon(url);
                Image scaled = img.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(scaled));
            }

        } catch (Exception e) {
            label.setIcon(null);
            System.err.println("Error crítico al cargar imagen: " + ruta);
            e.printStackTrace();
        }
    }

    public void setLeftIcon(Icon icon) {
        this.leftIcon = icon;
        repaint();
    }

    public Icon getLeftIcon() {
        return leftIcon;
    }

}
