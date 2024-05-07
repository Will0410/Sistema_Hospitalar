package Factory;



//Classes necessárias para uso de Banco de dados //

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;



//Início da classe de conexão//

public class ConexaoMySQL {

    Connection connection;

    public static String status = "Não conectou...";


    public ConexaoMySQL() {

    }



//Método de Conexão//

    public static java.sql.Connection getConexaoMySQL() {

        Connection connection = null;

        try {

// Carregando o JDBC Driver padrão

            String driverName = "com.mysql.cj.jdbc.Driver";

            Class.forName(driverName);



// Configurando a nossa conexão com um banco de dados//

            String serverName = "localhost";    //caminho do servidor do BD

            String mydatabase ="mysql";        //nome do seu banco de dados

            String url = "jdbc:mysql://localhost:3306/aplication?users";

            String username = "root";        //nome de um usuário de seu BD

            String password = "Ju04102005";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);





            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }



            return connection;



        } catch (ClassNotFoundException e) {  //Driver não encontrado



            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {



            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }



    }

    public static java.sql.Connection getConnectionMySQL() {

        Connection connection = null;          //atributo do tipo Connection



        try {

// Carregando o JDBC Driver padrão

            String driverName = "com.mysql.cj.jdbc.Driver";

            Class.forName(driverName);



// Configurando a nossa conexão com um banco de dados//

            String serverName = "localhost";    //caminho do servidor do BD

            String mydatabase ="mysql";        //nome do seu banco de dados

            String url = "jdbc:mysql://localhost:3306/aplication?func";

            String username = "root";        //nome de um usuário de seu BD

            String password = "Ju04102005";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);


            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }



            return connection;



        } catch (ClassNotFoundException e) {  //Driver não encontrado



            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

//Não conseguindo se conectar ao banco

            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }
    }


    //Método que retorna o status da sua conexão//

    public static String statusConection() {

        return status;

    }

    public static boolean FecharConexao() {

        try {

            ConexaoMySQL.getConnectionMySQL().close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }

    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();

        return ConexaoMySQL.getConexaoMySQL();

    }
    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplication?func", "root", "Ju04102005");
            return true;
        } catch (SQLException | ClassNotFoundException var2) {
            return false;

        }

    }


}
