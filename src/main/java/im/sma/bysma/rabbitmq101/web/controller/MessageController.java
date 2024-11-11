package im.sma.bysma.rabbitmq101.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import im.sma.bysma.rabbitmq101.publisher.RabbitMQProducer;

/**
 * Message Controller
 * - Send message to RabbitMQ
 */
@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer rabbitMQProducer;

    /**
     * Constructor
     * 
     * @param rabbitMQProducer RabbitMQProducer
     */
    public MessageController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    /**
     * Send message to RabbitMQ
     * Example: http://localhost:8080/api/v1/send?message=Hello
     * 
     * @param message
     * @return ResponseEntity<String>
     */
    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ: " + message);
    }

}
