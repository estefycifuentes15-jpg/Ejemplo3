package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroSocio extends JDialog {
    private JTextField txtCedula, txtNombre;
    private JComboBox<String> cmbMembresia, cmbEstado;
    private JButton btnGuardarSocio;

    public VentanaRegistroSocio(JFrame parent) {
        super(parent, "Registro de Nuevo Socio", true);
        setSize(360, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("  Cédula / ID:"));
        txtCedula = new JTextField();
        add(txtCedula);

        add(new JLabel("  Nombre Completo:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("  Membresía:"));
        cmbMembresia = new JComboBox<>(new String[]{"VIP (Gym + Spa)", "Regular (Solo Pesas)", "Estudiantil"});
        add(cmbMembresia);

        add(new JLabel("  Estado de Pago:"));
        cmbEstado = new JComboBox<>(new String[]{"Al día", "Vencido"});
        add(cmbEstado);

        add(new JLabel()); // Espacio vacío
        btnGuardarSocio = new JButton("Guardar Socio");
        add(btnGuardarSocio);
    }

    public JTextField getTxtCedula() { return txtCedula; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JComboBox<String> getCmbMembresia() { return cmbMembresia; }
    public JComboBox<String> getCmbEstado() { return cmbEstado; }
    public JButton getBtnGuardarSocio() { return btnGuardarSocio; }
    public void limpiarCampos() {
        txtCedula.setText("");
        txtNombre.setText("");
    }
}