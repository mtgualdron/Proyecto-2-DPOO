package TiendaCafeteria;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import TiendaCafeteria.Venta;
import Usuarios.Socio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Excepciones.UbicacionInvalidaException;

public class VentaTest {
    private Venta venta;

    @BeforeEach 
    void SetUp(){
        Socio comprador = new Socio("juan", "1234", 25);
        this.venta = new Venta(LocalDate.of(2026, 11, 13), "TIENDA", 100000.0, 0.0, 19000.0, 0.0, comprador);
    }

    @Test 
    void calcularTotal(){
        assertEquals(119000.0, venta.calcularTotal());
    }

    @Test 
    void calcularPuntosFidelidad(){
        assertEquals(2380, venta.calcularPuntosFidelidad(venta.calcularTotal()));
    }
    @Test 
    void calcularPuntosVentaPequena(){
        assertEquals(20, venta.calcularPuntosFidelidad(1000));
    }

    @Test 
    void esRubroCorrecto(){
        assertTrue(venta.esRubro("TIENDA"));
    }

    @Test 
    void esRubroIncorrecto(){
        assertFalse(venta.esRubro("CAFETERIA"));
    }
    


}
