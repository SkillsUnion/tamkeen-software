## Refactoring `SimpleCrm` to Use PostgreSQL

### Lesson Objectives for the File

  - Learn how to integrate Java Persistence API (JPA) with PostgreSQL for building robust, production-ready database solutions.

  - Implement JPA in the `SimpleCrm` project, including creating entities, repositories, and service layers for handling database operations.


### JPA and PostgreSQL

This lesson introduces Java Persistence API (JPA) with PostgreSQL and guides you through refactoring the `SimpleCrm` project to use JPA with PostgreSQL. It covers creating the entity, repository, service layer, and controller layer, as well as configuring and testing the application.

---

### JPA
- JPA (**Jakarta Persistence API**) is a specification for mapping Java objects to relational databases using Object Relational Mapping (ORM).
- Hibernate is the default implementation of JPA in Spring Boot, providing a framework for handling data persistence.

### PostgreSQL
PostgreSQL is an open-source relational database management system known for its reliability, performance, and robust feature set. It is production-ready, making it a preferred choice over in-memory databases like H2.

---

## Setting Up PostgreSQL

### Adding PostgreSQL Dependency
Add the PostgreSQL dependency to the `pom.xml` file:
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
```

### Configuring PostgreSQL
Next, we need to update the  `application.properties` with PostgreSQL settings:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/simple_crm
spring.datasource.username=postgres
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=create
```



### Creating the Entity

Define the `Customer` class as a JPA entity to map it to a PostgreSQL table:
```java
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    // Getters, setters, and constructors
}
```

---

### Creating the Repository :

Create a repository interface to handle database operations:
```java
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByFirstName(String firstName);
}
```
The `JpaRepository` provides ready-to-use methods for CRUD operations, reducing boilerplate code.

---

### Building the Service Layer :

Refactor the `CustomerService` to include business logic and interact with the repository:
```java
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = getCustomer(id);
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        // Update other fields...
        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
```

---

###  Updating the Controller Layer :

The controller layer handles HTTP requests and communicates with the service layer:
```java
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
```
---

###  Testing the Application

1. **Run the Application**  
   Start the Spring Boot application and ensure PostgreSQL is being used.

2. **Test Endpoints**  
   Use tools like Postman to create and retrieve customers.

3. **Verify in PostgreSQL**  
   Check the database to ensure data persistence.

---

This lesson introduces JPA and PostgreSQL integration while guiding you through refactoring the `SimpleCrm` project with an emphasis on robust, production-ready practices.
