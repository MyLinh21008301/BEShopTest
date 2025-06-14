package iuh.fit.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import iuh.fit.se.model.Customer;
import iuh.fit.se.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	
	
	@Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/hello")
    public String hello() {
		return "Hello, this is the Customer API!";
	}
    
    // ✅ Tạo mới Customer
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    // ✅ Cập nhật Customer theo ID
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer updatedCustomer) {
        Customer customer = customerService.updateCustomer(id, updatedCustomer);
        if (customer != null) {
            return customer;
        }
        throw new RuntimeException("Customer not found with id " + id);
    }

    // ✅ Xóa Customer theo ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable String id) {
        if (!customerService.deleteCustomer(id)) {
            throw new RuntimeException("Customer not found with id " + id);
        }
    }

    // ✅ Lấy tất cả Customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // ✅ Lấy 1 Customer theo ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return customer;
        }
        throw new RuntimeException("Customer not found with id " + id);
    }
}
