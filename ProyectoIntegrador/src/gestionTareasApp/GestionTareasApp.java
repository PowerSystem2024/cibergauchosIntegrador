
package gestionTareasApp;

import java.text.ParseException;
import java.util.Scanner;
import servicio.ServicioTarea;


public class GestionTareasApp {
    
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        boolean ejecucion = true;
       
        // Creamos un objeto servicio tarea que es el que se encarga de llamar a los métodos
        ServicioTarea servicioTarea = new ServicioTarea();
        
        while(ejecucion){
            System.out.println("============ MENÚ GESTIÓN DE TAREAS ============");
            System.out.println("1. Crear tarea");
            System.out.println("2. Modificar tarea");
            System.out.println("3. Mostrar tarea");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = input.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("********* CREAR TAREA *********");
                    servicioTarea.crearTarea();
                    break;
                case 2:
                    System.out.println("********* MODIFICAR TAREA *********");
                    servicioTarea.modificarTarea();
                    break;
                case 3:
                    System.out.println("********* MOSTRAR TAREA *********");
                    
                    servicioTarea.mostrarTarea();
                    break;
                case 4:
                    System.out.println("********* ELIMINAR TAREA *********");
                    servicioTarea.eliminarTarea();
                    break;
                case 5:
                    ejecucion = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    
            }
        }
    }
    
   
}
