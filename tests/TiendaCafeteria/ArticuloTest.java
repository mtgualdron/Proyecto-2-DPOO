package TiendaCafeteria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Excepciones.CantidadInvalidaException;
import Excepciones.UbicacionInvalidaException;

public class ArticuloTest {
    private Articulo articulo;

    @BeforeEach
    void setUp() {
        this.articulo = new Articulo("pelotaTenis", "tenis", 5500, 200, "tiendaDeportiva");
    }

    @Test
    void abastecerArticulo() throws CantidadInvalidaException{
        // Preparar: lo que falte además del setUp (a veces nada)
        articulo.abastecer(3);
        assertEquals(203, articulo.getCantidadDisponible());
    }

    @Test 
    void abastecerArticuloConCero() throws CantidadInvalidaException{
        assertThrows(CantidadInvalidaException.class, () -> articulo.abastecer(0));

    }
    @Test 
    void moverArticulo() throws UbicacionInvalidaException{
        articulo.mover("  algunPaisMuyLejano  ");
        assertEquals("algunPaisMuyLejano", articulo.getUbicacion());
    }

    @Test 
    void moverArticuloUbicacionInvalida() throws UbicacionInvalidaException{
        assertThrows(UbicacionInvalidaException.class, () -> articulo.mover(""));
    }

    @Test 
    void moverArticuloNull() throws UbicacionInvalidaException{
        assertThrows(NullPointerException.class, ()->articulo.mover(null));
    }

    @Test 
    void moverArticuloEnBlanco() throws UbicacionInvalidaException{
        assertThrows(UbicacionInvalidaException.class, () -> articulo.mover("            "));
    }
}