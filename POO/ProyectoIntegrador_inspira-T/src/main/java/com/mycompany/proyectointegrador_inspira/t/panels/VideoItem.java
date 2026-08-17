/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;
import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;
import net.miginfocom.swing.MigLayout;
/**
 *
 * @author berth
 */
public class VideoItem extends JPanel{
    //Componentes
    private JLabel lblMiniatura;
    private JLabel lblCategoria;
    private JLabel lblTitulo;
    private JLabel lblInstructor;
    private JLabel lblInfo;

    public VideoItem(String rutaMiniatura, String categoria, String instructor, String informacion) {
        construir(rutaMiniatura, categoria, instructor, informacion);
    }

    private void construir(String rutaMiniatura, String categoria, String instructor, String informacion) {
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setLayout(new MigLayout(
                "insets 5,fillx",
                "[140!][grow]",
                "[90!]"));
        // Miniatura
        lblMiniatura = new JLabel();
        lblMiniatura.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        lblMiniatura.setPreferredSize(new Dimension(130, 90));
        lblMiniatura.setMinimumSize(new Dimension(135, 90));
        lblMiniatura.setMaximumSize(new Dimension(135, 90));
        lblMiniatura.setHorizontalAlignment(SwingConstants.CENTER);
        lblMiniatura.setVerticalAlignment(SwingConstants.CENTER);
        cargarMiniatura(rutaMiniatura);
        add(lblMiniatura, "top");
        // Información
        JPanel datos = new JPanel(new MigLayout(
                "fillx,insets 0",
                "[grow]",
                "[][][][]"));
        datos.setOpaque(false);
        lblCategoria = new JLabel("<html><div style='width:145px'>" + categoria + "</div></html>");
        lblCategoria.setForeground(Colores.GRAFITO);
        lblCategoria.setFont(Fuentes.bold(13f));
        lblInstructor = new JLabel(instructor);
        lblInstructor.setFont(Fuentes.medium(13f));
        lblInstructor.setForeground(Color.GRAY);
        lblInfo = new JLabel(informacion);
        lblInfo.setFont(Fuentes.regular(12f));
        lblInfo.setForeground(Color.GRAY);
        datos.add(lblCategoria, "wrap");
        datos.add(lblInstructor, "wrap");
        datos.add(lblInfo);
        add(datos, "growx");

        // Hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblMiniatura.setBorder(crearBordeMiniatura(Colores.AZUL_TECNOLOGICO));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblMiniatura.setBorder(null);
            }
        });
    }

    private void cargarMiniatura(String rutaImagen) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(rutaImagen));
            Image img = icon.getImage().getScaledInstance(
                    135,
                    80,
                    Image.SCALE_SMOOTH);
            lblMiniatura.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            lblMiniatura.setOpaque(true);
            lblMiniatura.setBackground(new Color(235, 235, 235));
            lblMiniatura.setText("Sin imagen");
            lblMiniatura.setHorizontalAlignment(SwingConstants.CENTER);
            System.out.println("No se encontró: " + rutaImagen);
        }

    }

    private Border crearBordeMiniatura(Color color) {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color, 2, true),
                BorderFactory.createEmptyBorder(2, 2, 2, 2)
        );

    }

    // Getters
    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public JLabel getLblInstructor() {
        return lblInstructor;
    }

    public JLabel getLblCategoria() {
        return lblCategoria;
    }

    public JLabel getLblInfo() {
        return lblInfo;

    }

    public JLabel getLblMiniatura() {
        return lblMiniatura;
    }

    // Setters
    public void setTitulo(String titulo) {
        lblTitulo.setText("<html><b>" + titulo + "</b></html>");
    }

    public void setInstructor(String instructor) {
        lblInstructor.setText(instructor);
    }

    public void setCategoria(String categoria) {
        lblCategoria.setText(categoria);
    }

    public void setInformacion(String informacion) {
        lblInfo.setText(informacion);
    }

    public void setMiniatura(ImageIcon imagen) {
        lblMiniatura.setIcon(imagen);
    }
}
