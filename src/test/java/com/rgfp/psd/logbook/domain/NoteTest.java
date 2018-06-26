package com.rgfp.psd.logbook.domain;

import org.junit.Assert;
import org.junit.Test;

public class NoteTest {


    private Note note = new Note();

    // your tests here

    @Test
    public void retornaAlgo(){
        //Arrange
        String contenido="12345678901234567890";
        //ACT
        note.setContent(contenido);
        contenido = note.getSummary();
        //ASSERT
        Assert.assertNotNull(contenido);
    }

    @Test
    public void retornaSoloQuinceCaracteres(){
        //Arrange
        String contenido="12345678901234567890";
        //ACT
        note.setContent(contenido);
        contenido = note.getSummary();
        int largoPalabra = contenido.length();
        //ASSERT
        Assert.assertTrue(largoPalabra==15);
        Assert.assertTrue(contenido.substring(0,15).equals(contenido));
    }

    @Test
    public void retornaMenosDeQuinceCaracteres(){
        //Arrange
        String contenido="1234567890";
        //ACT
        note.setContent(contenido);
        contenido = note.getSummary();
        int largoPalabra = contenido.length();
        //ASSERT
        Assert.assertTrue(largoPalabra<15);
        Assert.assertTrue(contenido.equals(contenido));
    }
}