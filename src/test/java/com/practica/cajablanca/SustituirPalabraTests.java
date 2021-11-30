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


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SustituirPalabraTests {

    private AbstractSingleLinkedListImpl<String> miLista;
    Editor editor = new Editor();

    private String serialize(Editor editor) throws EmptyCollectionException{
        String edit="";
        int i = 1;
        if (editor.size()>0) {
            while (i <= editor.size()) {
                edit += editor.getLinea(i).toString();
                i++;
            }
        }
        return edit;
    }

    @DisplayName("Caso de prueba 1")
    @ParameterizedTest(name = "{index} => palabra={0}, sustituto={1}, esperado={2}")
    @CsvSource(value = {
            "hola:hello:Excepcion"
    },
            delimiter = ':')

    public void test_sustituirPalabraEditorVacio(String palabra, String sustituto, String esperado){
        this.editor = new Editor();
        assertThrows(EmptyCollectionException.class, () -> {
            editor.sustituirPalabra(palabra,sustituto);
        });
    }

    @DisplayName("Caso de prueba 3")
    @ParameterizedTest(name = "{index} => palabra={0}, sustituto={1}, esperado={2}")
    @CsvSource(value = {
            "hola:hello:[hello]"
    },
            delimiter = ':')

    public void test_sustituirPalabraCambio(String palabra, String sustituto, String esperado) throws EmptyCollectionException{
        this.editor = new Editor();
        this.editor.leerFichero("src/sustituirPalabra1palabra.txt");
        this.editor.sustituirPalabra(palabra,sustituto);
        String posterior = this.serialize(editor);
        assertEquals(posterior, esperado);

    }

    @DisplayName("Caso de prueba 4")
    @ParameterizedTest(name = "{index} => palabra={0}, sustituto={1}")
    @CsvSource(value = {
            "mundo:world"
    },
            delimiter = ':')

    public void test_sustituirPalabraNoCambio(String palabra, String sustituto) throws EmptyCollectionException{
        this.editor = new Editor();
        this.editor.leerFichero("src/sustituirPalabra1palabra.txt");
        String previo = serialize(this.editor);
        this.editor.sustituirPalabra(palabra,sustituto);
        String posterior = serialize(this.editor);
        assertEquals(previo, posterior);
    }

    @DisplayName("Caso de prueba 5")
    @ParameterizedTest(name = "{index} => palabra={0}, sustituto={1}, esperado={2}")
    @CsvSource(value = {
            "mundo:world:[hola][world]"
    },
            delimiter = ':')

    public void test_sustituirPalabraCambioFinal(String palabra, String sustituto, String esperado) throws EmptyCollectionException{
        this.editor = new Editor();
        this.editor.leerFichero("src/sustituirPalabra2palabras.txt");
        this.editor.sustituirPalabra(palabra,sustituto);
        String posterior = this.serialize(editor);
        assertEquals(posterior, esperado);

    }




}

