package com.valid.prueba.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.valid.prueba.modelo.Persona;
import com.valid.prueba.repository.Idao;
import com.valid.prueba.repository.implementacion.PersonaDaoH2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    // ===== ATRIBUTOS =============
    private Idao<Persona> personaIDao;

    //====== CONSTRUCTOR ==========
    public PersonaService(Idao<Persona> personaIDao) {
        this.personaIDao = personaIDao;
    }
    public PersonaService(){
        personaIDao= new PersonaDaoH2();
    }

    // ===== GETTERS AND SETTERS =====
    public Idao<Persona> getPersonaIDao() {
        return personaIDao;
    }

    public void setPersonaIDao(Idao<Persona> personaIDao) {
        this.personaIDao = personaIDao;
    }


    // ======== METODOS ===========
    public void clear(){
        personaIDao.clear();
    }

    public Persona insertInto(Persona odontologo){
        return personaIDao.insertInto(odontologo);
    }

    public void delete(Integer id){
        personaIDao.delete(id);
    }

    public Persona update(Persona odontologo){
        return personaIDao.update(odontologo);
    }

    public Persona search(Integer id){
        return personaIDao.search(id);
    }

    public List<Persona> searchAll(){
        return personaIDao.searchAll();
    }



}
