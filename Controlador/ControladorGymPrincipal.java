package Controlador;

import Modelo.GymControl;
import Modelo.Socio;
import Vista.VentanaGymPrincipal;
import Vista.VentanaRegistroSocio;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class ControladorGymPrincipal {
    private VentanaGymPrincipal vistaPrincipal;
    private GymControl modeloGym;
    private VentanaRegistroSocio vistaRegistro;

    public ControladorGymPrincipal(VentanaGymPrincipal vistaPrincipal, GymControl modeloGym) {
        this.vistaPrincipal = vistaPrincipal;
        this.modeloGym = modeloGym;

        this.vistaPrincipal.getBtnAbrirRegistro().addActionListener(e -> abrirVentanaRegistro());
        this.vistaPrincipal.getBtnAlternarPago().addActionListener(e -> cambiarEstadoPago());
    }

    private void abrirVentanaRegistro() {
        if (vistaRegistro == null) {
            vistaRegistro = new VentanaRegistroSocio(vistaPrincipal);
            new ControladorRegistroSocio(vistaRegistro, modeloGym, this);
        }
        vistaRegistro.setVisible(true);
    }

    public void refrescarTabla() {
        DefaultTableModel modelo = vistaPrincipal.getModeloTabla();
        modelo.setRowCount(0); // Limpiar tabla

        for (Socio s : modeloGym.getListaSocios()) {
            modelo.addRow(new Object[]{
                s.getCedula(),
                s.getNombre(),
                s.getMembresia(),
                s.getEstadoPago()
            });
        }

        vistaPrincipal.actualizarResumen(modeloGym.contarSociosAlDia(), modeloGym.contarSociosVencidos());
    }

    private void cambiarEstadoPago() {
        int fila = vistaPrincipal.getTablaSocios().getSelectedRow();
        if (fila != -1) {
            Socio socioSeleccionado = modeloGym.getListaSocios().get(fila);
            if (socioSeleccionado.getEstadoPago().equals("Al día")) {
                socioSeleccionado.setEstadoPago("Vencido");
            } else {
                socioSeleccionado.setEstadoPago("Al día");
            }
            refrescarTabla();
        } else {
            JOptionPane.showMessageDialog(vistaPrincipal, "Selecciona un socio de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}