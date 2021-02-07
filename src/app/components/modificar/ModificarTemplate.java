package app.components.modificar;

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

public class ModificarTemplate extends JPanel {

    private ModificarComponent modificarComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    private JLabel lTituloComponente, lNombre, lApellido, lDorsal, lPosicion;
    private JTextField tNombre, tApellido, tIdentificacion, tDorsal;
    private JComboBox cbPosicion;
    private JButton bConfirmar, bCargar;

    public ModificarTemplate(ModificarComponent modificarComponent) {
        this.modificarComponent = modificarComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.crearJTextFields();
        this.crearJButtons();
        this.crearJComboBox();
        this.crearJLabels();

        this.setBackground(sRecursos.getColorGris());
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1180, 900));
        this.setVisible(true);
    }

    public void crearJTextFields() {
        // NOMBRE ----------------------------------------------
        tNombre = sObjGraficos.construirJTextField(
                "Nombre del Jugador", 530, 350, 500, 40, null, Color.BLACK,
                sRecursos.getColorAzul(), sRecursos.getFontText(),
                sRecursos.getBordeAzul(), "c"
        );
        tNombre.setEnabled(false);
        tNombre.addFocusListener(modificarComponent);
        this.add(tNombre);

        // APELLIDO ----------------------------------------------
        tApellido = sObjGraficos.construirJTextField(
                "Apellido del Jugador", 530, 450, 500, 40, null, Color.BLACK,
                sRecursos.getColorAzul(), sRecursos.getFontText(),
                sRecursos.getBordeAzul(), "c"
        );
        tApellido.setEnabled(false);
        tApellido.addFocusListener(modificarComponent);
        this.add(tApellido);

        // IDENTIFIACIÓN ----------------------------------------------
        tIdentificacion = sObjGraficos.construirJTextField(
                "Identificación", 50, 150, 500, 40, null, Color.BLACK,
                sRecursos.getColorAzul(), sRecursos.getFontText(),
                sRecursos.getBordeAzul(), "c"
        );
        tIdentificacion.addFocusListener(modificarComponent);
        this.add(tIdentificacion);

        // DORSAL ----------------------------------------------
        tDorsal = sObjGraficos.construirJTextField(
                "Dorsal", 530, 550, 500, 40, null, Color.BLACK,
                sRecursos.getColorAzul(), sRecursos.getFontText(),
                sRecursos.getBordeAzul(), "c"
        );
        tDorsal.setEnabled(false);
        tDorsal.addFocusListener(modificarComponent);
        this.add(tDorsal);
    }

    public void crearJButtons() {
        // BOTÓN CARGAR ---------------------------------------
        bCargar = sObjGraficos.construirJButton(
                "Buscar", 750, 150, 300, 60, sRecursos.getcMano(), null,
                sRecursos.getFontBoton(), sRecursos.getColorAzul(),
                Color.white, null, "C", true
        );
        bCargar.addMouseListener(modificarComponent);
        bCargar.addActionListener(modificarComponent);
        this.add(bCargar);

        // BOTÓN CONFIRMAR ---------------------------------------
        bConfirmar = sObjGraficos.construirJButton(
                "Confirmar", (1200 - 400) / 2, 800, 400, 60,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorAzul(), Color.white, null,
                "C", true
        );
        bConfirmar.addMouseListener(modificarComponent);
        bConfirmar.addActionListener(modificarComponent);
        this.add(bConfirmar);
    }

    public void crearJComboBox() {
        // POSICIÓN -------------------------------------------------------
        cbPosicion = sObjGraficos.construirJComboBox(
                "Seleccione una posicion_Portero_Central_Carilero_Lateral_"
                + "Volante_Media Punta_Extremo_Delantero_Interior",
                530, 650, 500, 40, Color.WHITE, Color.BLACK, "c"
        );
        cbPosicion.setFont(sRecursos.getFontText());
        cbPosicion.setEnabled(false);
        cbPosicion.setBorder(BorderFactory.createLineBorder(sRecursos.getColorAzul(), 1));
        cbPosicion.addFocusListener(modificarComponent);
        this.add(cbPosicion);
    }

    public void crearJLabels() {
        // TITULO COMPONENTE ------------------------------------------------
        lTituloComponente = sObjGraficos.construirJLabel(
                "MODIFICAR JUGADOR", 0, 20, 1180, 80, null, Color.BLACK, null,
                sRecursos.getFontTituloPanel(), "c"
        );
        this.add(lTituloComponente);

        // NOMBRE ------------------------------------------------
        lTituloComponente = sObjGraficos.construirJLabel(
                "Nombre del jugador: ", 180, 350, 400, 40, null, Color.BLACK, null,
                sRecursos.getFontText(), "l"
        );
        this.add(lTituloComponente);

        // APELLIDO ------------------------------------------------
        lTituloComponente = sObjGraficos.construirJLabel(
                "Apellido del jugador: ", 180, 450, 400, 40, null, Color.BLACK, null,
                sRecursos.getFontText(), "l"
        );
        this.add(lTituloComponente);

        // DORSAL ------------------------------------------------
        lTituloComponente = sObjGraficos.construirJLabel(
                "Dorsal del jugador: ", 180, 550, 400, 40, null, Color.BLACK, null,
                sRecursos.getFontText(), "l"
        );
        this.add(lTituloComponente);

        // POSICION ------------------------------------------------
        lTituloComponente = sObjGraficos.construirJLabel(
                "Posicion del jugador: ", 180, 650, 400, 40, null, Color.BLACK, null,
                sRecursos.getFontText(), "l"
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

    public JButton getbCargar() {
        return bCargar;
    }

}
