package TiendaCafeteria;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Excepciones.UbicacionInvalidaException;
import Usuarios.Socio;
import java.util.ArrayList;

public class CafeteriaTest {

    private Cafeteria cafe;
    
    @BeforeEach 
    void SetUp(){
        this.cafe = new Cafeteria();
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
