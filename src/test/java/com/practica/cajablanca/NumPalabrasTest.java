package com.practica.cajablanca;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumPalabrasTest {


    private AbstractSingleLinkedListImpl<String> lista;
    Editor editor = new Editor();

    @DisplayName("Caso de prueba 1")
    @ParameterizedTest(name = "{index} => inicio={0}, fin={1}, palabra={2}")
    @CsvSource(value = {
            "-1:10:hola"
    },
            delimiter = ':')

    public void prueba1(int inicio, int fin, String palabra){
        editor.leerFichero("numPalabras.txt");
        assertThrows(IllegalArgumentException.class, () -> {
            editor.numPalabras(inicio,fin,palabra);
        });
    }


    @DisplayName("Caso de prueba 2")
    @ParameterizedTest(name = "{index} => inicio={0}, fin={1}, palabra={2}")
    @CsvSource(value = {
            "1:10:hola"
    },
            delimiter = ':')

    public void prueba2(int inicio, int fin, String palabra){
        editor.leerFichero("numPalabras.txt");
        assertThrows(IllegalArgumentException.class, () -> {
            editor.numPalabras(inicio,fin,palabra);
        });
    }


    @DisplayName("Caso de prueba 3")
    @ParameterizedTest(name = "{index} => inicio={0}, fin={1}, palabra={2}")
    @CsvSource(value = {
            "1:0:hola"
    },
            delimiter = ':')

    public void prueba3(int inicio, int fin, String palabra){
        editor.leerFichero("numPalabrasVacio.txt");
        assertEquals(editor.numPalabras(inicio,fin,palabra),0);
    }

    @DisplayName("Caso de prueba 4")
    @ParameterizedTest(name = "{index} => inicio={0}, fin={1}, palabra={2}")
    @CsvSource(value = {
            "1:0:hola"
    },
            delimiter = ':')

    public void prueba4(int inicio, int fin, String palabra){
        editor.leerFichero("numPalabras.txt");
        assertEquals(editor.numPalabras(inicio,fin,palabra),0);
    }



    @DisplayName("Caso de prueba 6")
    @ParameterizedTest(name = "{index} => inicio={0}, fin={1}, palabra={2}")
    @CsvSource(value = {
            "1:5:hola"
    },
            delimiter = ':')

    public void prueba6(int inicio, int fin, String palabra){
        editor.leerFichero("numPalabras.txt");
        assertEquals(editor.numPalabras(inicio,fin,palabra),4);
    }

    @DisplayName("Caso de prueba 7")
    @ParameterizedTest(name = "{index} => inicio={0}, fin={1}, palabra={2}")
    @CsvSource(value = {
            "1:5:salchicha"
    },
            delimiter = ':')

    public void prueba7(int inicio, int fin, String palabra){
        editor.leerFichero("numPalabras.txt");
        assertEquals(editor.numPalabras(inicio,fin,palabra),0);
    }
}










