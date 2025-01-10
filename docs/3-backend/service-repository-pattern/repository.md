 
## Repository Layer

## Lesson Objectives:

- Learn the purpose of the repository layer in handling CRUD operations and its separation from business logic.

- Understand how to create and annotate a repository class (e.g., `CustomerRepository`) in Spring Boot to manage data storage and retrieval efficiently.


## Refactoring Our `simple-crm`

Since the repository layer is responsible for CRUD operations, we will create a `CustomerRepository` class to handle all the CRUD operations on our `ArrayList`.

Only the repository should have access to the data store. Hence the `ArrayList` should be private and only accessible within the `CustomerRepository` class.

This class also needs to be annotated with `@Repository` to let Spring Boot know that it is a Spring Bean. The `@Repository` annotation is a specialization of the `@Component` annotation with additional functionality for persistence layer exceptions.

```java
@Repository
public class CustomerRepository {

  private ArrayList<Customer> customers = new ArrayList<>();

    // Preload data here now
  public CustomerRepository() {
    customers.add(new Customer("Peter", "Parker"));
    customers.add(new Customer("Stephen", "Strange"));
    customers.add(new Customer("Steve", "Rogers"));
  }

  // Create
  public Customer createCustomer(Customer customer) {
    customers.add(customer);
    return customer;
  }

  // Get One
  public Customer getCustomer(int index) {
    return customers.get(index);
  }

  // Get All
  public ArrayList<Customer> getAllCustomers() {
    return customers;
  }

  // Update
  public Customer updateCustomer(int index, Customer customer) {
    Customer customerToUpdate = customers.get(index);
    customerToUpdate.setFirstName(customer.getFirstName());
    customerToUpdate.setLastName(customer.getLastName());
    customerToUpdate.setEmail(customer.getEmail());
    customerToUpdate.setContactNo(customer.getContactNo());
    customerToUpdate.setJobTitle(customer.getJobTitle());
    customerToUpdate.setYearOfBirth(customer.getYearOfBirth());
    return customerToUpdate;
  }

  // Delete
  public void deleteCustomer(int index) {
    customers.remove(index);
  }

}
```

As you can see, the purpose of this layer is just to perform CRUD operations on our `ArrayList`. It does not contain any business logic.