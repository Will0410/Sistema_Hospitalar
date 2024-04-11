import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel telaMenu;
    private JButton button1;

    public  Menu() {
        setContentPane(telaMenu);
        setSize(300, 300);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login frame = new login();
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
