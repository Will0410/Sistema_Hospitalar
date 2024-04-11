package Application;

import Model.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Factory.ConexaoMySQL;
import Model.product;
import Model.userFunc;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class produt {


        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;

        private Connection connection;
        String id_produtos,nome_produto, valor_produto;

        public produt() {
            this.connection = new ConexaoMySQL().getConexaoMySQL();
            {
            }
        }

    public boolean adciona(product product) throws SQLException {
        String sql = "INSERT INTO produto(id_produtos,nome_produto,valor_produto)" + "VALUES (?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, product.getId_produt());
            stmt.setString(2, product.getNome_produt());
            stmt.setString(3, product.getValor_produt());
            boolean execute = stmt.execute();
            stmt.close();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }


        return false;
    }

    public product consultes(String id_produtos) throws SQLException {

        try {

            product produtos = new product();
            pstm = conn.prepareStatement("SELECT * FROM produto where id_produtos = ?");
            pstm.setString(1, id_produtos);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {

                produtos.setId_produt(String.valueOf(rs.getInt("id_produtos")));
                produtos.setNome_produt(rs.getString("nome_produto"));
                produtos.setValor_produt(rs.getString("valor_produto"));


                return produtos;
            } else {

                return null;
            }

        } catch (SQLException ex) {
            return null;
        }



    }

    public boolean conecte(){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplication?produto", "root","Ju04102005");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }
}

