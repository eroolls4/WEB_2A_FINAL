package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.*;
import mk.finki.ukim.mk.lab.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ticketOrder")
public class TicketOrderController {
    @PostMapping
    public String submitOrder(@RequestParam String movieTitle,
                              @RequestParam String userName,
                              @RequestParam int numTickets,
                              HttpServletRequest request,
                              Model model) {



        // You can use clientIp as needed
        model.addAttribute("clientIp", request.getRemoteAddr());


        model.addAttribute("movieTitle", movieTitle);
        model.addAttribute("userName" ,userName);
        model.addAttribute("numTickets", numTickets);

        return "orderConfirmation";
    }
}
