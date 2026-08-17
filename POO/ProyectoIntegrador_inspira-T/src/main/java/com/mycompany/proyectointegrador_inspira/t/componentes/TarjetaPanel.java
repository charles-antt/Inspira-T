/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
import com.mycompany.proyectointegrador_inspira.t.util.Colores;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
/**
 *
 * @author berth
 */
public class TarjetaPanel extends JPanel{
    private JLabel titulo;
    private JPanel contenido;

    /**
     * Constructor sin título.
     */
    public TarjetaPanel() {

        this(null);

    }


    public TarjetaPanel(String textoTitulo) {
        inicializar();
        
        if (textoTitulo != null && !textoTitulo.isBlank()) {
            setTitulo(textoTitulo);
        }
    }

    private void inicializar() {
        setOpaque(false);
        setLayout(new BorderLayout());

        // Panel interno
        contenido = new JPanel();
        contenido.setOpaque(true);
        contenido.setBackground(Colores.BLANCO);
        contenido.setBorder(
                new CompoundBorder(
                        new LineBorder(
                                Colores.BORDE,
                                1,
                                true),
                        new EmptyBorder(
                                25,
                                25,
                                25,
                                25)
                )
        );

        add(contenido, BorderLayout.CENTER);
    }

    public void setContenidoLayout(LayoutManager layout) {
        contenido.setLayout(layout);
    }

    @Override
    public Component add(Component comp) {
        return contenido.add(comp);
    }

    public Component addComp(Component comp, Object constraints) {
        contenido.add(comp, constraints);
        return comp;
    }

    public void setTitulo(String texto) {
        if (titulo == null) {
            titulo = new JLabel();
            titulo.setFont(Fuentes.bold(20f));
            titulo.setForeground(Colores.AZUL_CONFIANZA);
            titulo.setBorder(
                    new EmptyBorder(
                            0,
                            5,
                            15,
                            5)
            );
            add(titulo, BorderLayout.NORTH);
        }
        titulo.setText(texto);

    }

    public JPanel getContenido() {
        return contenido;
    }

    public void setPadding(int padding) {
        contenido.setBorder(
                new CompoundBorder(
                        new LineBorder(
                                Colores.BORDE,
                                1,
                                true),
                        new EmptyBorder(
                                padding,
                                padding,
                                padding,
                                padding)

                )

        );

    }

    public void setColorFondo(Color color) {
        contenido.setBackground(color);
    }
}
