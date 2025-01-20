##  Spring Security 

## Objectives

- Understand the basics of Spring Security.

- Learn how to integrate Spring Security into a Spring Boot application.

---

##  What is Spring Security?

Spring Security is a powerful and customizable framework for authentication and access control in Java applications. It provides out-of-the-box solutions for securing applications, such as:

- Authentication: Verifying the identity of a user.
- Authorization: Controlling user access to resources based on roles.

---

##  Adding Spring Security Dependency

To get started, add the Spring Security dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

After adding this dependency, Spring Security will automatically apply a default security configuration that requires a username and password for all endpoints.

---

###  Configuring the Most Basic Authentication

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

