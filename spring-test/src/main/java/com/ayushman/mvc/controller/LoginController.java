package com.ayushman.mvc.controller;
import com.ayushman.mvc.dao.UserDAO;
import com.ayushman.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
@Controller
public class LoginController {
    @Autowired
    UserDAO udao;
    @GetMapping("/loginPage")
    public String getLoginPage(){
        return "Login";
    }
    @PostMapping("/validateUser")
    public String  authenticateUser(@RequestParam("uname")String username, @RequestParam("pword")String pasword, Model model, HttpServletResponse response){
        String message = "Invalid Username / Password ... Try Again...!";
        User user = new User(username,pasword);
        if(udao.validateUser(user)){
            Cookie c = new Cookie("username",username);
            response.addCookie(c);
            return "SearchFlight";
        }
        model.addAttribute("message",message);
        return "Display";
    }
    @PostMapping("/flightBooking")
    public String getFlightBooking(){
        return "FlightBooking";
    }
}
