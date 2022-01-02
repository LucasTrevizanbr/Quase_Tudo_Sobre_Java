package fabricas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    public Connection criarConexao() throws SQLException {
        return  DriverManager.getConnection
                ("jdbc:mysql://localhost/loja_virtual?useTimeZone=true&serverTimeZone=UTC"
                        ,"root","luquinhas123");
    }
}
