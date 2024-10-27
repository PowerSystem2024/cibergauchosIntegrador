
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
        
        // 2. Establecer fecha de creación y estado de la tarea
        tarea.setFechaCreacion(new Date());  // Guarda la fecha actual como la de creación automaticamente
        tarea.setEsActiva(true);  // Marcar como activa la tarea.        

        // Luego la fecha
        System.out.print("Introduce la fecha de vencimiento (formato Año/Mes/Día): ");
        String fechaString = input.nextLine(); // Acá pedimos la fecha como String para poder transformarla en tipo Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); // Esto significa que se debe ingresar dia, mes y año con las barras (2024/11/10)
        Date fechaVencimiento = dateFormat.parse(fechaString); //Pasamos la fecha string a la variable en tipo date
        tarea.setFechaVencimiento(fechaVencimiento); // Y la reemplazamos con el método set

        // 3. Pedimos la prioridad de la tarea solo con opciones limitadas
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

        
        // Mostramos la tarea como fue ingresada
        System.out.println("Tarea creada!.");   // Acá deberia pegarse el método mostrarTarea()
        // AGREGAR VALIDACIONES PARA QUE NO SE PUEDAN INGRESAR DATOS RANDOM.
    }
    
    // Metodo para modificar la tarea 
    public void modificarTarea() throws ParseException{
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        // Esto le mostrara al usuario que campo desea modificar
        while (continuar){
            System.out.println("¿Que desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Descripcion");
            System.out.println("3. Fecha de vencimiento");
            System.out.println("4. Prioridad");
            System.out.println("5. Salir");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el nuevo nombre: "); // Agregaremos el nuevo nombre
                    String nuevoNombre = scanner.nextLine();
                    tarea.setNombre(nuevoNombre);
                    System.out.println("El nuevo nombre es "+nuevoNombre);// Se mostrara el nuevo nombre
                    break;
                case 2:
                    System.out.print("Ingrese la nueva descripción: ");
                    String nuevaDescripcion = scanner.nextLine();
                    tarea.setDescripcion(nuevaDescripcion);
                    System.out.println("La nueva descripcion es "+ nuevaDescripcion);
                    break;
                case 3:
                    System.out.print("Ingrese la nueva fecha de vencimiento (Formato: YYYY-MM-DD): ");
                    String nuevaFechaStr = scanner.nextLine();
                    SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-DD"); //Define el formato
                    Date nuevaFecha = formato.parse(nuevaFechaStr); //Covierte el string a date
                    tarea.setFechaVencimiento(nuevaFecha); //Convierte date a string y lo asigna
                    System.out.println("La nueva fecha de vencimiento es "+nuevaFecha);
                    break;
                case 4:
                    boolean prioridadValida = false;
                    while (!prioridadValida){
                        System.out.println("Elija la nueva prioridad (baja, media, alta): ");
                        String nuevaPrioridad = scanner.nextLine().toLowerCase();
                        
                        if (nuevaPrioridad.equals("baja") || nuevaPrioridad.equals("media") || nuevaPrioridad.equals("alta")) {
                            tarea.setPrioridad(nuevaPrioridad);
                            System.out.println("La nueva priodad es "+nuevaPrioridad);
                            prioridadValida = true;
                        } else {
                            System.out.println("Opcion incorrecta ,intente de nuevo");
                        }
                    }
                    break;
                case 5:
                    continuar = false;// Se dejara de ejecutar 
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion incorrecta. Por favor, vuelva a intentarlo");
            }
        }
    }
  
    
    public void mostrarTarea(){
        String mensaje;
        String activa;
        int diasRestantes = tarea.calcularDiasEntreFechas();

        if (tarea.isEsActiva() == true) {
            activa = "Activa";
        } else {
            activa = "Descativada";
        }

        if (tarea.getNombre() == null) {
            System.out.println("No hay datos para mostrar");
            return;
        }
        Scanner input = new Scanner(System.in);
        boolean ejecucion = true;
        System.out.print("Desea ver el detalle de la tarea en formato parrafo o tabla? \n");

        while (ejecucion) {
            System.out.println("1. Formato Tabla");
            System.out.println("2. Formato texto");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    String separador = "+-------------------+";
                    System.out.println(separador);
                    System.out.println("-->Nombre = " + tarea.getNombre());
                    System.out.println("-->Descripcion = " + tarea.getDescripcion());
                    System.out.println("-->Fecha de Creacion = " + tarea.formatearfecha(tarea.getFechaCreacion()));
                    System.out.println("-->Fecha de Vencimiento = " + tarea.formatearfecha(tarea.getFechaVencimiento()));
                    System.out.println("-->Prioridad = " + tarea.getPrioridad());
                    System.out.println("-->Estado= " + activa);
                    System.out.println("-->Días Restantes= Te quedan " + diasRestantes + " días restantes para completar la tarea.");
                    System.out.println(separador);
                    ejecucion = false;
                    break;
                case 2:
                    mensaje = "La tarea \"" + tarea.getNombre() + "\""
                        + " tiene en su descripcion \"" + tarea.getDescripcion() + "\".\n"
                        + "Fue creada en la fecha \"" + tarea.formatearfecha(tarea.getFechaCreacion()) + "\""
                        + ", cuenta con prioridad \"" + tarea.getPrioridad() + "\".\n"
                        + " y se encuentra \"" + activa + "\""
                        + " con  fecha de vencimiento \"" 
                        + tarea.formatearfecha(tarea.getFechaVencimiento()) + "\""
                        + " Y le quedan " + diasRestantes + " días restantes para completar la tarea.";
                    System.out.println("Descripcion tarea: \n" + mensaje);
                    ejecucion = false;
                    break;
                case 3:
                    ejecucion = false;
                    System.out.println("Saliendo de mostrar tarea");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
    
    public void eliminarTarea() throws ParseException{
    // Verificar si la tarea ya está inactiva
    if (!tarea.getEsActiva()) {
    System.out.println("No hay ninguna tarea activa para eliminar.");
    return; // No se continúa si no hay tarea activa
}
    // Preguntar al usuario si está seguro de eliminar la tarea
    System.out.println("¿Está seguro de que desea eliminar la tarea? (si/no)");
    String confirmacion = input.nextLine().toLowerCase();

        // Validar la confirmación del usuario
        switch (confirmacion) {
            case "si" -> {
                // Cambiar el estado de la tarea a inactiva
                tarea.setEsActiva(false);
                tarea.setDescripcion(null);
                tarea.setNombre(null);
                tarea.setPrioridad(null);
                tarea.setFechaVencimiento((Date)null);
                System.out.println("La tarea ha sido eliminada exitosamente.");
                return;
            }
            case "no" -> // Si el usuario cancela la eliminación
                System.out.println("Eliminación cancelada.");
            default -> // Manejar opciones no válidas
                System.out.println("Opción no válida. Eliminación cancelada.");
                
        }
    }
}
