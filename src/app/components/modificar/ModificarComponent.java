package app.components.modificar;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import negocio.models.Jugador;

public class ModificarComponent implements ActionListener, FocusListener, MouseListener,
        MouseMotionListener {

    private ModificarTemplate modificarTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private Jugador jugador;
    private JTextField textField;
    private JButton boton;
    private JComboBox comboBox;
    private int cantidad, identificacion;
    private String seleccionComboBox;

    public ModificarComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        jugador = new Jugador();
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        modificarTemplate = new ModificarTemplate(this);
    }

    public ModificarTemplate getModificarTemplate() {
        return modificarTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == modificarTemplate.getbCargar()) {
            if (verificarIdentificacion()) {
                mostrarDatosJugador();
            }
        }
        if (e.getSource() == modificarTemplate.getbConfirmar()) {
            if (cargarDatos()) {
                JOptionPane.showMessageDialog(null, "Cambios realizados con éxito", "Advertencia", 1);
                limpiarDatos();
            }
        }
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
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(
                    modificarTemplate.getsRecursos().getColorAzulClaro()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(
                    modificarTemplate.getsRecursos().getColorAzul()
            );
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    modificarTemplate.getsRecursos().getBordeAzulClaro()
            );
            if (e.getSource() == modificarTemplate.gettIdentificacion()
                    && textField.getText().equals("Identificación")) {
                modificarTemplate.gettIdentificacion().setText("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    modificarTemplate.getsRecursos().getBordeAzul()
            );
            if (e.getSource() == modificarTemplate.gettIdentificacion()
                    && textField.getText().equals("")) {
                modificarTemplate.gettIdentificacion().setText("Identificación");
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public boolean verificarIdentificacion() {
        if (!modificarTemplate.gettIdentificacion().getText().equals("Identificación")
                && !modificarTemplate.gettIdentificacion().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        modificarTemplate.gettIdentificacion().getText().trim(), 10)) {
            cantidad = Integer.parseInt(modificarTemplate.gettIdentificacion().getText().trim());
            if (cantidad > 0) {
                jugador.setIdentificacion(cantidad);
            } else {
                modificarTemplate.gettIdentificacion().setBorder(
                        modificarTemplate.getsRecursos().getBordeNaranja()
                );
                JOptionPane.showMessageDialog(null, "Documento Invalido", "Advertencia", 1);
                return false;
            }
        } else {
            modificarTemplate.gettIdentificacion().setBorder(
                    modificarTemplate.getsRecursos().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Documento Invalido", "Advertencia", 1);
            return false;
        }
        return true;
    }

    public boolean cargarDatos() {
        // NOMBRE ------------------------------------------------------------        
        if (!modificarTemplate.gettNombre().getText().equals("Nombre del Jugador")
                && !modificarTemplate.gettNombre().getText().equals("")) {
            jugador.setNombre(modificarTemplate.gettNombre().getText().trim());
        } else {
            modificarTemplate.gettNombre().setBorder(
                    modificarTemplate.getsRecursos().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del Jugador", "Advertencia", 1);
            return false;
        }

        // APELLIDO ------------------------------------------------------------        
        if (!modificarTemplate.gettApellido().getText().equals("Apellido del Jugador")
                && !modificarTemplate.gettApellido().getText().equals("")) {
            jugador.setApellido(modificarTemplate.gettApellido().getText().trim());
        } else {
            modificarTemplate.gettApellido().setBorder(
                    modificarTemplate.getsRecursos().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Ingrese el apellido del Jugador", "Advertencia", 1);
            return false;
        }

        // IDENTIFICACIÓN ------------------------------------------------------- 
        if (!modificarTemplate.gettIdentificacion().getText().equals("Identificación")
                && !modificarTemplate.gettIdentificacion().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        modificarTemplate.gettIdentificacion().getText().trim(), 10)) {
            cantidad = Integer.parseInt(modificarTemplate.gettIdentificacion().getText().trim());
            if (cantidad > 0) {
                jugador.setIdentificacion(cantidad);
            } else {
                modificarTemplate.gettIdentificacion().setBorder(
                        modificarTemplate.getsRecursos().getBordeNaranja()
                );
                JOptionPane.showMessageDialog(null, "Documento Invalido", "Advertencia", 1);
                return false;
            }
        } else {
            modificarTemplate.gettIdentificacion().setBorder(
                    modificarTemplate.getsRecursos().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Documento Invalido", "Advertencia", 1);
            return false;
        }

        // TIPO PARQUEADERO --------------------------------------------   
        seleccionComboBox = (String) modificarTemplate.getCbPosicion().getSelectedItem();
        if (!seleccionComboBox.equals("Seleccione una posicion")
                && !seleccionComboBox.equals("")) {
            jugador.setPosicion(seleccionComboBox);
        } else {
            modificarTemplate.getCbPosicion().setBorder(
                    BorderFactory.createLineBorder(
                            modificarTemplate.getsRecursos().getColorNaranja(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione una posicion", "Advertencia", 1);
            return false;
        }

        return true;
    }

    public void limpiarDatos() {
        modificarTemplate.gettNombre().setText(
                "Nombre del Jugador"
        );
        modificarTemplate.gettApellido().setText(
                "Apellido del Jugador"
        );
        modificarTemplate.gettIdentificacion().setText(
                "Identificación"
        );
        modificarTemplate.gettDorsal().setText(
                "Dorsal"
        );
        modificarTemplate.getCbPosicion().setSelectedIndex(0);

        modificarTemplate.gettNombre().setEnabled(false);
        modificarTemplate.gettApellido().setEnabled(false);
        modificarTemplate.gettIdentificacion().setEnabled(true);
        modificarTemplate.gettDorsal().setEnabled(false);
        modificarTemplate.getCbPosicion().setEnabled(false);
    }

    public void mostrarDatosJugador() {
        int i = 0;
        modificarTemplate.gettNombre().setText(
                jugador.getNombre()
        );
        modificarTemplate.gettApellido().setText(
                jugador.getApellido()
        );
        modificarTemplate.gettDorsal().setText(
                jugador.getDorsal() + ""
        );
        seleccionComboBox = "";
        while (seleccionComboBox.equals(jugador.getPosicion())) {
            i++;
            modificarTemplate.getCbPosicion().setSelectedIndex(i);
            seleccionComboBox = (String) modificarTemplate.getCbPosicion().getSelectedItem();
        }
        modificarTemplate.gettNombre().setEnabled(true);
        modificarTemplate.gettApellido().setEnabled(true);
        modificarTemplate.gettIdentificacion().setEnabled(false);
        modificarTemplate.gettDorsal().setEnabled(true);
        modificarTemplate.getCbPosicion().setEnabled(true);
    }

}
