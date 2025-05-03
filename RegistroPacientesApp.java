
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Paciente {
    private static int contadorId = 1;

    private final int id;
    private final String nombreCompleto;
    private final String dni;
    private final String tipoSangre;
    private final String categoriaAtencion;
    private final String presionArterial;
    private final String alergias;
    private final String fechaHoraIngreso;
    private final String usuarioRegistro;

    public Paciente(String nombreCompleto, String dni, String tipoSangre,
                    String categoriaAtencion, String presionArterial,
                    String alergias, String usuarioRegistro) {

        this.id = contadorId++;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.tipoSangre = tipoSangre;
        this.categoriaAtencion = categoriaAtencion;
        this.presionArterial = presionArterial;
        this.alergias = alergias;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaHoraIngreso = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
               "Nombre Completo: " + nombreCompleto + "\n" +
               "DNI: " + dni + "\n" +
               "Tipo de Sangre: " + tipoSangre + "\n" +
               "Categoría de Atención: " + categoriaAtencion + "\n" +
               "Presión Arterial: " + presionArterial + "\n" +
               "Alergias: " + alergias + "\n" +
               "Fecha y Hora de Ingreso: " + fechaHoraIngreso + "\n" +
               "Usuario que Registró: " + usuarioRegistro + "\n";
    }
}

public class RegistroPacientesApp {
    private static final ArrayList<Paciente> pacientes = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("===== MENÚ =====");
            System.out.println("1. Registrar nuevo paciente");
            System.out.println("2. Mostrar lista de pacientes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> registrarPaciente();
                case 2 -> mostrarPacientes();
                case 0 -> System.out.println("Saliendo del programa.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void registrarPaciente() {
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Tipo de sangre (ej. A+, O-): ");
        String tipoSangre = scanner.nextLine();

        System.out.print("Categoría de atención (Emergencia, Pediatría, etc.): ");
        String categoria = scanner.nextLine();

        System.out.print("Presión arterial (ej. 120/80): ");
        String presion = scanner.nextLine();

        System.out.print("Alergias (separadas por comas): ");
        String alergias = scanner.nextLine();

        System.out.print("Usuario que realiza el registro: ");
        String usuario = scanner.nextLine();

        Paciente nuevoPaciente = new Paciente(nombre, dni, tipoSangre, categoria, presion, alergias, usuario);
        pacientes.add(nuevoPaciente);
        System.out.println("Paciente registrado exitosamente.\n");
    }

    private static void mostrarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.\n");
            return;
        }

        System.out.println("\n===== LISTA DE PACIENTES =====");
        for (Paciente p : pacientes) {
            System.out.println(p);
            System.out.println("-----------------------------");
        }
    }
}
