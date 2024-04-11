package Application;

import Factory.ConexaoMySQL;
import Model.user;
import Model.userFunc;

import java.sql.*;

public class application {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    private Connection connection;
    String func_id,username, email, password, age, proced;

    public application() {
        this.connection = new ConexaoMySQL().getConexaoMySQL();
        {
        }
    }

    public boolean adciona(user User) throws SQLException {
        String sql = "INSERT INTO Users(user_id,username,email,password,age,proced)" + "VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, User.getUser_id());
            stmt.setString(2, User.getUsername());
            stmt.setString(3, User.getEmail());
            stmt.setString(4, User.getPassword());
            stmt.setString(5, User.getAge());
            stmt.setString(6, User.getProced());
            boolean execute = stmt.execute();
            stmt.close();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }


        return false;
    }

    public user consult(String user_id) throws SQLException {

        try {

            user objUser = new user();
            pstm = conn.prepareStatement("SELECT * FROM users where user_id = ?");
            pstm.setString(1, user_id);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {

                objUser.setUser_id(rs.getString("user_id"));
                objUser.setUsername(rs.getString("username"));
                objUser.setEmail(rs.getString("email"));
                objUser.setPassword(rs.getString("password"));
                objUser.setAge(rs.getString("age"));
                objUser.setProced(rs.getString("proced"));


                return objUser;
            } else {

                return null;
            }

        } catch (SQLException ex) {
            return null;
        }



    }

    public boolean conec(){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplication?users", "root","Ju04102005");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }



}



