
package tarea;

import java.time.LocalDate;

public class Tarea {
    /*
    La clase 'Tarea' representa una tarea genérica, que tiene información básica
    como el nombre de la tarea, descripción, la fecha que fue creada,
    fecha de vencimiento, la prioridad (baja-media-alta) y si aún esta activa o no.
    */
    
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    private LocalDate fechaVencimiento;
    private String prioridad;
    private boolean activa;
    
    public Tarea() {
    }

    public Tarea(String nombre, String descripcion, LocalDate fechaCreacion, LocalDate fechaVencimiento, String prioridad, boolean activa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
        this.activa = activa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
