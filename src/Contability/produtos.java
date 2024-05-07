package Contability;


import Application.produt;
import Model.product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class produtos  extends JFrame{
    private JTextField txt_id_produt;
    private JPanel painel_produtos;
    private JTextField txt_nome_produt;
    private JTextField txt_valor_produt;
    private JButton btn_cad_produto;
    private JLabel Valor;
    private JButton button1;

    public produtos() {
        setContentPane(painel_produtos);
        setSize(300, 300);
        btn_cad_produto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    product producties = new product();
                    producties.setId_produt(String.valueOf(Integer.parseInt(txt_id_produt.getText())));
                    producties.setNome_produt(txt_nome_produt.getText());
                    producties.setValor_produt(txt_valor_produt.getText());

                    if ((  (txt_id_produt.getText().isEmpty()) ||  txt_nome_produt.getText().isEmpty()) || (txt_valor_produt.getText().isEmpty())) {
                        JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
                    } else {
                        produt produto = new produt();
                        try {
                            produto.adciona(producties);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(null, "Produto " + txt_nome_produt.getText() + " inserido com sucesso! ");

                        txt_id_produt.setText("");
                        txt_nome_produt.setText("");
                        txt_valor_produt.setText("");

                    }
                }
            }
        );
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
