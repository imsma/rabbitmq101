package im.sma.bysma.rabbitmq101.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import im.sma.bysma.rabbitmq101.dto.User;

/**
 * This class listens on the queue and consumes the message.
 */
@Service
public class RabbitMQJSONConsumer {
    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJSONConsumer.class);

    /**
     * This method listens on the queue and consumes the message.
     * 
     * @param user The message that was sent to the queue.
     */
    @RabbitListener(queues = "${bySMA.rabbitmq.jsonQueue.name}")
    public void listen(User user) {
        LOGGER.info("Received a JSON message: {}", user);
    }
}
