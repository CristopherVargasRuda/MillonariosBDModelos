package app.client.vistaPrincipal;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import app.components.insertar.InsertarComponent;
import app.components.eliminar.EliminarComponent;
import app.components.listar.ListarComponent;
import app.components.modificar.ModificarComponent;

public class VistaPrincipalComponent implements ActionListener, FocusListener, MouseListener,
        MouseMotionListener {

    private VistaPrincipalTemplate vistaPrincipalTemplate;
    private InsertarComponent insertarComponent;
    private EliminarComponent eliminarComponent;
    private ListarComponent listarComponent;
    private ModificarComponent modificarComponent;
    private int posicionInicialX, posicionInicialY;
    private String comando;
    private JButton botonSeleccionado;

    public VistaPrincipalComponent() {
        comando = "";
        vistaPrincipalTemplate = new VistaPrincipalTemplate(this);
    }

    public void mostrarComponente(String botonSeleccionado) {
        vistaPrincipalTemplate.getpPrincipal().removeAll();
        switch (botonSeleccionado) {
            case "Insertar Jugador":
                if (insertarComponent == null){
                    insertarComponent = new InsertarComponent(this);
                } 
                vistaPrincipalTemplate.crearScrollpane(
                        insertarComponent.getInsertarTemplate()
                );
                break;
            case "Modificar Jugador":
                if (modificarComponent == null){
                    modificarComponent = new ModificarComponent(this);
                } 
                vistaPrincipalTemplate.crearScrollpane(
                        modificarComponent.getModificarTemplate()
                );
                break;
            case "Eliminar Jugador":
                if (eliminarComponent == null){
                    eliminarComponent = new EliminarComponent(this);
                } 
                vistaPrincipalTemplate.crearScrollpane(
                        eliminarComponent.getEliminarTemplate()
                );
                break;
            case "Listar Jugadores":
                if (listarComponent == null){
                    listarComponent = new ListarComponent(this);
                } 
                vistaPrincipalTemplate.crearScrollpane(
                        listarComponent.getListarTemplate()
                );
                break;
            default:
                vistaPrincipalTemplate.crearJLabels();
                break;
        }
        vistaPrincipalTemplate.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPrincipalTemplate.getbCerrar()) {
            System.exit(0);
        } else if (e.getSource() == vistaPrincipalTemplate.getbMinimizar()) {
            minimizar();
        } else {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    vistaPrincipalTemplate.getsRecursos().getColorAzulClaro()
            );
            if (!comando.equals(e.getActionCommand().trim())) {
                comando = e.getActionCommand().trim();
                botonSeleccionado = boton;
                this.mostrarComponente(e.getActionCommand().trim());
            } else {
                comando = "";
                botonSeleccionado = null;
                this.mostrarComponente("");
            }
        }

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {        
        quitarSeleccion();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        posicionInicialX = e.getX();
        posicionInicialY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    vistaPrincipalTemplate.getsRecursos().getColorAzulClaro()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        quitarSeleccion();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        moverVentana(
                e.getXOnScreen() - posicionInicialX, e.getYOnScreen() - posicionInicialY
        );
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public void minimizar() {
        this.vistaPrincipalTemplate.setExtendedState(Frame.ICONIFIED);
    }

    public void moverVentana(int posicionX, int posicionY) {
        this.vistaPrincipalTemplate.setLocation(posicionX, posicionY);
    }

    public VistaPrincipalTemplate getVistaPrincipalTemplate() {
        return vistaPrincipalTemplate;
    }

    public boolean validarNumeros(String texto, int tamanio) {
        return texto.matches("[0-9]{1," + tamanio + "}");
    }
    
    public void quitarSeleccion() {
        if (vistaPrincipalTemplate.getbInsertar()!= botonSeleccionado) {
            vistaPrincipalTemplate.getbInsertar().setBackground(
                    vistaPrincipalTemplate.getsRecursos().getColorAzul()
            );
        }
        if (vistaPrincipalTemplate.getbModificar()!= botonSeleccionado) {
            vistaPrincipalTemplate.getbModificar().setBackground(
                    vistaPrincipalTemplate.getsRecursos().getColorAzul()
            );
        }
        if (vistaPrincipalTemplate.getbBorrar()!= botonSeleccionado) {
            vistaPrincipalTemplate.getbBorrar().setBackground(
                    vistaPrincipalTemplate.getsRecursos().getColorAzul()
            );
        }
        if (vistaPrincipalTemplate.getbListar()!= botonSeleccionado) {
            vistaPrincipalTemplate.getbListar().setBackground(
                    vistaPrincipalTemplate.getsRecursos().getColorAzul()
            );
        }
    }

}
