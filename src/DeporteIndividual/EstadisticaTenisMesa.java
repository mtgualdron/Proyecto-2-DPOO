package DeporteIndividual;

import Usuarios.Socio;

public class EstadisticaTenisMesa extends EstadisticaDisciplina{
    private int puntosTotales;

    public EstadisticaTenisMesa(int sets, Socio jugador, int puntosTotales) {
        super(sets, jugador);
        this.puntosTotales = puntosTotales;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    

}
