package com.practica.cajablanca;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MayorLongitudTests {

    Editor editor = new Editor();
    private AbstractSingleLinkedListImpl<String> miLista;

    @DisplayName("caso de prueba 1")
    @Test
    public void test_MayorLongitud1() throws EmptyCollectionException {
        assertEquals(null, editor.mayorLongitud());
    }


    @DisplayName("caso de prueba 3")
    @Test
    public void test_MayorLongitud3() throws EmptyCollectionException {
        editor.leerFichero("src/archivoVacio.txt");
        assertEquals(null, editor.mayorLongitud());
    }


    @DisplayName("caso de prueba 4")
    @Test
    public void test_MayorLongitud4() throws EmptyCollectionException {
        editor.leerFichero("src/mayorLongitud1.txt");
        assertEquals("hola", editor.mayorLongitud());
    }

    @DisplayName("caso de prueba 6")
    @Test
    public void test_MayorLongitud6() throws EmptyCollectionException {
        editor.leerFichero("src/mayorLongitud2.txt");
        assertEquals("holaMundo", editor.mayorLongitud());
    }




}
