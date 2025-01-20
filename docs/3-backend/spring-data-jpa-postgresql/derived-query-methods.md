##  JPA Query Creation from Method Name

JPA provides a set of <a href="https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html" target="_blank" > methods </a> for us to perform CRUD operations. However, there may be times when we need to perform more complex queries. For example, we may want to find all customers with a certain first name.

In this case, we can create a query using the method name. This is known as JPA Query Creation from Method Name.

```java
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom query to find all customers with a certain first name
    List<Customer> findByFirstName(String firstName);
}
```

In our service layer `CustomerServiceImpl`, we can call this method. Remember to add the method to the interface `CustomerService` too.

```java
@Override
public ArrayList<Customer> searchCustomers(String firstName) {
    List<Customer> foundCustomers = customerRepository.findByFirstName(firstName);
    return (ArrayList<Customer>) foundCustomers;
}
```

And in our controller, we can create a new endpoint to allow the user to search for customers by first name.

```java
@GetMapping("/search")
public ResponseEntity<ArrayList<Customer>> searchCustomers(@RequestParam String firstName) {
    ArrayList<Customer> foundCustomers = customerService.searchCustomers(firstName);
    return new ResponseEntity<>(foundCustomers, HttpStatus.OK);
}
```

Try to search for customers by first name.

<a href="http://localhost:8080/customers/search?firstName=Stephen" target = "_blank"> http://localhost:8080/customers/search?firstName=Stephen </a>

To search for first names starting with a certain string, we can use the `StartingWith` keyword. You can try this on your own in your free time.

```java
List<Customer> findByFirstNameStartingWith(String firstName);
```

For more information, you can read more about <a href="https://www.baeldung.com/spring-data-derived-queries" target="_blank"> JPA Derived Query from Method Name </a>

---