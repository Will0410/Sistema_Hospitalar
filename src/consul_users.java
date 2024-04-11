import Application.CadFunc;
import Model.userFunc;
import Application.application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import Application.application;
import Model.user;

public class consul_users extends JFrame {
    private JTextField txt_username_user1;
    private JTextField txt_func_id__user;
    private JTextField txt_email_user;
    private JTextField txt_age_user;
    private JTextField txt_proced_user;
    private JButton consultarButton;
    private JPanel painel_user;

    public consul_users() {
        setContentPane(painel_user);
        setSize(300, 300);
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                user users;
                application aplication;
                boolean status;
                int resp;
                String user_id;

                user_id = txt_func_id__user.getText();

                application conexDAO = new application();
                status = conexDAO.conec();
                if (status  == true){
                    user usuario = null;
                    try {
                        usuario = conexDAO.consult(user_id);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (usuario==null){
                        JOptionPane.showMessageDialog(null,"Funcionário não localizado");
                    }else{
                        txt_func_id__user.setText(String.valueOf(usuario.getUser_id()));
                        txt_username_user1.setText(usuario.getUsername());
                        txt_email_user.setText(usuario.getEmail());
                        txt_age_user.setText(usuario.getAge());
                        txt_proced_user.setText(usuario.getProced());
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
                }
            }

        });
    }
}


