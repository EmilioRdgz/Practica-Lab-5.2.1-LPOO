import java.util.List;

public class Transaccion {
    private Cliente cliente;
    private List<Producto> productosComprados;
    private float total;

    // Constructor que recibe un Cliente
    public Transaccion(Cliente cliente) {
        this.cliente = cliente;
        this.productosComprados = cliente.getCarrito().getProductos();  // Obtenemos los productos del carrito del cliente
        calcularTotal();
    }

    private void calcularTotal() {
        total = 0;
        for (Producto producto : productosComprados) {
            total += producto.getPrecio();
        }
    }

    @Override
    public String toString() {
        return "Transacción de " + cliente.getNombre() + " con " + productosComprados.size() + " productos por un total de $" + total;
    }
}

