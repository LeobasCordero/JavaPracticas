package com.leocg.utilidades;

import com.leocg.objectos.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneradorDePersonas {

    // Método para generar nombres aleatorios de una lista predefinida
    public static String generarNombreAleatorio() {
        String[] nombres = {"Juan", "Ana", "Carlos", "Lucía", "Pedro", "María", "Javier", "Sofía"};
        Random random = new Random();
        return nombres[random.nextInt(nombres.length)];
    }

    // Método para generar puestos aleatorios de una lista predefinida
    public static String generarPuestoAleatorio() {
        String[] puestos = {"Desarrollador", "Analista", "Gerente", "Diseñador", "Soporte Técnico", "Administrador"};
        Random random = new Random();
        return puestos[random.nextInt(puestos.length)];
    }

    // Método para generar una Persona con datos aleatorios
    public static Persona generarPersonaAleatoria() {
        Random random = new Random();
        String nombre = generarNombreAleatorio();
        int edad = random.nextInt(43) + 18;  // Edad entre 18 y 60 años
        int id = random.nextInt(10000);  // ID aleatorio entre 0 y 9999
        double salario = 30000 + (random.nextDouble() * 70000);  // Salario entre 30,000 y 100,000
        String puesto = generarPuestoAleatorio();

        return new Persona(nombre, edad, id, salario, puesto);
    }

    // Método para generar una lista de N personas con datos aleatorios
    public static List<Persona> generarNPersonasAleatorias(int n) {
        List<Persona> personas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            personas.add(generarPersonaAleatoria());
        }
        return personas;
    }

}
