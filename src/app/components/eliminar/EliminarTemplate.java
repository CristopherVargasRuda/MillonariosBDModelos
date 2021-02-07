package app.components.eliminar;

import app.services.GraficosAvanzadosService;
import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EliminarTemplate extends JPanel {

    private EliminarComponent eliminarComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    private JLabel lTituloComponente;
    private JTextField tIdentificacion;
    private JButton bConfirmar;

    public EliminarTemplate(EliminarComponent eliminarComponent) {
        this.eliminarComponent = eliminarComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.crearJTextFields();
        this.crearJButtons();
        this.crearJLabels();

        this.setBackground(sRecursos.getColorGris());
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1200, 480));
        this.setVisible(true);
    }

    public void crearJTextFields() {
        // IDENTIFIACIÓN ----------------------------------------------
        tIdentificacion = sObjGraficos.construirJTextField(
                "Identificación", 350, 200, 500, 40, null, Color.BLACK,
                sRecursos.getColorAzul(), sRecursos.getFontText(),
                sRecursos.getBordeAzul(), "c"
        );
        tIdentificacion.addFocusListener(eliminarComponent);
        this.add(tIdentificacion);
    }

    public void crearJButtons() {
        // BOTÓN CONFIRMAR ---------------------------------------
        bConfirmar = sObjGraficos.construirJButton(
                "Confirmar", 400, 350, 400, 60, sRecursos.getcMano(), null,
                sRecursos.getFontBoton(), sRecursos.getColorAzul(),
                Color.white, null, "C", true
        );
        bConfirmar.addMouseListener(eliminarComponent);
        bConfirmar.addActionListener(eliminarComponent);
        this.add(bConfirmar);
    }

    public void crearJLabels() {
        // TITULO COMPONENTE ------------------------------------------------
        lTituloComponente = sObjGraficos.construirJLabel(
                "ELIMINAR JUGADOR", 0, 20, 1200, 80, null, Color.BLACK, null,
                sRecursos.getFontTituloPanel(), "c"
        );
        this.add(lTituloComponente);
    }

    public JTextField gettIdentificacion() {
        return tIdentificacion;
    }

    public JButton getbConfirmar() {
        return bConfirmar;
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

}
