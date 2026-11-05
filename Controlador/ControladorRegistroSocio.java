package Controlador;

import Modelo.GymControl;
import Modelo.Socio;
import Vista.VentanaRegistroSocio;

import javax.swing.*;

public class ControladorRegistroSocio {
    private VentanaRegistroSocio vistaRegistro;
    private GymControl modeloGym;
    private ControladorGymPrincipal controladorPrincipal;

    public ControladorRegistroSocio(VentanaRegistroSocio vistaRegistro, GymControl modeloGym, ControladorGymPrincipal controladorPrincipal) {
        this.vistaRegistro = vistaRegistro;
        this.modeloGym = modeloGym;
        this.controladorPrincipal = controladorPrincipal;

        this.vistaRegistro.getBtnGuardarSocio().addActionListener(e -> guardarSocio());
    }

    private void guardarSocio() {
        String cedula = vistaRegistro.getTxtCedula().getText().trim();
        String nombre = vistaRegistro.getTxtNombre().getText().trim();

        if (cedula.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegistro, "Todos los campos de texto son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String membresia = (String) vistaRegistro.getCmbMembresia().getSelectedItem();
        String estado = (String) vistaRegistro.getCmbEstado().getSelectedItem();

        Socio nuevoSocio = new Socio(cedula, nombre, membresia, estado);
        modeloGym.agregarSocio(nuevoSocio);

        controladorPrincipal.refrescarTabla();
        vistaRegistro.limpiarCampos();
        vistaRegistro.dispose();
    }
}