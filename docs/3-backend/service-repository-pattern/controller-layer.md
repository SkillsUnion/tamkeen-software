## Controller Layer

### Lesson Objectives:

 
 - Learn how to refactor a Spring Boot controller class to use constructor-based dependency injection for improved code modularity, testability, and adherence to Spring's dependency injection principles.

  - Gain hands-on experience in creating and handling RESTful endpoints for basic CRUD operations (Create, Read, Update, Delete) using Spring Boot annotations such as `@PostMapping`, `@GetMapping`, `@PutMapping`, and `@DeleteMapping`.


##### Modify CustomController

Lets modify the `CustomerController` class to use constructor-based dependency injection. The `CustomerService` instance will be passed in by Spring Boot.

```java
@RestController
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  // CREATE
  @PostMapping("")
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    Customer newCustomer = customerService.createCustomer(customer);
    return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
  }

  // READ (GET ALL)
  @GetMapping("")
  public ResponseEntity<ArrayList<Customer>> getAllCustomers() {
    ArrayList<Customer> allCustomers = customerService.getAllCustomers();
    return new ResponseEntity<>(allCustomers, HttpStatus.OK);
  }

  // READ (GET ONE)
  @GetMapping("{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable String id) {

    try {
      Customer foundCustomer = customerService.getCustomer(id);
      return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
    } catch (CustomerNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // UPDATE
  @PutMapping("{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {

    try {
      Customer updatedCustomer = customerService.updateCustomer(id, customer);
      return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    } catch (CustomerNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // DELETE
  @DeleteMapping("{id}")
  public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String id) {

    try {
      customerService.deleteCustomer(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (CustomerNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
```

---

## Key Changes:
1. The `CustomerService` and `CustomerController` classes now use **constructor-based dependency injection**.
2. The `@Autowired` annotation on constructors allows Spring Boot to inject the dependencies automatically.
3. The explicit instantiation of `CustomerRepository` and `CustomerService` in the classes has been removed, promoting **loose coupling**.

---

## Testing:
Once these changes are made, re-run the application and test the endpoints again to ensure they work as expected. The behavior of the application will remain the same, but the code is now more modular, testable, and adheres to Spring's dependency injection principles.

