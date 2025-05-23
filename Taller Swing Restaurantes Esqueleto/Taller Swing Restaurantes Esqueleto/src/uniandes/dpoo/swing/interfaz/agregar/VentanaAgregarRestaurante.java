package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import uniandes.dpoo.swing.interfaz.principal.*;
import uniandes.dpoo.swing.mundo.Restaurante;

import uniandes.dpoo.swing.interfaz.mapa.PanelMapaVisualizar;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
        this.ventanaPrincipal = principal;
        setLayout( new BorderLayout( ) );

        // Agrega el panel donde va a estar el mapa
        panelMapa = new PanelMapaAgregar(); 
        add(panelMapa, BorderLayout.CENTER);

        // Agrega en el sur un panel para los detalles del restaurante y para los botones
        JPanel PanelSur = new JPanel(new BorderLayout());
        panelDetalles = new PanelEditarRestaurante( );
        panelBotones = new PanelBotonesAgregar( this );
        
        PanelSur.add(panelDetalles,BorderLayout.CENTER );
        PanelSur.add( panelBotones ,BorderLayout.SOUTH );
        
        add(PanelSur,BorderLayout.SOUTH );
       
        
        
        // Termina de configurar la ventana
        pack( );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setResizable( false );
    }

    /**
     * Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
     */
    public void agregarRestaurante( )
    {
       int calificacion = panelDetalles.getCalificacion();
       String nombre = panelDetalles.getNombre();
       int[] cordenadas = panelMapa.getCoordenadas();
       int x =cordenadas[0];
       int y = cordenadas[1];
       boolean visitado = panelDetalles.getVisitado();
       
       ventanaPrincipal.agregarRestaurante(nombre, calificacion, x, y, visitado);
       
       dispose();
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana( )
    {
        dispose( );
    }

}
