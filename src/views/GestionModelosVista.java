package views;

import controlador.ControladorAdmin;
import modelo.Modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestionModelosVista extends JFrame {

    private ControladorAdmin controlAdmin;
    private JPanel gestionModelos;
    private JButton verButton;
    private JButton modificarButton;
    private JTable tableModelos ;
    private JButton salirButton;

    public GestionModelosVista(ControladorAdmin controlerAdmin) {
        setContentPane(gestionModelos);
        setTitle("Gestion de Modelos");
        setSize(600,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.controlAdmin = controlerAdmin;
        completarTabla();
        configBotonVer();
        configBotonModificar();
        controlAdmin.configurarBotonSalirGestionModelos(salirButton);

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
    public void configBotonVer(){
        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tableModelos.getSelectedRow();
                if (filaSeleccionada != -1){
                    Object[] datosFila = new Object[tableModelos.getColumnCount()];
                    for (int i = 0; i < tableModelos.getColumnCount(); i++){
                        datosFila[i] = tableModelos.getValueAt(filaSeleccionada,i);
                    }
                    controlAdmin.verModelo(datosFila);
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
