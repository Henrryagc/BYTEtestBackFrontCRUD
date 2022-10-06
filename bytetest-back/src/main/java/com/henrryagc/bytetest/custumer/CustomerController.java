package com.henrryagc.bytetest.custumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public Flux<CustomerDTO> findAllCustomers() {
        return Flux.fromIterable(customerService.findAllCustomers());
    }

    @PostMapping("/customer")
    public ResponseEntity<Long> addCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.addCustomer(customerDTO));
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Long> putCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        var customer = customerService.existCustomerById(id);
        if (!customer) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.putCustomer(id, customerDTO));
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        var customer = customerService.existCustomerById(id);
        if (!customer) {
            return ResponseEntity.notFound().build();
        }
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/customer/all")
    public ResponseEntity<Integer> addManyCustomer(@RequestBody List<CustomerDTO> customerDTOList) {
        return ResponseEntity.ok(customerService.addManyCustomer(customerDTOList));
    }

}
