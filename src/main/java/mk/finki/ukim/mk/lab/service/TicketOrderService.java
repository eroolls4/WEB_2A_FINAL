package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.TicketOrder;

public interface TicketOrderService {
    TicketOrder getCurrentOrder();
    TicketOrder placeOrder(String movieTitle, String clientName, String address, Integer numberOfTickets);
    void delete();
}
