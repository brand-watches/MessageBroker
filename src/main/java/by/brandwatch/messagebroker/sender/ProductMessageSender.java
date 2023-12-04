package by.brandwatch.messagebroker.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMessageSender {

    private final AmqpTemplate rabbitTemplate;
    private final Queue productQueue;

    @Autowired
    public ProductMessageSender(AmqpTemplate rabbitTemplate, Queue productQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.productQueue = productQueue;
    }

    public void sendProductMessage(String message) {
        rabbitTemplate.convertAndSend(productQueue.getName(), message);
        System.out.println("Message sent to productQueue: " + message);
    }
}
