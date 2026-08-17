/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.componentes.BotonRedondeado;
import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Iconos;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author berth
 */
public class PanelPublicar extends PanelTarjeta {
    //Componentes

    private BotonRedondeado btnPublicar;

    public PanelPublicar() {
        construir();
    }

    private void construir() {
        setLayout(new MigLayout(
                "fill,insets 26",
                "[grow,center]",
                "[]10[]"));
        setCardSize(300, 220);
        setCardBackground(new Color(31, 60, 136, 15));
        JLabel lblTexto = new JLabel();

        lblTexto.setText("<html><body style='text-align: justify; font-family: sans-serif; font-size: 12px; line-height: 1.4;'>"
                + "<b style='color: #2E3440;'>Consejo:</b> "
                + "<span style='color: #2E3440; font-weight: normal;'>Asegurate de que tu vídeo tenga buena calidad de audio e imagen para "
                + "brindar mejor experiencia de aprendizaje.</span></body></html>");

        // Añadimos el texto ocupando todo el ancho disponible
        add(lblTexto, "growx, wrap");

        btnPublicar = new BotonRedondeado("Publicar vídeo", Colores.TURQUESA);
        btnPublicar.setForeground(Colores.GRAFITO);
        btnPublicar.setIcon(
                Iconos.cargar(
                        Iconos.UP,
                        18,
                        Colores.GRAFITO));
        btnPublicar.setHorizontalTextPosition(SwingConstants.LEFT);
        btnPublicar.setIconTextGap(10);
        add(btnPublicar, "wmax 240,h 42!,center");
    }

    public BotonRedondeado getBtnPublicar() {
        return btnPublicar;
    }
}
