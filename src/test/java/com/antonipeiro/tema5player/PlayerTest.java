package com.antonipeiro.tema5player;

import com.antonipeiro.tema5player.config.config;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    /*
    void constructorPlayer() {
        final String nombre = "Jugador Test";
        final int vida = 50;
        final int ataque = 5;
        Player player = new Player(nombre, vida, ataque);
        assertEquals(nombre, player.getNombre());
        assertEquals(vida, player.getVida());
        assertEquals(ataque, player.getAtaque());
        System.out.println("Player construido correctamente");
    }
    */

    /* -------------------------------------------
    ---------------- CONSTRUCTOR -----------------
    -------------------------------------------- */

    @Test
    void constructorInicializaInstanciaCorrectamente() {
        assertEquals(config.playerNombre, player.getNombre());
        assertEquals(config.playerVida, player.getVida());
        assertEquals(config.playerAtaque, player.getAtaque());
    }

    @Test
    void constructorNoPermiteVidaNegativa(){
        assertThrows(IllegalArgumentException.class, () ->
            {player = new Player("Jugador Test", -10, 20);
            });
    }

    @Test
    void constructorNoPermiteSuperarVidaMaxima(){
        assertThrows(IllegalArgumentException.class, () ->
            {player = new Player("Jugador Test", 1000, 20);
            });
    }

    @Test
    void constructorNoPermiteAtaqueNegativo(){
        assertThrows(IllegalArgumentException.class, () ->
            {player = new Player("Jugador Test", 20, -10);
            });
    }

    @Test
    void constructorNoPermiteAtaqueMaxima(){
        assertThrows(IllegalArgumentException.class, () ->
            {player = new Player("Jugador Test", 20, 1000);
            });
    }


    /* -------------------------------------------
    -------------- BEFORE / AFTER ----------------
    -------------------------------------------- */

    @BeforeAll
    static void iniciar(){
        System.out.println("Iniciando");
    }

    @BeforeEach
    void construirPLayer() {
        // se crea player
        player = new Player(config.playerNombre, config.playerVida, config.playerAtaque);
        System.out.println("Player creado");
    }

    @AfterEach
    void destruirPlayer() {
        // se destruye player
        player = null;
        System.out.println("Player destruido");
    }

    @AfterAll
    static void finalizar(){
        System.out.println("Finalizando");
    }

    /* -------------------------------------------
    ---------------- CURAR VIDA -----------------
    -------------------------------------------- */

    @Test
    void curarSumaVida() {

        player.curar(5);
        assertEquals(55, player.getVida());
    }

    @Test
    void curarNoSuperaMaximo() {

        player.curar(player.getVida());
        assertTrue(player.getVida() <= 100);
    }

    @Test
    void curarMuertoNoFunciona() {

        player.recibirDanyo(player.getVida());
        player.curar(5);
        assertEquals(0, player.getVida());
    }

    /* -------------------------------------------
    ---------------- RECIBIR DAÑO ----------------
    -------------------------------------------- */

    @Test
    void recibirDanyoNoPermiteVidaNegativa() {
        player.recibirDanyo(player.getVida() + 10);
        assertEquals(0, player.getVida());
    }

    @Test
    void recibirDanyoReduceVida() {
        player.recibirDanyo(10);
        assertEquals(config.playerVida - 10, player.getVida());
    }

    @Test
    void recibirDanyoNoPermiteCantidadNegativa() {

        int danyo = -10;
        assertThrows(IllegalArgumentException.class,
                () -> player.recibirDanyo(danyo));
    }

    @Test
    void recibirDanyoNoSuperaMaximo() {

        int danyo = 1000;
        assertThrows(IllegalArgumentException.class,
                () -> player.recibirDanyo(danyo));
    }

}