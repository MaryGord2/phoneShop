package ru.specialist.demo.models.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.specialist.demo.models.Repositories.DolznostRepository;
import ru.specialist.demo.models.Repositories.EmployeeRepository;
import ru.specialist.demo.models.client;
import ru.specialist.demo.models.dolznost;
import ru.specialist.demo.models.employee;

import javax.persistence.Convert;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DolznostRepository dolznostRepository;

    @GetMapping("/login")
    public String employeeLogInMain(Model model) {
        return "/login";
    }

    @PostMapping("/login/{login}")
    public String employeeMain(@PathVariable(value="login") String login, Model model) {

        Iterable<employee> clients = employeeRepository.findAll();
        model.addAttribute("clients", clients);
        return "/home";
    }

    @GetMapping("/employee/{id}")
    public String employeeDetails(@PathVariable(value="id") long id, Model model) {
        if(!employeeRepository.existsById(id)) {
            return "redirect:/employee";
        }
        Optional<employee> employeeById = employeeRepository.findById(id);
        ArrayList<employee> res = new ArrayList<>();
        employeeById.ifPresent(res::add);
        model.addAttribute("employee", res);
        var d = employeeById.get().getDolzn().nameDolznost;
        model.addAttribute("dolznost", d);
        return "employee-details";
    }

    @GetMapping("/employees-main")
    public String emolyeeMain(Model model){
        Iterable<employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employees-main";
    }

    @GetMapping("/employees")
    public String emolyeerepMain(Model model){
        Iterable<employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/employee/add")
    public String employeeAdd(Model model) {
        Iterable<dolznost> dolznosts = dolznostRepository.findAll();
        model.addAttribute("dolznosts", dolznosts);
        return "employee-add";
    }

    @PostMapping("/employee/add")
    public String employeePostAdd(@RequestParam String name, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String numberOfPhone,
                                @RequestParam String login,  @RequestParam String password, @RequestParam String address
            , @RequestParam (value = "dolznosti") String dolznosti,  Model model) {
        long idDolzn = Long.parseLong(dolznosti) ;

        var dolxnost = dolznostRepository.findById(idDolzn);
        employee newEmployee = new employee(name, firstname, numberOfPhone, lastname, address, login, password, dolxnost.get());
        employeeRepository.save(newEmployee);
        return "redirect:/employees-main";
    }

    @PostMapping("/employee/{id}/remove")
    public String employeePostDelete(@PathVariable(value="id") long id, Model model) {
        employee employeeUpdate = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(employeeUpdate);
        return "redirect:/employees-main";
    }

    @GetMapping("/employee/{id}/edit")
    public String employeeEdit(@PathVariable(value="id") long id, Model model) {
        if(!employeeRepository.existsById(id)) {
            return "redirect:/employees-main";
        }
        Optional<employee> clientById = employeeRepository.findById(id);
        ArrayList<employee> res = new ArrayList<>();
        clientById.ifPresent(res::add);
        model.addAttribute("employee", res);
        Iterable<dolznost> dolznosts = dolznostRepository.findAll();
        model.addAttribute("dolznosts", dolznosts);
        var dolzn = res.get(0).getDolzn();
        model.addAttribute("dolznost", dolzn);
        return "employee-edit";
    }

    @PostMapping("/employee/{id}/edit")
    public String employeePostUpdate(@PathVariable(value="id") long id, @RequestParam String name,@RequestParam String firstname,
                                   @RequestParam String lastname, @RequestParam String numberOfPhone,
                                   @RequestParam String login, @RequestParam String password, @RequestParam String address,
                                     @RequestParam (value = "dolznosti") String dolznosti, Model model) {
        employee employeeUpdate = employeeRepository.findById(id).orElseThrow();
        employeeUpdate.setName(name);
        employeeUpdate.setFirstname(firstname);
        employeeUpdate.setLastname(lastname);
        employeeUpdate.setNumberOfPhone(numberOfPhone);
        employeeUpdate.setLogin(login);
        employeeUpdate.setPassword(password);
        long idDolzn = Long.parseLong(dolznosti) ;

        var dolxnost = dolznostRepository.findById(idDolzn);
        employeeUpdate.setDolzn(dolxnost.get());
        employeeUpdate.setAddress(address);
        employeeRepository.save(employeeUpdate);
        return "redirect:/employees-main";
    }
}
