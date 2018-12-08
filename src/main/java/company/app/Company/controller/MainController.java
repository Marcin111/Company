package company.app.Company.controller;

import company.app.Company.entities.Employee;
import company.app.Company.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String Home() {
        return "Home";
    }

    @GetMapping("/addemployee")
    public String addEmployee(){
        return "addemployee";
    }

    @PostMapping("/addemployee")
    public String addEmployee(@RequestParam(value = "name") String name,
                              @RequestParam(value = "surname") String surname,
                              @RequestParam(value = "job") String job,
                              @RequestParam(value = "mail") String mail){
        Employee employee = new Employee(name, surname, job, mail);
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String employeesPage(Model model){
        List<Employee> employeeList = new ArrayList<>();
        Iterable<Employee> employeeIterable = employeeRepository.findAll();

        for (Employee employee : employeeIterable) {
            employeeList.add(employee);
        }

        model.addAttribute("employees", employeeList);
        return "employees";
    }


}
