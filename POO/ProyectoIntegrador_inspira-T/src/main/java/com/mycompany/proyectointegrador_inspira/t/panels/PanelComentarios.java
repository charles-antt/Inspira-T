/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
import com.mycompany.proyectointegrador_inspira.t.util.Iconos;
import com.mycompany.proyectointegrador_inspira.t.componentes.BotonRedondeado;
import com.mycompany.proyectointegrador_inspira.t.componentes.JTextAreaRedondeado;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author berth
 */
public class PanelComentarios extends JPanel {

    //Componentes
    private JLabel lblTitulo;
    private JLabel foto;
    private JTextArea txtComentario;
    private BotonRedondeado btnComentar;
    private JPanel panelLista;
    private JButton btnMostrarMas;

    public PanelComentarios() {
        construir();
    }

    private void construir() {
        setOpaque(false);
        setLayout(new MigLayout(
                "fillx,insets 0",
                "[grow]",
                "[][]5[]5[]"));
        // Título
        lblTitulo = new JLabel("Comentarios (10)");
        lblTitulo.setFont(Fuentes.bold(22f));
        lblTitulo.setForeground(Colores.GRAFITO);
        add(lblTitulo, "wrap");

        // Nuevo comentario
        add(crearCajaComentario(), "growx,wrap");

        // Lista
        panelLista = new JPanel();
        panelLista.setOpaque(false);
        panelLista.setLayout(new BoxLayout(
                panelLista,
                BoxLayout.Y_AXIS));
        panelLista.add(new ComentarioItem(
                "María Hernández",
                "Excelente explicación. Aprendí una técnica que mi abuela utilizaba."));
        panelLista.add(Box.createVerticalStrut(3));
        panelLista.add(new ComentarioItem(
                "José López",
                "Muchas gracias por compartir este conocimiento."));
        panelLista.add(Box.createVerticalStrut(3));
        panelLista.add(new ComentarioItem(
                "Ana Ruiz",
                "¿Habrá una segunda parte del curso?"));
        add(panelLista, "growx,wrap");

        // Mostrar más
        btnMostrarMas = new JButton("Mostrar más comentarios");
        btnMostrarMas.setBorderPainted(false);
        btnMostrarMas.setContentAreaFilled(false);
        btnMostrarMas.setFocusPainted(false);
        btnMostrarMas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMostrarMas.setForeground(Colores.MORADO);
        btnMostrarMas.setFont(Fuentes.medium(15f));
        add(btnMostrarMas, "center");
    }

    // Caja nuevo comentario
    private JPanel crearCajaComentario() {
        JPanel panel = new JPanel(new BorderLayout(12, 0));
        panel.setOpaque(false);
        foto = new JLabel();
        foto.setIcon(Iconos.cargar(Iconos.USER, 40, Colores.GRAFITO));
        JTextArea txtComentario = new JTextArea(1, 20);
        //txtComentario = new JTextArea(3,20);
        txtComentario.setLineWrap(true);
        txtComentario.setWrapStyleWord(true);
        txtComentario.setOpaque(false);
        //txtComentario.setFont(Fuentes.regular(15f));
        JScrollPane spComentario = new JScrollPane(txtComentario);
        spComentario.setBorder(new JTextAreaRedondeado(22, new Color(210, 210, 210)));
        spComentario.getViewport().setOpaque(false);
        spComentario.setOpaque(false);
        //btnComentar = new BotonRedondeado("Comentar",Colores.AZUL_TECNOLOGICO);
        //btnComentar.setPreferredSize(new Dimension(120,42));

        panel.add(foto, BorderLayout.WEST);
        panel.add(spComentario, BorderLayout.CENTER);
        //panel.add(btnComentar, BorderLayout.EAST);
        return panel;
    }

    // API
    public void agregarComentario(ComentarioItem comentario) {
        panelLista.add(Box.createVerticalStrut(12));
        panelLista.add(comentario);
        panelLista.revalidate();
        panelLista.repaint();
    }

    public JTextArea getTxtComentario() {
        return txtComentario;
    }

    public BotonRedondeado getBtnComentar() {
        return btnComentar;
    }

    public JButton getBtnMostrarMas() {
        return btnMostrarMas;
    }
}
