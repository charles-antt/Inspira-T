/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.util.List;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
import com.mycompany.proyectointegrador_inspira.t.imagen.ImagenEscalable;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author berth
 */
public class ImageDropZone extends JPanel {

    //Componentes
    private JLabel preview;
    private JLabel lblTexto;
    private File imagenSeleccionada;
    private Image imagenOriginal;
    private boolean arrastrandoArchivo = false;
    private java.awt.image.BufferedImage imagenMiniatura = null;

    public void abrirSelector(javax.swing.filechooser.FileNameExtensionFilter filtro) {
        seleccionarImagen(filtro);
    }

    public ImageDropZone() {
        this.setOpaque(false);
        this.setBackground(Colores.BLANCO);
        final javax.swing.border.Border bordeOriginal = javax.swing.BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true);
        //Borde destacado
        final javax.swing.border.Border bordeDestacado = javax.swing.BorderFactory.createLineBorder(Colores.GRAFITO, 5, true);
        this.setBorder(null);
        this.setOpaque(false);
        new java.awt.dnd.DropTarget(this, new java.awt.dnd.DropTargetListener() {
            @Override
            public void dragEnter(java.awt.dnd.DropTargetDragEvent dtde) {
                // Validar en tiempo real si lo que se seostiene sobre la zona es un archivo
                if (dtde.isDataFlavorSupported(java.awt.datatransfer.DataFlavor.javaFileListFlavor)) {
                    //setBorder(bordeDestacado);
                    arrastrandoArchivo = true;
                    repaint();
                } else {
                    dtde.rejectDrag();
                }
            }

            @Override
            public void dragExit(java.awt.dnd.DropTargetEvent dte) {
                // Volver al diseño original si el usuario saca el archivo sin soltarlo
                //setBorder(bordeOriginal);
                arrastrandoArchivo = false;
                repaint();
            }

            @Override
            public void drop(java.awt.dnd.DropTargetDropEvent dtde) {
                // Restaurar el diseño original inmediatamente al soltar
                //setBorder(bordeOriginal);
                arrastrandoArchivo = false;
                repaint();

                try {
                    if (dtde.isDataFlavorSupported(java.awt.datatransfer.DataFlavor.javaFileListFlavor)) {
                        dtde.acceptDrop(java.awt.dnd.DnDConstants.ACTION_COPY);
                        // Extraer los archivos soltados
                        java.util.List<?> archivos = (java.util.List<?>) dtde.getTransferable()
                                .getTransferData(java.awt.datatransfer.DataFlavor.javaFileListFlavor);
                        if (archivos != null && !archivos.isEmpty()) {
                            java.io.File archivoArrastrado = (java.io.File) archivos.get(0);

                            // Reutilizar filtro del paso anterior
                            if (validarSiEsImagen(archivoArrastrado)) {
                                //Lógica de carga
                                cargarImagen(archivoArrastrado);
                                System.out.println("Miniatura aceptada via Drag&Drop: " + archivoArrastrado.getName());
                                dtde.dropComplete(true);
                                return;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dtde.dropComplete(false); // Cancelar la acción si algo falla o no es válido
            }

            @Override
            public void dragOver(java.awt.dnd.DropTargetDragEvent dtde) {
            }

            @Override
            public void dropActionChanged(java.awt.dnd.DropTargetDragEvent dtde) {
            }
        });
    }

    private void construir() {
        setOpaque(false);
        setMinimumSize(new Dimension(0, 0));
        //setPreferredSize(new Dimension(300, 180));
        Dimension d = new Dimension(320, 190);

        setPreferredSize(d);

        setMinimumSize(d);

        setMaximumSize(new Dimension(
                Integer.MAX_VALUE,
                190));
        setLayout(new GridBagLayout());
        preview = new JLabel();
        preview.setHorizontalAlignment(SwingConstants.CENTER);
        preview.setVerticalAlignment(SwingConstants.CENTER);
        preview.setLayout(new BorderLayout());

        lblTexto = new JLabel(
                "<html><center>"
                + "<h2>📷</h2>"
                + "<b>Arrastra una imagen aquí</b><br>"
                + "o haz clic para seleccionarla"
                + "</center></html>");
        lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
        lblTexto.setFont(Fuentes.medium(16f));
        lblTexto.setForeground(Colores.GRAFITO);
        preview.add(lblTexto, BorderLayout.CENTER);
        add(preview);

        /**
         * addMouseListener(new java.awt.event.MouseAdapter() {
         *
         * @Override public void mouseClicked(java.awt.event.MouseEvent e) {
         * seleccionarImagen(); } });*
         */
    }

    private void habilitarDragAndDrop() {

        new DropTarget(this, new DropTargetAdapter() {

            @Override
            public void drop(DropTargetDropEvent dtde) {

                try {

                    dtde.acceptDrop(DnDConstants.ACTION_COPY);

                    List<File> files
                            = (List<File>) dtde.getTransferable()
                                    .getTransferData(
                                            DataFlavor.javaFileListFlavor);

                    if (!files.isEmpty()) {

                        cargarImagen(files.get(0));

                    }

                } catch (Exception ex) {

                    ex.printStackTrace();

                }

            }

        });

    }

    private void seleccionarImagen(javax.swing.filechooser.FileNameExtensionFilter filtro) {
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();

        // Aplicamos el filtro recibido para que solo muestre imágenes
        fileChooser.setFileFilter(filtro);

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File archivoSeleccionado = fileChooser.getSelectedFile();

            // Validamos por seguridad la extensión antes de procesarla
            if (validarSiEsImagen(archivoSeleccionado)) {
                // Aquí pones tu lógica original para cargar la imagen en el dropZone
                System.out.println("Imagen aceptada: " + archivoSeleccionado.getAbsolutePath());
                // Ejemplo: mostrarImagen(archivoSeleccionado);
            }
        }
    }

    private boolean validarSiEsImagen(java.io.File archivo) {
        String nombre = archivo.getName().toLowerCase();
        if (nombre.endsWith(".jpg") || nombre.endsWith(".jpeg")
                || nombre.endsWith(".png") || nombre.endsWith(".gif") || nombre.endsWith(".webp")) {
            return true;
        }

        javax.swing.JOptionPane.showMessageDialog(this,
                "Archivo no válido. Por favor, selecciona una imagen (JPG, PNG, GIF, WEBP).",
                "Formato Incorrecto",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public boolean validarImagen(java.io.File archivo) {
        String nombre = archivo.getName().toLowerCase();

        // Verificar extensiones de imagen válidas
        if (nombre.endsWith(".jpg") || nombre.endsWith(".jpeg")
                || nombre.endsWith(".png") || nombre.endsWith(".gif") || nombre.endsWith(".webp")) {
            return true;
        }

        // Si no es una imagen, mostrar mensaje de error
        javax.swing.JOptionPane.showMessageDialog(null,
                "Archivo no válido. Por favor, selecciona una imagen (JPG, PNG, GIF, WEBP).",
                "Formato Incorrecto",
                javax.swing.JOptionPane.ERROR_MESSAGE);

        return false;
    }

    private void cargarImagen(File file) {
        imagenSeleccionada = file;
        ImageIcon icon = new ImageIcon(file.getAbsolutePath());
        Image img = icon.getImage();

        imagenOriginal = icon.getImage();
        actualizarEscala();
        /**
         * Image escala= img.getScaledInstance( getWidth() - 20, getHeight() -
         * 20, Image.SCALE_SMOOTH);*
         */
        int w = preview.getWidth();
        int h = preview.getHeight();

        if (w <= 0) {
            w = 280;
        }
        if (h <= 0) {
            h = 160;
        }

        preview.removeAll();

        //preview.setIcon(new ImageIcon(escala));
        double proporcion
                = (double) img.getWidth(null)
                / img.getHeight(null);

        int nuevoW = w;
        int nuevoH = (int) (w / proporcion);

        if (nuevoH > h) {
            nuevoH = h;
            nuevoW = (int) (h * proporcion);
        }

        Image escala = img.getScaledInstance(
                nuevoW,
                nuevoH,
                Image.SCALE_SMOOTH);

        preview.revalidate();
        preview.repaint();
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Activar Antialiasing para que las curvas se vean suaves y sin pixelar
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        int ancho = getWidth();
        int alto = getHeight();
        int radioEsquina = 20;

        //Fondo blanco redondeado
        g2d.setColor(java.awt.Color.WHITE);
        g2d.fillRoundRect(0, 0, ancho, alto, radioEsquina, radioEsquina);

        //Si hay una miniatura cargada, recortar el lienzo y dibujarla
        if (imagenMiniatura != null) {
            //área de recorte redondeada para que la imagen no se salga de las esquinas
            g2d.setClip(new java.awt.geom.RoundRectangle2D.Float(0, 0, ancho, alto, radioEsquina, radioEsquina));

            int imgAncho = imagenMiniatura.getWidth();
            int imgAlto = imagenMiniatura.getHeight();

            double escalaAncho = (double) ancho / imgAncho;
            double escalaAlto = (double) alto / imgAlto;
            double escalaFinal = Math.min(escalaAncho, escalaAlto);

            int nuevoAncho = (int) (imgAncho * escalaFinal);
            int nuevoAlto = (int) (imgAlto * escalaFinal);

            // Centrar la imagen en el panel
            int x = (ancho - nuevoAncho) / 2;
            int y = (alto - nuevoAlto) / 2;

            g2d.drawImage(imagenMiniatura, x, y, nuevoAncho, nuevoAlto, null);
            g2d.setClip(null);
        }
        if (arrastrandoArchivo) {
            g2d.setColor(new java.awt.Color(46, 52, 64)); // Borde destacado oscuro
            g2d.setStroke(new java.awt.BasicStroke(2f)); // Grosor de 2 píxeles
            // Restamos 1 pixel en ancho y alto para que la línea no se corte en los bordes del panel
            g2d.drawRoundRect(1, 1, ancho - 2, alto - 2, radioEsquina, radioEsquina);
        } else {
            g2d.setColor(new java.awt.Color(204, 204, 204)); // Borde gris original
            g2d.setStroke(new java.awt.BasicStroke(1f)); // Grosor de 1 píxel
            g2d.drawRoundRect(0, 0, ancho - 1, alto - 1, radioEsquina, radioEsquina);
        }
        g2d.dispose();
    }

    public File getImagenSeleccionada() {
        return imagenSeleccionada;
    }

    private void actualizarEscala() {
        if (imagenOriginal == null) {
            return;
        }

        addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {

                actualizarEscala();

            }

        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(320, 190);
    }
}
