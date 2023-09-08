package com.ayushman.mvc.controller;
import com.ayushman.mvc.dao.BookingsDAO;
import com.ayushman.mvc.entity.Flight;
import com.ayushman.mvc.entity.Passengers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class BookingController
{
    @Autowired
    BookingsDAO bdao;

    @PostMapping("/bookFlight")
    public String searchFlight(@RequestParam("flightId") String flightId, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("mobile") long mobile, @RequestParam("email") String email,Model model)
    {
        Random rand = new Random();
        String bookingId = "b"+ Integer.toString(rand.nextInt(1000));
        String passengerId = "p"+ Integer.toString(rand.nextInt(1000));
        if(bdao.checkSeatsAvailable(flightId) && bdao.bookTicket(bookingId,flightId,passengerId) && bdao.addPassenger(passengerId, firstName, lastName, mobile, email))
        {
            Flight flight=bdao.searchFlightById(flightId);
            model.addAttribute("flights", flight);
            Passengers passenger = bdao.searchPassengerById(passengerId);
            model.addAttribute("passengers",passenger);
            boolean update =bdao.updateSeats(flightId);
            model.addAttribute("message","Successfully Booked");

        }
        else
            model.addAttribute("message","Booked Failed");
        return "DisplayBooking";
    }

}