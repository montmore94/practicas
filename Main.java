import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Ver clientes y saldos");
            System.out.println("2. Agregar nuevo cliente");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nClientes y saldos:");
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente.getNombre() + ": $" + cliente.getSaldo());
                    }
                    break;
                 case 2:
                    System.out.print("\nNombre del nuevo cliente: ");
                    String nombre = scanner.next();
                    System.out.print("Saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();
                    System.out.print("Tipo de cuenta (C/C para Cuenta Corriente, C/A para Cuenta de Ahorro): ");
                    String tipoCuenta = scanner.next();

                    if (tipoCuenta.equalsIgnoreCase("C/C")) {
                        clientes.add(new CuentaCorriente(nombre, saldoInicial));
                    } else if (tipoCuenta.equalsIgnoreCase("C/A")) {
                        System.out.print("Tasa de interés (%): ");
                        double tasaInteres = scanner.nextDouble();
                        clientes.add(new CuentaAhorro(nombre, saldoInicial, tasaInteres));
                    } else {
                        System.out.println("Tipo de cuenta no válido.");
                    }
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
