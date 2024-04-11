import Application.application;
import Model.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class crud extends JFrame {
    public JLabel lblname;
    public JLabel lblemail;
    public JLabel lblage;
    public JLabel lblpassword;
    public JTextField txtname;
    public JTextField txtemail;
    public JTextField txtage;
    public JPasswordField txtpassword;
    public JButton unregister;
    public JPanel Crud;
    public JButton btnlimpar;
    private JButton button1;
    private JTextField txt_proced_user;
    private JTextField txt_cod_user;

    public crud() {

    setContentPane(Crud);
    setSize(300, 300);

        btnlimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txt_cod_user.setText("");
                txtname.setText("");
                txtemail.setText("");
                txtage.setText("");
                txtpassword.setText("");
                txt_proced_user.setText("");
            }

                        });

        unregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user usuario = new user();
                usuario.setUser_id(txt_cod_user.getText());
                usuario.setUsername(txtname.getText());
                usuario.setEmail(txtemail.getText());
                usuario.setAge(txtage.getText());
                usuario.setPassword(txtpassword.getText());
                usuario.setProced(txt_proced_user.getText());

                if (( txt_cod_user.getText().isEmpty())||(txtname.getText().isEmpty()) || (txtemail.getText().isEmpty()) || (txtage.getText().isEmpty())
                        || (txtpassword.getText().isEmpty()) ||(txt_proced_user.getText().isEmpty())){
                    JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
                } else {
                    application Application = new application();
                    try {
                        Application.adciona(usuario);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null, "Usuário " + txtname.getText() + " inserido com sucesso! ");

                    txt_cod_user.setText("");
                    txtname.setText("");
                    txtemail.setText("");
                    txtage.setText("");
                    txtpassword.setText("");
                    txt_proced_user.setText("");
                }
            }
        });
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