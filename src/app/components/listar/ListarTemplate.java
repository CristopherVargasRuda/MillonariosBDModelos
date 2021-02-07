package app.components.listar;

import app.services.GraficosAvanzadosService;
import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ListarTemplate extends JPanel {

    private ListarComponent listarComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    //Objetos Tabla
    private JScrollPane pTabla;
    private JPanel pCorner;
    private JTable tabla;
    private JTableHeader header;
    private DefaultTableModel modelo;
    private String[] cabecera = {
        "Identificación", "Nombre", "Apellido", "Posicion", "Dorsal"
    };

    public ListarTemplate(ListarComponent listarComponent) {
        this.listarComponent = listarComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.crearJTable();

        this.setBackground(sRecursos.getColorGris());
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1200, 480));
        this.setVisible(true);
    }

    public void crearJTable() {
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        tabla.addMouseListener(listarComponent);
        tabla.setRowHeight(40);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);

        header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(800, 30));

        pTabla = sObjGraficos.construirPanelBarra(tabla, 50, 50, 1100, 380, Color.WHITE, null);

        header.setDefaultRenderer(
                sGraficosAvanzados.devolverTablaPersonalizada(
                        sRecursos.getColorAzulClaro(), null, null, Color.WHITE,
                        sRecursos.getFontLigera()
                )
        );

        tabla.setDefaultRenderer(
                Object.class,
                sGraficosAvanzados.devolverTablaPersonalizada(
                        Color.WHITE, Color.LIGHT_GRAY,
                        sRecursos.getColorAzulClaro(),
                        sRecursos.getColorGris(),
                        sRecursos.getFontLigera()
                )
        );

        pTabla.getVerticalScrollBar().setUI(
                sGraficosAvanzados.devolverScrollPersonalizado(
                        7, 10, Color.WHITE, sRecursos.getColorAzul(),
                        sRecursos.getColorAzulClaro()
                )
        );

        pCorner = new JPanel();
        pCorner.setBackground(sRecursos.getColorNaranja());
        pTabla.setCorner(JScrollPane.UPPER_RIGHT_CORNER, pCorner);

        this.add(pTabla);
    }

    public JScrollPane getpTabla() {
        return pTabla;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

}
