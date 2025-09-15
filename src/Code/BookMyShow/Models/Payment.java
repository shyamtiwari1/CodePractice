package Code.BookMyShow.Models;

import Code.BookMyShow.Enums.PaymentStatus;

import java.time.LocalDateTime;

public abstract class Payment {

    int amount ;
    LocalDateTime timestamp ;
    PaymentStatus paymentStatus;


    public abstract boolean makePayemnt();
}
