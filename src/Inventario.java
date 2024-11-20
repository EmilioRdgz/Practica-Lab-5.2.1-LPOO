import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<Integer, Producto> productosDisponibles;
    private Map<Integer, Integer> stock;

    // Singleton para manejar la instancia única de Inventario
    private static Inventario instance = new Inventario();

    private Inventario() {
        productosDisponibles = new HashMap<>();
        stock = new HashMap<>();
    }

    public static Inventario getInstance() {
        return instance;
    }

    public synchronized void agregarProducto(Producto producto, int cantidad) {
        productosDisponibles.put(producto.getId(), producto);
        stock.put(producto.getId(), cantidad);
    }

    // Método sincronizado para evitar problemas de concurrencia al actualizar el inventario
    public synchronized void actualizarInventario(Producto producto, int cantidad) {
        int cantidadActual = stock.getOrDefault(producto.getId(), 0);
        int nuevaCantidad = cantidadActual + cantidad;
        if (nuevaCantidad < 0) {
            System.out.println("No hay suficiente stock para el producto " + producto.getNombre());
        } else {
            stock.put(producto.getId(), nuevaCantidad);
            System.out.println("Inventario actualizado para el producto " + producto.getNombre() + ": " + nuevaCantidad + " unidades.");
        }
    }

    public int obtenerStock(Producto producto) {
        return stock.getOrDefault(producto.getId(), 0);
    }
}
