package fabrica;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public DataSource fonteDados;

    public ConexaoFactory() {

        /**Esse objeto vem do c3p0*/
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        /**Seto as informações no objeto que vai ser o nosso pool*/
        comboPooledDataSource
                .setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimeZone=true&serverTimeZone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("luquinhas123");

        /**A vantagem dessa pool é poder setar a quantidade de pool que elá podera ter, eu falei que
         * é no máximo 10 conexão simultâneas*/
        comboPooledDataSource.setMaxPoolSize(10);

        /**E exponho para minha aplicação através da interface DataSource*/
        this.fonteDados = comboPooledDataSource;

    }

    public Connection criarConexao(){
        /**Agora eu retorno minha conexão através do meu DataSource que vai buscar uma
         * conexão do pool*/
        try {
            return fonteDados.getConnection();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao criar conexão: "+exception.getMessage());
        }
    }
}
