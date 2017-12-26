package pl.wedel.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wedel.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
