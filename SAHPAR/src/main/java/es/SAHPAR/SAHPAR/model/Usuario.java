package es.SAHPAR.SAHPAR.model;

public abstract class Usuario {
    private String username;
    private String passw;
    private String foto;
    private String dni;
    private String nombre;
    private String apellidos;

    public Usuario() {
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

}
