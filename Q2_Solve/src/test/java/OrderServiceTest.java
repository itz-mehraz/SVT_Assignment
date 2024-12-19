import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    //Que 4
    private ShippingService shippingServiceMock;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        shippingServiceMock = mock(ShippingService.class);
        orderService = new OrderService(shippingServiceMock);
    }

    @Test
    @DisplayName("Netflix 1 Months subscription")
    void testPlaceOrder_ValidQuantity() {
        String item = "Netflix";
        int quantity = 1;

        when(shippingServiceMock.ship(item, quantity)).thenReturn(true);

        boolean result = orderService.placeOrder(item, quantity);

        assertTrue(result, "Order should be placed successfully");

        verify(shippingServiceMock).ship(item, quantity);
    }


    @Test
    @DisplayName("Can't be -1 PrimeVideo")
    void testPlaceOrder_InvalidQuantity() {
        String item = "PrimeVideo";
        int quantity = -3;

        boolean result = orderService.placeOrder(item, quantity);

        assertFalse(result, "Order should not be placed with invalid quantity");

        verify(shippingServiceMock, never()).ship(item, quantity);
    }

    @Test
    @DisplayName("Can be 5 blushes")
    void testPlaceOrder_ShipmentFailure() {
        String item = "Blush";
        int quantity = 5;

        when(shippingServiceMock.ship(item, quantity)).thenReturn(false);

        boolean result = orderService.placeOrder(item, quantity);

        assertFalse(result, "Order should fail when shipment fails");

        verify(shippingServiceMock).ship(item, quantity);
    }
}
