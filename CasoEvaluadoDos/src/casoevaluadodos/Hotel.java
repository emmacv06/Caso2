/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoevaluadodos;

/**
 *
 * @author emmac
 */
public class Hotel {

    private Habitacion[][] habitaciones;

    public Hotel() {
        habitaciones = new Habitacion[3][3];
        precargarHabitaciones();
    }

    //Ingreso los datos para que esten precargados cuando se ejecuta el codigo 
    private void precargarHabitaciones() {
        habitaciones[0][0] = new Habitacion(1, "Simple", 20000, "Ocupada");
        habitaciones[0][1] = new Habitacion(2, "Doble", 40000, "Ocupada");
        habitaciones[0][2] = new Habitacion(3, "Simple", 20000, "Ocupada");

        habitaciones[1][0] = new Habitacion(4, "Doble", 40000, "Libre");
        habitaciones[1][1] = new Habitacion(5, "Simple", 20000, "Ocupada");
        habitaciones[1][2] = new Habitacion(6, "Doble", 40000, "Sucia");

        habitaciones[2][0] = new Habitacion(7, "Simple", 20000, "Ocupada");
        habitaciones[2][1] = new Habitacion(8, "Doble", 40000, "Libre");
        habitaciones[2][2] = new Habitacion(9, "Simple", 20000, "Libre");
    }

    //Muestra el estado del hotel en base a los datos cargados anteriormente 
    public String mostrarHabitaciones() {
        String texto = "";
        for (int i = 0; i < habitaciones.length; i++) {
            texto += "Piso " + (i + 1) + ":\n";
            for (int j = 0; j < habitaciones[i].length; j++) {
                texto += habitaciones[i][j].toString() + "\n";
            }
            texto += "\n";
        }
        return texto;
    }

    //llama las opciones de habitacion para modificarlas en el main 
    public void modificarHabitacion(int piso, int columna, String estado, String tipo, double precio) {
        Habitacion hab = habitaciones[piso][columna];
        hab.setEstado(estado);
        hab.setTipo(tipo);
        hab.setPrecio(precio);
    }

    //generar el total de la ganancia 
    public String generarResumen() {
        int libres = 0, ocupadas = 0, sucias = 0;
        double ganancia = 0;
        int total = habitaciones.length * habitaciones[0].length;

        for (int i = 0; i < habitaciones.length; i++) {
            for (int j = 0; j < habitaciones[i].length; j++) {
                String estado = habitaciones[i][j].getEstado();
                if (estado.equals("Libre")) {
                    libres++;
                } else if (estado.equals("Ocupada")) {
                    ocupadas++;
                    ganancia += habitaciones[i][j].getPrecio();
                } else if (estado.equals("Sucia")) {
                    sucias++;
                }
            }
        }

        //Creados para obtener porcentaje 
        int porcLibres = (int) ((libres * 100.0) / total);
        int porcOcupadas = (int) ((ocupadas * 100.0) / total);
        int porcSucias = (int) ((sucias * 100.0) / total);

        //Usa los int creados arriba para mostrar en formato de porcentaje
        return "Resumen del Hotel:\n"
                + "Libres: " + libres + " (" + porcLibres + "%)\n"
                + "Ocupadas: " + ocupadas + " (" + porcOcupadas + "%)\n"
                + "Sucias: " + sucias + " (" + porcSucias + "%)\n"
                + "Ganancia actual: " + ganancia;
    }
}
