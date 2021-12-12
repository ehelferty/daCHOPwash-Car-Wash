package comp31.dachopwash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.dachopwash.models.entities.Employee;
import comp31.dachopwash.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
    EmployeeService employeeService;

    @Autowired 
    public EmployeeController(EmployeeService employeeService){
        super();
        this.employeeService= employeeService;
    }


    @GetMapping("")
    public String getEmployees(Model model, @ModelAttribute Employee newEmployee,
                                @RequestParam(required=false) String employeeFirstName,
                                @RequestParam(required=false) String employeeLastName)
    {
        boolean invalidName = 
            employeeFirstName == null || employeeFirstName.isEmpty() ||
            employeeLastName == null || employeeLastName.isEmpty();

        if(invalidName){
            model.addAttribute("employees", employeeService.findEmployees());
        }
        else{
            employeeService.createEmployee(newEmployee.getEmployeeFirstName(), newEmployee.getEmployeeLastName(), 
                                        newEmployee.getEmployeeRole(), newEmployee.getEmployeeStartDate(), 
                                        newEmployee.getEmployeeEndDate(), newEmployee.getEmployeeSalary());
            model.addAttribute("employee", new Employee());
            model.addAttribute("employees", employeeService.findEmployees());
        }
        
        return "employees";
    }  
   
}
