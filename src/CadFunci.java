import Application.CadFunc;
import Model.userFunc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CadFunci extends JFrame {
    private JButton btncadFunc;
    private JButton btnBack;
    private JTextField txtCodFunc;
    private JTextField txtNmfunc;
    private JTextField txtEmailfunc;
    private JTextField txtNmphone;
    private JTextField txtCargoFunc;
    private JPanel tela_func;
    private JButton cleanButton;
    private JPasswordField pass_func;
    private JTextField txt_func_id;

    public CadFunci() {
        setContentPane(tela_func);
        setSize(300, 300);
        btncadFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btncadFunc.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        userFunc usuario = new userFunc();
                        usuario.setFunc_id(Integer.parseInt(txt_func_id.getText()));
                        usuario.setName_func(txtNmfunc.getText());
                        usuario.setTel_func(txtNmphone.getText());
                        usuario.setEmail_func(txtEmailfunc.getText());
                        usuario.setPass_func(pass_func.getText());
                        usuario.setCargo_func(txtCargoFunc.getText());

                        if ((  (txt_func_id.getText().isEmpty()) ||  txtCargoFunc.getText().isEmpty()) || (txtNmfunc.getText().isEmpty()) || (txtNmphone.getText().isEmpty())
                                || (pass_func.getText().isEmpty() ||  (txtEmailfunc.getText().isEmpty()))) {
                            JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
                        } else {
                            CadFunc cadfunci = new CadFunc();
                            try {
                                cadfunci.cadFunc(usuario);
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                            JOptionPane.showMessageDialog(null, "Usuário " + txtNmfunc.getText() + " inserido com sucesso! ");

                            txtNmfunc.setText("");
                            txtEmailfunc.setText("");
                            txtNmphone.setText("");
                            pass_func.setText("");
                            txtCargoFunc.setText("");
                        }
                    }
                });
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu frame = new Menu();
                frame.setVisible(true);
                dispose();
            }
        });
        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_func_id.setText("");
                txtNmphone.setText("");
                txtNmphone.setText("");
                txtEmailfunc.setText("");
                txtCargoFunc.setText("");
                pass_func.setText("");
            }


        });
    }
}
