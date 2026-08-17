/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
import com.mycompany.proyectointegrador_inspira.t.util.Iconos;
import com.mycompany.proyectointegrador_inspira.t.componentes.JTextAreaRedondeado;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author berth
 */
public class ComentarioItem extends JPanel {

    //Componentes
    private JLabel lblFoto;
    private JLabel lblNombre;
    private JLabel lblTiempo;
    private JLabel lblComentario;
    private JButton btnLike;
    private JButton btnResponder;
    private JLabel lblLikes;

    public ComentarioItem(String nombre, String comentario) {
        construir(nombre, comentario);
    }

    private void construir(String nombre, String comentario) {
        setOpaque(false);
        setBorder(new EmptyBorder(1, 0, 1, 0));
        setLayout(new MigLayout(
                "fillx,insets 0",
                "[]5[grow]",
                "[][]"));

        // Foto
        lblFoto = new JLabel();
        lblFoto.setPreferredSize(new Dimension(48, 48));
        try {
            lblFoto.setIcon(Iconos.cargar(Iconos.USER, 40, Colores.GRAFITO));
        } catch (Exception ex) {
            lblFoto.setText("👤");
            lblFoto.setFont(Fuentes.regular(28));
        }
        add(lblFoto, "top");

        // Contenido
        JPanel contenido = new JPanel(new MigLayout(
                "fillx,insets 0",
                "[grow]",
                "[][][]"));
        contenido.setOpaque(false);

        // Encabezado
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setOpaque(false);
        lblNombre = new JLabel(nombre);
        lblNombre.setFont(Fuentes.bold(15f));
        lblNombre.setForeground(Colores.GRAFITO);
        //lblTiempo = new JLabel(tiempo);
        //lblTiempo.setFont(Fuentes.regular(13f));
        //lblTiempo.setForeground(Color.GRAY);
        encabezado.add(lblNombre, BorderLayout.WEST);
        //encabezado.add(lblTiempo, BorderLayout.EAST);
        contenido.add(encabezado, "growx,wrap");

        // Comentario
        JPanel comment = new JPanel(new BorderLayout());
        comment.setOpaque(false);
        lblComentario = new JLabel(comentario);
        lblComentario.setFont(Fuentes.regular(13f));
        lblComentario.setForeground(Colores.GRAFITO);
        comment.add(lblComentario, BorderLayout.WEST);
        contenido.add(comment, "growx,wrap");
        /**
         * JTextArea txtComentario = new JTextArea(4,20);
         * txtComentario.setLineWrap(true);
         * txtComentario.setWrapStyleWord(true); txtComentario.setOpaque(false);
         * JScrollPane spComentario = new JScrollPane(txtComentario);
         * spComentario.setBorder(new JTextAreaRedondeado(22,new
         * Color(210,210,210))); spComentario.setPreferredSize(new
         * Dimension(0,75)); spComentario.getViewport().setOpaque(false);
         * spComentario.setOpaque(false); contenido.add(spComentario, "growx,h 75!");*
         */
        /**
         * txtComentario = new JTextArea(comentario);
         * txtComentario.setEditable(false); txtComentario.setBorder(null);
         * txtComentario.setFocusable(false);
         * txtComentario.setFont(Fuentes.regular(15f));
         * txtComentario.setForeground(Colores.GRAFITO);
        *
         */

        // Acciones
        /**
         * JPanel acciones = new JPanel(new FlowLayout( FlowLayout.LEFT, 15,
         * 0)); acciones.setOpaque(false); btnLike = crearBotonIcono(
         * "/imagenes/like.svg", "Me gusta"); lblLikes = new JLabel("0");
         * lblLikes.setFont(Fuentes.medium(14f)); btnResponder =
         * crearBotonTexto("Responder"); acciones.add(btnLike);
         * acciones.add(lblLikes); acciones.add(btnResponder);
        contenido.add(acciones);*
         */
        add(contenido, "growx");
    }

    // Botón con icono
    private JButton crearBotonIcono(String icono, String tooltip) {
        JButton boton = new JButton();
        try {
            boton.setIcon(new FlatSVGIcon(icono, 18, 18));
        } catch (Exception ex) {
            boton.setText("👍");
        }
        boton.setToolTipText(tooltip);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        boton.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR));
        return boton;
    }

    // Botón texto
    private JButton crearBotonTexto(String texto) {
        JButton boton = new JButton(texto);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        boton.setForeground(Colores.MORADO);
        boton.setFont(Fuentes.medium(14f));
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return boton;
    }

    // Getters
    public JButton getBtnLike() {
        return btnLike;
    }

    public JButton getBtnResponder() {
        return btnResponder;
    }

    public JLabel getLblLikes() {
        return lblLikes;
    }

    // Setters
    public void setNombre(String nombre) {
        lblNombre.setText(nombre);
    }

    public void setComentario(String comentario) {
        lblComentario.setText(comentario);
    }

    public void setTiempo(String tiempo) {
        lblTiempo.setText(tiempo);
    }

    public void setLikes(int likes) {
        lblLikes.setText(String.valueOf(likes));
    }
}
