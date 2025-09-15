package Code.BookMyShow.Models;

public class CreditCardPayment extends Payment{
    @Override
    public boolean makePayemnt() {
        return false;
    }
}
