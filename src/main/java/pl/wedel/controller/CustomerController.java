package pl.wedel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wedel.model.Customer;
import pl.wedel.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.findAllSorted();
        model.addAttribute("customers", customers);
        return "customers-list";
    }

    @GetMapping("/addCustomer")
    public String showCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer tempCustomer) {
        System.out.println(tempCustomer);
        customerService.saveCustomer(tempCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/addCustomer", params = "id")
    public String showCustomerForm(@RequestParam("id") Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping(value = "/delete", params = "id")
    public String deleteCustomer(@RequestParam("id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @PostMapping("/search")
    public String searchCustomers(@RequestParam("searchName") String searchName, Model model) {
        List<Customer> selectedCustomers = customerService.findAllByName(searchName);
        model.addAttribute("customers", selectedCustomers);

        return "customers-list";
    }

}
