import Modelo.GymControl;
import Vista.VentanaGymPrincipal;
import Controlador.ControladorGymPrincipal;

public class MainGym {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            VentanaGymPrincipal vista = new VentanaGymPrincipal();
            GymControl modelo = new GymControl();
            new ControladorGymPrincipal(vista, modelo);
            vista.setVisible(true);
        });
    }
}