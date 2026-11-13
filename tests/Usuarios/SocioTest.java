package Usuarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DeporteIndividual.DisciplinaIndividual;
import Excepciones.UbicacionInvalidaException;

public class SocioTest {
    private Socio socio1;
    private Socio socio2;
    private DisciplinaIndividual deporte1;
    private DisciplinaIndividual deporte2;

    @BeforeEach 
    void SetUp(){
        socio1 = new Socio("juan123", "password1", 19);
        socio2 = new Socio("carlos67", "password2", 17);
        deporte1 = new DisciplinaIndividual("tenis", 5);
        deporte2 = new DisciplinaIndividual("padel", 5);
    }

    @Test 
    void obtenerRankingDosDeportes(){
        socio1.inscribirseEnDisciplina(deporte1, "PRINCIPIANTE");
        socio1.inscribirseEnDisciplina(deporte2, "INTERMEDIO");
        assertEquals("padel", socio1.obtenerRanking(deporte2).getDisciplina().getNombre());


    }
}
