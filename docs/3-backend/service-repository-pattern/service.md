
## Service Layer

## Lesson Objectives

- Learn how the service layer manages business logic and interacts with the repository layer for CRUD operations.

- Understand how to use `@Service` and `@Autowired` annotations to enable Spring Boot.

### Create `CustomerService` :
 
 We will create a `CustomerService` class to handle all the business logic (i.e. decisions, processing or computations regarding our data).

`CustomerService` will need to call our `CustomerRepository` to perform CRUD operations on our `ArrayList` since updating the data store is the responsibility of the repository layer. That also means that `CustomerService` needs an instance of `CustomerRepository` to perform CRUD operations.

We also want to move our helper function `getCustomerIndex()` from `CustomerController` to `CustomerService` because it is part of the business logic.

The service class needs to be annotated with `@Service` to let Spring Boot know that it is a Spring Bean. The `@Service` annotation is a specialization of the `@Component` annotation with additional functionality for service layer classes.


Modify the `CustomerService` class to accept a `CustomerRepository` instance via its constructor. Annotate the `CustomerRepository` field with `@Autowired` for dependency injection:

```java
@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer createCustomer(Customer customer) {
    return customerRepository.createCustomer(customer);
  }

  public Customer getCustomer(String id) {
    return customerRepository.getCustomer(getCustomerIndex(id));
  }

  public ArrayList<Customer> getAllCustomers() {
    return customerRepository.getAllCustomers();
  }

  public Customer updateCustomer(String id, Customer customer) {
    return customerRepository.updateCustomer(getCustomerIndex(id), customer);
  }

  public void deleteCustomer(String id) {
    customerRepository.deleteCustomer(getCustomerIndex(id));
  }

  private int getCustomerIndex(String id) {

    for (Customer customer : customerRepository.getAllCustomers()) {
      if (customer.getId().equals(id)) {
        return customerRepository.getAllCustomers().indexOf(customer);
      }
    }

    throw new CustomerNotFoundException(id);
  }
}
```

---

