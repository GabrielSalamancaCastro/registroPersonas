package com.valid.prueba.repository.implementacion;

import com.valid.prueba.modelo.Persona;
import com.valid.prueba.repository.Idao;
import com.valid.prueba.repository.configuracion.ConfigurationJDBC;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PersonaDaoH2 implements Idao<Persona> {
    // ==== ATRIBUTOS =======
    private ConfigurationJDBC configuracionJDBC;
    private static final Logger logger = Logger.getLogger(PersonaDaoH2.class);


    // ===== CONSTRUCTORES ========
    public PersonaDaoH2(ConfigurationJDBC configuracionJDBC) {
        this.configuracionJDBC = configuracionJDBC;
    }

    public PersonaDaoH2() {
        configuracionJDBC = new ConfigurationJDBC();
    }

    // ====== GETTERS AND SETTERS =======
    public ConfigurationJDBC getConfiguracionJDBC() {
        return configuracionJDBC;
    }

    public void setConfiguracionJDBC(ConfigurationJDBC configuracionJDBC) {
        this.configuracionJDBC = configuracionJDBC;
    }

    // ======== METODOS DE LA INTERFAZ ==============

    @Override
    public void clear() {

        Connection connection = configuracionJDBC.connectionDataBase();
        Statement statement = configuracionJDBC.statementDB();

        String query = "TRUNCATE TABLE Personas RESTART IDENTITY;" + "TRUNCATE TABLE LOGS RESTART IDENTITY ";

        try {
            statement.executeUpdate(query);
            logger.debug("Base de datos Personas limpiada....");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.error("Error: " + e.getMessage());
        }
    }

    @Override
    public Persona insertInto(Persona persona) {

        Connection connection = configuracionJDBC.connectionDataBase();
        Statement statement = configuracionJDBC.statementDB();


        String query = String.format("INSERT INTO Personas (Nombre, Apellido, Procesado) VALUES ('%s', '%s', '%s')",persona.getNombre(),persona.getApellido(),persona.getProcesado());

        try{
            statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet IdKey = statement.getGeneratedKeys();

            if(IdKey.next()){
                persona.setId(IdKey.getInt(1));
                logger.debug("Correcta inserción en la base de datos Personas, ID: " + IdKey.getInt(1));
            }

            statement.close();
            connection.close();

        }catch(SQLException e){
            logger.error("Error: " + e.getMessage());
        }

        return persona;
    }

    @Override
    public void delete(Integer id) {

        Connection connection = configuracionJDBC.connectionDataBase();
        Statement statement = configuracionJDBC.statementDB();

        String query = String.format("DELETE FROM Personas WHERE ID = %d",id);

        try{
            statement.executeUpdate(query);
            logger.info("Campo eliminado en la tabla Personas, ID: " + id);

            statement.close();
            connection.close();

        }catch(SQLException e){
            logger.error("Error: " + e.getMessage());
            //e.printStackTrace();
        }

    }

    @Override
    public Persona update(Persona persona) {

        Connection connection = configuracionJDBC.connectionDataBase();
        Statement statement = configuracionJDBC.statementDB(); // Statement st = cn.createStatement();


        String query = String.format("UPDATE Personas SET Nombre = %d, Apellido = '%s', Procesado = '%s' WHERE ID = %d", persona.getNombre(), persona.getApellido(), persona.getProcesado(), persona.getId());

        try{
            statement.executeUpdate(query);
            logger.debug("Datos actualizados en la tabla Personas, ID: " + persona.getId());

            statement.close();
            connection.close();

        }catch(SQLException e){
            logger.error("Error: " + e.getMessage());
            //e.printStackTrace();
        }
        return search(persona.getId());
    }

    @Override
    public Persona search(Integer id) {

        Connection connection = configuracionJDBC.connectionDataBase();
        Statement statement = configuracionJDBC.statementDB(); // Statement st = cn.createStatement();
        Persona persona = null;


        String query = String.format("SELECT * FROM Personas WHERE ID = %d",id);

        try{
            ResultSet rd = statement.executeQuery(query);
            logger.debug("Búsqueda realizada en la tabla Personas, ID: " + id);

            while(rd.next()){
                persona = new Persona(rd.getString(2),rd.getString(3),rd.getString(4));
                persona.setId(rd.getInt(1));
            }
            statement.close();
            connection.close();

        }catch(SQLException e){
            logger.error("Error: " + e.getMessage());
            //e.printStackTrace();
        }

        return persona;
    }

    @Override
    public List<Persona> searchAll() {

        Connection connection = configuracionJDBC.connectionDataBase();
        Statement statement = configuracionJDBC.statementDB(); // Statement st = cn.createStatement();

        String query = "SELECT * FROM Personas;";
        List<Persona> personas = new ArrayList<>();

        try{
            ResultSet rd = statement.executeQuery(query);
            logger.debug("Búsqueda realizada en toda la tabla de Personas");

            while(rd.next()){
                Persona persona = new Persona(rd.getString(2),rd.getString(3), rd.getString(4));
                persona.setId(rd.getInt(1));
                personas.add(persona);
            }
            statement.close();
            connection.close();

        }catch (SQLException e){
            logger.error("Error: " + e.getMessage());
            //e.printStackTrace();
        }

        return personas;

    }












}
