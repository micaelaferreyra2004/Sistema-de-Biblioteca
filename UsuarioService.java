package org.escuela.programacionIII2024.modelo;


import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void eliminarUsuario(String dni) {
        usuarios.removeIf(usuario -> usuario.getDni().equals(dni));
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
