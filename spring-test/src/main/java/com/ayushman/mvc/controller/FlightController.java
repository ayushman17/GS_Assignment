package com.ayushman.mvc.controller;

import com.ayushman.mvc.dao.FlightDAO;
import com.ayushman.mvc.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class FlightController {
    @Autowired
    FlightDAO fdao;
    @PostMapping("/flightBooking")
    public String  getFlights(@RequestParam("src")String source, @RequestParam("dest")String destination, Model model, HttpServletResponse response){
        ArrayList<Flight> flights= fdao.searchFlight(source,destination);
        model.addAttribute("message",flights);
        return "Display";
    }
}
