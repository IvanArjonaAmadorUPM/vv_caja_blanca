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

    private Editor miEditor;
    private AbstractSingleLinkedListImpl<String> miLista;

    private String serialize(Editor editor) throws EmptyCollectionException{
        String edit="";
        int i = 1;
        if (editor.size()>0) {
            while (i <= editor.size()) {
                edit += editor.getLinea(i).toString();
                edit +=":";
            }
        }
        return edit;
    }

    @DisplayName("Caso de prueba 1")
    @Test
    public void test_sustituirPalabraEditorVacio(){
        Editor editor = new Editor();
        assertThrows(EmptyCollectionException.class, () -> {
            editor.sustituirPalabra("","");
        });
    }

    @DisplayName("Caso de prueba 3")
    @ParameterizedTest(name = "{index} => palabra={0}, sustituto={1}")
    @CsvSource(value = {
            "world:mundo"
    },
            delimiter = ':')

    public void test_sustituirPalabraNoCambio(String palabra, String sustituto) throws EmptyCollectionException{
        Editor editor = new Editor();
        editor.leerFichero("palabras.txt");
        String previo = this.serialize(editor);
        editor.sustituirPalabra(palabra,sustituto);
        String posterior = this.serialize(editor);
        assertEquals(previo, posterior);
    }



}

