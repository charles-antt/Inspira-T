/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador_inspira.t.panels;

import com.mycompany.proyectointegrador_inspira.t.util.Colores;
import com.mycompany.proyectointegrador_inspira.t.util.Fuentes;
//import com.mycompany.proyectointegrador_inspira.t.panels.PanelTarjeta;
import com.mycompany.proyectointegrador_inspira.t.componentes.JTextAreaRedondeado;
import com.mycompany.proyectointegrador_inspira.t.componentes.TextField;
import com.mycompany.proyectointegrador_inspira.t.componentes.CustomComboBox;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author berth
 */
public class PanelTransmision extends JPanel {

    //Componentes
    private CustomComboBox<String> cbCategoria;
    private JTextField txtFecha;
    private JTextField txtHora;
    private CustomComboBox<String> cbNivel;

    private JCheckBox chkComentarios;

    public PanelTransmision() {
        setOpaque(false);
        setLayout(new MigLayout(
                "fillx,insets 0",
                "[grow]",
                "[]"));
        add(crearFormulario(), "growx");
    }

    // Formulario
    private JPanel crearFormulario() {
        PanelTarjeta card = new PanelTarjeta();
        card.setCardSize(360, 760);

        card.setLayout(new MigLayout(
                "fillx, insets 1",
                "[0:pref:50%, grow, sg 5][0:pref:50%, grow, sg 1]", // <- Sintaxis corregida aquí
                "[]10[]10[]10[][]10[]"
        ));

        JLabel titulo = new JLabel("Crear transmisión en vivo");
        titulo.setFont(Fuentes.bold(18f));
        card.add(titulo, "span 2,wrap");

        // TÍTULO
        card.add(crearLabel("Título de la transmisión*"));
        card.add(crearLabel("Categoría*"), "wrap");

        TextField txtTitulo = new TextField("Introduce un título atractivo y descriptivo");
        txtTitulo.setRadius(22);
        cbCategoria = new CustomComboBox<>();
        cbCategoria.addItem("Selecciona una categoría");
        cbCategoria.addItem("Agricultura");
        cbCategoria.addItem("Artesanías");
        cbCategoria.addItem("Gastronomía");
        cbCategoria.addItem("Lenguas");
        cbCategoria.addItem("Medicina tradicional");
        //card.add(txtTitulo, "growx,h 40!");
        //card.add(cbCategoria, "growx,h 40!,wrap");
        card.add(txtTitulo, "growx,pushx,w 0:n:n,h 40!");

        card.add(cbCategoria, "growx,pushx,w 0:n:n,h 40!,wrap");
        // DESCRIPCIÓN
        card.add(crearLabel("Descripción*"));
        card.add(crearLabel("Etiquetas"), "wrap");

        JTextArea jDescripcion = new JTextArea(2, 20);
        jDescripcion.setLineWrap(true);
        jDescripcion.setWrapStyleWord(true);
        jDescripcion.setOpaque(false);
        JScrollPane spDescripcion = new JScrollPane(jDescripcion);
        spDescripcion.setBorder(new JTextAreaRedondeado(15, new Color(210, 210, 210)));

        spDescripcion.getViewport().setOpaque(false);
        spDescripcion.setOpaque(false);

        TextField txtEtiquetas = new TextField("Ej. medicina, herbolaria");
        txtEtiquetas.setRadius(22);
        card.add(spDescripcion, "growx,pushx,w 0:n:n,h 90!");
        JPanel panelEtiquetas = new JPanel(
                new MigLayout(
                        "fillx,insets 0",
                        "[grow]",
                        "[][]"));

        panelEtiquetas.setOpaque(false);

        panelEtiquetas.add(txtEtiquetas, "growx,wrap");

        JLabel ayuda = new JLabel("Separa las etiquetas con comas");
        ayuda.setForeground(Colores.MORADO);
        ayuda.setFont(Fuentes.regular(14f));

        panelEtiquetas.add(ayuda);

        //card.add(panelEtiquetas, "growx,wrap");
        card.add(panelEtiquetas, "growx,pushx,w 0:n:n,wrap");
        // FECHA
        card.add(crearLabel("Fecha*"));
        card.add(crearLabel("Hora de inicio*"), "wrap");

        txtFecha = new TextField();
        txtFecha.setText("Selecciona fecha");

        txtHora = new TextField();
        txtHora.setText("--:--");

        card.add(txtFecha, "growx,pushx,w 0:n:n,h 40!");

        card.add(txtHora, "growx,pushx,w 0:n:n,h 40!,wrap");
        // DURACIÓN
        card.add(crearLabel("Duración estimada*"));
        card.add(crearLabel("Nivel de dificultad"), "wrap");

        //card.add(new JLabel(), "wrap");
        TextField txtDuracion = new TextField("Ej. 1 hora");
        txtDuracion.setRadius(22);

        //card.add(new JLabel(), "growx,pushx,wrap");
        cbNivel = new CustomComboBox<>();
        cbNivel.addItem("Selecciona el nivel");
        cbNivel.addItem("Principiante");
        cbNivel.addItem("Intermedio");
        cbNivel.addItem("Avanzado");

        card.add(txtDuracion, "growx,pushx,w 0:n:n,h 40!");
        card.add(cbNivel, "growx,pushx,w 0:n:n,h 40!, wrap");

        card.add(crearLabel("Permitir comentarios"), "span 2, wrap");

        chkComentarios = new JCheckBox("<html>Los alumnos podrán comentar y hacer preguntas</html>");
        chkComentarios.setOpaque(false);
        chkComentarios.setFont(Fuentes.regular(15f));
        chkComentarios.setIcon(new SwitchIcon(false));        // Estado apagado
        chkComentarios.setSelectedIcon(new SwitchIcon(true)); // Estado encendido

        chkComentarios.setIconTextGap(12); // Distancia entre el texto y el interruptor
        chkComentarios.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        chkComentarios.setHorizontalTextPosition(SwingConstants.LEFT);
        card.add(chkComentarios, "span 2, growx,pushx, w 0:n:n, top, wrap");
        return card;

    }

    // Etiquetas
    private JLabel crearLabel(String texto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(Fuentes.medium(16f));
        lbl.setForeground(Colores.GRAFITO);
        return lbl;

    }

    private static class SwitchIcon implements Icon {
        private final boolean seleccionado;
        private final Color colorFondoOn = Colores.TURQUESA;
        private final Color colorFondoOff = new Color(220, 224, 230);
        private final Color colorBolaOff = Colores.GRAFITO;

        public SwitchIcon(boolean seleccionado) {
            this.seleccionado = seleccionado;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Dimensiones del switch (Píldora)
            int anchoPildora = 34;
            int altoPildora = 20;
            int diametroBola = 14;

            // Centrar verticalmente el icono respecto al texto
            int verticalOffset = y + ((getIconHeight() - altoPildora) / 2);

            // 1. Dibujar el cuerpo de la píldora (Fondo)
            if (seleccionado) {
                g2.setColor(colorFondoOn);
            } else {
                g2.setColor(colorFondoOff);
            }
            g2.fillRoundRect(x, verticalOffset, anchoPildora, altoPildora, altoPildora, altoPildora);

            // 2. Calcular posición y dibujar la bola deslizante interna
            int posicionBolaX;
            if (seleccionado) {
                // Lado derecho (Encendido)
                posicionBolaX = x + anchoPildora - diametroBola - 3;
                g2.setColor(Color.WHITE);
            } else {
                // Lado izquierdo (Apagado)
                posicionBolaX = x + 3;
                g2.setColor(colorBolaOff);
            }

            int posicionBolaY = verticalOffset + ((altoPildora - diametroBola) / 2);
            g2.fillOval(posicionBolaX, posicionBolaY, diametroBola, diametroBola);

            g2.dispose();
        }

        @Override
        public int getIconWidth() {
            return 40; // Espacio total horizontal reservado para el icono
        }

        @Override
        public int getIconHeight() {
            return 24; // Espacio total vertical reservado
        }
    }

    // Getters
    /**
     * public JTextField getTxtTitulo() { return txtTitulo; }*
     */
    /**
     * public JComboBox<String> getCbCategoria() { return cbCategoria; }*
     */
    /**
     * public JTextArea getTxtDescripcion() { return txtDescripcion; }*
     */
    /**
     * public JTextField getTxtEtiquetas() { return txtEtiquetas; }*
     */
    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public JTextField getTxtHora() {
        return txtHora;
    }

    public JComboBox<String> getCbNivel() {
        return cbNivel;
    }

    public JCheckBox getChkComentarios() {
        return chkComentarios;
    }
}
