package im.sma.bysma.rabbitmq101.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import im.sma.bysma.rabbitmq101.dto.User;
import im.sma.bysma.rabbitmq101.publisher.RabbitMQJSONProducer;

/**
 * JSONMessageController
 * - Send JSON message to RabbitMQ
 */
@RestController
@RequestMapping("/api/v1")
public class JSONMessageController {
    // RabbitMQJSONProducer
    private RabbitMQJSONProducer jsonMessageProducer;

    /**
     * Constructor
     * 
     * @param jsonMessageProducer RabbitMQJSONProducer
     */
    public JSONMessageController(RabbitMQJSONProducer jsonMessageProducer) {
        this.jsonMessageProducer = jsonMessageProducer;
    }

    /**
     * Send JSON message to RabbitMQ
     * http://localhost:8080/api/v1/send-json-message
     * 
     * @param user User
     * @return ResponseEntity<String>
     */
    @PostMapping("/send-json-message")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        jsonMessageProducer.sendJSONMessage(user);
        return ResponseEntity.ok("JSON message sent successfully");
    }

}
