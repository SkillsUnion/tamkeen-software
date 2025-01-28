## Unit Testing the Service Layer with Mockito in Spring Boot

## Lesson Objective:

- Understand Mocking in Unit Testing: Students will learn how to use Mockito to mock dependencies like repositories to test the service layer in isolation.

- Write and Execute Unit Tests: Students will practice creating and executing unit tests for service methods, ensuring the logic behaves as expected under various scenarios.

### Service Layer 

Recall that the service layer is where we put our business logic. We will be writing unit tests for the service layer.

As the service layer is dependent on the data layer, we will need to mock the data layer using Mockito because we are only interested in testing the service layer i.e. we don't actually want to read and write to the database.

Create a `CustomerServiceImplTest.java` in the corresponding test folder. Note that it is a conventional practice to place test files in the corresponding test folder.

e.g.

File to test:
`CustomerServiceImpl.java` in `src/main/java/sg/edu/simplecrm/service/`

Test file:
`CustomerServiceImplTest.java` in `src/test/java/sg/edu/simplecrm/service/`

### Mocking

Mocking is a technique used in unit testing to isolate a class under test from its dependencies.

In our case of testing the service layer, we will mock the repository layer. This means instead of calling the repository layer, we will create a mock object that simulates the behavior of the repository layer.

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

  // We need to mock the CustomerRepository
  // Because we don't want to test the repository layer
  @Mock
  private CustomerRepository customerRepository;

  @InjectMocks // Inject the mocks as dependencies into CustomerServiceImpl
  CustomerServiceImpl customerService; // Instantiated and injected by Mockito

  // ...
}
```

The `@ExtendWith(MockitoExtension.class)` annotation is used to enable the Mockito extension for JUnit 5. It will automatically initialize the mocks and inject them into the test class.

The `@Mock` annotation is used to tell Mockito to create a mock object for the `CustomerRepository` class.

The `@InjectMocks` annotation is used to tell Mockito to inject the mock object into the `CustomerServiceImpl` class.

With this, we do not have to spin up the entire Spring application context and we can test the service layer in isolation.

### Test Create Customer

Now we can add a test method to test the `createCustomer()` method.

```java
@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

  // Mock the customer repository
  @Mock
  private CustomerRepository customerRepository;

  // Inject the mocked customer repository into the customer service
  @InjectMocks
  private CustomerServiceImpl customerService;

  @Test
  public void testCreateCustomer() {

    // 1. SETUP
    // Create a new customer
    Customer customer = Customer.builder().firstName("Clint").lastName("Barton").email("clint@avengers.com")
        .contactNo("12345678").jobTitle("Special Agent").yearOfBirth(1975).build();

    // Mock the save method of the customer repository
    when((customerRepository.save(customer))).thenReturn(customer);

    // 2. EXECUTE
    // Call the method that we want to test
    Customer savedCustomer = customerService.createCustomer(customer);

    // 3. ASSERT
    // Compare the actual result with the expected result
    assertEquals(customer, savedCustomer, "The saved customer should be the same as the new customer");

    // Also verify that the save method of the customer repository is called once
    verify(customerRepository, times(1)).save(customer);
  }

}
```

#### We start with our setup.

- We create a new customer using the builder pattern. To allow that, we add `@Builder` on our `Customer` class. Note that you can also create it using the usual constructor method.

- Then we mock the `save()` method of the `CustomerRepository` to return the customer that is passed in. This is because we want to test the `createCustomer()` method and not the `save()` method of the `CustomerRepository`.

- We can use the `when()` method to tell Mockito what to do when the `save()` method of the `CustomerRepository` is called. In this case, we want to return the customer that is passed in.

Next we execute, which is to call the method that we want to test

- We call the `createCustomer()` method of the `CustomerService` and pass in the customer that we created earlier.

Finally, we assert.

- We assert that the customer that is returned by the `createCustomer()` method is the same as the customer that we created earlier.

- Note that we have to override the `equals()` method in the `Customer` class for this to work. You can use VSCode to do this. Right click on the `Customer` class and select `Generate hashCode() and equals()`. Select all the fields and click `Generate`. Alternatively, we can use the `@EqualsAndHashCode` annotation from Lombok.

- We also verify that the `save()` method of the `CustomerRepository` is called once. This is to ensure that the `createCustomer()` method is calling the `save()` method of the `CustomerRepository`.

### Test Get Customer

```java
@Test
public void testGetCustomer() {
    // 1. SETUP
    // Create a new customer
    Customer customer = Customer.builder().firstName("Clint").lastName("Barton").email("clint@avengers.com")
        .contactNo("12345678").jobTitle("Special Agent").yearOfBirth(1975).build();

    Long customerId = 1L;

    when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

    // 2. EXECUTE
    Customer retrievedCustomer = customerService.getCustomer(customerId);

    // 3. ASSERT
    assertEquals(customer, retrievedCustomer);

}
```

### Test Get Customer Not Found

```java
@Test
void testGetCustomerNotFound() {
    Long customerId = 1L;
    when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

    assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomer(customerId));
}
```

---
