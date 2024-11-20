public class Main {
    public static void main(String[] args) {
        // Crear productos
        Producto p1 = new Producto(1, "Laptop", 1000);
        Producto p2 = new Producto(2, "Teléfono", 500);

        // Crear inventario y agregar productos
        Inventario inventario = Inventario.getInstance();
        inventario.agregarProducto(p1, 10);
        inventario.agregarProducto(p2, 5);

        // Crear clientes
        Cliente cliente1 = new Cliente(1, "Juan");
        Cliente cliente2 = new Cliente(2, "Ana");

        // Simular compras concurrentes
        new Thread(() -> {
            cliente1.getCarrito().agregarProducto(p1);
            cliente1.realizarCompra();
        }).start();

        new Thread(() -> {
            cliente2.getCarrito().agregarProducto(p2);
            cliente2.realizarCompra();
        }).start();
    }
}


