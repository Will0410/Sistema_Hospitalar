import Contability.contability_area;
import Contability.produtos;

import javax.swing.*;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new login();
                frame.setSize(300,300);
                frame.setVisible(true);

            }
        });
    }
}