package pl.wedel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wedel.data.CustomerRepository;
import pl.wedel.model.Customer;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAll()
    {
        return repository.findAll();
    }

    public void saveCustomer(Customer customer)
    {
        repository.save(customer);
    }
}
