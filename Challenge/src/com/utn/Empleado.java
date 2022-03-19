package com.utn;

public class Empleado extends Persona{
    private double salario;
    private int antiguedad;
    private String puestoDeTrabajo;
    private Municipalidad municipio;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int telefono, String email, double salario, int antiguedad, String puestoDeTrabajo, Municipalidad municipio) {
        super(nombre, apellido, telefono, email);
        this.salario = salario;
        this.antiguedad = antiguedad;
        this.puestoDeTrabajo = puestoDeTrabajo;
        this.municipio = municipio;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getPuestoDeTrabajo() {
        return puestoDeTrabajo;
    }

    public void setPuestoDeTrabajo(String puestoDeTrabajo) {
        this.puestoDeTrabajo = puestoDeTrabajo;
    }

    public Enum getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(Municipalidad municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        String formato = "\nSALARIO: $%.2f \nANTIGUEDAD: %d años. \nCARGO: %s \nMUNICIPIO: %s";
        return super.toString() + String.format(formato,getSalario(),getAntiguedad(),getPuestoDeTrabajo(), getMunicipio());
    }
}
