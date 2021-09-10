package com.valid.prueba.modelo;

public class Persona {
    // === ATRIBUTOS =========
    private Integer id;
    private String nombre;
    private String apellido;
    private String procesado;

    // ========= CONSTRUCTORES ==============

    public Persona(String nombre, String apellido, String procesado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.procesado = procesado;
    }

    // ===== GETTERS AND SETTERS ================


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProcesado() {
        return procesado;
    }

    public void setProcesado(String procesado) {
        this.procesado = procesado;
    }
}
