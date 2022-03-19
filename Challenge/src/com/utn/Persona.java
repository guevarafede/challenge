package com.utn;

public class Persona {
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;

    //Constructor por defecto
    public Persona() {
    }

    //Constructor con parametros
    public Persona(String nombre, String apellido, int telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    //Metodos setters y getters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String formato = "\nNOMBRE Y APELLIDO: %s %s \nTELEFONO: %d \nEMAIL: %s";
        return String.format(formato,getNombre(), getApellido(), getTelefono(), getEmail());
    }
}
