package Documentação;

// imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe Etapa3 para conexão com o banco de dados.
 */
public class Etapa3 {

    /**
     * Classe usuário.
     */
    public class User {

        /**
         * Conecta ao banco de dados MySQL.
         *
         * @return Uma conexão com o banco de dados.
         */
        public Connection conectarBD(){
            Connection conn = null;
            try{
                // Carrega o driver do MySQL
                Class.forName("com.mysql.Driver.Manager").newInstance();
                String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
                conn = DriverManager.getConnection(url);
            } catch (Exception e) {
                // Exceções em caso de erro na conexão
            }
            return conn;
        }

        /**
         * Nome do usuário.
         */
        public String nome = "";

        /**
         * Verificação do usuário (verdadeiro ou falso).
         */
        public boolean result = false;

        /**
         * Verifica se o usuário e a senha fornecidos estão corretos no banco de dados.
         *
         * @param login Nome a ser verificado.
         * @param senha Senha a ser verificada.
         * @return Verdadeiro se o usuário for encontrado, falso caso contrário.
         */
        public boolean verificarUsuario(String login, String senha) {
            String sql = "";
            Connection conn = conectarBD();
            // INSTRUÇÃO SQL para verificar o usuário e senha no banco de dados
            sql += "select nome from usuarios ";
            sql +="where login = " + "'" + login + "'";
            sql += " and senha = " + "'" + senha + "';";
            try{
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    result = true;
                    nome = rs.getString("nome");
                }
            } catch (Exception e) {
                // Lidar com exceções em caso de erro na consulta SQL
            }
            return result;
        }
    } // fim da classe User
}