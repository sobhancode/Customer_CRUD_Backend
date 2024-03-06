package in.sp.backend.CRUD_Project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.backend.CRUD_Project.entity.Customer;
import in.sp.backend.CRUD_Project.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private  CustomerRepository repository;
	
	public Customer postCustomer(Customer customer) {
		return repository.save(customer);
	}
	
	public List<Customer> getAllCustomer(){
		return repository.findAll();
	}
	
	public void deleteCustomer(Long id) {
		repository.deleteById(id);
		
	}
	
	public Customer getCustomerById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Customer UpdateCustomer(Long id,Customer customer) {
		Optional<Customer> existCustomer = repository.findById(id);
		if(existCustomer.isPresent()) {
			Customer newCustomer = existCustomer.get();
			newCustomer.setName(customer.getName());
			newCustomer.setEmail(customer.getEmail());
			newCustomer.setPhone(customer.getPhone());
			return repository.save(newCustomer);
		}
		return null;
	}
}
