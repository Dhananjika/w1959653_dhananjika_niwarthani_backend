package lk.ticket.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticketBooking")  // Base path for this controller
public class BookingController {

    private static final Logger logger = Logger.getLogger(BookingController.class);

    @GetMapping("/test")
    public String test() {
        logger.info("test");
        return "test";
    }
}
