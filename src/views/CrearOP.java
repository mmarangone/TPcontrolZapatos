package views;

import controlador.ControladorSL;
import modelo.Color;
import modelo.Modelo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CrearOP extends JFrame{
    private JPanel crearOP;
    private JButton cancelarButton;
    private JButton confirmarButton;
    private JComboBox coloresCombo;
    private JComboBox modeloCombo;
    private JComboBox superCombo;
    private JComboBox lineaCombo;
    private JTextField opText;
    private ControladorSL controlSL;


    public CrearOP(ControladorSL controlerSL) {
        setContentPane(crearOP);
        setTitle("Orden de Produccion");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.controlSL = controlerSL;
        configComboModeloColores();
        completarComboBox();
        configurarBotonConfirmarOP();
        configurarBotonCancelar();

    }

    public void configurarBotonConfirmarOP(){
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String linea = lineaCombo.getSelectedItem().toString();
                String numeroOp = opText.getText();
                String supCalidad = superCombo.getSelectedItem().toString();
                String modelo = modeloCombo.getSelectedItem().toString();
                if (coloresCombo.getSelectedItem() == null){
                    JOptionPane.showMessageDialog(null,"Faltan datos por completar");
                }else {
                    String color = coloresCombo.getSelectedItem().toString();
                    if (linea.isEmpty() || numeroOp.isEmpty() || supCalidad.isEmpty() || modelo.isEmpty() || color.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Faltan datos por completar");
                    } else {
                        ArrayList<String> datos = new ArrayList<>();
                        datos.add(linea);
                        datos.add(numeroOp);
                        datos.add(supCalidad);
                        datos.add(modelo);
                        datos.add(color);
                        controlSL.crearOP(datos);
                        JOptionPane.showMessageDialog(null, "Orden de Produccion creada correctamente");
                        controlSL.vueltaMenuPrincipal();
                    }
                }
            }
        });

    }
    public void configurarBotonCancelar(){
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlSL.vueltaMenuPrincipal();
            }
        });
    }

    public void completarComboBox(){
        completarComboLinea();
        completarComboSupervisores();
        completarComboModelos();
        coloresCombo.setEnabled(false);


    }
    public void configComboModeloColores(){
        modeloCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modeloSeleccionado = (String) modeloCombo.getSelectedItem();
                coloresCombo.removeAllItems();
                if (!modeloSeleccionado.isEmpty()) {
                    coloresCombo.setEnabled(true);
                    completarComboColores(modeloSeleccionado);
                }else{coloresCombo.setEnabled(false);}
            }
        });
    }
    public void completarComboColores(String modelo){
        ArrayList<Color> colores = controlSL.traerColoresModelo(modelo);
        coloresCombo.addItem("");
        for (Color c : colores){
            coloresCombo.addItem(c.getDescripcion());
        }
    }
    public void completarComboModelos(){
        ArrayList<Modelo> modelos = controlSL.traerModelos();
        modeloCombo.addItem("");
        for (Modelo m : modelos){
            modeloCombo.addItem(m.getDescripcion());
        }

    }
    public void completarComboLinea(){
        ArrayList<String> lineas = controlSL.traerLineasDisponibles();
        lineaCombo.addItem("");
        for (String l : lineas){
            lineaCombo.addItem(l);
        }
    }
    public void completarComboSupervisores(){
        ArrayList<String> supers = controlSL.traerSupervisoresDisponibles();
        superCombo.addItem("");
        for (String sc : supers){
            superCombo.addItem(sc);
        }
    }

    public void ejecutar(){
        setVisible(true);
    }
    public void cerrar(){
        setVisible(false);
    }
}
