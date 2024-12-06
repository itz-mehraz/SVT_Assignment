public class BookingService {

    private PaymentService paymentService;

    public BookingService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean bookService(double amount) {
        // Process payment when booking a service
        return paymentService.processPayment(amount);
    }
}