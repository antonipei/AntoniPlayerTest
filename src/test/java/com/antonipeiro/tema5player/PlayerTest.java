package com.antonipeiro.tema5player;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @BeforeAll
    static void iniciar(){
        System.out.println("Iniciando");
    }

    //Hacer que BeforeEach cree su propio player y que despues se destruya con un AfterEach

    @Test
    void curarSumaVida() {
        Player player = new Player("Toni Peperonni", 5, 4);

        player.curar(5);
        assertEquals(10, player.getVida());
    }

    @Test
    void curarNoSuperaMaximo() {
        Player player = new Player("Danylo Vladimir Vladivoskov", 96, 4);

        player.curar(5);
        assertTrue(player.getVida() <= 100);
    }

    @Test
    void curarMuertoNoFunciona() {
        Player player = new Player("Andres Colombiano", 5, 4);

        player.recibirDanyo(10);
        player.curar(5);
        assertEquals(0, player.getVida());
    }

    @AfterAll
    static void finalizar(){
        System.out.println("Finalizando");
    }

}