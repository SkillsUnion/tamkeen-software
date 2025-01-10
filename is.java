### Coding to an Interface

Recall that an interface is a contract that specifies the methods that a class must implement e.g.

```java
public interface Food {
  // This method must be implemented by any class that implements the Food interface
  String getFlavour();
}
```

**Coding to an interface** means writing our code to be dependent on an interface instead of a concrete class. This promotes loose coupling and makes our code more flexible.

For our service layer, it is a good practice to code to an interface. This is because we may want to change the implementation of our service layer in the future.

Let's rename our `CustomerService.java` to `CustomerServiceImpl.java` and create a new interface called `CustomerService.java` with the all the method signatures:

```java
public interface CustomerService {
  Customer createCustomer(Customer customer);
  Customer getCustomer(String id);
  ArrayList<Customer> getAllCustomers();
  Customer updateCustomer(String id, Customer customer);
  void deleteCustomer(String id);
}
```

Next, our `CustomerServiceImpl` class should implement the `CustomerService` interface:

```java
@Service
public class CustomerServiceImpl implements CustomerService {
  // ...
}
```

Note that we do not have to change anything in `CustomerController.java` as it is already using the `CustomerService` bean.

```java
private CustomerService customerService;

// Constructor Injection
public CustomerController(CustomerService customerService) {
  this.customerService = customerService;
}
```

When Spring Boot encounters a `CustomerService` type dependency in the `CustomerController`, it will look for a bean that implements the `CustomerService` interface. Since we have annotated our `CustomerServiceImpl` class with `@Service`, Spring Boot will create a bean of type `CustomerServiceImpl` and inject it into the `CustomerController`.

Test the endpoints again to make sure they still work.