package comp31.dachopwash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comp31.dachopwash.services.EmployeeService;

@Controller
public class EmployeeController {
    
    @Autowired EmployeeService employeeService;

    @GetMapping("/")
    public String getStarted()
    {
        return "index";
    }

    @GetMapping("/employees")
    public String getEmployees(Model model)
    {
        model.addAttribute("employees", employeeService.findEmployees());
        return "employees";
    }

    // @GetMapping("/employees")
    // public String getEmployees(
    //     @RequestParam(required=false) String firstName,
    //     @RequestParam(required=false) String lastName,
    //     @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
    //     @RequestParam(required=false) String roleTitle,  
    //     @RequestParam(required=false) double salary,    
    //     Model model)
    // {
    //     boolean nameInvalid = 
    //             firstName == null || firstName.isEmpty() ||
    //             lastName == null || lastName.isEmpty();

    //     //LocalDate empStartDate = LocalDate.parse(startDate);
    //     if(nameInvalid)
    //     {
    //         model.addAttribute("employees", employeeService.findEmployees());
    //     }
    //     else{
    //         employeeService.addEmployee(firstName, lastName, startDate, roleTitle, salary);
    //         model.addAttribute("employees", employeeService.findEmployees());
    //     }
    //     return "employees";
    // }

    
   
   
}
