package com.leocg.utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomStringArrayGenerator {

    // Método para generar una cadena aleatoria
    public static String generateRandomString(int maxLength) {
        int length = new Random().nextInt(maxLength) + 1; // Longitud aleatoria entre 1 y maxLength
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }

        return randomString.toString();
    }

    // Método para generar un arreglo dinámico de cadenas aleatorias
    public static List<String> generateRandomStringArray(int numberOfStrings, int maxLength) {
        List<String> randomStrings = new ArrayList<>();

        for (int i = 0; i < numberOfStrings; i++) {
            randomStrings.add(generateRandomString(maxLength));
        }

        return randomStrings;
    }

    // Método para generar una lista de cadenas aleatorias con algunas repetidas
    public static List<String> generarListadoCadenasConRepetidos(int cantidadTotal, int cantidadRepetidas, int longitudCadena) {
        List<String> cadenas = new ArrayList<>();
        Random random = new Random();

        // Generar cadenas aleatorias únicas
        for (int i = 0; i < cantidadTotal - cantidadRepetidas; i++) {
            cadenas.add(generateRandomString(longitudCadena));
        }

        // Añadir algunas cadenas repetidas
        for (int i = 0; i < cantidadRepetidas; i++) {
            // Seleccionamos una cadena aleatoria ya existente y la agregamos de nuevo
            String cadenaRepetida = cadenas.get(random.nextInt(cadenas.size()));
            cadenas.add(cadenaRepetida);
        }

        return cadenas;
    }
}
