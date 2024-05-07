import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Contability.produtos;

import static sun.tools.jconsole.inspector.XDataViewer.dispose;

public class menu_func_comum extends JFrame {
    private JButton btn_consul_user;
    private JButton btn_cad_users;
    private JButton BTN_CONSUL_PRODUT;
    private JPanel tela_menu_user;

    public menu_func_comum() {
        setContentPane(tela_menu_user);
        setSize(500, 500);

        btn_consul_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consul_users frame = new consul_users();
                frame.setVisible(true);
                dispose();
            }
        });
        BTN_CONSUL_PRODUT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produtos frame = new produtos();
                frame.setVisible(true);
                dispose();
            }
        });
        btn_cad_users.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crud frame = new crud();
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
