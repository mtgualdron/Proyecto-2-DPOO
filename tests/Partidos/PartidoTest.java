package Partidos;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DeporteConjunto.Categoria;
import DeporteConjunto.DeporteConjunto;
import DeporteConjunto.Equipo;
import Excepciones.UbicacionInvalidaException;
import Usuarios.Socio;

public class PartidoTest {
    private DeporteConjunto deporte;
    private Categoria cat;
    private Equipo equipo1;
    private Equipo equipo2;
    private PartidoInterno partido;
    
    
    @BeforeEach 
    void SetUp(){
        this.deporte = new DeporteConjunto("Microfutbol", 2, false);
        this.cat = new Categoria("Intermedios", 15, 20);
        this.equipo1 = new Equipo("Ovejas", deporte, cat, 4);
        this.equipo2 = new Equipo("Tejones", deporte, cat, 4);
        List<Equipo> equiposParticipantes = new ArrayList<Equipo>();
        equiposParticipantes.add(equipo1);
        equiposParticipantes.add(equipo2);
        this.partido = new PartidoInterno(null, deporte, equiposParticipantes);
        
    }

    @Test 
    void puedeJugarseEquiposCompletos(){
        Socio jugador1 = new Socio("Carlos67", "1234", 15);
        Socio jugador2 = new Socio("Adrian42", "5678", 18);
        Socio jugador3 = new Socio("Juan2010", "abcd", 19);
        Socio jugador4 = new Socio("Laura777", "efgh", 20);
        jugador1.inscribirseEnEquipo(equipo1, "Delantero", 67);
        jugador2.inscribirseEnEquipo(equipo1, "Arquero", 1);
        jugador3.inscribirseEnEquipo(equipo2, "Delantero", 10);
        jugador4.inscribirseEnEquipo(equipo2, "Arquero", 77);

        assertTrue(partido.puedeJugarse(equipo1));
    }





}
