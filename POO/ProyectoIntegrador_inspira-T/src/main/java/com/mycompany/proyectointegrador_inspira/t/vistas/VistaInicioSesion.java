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
public class VistaInicioSesion extends JFrame {

    private Icon leftIcon;

    public VistaInicioSesion() {
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
        gbc.weightx = 0.35;

        contenido.add(
                crearSeccionIzquierda(),
                gbc
        );

        // SECCIÓN CENTRO
        gbc.gridx = 1;
        gbc.weightx = 0.35;
        gbc.insets = new Insets(20, 10, 20, 10);

        contenido.add(
                crearSeccionCentro(),
                gbc
        );

        // SECCIÓN DERECHA
        gbc.gridx = 2;
        gbc.weightx = 0.30;
        //gbc.insets = new Insets(0, 0, 0, 0);

        contenido.add(
                crearSeccionDerecha(),
                gbc
        );

        // AGREGAR CONTENIDO ENCIMA DEL FONDO
        layeredPane.add(
                contenido,
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

                contenido.setBounds(
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
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(450, 600));

        // Imagen principal de las artesanas (bordado.png)
        JLabel lblArtesanas = new JLabel();
        lblArtesanas.setHorizontalAlignment(SwingConstants.LEFT);
        lblArtesanas.setVerticalAlignment(SwingConstants.BOTTOM);
        cargarImagen(lblArtesanas, "imagenes/imgInicioSesion.svg", 450, 650);

        panel.add(lblArtesanas, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearSeccionCentro() {
        JPanel contenedor = new JPanel(new GridBagLayout());
        contenedor.setOpaque(false);

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
        tarjeta.setBorder(new EmptyBorder(30, 0, 30, 0));
        tarjeta.setPreferredSize(new Dimension(410, 610));

        JLabel lblLogo = new JLabel();
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        cargarImagen(lblLogo, "imagenes/logoSlogan.svg", 225, 170);

        JPanel campoCorreo = crearCampoTexto("Correo electronico", "Ingresa tu correo electrónico", "imagenes/mail.svg", false);
        JPanel campoPass = crearCampoTexto("Contraseña", "Ingresa tu contraseña", "imagenes/lock.svg", true);

        // --- Enlace "¿Olvidaste tu contraseña?" ---
        JPanel pnlOlvidaste = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        pnlOlvidaste.setOpaque(false);
        pnlOlvidaste.setMaximumSize(new Dimension(330, 20));

        JLabel lblOlvidaste = new JLabel("¿Olvidaste tu contraseña?");
        lblOlvidaste.setFont(Fuentes.bold(14f));
        lblOlvidaste.setForeground(Colores.AZUL_TECNOLOGICO);
        lblOlvidaste.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlOlvidaste.add(lblOlvidaste);

        BotonRedondeado btnLogin = new BotonRedondeado("Iniciar sesión", Colores.AZUL_TECNOLOGICO);
        com.formdev.flatlaf.extras.FlatSVGIcon iconoBoton = new com.formdev.flatlaf.extras.FlatSVGIcon("imagenes/person.svg", 25, 25);
        iconoBoton.setColorFilter(new com.formdev.flatlaf.extras.FlatSVGIcon.ColorFilter(color -> Color.WHITE));
        btnLogin.setIcon(iconoBoton);
        btnLogin.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnLogin.setIconTextGap(10);

        btnLogin.setFont(Fuentes.bold(16f));
        btnLogin.setColorTexto(Colores.BLANCO);
        btnLogin.setMaximumSize(new Dimension(330, 44));
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.setColorBorde(Colores.AZUL_TECNOLOGICO);

        JPanel pnlRegister = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 0));
        pnlRegister.setOpaque(false);

        JLabel lblPre = new JLabel("¿No tienes cuenta?");
        lblPre.setFont(Fuentes.bold(15f));
        lblPre.setForeground(Colores.GRAFITO);

        JLabel lblRegLink = new JLabel("Registrate aquí");
        lblRegLink.setFont(Fuentes.bold(15f));
        lblRegLink.setForeground(Colores.AZUL_TECNOLOGICO);
        lblRegLink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pnlRegister.add(lblPre);
        pnlRegister.add(lblRegLink);

        // Ensamblado de la tarjeta
        tarjeta.add(lblLogo);
        tarjeta.add(Box.createVerticalStrut(5));
        tarjeta.add(Box.createVerticalStrut(25));
        tarjeta.add(campoCorreo);
        tarjeta.add(Box.createVerticalStrut(20));
        tarjeta.add(campoPass);
        tarjeta.add(Box.createVerticalStrut(15));
        tarjeta.add(pnlOlvidaste);
        tarjeta.add(Box.createVerticalStrut(20));
        tarjeta.add(btnLogin);
        tarjeta.add(Box.createVerticalStrut(30));
        tarjeta.add(pnlRegister);

        contenedor.add(tarjeta);
        return contenedor;
    }

    private JPanel crearSeccionDerecha() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(250, 600));

        panel.add(Box.createVerticalGlue());

        // Flor icono
        JLabel lblFlor = new JLabel();
        lblFlor.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblFlor.setHorizontalAlignment(SwingConstants.CENTER);

        //cargarImagen(lblFlor, "imagenes/flor.svg", 70, 70);
        panel.add(lblFlor);

        panel.add(Box.createVerticalStrut(30));

        // Frase 1
        /**JLabel lblTexto1 = new JLabel("<html><center>Aprende de nuestros<br>guardianes del conocimiento.</center></html>");
        lblTexto1.setFont(Fuentes.regular(18f));
        lblTexto1.setForeground(Colores.GRAFITO);
        lblTexto1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblTexto1);

        panel.add(Box.createVerticalStrut(30));

        // Frase 2 (Itálica)
        JLabel lblTexto2 = new JLabel("<html><center>Hoy sus saberes, mañana<br>nuestro futuro.</center></html>");
        lblTexto2.setFont(Fuentes.italic(18f));
        lblTexto2.setForeground(Colores.AZUL_CONFIANZA);
        lblTexto2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblTexto2);

        panel.add(Box.createVerticalGlue());**/

        return panel;
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
