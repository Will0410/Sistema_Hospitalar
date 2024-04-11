package Application;

import Factory.ConexaoMySQL;
import Model.userFunc;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class CadFunc {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    ArrayList<userFunc> list = new ArrayList<>();


    private Connection connection;
    String func_id, name_func, tel_func, pass_func, cargo_func, email_func;

    public CadFunc() {
        this.connection = new ConexaoMySQL().getConnectionMySQL();
        {
        }
    }

    public void cadFunc(userFunc UserFunc) throws SQLException {
        String sql = "INSERT INTO Func(func_id,name_func,email_func,tel_func,pass_func,cargo_func)" + "VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1, UserFunc.getFunc_id());
            pstm.setString(2, UserFunc.getName_func());
            pstm.setString(3, UserFunc.getEmail_func());
            pstm.setString(4, UserFunc.getTel_func());
            pstm.setString(5, UserFunc.getPass_func());
            pstm.setString(6, UserFunc.getCargo_func());
            boolean execute = pstm.execute();
            pstm.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }


    }

    public ArrayList<userFunc> pesquisar() {

        conn = new ConexaoMySQL().getConnectionMySQL();
        String sql = "select * from func where id_func = ? and name_func = ? and email_func = ? and tel_func = ? and pass_func = ? and cargo_func = ? ";

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                userFunc objfunDTO = new userFunc();
                objfunDTO.setFunc_id(rs.getInt("func_id"));
                objfunDTO.setName_func(rs.getString("name_func"));
                objfunDTO.setEmail_func(rs.getString("email_func"));
                objfunDTO.setTel_func(rs.getString("tel_func"));
                objfunDTO.setPass_func(rs.getString("pass_func"));
                objfunDTO.setCargo_func(rs.getString("cargo_func"));

                list.add(objfunDTO);

            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "FuncionarioDao pesquisar" + erro);
        }

        return list;

    }

    public boolean conect(){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplication?func", "root","Ju04102005");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }

    public userFunc consulta(String func_id) throws SQLException {

        try {

            userFunc funcUser = new userFunc();
            pstm = conn.prepareStatement("SELECT * FROM func where func_id = ?");
            pstm.setString(1, func_id);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {

                funcUser.setFunc_id(rs.getInt("func_id"));
                funcUser.setName_func(rs.getString("name_func"));
                funcUser.setEmail_func(rs.getString("email_func"));
                funcUser.setTel_func(rs.getString("tel_func"));
                funcUser.setCargo_func(rs.getString("cargo_func"));

                return funcUser;
            } else {

                return null;
            }

        } catch (SQLException ex) {
            return null;
        }



    }


}



