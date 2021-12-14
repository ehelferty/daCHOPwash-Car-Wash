package comp31.dachopwash.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp31.dachopwash.models.entities.Customer;
import comp31.dachopwash.models.entities.Wash;
import comp31.dachopwash.models.repositories.WashRepo;

@Service
public class WashService {

    EmployeeService employeeService;
    CustomerService customerService;
    WashRepo washRepo;

    @Autowired
    public WashService(WashRepo washRepo, EmployeeService employeeService, CustomerService customerService) {
        super();
        this.washRepo = washRepo;
        this.employeeService = employeeService;
        this.customerService = customerService;
    }

    public Iterable<Wash> findWashes() {
        return washRepo.findAll();
    }

    /**
     * Receives new wash info from form fills some blanks and persists the data
     * @param washType
     * @param firstName
     * @param lastName
     * @return
     */
    public Wash addWash(Integer washType, String firstName, String lastName) {
        Wash wash = new Wash();

        /**
         * Assign return customer to wash or create new customer
         */
        Customer customer = customerService.findByFirstAndLastName(firstName, lastName);
        if(customer == null) {
            //for illustrative purposes, ideally you would create a new customer
            customer = customerService.findByFirstAndLastName("Washma", "Car");
        }

        wash.setWashType(washType);
        wash.setWashStatus(1);
        wash.setEmployee(employeeService.findById(1)); // Hard coded to illustrate functionality
        wash.setCustomer(customer);

        washRepo.save(wash);

        return wash;
    }

}