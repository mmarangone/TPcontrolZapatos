package views;

import controlador.ControladorAdmin;
import modelo.Color;
import modelo.Modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestionModelosVista extends JFrame {

    private ControladorAdmin controlAdmin;
    private JPanel gestionModelos;
    private JButton quitarButton;
    private JButton modificarButton;
    private JTable tableModelos ;
    private JButton finalizarButton;
    private JButton agregarButton;
    private JTextField skuText;
    private JTextField descripText;
    private JComboBox colorComboBox;

    public GestionModelosVista(ControladorAdmin controlerAdmin) {
        setContentPane(gestionModelos);
        setTitle("Gestion de Modelos");
        setSize(600,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.controlAdmin = controlerAdmin;
        completarTabla();
        configBotonQuitar();
        configBotonModificar();
        configBotonAgregar();
        completarComboBox();
        controlAdmin.configurarBotonSalirGestionModelos(finalizarButton);

    }


    public void completarTabla (){
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("SKU");
    model.addColumn("DESCRIPCION");
    model.addColumn("COLORES");
    //Object[] fila = {"Sku1","Descrip1","colores"};
    ArrayList<Modelo> modelos = controlAdmin.traerModelos();
    for (Modelo m : modelos){
        Object[] fila = {m.getSku().toString(),m.getDescripcion(),m.listarColores()};
        model.addRow(fila);
    }
    tableModelos.setModel(model);

}
    public void completarComboBox(){
        ArrayList<Color> colores = controlAdmin.traerColoresDisponibles();
        colorComboBox.addItem("");
        for (Color c : colores){
            colorComboBox.addItem(c.getDescripcion());
        }

    }
    public void configBotonAgregar(){
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sku = skuText.getText();
                String descripcion = descripText.getText();
                String color = colorComboBox.getSelectedItem().toString();
                if (color.isEmpty() || descripcion.isEmpty() || sku.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan agregar datos");
                } else {
                    if (controlAdmin.checkModeloExist(sku, descripcion)) {
                        JOptionPane.showMessageDialog(null, "Modelo ya existente");
                        skuText.setText("");
                        descripText.setText("");
                        colorComboBox.setSelectedIndex(0);
                    } else {
                        controlAdmin.agregarModelo(sku, descripcion, color);
                        skuText.setText("");
                        descripText.setText("");
                        colorComboBox.setSelectedIndex(0);
                        JOptionPane.showMessageDialog(null, "Modelo agregado correctamente");
                    }
                }
            }

        });
            }


    public void configBotonQuitar(){
        quitarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tableModelos.getSelectedRow();
                if (filaSeleccionada != -1){
                    Object[] datosFila = new Object[tableModelos.getColumnCount()];
                    for (int i = 0; i < tableModelos.getColumnCount(); i++){
                        datosFila[i] = tableModelos.getValueAt(filaSeleccionada,i);
                    }
                    controlAdmin.quitarModelo(datosFila);
                    JOptionPane.showMessageDialog(null, "Modelo eliminado correctamente");
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
                }

            }
        });
    }
    public void configBotonModificar(){
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tableModelos.getSelectedRow();
                if (filaSeleccionada != -1){
                    Object[] datosFila = new Object[tableModelos.getColumnCount()];
                    for (int i = 0; i < tableModelos.getColumnCount(); i++){
                        datosFila[i] = tableModelos.getValueAt(filaSeleccionada,i);
                    }
                    controlAdmin.modificarModelo(datosFila);
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
                }

            }
        });
    }


    public void ejecutar(){
        this.setVisible(true);
        completarTabla();
    }
    public void cerrar(){
        this.setVisible(false);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
