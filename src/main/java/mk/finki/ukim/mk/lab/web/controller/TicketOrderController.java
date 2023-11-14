package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.*;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.model.Production;
import mk.finki.ukim.mk.lab.model.TicketOrder;
import mk.finki.ukim.mk.lab.repository.MovieRepository;
import mk.finki.ukim.mk.lab.service.TicketOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ticketOrder")
public class TicketOrderController {
    private final TicketOrderService toS;
    public TicketOrderController(TicketOrderService toS) {
       this.toS = toS;
    }
    @PostMapping
    public String submitOrder(@RequestParam String movieTitle,
                              @RequestParam String userName,
                              @RequestParam int numTickets,
                              HttpServletRequest request,
                              Model model) {



        toS.placeOrder(movieTitle, userName, "baba", numTickets);
        // You can use clientIp as needed
        model.addAttribute("clientIp", request.getRemoteAddr());

        model.addAttribute("movieTitle", movieTitle);
        model.addAttribute("userName" ,userName);
        model.addAttribute("numTickets", numTickets);

        return "orderConfirmation";
    }

    @GetMapping
    public String getOrder(HttpServletRequest request, Model model){
        model.addAttribute("clientIp", request.getRemoteAddr());

        TicketOrder current = toS.getCurrentOrder();

        model.addAttribute("movieTitle", current.movieTitle);
        model.addAttribute("userName" ,current.clientName);
        model.addAttribute("numTickets", current.numberOfTickets);

        return "orderConfirmation";
    }

    @GetMapping("/delete")
    public String deleteOrder() {
        this.toS.delete();
        return "redirect:/movies";
    }
}
