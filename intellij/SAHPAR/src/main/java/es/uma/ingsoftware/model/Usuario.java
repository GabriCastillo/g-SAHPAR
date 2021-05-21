package es.uma.ingsoftware.model;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Usuario {

    private String dni;
    private String username;
    private String passw;
    private String foto;
    private int type;
    private String nombre;
    private String apellidos;

    public Usuario() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public void editarFoto() {
    }

    public void avisarMedico() {
    }

    public void añadirPaciente(Paciente paciente) {
    }

    public void buscarPaciente() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return getDni().equals(usuario.getDni()) && getNombre().equals(usuario.getNombre()) && getApellidos().equals(usuario.getApellidos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDni(), getNombre(), getApellidos());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
