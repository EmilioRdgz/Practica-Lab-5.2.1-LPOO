public class Cliente {
    private int id;
    private String nombre;
    private Carrito carrito;

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.carrito = new Carrito();  // Cada cliente tiene un carrito
    }

    public String getNombre() {
        return nombre;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    // Este método ahora solo realiza la compra usando el carrito del cliente
    public void realizarCompra() {
        System.out.println("Cliente " + nombre + " realizando compra...");
        carrito.finalizarCompra(this);  // Se pasa el Cliente aquí
    }
}
