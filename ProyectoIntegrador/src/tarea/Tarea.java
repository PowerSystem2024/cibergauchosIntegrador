
package tarea;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Tarea {
    
    /*
    La clase 'Tarea' representa una tarea genérica, que tiene información básica
    como el nombre de la tarea, descripción, la fecha que fue creada,
    fecha de vencimiento, la prioridad (baja-media-alta) y si aún esta activa o no.
    */
    
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaVencimiento;
    private String prioridad;
    private boolean esActiva;
    
    public Tarea() {
    }

    public Tarea(String nombre, String descripcion, Date fechaCreacion, Date fechaVencimiento, String prioridad, boolean esActiva) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
        this.esActiva = esActiva;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isEsActiva() {
        return esActiva;
    }

    public void setEsActiva(boolean esActiva) {
        this.esActiva = esActiva;
    }
    
    public boolean getEsActiva() {
        return esActiva; 
    }

    public void setFechaVencimiento(String nuevaFecha) {
        throw new UnsupportedOperationException("Aún no es compatible."); 
    }

    public String formatearfecha(Date fecha) {
        String fechaFormateada;
        SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy/MM/dd");
        fechaFormateada = formatoSalida.format(fecha);
        return fechaFormateada;
    }
    
    public int calcularDiasEntreFechas() {
    int miliSegundosPorDia = 86400000;
    long diferenciaEnMilisegundos = fechaVencimiento.getTime() - fechaCreacion.getTime();
    return (int) (diferenciaEnMilisegundos / (miliSegundosPorDia));
    }
    
    public Date sumarDiasAFechaCreacion(Date fechaDeCreacion, int dias) {
    long milisegundosPorDia = 86400000L;
    long nuevaFechaMilis = fechaDeCreacion.getTime() + (dias * milisegundosPorDia);
    return new Date(nuevaFechaMilis);
}
}
