package DesignPattern.Strategy;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("payment by credit card");
    }
}
