package app.client.vistaPrincipal;

import app.services.GraficosAvanzadosService;
import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VistaPrincipalTemplate extends JFrame {

    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    private JPanel pBarraSuperior, pNavegacion, pPrincipal;
    private ImageIcon iDimAux, iLogo, iFondo, iCerrar, iMinimizar;
    private JLabel lLogo, lFondo;
    private JScrollPane scrollpane;
    private JButton bCerrar, bMinimizar, bInsertar, bModificar, bBorrar, bListar;

    private VistaPrincipalComponent vistaPrincipalComponent;

    public VistaPrincipalTemplate(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;

        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJButtons();
        this.crearJLabels();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 650);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    public void crearObjetosDecoradores() {
        iLogo = new ImageIcon("resources/img/logo.png");
        iFondo = new ImageIcon("resources/img/fondo.png");
        iCerrar = new ImageIcon("resources/img/cerrar.png");
        iMinimizar = new ImageIcon("resources/img/minimizar.png");
    }

    public void crearJPanels() {
        pBarraSuperior = sObjGraficos.construirJPanel(0, 0, 1200, 120,
                sRecursos.getColorGris(), null);
        this.add(pBarraSuperior);
        pBarraSuperior.addMouseListener(vistaPrincipalComponent);
        pBarraSuperior.addMouseMotionListener(vistaPrincipalComponent);

        pNavegacion = sObjGraficos.construirJPanel(0, 120, 1200, 50,
                Color.CYAN, null);
        this.add(pNavegacion);

        pPrincipal = sObjGraficos.construirJPanel(0, 170, 1200, 480,
                sRecursos.getColorGris(), null);
        this.add(pPrincipal);
    }

    public void crearJButtons() {
        // BOTÓN CERRAR ------------------------------------------------
        iDimAux = new ImageIcon(
                iCerrar.getImage().getScaledInstance(
                        50, 50, Image.SCALE_AREA_AVERAGING
                )
        );
        bCerrar = sObjGraficos.construirJButton(
                null, 1140, 10, 50, 50, sRecursos.getcMano(), iDimAux, null,
                null, null, null, "c", false
        );
        pBarraSuperior.add(bCerrar);
        bCerrar.addActionListener(vistaPrincipalComponent);

        // BOTÓN MINIMIZAR ------------------------------------------------
        iDimAux = new ImageIcon(
                iMinimizar.getImage().getScaledInstance(
                        50, 50, Image.SCALE_AREA_AVERAGING
                )
        );
        bMinimizar = sObjGraficos.construirJButton(
                null, 1080, 10, 50, 50, sRecursos.getcMano(), iDimAux, null,
                null, null, null, "c", false
        );
        pBarraSuperior.add(bMinimizar);
        bMinimizar.addActionListener(vistaPrincipalComponent);

        // BOTÓN INSERTAR ------------------------------------------
        bInsertar = sObjGraficos.construirJButton(
                "Insertar Jugador", 0, 0, 300, 50,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorAzul(), Color.white, null, "C", true
        );
        bInsertar.addActionListener(vistaPrincipalComponent);
        bInsertar.addMouseListener(vistaPrincipalComponent);
        pNavegacion.add(bInsertar);

        // BOTÓN MODIFICAR ------------------------------------------
        bModificar = sObjGraficos.construirJButton(
                "Modificar Jugador", 300, 0, 300, 50,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorAzul(), Color.white, null, "C", true
        );
        bModificar.addActionListener(vistaPrincipalComponent);
        bModificar.addMouseListener(vistaPrincipalComponent);
        pNavegacion.add(bModificar);

        // BOTÓN ELIMINAR ------------------------------------------
        bBorrar = sObjGraficos.construirJButton(
                "Eliminar Jugador", 600, 0, 300, 50,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorAzul(), Color.white, null, "C", true
        );
        bBorrar.addActionListener(vistaPrincipalComponent);
        bBorrar.addMouseListener(vistaPrincipalComponent);
        pNavegacion.add(bBorrar);

        // BOTÓN LISTAR ------------------------------------------
        bListar = sObjGraficos.construirJButton(
                "Listar Jugadores", 900, 0, 300, 50,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorAzul(), Color.white, null, "C", true
        );
        bListar.addActionListener(vistaPrincipalComponent);
        bListar.addMouseListener(vistaPrincipalComponent);
        pNavegacion.add(bListar);
    }

    public void crearJLabels() {
        // IMAGEN LOGO ------------------------------------------------
        iDimAux = new ImageIcon(
                iLogo.getImage().getScaledInstance(
                        465, 130, Image.SCALE_AREA_AVERAGING
                )
        );
        lLogo = sObjGraficos.construirJLabel(
                null, (pBarraSuperior.getWidth() - 600) / 2, 0, 600, 130, iDimAux,
                null, null, null, "c"
        );
        pBarraSuperior.add(lLogo);

        // IMAGEN FONDO ------------------------------------------------
        iDimAux = new ImageIcon(
                iFondo.getImage().getScaledInstance(
                        375, 400, Image.SCALE_AREA_AVERAGING
                )
        );
        lFondo = sObjGraficos.construirJLabel(
                null, (1200 - 375) / 2, 40, 375, 400, iDimAux, null, null,
                null, "c"
        );
        pPrincipal.add(lFondo);
    }

    public void crearScrollpane(JPanel panel) {
        this.scrollpane = sObjGraficos.construirPanelBarra(panel, 0, 0, 1200, 480, null, null);
        this.scrollpane.getVerticalScrollBar().setUI(sGraficosAvanzados.devolverScrollPersonalizado(
                7, 10, Color.WHITE, sRecursos.getColorAzul(), sRecursos.getColorAzulClaro())
        );
        this.scrollpane.getHorizontalScrollBar().setUI(sGraficosAvanzados.devolverScrollPersonalizado(
                7, 10, Color.WHITE, sRecursos.getColorAzul(), sRecursos.getColorAzulClaro())
        );
        this.pPrincipal.add(scrollpane);
        this.scrollpane.revalidate();
    }

    public JPanel getpBarraSuperior() {
        return pBarraSuperior;
    }

    public JPanel getpNavegacion() {
        return pNavegacion;
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public JButton getbCerrar() {
        return bCerrar;
    }

    public JButton getbMinimizar() {
        return bMinimizar;
    }

    public JButton getbInsertar() {
        return bInsertar;
    }

    public JButton getbModificar() {
        return bModificar;
    }

    public JButton getbBorrar() {
        return bBorrar;
    }

    public JButton getbListar() {
        return bListar;
    }

}
