package ma.sid.ebankservices.repositories;

import ma.sid.ebankservices.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
