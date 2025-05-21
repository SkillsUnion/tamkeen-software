## Role-Based Access Control (RBAC)

## Lesson Objective

- Learn how to restrict access to endpoints using user roles with Spring Security's `hasRole()` and `PreAuthorize()` annotations.  

- Understand how to test endpoints with different user roles to verify access restrictions and permissions.  

#### Role-Based Access Control (RBAC) allows you to restrict access to application features or endpoints based on the user's assigned roles.

### Updated Configuration Code

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/customers/**").hasRole("ADMIN")
            .requestMatchers("/reports/**").hasRole("MANAGER")
            .anyRequest().permitAll()
        )
        .formLogin(org.springframework.security.config.Customizer.withDefaults()) 
        .httpBasic(org.springframework.security.config.Customizer.withDefaults()); 

    return http.build();
}
```


### Explanation:

- **`.hasRole("ADMIN")`**: Only users with the `ADMIN` role can access endpoints matching `/customers/**`.

- **`.hasRole("MANAGER")`**: Only users with the `MANAGER` role can access endpoints matching `/reports/**`.

- **`.anyRequest().permitAll()`**: All other endpoints are open to everyone.

### Testing the Configuration

1. Start the application.
2. Test the `/customers` endpoint:
   - Log in as `admin` (username: `admin`, password: `password`). You should be able to access this endpoint.
   - Log in as `user` (username: `user`, password: `password`). You should **not** be able to access this endpoint.
3. Test the `/reports` endpoint:
   - Add a new user with the `MANAGER` role in `inMemoryAuthentication`.
   - Log in with the `MANAGER` user. You should be able to access this endpoint.
4. Test unrestricted endpoints:
   - Access any other endpoints without logging in. You should be able to access them freely.

---

### Applying Security to `simple_crm`

Here’s how you can secure key endpoints:

### Controller Example
Modify the `CustomerController` to add role-specific annotations if needed:

```java
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public List<Customer> getAllCustomers() {
        // Accessible only to authenticated users
        return customerService.findAllCustomers();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Customer addCustomer(@RequestBody Customer customer) {
        // Accessible only to ADMIN role
        return customerService.addCustomer(customer);
    }
}
```

### Testing Controllers
1. Log in as `admin` and perform POST requests to `/customers`. You should succeed.
2. Log in as `user` and perform the same POST request. You should receive an `HTTP 403 Forbidden` error.
3. Test GET requests to `/customers` with both users. Both should succeed.

---

###  Summary

- Spring Security provides robust security out-of-the-box.
- Role-Based Access Control allows for fine-grained access control based on user roles.
- Test your security configurations thoroughly to ensure proper implementation.

---

### Resources

- [Spring Security Documentation](https://docs.spring.io/spring-security/reference/index.html)
- [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-security)
- [BCryptPasswordEncoder](https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt)


