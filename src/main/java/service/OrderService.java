package service;

import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {


    private final OrderRepository orderRepository;
    private final OrderKafkaProducerService kafkaProducer;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderKafkaProducerService kafkaProducer) {
        this.orderRepository = orderRepository;
        this.kafkaProducer = kafkaProducer;
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        order.setId(null); // Prevent unintended updates if ID is provided
        Order saved = orderRepository.save(order);
        kafkaProducer.sendOrderEvent(saved);
        return saved;
    }
}
