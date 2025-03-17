
## Annotations

## Lesson Objectives


- Understand the purpose of `@Component`, `@Controller`, `@RestController`, and `@ResponseBody` annotations.

- Learn their use with simple examples and explanations.

---

### `Annotations`

In Spring Boot, **annotations** are special labels (starting with `@`) that tell the framework how to set up and manage different parts of your application. They help reduce manual configuration by marking classes and methods for specific purposes. For example, `@RestController` tells Spring that a class handles web requests, and `@Autowired` lets Spring automatically provide required objects. Annotations make development easier by letting Spring handle many tasks behind the scenes. Lets look at most commonly used annotations in Spring boot applications.

### 1. `@Component`

### Definition:
`@Component` is a generic annotation that marks a class as a Spring-managed bean. It enables Spring to detect and register the class as a bean during component scanning, allowing it to be injected into other classes using dependency injection.

### Example:
```java
package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {
    public String getGreeting() {
        return "Hello, Welcome to Spring Boot!";
    }
}
```
**Explanation:**
- `GreetingService` is marked with `@Component`, making it a Spring-managed bean.
- This allows it to be injected into other components or controllers using the `@Autowired` annotation.

---

## 2. `@Controller`

### Definition:
`@Controller` is a specialized annotation used in Spring MVC to define a controller class. It is responsible for handling HTTP requests and returning views (e.g., HTML pages). This is commonly used in web applications that follow the Model-View-Controller (MVC) pattern.

### Example:
```java
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Spring Boot!");
        return "home"; // Returns view name (e.g., home.html)
    }
}
```
**Explanation:**
- `HomeController` is annotated with `@Controller`, allowing it to handle web requests.
- The `@GetMapping` maps HTTP GET requests to the `home` method.
- The `Model` object is used to pass data to the view (e.g., `home.html`).

---

## 3. `@RestController`

### Definition:
`@RestController` is a combination of `@Controller` and `@ResponseBody`. It is used to create RESTful web services by directly returning data (e.g., JSON or XML) instead of rendering views. It is commonly used for building APIs.

### Example:
```java
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Boot REST API!";
    }
}
```
**Explanation:**
- `HomeController` is annotated with `@RestController`, making it a RESTful controller.
- The `@GetMapping` maps HTTP GET requests to the `home` method, which directly returns a `String` response.
- The response (`"Welcome to Spring Boot REST API!"`) is sent to the client as plain text or JSON.

---

## 4. `@ResponseBody`

### Definition:
`@ResponseBody` is an annotation used to indicate that the return value of a method should be written directly to the HTTP response body (e.g., as JSON or XML). It is typically used in REST APIs.

### Example:
```java
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/message")
    @ResponseBody
    public String message() {
        return "This is a plain text response from @ResponseBody!";
    }
}
```
**Explanation:**
- The `@Controller` annotation is used to define a standard controller.
- The `@ResponseBody` annotation on the `message` method tells Spring to return the method's value directly in the HTTP response body.
- In this case, the string "This is a plain text response from @ResponseBody!" is returned as a plain text response.

**When to Use:**
- Use `@ResponseBody` when you want a specific method in a `@Controller` to return raw data (e.g., JSON or plain text) instead of a view.
- If all methods in a class should behave this way, consider using `@RestController` instead.

---

## Key Differences

| Annotation      | Use Case                               | Returns               |
|------------------|----------------------------------------|-----------------------|
| `@Controller`   | Web pages (views)                     | HTML view name        |
| `@RestController`| RESTful APIs                          | JSON, XML, or raw data|
| `@ResponseBody` | Direct response for specific methods   | JSON, XML, or raw data|

---

## Example Combining `@Component` and `@RestController`

### `GreetingService.java`
```java
package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {
    public String getGreeting() {
        return "Hello from GreetingService!";
    }
}
```

### `HomeController.java`
```java
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HomeController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/")
    public String home() {
        return greetingService.getGreeting();
    }
}
```
**Explanation:**
- The `GreetingService` class is marked with `@Component`, making it a Spring-managed bean.
- The `HomeController` class is marked with `@RestController` and uses the `@Autowired` annotation to inject the `GreetingService`.
- The `home` method uses the `GreetingService` to return a greeting message as the API response.

---
