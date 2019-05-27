package pl.wedel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQConnectionIntegrationTest
{
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Test
    public void name()
    {
        String message = "test";
        
        rabbitTemplate.convertAndSend("queue", message);
        
        Object receivedMessage = rabbitTemplate.receiveAndConvert("queue");
        
        Assert.assertEquals(receivedMessage, message);
    }
}
