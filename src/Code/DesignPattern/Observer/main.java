package Code.DesignPattern.Observer;

public class main {
    public static void main(String args[]){
        Publisher publisher = new Publisher();

        Observer emailUser = new EmailSubscribers();
        Observer smsUser = new SMSSubricebers();

        publisher.addObserver(emailUser);
        publisher.addObserver(smsUser);

        publisher.publishNews("Big earthquake in Tokyo!");
    }
}
