##  Rest Controller testing with MockMvc

## Lesson Objective

 - Learn how to use Spring's `MockMvc` library to perform unit and integration testing for REST controllers, covering HTTP request and response cycles.

 - Develop test cases to validate REST endpoints, including GET, POST, and JSON response validations, using tools such as `MockMvc` and `JsonPath`.

---
### MockMvc
In Unit Testing, we test a small unit of the application. In Integration Testing, we want to test the whole request and response cycle of our application. It will involve all the layers of our application.

How do we test a REST Controller? Spring provides a library called `MockMvc` that allows us to mock HTTP requests and responses. We can use MockMvc to test our REST Controller.

Let's create a `CustomerControllerTest.java` in the corresponding test folder.

We need to annotate it first with `@SpringBootTest`, which will load the Spring application context. This will allow us to test the controller as if it is running in a real Spring application because it will load all the beans and configurations.

We also need to annotate it with `@AutoConfigureMockMvc`, which will autowire the `MockMvc` object. This object is used to perform the HTTP requests.


## Disabling Security for Integration Testing in Spring Boot

During integration testing, we often want to **bypass Spring Security** so that we can focus purely on the application logic, API responses, and database interactions without authentication interfering with the tests.

---

###  Why Disable Security in Tests?

- To **avoid authentication/authorization checks** during test runs  
- To test endpoints **freely using MockMvc or TestRestTemplate**  
- To **speed up test execution** without configuring login credentials  
- To **focus tests on business logic and data correctness**, not security behavior  

---

 ### Disable the Security

You **should not delete** your main `SecurityConfig` class. It is essential for production security. However, for integration tests:

- You can **comment out the  security code temporarily** during test runs 
-  You can comment out the  Security logic code we had written earlier (for quick testing only) and replace it with new code as shown below :

```java
 @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {


        http
            .securityMatcher("/**") // Apply to all paths
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // Allow all requests
            .csrf(csrf -> csrf.disable()); // Disable CSRF using new syntax
        return http.build();
        
        /*http.authorizeHttpRequests(auth-> auth
              .requestMatchers("/customers/**").authenticated()
               .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")// show later
              .anyRequest().permitAll()
        )
        .formLogin(org.springframework.security.config.Customizer.withDefaults()) //new code
        .httpBasic(org.springframework.security.config.Customizer.withDefaults()); // new code
        return http.build();*/

    }
```
---

Also **Before running integration tests, make sure to comment out any `@PreAuthorize` annotations in your controller methods.** These security checks can block access during testing unless properly configured.

```java
// Create Operation
    @PostMapping
  //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

        Customer newCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(newCustomer,HttpStatus.CREATED);
    }
```

---



## Now that we’ve disabled security, let’s move on to writing our integration tests.

### Test Get Customer

```java
// This may not be auto-imported
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc // This is needed to autowire the MockMvc object
public class CustomerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @DisplayName("Get customer by Id")
  @Test
  public void getCustomerByIdTest() throws Exception {
    // Step 1: Build a GET request to /customers/1
    RequestBuilder request = MockMvcRequestBuilders.get("/customers/1");

    // Step 2: Perform the request, get the response and assert
    mockMvc.perform(request)
        // Assert that the status code is 200
        .andExpect(status().isOk())
        // Assert that the content type is JSON
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        // Assert that the id returned is 1
        .andExpect(jsonPath("$.id").value(1));
  }
}
```

### JsonPath

JsonPath is a library that allows us to query JSON documents. We can use it to query the JSON response returned by our REST Controller.

For example, if we have a JSON response like this:

```json
{
  "id": 1,
  "firstName": "Clint",
  "lastName": "Barton",
  "email": "clint@avengers.com"
}
```

```java
jsonPath("$.id") // returns 1.
jsonPath("$.firstName") // returns Clint.
jsonPath("$.lastName") // returns Barton.
jsonPath("$.email") // returns "clint@avengers.com"
```

### Test Get All Customers

```java
@Test
public void getAllCustomersTest() throws Exception {
    // Step 1: Build a GET request to /customers
    RequestBuilder request = MockMvcRequestBuilders.get("/customers");

    // Step 2: Perform the request, get the response and assert
    mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.size()").value(4));
}
```

### Test Valid Customer Creation

To create a customer, we need to send a POST request to `/customers` with a JSON body. In order to do that, we need to convert our Java object to JSON. We can use the `ObjectMapper` class to do that. ObjectMapper is provided by the Jackson library.

```java
@Autowired
private ObjectMapper objectMapper;
```

```java
@Test
public void validCustomerCreationTest() throws Exception {
	// Step 1: Create a Customer object
	 Customer newCustomer = Customer.builder().firstName("Clint").lastName("Barton").email("clint@avengers.com")
        .contactNo("12345678").jobTitle("Special Agent").yearOfBirth(1975).build();

	// Step 2: Convert the Java object to JSON using ObjectMapper
	String newCustomerAsJSON = objectMapper.writeValueAsString(newCustomer);

	// Step 3: Build the request
	RequestBuilder request = MockMvcRequestBuilders.post("/customers")
			.contentType(MediaType.APPLICATION_JSON)
			.content(newCustomerAsJSON);

	// Step 4: Perform the request and get the response and assert
	mockMvc.perform(request)
			.andExpect(status().isCreated())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id").value(5))
			.andExpect(jsonPath("$.firstName").value("Clint"))
			.andExpect(jsonPath("$.lastName").value("Barton"));

}
```

