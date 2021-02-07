package negocio.logic;

import java.util.ArrayList;
import negocio.models.Jugador;

public class ControlTablaJugadores {
    
    private ArrayList<Jugador> jugadores;

    public ControlTablaJugadores() {
    }

    public Jugador devolverJugador(int posicion) {
        try {
            return jugadores.get(posicion);
        } catch (Exception e) {
            return null;
        }
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public int devolverCantidadJugadors() {
        return jugadores.size();
    }
    
}
