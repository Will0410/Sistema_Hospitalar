import Application.CadFunc;
import Factory.ConexaoMySQL;
import Model.userFunc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class consul_painel extends JFrame {
    private JPanel painel_consul;
    private JButton btn_consul;
    private JTextField txt_func_id;
    private JTextField txt_func_name;
    private JTextField txt_func_email;
    private JTextField txt_func_tel;
    private JTextField txt_func_cargo;


    public consul_painel() {
        setContentPane(painel_consul);
        setSize(300, 300);

        btn_consul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                userFunc userFunc;
                CadFunc cadFunc;
                boolean status;
                int resp;
                String func_id;

                func_id = txt_func_id.getText();

                CadFunc conexDAO = new CadFunc();
                status = conexDAO.conect();
                if (status  == true){
                    userFunc funcUser = null;
                    try {
                        funcUser = conexDAO.consulta(func_id);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (funcUser==null){
                        JOptionPane.showMessageDialog(null,"Funcionário não localizado");
                    }else{
                        txt_func_id.setText(String.valueOf(funcUser.getFunc_id()));
                        txt_func_name.setText(funcUser.getName_func());
                        txt_func_email.setText(funcUser.getEmail_func());
                        txt_func_tel.setText(funcUser.getTel_func());
                        txt_func_cargo.setText(funcUser.getCargo_func());
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
                }
            }

        });
    }

    private void  listarvalues() throws SQLException {
        userFunc userFunc;
        CadFunc cadFunc;
        boolean status;
        int resp;
        String func_id;

        func_id = txt_func_id.getText();

        CadFunc conexDAO = new CadFunc();
        status = conexDAO.conect();
        if (status  == true){
            userFunc funcUser = conexDAO.consulta(func_id);
            if (funcUser==null){
                JOptionPane.showMessageDialog(null,"Funcionário não localizado");
            }else{
                txt_func_id.setText(String.valueOf(funcUser.getFunc_id()));
                txt_func_name.setText(funcUser.getName_func());
                txt_func_email.setText(funcUser.getEmail_func());
                txt_func_tel.setText(funcUser.getTel_func());
                txt_func_cargo.setText(funcUser.getCargo_func());
            }
        } else{
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
        }
    }


        }







