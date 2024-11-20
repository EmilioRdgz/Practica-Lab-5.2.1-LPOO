import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    private List<Transaccion> transacciones;

    // Singleton para manejar la instancia única de BaseDeDatos
    private static BaseDeDatos instance = new BaseDeDatos();

    private BaseDeDatos() {
        transacciones = new ArrayList<>();
    }

    public static BaseDeDatos getInstance() {
        return instance;
    }

    // Método sincronizado para evitar problemas de concurrencia en la base de datos
    public synchronized void registrarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
        System.out.println("Transacción registrada: " + transaccion);
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }
}
