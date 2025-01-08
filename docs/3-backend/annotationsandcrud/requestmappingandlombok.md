
## @RequestMapping And Lombok

## Lesson Objectives

- Understand how to use @RequestMapping at the class level to manage base paths for REST endpoints efficiently.

- Explore the @Getter and @Setter annotations provided by Lombok to simplify class structures by auto-generating accessor methods.



### `@RequestMapping`

We can reduce repetition in the code with `@RequestMapping`. By adding it to the class level, we can specify the base path for all the endpoints in the class.

```java
@RestController
@RequestMapping("/customers")
public class CustomerController {

}
```

The rest of the paths can then be updated to remove the `/customers` part.

### Custom Exception

Currently, when we enter an invalid id, we get an Internal Server Error. This is because we are trying to get the index of the customer in the `customers` list, but the customer does not exist.

Technically, it is not really a server error because it is the client that is sending an invalid request. We should return a `404` status code instead.

To handle this we can create a custom exception.

```java
public class CustomerNotFoundException extends RuntimeException {
  CustomerNotFoundException(String id) {
    super("Could not find customer with id: " + id);
  }
}
```

Then, in our helper method, we can throw this exception if the customer is not found.

```java
private int getCustomerIndex(String id) {
    for( Customer customer: customers) {
        if(customer.getId().equals(id)) {
            return customers.indexOf(customer);
        }
    }

    // Not found
    throw new CustomerNotFoundException(id);
}
```

Since this exception is propagated up the call stack, we need to catch it in our handler method.

Let's catch this exception in the methods that call this helper method so that we can return the appropriate status code when a customer `id` is not found.

```java
@GetMapping("/{id}")
public ResponseEntity<Customer> getCustomer(@PathVariable String id) {
  try {
    int index = getCustomerIndex(id);
    return new ResponseEntity<>(customers.get(index), HttpStatus.OK);
  } catch (CustomerNotFoundException e) {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
```

Proceed to update the rest of the endpoints to handle the `CustomerNotFoundException`.

## Intro to Lombok

Lombok is a library that helps us to reduce boilerplate code. It does this by generating the code for us during compile time.

### Installation

To install Lombok, we need to add the Lombok dependency in VSCode.

```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
</dependency>
```

### Example Usage

For now, we will just use the `@Getter` and `@Setter` annotations. These annotations will generate the getters and setters for us. This keeps our code clean and concise.

```java
@Getter
@Setter
public class Customer {
  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private String contactNo;
  private String jobTitle;
  private int yearOfBirth;
}
```

For further reading, you can read the<a href="https://projectlombok.org/features/all" target="_blank">  documentation </a>