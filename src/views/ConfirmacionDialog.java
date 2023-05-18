package views;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmacionDialog extends JDialog {
    private boolean confirmed = false;
    private JButton yesButton = new JButton("Sí");
    private JButton noButton = new JButton("No");


    public ConfirmacionDialog(JFrame parent, String title, String message) {
        super(parent, title, true);
        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);
        panel.add(label);
        panel.add(yesButton);
        panel.add(noButton);
        getContentPane().add(panel);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        pack();
        setLocationRelativeTo(parent);
        configuracionBotones();
    }
    public void configuracionBotones(){

        yesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmed = true;
                cerrar();

            }
        });

        noButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmed = false;
                cerrar();
            }
        });
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void cerrar(){
        setVisible(false);
    }

}
