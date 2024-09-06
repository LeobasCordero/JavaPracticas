package com.leocg.objectos;

public class Persona {
    private String nombre;
    private int edad;
    private int id;
    private double salario;
    private String puesto;

    // Constructor para inicializar todos los atributos
    public Persona(String nombre, int edad, int id, double salario, String puesto) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.salario = salario;
        this.puesto = puesto;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", id=" + id +
                ", salario=" + salario +
                ", puesto='" + puesto + '\'' +
                '}';
    }
}



