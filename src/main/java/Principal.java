import com.google.gson.Gson;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        String apiKey = "COLOCA_TU_API_KEY_AQUI";

        int opcion = 0;

        while (opcion != 5) {

            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("       CONVERSOR DE MONEDAS");
            System.out.println("╚══════════════════════════════╝");
            System.out.println("1) USD → MXN");
            System.out.println("2) USD → ARS");
            System.out.println("3) USD → BRL");
            System.out.println("4) Elegir otra moneda");
            System.out.println("5) Salir");
            System.out.println("\nSelecciona una opción:");

            opcion = lectura.nextInt();

            if (opcion == 5) {
                System.out.println("Programa finalizado. ¡Gracias por usar el conversor!");
                break;
            }

            String monedaDestino = "";

            switch (opcion) {

                case 1:
                    monedaDestino = "MXN";
                    break;

                case 2:
                    monedaDestino = "ARS";
                    break;

                case 3:
                    monedaDestino = "BRL";
                    break;

                case 4:
                    System.out.println("Escribe el código de la moneda (EUR, COP, JPY, etc):");
                    monedaDestino = lectura.next().toUpperCase();
                    break;

                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            System.out.println("Cantidad en USD:");
            double cantidad = lectura.nextDouble();

            String json = consulta.obtenerDatos(apiKey);
            RespuestaMoneda datos = consulta.convertirDatos(json);

            double tasa = consulta.obtenerTasa(datos, monedaDestino);
            if (tasa == -1) {
                continue;
            }

            double resultado = consulta.convertirMoneda(cantidad, tasa);

            System.out.println("\n━━━━━━━━ RESULTADO ━━━━━━━━");
            System.out.printf("%.2f USD = %.2f %s%n", cantidad, resultado, monedaDestino);
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");

        }

        lectura.close();
    }
}