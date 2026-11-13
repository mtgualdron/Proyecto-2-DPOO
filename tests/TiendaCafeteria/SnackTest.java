package TiendaCafeteria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Excepciones.UbicacionInvalidaException;
import TiendaCafeteria.Snack;

import java.util.ArrayList;
import java.util.List;

public class SnackTest {

    private Snack snack;

    @BeforeEach 
    void SetUp(){
    this.snack = new Snack("Pastel de nueces", 2500);
    }

    @Test 
    void tieneAlergenosVacio(){
        assertFalse(snack.tieneAlergenos());
    }

    @Test 
    void agregarAlergeno(){
        snack.agregarAlergeno("MANI");
        assertEquals(List.of("MANI"), snack.getAlergenos());
    }

    @Test 
    void agregarMuchosAlergenos(){
        snack.agregarAlergeno("MANI");
        snack.agregarAlergeno("NUECES");
        snack.agregarAlergeno("GLUTEN");
        assertEquals(List.of("MANI", "NUECES", "GLUTEN"), snack.getAlergenos());
    }

    @Test
    void tieneAlergenosNoVacio(){
        snack.agregarAlergeno("MANI");
        assertTrue(snack.tieneAlergenos());
    }


}
