package in.sp.backend.CRUD_Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.backend.CRUD_Project.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
