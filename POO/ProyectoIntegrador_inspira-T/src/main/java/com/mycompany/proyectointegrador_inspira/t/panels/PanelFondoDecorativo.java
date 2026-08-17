/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

//import java.awt.*;
import javax.swing.*;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author berth
 */
public class PanelFondoDecorativo extends JPanel {

    private final JLabel imgTop;
    private final JLabel imgRight;
    private final JLabel imgBottom;
    private final JLabel imgLeft;

    public PanelFondoDecorativo() {

        setOpaque(false);

        setLayout(null);

        imgTop = new JLabel(
                new FlatSVGIcon(
                        "imagenes/imgTop.svg",
                        110,
                        110));

        imgRight = new JLabel(
                new FlatSVGIcon(
                        "imagenes/imgRight.svg",
                        135,
                        135));

        imgBottom = new JLabel(
                new FlatSVGIcon(
                        "imagenes/imgBottom.svg",
                        110,
                        100));

        imgLeft = new JLabel(
                new FlatSVGIcon(
                        "imagenes/imgLeft.svg",
                        115,
                        125));

        add(imgTop);
        add(imgRight);
        add(imgBottom);
        add(imgLeft);

    }

    @Override
    public void doLayout() {

        super.doLayout();

        int w = getWidth();
        int h = getHeight();

        imgTop.setBounds(
                w - 70,
                h - 180,
                110,
                110);

        imgRight.setBounds(
                w - 88,
                h - 100,
                135,
                135);

        imgBottom.setBounds(
                w - 150,
                h - 50,
                110,
                100);

        imgLeft.setBounds(
                w - 150,
                h - 145,
                115,
                125);

    }
}
