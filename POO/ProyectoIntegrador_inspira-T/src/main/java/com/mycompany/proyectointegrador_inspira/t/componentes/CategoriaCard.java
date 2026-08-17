/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author berth
 */
public class CategoriaCard extends JPanel{
    // Componentes
    private JLabel lblImagen;
    private JLabel lblTitulo;
    private String rutaImagen;

    private int radio = 24;
    private Color fondo = Color.WHITE;
    private Color hover = new Color(247,250,255);

    private boolean mouseEncima = false;


    public CategoriaCard(String rutaImagen,
                         String titulo) {

        this.rutaImagen = rutaImagen;

        construir(titulo);

    }

    private void construir(String titulo) {
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(120,190));

        setLayout(new BorderLayout());

        // Imagen
        lblImagen = new JLabel();
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);

        lblImagen.setPreferredSize(new Dimension(120,185));

        cargarImagen(rutaImagen);
        add(lblImagen,BorderLayout.CENTER);

        // Título
        JPanel panelTexto = new JPanel(new BorderLayout());

        panelTexto.setOpaque(false);

        panelTexto.setBorder(new EmptyBorder(18,15,18,15));

        lblTitulo = new JLabel(
                titulo,
                SwingConstants.CENTER);

        lblTitulo.setFont(Fuentes.bold(17f));

        lblTitulo.setForeground(Colores.GRAFITO);

        panelTexto.add(lblTitulo);

        add(panelTexto,BorderLayout.SOUTH);

        // Hover
        MouseAdapter hoverMouse =
                new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                mouseEncima = true;

                repaint();

            }

            @Override
            public void mouseExited(MouseEvent e) {

                mouseEncima = false;

                repaint();

            }

        };

        addMouseListener(hoverMouse);

        lblImagen.addMouseListener(hoverMouse);

        lblTitulo.addMouseListener(hoverMouse);

    }

    // Imagen
    private void cargarImagen(String ruta) {

        try {

            ImageIcon icon =
                    new ImageIcon(
                            getClass().getResource(ruta));

            Image img =
                    icon.getImage().getScaledInstance(
                            120,
                            185,
                            Image.SCALE_SMOOTH);

            lblImagen.setIcon(
                    new ImageIcon(img));

        } catch (Exception ex) {

            lblImagen.setOpaque(true);

            lblImagen.setBackground(
                    new Color(235,235,235));

            lblImagen.setText("Imagen");

            lblImagen.setHorizontalAlignment(
                    SwingConstants.CENTER);

            System.out.println(
                    "No se encontró: " + ruta);

        }

    }

    // Pintado
    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 =
                (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // sombra
        g2.setColor(
                new Color(0,0,0,18));

        g2.fillRoundRect(
                5,
                6,
                getWidth()-10,
                getHeight()-8,
                radio,
                radio);

        // fondo
        if(mouseEncima){

            g2.setColor(hover);

        }else{

            g2.setColor(fondo);

        }

        g2.fillRoundRect(
                0,
                0,
                getWidth()-8,
                getHeight()-8,
                radio,
                radio);

        // borde
        g2.setColor(
                new Color(225,225,225));

        g2.drawRoundRect(
                0,
                0,
                getWidth()-8,
                getHeight()-8,
                radio,
                radio);

        g2.dispose();

        super.paintComponent(g);

    }

    // API pública
    public void setTitulo(String titulo){
        lblTitulo.setText(titulo);
    }

    public void setImagen(String ruta){
        rutaImagen = ruta;
        cargarImagen(ruta);
    }

    public JLabel getLblTitulo(){
        return lblTitulo;
    }

    public JLabel getLblImagen(){
        return lblImagen;
    }
}
