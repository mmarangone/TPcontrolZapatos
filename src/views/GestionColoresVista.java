package views;

import controlador.ControladorAdmin;
import modelo.Color;
import modelo.Modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestionColoresVista extends JFrame{
    private ControladorAdmin controlAdmin;
    private JPanel gestionColores;
    private JTable coloresTable;
    private JButton quitarColorButton;
    private JButton agregarColorButton;
    private JTextField codigoText;
    private JTextField descripcionText;
    private JButton finalizarButton;

    public GestionColoresVista(ControladorAdmin controlerAdmin) {
        setContentPane(gestionColores);
        setTitle("Gestion de Colores");
        setSize(600,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.controlAdmin = controlerAdmin;
        completarTabla();
        controlAdmin.configurarBotonFinalizarGestionColores(finalizarButton);
        configurarBotonQuitar();
        configurarBotonAgregar();

    }
    public void configurarBotonAgregar(){
        agregarColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoText.getText();
                String descripcion = descripcionText.getText();
                if (controlAdmin.checkColorExist(codigo, descripcion)) {
                    JOptionPane.showMessageDialog(null, "Color ya existente");
                    codigoText.setText("");
                    descripcionText.setText("");
                } else {
                    controlAdmin.agregarColorPaleta(codigo, descripcion);
                    codigoText.setText("");
                    descripcionText.setText("");
                    JOptionPane.showMessageDialog(null, "Color agregado correctamente");
                }
            }

        });

    }
    public void configurarBotonQuitar(){
        quitarColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = coloresTable.getSelectedRow();
                if (filaSeleccionada != -1){
                    Object[] datosFila = new Object[coloresTable.getColumnCount()];
                    for (int i = 0; i < coloresTable.getColumnCount(); i++){
                        datosFila[i] = coloresTable.getValueAt(filaSeleccionada,i);
                    }
                    controlAdmin.quitarColorPaleta(datosFila);
                    //completarTablaModelos(modelo);
                    //completarTablaColores(modelo);
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
                }

            }
        });

    }

    public void completarTabla (){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CODIGO");
        model.addColumn("DESCRIPCION");
        //Object[] fila = {"Sku1","Descrip1","colores"};
        ArrayList<Color> colores = controlAdmin.traerColoresDisponibles();
        for (Color c : colores){
            Object[] fila = {c.getCodigo(),c.getDescripcion()};
            model.addRow(fila);
        }
        coloresTable.setModel(model);

    }
    public void ejecutar(){
        this.setVisible(true);
        completarTabla();
    }
    public void cerrar(){
        this.setVisible(false);
    }
}
