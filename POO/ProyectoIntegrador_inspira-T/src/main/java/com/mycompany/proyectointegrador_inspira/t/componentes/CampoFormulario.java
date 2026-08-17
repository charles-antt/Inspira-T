/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.componentes;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 *
 * @author berth
 */
public class CampoFormulario extends JPanel {

    private final JLabel etiqueta;
    private final JTextField campo;

    public CampoFormulario(String titulo) {

        setOpaque(false);

        setLayout(new BorderLayout(0, 8));

        // Etiqueta
        etiqueta = new JLabel(titulo);

        etiqueta.setFont(Fuentes.medium(14f));

        etiqueta.setForeground(Colores.GRAFITO);

        // Campo
        campo = new JTextField();
        campo.setFont(Fuentes.regular(15f));
        campo.setBackground(Colores.BLANCO);
        campo.setForeground(Colores.GRAFITO);
        campo.setCaretColor(Colores.AZUL_TECNOLOGICO);
        campo.setBorder(new CompoundBorder(
                new LineBorder(
                        Colores.BORDE,
                        1,
                        true),
                new EmptyBorder(10, 12, 10, 12)
        ));
        campo.setPreferredSize(new Dimension(250, 42));

        add(etiqueta, BorderLayout.NORTH);
        add(campo, BorderLayout.CENTER);

    }

    public String getTexto() {
        return campo.getText();
    }

    public void setTexto(String texto) {
        campo.setText(texto);
    }

    public void setEditable(boolean editable) {
        campo.setEditable(editable);
        if (editable) {
            campo.setBackground(Colores.BLANCO);
        } else {
            campo.setBackground(new Color(248, 249, 251));
        }

    }

    public JTextField getCampo() {
        return campo;
    }

    public void setPlaceholder(String texto) {
        campo.setToolTipText(texto);
    }

    public void setColumnas(int columnas) {
        campo.setColumns(columnas);
    }

    public void setEtiqueta(String texto) {
        etiqueta.setText(texto);
    }

    public JLabel getEtiqueta() {
        return etiqueta;
    }
}
