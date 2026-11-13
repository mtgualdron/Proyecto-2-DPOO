package TiendaCafeteria;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DeporteIndividual.Instalacion;
import DeporteIndividual.Reserva;
import Usuarios.Socio;

public class CafeteriaTest {

    private Cafeteria cafe;
    private Socio comprador;
    private Bebida jugo;
    private Bebida tinto;
    private Snack papas;

    @BeforeEach
    void setUp() {
        cafe = new Cafeteria();
        comprador = new Socio("juan", "1234", 25);
        jugo = new Bebida("Jugo", 5000, false);
        tinto = new Bebida("Tinto", 3000, true);
        papas = new Snack("Papas", 3000);
    }

    @Test
    void venderVentaNormal() {
        Venta venta = cafe.vender(comprador, List.of(jugo), List.of(papas), 800);
        assertEquals("CAFETERIA", venta.getRubro());
        assertEquals(8000.0, venta.getValor());
        assertEquals(640.0, venta.getImpuesto());
        assertEquals(800.0, venta.getPropina());
        assertEquals(9440.0, venta.calcularTotal());
        assertEquals(comprador, venta.getComprador());
        assertTrue(comprador.getHistorialCompras().contains(venta));
    }

    @Test
    void venderSinCompradorLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> cafe.vender(null, List.of(jugo), List.of(papas), 0));
    }

    @Test
    void venderSoloBebidas() {
        Venta venta = cafe.vender(comprador, List.of(jugo), null, 0);
        assertEquals(5000.0, venta.getValor());
        assertEquals(400.0, venta.getImpuesto());
    }

    @Test
    void venderSoloSnacks() {
        Venta venta = cafe.vender(comprador, new ArrayList<Bebida>(), List.of(papas), 0);
        assertEquals(3000.0, venta.getValor());
        assertEquals(240.0, venta.getImpuesto());
    }

    @Test
    void venderSinBebidasNiSnacks() {
        assertThrows(IllegalArgumentException.class, () -> cafe.vender(comprador, null, null, 0));
        assertThrows(IllegalArgumentException.class,
                () -> cafe.vender(comprador, new ArrayList<Bebida>(), new ArrayList<Snack>(), 0));
        assertTrue(comprador.getHistorialCompras().isEmpty());
    }

    @Test
    void venderBebidaCalienteEnInstalacionProhibida() {
        Instalacion cancha = new Instalacion("Cancha Tenis 1", "Cancha de tenis", 4, true);
        LocalDateTime ahora = LocalDateTime.now();
        Reserva reserva = new Reserva(ahora.minusMinutes(30), ahora.plusMinutes(30), 2, "SENCILLOS", comprador, cancha);
        comprador.getReservas().add(reserva);
        assertThrows(IllegalArgumentException.class, () -> cafe.vender(comprador, List.of(tinto), null, 0));
        assertTrue(comprador.getHistorialCompras().isEmpty());
    }


    @Test 
    void agregarBebida(){
        Bebida newBebida = new Bebida("Capuchino", 5000, true);
        cafe.agregarBebida(newBebida);
        assertEquals(List.of(newBebida), cafe.getBebidas());
    }

    @Test 
    void agregarSnack(){
        Snack newSnack = new Snack("Mani moto", 500);
        cafe.agregarSnack(newSnack);
        assertEquals(List.of(newSnack), cafe.getSnacks());
    }

    @Test 
    void reportarAlergenosUnSnack(){
        Snack maniMoto = new Snack("Mani moto", 500);
        ArrayList<Snack> snacksAComprar = new ArrayList<Snack>();
        maniMoto.agregarAlergeno("Maní");
        maniMoto.agregarAlergeno("Nueces");
        snacksAComprar.add(maniMoto);
        assertEquals(List.of("El snack Mani moto contiene alérgenos: [Maní, Nueces]"), cafe.informarAlergenos(snacksAComprar));
    }

    @Test 
    void reportarAlergenosVariosSnacks() {
        Snack maniMoto = new Snack("Mani moto", 500);
        Snack brownie = new Snack("Brownie", 4000);
        ArrayList<Snack> snacksAComprar = new ArrayList<Snack>();
        maniMoto.agregarAlergeno("Maní");
        maniMoto.agregarAlergeno("Nueces");
        brownie.agregarAlergeno("Gluten");
        brownie.agregarAlergeno("Huevo");
        snacksAComprar.add(maniMoto);
        snacksAComprar.add(brownie);
        List<String> esperado = List.of(
                "El snack Mani moto contiene alérgenos: [Maní, Nueces]",
                "El snack Brownie contiene alérgenos: [Gluten, Huevo]");
        assertEquals(esperado, cafe.informarAlergenos(snacksAComprar));
}

}
