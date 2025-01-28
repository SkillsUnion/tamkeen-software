##  Configuring Basic Authentication with Custom Settings

## Lesson Objectives:

- Learn to configure Spring Security with custom user roles, in-memory authentication, and secured endpoints.  

- Understand how to protect specific routes using Spring Security's `authorizeHttpRequests` and enable both form-based and basic authentication for user access control.  

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

