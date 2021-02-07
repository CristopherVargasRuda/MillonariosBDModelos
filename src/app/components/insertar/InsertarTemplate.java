package app.components.insertar;

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

public class InsertarTemplate extends JPanel {

    private InsertarComponent insertarComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    private JLabel lTituloComponente;
    private JTextField tNombre, tApellido, tIdentificacion, tDorsal;
    private JComboBox cbPosicion;
    private JButton bConfirmar;

    public InsertarTemplate(InsertarComponent insertarComponent) {
        this.insertarComponent = insertarComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.crearJTextFields();
        this.crearJButtons();
        this.crearJComboBox();
        this.crearJLabels();

        this.setBackground(sRecursos.getColorGris());
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1200, 480));
        this.setVisible(true);
    }

    public void crearJTextFields() {
        // NOMBRE ----------------------------------------------
        tNombre = sObjGraficos.construirJTextField(
                "Nombre del Jugador", 50, 150, 500, 40, null, Color.BLACK,
                sRecursos.getColorAzul(), sRecursos.getFontText(),
                sRecursos.getBordeAzul(), "c"
        );
        tNombre.addFocusListener(insertarComponent);
        this.add(tNombre);

        // APELLIDO ----------------------------------------------
        tApellido = sObjGraficos.construirJTextField(
                "Apellido del Jugador", 650, 150, 500, 40, null, Color.BLACK,
                sRecursos.getColorAzul(), sRecursos.getFontText(),
                sRecursos.getBordeAzul(), "c"
        );
        tApellido.addFocusListener(insertarComponent);
        this.add(tApellido);

        // IDENTIFIACIÓN ----------------------------------------------
        tIdentificacion = sObjGraficos.construirJTextField(
                "Identificación", 50, 250, 300, 40, null, Color.BLACK,
                sRecursos.getColorAzul(), sRecursos.getFontText(),
                sRecursos.getBordeAzul(), "c"
        );
        tIdentificacion.addFocusListener(insertarComponent);
        this.add(tIdentificacion);

        // DORSAL ----------------------------------------------
        tDorsal = sObjGraficos.construirJTextField(
                "Dorsal", 850, 250, 300, 40, null, Color.BLACK,
                sRecursos.getColorAzul(), sRecursos.getFontText(),
                sRecursos.getBordeAzul(), "c"
        );
        tDorsal.addFocusListener(insertarComponent);
        this.add(tDorsal);
    }

    public void crearJButtons() {
        // BOTÓN CONFIRMAR ---------------------------------------
        bConfirmar = sObjGraficos.construirJButton(
                "Confirmar", (1200 - 400) / 2, 350, 400, 60,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorAzul(), Color.white, null,
                "C", true
        );
        bConfirmar.addMouseListener(insertarComponent);
        bConfirmar.addActionListener(insertarComponent);
        this.add(bConfirmar);

    }

    public void crearJComboBox() {
        // POSICIÓN -------------------------------------------------------
        cbPosicion = sObjGraficos.construirJComboBox(
                "Seleccione una posicion_Portero_Central_Carilero_Lateral_"
                + "Volante_Media Punta_Extremo_Delantero_Interior",
                450, 250, 300, 40, Color.WHITE, Color.BLACK, "c"
        );
        cbPosicion.setFont(sRecursos.getFontText());
        cbPosicion.setBorder(BorderFactory.createLineBorder(sRecursos.getColorAzul(), 1));
        cbPosicion.addFocusListener(insertarComponent);
        this.add(cbPosicion);
    }

    public void crearJLabels() {
        // TITULO COMPONENTE ------------------------------------------------
        lTituloComponente = sObjGraficos.construirJLabel(
                "INSERTAR JUGADOR", 0, 20, 1200, 80, null, Color.BLACK, null,
                sRecursos.getFontTituloPanel(), "c"
        );
        this.add(lTituloComponente);
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public JTextField gettNombre() {
        return tNombre;
    }

    public JTextField gettApellido() {
        return tApellido;
    }

    public JTextField gettIdentificacion() {
        return tIdentificacion;
    }

    public JTextField gettDorsal() {
        return tDorsal;
    }

    public JComboBox getCbPosicion() {
        return cbPosicion;
    }

    public JButton getbConfirmar() {
        return bConfirmar;
    }
    
}
