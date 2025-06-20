package iuh.fit.se.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.fit.se.model.Customer;
import iuh.fit.se.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

	@Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Thêm khách hàng mới
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Cập nhật thông tin khách hàng
    public Customer updateCustomer(String id, Customer updatedCustomer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setSoLuongDonHang(updatedCustomer.getSoLuongDonHang());
            customer.setDiemTichLuy(updatedCustomer.getDiemTichLuy());
            customer.setAddress(updatedCustomer.getAddress());
            customer.setHoaDon(updatedCustomer.getHoaDon());
            customer.setUser(updatedCustomer.getUser());
            customer.setBank(updatedCustomer.getBank());
            return customerRepository.save(customer);
        }
        return null;
    }

    // Xóa khách hàng theo ID
    public boolean deleteCustomer(String id) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
    // Lấy tất cả khách hàng
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll(); // MongoRepository trả về List
    }

    // Lấy customer theo ID
    public Customer getCustomerById(String id) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        return existingCustomer.orElse(null); // Trả về null nếu không tìm thấy
    }
}
