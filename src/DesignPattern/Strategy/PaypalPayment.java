package DesignPattern.Strategy;

public class PaypalPayment implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("Paypal payment strategy:{} " + amount);
    }
}
