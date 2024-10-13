package org.example.restaurantorders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final MessageSender messageSender;

    @Autowired
    public OrderController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @PostMapping("/sendOrder")
    public String sendOrder(@RequestBody String order) {
        messageSender.sendMessage(order);
        return "Order sent: " + order;
    }
}

