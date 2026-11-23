package Usuarios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DeporteConjunto.Categoria;
import DeporteConjunto.DeporteConjunto;
import DeporteConjunto.Equipo;
import DeporteIndividual.DisciplinaIndividual;
import Excepciones.UbicacionInvalidaException;
import Partidos.EstadisticaFutbol;
import Partidos.PartidoInterno;

public class EntrenadorTest {
    private Entrenador entrenador;
    private DeporteConjunto deporte;
    private Categoria cat;
    private Equipo equipo1;
    private Equipo equipo2;
    private PartidoInterno partido;
    
    
    @BeforeEach 
    void SetUp(){
        this.entrenador = new Entrenador("martin88", "password", "12345");
        this.deporte = new DeporteConjunto(DeporteConjunto.FUTBOL, 2, false);
        this.cat = new Categoria("Intermedios", 15, 20);
        this.equipo1 = new Equipo("Ovejas", deporte, cat, 11);
        this.equipo2 = new Equipo("Tejones", deporte, cat, 11);
        List<Equipo> equiposParticipantes = new ArrayList<Equipo>();
        equiposParticipantes.add(equipo1);
        equiposParticipantes.add(equipo2);
        this.partido = new PartidoInterno(new Date(), deporte, equiposParticipantes);
    }

    @Test 
    void registrarAmarilla(){
        Socio jugador1 = new Socio("Carlos67", "1234", 15);
        partido.agregarParticipante(jugador1);
        entrenador.registrarTarjeta(partido, jugador1, "AMARILLA");

        EstadisticaFutbol stats = assertInstanceOf(EstadisticaFutbol.class, partido.getEstadistica(jugador1));
        assertEquals(1, stats.getTarjetasAmarillas());
    }


}
