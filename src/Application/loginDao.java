package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Factory.ConexaoMySQL;
import Model.user;

import javax.swing.*;


public class loginDao {

    Connection connection;
    public ResultSet autenticar(user objusername) {
        connection = new ConexaoMySQL().getConexaoMySQL();

        try {
            String sql = "select * from user where username = ? and password = ?";

            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, objusername.getUsername());
            pstm.setString(2, objusername.getPassword());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Usuario" + erro);
            return null;
        }


    }
}
