# Beginner-Level Assignment: Adding Form Security to Product Management

## Lesson Objectives:
By the end of this assignment, students will:
- Understand how to integrate Spring Security into a Spring Boot application.
- Learn to configure basic authentication and role-based access control.
- Implement form-based authentication to secure a simple Product Management project.

---

## Assignment Overview:
Your task is to add **basic form authentication** to a `Product Management` project using Spring Security. You will:
1. Secure the `/products/**` endpoints so only authenticated users can access them.
2. Implement in-memory authentication with `ADMIN` and `USER` roles.
3. Enable a login form for user authentication.

---

## 1. Add the Spring Security Dependency
Ensure that your `pom.xml` includes the Spring Security dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

---

## 2. Create the Security Configuration Class
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
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/products/**").authenticated() // TODO: Secure product endpoints
                .anyRequest().permitAll()
            )
            .formLogin() // TODO: Enable form login
            .and()
            .httpBasic(); // TODO: Enable basic authentication

        return http.build();
    }
    
    // TODO: Configure in-memory authentication with ADMIN and USER roles
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

**TODOs:**
- Secure `/products/**` endpoints.
- Enable form-based authentication.
- Enable basic authentication.
- Configure users `admin` (role `ADMIN`) and `user` (role `USER`) with encrypted passwords.

---

## 3. Test the Security Configuration
1. **Run the Application**: Start your Spring Boot application.
2. **Access the `/products` endpoint**:
   - Open your browser and navigate to `http://localhost:8080/products`.
   - You should be redirected to a login page.
3. **Login with the credentials**:
   - Username: `admin`, Password: `password`
   - Username: `user`, Password: `password`
4. **Verify Access**:
   - Logged-in users should access `/products`.
   - Unauthenticated users should be redirected to login.

---

## 4. Bonus: Restrict Actions Based on Roles
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
    @PreAuthorize("hasRole('ADMIN')") // TODO: Restrict to ADMIN users
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
```

**TODOs:**
- Use `@PreAuthorize("hasRole('ADMIN')")` to restrict `POST /products` to `ADMIN` users.
- Test by logging in as `user` and trying to add a product (should get `403 Forbidden`).

---

