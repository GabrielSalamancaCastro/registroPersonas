package com.valid.prueba;

import com.valid.prueba.repository.configuracion.ConfigurationJDBC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class JDBCconfiguracionTest {

    @Test
    void connectionDB() {

        ConfigurationJDBC configuracionJDBC = new ConfigurationJDBC();
        Connection cn = configuracionJDBC.connectionDataBase();
        Assertions.assertNotNull(cn);

    }


}
