package jsp;

import Factory.ConexaoMySQL;
import Application.CadFunc;
import static java.lang.System.out;

public class jsp {

        public static void main(String[] args) {



            out.println(ConexaoMySQL.statusConection());
        }
    }
