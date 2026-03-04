import service.ConversorService;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ConversorService service = new ConversorService();
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("=== CONVERSOR DE MONEDAS ===");

        while (true) {
            System.out.println("""
                    
                    1 - USD → ARS
                    2 - USD → BOB
                    3 - USD → BRL
                    4 - USD → CLP
                    5 - USD → COP
                    6 - Salir
                    """);

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 6) {
                System.out.println("Gracias por usar el conversor.");
                break;
            }

            System.out.print("Ingrese el monto en USD: ");
            double monto = scanner.nextDouble();

            String destino = switch (opcion) {
                case 1 -> "ARS";
                case 2 -> "BOB";
                case 3 -> "BRL";
                case 4 -> "CLP";
                case 5 -> "COP";
                default -> {
                    System.out.println("Opción inválida.");
                    yield null;
                }
            };

            if (destino != null) {
                try {
                    double resultado =
                            service.convertir("USD", destino, monto);

                    System.out.println(
                            "Resultado: " + df.format(resultado)
                                    + " " + destino);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        scanner.close();
    }
}
