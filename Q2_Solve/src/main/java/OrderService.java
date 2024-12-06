public class OrderService {
    private final ShippingService shippingService;

    // Constructor to initialize the shippingService
    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    // placeOrder method to place an order and call the ship method
    public boolean placeOrder(String item, int quantity) {
        if (quantity <= 0) return false; // Invalid quantity check
        return shippingService.ship(item, quantity); // Delegate to shipping service
    }
}
