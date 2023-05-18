package views;

import controlador.ControladorSL;

import javax.swing.*;
import java.util.ArrayList;

public class VerOP extends JFrame{
    private JLabel opLabel;
    private JLabel lineaLabel;
    private JLabel supCalidadLabel;
    private JButton reanudarButton;
    private JButton pausarButton;
    private JButton finalizarButton;
    private JButton cerrarButton;
    private JLabel estadoLabel;
    private JLabel colorLabel;
    private JLabel modeloLabel;
    private JPanel verOPPanel;
    private ControladorSL controlSL;
    private ArrayList<String> labels;

    public VerOP(ControladorSL controlerSL) {
        setContentPane(verOPPanel);
        setTitle("Orden de Produccion");
        setSize(450,300);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.controlSL = controlerSL;
        configurarBotones();
        completarLabels();

    }

    public void completarLabels(){
            labels = controlSL.datosOP();
            opLabel.setText(labels.get(1));
            lineaLabel.setText(""+labels.get(2));
            supCalidadLabel.setText(""+labels.get(3));
            modeloLabel.setText(""+labels.get(4));
            colorLabel.setText(""+labels.get(5));
            estadoLabel.setText(""+labels.get(0));

    }
    public void finalizarOP(){
        estadoLabel.setText("FINALIZADA");
    }

    public void ejecutar(){
        setVisible(true);
    }
    public void cerrar(){
        setVisible(false);
    }
    public void habilitarBotonReanudar(){
        reanudarButton.setEnabled(true);
    }
    public void deshabilitarBotonReanudar(){
        reanudarButton.setEnabled(false);
    }
    public void habilitarBotonPausar(){
        pausarButton.setEnabled(true);
    }
    public void deshabilitarBotonPausar(){
        pausarButton.setEnabled(false);
    }
    public void habilitarBotonFinalizar(){
        finalizarButton.setEnabled(true);
    }
    public void deshabilitarBotonFinalizar(){
        finalizarButton.setEnabled(false);
    }
    public void configurarBotones(){
        controlSL.configurarBotonReanudar(reanudarButton);
        controlSL.configurarBotonPausar(pausarButton);
        controlSL.configurarBotonFinalizar(finalizarButton);
        controlSL.configurarBotonCerrar(cerrarButton);
    }

}
