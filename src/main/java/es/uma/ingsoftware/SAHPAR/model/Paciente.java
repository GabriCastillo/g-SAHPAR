package es.uma.ingsoftware.SAHPAR.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity

public class Paciente implements Comparable<Paciente> {
    @Id
    private String seguridadSocial;
    private String dni;
    private String nombre;
    private String apellidos;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    private Date nacimiento;
    private String direccion;
    private String datosSanitarios;
    private String estado = "verde";    // Verde por defecto y cambia segun datos del sensor
    private double limiteRojo;
    private double limiteAmarillo;
    private String tlfContc;
    private String doctor;
    private String habitacion;


    /*  @OneToOne
      Sensor sensor;*/
    @ManyToMany
    List<Usuario> usuario;

    public Paciente() {
    	
    }

    public String comprobarPaciente(double frec) {
        String st;
        if (frec <= limiteRojo && frec > 0) {
            st = "rojo";
        } else if (frec <= limiteAmarillo && frec > limiteRojo) {
            st = "amarillo";
        } else if (frec == 0) {
            st = "negro";
        } else {
            st = "verde";
        }
        return st;
    }

    public String getSeguridadSocial() {
        return seguridadSocial;
    }

    public void setSeguridadSocial(String seguridadSocial) {
        this.seguridadSocial = seguridadSocial;
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

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDatosSanitarios() {
        return datosSanitarios;
    }

    public void setDatosSanitarios(String datosSanitarios) {
        this.datosSanitarios = datosSanitarios;
    }

    public void cambiarEstado() {
        int prob;
        double frecuencia;
        prob = (int) (Math.random() * 101);
        if (prob <= 20 && prob > 0) {
            frecuencia = Math.random() * (40);
        } else if (prob <= 45 && prob > 20) {
            frecuencia = Math.random() * (59 - 40 + 1) + 40;
        } else if (prob <= 50 && prob > 45) {
            frecuencia = 0;
        } else {
            frecuencia = Math.random() * (100 - 60 + 1) + 60;
        }
        String status = comprobarPaciente(frecuencia);
        setEstado(status);
    }
    public String getEstado() {
    	return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getLimiteRojo() {
        return limiteRojo;
    }

    public void setLimiteRojo(double limiteRojo) {
        this.limiteRojo = limiteRojo;
    }

    public double getLimiteAmarillo() {
        return limiteAmarillo;
    }

    public void setLimiteAmarillo(double limiteAmarillo) {
        this.limiteAmarillo = limiteAmarillo;
    }

    public String getTlfContc() {
        return tlfContc;
    }

    public void setTlfContc(String tlfContc) {
        this.tlfContc = tlfContc;
    }

    public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}

	@Override
    public int hashCode() {
        return seguridadSocial.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Paciente) {
            Paciente pac = (Paciente) obj;
            if (seguridadSocial.equalsIgnoreCase(pac.seguridadSocial)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Paciente [nombre=" + nombre + ", apellidoselidos=" + apellidos + ", direccion=" + direccion
                + ", seguridadSocial=" + seguridadSocial + ", datosSanitarios=" + datosSanitarios + ", limiteRojo="
                + limiteRojo + ", limiteAmarillo=" + limiteAmarillo + ", tlfContacto=" + tlfContc + "]";
    }

    @Override
    public int compareTo(Paciente o) {
        int prioridad1 = 0, prioridad2 = 0;
        if (estado.equalsIgnoreCase("negro")) {
            prioridad1 = 1;
        } else if (estado.equalsIgnoreCase("rojo")) {
            prioridad1 = 2;
        } else if (estado.equalsIgnoreCase("amarillo")) {
            prioridad1 = 3;
        } else if (estado.equalsIgnoreCase("verde")) {
            prioridad1 = 4;
        }
        if (o.estado.equalsIgnoreCase("negro")) {
            prioridad2 = 1;
        } else if (o.estado.equalsIgnoreCase("rojo")) {
            prioridad2 = 2;
        } else if (o.estado.equalsIgnoreCase("amarillo")) {
            prioridad2 = 3;
        } else if (o.estado.equalsIgnoreCase("verde")) {
            prioridad2 = 4;
        }
        int resultado = Integer.compare(prioridad1, prioridad2);
        if (resultado == 0) {
            resultado = nombre.compareTo(o.nombre);
        }
        return resultado;
    }

}
