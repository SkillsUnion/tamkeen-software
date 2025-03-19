# Crud Operations: Create

## Lesson Objectives

- Understand the First CRUD Operation: Learn how to create data using a simple Customer class and an ArrayList as a temporary datastore.

- Implement API Endpoints in Spring Boot: Use annotations such as @PostMapping and @RequestBody to build RESTful endpoints for creating and managing Customer objects.

- Learn to Generate Unique Identifiers: Use the UUID class to generate unique IDs for Customer objects and explore how to enforce immutability with the final keyword.


### Building Our `simple-crm`

If you have not done the last activity from the previous lesson, you can start creating a new Spring Boot project now.

### `Customer` POJO

Create our `Customer` POJO.

```java
public class Customer {
  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private String contactNo;
  private String jobTitle;
  private int yearOfBirth;

  // Generate getters and setters
}
```

### Storing `Customer` objects

We will use an `ArrayList` to store our `Customer` objects in `CustomerController.java`.

```java
@RestController
public class CustomerController {

  private ArrayList<Customer> customers = new ArrayList<>();

}
```

We will use this as a datastore for now in order to create, read, update, and delete data (CRUD).

### Create

To let our user create a customer by calling an API, we need a `POST` endpoint.

#### `@PostMapping`: This annotation in Spring Boot is used to handle HTTP POST requests. It maps a method to a specific URL so that when a client sends data to the server (like adding a new user), this method processes it.

```java
@PostMapping("/customers")
public Customer createCustomer(Customer customer) {
    customers.add(customer);
    return customer;
}
```

Send a `POST` request to `http://localhost:8080/customers` with the following payload:

```json
{
  "id": "123",
  "firstName": "Bruce",
  "lastName": "Banner",
  "email": "bruce@avengers.com",
  "contactNo": "12345678",
  "jobTitle": "Scientist",
  "yearOfBirth": "1975"
}
```

Send the request and check the response. Is it what you expected?

When Postman sends us data, it sends it as a `JSON`. But in our handler method, we are expecting a `Customer` object. Our application does not know how to convert the `JSON` into a `Customer` object. We need to tell our application how to do this.

This is done by adding the `@RequestBody` annotation to our handler method.

```java
@PostMapping("/customers")
public Customer createCustomer(@RequestBody Customer customer) {
    customers.add(customer);
    return customer;
}
```

The `@RequestBody` annotation tells our application to convert the JSON into a `Customer` object. Spring Boot is now able to de-serialize the JSON into a `Customer` object, which is why we are able to add it to our `customers` list.

#### `uuid`

Currently, we are manually setting the `id` of our `Customer` object. We can use the `UUID` class to generate a unique id for us whenever a new `Customer` object is created.

```java
import java.util.UUID;

public Customer() {
  this.id = UUID.randomUUID().toString();
}
```

Let's also make the `id` field `final` so that it cannot be changed once it is set. The corresponding setter method can be removed.

```java
private final String id;
```

Now try to create a new `Customer` object using Postman. 