package views;

import controlador.ControladorAdmin;
import modelo.Color;
import modelo.Modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModificarModelos extends JFrame{
    private JPanel modicarModelos;
    private JTable modelosTable;
    private JTable coloresTable;
    private JButton quitarColorButton;
    private JButton agregarColorButton;
    private JButton finalizarButton;
    private ControladorAdmin controlAdmin;
    private Modelo modelo;

    public ModificarModelos(ControladorAdmin controlerAdmin, Modelo m) {
        setContentPane(modicarModelos);
        setTitle("Modificar Modelo");
        setSize(600,550);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.controlAdmin = controlerAdmin;
        this.modelo = m;
        completarTablaModelos(m);
        completarTablaColores(m);
        configurarBotonQuitarColor();
        configurarBotonAgregarColor();
        controlAdmin.configurarBotonFinalizarModificarModelo(finalizarButton);

    }


    public void completarTablaModelos (Modelo m){
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
    public void completarTablaColores (Modelo m){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CÓDIGO COLOR");
        model.addColumn("COLOR");
        ArrayList<Color> colores = controlAdmin.traerColoresDisponibles();
        ArrayList<Color> resultado = new ArrayList<Color>();
        for (Color cd : colores) {
            boolean encontrado = false;
            for (Color cm : m.getColores()) {
                if (cd.getCodigo().equals(cm.getCodigo())) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                resultado.add(cd);
            }
        }
        for (Color c : resultado){
            Object[] fila = {c.getCodigo(),c.getDescripcion()};
            model.addRow(fila);
        }
        coloresTable.setModel(model);
    }
    public void configurarBotonQuitarColor(){
        quitarColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = modelosTable.getSelectedRow();
                if (filaSeleccionada != -1){
                    Object[] datosFila = new Object[modelosTable.getColumnCount()];
                    for (int i = 0; i < modelosTable.getColumnCount(); i++){
                        datosFila[i] = modelosTable.getValueAt(filaSeleccionada,i);
                    }
                    controlAdmin.quitarColor(datosFila);
                    //completarTablaModelos(modelo);
                    //completarTablaColores(modelo);
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
                }

            }
        });

            }
    public void configurarBotonAgregarColor(){
        agregarColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = coloresTable.getSelectedRow();
                if (filaSeleccionada != -1){
                    Object[] datosFila = new Object[coloresTable.getColumnCount()];
                    for (int i = 0; i < coloresTable.getColumnCount(); i++){
                        datosFila[i] = coloresTable.getValueAt(filaSeleccionada,i);
                    }
                    controlAdmin.agregarColorModelo(datosFila,modelo);
                    //completarTablaModelos(modelo);
                    //completarTablaColores(modelo);
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
                }

            }
        });

    }



    public void ejecutar(){
        this.setVisible(true);
    }
    public void cerrar(){
        this.setVisible(false);
    }
}
