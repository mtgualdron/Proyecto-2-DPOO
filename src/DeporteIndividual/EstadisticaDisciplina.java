package DeporteIndividual;

import Usuarios.Socio;

public abstract class EstadisticaDisciplina {
    private int sets;
    private Socio jugador;
    
    public EstadisticaDisciplina(int sets, Socio jugador) {
        this.sets = sets;
        this.jugador = jugador;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public Socio getJugador() {
        return jugador;
    }

    public void setJugador(Socio jugador) {
        this.jugador = jugador;
    }

    

}
