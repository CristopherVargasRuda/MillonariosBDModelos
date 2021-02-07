package app.components.listar;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import negocio.logic.ControlTablaJugadores;
import negocio.models.Jugador;

public class ListarComponent implements ActionListener, FocusListener, MouseListener,
        MouseMotionListener {

    private ListarTemplate listarTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private ControlTablaJugadores controlTablaJugadores;
    private Jugador jugador;

    public ListarComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        listarTemplate = new ListarTemplate(this);
    }

    public ListarTemplate getListarTemplate() {
        return listarTemplate;
    }

    public void actualizarTabla() {

    }

    public void mostrarRegistrosTabla() {
        for (int i = 0; i < controlTablaJugadores.devolverCantidadJugadors(); i++) {
            jugador = controlTablaJugadores.devolverJugador(i);
            this.agregarRegistro(jugador);
        }
    }

    public void agregarRegistro(Jugador jugador) {
        String identificacion, nombre, apellido, posicion, dorsal;
        identificacion = jugador.getIdentificacion()+"";
        nombre = jugador.getNombre();
        apellido = jugador.getApellido();
        posicion = jugador.getPosicion();
        dorsal = jugador.getDorsal()+"";
        listarTemplate.getModelo().addRow(
                new Object[]{
                    identificacion, nombre, apellido, posicion, dorsal
                }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
