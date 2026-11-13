package TiendaCafeteria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Excepciones.UbicacionInvalidaException;

public class ArticuloTest {
    private Articulo articulo;

    @BeforeEach
    void setUp() {
        this.articulo = new Articulo("pelotaTenis", "tenis", 5500, 200, "tiendaDeportiva");
    }

    @Test
    void abastecerArticulo() {
        // Preparar: lo que falte además del setUp (a veces nada)
        articulo.abastecer(3);
        assertEquals(203, articulo.getCantidadDisponible());
    }

    @Test 
    void abastecerArticuloConCero(){
        articulo.abastecer(0);
        assertEquals(200, articulo.getCantidadDisponible());

    }
    @Test 
    void moverArticulo() throws UbicacionInvalidaException{
        articulo.mover("algunPaisMuyLejano");
        assertEquals("algunPaisMuyLejano", articulo.getUbicacion());
    }

    @Test 
    void moverArticuloUbicacionInvalida() throws UbicacionInvalidaException{
        assertThrows(UbicacionInvalidaException.class, () -> articulo.mover(""));
    }
}