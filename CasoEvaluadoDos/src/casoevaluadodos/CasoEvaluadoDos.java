/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casoevaluadodos;

import javax.swing.JOptionPane;

/**
 *
 * @author emmac
 */
public class CasoEvaluadoDos {
  public static void main(String[] args) {
        Hotel hotel = new Hotel();
        String opcion;

        do {
            opcion = JOptionPane.showInputDialog(
                    "Sistema de reservas del Hotel\n"
                    + "1. Ver habitaciones\n"
                    + "2. Modificar habitación\n"
                    + "3. Ver resumen del hotel\n"
                    + "4. Salir");

            switch (opcion) {
                case "1":
                    JOptionPane.showMessageDialog(null, hotel.mostrarHabitaciones());
                    break;

                case "2":
                    int piso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el piso (1-3):")) - 1;
                    int col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la habitación (1-3):")) - 1;

                    String nuevoEstado = JOptionPane.showInputDialog("Nuevo estado (Libre/Ocupada/Sucia):");
                    String nuevoTipo = JOptionPane.showInputDialog("Nuevo tipo (Simple/Doble):");
                    double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:"));

                    hotel.modificarHabitacion(piso, col, nuevoEstado, nuevoTipo, nuevoPrecio);
                    JOptionPane.showMessageDialog(null, "Habitación actualizada.");
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, hotel.generarResumen());
                    break;

                case "4":
                    JOptionPane.showMessageDialog(null, "Actualización completada");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }

        } while (!opcion.equals("4"));
    }
}

// llama las funciones creadas en la clase Hotel y se genera el menu solicitado 
    

