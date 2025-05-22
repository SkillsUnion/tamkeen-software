##  Configuring Basic Authentication with Custom Settings

## Lesson Objectives:

- Learn to configure Spring Security with custom user roles, in-memory authentication, and secured endpoints.  

- Understand how to protect specific routes using Spring Security's `authorizeHttpRequests` and enable both form-based and basic authentication for user access control.  

### Step 1: Create a Security Configuration Class

To customize the default security settings further, create a new configuration class. Place this class in a `config` package to keep your project organized:

```java
package com.simplecrm.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(auth-> auth
              .requestMatchers("/customers/**").authenticated()
              .anyRequest().permitAll()
        )
        .formLogin(org.springframework.security.config.Customizer.withDefaults()) 
        .httpBasic(org.springframework.security.config.Customizer.withDefaults()); 
        return http.build();

    }

   @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
            User.withUsername("admin")
                .password(encoder.encode("password"))
                .roles("ADMIN")
                .build()
        );
        manager.createUser(
            User.withUsername("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build()
        );
        return manager;
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


#  Spring Security Configuration Explained

This Section below explains the complete Spring Security configuration using the **modern approach** with `SecurityFilterChain` and `UserDetailsService`.

---

##  1. @Configuration Class

```java
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
```
- Marks the class as a Spring configuration class.
- Spring will process this class and register the beans defined inside.

---

##  2. Password Encoder Bean

```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

- Defines a `PasswordEncoder` bean using **BCrypt**.
- BCrypt hashes the passwords securely.
- Required for encoding passwords in-memory or from database.

---

##  3. SecurityFilterChain Bean

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth
            .requestMatchers("/customers/**").authenticated()
            .anyRequest().permitAll()
        )
        .formLogin(org.springframework.security.config.Customizer.withDefaults())
        .httpBasic(org.springframework.security.config.Customizer.withDefaults());

    return http.build();
}
```

###  Explanation:
- `.authorizeHttpRequests()` — Configures URL access rules.
    - `/customers/**` requires login (authenticated).
    - All other URLs are open (`permitAll()`).
- `.formLogin()` — Enables a login form (default provided by Spring).
- `.httpBasic()` — Also enables browser popup login (basic auth).
- `return http.build();` — Builds the security configuration.

---

##  4. In-Memory UserDetailsService

```java
@Bean
public UserDetailsService userDetailsService(PasswordEncoder encoder) {
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(
        User.withUsername("admin")
            .password(encoder.encode("password"))
            .roles("ADMIN")
            .build()
    );
    manager.createUser(
        User.withUsername("user")
            .password(encoder.encode("password"))
            .roles("USER")
            .build()
    );
    return manager;
}
```

###  Explanation:
- `UserDetailsService` is a standard interface for user management.
- `InMemoryUserDetailsManager` stores users in memory for testing.
- `admin` and `user` are created with role `ADMIN` and `USER`.
- Passwords are encrypted using the `PasswordEncoder` bean.

---

##  How It Works at Runtime

| URL                | Role Required       | Behavior                          |
|--------------------|---------------------|-----------------------------------|
| `/customers/**`    | Any logged-in user  | Prompts for login (admin/user)    |
| Any other route    | None                | Accessible by anyone              |

---

##  Summary

- This setup uses the modern Spring Security style (post Spring Security 5.7).
- It avoids deprecated classes like `WebSecurityConfigurerAdapter`.
- Passwords are safely encoded using BCrypt.
- Suitable for small apps and testing environments.

---



##  Testing the Configuration

### Step 1: Run the Application
Start the application. By default, Spring Security will secure all endpoints.

### Step 2: Access the Endpoints
- Try accessing `/customers` without logging in. You should be redirected to the login page.
- Log in with the following credentials:
  - **Admin**: `admin / password`
  - **User**: `user / password`

You can verify that the `admin` user has additional privileges (based on roles) compared to the `user` account.

---

