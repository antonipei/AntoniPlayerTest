package com.antonipeiro.tema5player;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeAll
    static void iniciar(){
        System.out.println("Iniciando");
    }

    //Hacer que BeforeEach cree su propio player y que despues se destruya con un AfterEach

    @BeforeEach
    void setUp() {
        // se crea player
        player = new Player("Jugador Test", 50, 4);
        System.out.println("Player creado");
    }

    @AfterEach
    void tearDown() {
        // se destruye player
        player = null;
        System.out.println("Player destruido");
    }

    @Test
    void curarSumaVida() {

        player.curar(5);
        assertEquals(10, player.getVida());
    }

    @Test
    void curarNoSuperaMaximo() {

        player.curar(5);
        assertTrue(player.getVida() <= 100);
    }

    @Test
    void curarMuertoNoFunciona() {

        player.recibirDanyo(10);
        player.curar(5);
        assertEquals(0, player.getVida());
    }

    @AfterAll
    static void finalizar(){
        System.out.println("Finalizando");
    }

}