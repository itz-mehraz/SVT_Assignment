import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    //Que 9

    @Mock
    private PaymentService paymentService;


    @InjectMocks
    private BookingService bookingService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void bookService() {
        double bookingAmount = 100.0;

        when(paymentService.processPayment(bookingAmount)).thenReturn(true);

        boolean paymentSuccess = bookingService.bookService(bookingAmount);

        assertTrue(paymentSuccess);

        verify(paymentService, times(1)).processPayment(bookingAmount);
    }
}