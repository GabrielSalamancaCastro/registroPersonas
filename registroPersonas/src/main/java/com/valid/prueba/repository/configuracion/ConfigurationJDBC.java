package com.valid.prueba.repository.configuracion;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConfigurationJDBC {

    private String JDBCDriver;
    private String URL;
    private String User;
    private String Pass;

    private static final Logger logger = Logger.getLogger(ConfigurationJDBC.class);

    /* ================ Getters y Setters ================= */

    public String getJDBCDriver() {
        return JDBCDriver;
    }

    public void setJDBCDriver(String JDBCDriver) {
        this.JDBCDriver = JDBCDriver;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    /* =================== Métodos ===================== */

    public Connection connectionDataBase() {

        Connection cn = null;

        try {
            Class.forName(JDBCDriver);
            cn = DriverManager.getConnection(URL, User, Pass);
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error " + e.getMessage());
            e.printStackTrace();
        }

        return cn;
    }

    public Statement statementDB() {

        Connection cn = connectionDataBase();
        Statement st = null;

        try {
            st = cn.createStatement();
        } catch (SQLException e) {
            logger.error("Error" + e.getMessage());
            e.printStackTrace();
        }

        return st;

    }

    /* =================== Constructor ===================== */

    public ConfigurationJDBC(String JDBCDriver, String URL, String user, String pass) {
        this.JDBCDriver = JDBCDriver;
        this.URL = URL;
        User = user;
        Pass = pass;
    }

    public ConfigurationJDBC() {
        JDBCDriver = "org.h2.Driver";
        URL = "jdbc:h2:~/test3;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'create.sql'";
        User = "sa";
        Pass = "";

    }

}