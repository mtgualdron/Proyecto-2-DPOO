package Partidos;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import DeporteConjunto.Equipo;
import DeporteConjunto.DeporteConjunto;

public class PartidoInterno extends Partido {

    // Constructor 
    public PartidoInterno(Date fecha, DeporteConjunto deporte, List<Equipo> equiposParticipantes) { 
    	super(fecha, deporte);
    } 
    
    //metodos 
 
    public List<Equipo> getEquiposParticipantes() {
    	return this.equiposParticipantes;
    }

}