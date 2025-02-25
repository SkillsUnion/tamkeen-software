# Solution: Adding Form Security to Product Management

## Lesson Objectives:

- Understand how to integrate Spring Security into a Spring Boot application.
- Configure basic authentication and role-based access control.
- Implement form-based authentication to secure a simple Product Management project.

---

## 1. Add the Spring Security Dependency
Ensure that your `pom.xml` includes the Spring Security dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

This dependency brings in the necessary security features, including authentication and authorization mechanisms.

---

## 2. Implement the Security Configuration Class
Inside your project, create a package `config` and add a class named `SecurityConfig`.

```java
package com.productmanagement.config;

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
        return new BCryptPasswordEncoder(); // Encrypts passwords securely
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/products/**").authenticated() // Secures product endpoints
                .anyRequest().permitAll()
            )
            .formLogin() // Enables form-based login
            .and()
            .httpBasic(); // Enables basic authentication

        return http.build();
    }
    
    // Configuring in-memory authentication with ADMIN and USER roles
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

### Explanation:
- **`BCryptPasswordEncoder`**: Used to encrypt passwords before storing them.
- **Users Created**:
  - `admin` (password: `password`, role: `ADMIN`)
  - `user` (password: `password`, role: `USER`)
- **`configureGlobal` Bean**:
  - This method configures in-memory authentication with predefined users and roles.
  - It ensures Spring Security recognizes the defined users and roles globally.
- **Security Rules**:
  - `/products/**` requires authentication.
  - Other endpoints are open to all users.

---

## 3. Test the Security Configuration
1. **Run the Application**: Start your Spring Boot application.
2. **Access the `/products` endpoint**:
   - Open a browser and go to `http://localhost:8080/products`.
   - You will be redirected to a login page.
3. **Login with Credentials**:
   - Username: `admin`, Password: `password`
   - Username: `user`, Password: `password`
4. **Verify Access**:
   - Logged-in users should be able to access `/products`.
   - Unauthenticated users should be redirected to login.

---

## 4. Restrict Actions Based on Roles
Modify your `ProductController` to restrict access to **adding products** so only `ADMIN` users can perform this action.

```java
@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // Restricts POST to ADMIN users
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
```

### Explanation:
- **`@PreAuthorize("hasRole('ADMIN')")`** ensures that only `ADMIN` users can add products.
- **Testing Restrictions:**
  - Log in as `admin` and perform `POST /products` (✅ Success).
  - Log in as `user` and perform `POST /products` (🚫 Should return `403 Forbidden`).

---

