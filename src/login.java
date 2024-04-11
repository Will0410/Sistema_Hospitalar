import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import Application.loginDao;
import Model.user;

public class login extends JFrame{
    private JButton btnlogin;
    private JTextField txtlogin;
    private JTextField txtpassword;
    private JPanel login;
    private JButton cadastrarSeButton;

    public login() {
        setContentPane(login);
        setSize(300,300);
        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String username, password;

                    username = txtlogin.getText();
                    password = txtpassword.getText();

                    user objusername = new user();

                    objusername.setUsername(username);
                    objusername.setPassword(password);

                    loginDao objusuario = new loginDao();
                    ResultSet rsUSer = objusuario.autenticar(objusername);


                    if (rsUSer.next()){
                        Menu telaMenu = new Menu();
                        telaMenu.setVisible (true);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuario ou senha Invalida");
                    }

                }catch (SQLException erro){
                    JOptionPane.showMessageDialog(null, "FRMLOGINVIEW" + erro);
                }//
            }
        });
        cadastrarSeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crud telaMenu = new crud();
                telaMenu.setVisible (true);
                dispose();
            }
        });
    }



}
