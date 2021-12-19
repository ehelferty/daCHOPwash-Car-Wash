package comp31.dachopwash.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp31.dachopwash.models.entities.Customer;
import comp31.dachopwash.models.repositories.CustomerRepo;

@Service
public class CustomerService {

    CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        super();
        this.customerRepo = customerRepo;
    }
    
    Customer customer;

    public List<Customer> findCustomers(){
        List<Customer> customerList = customerRepo.findAll();
        return customerList;
    }

    public Customer findByFirstAndLastName(String firstName, String lastName) {
        return customerRepo.findByCustomerFirstNameAndCustomerLastName(firstName, lastName);
    }

    public void createCustomer(String firstName, String lastName){
        customer = new Customer();
        customer.setCustomerFirstName(firstName);
        customer.setCustomerLastName(lastName);
        
        customerRepo.save(customer);
    }
}
