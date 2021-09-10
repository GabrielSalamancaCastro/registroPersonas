package com.valid.prueba.controller;


import com.valid.prueba.modelo.Persona;
import com.valid.prueba.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
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









}
