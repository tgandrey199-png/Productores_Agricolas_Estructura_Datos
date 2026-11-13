package com.example.productores_agricolas.services;

import com.example.productores_agricolas.dto.CreateUsuarioRequest;
import com.example.productores_agricolas.models.Usuario;
import com.example.productores_agricolas.structures.MiListaLigada;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {

    private final MiListaLigada<Usuario> usuarios = new MiListaLigada<>();
    private Long nextId = 1L;

    public UsuarioService() {
        // Los 3 registros de ejemplo obligatorios
        crearUsuarioInterno("juanP", "juan@mail.com", "hash123", "555-1234");
        crearUsuarioInterno("mariaG", "maria@mail.com", "hash456", "555-5678");
        crearUsuarioInterno("carlosR", "carlos@mail.com", "hash789", "555-9012");
    }

    private void crearUsuarioInterno(String nombre, String correo, String pass, String tel) {
        Usuario u = new Usuario();
        u.setId(nextId++);
        u.setNombreUsuario(nombre);
        u.setCorreo(correo);
        u.setContrasenaHash(pass);
        u.setTelefono(tel);
        u.setFechaRegistro(LocalDate.now());
        u.setEstado("ACTIVO");
        usuarios.agregar(u);
    }

    public List<Usuario> obtenerTodos() {
        return usuarios.toList();
    }

    public Usuario obtenerPorId(Long id) {
        return usuarios.toList().stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Usuario crear(CreateUsuarioRequest req) {
        Usuario u = new Usuario();
        u.setId(nextId++);
        u.setNombreUsuario(req.getNombreUsuario());
        u.setCorreo(req.getCorreo());
        u.setContrasenaHash("hash_de_" + req.getContrasena());
        u.setTelefono(req.getTelefono());
        u.setFechaRegistro(LocalDate.now());
        u.setEstado("ACTIVO");

        usuarios.agregar(u);
        return u;
    }
}