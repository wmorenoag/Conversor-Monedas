import com.google.gson.JsonSyntaxException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcionElegida = 0;

        Consulta consulta = new Consulta();

        Calculos calculos = new Calculos(consulta);
        GeneradorArchivos generador = new GeneradorArchivos();

        List<String> respuestas = new ArrayList<>();

        String menu = """
            \n******************************************************
            *** Bienvenido al conversor de monedas ***
            
            1. Peso Colombiano ==> Dolar Estadounidense
            2. Dolar Estadounidense ==> Peso Colombiano
            3. Peso Mexicano ==> Dolar Estadounidense
            4. Dolar Estadounidense ==> Peso Mexicano
            5. Sol Peruano ==> Dolar Estadounidense
            6. Dolar Estadounidense ==> Sol Peruano
            7. Peso Argentino ==> Dolar Estadounidense
            8. Dolar Estadounidense ==> Peso Argentino
            9. Real Brasilero ==> Dolar Estadounidense
            10.Dolar Estadounidense ==> Real Brasilero
            
            11. Salir
            ********************************************************           
            """;
        while (opcionElegida != 11) {
            try {
                System.out.println(menu);
                opcionElegida = Integer.parseInt(lectura.nextLine());

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                switch (opcionElegida) {
                    case 1:
                        calculos.almacenarValores("COP", "USD");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 2:
                        calculos.almacenarValores("USD", "COP");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 3:
                        calculos.almacenarValores("MXN", "USD");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 4:
                        calculos.almacenarValores("USD", "MXN");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 5:
                        calculos.almacenarValores("PEN", "USD");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 6:
                        calculos.almacenarValores("USD", "PEN");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 7:
                        calculos.almacenarValores("ARS", "USD");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 8:
                        calculos.almacenarValores("USD", "ARS");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 9:
                        calculos.almacenarValores("BRL", "USD");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 10:
                        calculos.almacenarValores("USD", "BRL");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 11:
                        break;
                    default:
                        System.out.println("ingrese una opción válida");
                }
            } catch (JsonSyntaxException | NullPointerException e){
                System.out.println("Error, ingrese solo monedas válidas");
            } catch (NumberFormatException | InputMismatchException e){
                System.out.println("Error, ingrese un valor válido");
            }
        }
        generador.guardarJson(respuestas);
        System.out.println("Finalizando programa");
    }
}
