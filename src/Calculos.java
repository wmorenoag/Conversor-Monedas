
import java.util.Scanner;

public class Calculos {
    private String monedaOrigen;
    private String monedaObjetivo;
    private double cantidad;

    Scanner lectura = new Scanner(System.in);
    Consulta conversion;

    public Calculos(Consulta conversion){
        this.conversion = conversion;
    }

    public String getMonedaOrigen(){
        return monedaOrigen;
    }
    public String getMonedaObjetivo(){
        return monedaObjetivo;
    }
    public double getCantidad(){
        return cantidad;
    }

    public void almacenarValores(String monedaOrigen, String monedaObjetivo){
        this.monedaOrigen = monedaOrigen;
        this.monedaObjetivo = monedaObjetivo;

        System.out.println("Ingrese el valor a convertir");
        this.cantidad = Double.parseDouble(lectura.nextLine());
    }

    public String obtenerMensajeRespuesta(){
        String mensaje = getMonedaOrigen().toUpperCase() +" " + getCantidad() +
                " corresponde a: " + getMonedaObjetivo().toUpperCase() + " "
                + conversion.buscaConversion(getMonedaOrigen(), getMonedaObjetivo(), getCantidad());
        System.out.println(mensaje);
        return mensaje;
    }

}
