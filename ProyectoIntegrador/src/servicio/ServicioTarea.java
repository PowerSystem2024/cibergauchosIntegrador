package servicio;

import java.time.LocalDate;
import java.util.Scanner;
import tarea.Tarea;
import utilidades.UtilidadTarea;

public class ServicioTarea {

    private final Scanner input = new Scanner(System.in);
    private final Tarea tarea = new Tarea();
    private final UtilidadTarea utilidadTarea = new UtilidadTarea();

    // ----------------- MÉTODO CREA UNA TAREA ESPECÍFICA --------------------------
    public void crearTarea() {
        if (tarea.isActiva()) {
            System.out.println("Ya tienes una tarea pendiente, finalizala para crear otra nuevamente.");
            return;
        }
        String nombre, descripcion;
        do {
            // Solicitamos nombre y descripcion al usuario
            System.out.println("Introduce el nombre de la tarea: ");
            nombre = input.nextLine().trim();
            System.out.println("Introduce la descripción de la tarea: ");
            descripcion = input.nextLine().trim();

            // Nos aseguramos que no se ingresen campos vacíos
            if (nombre.isEmpty() || descripcion.isEmpty()) {
                System.out.println("¡ERROR! Los campos no pueden estar vacíos.");
            }
        } while (nombre.isEmpty() || descripcion.isEmpty());
        tarea.setNombre(nombre);
        tarea.setDescripcion(descripcion);
        // Establecer fecha de creación y estado de la tarea
        tarea.setFechaCreacion(LocalDate.now());  // Asignamos la fecha actual como la de creacion
        tarea.setActiva(true);  // La establecemos como true, ya que estamos creando la tarea

        // Selección de método para ingresar fecha de vencimiento
        System.out.println("Selecciona el método para definir la fecha de vencimiento:");
        System.out.println("1- Ingresar una fecha de vencimiento específica (formato yyyy/MM/dd)");
        System.out.println("2- Establecer una cantidad de días a partir hoy");
        int opcion = Integer.parseInt(input.nextLine().trim());

        switch (opcion) {
            case 1: {
                System.out.println("Ingrese la fecha de vencimiento siguiendo el formato yyyy/MM/dd (Año/Mes/Dia): ");
                solicitarFechaVencimiento();
                break;
            }
            case 2: {
                System.out.print("Introduce la cantidad de días a partir de hoy para establecer la fecha de vencimiento: ");
                int dias = Integer.parseInt(input.nextLine().trim());
                // Verificación de días
                while (dias < 1) {
                    System.out.println("La fecha de vencimiento debe ser con al menos un día de posterioridad.");
                    dias = Integer.parseInt(input.nextLine().trim());
                }
                // Establecemos la fecha de vencimiento usando el método sumarDiasAFecha
                LocalDate fechaVencimiento = utilidadTarea.sumarDiasAFecha(tarea.getFechaCreacion(), dias);
                tarea.setFechaVencimiento(fechaVencimiento); // Seteamos la fecha de vencimiento al objeto tarea
                break;
            }
            default: {
                System.out.println("Opción no válida. Intenta de nuevo.");
                break;
            }
        }
        // Solicitamos la prioridad al usuario
        String prioridad = "";
        boolean aux = true;
        while (aux) {
            System.out.println("Selecciona la prioridad (baja, media, alta): ");
            prioridad = input.nextLine().trim().toLowerCase();

            switch (prioridad) {
                case "baja", "media", "alta":
                    aux = false;
                    break;
                default:
                    System.out.println("Opción inválida. Selecciona: Baja, Media o Alta.");
            }
        }
        tarea.setPrioridad(prioridad); // Seteamos la prioridad al objeto tarea

        // Mostramos mensaje de confirmacion
        System.out.println("La tarea '" + tarea.getNombre() + "', fue creada correctamente.");
    }

    // ----------------- MÉTODO QUE MODIFICA LOS CAMPOS DESEADOS DE LA TAREA --------------------------
    public void modificarTarea() {
        // Comprobamos si existe una tarea
        if (!tarea.isActiva()) {
            System.out.println("¡ERROR! No existe ninguna tarea por el momento.");
            return;
        }
        boolean continuar = true;
        // Esto le mostrara al usuario que campo desea modificar
        while (continuar) {
            System.out.println("¿Que desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Descripcion");
            System.out.println("3. Fecha de vencimiento");
            System.out.println("4. Prioridad");
            System.out.println("5. Volver al menú principal");

            int opcion = Integer.parseInt(input.nextLine().trim());
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre: ");
                    String nuevoNombre = input.nextLine().trim();

                    if (nuevoNombre.isEmpty()) {
                        System.out.println("¡ERROR! El nombre no puede estar vacío.");
                    } else {
                        tarea.setNombre(nuevoNombre);
                        System.out.println("Nombre de la tarea cambiado exitosamente. El nuevo nombre es '" + nuevoNombre + "'");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la nueva descripción: ");
                    String nuevaDescripcion = input.nextLine().trim();
                    if (nuevaDescripcion.isEmpty()) {
                        System.out.println("¡ERROR! La descripción no puede estar vacía.");
                        break;
                    } else {
                        tarea.setDescripcion(nuevaDescripcion);
                        System.out.println("Descripción de la tarea cambiada exitosamente. La nueva descripción es '" + nuevaDescripcion + "'");
                        break;
                    }
                case 3:
                    System.out.println("Ingrese la nueva fecha de vencimiento siguiendo el formato yyyy/MM/dd (Año/Mes/Dia): ");
                    solicitarFechaVencimiento();
                    System.out.println("Fecha de vencimiento actualizada correctamente. La nueva fecha de vencimiento es: " + tarea.getFechaVencimiento());
                    break;
                case 4:
                    // Solicitamos la prioridad al usuario
                    String prioridad = "";
                    boolean aux = true;
                    while (aux) {
                        System.out.println("Selecciona la prioridad (baja, media, alta): ");
                        prioridad = input.nextLine().trim().toLowerCase();

                        switch (prioridad) {
                            case "baja", "media", "alta":
                                aux = false;
                                break;
                            default:
                                System.out.println("Opción inválida. Selecciona: Baja, Media o Alta.");
                        }
                    }
                    tarea.setPrioridad(prioridad);
                    System.out.println("Prioridad cambiada exitosamente. La nueva prioridad es: " + tarea.getPrioridad());
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta. Por favor, vuelva a intentarlo.");
            }
        }
    }

    // ----------------- MÉTODO MUESTRA TODOS LOS DATOS DE UNA TAREA --------------------------
    public void mostrarTarea() {
        // Comprobamos si existe una tarea
        if (!tarea.isActiva()) {
            System.out.println("¡ERROR! No existe ninguna tarea por el momento.");
            return;
        }
        String separador = "+-------------------------------------------+";
        System.out.println(separador);
        System.out.println("--> Nombre: " + tarea.getNombre());
        System.out.println("--> Descripcion: " + tarea.getDescripcion());
        System.out.println("--> Fecha de Creacion: " + tarea.getFechaCreacion());
        System.out.println("--> Fecha de Vencimiento: " + tarea.getFechaVencimiento());
        System.out.println("--> Prioridad: " + tarea.getPrioridad());
        System.out.println("--> Estado: Activa");

        Long diasRestantes = utilidadTarea.calcularDiasHastaVencimiento(tarea.getFechaVencimiento());
        System.out.println("--> Días Restantes: Te quedan " + diasRestantes + " días restantes para completar la tarea.");

        System.out.println(separador);
    }

    // ----------------- MÉTODO QUE DA POR FINALIZADA UNA TAREA --------------------------
    public void finalizarTarea() {
        // Verificar si la tarea ya está inactiva
        if (!tarea.isActiva()) {
            System.out.println("No hay ninguna tarea activa para finalizar.");
            return;
        }
        // Preguntar al usuario si está seguro de finalizar la tarea
        System.out.println("¿Está seguro de que desea dar por finalizada la tarea? (si/no)");
        String confirmacion = input.nextLine().trim().toLowerCase();

        // Validar la confirmación del usuario
        switch (confirmacion) {
            case "si":
                // Establecemos el campo activa como falso y los otros campos los dejamos nulos.
                tarea.setActiva(false);
                tarea.setDescripcion(null);
                tarea.setNombre(null);
                tarea.setPrioridad(null);
                tarea.setFechaVencimiento((LocalDate) null);
                System.out.println("La tarea ha sido eliminada exitosamente.");
                return;

            case "no":
                // Si el usuario cancela la eliminación
                System.out.println("La tarea sigue vigente con fecha de vencimiento para " + tarea.getFechaVencimiento());
            default:
                System.out.println("Opción no válida. Eliminación cancelada.");
        }
    }

    public void solicitarFechaVencimiento() {
        while (true) {
            String fechaString = input.nextLine().trim();
            LocalDate fechaVencimiento = utilidadTarea.parsearFecha(fechaString);
            if (utilidadTarea.calcularDiasHastaVencimiento(fechaVencimiento) < 1) {
                System.out.println("La fecha de vencimiento debe ser al menos con un día de posterioridad.");
                System.out.println("Por favor ingrese una fecha válida.");
            } else {
                tarea.setFechaVencimiento(fechaVencimiento);
                break;
            }
        }
    }
}
