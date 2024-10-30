package utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class UtilidadTarea {

    public LocalDate parsearFecha(String fechaString) {
       
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try {
            // Parseamos el String a LocalDate usando el formato dado
            return LocalDate.parse(fechaString, formato);
        } catch (DateTimeParseException e) {
            System.out.println("La fecha ingresada no es correcta. Asegúrese de seguir el formato yyyy/MM/dd");
            return LocalDate.now();
        }
    }

    public long calcularDiasHastaVencimiento(LocalDate fechaVencimiento) {
        LocalDate fechaActual = LocalDate.now(); // Fecha actual
        return ChronoUnit.DAYS.between(fechaActual, fechaVencimiento);
    }

    public LocalDate sumarDiasAFecha(LocalDate fecha, int dias) {
        return fecha.plusDays(dias);
    }

    
}
