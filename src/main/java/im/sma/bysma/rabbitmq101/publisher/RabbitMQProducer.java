package im.sma.bysma.rabbitmq101.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * RabbitMQ Producer
 * - Send message to RabbitMQ
 */
@Service
public class RabbitMQProducer {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    /**
     * Exchange name
     */
    @Value("${bySMA.rabbitmq.exchange.name}")
    private String exchangeName;

    /**
     * Routing key
     */
    @Value("${bySMA.rabbitmq.routingKey}")
    private String routingKey;

    public RabbitTemplate rabbitTemplate;

    /**
     * Constructor
     * - Inject RabbitTemplate
     * 
     * @param rabbitTemplate
     */
    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Send message to RabbitMQ
     * 
     * @param message
     */
    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent: %s", message));
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }

}
