/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;
import com.mycompany.proyectointegrador_inspira.t.util.Colores;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
/**
 *
 * @author berth
 */
public class PanelPrincipal extends JPanel{
    private PanelHero panelHero;
    private PanelOferta panelOferta;
    private PanelConocenos panelConocenos;
    private PanelQueHacemos panelQueHacemos;

    public PanelPrincipal() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        panelHero = new PanelHero();
        panelOferta = new PanelOferta();
        panelConocenos = new PanelConocenos();
        panelQueHacemos = new PanelQueHacemos();

        add(panelHero);
        add(panelOferta);
        add(panelConocenos);
        add(panelQueHacemos);
    }

    public PanelHero getPanelHero() {
        return panelHero;
    }

    public PanelOferta getPanelOferta() {
        return panelOferta;
    }

    public PanelConocenos getPanelConocenos() {
        return panelConocenos;
    }

    public PanelQueHacemos getPanelQueHacemos() {
        return panelQueHacemos;
    }
}
