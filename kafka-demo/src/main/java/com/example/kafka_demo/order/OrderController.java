package com.example.kafka_demo.order;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private final OrderProducer producer;
    private final OrderService orderService;

    public OrderController(OrderProducer producer, OrderService orderService) {
        this.producer = producer;
        this.orderService = orderService;
    }

    @PostMapping("/create-order")
    public String createOrder(@RequestBody Order order) {
        producer.send(order);
        orderService.saveOrder(order);
        return "Order Published Successfully";
    }
}
