package com.valid.prueba.controller;


import com.valid.prueba.modelo.Persona;
import com.valid.prueba.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class PersonaController {

    // ===== ATRIBUTOS ========
    @Autowired
    private PersonaService personaService;


    // ===== METODO POST =======
    @PostMapping()
    public Persona insertInto(@RequestBody Persona persona) {
        return personaService.insertInto(persona);
    }




    // ===== METODOS GET ======
    @GetMapping("/{id}")
    public Persona search(@PathVariable Integer id) {
        return personaService.search(id);
    }

    @GetMapping("/todos")
    public List<Persona> searchAll() {
        return personaService.searchAll();
    }



    //=== METODO DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;
            personaService.delete(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");


        return response;
    }


    @PutMapping()
    public ResponseEntity<Persona> actualizar(@RequestBody Persona persona) {
        ResponseEntity<Persona> response = null;

            response = ResponseEntity.ok(personaService.update(persona));

        return response;
    }







}
