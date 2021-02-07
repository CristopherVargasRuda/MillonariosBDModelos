package DAO;

import java.util.ArrayList;
import negocio.models.Jugador;
import util.CaException;

public class JugadorDAO {

    private Jugador jugador;
    private ArrayList<Jugador> jugadores;

    public JugadorDAO() {
        jugador = new Jugador();
    }

    public void insertar() throws CaException {

    }

    public void modificar() {

    }

    public void eliminar() {

    }

    public void buscar() throws CaException {

    }

    public void actualizar() throws CaException {

    }

    public Jugador getJugador() {
        return jugador;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

}
