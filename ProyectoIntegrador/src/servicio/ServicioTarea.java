
package servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import tarea.Tarea;


public class ServicioTarea {
    
    private Scanner input = new Scanner(System.in);
    private Tarea tarea = new Tarea();
   
    
    public void crearTarea() throws ParseException{
        
        // 1. Pedimos los datos al usuario
        System.out.print("Introduce el nombre de la nueva tarea: ");
        String nuevoNombre = input.nextLine(); // Guardamos el nombre en una variable
        tarea.setNombre(nuevoNombre); // Y la reemplazamos mediante el método set.
        
        // Ahora pedimos una descripcion sobre la tarea a realizar:
        System.out.print("Introduce la descripción de la tarea: ");
        String descripcion = input.nextLine(); // La guardamos en una variable
        tarea.setDescripcion(descripcion); // Y la reemplazamos por el método set.
        
        // Luego la fecha
        System.out.print("Introduce la fecha de vencimiento (formato Año/Mes/Día): ");
        String fechaString = input.nextLine(); // Acá pedimos la fecha como String para poder transformarla en tipo Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); // Esto significa que se debe ingresar dia, mes y año con las barras (2024/11/10)
        Date fechaVencimiento = dateFormat.parse(fechaString); //Pasamos la fecha string a la variable en tipo date
        tarea.setFechaVencimiento(fechaVencimiento); // Y la reemplazamos con el método set

        // 2. Pedimos la prioridad de la tarea solo con opciones limitadas
        System.out.println("Selecciona la prioridad (Baja, Media, Alta): ");
        String prioridad = "";
        boolean opcion = false; 
        while (!opcion) { // Usamos el ciclo while para que solo se pueda seleccionar una de las 3 opciones
            prioridad = input.nextLine().toLowerCase(); // Convertimos el texto por si ingresarion la opcion en mayusculas
            switch (prioridad) {
                case "baja":
                case "media":
                case "alta":
                    opcion = true;
                    break;
                default:
                    System.out.println("Opción inválida. Selecciona: Baja, Media o Alta.");
            }
        }
        tarea.setPrioridad(prioridad); // Mandamos con el método set la prioridad

        // 3. Establecer fecha de creación y estado de la tarea
        tarea.setFechaCreacion(new Date());  // Guarda la fecha actual como la de creación automaticamente
        tarea.setEsActiva(true);  // Marcar como activa la tarea.

        // Mostramos la tarea como fue ingresada
        System.out.println("Tarea creada!.");   // Acá deberia pegarse el método mostrarTarea()
        // AGREGAR VALIDACIONES PARA QUE NO SE PUEDAN INGRESAR DATOS RANDOM.
    }
    
    public void modificarTarea(){
        // Implementar lógica para modificar una tarea
    }
    
    public void mostrarTarea(){
        // Implementar lógica para mostrar una tarea
    }
    
    public  void eliminarTarea(){
        // Implementar lógica para eliminar una tarea
    }
}
