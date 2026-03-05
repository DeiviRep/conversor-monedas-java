import service.ConversorService;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConversorService service = new ConversorService();
        DecimalFormat df = new DecimalFormat("#.##");

        List<String> historial = new ArrayList<>();

        int opcion = 0;

        while (opcion != 8) {

            System.out.println("""
                    
            =============================================
                    🌍 CONVERSOR DE MONEDAS
            =============================================

            1) USD → ARS  (Dólar → Peso argentino)
            2) ARS → USD  (Peso argentino → Dólar)
            3) USD → BRL  (Dólar → Real brasileño)
            4) BRL → USD  (Real brasileño → Dólar)
            5) USD → COP  (Dólar → Peso colombiano)
            6) COP → USD  (Peso colombiano → Dólar)

            7) Ver historial de conversiones
            8) Salir

            Seleccione una opción:
            """);

            if (!scanner.hasNextInt()) {
                System.out.println("⚠ Entrada inválida.");
                scanner.next();
                continue;
            }

            opcion = scanner.nextInt();

            if (opcion == 8) {
                System.out.println("👋 Gracias por usar el conversor.");
                break;
            }

            if (opcion == 7) {

                System.out.println("\n📜 HISTORIAL DE CONVERSIONES");

                if (historial.isEmpty()) {
                    System.out.println("Aún no hay conversiones.");
                } else {
                    historial.forEach(System.out::println);
                }

                continue;
            }

            System.out.print("\nIngrese el monto: ");

            if (!scanner.hasNextDouble()) {
                System.out.println("⚠ Debe ingresar un número.");
                scanner.next();
                continue;
            }

            double monto = scanner.nextDouble();

            String base = "";
            String destino = "";

            switch (opcion) {

                case 1 -> {
                    base = "USD";
                    destino = "ARS";
                }

                case 2 -> {
                    base = "ARS";
                    destino = "USD";
                }

                case 3 -> {
                    base = "USD";
                    destino = "BRL";
                }

                case 4 -> {
                    base = "BRL";
                    destino = "USD";
                }

                case 5 -> {
                    base = "USD";
                    destino = "COP";
                }

                case 6 -> {
                    base = "COP";
                    destino = "USD";
                }

                default -> {
                    System.out.println("⚠ Opción inválida.");
                    continue;
                }
            }

            try {

                double resultado = service.convertir(base, destino, monto);

                String salida = monto + " " + base +
                        " = " + df.format(resultado) + " " + destino;

                System.out.println("\n💱 Resultado: " + salida);

                historial.add(salida);

            } catch (Exception e) {

                System.out.println("❌ Error en la conversión: "
                        + e.getMessage());
            }

            System.out.println("\nPresione ENTER para continuar...");
            try {
                System.in.read();
            } catch (Exception ignored) {
            }
        }

        scanner.close();
    }
}