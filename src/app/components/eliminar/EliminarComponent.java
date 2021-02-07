package app.components.eliminar;

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

public class EliminarComponent implements ActionListener, FocusListener, MouseListener,
        MouseMotionListener {

    private EliminarTemplate eliminarTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private Jugador jugador;
    private JTextField textField;
    private JButton boton;
    private int identificacion, cantidad;

    public EliminarComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        eliminarTemplate = new EliminarTemplate(this);
    }

    public EliminarTemplate getEliminarTemplate() {
        jugador = new Jugador();
        return eliminarTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (verificarIdentificacion()) {
            JOptionPane.showMessageDialog(null, "Cambios realizados con éxito", "Advertencia", 1);
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
                    eliminarTemplate.getsRecursos().getColorAzulClaro()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(
                    eliminarTemplate.getsRecursos().getColorAzul()
            );
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    eliminarTemplate.getsRecursos().getBordeAzulClaro()
            );
            if (e.getSource() == eliminarTemplate.gettIdentificacion()
                    && textField.getText().equals("Identificación")) {
                eliminarTemplate.gettIdentificacion().setText("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    eliminarTemplate.getsRecursos().getBordeAzul()
            );
            if (e.getSource() == eliminarTemplate.gettIdentificacion()
                    && textField.getText().equals("")) {
                eliminarTemplate.gettIdentificacion().setText("Identificación");
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
        if (!eliminarTemplate.gettIdentificacion().getText().equals("Identificación")
                && !eliminarTemplate.gettIdentificacion().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        eliminarTemplate.gettIdentificacion().getText().trim(), 10)) {
            cantidad = Integer.parseInt(eliminarTemplate.gettIdentificacion().getText().trim());
            if (cantidad > 0) {
                jugador.setIdentificacion(cantidad);
            } else {
                eliminarTemplate.gettIdentificacion().setBorder(
                        eliminarTemplate.getsRecursos().getBordeNaranja()
                );
                JOptionPane.showMessageDialog(null, "Documento Invalido", "Advertencia", 1);
                return false;
            }
        } else {
            eliminarTemplate.gettIdentificacion().setBorder(
                    eliminarTemplate.getsRecursos().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Documento Invalido", "Advertencia", 1);
            return false;
        }
        return true;
    }

}
