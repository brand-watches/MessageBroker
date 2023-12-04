package by.brandwatch.messagebroker.reciever;

import by.brandwatch.messagebroker.model.product.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductMessageReceiver {

    @RabbitListener(queues = {"productQueue"})
    public void receiveProductMessage(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Product product;
        try {
            product = objectMapper.readValue(json, Product.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.info("Received message from productQueue: " + product);
        System.out.println("Received message from productQueue: " + product);
    }
}