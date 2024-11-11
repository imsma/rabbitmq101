package im.sma.bysma.rabbitmq101.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import im.sma.bysma.rabbitmq101.dto.User;

/**
 * RabbitMQ JSON Producer
 * - Send message to RabbitMQ as JSON
 */
@Service
public class RabbitMQJSONProducer {

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJSONProducer.class);

    // Exchange name
    @Value("${bySMA.rabbitmq.exchange.name}")
    private String exchangeName;

    // Routing key
    @Value("${bySMA.rabbitmq.jsonQueue.routingKey}")
    private String routingKey;

    // RabbitTemplate
    private RabbitTemplate rabbitTemplate;

    /**
     * Constructor
     * 
     * @param rabbitTemplate RabbitTemplate
     */
    public RabbitMQJSONProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Send message as JSON to RabbitMQ
     * 
     * @param user User
     */
    public void sendJSONMessage(User user) {
        LOGGER.info("Message sent as JSON {}", user.toString());
        rabbitTemplate.convertAndSend(exchangeName, routingKey, user);
    }

}
