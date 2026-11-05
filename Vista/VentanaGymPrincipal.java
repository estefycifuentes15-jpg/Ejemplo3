package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaGymPrincipal extends JFrame {
    private JTable tablaSocios;
    private DefaultTableModel modeloTabla;
    private JButton btnAbrirRegistro, btnAlternarPago;
    private JLabel lblResumen;

    public VentanaGymPrincipal() {
        setTitle("Control de Gimnasio - Panel Principal (MVC)");
        setSize(820, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Superior: Botones y Estadísticas
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        btnAbrirRegistro = new JButton("+ Registrar Nuevo Socio");
        btnAlternarPago = new JButton("Cambiar Estado de Pago");
        lblResumen = new JLabel("Socios Al Día: 0 | Vencidos: 0");
        lblResumen.setFont(new Font("Arial", Font.BOLD, 12));

        panelSuperior.add(btnAbrirRegistro);
        panelSuperior.add(btnAlternarPago);
        panelSuperior.add(Box.createHorizontalStrut(15));
        panelSuperior.add(lblResumen);
        add(panelSuperior, BorderLayout.NORTH);

        // Centro: Tabla de Socios
        modeloTabla = new DefaultTableModel(new String[]{"Cédula / ID", "Nombre Completo", "Membresía", "Estado de Pago"}, 0);
        tablaSocios = new JTable(modeloTabla);
        add(new JScrollPane(tablaSocios), BorderLayout.CENTER);
    }

    public JButton getBtnAbrirRegistro() { return btnAbrirRegistro; }
    public JButton getBtnAlternarPago() { return btnAlternarPago; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }
    public JTable getTablaSocios() { return tablaSocios; }
    
    public void actualizarResumen(int alDia, int vencidos) {
        lblResumen.setText("Socios Al Día: " + alDia + " | Vencidos: " + vencidos);
    }
}