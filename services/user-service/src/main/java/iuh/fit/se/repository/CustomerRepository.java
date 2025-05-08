package iuh.fit.se.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import iuh.fit.se.model.Customer;

import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
