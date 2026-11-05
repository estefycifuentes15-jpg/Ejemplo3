package Modelo;

import java.util.ArrayList;
import java.util.List;

public class GymControl {
    private List<Socio> listaSocios = new ArrayList<>();

    public void agregarSocio(Socio socio) {
        listaSocios.add(socio);
    }

    public List<Socio> getListaSocios() {
        return listaSocios;
    }

    public int contarSociosAlDia() {
        int count = 0;
        for (Socio s : listaSocios) {
            if (s.getEstadoPago().equals("Al día")) count++;
        }
        return count;
    }

    public int contarSociosVencidos() {
        int count = 0;
        for (Socio s : listaSocios) {
            if (s.getEstadoPago().equals("Vencido")) count++;
        }
        return count;
    }
}