package pl.wedel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.wedel.data.CustomerRepository;
import pl.wedel.model.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryIntegrationTest
{
    @Autowired
    CustomerRepository customerRepository;
    
    @Test
    public void shouldReturnCustomerList()
    {
        customerRepository.save(new Customer());
        
        Customer customer = customerRepository.findOne(1L);
    
        Assert.assertNotNull(customer);
    }
}
