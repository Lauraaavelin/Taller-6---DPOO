package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante()
    {
        // Configura el layout principal
        setLayout(new GridLayout(3, 1, 5, 5)); // 3 filas, 1 columna

        // -------------- Panel para el nombre --------------
        JPanel panelNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblNombre = new JLabel("Nombre: ");
        txtNombre = new JTextField(20);
        panelNombre.add(lblNombre);
        panelNombre.add(txtNombre);
        add(panelNombre);

        // ------------- Panel para la calificación ----------
        JPanel panelCalificacion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblCalificacion = new JLabel("Calificación (1-5): ");
        cbbCalificacion = new JComboBox<>();
        for (int i = 1; i <= 5; i++) {
            cbbCalificacion.addItem(String.valueOf(i));
        }
        panelCalificacion.add(lblCalificacion);
        panelCalificacion.add(cbbCalificacion);
        add(panelCalificacion);

        // ---------- Panel para visitado -------------
        JPanel panelVisitado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblVisitado = new JLabel("¿Visitado?: ");
        cbbVisitado = new JComboBox<>();
        cbbVisitado.addItem("Sí");
        cbbVisitado.addItem("No");
        panelVisitado.add(lblVisitado);
        panelVisitado.add(cbbVisitado);
        add(panelVisitado);
    }


    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return
     */
    public boolean getVisitado()
    {
        return cbbVisitado.getSelectedItem().equals("Sí");
    }


    /**
     * Indica la calificación marcada en el selector
     * @return
     */
    public int getCalificacion( )
    {
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        return Integer.parseInt( calif );
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return
     */
    public String getNombre()
    {
        return txtNombre.getText().trim(); // trim() para quitar espacios innecesarios
    }

}
