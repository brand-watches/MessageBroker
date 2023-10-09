package by.brandwatch.messagebroker.controller;

import by.brandwatch.messagebroker.model.product.Product;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/sendProduct")
    @SendTo("/topic/product")
    public Product sendProduct(Product product) {
        // Отправляем сообщение о товаре в WebSocket топик
        return product;
    }
}
