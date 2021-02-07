package app.components.insertar;

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

public class InsertarComponent implements ActionListener, FocusListener, MouseListener,
        MouseMotionListener {

    private InsertarTemplate insertarTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private Jugador jugador;
    private JTextField textField;
    private JButton boton;
    private JComboBox comboBox;
    private int cantidad;
    private String seleccionComboBox;

    public InsertarComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        jugador = new Jugador();
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        insertarTemplate = new InsertarTemplate(this);
    }

    public InsertarTemplate getInsertarTemplate() {
        return insertarTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cargarDatos()) {
            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Advertencia", 1);
            limpiarDatos();
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
                    insertarTemplate.getsRecursos().getColorAzulClaro()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(
                    insertarTemplate.getsRecursos().getColorAzul()
            );
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    insertarTemplate.getsRecursos().getBordeAzulClaro()
            );
            if (e.getSource() == insertarTemplate.gettNombre()
                    && textField.getText().equals("Nombre del Jugador")) {
                insertarTemplate.gettNombre().setText("");
            }
            if (e.getSource() == insertarTemplate.gettApellido()
                    && textField.getText().equals("Apellido del Jugador")) {
                insertarTemplate.gettApellido().setText("");
            }
            if (e.getSource() == insertarTemplate.gettIdentificacion()
                    && textField.getText().equals("Identificación")) {
                insertarTemplate.gettIdentificacion().setText("");
            }
            if (e.getSource() == insertarTemplate.gettDorsal()
                    && textField.getText().equals("Dorsal")) {
                insertarTemplate.gettDorsal().setText("");
            }
        }
        if (e.getSource() instanceof JComboBox) {
            comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(
                    insertarTemplate.getsRecursos().getColorAzulClaro(), 2)
            );
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    insertarTemplate.getsRecursos().getBordeAzul()
            );
            if (e.getSource() == insertarTemplate.gettNombre()
                    && textField.getText().equals("")) {
                insertarTemplate.gettNombre().setText("Nombre del Jugador");
            }
            if (e.getSource() == insertarTemplate.gettApellido()
                    && textField.getText().equals("")) {
                insertarTemplate.gettApellido().setText("Apellido del Jugador");
            }
            if (e.getSource() == insertarTemplate.gettIdentificacion()
                    && textField.getText().equals("")) {
                insertarTemplate.gettIdentificacion().setText("Identificación");
            }
            if (e.getSource() == insertarTemplate.gettDorsal()
                    && textField.getText().equals("")) {
                insertarTemplate.gettDorsal().setText("Dorsal");
            }
        }
        if (e.getSource() instanceof JComboBox) {
            comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(
                    insertarTemplate.getsRecursos().getColorAzul(), 2)
            );
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public boolean cargarDatos() {
        // NOMBRE ------------------------------------------------------------        
        if (!insertarTemplate.gettNombre().getText().equals("Nombre del Jugador")
                && !insertarTemplate.gettNombre().getText().equals("")) {
            jugador.setNombre(insertarTemplate.gettNombre().getText().trim());
        } else {
            insertarTemplate.gettNombre().setBorder(
                    insertarTemplate.getsRecursos().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del Jugador", "Advertencia", 1);
            return false;
        }

        // APELLIDO ------------------------------------------------------------        
        if (!insertarTemplate.gettApellido().getText().equals("Apellido del Jugador")
                && !insertarTemplate.gettApellido().getText().equals("")) {
            jugador.setApellido(insertarTemplate.gettApellido().getText().trim());
        } else {
            insertarTemplate.gettApellido().setBorder(
                    insertarTemplate.getsRecursos().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Ingrese el apellido del Jugador", "Advertencia", 1);
            return false;
        }

        // IDENTIFICACIÓN ------------------------------------------------------- 
        if (!insertarTemplate.gettIdentificacion().getText().equals("Identificación")
                && !insertarTemplate.gettIdentificacion().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        insertarTemplate.gettIdentificacion().getText().trim(), 10)) {
            cantidad = Integer.parseInt(insertarTemplate.gettIdentificacion().getText().trim());
            if (cantidad > 0) {
                jugador.setIdentificacion(cantidad);
            } else {
                insertarTemplate.gettIdentificacion().setBorder(
                        insertarTemplate.getsRecursos().getBordeNaranja()
                );
                JOptionPane.showMessageDialog(null, "Documento Invalido", "Advertencia", 1);
                return false;
            }
        } else {
            insertarTemplate.gettIdentificacion().setBorder(
                    insertarTemplate.getsRecursos().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Documento Invalido", "Advertencia", 1);
            return false;
        }

        // DORSAL ------------------------------------------------------- 
        if (!insertarTemplate.gettDorsal().getText().equals("Dorsal")
                && !insertarTemplate.gettDorsal().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        insertarTemplate.gettDorsal().getText().trim(), 2)) {
            cantidad = Integer.parseInt(insertarTemplate.gettDorsal().getText().trim());
            if (cantidad > 0) {
                jugador.setDorsal(cantidad);
            } else {
                insertarTemplate.gettDorsal().setBorder(
                        insertarTemplate.getsRecursos().getBordeNaranja()
                );
                JOptionPane.showMessageDialog(null, "Dorsal Invalido", "Advertencia", 1);
                return false;
            }
        } else {
            insertarTemplate.gettDorsal().setBorder(
                    insertarTemplate.getsRecursos().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Dorsal Invalido", "Advertencia", 1);
            return false;
        }

        // TIPO PARQUEADERO --------------------------------------------   
        seleccionComboBox = (String) insertarTemplate.getCbPosicion().getSelectedItem();
        if (!seleccionComboBox.equals("Seleccione una posicion")
                && !seleccionComboBox.equals("")) {
            jugador.setPosicion(seleccionComboBox);
        } else {
            insertarTemplate.getCbPosicion().setBorder(
                    BorderFactory.createLineBorder(
                            insertarTemplate.getsRecursos().getColorNaranja(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione una posicion", "Advertencia", 1);
            return false;
        }

        return true;
    }

    public void limpiarDatos() {
        insertarTemplate.gettNombre().setText(
                "Nombre del Jugador"
        );
        insertarTemplate.gettApellido().setText(
                "Apellido del Jugador"
        );
        insertarTemplate.gettIdentificacion().setText(
                "Identificación"
        );
        insertarTemplate.gettDorsal().setText(
                "Dorsal"
        );
        insertarTemplate.getCbPosicion().setSelectedIndex(0);
    }
}
