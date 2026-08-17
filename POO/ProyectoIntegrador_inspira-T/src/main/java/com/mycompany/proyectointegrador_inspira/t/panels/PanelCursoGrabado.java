/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import javax.swing.*;
import java.awt.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.io.File;
import javax.swing.Icon;
import net.miginfocom.swing.MigLayout;
import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
//import com.mycompany.proyectointegrador_inspira.t.panels.PanelTarjeta;
import com.mycompany.proyectointegrador_inspira.t.componentes.JTextAreaRedondeado;
import com.mycompany.proyectointegrador_inspira.t.componentes.TextField;
import com.mycompany.proyectointegrador_inspira.t.componentes.BotonRedondeado;
import com.mycompany.proyectointegrador_inspira.t.componentes.CustomComboBox;
import com.mycompany.proyectointegrador_inspira.t.componentes.ImageDropZone;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author berth
 */
public class PanelCursoGrabado extends JPanel {

    private CustomComboBox<String> cbCategoria;
    private CustomComboBox<String> cbIdioma;
    private CustomComboBox<String> cbNivel;
    private ImageDropZone dropZone;
    private JCheckBox chkComentarios;
    private BotonRedondeado btnSelectFile;

    public PanelCursoGrabado() {

        setOpaque(false);
        setLayout(new MigLayout(
                "fillx,insets 0",
                "[grow,fill]",
                "[]20[]20[]"
        ));
        add(crearPanelSubida(), "growx,wrap");
        add(crearPanelInformacion(), "growx,wrap");
        add(crearPanelDetalles(), "growx");
    }

    // SUBIR VIDEO
    private JPanel crearPanelSubida() {
        PanelTarjeta card = new PanelTarjeta();
        card.setLayout(new MigLayout(
                "fillx,insets 5",
                "[grow,center]",
                "[]3[]3[]5[]"));
        card.setPreferredSize(new Dimension(300, 250));

        //dropZone=new ImageDropZone();
        //add(dropZone, "grow,pushx,h 250!,wrap");
        FlatSVGIcon svgIcon = new FlatSVGIcon("imagenes/upload.svg", 70, 70);
        Color miColor = new Color(46, 52, 64);
        svgIcon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> miColor));
        JLabel icono = new JLabel(svgIcon);

        JLabel titulo = new JLabel("Arrastra y suelta tu video aquí");
        titulo.setFont(Fuentes.bold(18f));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel o = new JLabel("o");
        o.setHorizontalAlignment(SwingConstants.CENTER);
        o.setFont(Fuentes.medium(18f));

        btnSelectFile = new BotonRedondeado("Seleccionar archivo", Colores.AZUL_TECNOLOGICO);

        btnSelectFile.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();

                javax.swing.filechooser.FileNameExtensionFilter filtro
                        = new javax.swing.filechooser.FileNameExtensionFilter("Videos (MP4, MOV, AVI)", "mp4", "mov", "avi");
                fileChooser.setFileFilter(filtro);
                int resultado = fileChooser.showOpenDialog(null);

                // Comprobar si el usuario seleccionó un archivo
                if (resultado == javax.swing.JFileChooser.APPROVE_OPTION) {
                    java.io.File archivoSeleccionado = fileChooser.getSelectedFile();
                    if (validarArchivo(archivoSeleccionado)) {
                        procesarVideo(archivoSeleccionado);
                    }
                    //String ruta = archivoSeleccionado.getAbsolutePath();//Obtiene la ruta del archivo
                    //System.out.println("Archivo seleccionado: " + ruta);
                }
            }
        });
        //btnSelectFile.addActionListener(e->dropZone.abrirSelector());
        //int btnAncho = 260;
        //int btnAlto = 40;
        //btnSelectFile.setSize(btnAncho, btnAlto);

        // --- CONFIGURACIÓN DE REACCIÓN VISUAL AL ARRASTRAR (DRAG & DROP) ---
        // Guardar borde original para poder restaurarlo cuando el archivo se mueva o se suelte
        final javax.swing.border.Border bordeOriginal = card.getBorder();
        // Crear borde destacado
        final javax.swing.border.Border bordeDestacado = javax.swing.BorderFactory.createLineBorder(Colores.GRAFITO, 5, true);
        new java.awt.dnd.DropTarget(card, new java.awt.dnd.DropTargetListener() {
            @Override
            public void dragEnter(java.awt.dnd.DropTargetDragEvent dtde) {
                // Verificar si lo que arrastran es un archivo válido antes de pintar el borde
                if (dtde.isDataFlavorSupported(java.awt.datatransfer.DataFlavor.javaFileListFlavor)) {
                    card.setBorder(bordeDestacado);
                    card.repaint();
                } else {
                    dtde.rejectDrag();
                }
            }

            @Override
            public void dragOver(java.awt.dnd.DropTargetDragEvent dtde) {
                //Ejecución mientras se mueve el cursor dentro del panel
            }

            @Override
            public void dropActionChanged(java.awt.dnd.DropTargetDragEvent dtde) {
            }

            @Override
            public void dragExit(java.awt.dnd.DropTargetEvent dte) {
                //Regresar al diseño original cuando el usuario saca el archivo del panel
                card.setBorder(bordeOriginal);
                card.repaint();
            }

            @Override
            public void drop(java.awt.dnd.DropTargetDropEvent dtde) {
                // Volver al borde normal inmediatamente al soltar
                card.setBorder(bordeOriginal);
                card.repaint();

                try {
                    if (dtde.isDataFlavorSupported(java.awt.datatransfer.DataFlavor.javaFileListFlavor)) {
                        dtde.acceptDrop(java.awt.dnd.DnDConstants.ACTION_COPY);

                        java.util.List<?> archivos = (java.util.List<?>) dtde.getTransferable()
                                .getTransferData(java.awt.datatransfer.DataFlavor.javaFileListFlavor);

                        if (archivos != null && !archivos.isEmpty()) {
                            java.io.File archivoArrastrado = (java.io.File) archivos.get(0);

                            // Invoca tus métodos de validación ya creados
                            if (validarArchivo(archivoArrastrado)) {
                                procesarVideo(archivoArrastrado);
                                dtde.dropComplete(true);
                                return;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dtde.dropComplete(false);
            }
        });

        JPanel boton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        boton.setOpaque(false);
        boton.add(btnSelectFile);

        JLabel formatos = new JLabel("Formatos: MP4, MOV, AVI     Máx. 5GB");
        formatos.setHorizontalAlignment(SwingConstants.CENTER);
        formatos.setFont(Fuentes.regular(18f));
        card.add(icono, "growx,wrap");
        card.add(titulo, "growx,wrap");
        card.add(o, "growx,wrap");
        card.add(boton, "growx,wrap");
        card.add(formatos, "growx");

        return card;
    }

    private boolean validarArchivo(java.io.File archivo) {
        String nombre = archivo.getName().toLowerCase();

        //Validar Extensión
        if (!nombre.endsWith(".mp4") && !nombre.endsWith(".mov") && !nombre.endsWith(".avi")) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Formato no permitido. Solo se aceptan videos MP4, MOV o AVI.",
                    "Error de Formato!", javax.swing.JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Validar Tamaño (5 GB en bytes)
        long maxBytes = 5L * 1024L * 1024L * 1024L;
        if (archivo.length() > maxBytes) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "El archivo excede el límite de 5GB.",
                    "Archivo muy grande", javax.swing.JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void procesarVideo(java.io.File video) {
        System.out.println("Video aceptado listo para usar: " + video.getAbsolutePath());
        //Lógica para reproducir o subir el video
    }

    // INFORMACIÓN
    private JPanel crearPanelInformacion() {
        PanelTarjeta card = new PanelTarjeta();
        card.setLayout(new MigLayout(
                "fillx,insets 5",
                "[grow,fill][grow,fill]",
                "[]5[][]5[]5[]"));
        card.setPreferredSize(new Dimension(300, 250));
        JLabel titulo = new JLabel("Información del video");
        titulo.setFont(Fuentes.bold(18f));

        card.add(titulo, "span 2,wrap");
        card.add(crearLabel("Título del video*"));
        card.add(crearLabel("Categoría*"), "wrap");

        TextField txtTitulo = new TextField("Introduce un título atractivo y descriptivo");
        txtTitulo.setRadius(22);

        cbCategoria = new CustomComboBox<>();
        cbCategoria.addItem("Selecciona una categoría");
        cbCategoria.addItem("Agricultura");
        cbCategoria.addItem("Artesanías");
        cbCategoria.addItem("Gastronomía");
        cbCategoria.addItem("Lenguas");
        cbCategoria.addItem("Medicina tradicional");
        card.add(txtTitulo, "growx,h 40!");
        card.add(cbCategoria, "growx,h 40!,wrap");

        card.add(crearLabel("Descripción*"));
        card.add(crearLabel("Etiquetas"), "wrap");

        JTextArea jDescripcion = new JTextArea(2, 20);
        jDescripcion.setLineWrap(true);
        jDescripcion.setWrapStyleWord(true);
        jDescripcion.setOpaque(false);
        JScrollPane spDescripcion = new JScrollPane(jDescripcion);
        spDescripcion.setBorder(new JTextAreaRedondeado(15, new Color(210, 210, 210)));

        spDescripcion.getViewport().setOpaque(false);
        spDescripcion.setOpaque(false);
        TextField txtEtiquetas = new TextField("Ej. medicina, herbolaria");
        txtEtiquetas.setRadius(22);
        card.add(spDescripcion, "growx,h 70!");

        JPanel etiquetas = new JPanel(new MigLayout(
                "fillx,insets 0",
                "[grow]",
                "[][]"));

        etiquetas.setOpaque(false);
        etiquetas.add(txtEtiquetas, "growx,wrap");
        JLabel ayuda = new JLabel("Separa las etiquetas con comas");
        ayuda.setForeground(Colores.MORADO);
        etiquetas.add(ayuda);
        card.add(etiquetas, "growx,top");
        return card;
    }

    // DETALLES
    private JPanel crearPanelDetalles() {
        PanelTarjeta card = new PanelTarjeta();

        card.setLayout(new MigLayout(
                "fillx, insets 1",
                "[0:pref:50%, grow, sg 3][0:pref:50%, grow, sg 1]",
                "[]5[]5[]"
        ));
        card.setPreferredSize(new Dimension(300, 220));
        JLabel titulo = new JLabel("Detalles adicionales");
        titulo.setFont(Fuentes.bold(18f));
        card.add(titulo, "span 2,wrap");
        card.add(crearLabel("Idioma del video"));
        card.add(crearLabel("Público objetivo"), "wrap");

        cbIdioma = new CustomComboBox<>();
        cbIdioma.addItem("Selecciona el idioma");
        cbIdioma.addItem("Español");
        cbIdioma.addItem("Náhuatl");
        cbIdioma.addItem("Totonaco");
        TextField txtPublico = new TextField("¿A quién va dirigido este contenido?");
        txtPublico.setRadius(22);
        card.add(cbIdioma, "growx,pushx,w 0:n:n,h 40!");
        card.add(txtPublico, "growx,pushx,w 0:n:n,h 40!,wrap");
        card.add(crearLabel("Nivel de dificultad"));
        card.add(crearLabel("Permitir comentarios"), "wrap");
        cbNivel = new CustomComboBox<>();
        cbNivel.addItem("Selecciona el nivel");
        cbNivel.addItem("Principiante");
        cbNivel.addItem("Intermedio");
        cbNivel.addItem("Avanzado");

        chkComentarios = new JCheckBox("<html>Los alumnos podrán comentar y hacer preguntas</html>");
        chkComentarios.setOpaque(false);
        chkComentarios.setFont(Fuentes.regular(15f));

        // 2. Asignar la píldora personalizada
        chkComentarios.setIcon(new SwitchIcon(false));        // Estado apagado
        chkComentarios.setSelectedIcon(new SwitchIcon(true)); // Estado encendido

        chkComentarios.setIconTextGap(12); // Distancia entre el texto y el interruptor
        chkComentarios.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        chkComentarios.setHorizontalTextPosition(SwingConstants.LEFT);

        card.add(cbNivel, "growx,pushx,w 0:n:n,top");
        card.add(chkComentarios, "growx,pushx,w 0:n:n,top");
        return card;
    }

    private JLabel crearLabel(String texto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(Fuentes.bold(16f));
        lbl.setForeground(Colores.GRAFITO);
        return lbl;
    }

    private static class SwitchIcon implements Icon {

        private final boolean seleccionado;
        private final Color colorFondoOn = Colores.TURQUESA;
        private final Color colorFondoOff = new Color(220, 224, 230);
        private final Color colorBolaOff = Colores.GRAFITO;

        public SwitchIcon(boolean seleccionado) {
            this.seleccionado = seleccionado;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Dimensiones del switch (Píldora)
            int anchoPildora = 34;
            int altoPildora = 20;
            int diametroBola = 14;

            // Centrar verticalmente el icono respecto al texto
            int verticalOffset = y + ((getIconHeight() - altoPildora) / 2);

            // 1. Dibujar el cuerpo de la píldora (Fondo)
            if (seleccionado) {
                g2.setColor(colorFondoOn);
            } else {
                g2.setColor(colorFondoOff);
            }
            g2.fillRoundRect(x, verticalOffset, anchoPildora, altoPildora, altoPildora, altoPildora);

            // 2. Calcular posición y dibujar la bola deslizante interna
            int posicionBolaX;
            if (seleccionado) {
                // Lado derecho (Encendido)
                posicionBolaX = x + anchoPildora - diametroBola - 3;
                g2.setColor(Color.WHITE);
            } else {
                // Lado izquierdo (Apagado)
                posicionBolaX = x + 3;
                g2.setColor(colorBolaOff);
            }

            int posicionBolaY = verticalOffset + ((altoPildora - diametroBola) / 2);
            g2.fillOval(posicionBolaX, posicionBolaY, diametroBola, diametroBola);

            g2.dispose();
        }

        @Override
        public int getIconWidth() {
            return 40; // Espacio total horizontal reservado para el icono
        }

        @Override
        public int getIconHeight() {
            return 24; // Espacio total vertical reservado
        }
    }

    public File getArchivoSeleccionado() {
        return dropZone.getImagenSeleccionada();
    }
}
