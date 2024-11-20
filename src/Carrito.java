import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto " + producto.getNombre() + " agregado al carrito.");
    }

    public List<Producto> getProductos() {
        return productos;
    }

    // Esta función debería aceptar un Cliente en lugar de un Carrito
    public void finalizarCompra(Cliente cliente) {
        // Aquí ya no pasas un Carrito, pasas un Cliente
        Transaccion transaccion = new Transaccion(cliente);
        BaseDeDatos.getInstance().registrarTransaccion(transaccion);
        System.out.println("Compra finalizada para " + cliente.getNombre());
    }
}


