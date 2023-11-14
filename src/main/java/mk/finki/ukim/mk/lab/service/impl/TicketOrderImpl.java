package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.TicketOrder;
import mk.finki.ukim.mk.lab.service.TicketOrderService;
import org.springframework.stereotype.Service;

@Service
public class TicketOrderImpl implements TicketOrderService {

    TicketOrder currentTicketOrder;
    @Override
    public TicketOrder getCurrentOrder() {
        return currentTicketOrder;
    }
    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, Integer numberOfTickets) {
        currentTicketOrder = new TicketOrder(movieTitle, clientName, address, numberOfTickets);
        return currentTicketOrder;
    }

    @Override
    public void delete() {
        currentTicketOrder = null;
    }
}
