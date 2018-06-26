package com.rgfp.psd.logbook.domain;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
        assertNotNull(contenido);
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
        assertTrue(largoPalabra==15);
        assertTrue(contenido.substring(0,15).equals(contenido));
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
        assertTrue(largoPalabra<15);
        assertTrue(contenido.equals(contenido));
    }

    @Test
    public void clonarNotaNotNull() {
        Note notaOriginal = new Note();
        Note notaClonada = new Note();
        notaClonada = notaOriginal.clone();
        assertNotNull(notaClonada);
    }


    @Test
    public void clonarNotaRetornaMismoTitulo(){
        Note notaOriginal = new Note();
        String titulo = "Titulo";
        notaOriginal.setTitle(titulo);
        Note notaClonada = notaOriginal.clone();
        assertTrue(notaClonada.getTitle().equals(notaOriginal.getTitle()));
    }

    @Test
    public void clonarNotaretornaMismoContenido(){
        Note notaOriginal = new Note();
        String contenido = "Contenido";
        notaOriginal.setContent(contenido);
        Note notaClonada = notaOriginal.clone();
        assertTrue(notaClonada.getContent().equals(notaOriginal.getContent()));
    }

    @Test
    public void clonarNotaRetornaDistintoId(){
        Note notaOriginal = new Note();
        notaOriginal.setId(123);
        Note notaClonada = notaOriginal.clone();
        assertTrue(notaClonada.getId()!=notaOriginal.getId());
    }

    @Test
    public void clonarNotaRetornaDistintaFecha(){
        Note notaOriginal = new Note();
        notaOriginal.setTimestamp(LocalDateTime.parse("2017-03-20T00:00"));
        Note notaClonada = notaOriginal.clone();
        assertTrue(!notaClonada.getTimestamp().equals(notaOriginal.getTimestamp()));
    }

}