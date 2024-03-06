package in.sp.backend.CRUD_Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.backend.CRUD_Project.entity.Customer;
import in.sp.backend.CRUD_Project.service.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("/customer")
	public Customer postCustomer(@RequestBody Customer  customer) {
		return service.postCustomer(customer);
	}
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomer();
	}
	
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		service.deleteCustomer(id);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		Customer customerById = service.getCustomerById(id);
		if(customerById == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customerById);
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		Customer updateCustomer = service.UpdateCustomer(id, customer);
		if(updateCustomer==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.ok(updateCustomer);
	}
}
