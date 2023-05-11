package views;

import controlador.ControladorAdmin;
import modelo.Color;
import modelo.Modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VerModelos extends JFrame{
    private JPanel verModelos;
    private JButton cerrarButton;
    private JTable modelosTable;
    private ControladorAdmin controlAdmin;
    private Modelo modelo;
    public VerModelos(ControladorAdmin controlerAdmin, Modelo m) {
        setContentPane(verModelos);
        setTitle("Gestion de Modelos");
        setSize(600,300);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.controlAdmin = controlerAdmin;
        this.modelo = m;
        completarTabla(m);
        controlAdmin.configBotonCerrar(cerrarButton);

    }



    public void completarTabla (Modelo m){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("SKU");
        model.addColumn("CÓDIGO COLOR");
        model.addColumn("DESCRIPCIÓN");
        model.addColumn("COLOR");
        for (Color cl : m.getColores()){
            Object[] fila = {m.getSku(),cl.getCodigo(),m.getDescripcion(),cl.getDescripcion()};
            model.addRow(fila);
        }
        modelosTable.setModel(model);
    }

    public void ejecutar(){
        this.setVisible(true);
    }
    public void cerrar(){
        this.setVisible(false);
    }

}
