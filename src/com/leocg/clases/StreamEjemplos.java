package com.leocg.clases;

import com.leobas.impresion.Impresion;
import com.leocg.interfaces.Ejecucion;
import com.leocg.objectos.Persona;
import com.leocg.utilidades.GeneradorDePersonas;
import com.leocg.utilidades.RandomStringArrayGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Características Principales de los Streams
 * Declarativos:
 *
 * En lugar de escribir bucles explícitos para iterar sobre elementos, con los Streams puedes expresar operaciones de manera concisa y declarativa.
 * Operaciones en Cadena:
 *
 * Las operaciones de Stream pueden encadenarse para formar pipelines de procesamiento. Un Stream se procesa en varias etapas, donde cada operación se aplica secuencialmente.
 * Lazy Evaluation:
 *
 * Las operaciones intermedias en los Streams son "perezosas", lo que significa que no se ejecutan hasta que una operación terminal es invocada.
 * Inmutables:
 *
 * Los Streams no modifican la estructura original de los datos. En lugar de ello, producen un nuevo Stream con los resultados de las operaciones.
 * Paralelismo:
 *
 * Los Streams pueden ser procesados en paralelo para aprovechar múltiples núcleos de CPU, facilitando el procesamiento de grandes conjuntos de datos.
 * @param args
 */

/**
 * 1. Operaciones Intermedias:
 * Transforman un Stream en otro Stream.
 * Son operaciones "lazy", es decir, no se ejecutan hasta que se llama a una operación terminal.
 *
 * Ejemplos:
 *
 * filter(): Filtra elementos basándose en una condición.
 * map(): Aplica una función a cada elemento y produce un nuevo Stream con los resultados.
 * distinct(): Elimina elementos duplicados.
 * sorted(): Ordena los elementos.
 * flatMap(Function): Transforma cada elemento en un Stream y luego aplanado para crear un solo Stream.
 * peek(Consumer): Permite realizar alguna operación sobre cada elemento del Stream sin modificarlo.
 * limit(long): Limita el número de elementos del Stream a un valor máximo dado.
 * skip(long): Omite un número específico de elementos al comienzo del Stream
 * boxed(): Convierte un Stream de tipos primitivos en su correspondiente tipo de referencia (como de IntStream a Stream<Integer>).
 * takeWhile(Predicate) (desde Java 9): Toma los elementos mientras se cumple una condición y detiene la evaluación en el primer caso donde no se cumpla
 * dropWhile(Predicate) (desde Java 9): Descartar los elementos del Stream mientras se cumple una condición y comienza a procesar cuando ya no se cumpla.
 */

/**
 * Operaciones Terminales:
 * Finalizan el procesamiento del Stream y producen un resultado, como un valor, una colección, o simplemente consumen los elementos.
 * Ejemplos:
 *
 * collect(): Recolecta los elementos en una colección o en un valor agregado.
 * forEach(): Aplica una acción a cada elemento.
 * reduce(): Reduce los elementos a un solo valor, como una suma o concatenación.
 * count(): Devuelve el número de elementos en el Stream.
 */

public class StreamEjemplos implements Ejecucion {

    @Override
    public void ejecucion() {

        List<String> lista = RandomStringArrayGenerator.generateRandomStringArray(5, 15);
        Impresion.impresionNormal("---------Lista Aleatoria");
        Impresion.imprimirLista(lista);

        /**
         *          FILTER
         *
         *
         *
         */

        //FILTER
        List<String> listaFiltrada = lista.stream().filter(s -> s.length() > 8).collect(Collectors.toList());
        Impresion.impresionNormal("---------Lista Filtrada");
        Impresion.imprimirLista(listaFiltrada);
        //MAP

        /**
         *          MAP
         *
         * Transformación de Datos:
         *
         * map() toma una función como argumento y la aplica a cada elemento del Stream. El resultado es un nuevo Stream donde cada elemento es el resultado de la función aplicada al correspondiente elemento del Stream original.
         * Operación Intermedia:
         *
         * map() es una operación lazy (perezosa), lo que significa que no se ejecuta inmediatamente cuando se invoca. La transformación se realiza solo cuando se invoca una operación terminal, como collect() o forEach().
         * No Modifica el Stream Original:
         *
         * map() no altera el Stream original; en su lugar, crea un nuevo Stream con los elementos transformados.
         */
        Impresion.impresionNormal("---------Lista Mapeada");
        //Conversión de Tipos
        List<Integer> listaMapeadaInteger = lista.stream().map(s -> s.length()).collect(Collectors.toList());

        //Aplicar calculo
        List<String> listaMapeadaString = listaMapeadaInteger.stream().map(integer -> Integer.toString(integer * 2)).collect(Collectors.toList());
        Impresion.imprimirLista(listaMapeadaString);

        //Extraer o Modificar Propiedades de Objetos
        List<Persona> personas = GeneradorDePersonas.generarNPersonasAleatorias(10);
        List<String> personasString = personas.stream().map(Persona::toString).collect(Collectors.toList());
        Impresion.impresionNormal("---------Lista Personas");
        Impresion.imprimirLista(personasString);
        Impresion.impresionNormal("---------Lista Personas salarios extraidos");
        List<String> salarios = personas.stream().map(persona -> String.valueOf(persona.getSalario())).collect(Collectors.toList());
        Impresion.imprimirLista(salarios);

        /**
         *          DISTINCT
         *
         * Elimina duplicados:
         *
         * distinct() devuelve un Stream en el que cada elemento aparece una sola vez, eliminando aquellos que se repiten.
         * Internamente utiliza el método equals() para determinar si dos elementos son iguales.
         * Operación Intermedia:
         *
         * distinct() es una operación intermedia, lo que significa que produce un nuevo Stream y no realiza la operación hasta que se invoca una operación terminal, como collect() o forEach().
         * Eficiencia:
         *
         * En un Stream secuencial, el método distinct() utiliza un conjunto (Set) internamente para rastrear los elementos únicos, lo cual puede tener un impacto en el rendimiento si el Stream es muy grande.
         *
         * Consideraciones sobre distinct()
         * Sobrecarga en Objetos Personalizados:
         *
         * Cuando se trabaja con objetos personalizados, es crucial tener implementaciones correctas de los métodos equals() y hashCode() para que distinct() funcione como se espera.
         * Rendimiento:
         *
         * distinct() puede no ser la operación más eficiente si el Stream tiene una gran cantidad de datos, ya que puede implicar la creación de un conjunto en memoria para rastrear los elementos únicos.
         * Uso en Streams Paralelos:
         *
         * Aunque se puede usar distinct() en Streams paralelos, debes tener en cuenta que la eliminación de duplicados puede ser costosa y afectar el rendimiento en algunos casos.
         * Ventajas de distinct()
         * Simplifica la eliminación de duplicados en colecciones.
         * Funciona tanto con tipos primitivos como con objetos complejos, siempre que los métodos equals() y hashCode() estén correctamente implementados.
         */
        List<String> listaCadenasConRepetidos = RandomStringArrayGenerator.generarListadoCadenasConRepetidos(10, 3, 10);
        Impresion.impresionNormal("---------Lista Cadenas Con Repetidos");
        Impresion.imprimirLista(listaCadenasConRepetidos);

        List<String> listaSinRepetidos = listaCadenasConRepetidos.stream().distinct().collect(Collectors.toList());
        Impresion.impresionNormal("---------Lista Cadenas Sin Repetidos");
        Impresion.imprimirLista(listaSinRepetidos);

        /**
         *          SORTED
         *
         * El método sorted() en la API de Streams de Java es una operación intermedia que se utiliza para ordenar los elementos de un Stream. Este método puede trabajar con el orden natural de los elementos (si implementan la interfaz Comparable), o mediante un comparador (Comparator) personalizado.
         *
         * Tipos de sorted()
         * Orden natural (sorted()):
         *
         * Si los elementos del Stream implementan la interfaz Comparable (por ejemplo, String, Integer, etc.), se pueden ordenar según su orden natural. El orden natural para los números es ascendente, y para las cadenas de texto es lexicográfico.
         * Orden personalizado (sorted(Comparator)):
         *
         * También se puede especificar un comparador (Comparator) para definir un criterio de ordenación personalizado. Esto es útil cuando quieres ordenar por una propiedad específica de los objetos o en un orden diferente al natural (por ejemplo, descendente).
         * Características de sorted()
         * Operación Intermedia:
         *
         * sorted() es una operación intermedia, lo que significa que no produce el resultado inmediatamente. La operación se ejecuta solo cuando se invoca una operación terminal como collect().
         * Ordenación Estable:
         *
         * La ordenación en Streams es estable, lo que significa que si dos elementos son iguales según el criterio de ordenación, el orden relativo de los elementos en el Stream original se mantendrá en el Stream ordenado.
         *
         */

        Impresion.impresionNormal("---------Ordenar Lista Cadenas Sin Repetidos");
        List<String> listaSinRepetidosOrdenados = listaSinRepetidos.stream().sorted().collect(Collectors.toList());
        Impresion.imprimirLista(listaSinRepetidosOrdenados);

        Impresion.impresionNormal("---------Ordenar Reverso Lista Cadenas Sin Repetidos");
        List<String> listaSinRepetidosOrdenadosReverso = listaSinRepetidos.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Impresion.imprimirLista(listaSinRepetidosOrdenadosReverso);

        Impresion.impresionNormal("---------Ordenar Reverso Lista Personas por edad y nombre");
        List<String> listaPersonasOrdenadaReverso = personas.stream().sorted(Comparator.comparingInt(Persona::getEdad).thenComparing(Persona::getNombre).reversed()).map(Persona::toString).collect(Collectors.toList());
        Impresion.imprimirLista(listaPersonasOrdenadaReverso);
    }

}
