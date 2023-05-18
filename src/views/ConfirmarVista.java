package views;

import controlador.ControladorSL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConfirmarVista extends JFrame {
    private JPanel confirmarPanel;
    private JButton noButton;
    private JButton siButton;
    private JLabel labelNumero;
    private JLabel labelLinea;
    private JLabel labelSupervisor;
    private JLabel labelModelo;
    private JLabel labelColor;
    private ControladorSL controlSL;
    private ArrayList<String> labels;
    private Boolean var = null;

    public ConfirmarVista(ControladorSL control){
        setContentPane(confirmarPanel);
        setTitle("Importante");
        setSize(450,250);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.controlSL = control;
        configuracionBotones();
        completarLabels();
    }

    public void completarLabels(){
        labels = controlSL.datosOP();
        labelNumero.setText(labels.get(1));
        labelLinea.setText(""+labels.get(2));
        labelSupervisor.setText(""+labels.get(3));
        labelModelo.setText(""+labels.get(4));
        labelColor.setText(""+labels.get(5));
        //estadoLabel.setText(""+labels.get(0));
    }

    public void configuracionBotones(){
        siButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var = true;
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var =false;
            }
        });
    }

    public Boolean confirmacion(){
        return var;
    }
    public void ejecutar(){
        setVisible(true);
    }
    public void cerrar(){
        setVisible(false);
    }
}
