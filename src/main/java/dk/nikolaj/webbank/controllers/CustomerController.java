package dk.nikolaj.webbank.controllers;

import dk.nikolaj.webbank.model.Customer;
import dk.nikolaj.webbank.service.interfaces.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public List<Customer> list() {
        return customerService.listAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> get(@PathVariable Long id) {
        try {
            Customer customer = customerService.getCustomer(id);
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Long id) {
        try {
            Customer existCustomer = customerService.getCustomer(id);
            customer.setID(id);
            customerService.saveCustomer(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        customerService.deleteCustomer(id);
    }
}
