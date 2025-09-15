package Code.BookMyShow.Models;

public class CashPayment extends Payment{
    @Override
    public boolean makePayemnt() {
        return true;
    }
}
