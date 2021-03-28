package by.bsuir.vstudio.controller;

import by.bsuir.vstudio.dao.CustomerRepository;
import by.bsuir.vstudio.entity.Movie;
import by.bsuir.vstudio.model.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {

    private final CustomerService customerService;

    @Autowired
    public MainController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String listClients(Model model) {
        model.addAttribute("customers", customerService.listCustomers());
        return "customers";
    }

    @GetMapping("/login")
    public String loginClient(@RequestParam(name = "username", defaultValue = "") String username, @RequestParam(name = "password", defaultValue = "")  String password, Model model) {
        model.addAttribute("customers", List.of(customerService.tryAuthorize(username, password)));
        return "customers";
    }

    @GetMapping("/register")
    public String loginClient(
            @RequestParam(name = "username", defaultValue = "") String username,
            @RequestParam(name = "password", defaultValue = "")  String password,
            @RequestParam(name = "email", defaultValue = "") String email,
            @RequestParam(name = "name", defaultValue = "") String name,
            @RequestParam(name = "birthDate", defaultValue = "") LocalDate birthDate,
            Model model) {
        customerService.tryRegister(username, password, email, name, birthDate);
        model.addAttribute("customers", List.of(customerService.tryAuthorize(username, password)));
        return "customers";
    }

}
