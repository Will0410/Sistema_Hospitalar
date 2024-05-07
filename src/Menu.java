import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel telaMenu;
    private JButton button1;
    private JButton contabilityButton;
    private JButton cadastro_userButton;
    private JButton consul_FuncButton;
    private JButton consul_FuncButton1;
    private JButton cad_FuncButton;
    private JButton consul_ProdutosButton;

    public  Menu() {
        setContentPane(telaMenu);
        setSize(500, 500);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login frame = new login();
                frame.setVisible(true);
                dispose();
            }
        });
        contabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contability.contability_area frame = new Contability.contability_area();
                frame.setVisible(true);
                dispose();
            }
        });
        cadastro_userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                crud frame = new crud();
                frame.setVisible(true);
                dispose();
            }
        });
        cad_FuncButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CadFunci frame = new CadFunci();
                frame.setVisible(true);
                dispose();
            }
        });
        consul_FuncButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consul_painel frame = new consul_painel();
                frame.setVisible(true);
                dispose();
            }
        });
        consul_FuncButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consul_users frame = new consul_users();
                frame.setVisible(true);
                dispose();
            }
        });
        consul_ProdutosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contability.produtos frame = new Contability.produtos();
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
