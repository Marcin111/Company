package company.app.Company.controller;

import company.app.Company.entities.Employee;
import company.app.Company.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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

    @Transactional
    @PostMapping("/employees")
    public String deleteId(@RequestParam("id") Long id){
        employeeRepository.deleteById(id);
        return "redirect:/employees";
    }

    @Transactional
    @PostMapping("/delete")
    public String delete(Model model){
        List<Employee> employeeList = new ArrayList<>();
        Iterable<Employee> employeeIterable = employeeRepository.findAll();

        for (Employee employee : employeeIterable) {
            employeeList.add(employee);
        }

        model.addAttribute("employees", employeeList);
        return "delete";
    }

    @GetMapping("/filter")
    public String filterPage(Model model){
        List<Employee> employeeList = new ArrayList<>();
        Iterable<Employee> employeeIterable = employeeRepository.findAll();

        for (Employee employee : employeeIterable) {
            employeeList.add(employee);
        }

        model.addAttribute("filter", employeeList);
        return "filter";
    }

//@Transactional
    @PostMapping("/filterbyname")
    public String filterByName(Model model, @RequestParam("name") String name){
        List<Employee> employeeList = new ArrayList<>();
        Iterable<Employee> employeeIterable = employeeRepository.findByName(name);

        for (Employee employee : employeeIterable) {
            employeeList.add(employee);
        }

        model.addAttribute("filter", employeeList);
        return "filterresult";
    }

    @PostMapping("/filterbysurname")
    public String filterBySurname(Model model, @RequestParam("surname") String surname){
        List<Employee> employeeList = new ArrayList<>();
        Iterable<Employee> employeeIterable = employeeRepository.findBySurname(surname);

        for (Employee employee : employeeIterable) {
            employeeList.add(employee);
        }

        model.addAttribute("filter", employeeList);
        return "filterresult";
    }

    @PostMapping("/filterbymail")
    public String filterByMail(Model model, @RequestParam("mail") String mail){
        List<Employee> employeeList = new ArrayList<>();
        Iterable<Employee> employeeIterable = employeeRepository.findByMail(mail);

        for (Employee employee : employeeIterable) {
            employeeList.add(employee);
        }

        model.addAttribute("filter", employeeList);
        return "filterresult";
    }

}
