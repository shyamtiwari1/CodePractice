package Code.BookMyShow.Models;

public abstract class Notification {

    int notificationId;
    String content;


    public abstract void sendNotification();
}
