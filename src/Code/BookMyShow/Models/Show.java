package Code.BookMyShow.Models;

import java.time.LocalDateTime;
import java.util.List;

public class Show {

    int showId;
    LocalDateTime startTime;
    String duration;
    List<Seat> seatList;
}
