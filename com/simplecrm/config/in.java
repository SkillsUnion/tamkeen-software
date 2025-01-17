# Lesson: Adding Spring Security to the `simple_crm` Project

## Objectives
- Understand the basics of Spring Security.
- Learn how to integrate Spring Security into a Spring Boot application.
- Implement basic authentication and role-based access control for the `simple_crm` project.

---

## 1. What is Spring Security?

Spring Security is a powerful and customizable framework for authentication and access control in Java applications. It provides out-of-the-box solutions for securing applications, such as:

- Authentication: Verifying the identity of a user.
- Authorization: Controlling user access to resources based on roles.

---

## 2. Adding Spring Security Dependency

To get started, add the Spring Security dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

After adding this dependency, Spring Security will automatically apply a default security configuration that requires a username and password for all endpoints.

---

## 3. Configuring the Most Basic Authentication

If you just want to specify a fixed username and password for your application, you can do so in the `application.properties` file without creating a custom configuration.

### Step 1: Update `application.properties`

Add the following lines to your `application.properties` file:

```properties
spring.security.user.name=admin
spring.security.user.password=admin123
```

### Explanation:
- `spring.security.user.name`: Specifies the default username that Spring Security will use for basic authentication.
- `spring.security.user.password`: Specifies the default password for the specified username. **Note**: Avoid using plaintext passwords in production; this setup is only for basic testing purposes.

By default, this username and password will apply to all endpoints in your application.

### Step 2: Test the Configuration
1. Start the application.
2. Try accessing any endpoint in your application (e.g., `/customers`).
3. Enter the username `admin` and password `admin123` when prompted.

You will be granted access after authentication.

---

## 4. Configuring Basic Authentication with Custom Settings

### Step 1: Create a Security Configuration Class

To customize the default security settings further, create a new configuration class. Place this class in a `config` package to keep your project organized:

```java
package com.simplecrm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/customers/**").authenticated()
                .anyRequest().permitAll()
            )
            .formLogin() // Enable form-based authentication
            .and()
            .httpBasic(); // Enable basic authentication

        return http.build();
    }

    @Bean
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")
            .and()
            .withUser("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER");
    }
}
```

### Project Structure

Your project structure should now look like this:

```
simple_crm/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── simplecrm/
│   │   │   │   │   ├── config/
│   │   │   │   │   │   ├── SecurityConfig.java
│   │   │   │   │   ├── controller/
│   │   │   │   │   │   ├── CustomerController.java
│   │   │   │   │   ├── service/
│   │   │   │   │   ├── model/
│   │   │   │   │   ├── repository/
```

### Explanation:
- **`BCryptPasswordEncoder`**: This ensures that passwords are securely hashed using the BCrypt hashing algorithm. Hashing protects user credentials, making it difficult for attackers to retrieve plain-text passwords even if the database is compromised.
- **`authorizeHttpRequests`**: This method allows us to define which endpoints should be secured. In this case:
  - The `/customers/**` endpoint is secured, meaning only authenticated users can access it.
  - Other endpoints (`anyRequest()`) are permitted to everyone without authentication.
- **`formLogin()`**: Enables form-based login, which prompts users with a login page where they can enter their credentials. This is a user-friendly option compared to basic authentication.
- **`and()`**: Combines configurations. It signifies the continuation of the security chain, allowing multiple configurations to be applied together.
- **`httpBasic()`**: Enables basic authentication, where credentials (username and password) are sent as a part of the HTTP header. This is simpler but less secure compared to form-based login.
- **`inMemoryAuthentication`**: This is a simple way to configure users and roles directly in memory for testing purposes. Here:
  - A user `admin` with the password `password` and role `ADMIN` is created.
  - Another user `user` with the password `password` and role `USER` is created.
  - **Note**: These users are stored in memory and are not persistent. In a real application, you would typically retrieve user details from a database.

---

## 5. Testing the Configuration

### Step 1: Run the Application
Start the application. By default, Spring Security will secure all endpoints.

### Step 2: Access the Endpoints
- Try accessing `/customers` without logging in. You should be redirected to the login page.
- Log in with the following credentials:
  - **Admin**: `admin / password`
  - **User**: `user / password`

You can verify that the `admin` user has additional privileges (based on roles) compared to the `user` account.

---

## 6. Adding Role-Based Access Control (RBAC)

Role-Based Access Control (RBAC) allows you to restrict access to application features or endpoints based on the user's assigned roles.

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
        .formLogin() // Enables form-based login
        .and()
        .httpBasic(); // Enables basic authentication

    return http.build();
}
```

### Updated Explanation
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

## 7. Applying Security to `simple_crm`

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

## 8. Summary

- Spring Security provides robust security out-of-the-box.
- Role-Based Access Control allows for fine-grained access control based on user roles.
- Test your security configurations thoroughly to ensure proper implementation.

---

## Homework

1. Add a new role `MANAGER` and grant it access to view customers but not add them.
2. Secure the `deleteCustomer` endpoint so only `ADMIN` can delete customers.
3. Explore Spring Security’s documentation for customizing login pages.

---

## Resources

- [Spring Security Documentation](https://docs.spring.io/spring-security/reference/index.html)
- [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-security)
- [BCryptPasswordEncoder](https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt)

Happy Learning!
