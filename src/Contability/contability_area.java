package Contability;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Application.CadFunc;
import Model.product;
import Application.produt;
import Model.userFunc;
import Application.application;

public class contability_area extends javax.swing.JFrame{
    private JTextField txt_produto_;
    private JTextField txt_valor_produto;
    private JButton calcularButton;
    private JTextField txt_id_produto;
    private JTextField txt_quantidade_vendida;
    private JButton consultarButton;
    private JPanel painel_contability;
    private JTextField txt_valor_lucro;


    public contability_area() {

        setContentPane(painel_contability);
        setSize(300, 300);



        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double n1 = Double.parseDouble(txt_valor_produto.getText());
                double n2 = Double.parseDouble(txt_quantidade_vendida.getText());
                double resultado = n1+((n1/100)*n2);
                double resultadoLucro = resultado-n1;
                txt_valor_produto.setText(String.valueOf(resultado));
                txt_valor_lucro.setText(String.valueOf(resultadoLucro));
        }
        });

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                produt produt;
                product product;
                boolean status;
                int resp;
                String id_produt;

                id_produt = txt_id_produto.getText();

                produt productes = new produt();

                status = productes.conecte();
                if (status  == true){
                    product producte = null;
                    try {
                        producte = productes.consultes(id_produt);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (producte==null){
                        JOptionPane.showMessageDialog(null,"Produto não localizado");
                    }else{
                        txt_id_produto.setText(String.valueOf(producte.getId_produt()));
                        txt_produto_.setText(producte.getNome_produt());
                        txt_valor_produto.setText(producte.getValor_produt());
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
                }
            }
        });
    }
}
