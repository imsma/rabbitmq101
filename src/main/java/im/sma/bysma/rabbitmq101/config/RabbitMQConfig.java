package im.sma.bysma.rabbitmq101.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ configuration
 * - Create a queue
 * - Create an exchange
 * - Bind the queue to the exchange with the routing key
 */
@Configuration
public class RabbitMQConfig {

    // The queue is used to receive messages from the exchange
    @Value("${bySMA.rabbitmq.jsonQueue.name}")
    private String jsonQueueName;

    @Value("${bySMA.rabbitmq.queue.name}")
    private String queueName;

    // The exchange is used to route messages to the queue based on the routing key
    @Value("${bySMA.rabbitmq.exchange.name}")
    private String exchangeName;

    // The routing key is used to route messages from the exchange to the queue
    @Value("${bySMA.rabbitmq.routingKey}")
    private String routingKey;

    // The routing key for the jsonQueue
    @Value("${bySMA.rabbitmq.jsonQueue.routingKey}")
    private String routingKeyForJsonQueue;

    /**
     * Create a queue
     * - The queue will receive messages from the exchange
     * 
     * @return Queue
     */
    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    /**
     * Create a jsonQueue
     * 
     * @return Queue
     */
    @Bean
    public Queue jsonQueue() {
        return new Queue(jsonQueueName);
    }

    /**
     * Create a topic exchange
     * - The exchange will route messages to the queue based on the routing key
     * 
     * @return TopicExchange
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeName);
    }

    /**
     * Binding the queue to the exchange with the routing key
     * - The queue will send and receive messages from the exchange with the routing
     * key
     * - The routing key is used to route messages from the exchange to the queue
     * - The routing key can be a pattern
     * 
     * @return Binding
     */
    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
    }

    /**
     * Binding the jsonQueue to the exchange with the routing key
     * 
     * @return Binding
     */
    @Bean
    public Binding bindingForJsonQueue() {
        return BindingBuilder
                .bind(jsonQueue())
                .to(exchange())
                .with(routingKeyForJsonQueue);
    }

    /**
     * Create a MessageConverter
     * 
     * @return MessageConverter
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Create a RabbitTemplate
     * - The RabbitTemplate is used to send JSON messages to the exchange
     * 
     * @param connectionFactory ConnectionFactory
     * @return AmqpTemplate
     */
    @Bean
    public AmqpTemplate jsonMessageTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    // ConnectionFactory
    // RabbitTemplate
    // RabbitAdmin

}
