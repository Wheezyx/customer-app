package pl.wedel;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAppApplication.class, args);
	}
	
	@Bean
	public CachingConnectionFactory cachingConnectionFactory()
	{
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
		
		String uri = System.getenv("CLOUDAMQP_URL");
		if(uri == null)
		{
			uri = "amqp://guest:guest@localhost";
		}
		cachingConnectionFactory.setUri(uri);
        
        RabbitAdmin admin = new RabbitAdmin(cachingConnectionFactory);
        Queue queue = new Queue("queue");
        admin.declareQueue(queue);
		return cachingConnectionFactory;
	}
	
}


