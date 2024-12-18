# Model View Controller

### Lesson Objectives
1. Understand the Model-View-Controller (MVC) architectural pattern and its components.

2. Learn how to create a separate controller file in Spring Boot for better organization and maintainability.

3. Explore the use of `application.properties` for configuration management and how to access its values using the `@Value` annotation.

4. Learn about dependency injection in Spring Boot and how to use `@Autowired` and `@Component` annotations.


Currently we have all our routes in the main application file. This is not ideal as the file will become very long and difficult to maintain.

### Introduction to Model View Controller (MVC)

The Model-View-Controller (MVC) is an architectural pattern that separates an application into three main logical components: the model, the view, and the controller.

- **Model**: The model represents the data, and does nothing else. The model does NOT depend on the controller or the view.

- **View**: The view displays the data through the controller, and sends user actions (e.g. button clicks) to the controller. The view does NOT depend on the model.

- **Controller**: The controller provides model data to the view.

You can read more about MVC <a href = "https://www.freecodecamp.org/news/model-view-controller-mvc-explained-through-ordering-drinks-at-the-bar-efcba6255053/" target= "_blank"> here 
</a>.

In a typical API-centric application, the view is usually a frontend application (e.g. React, Vue, Angular, etc).

In our Spring Boot application, the controller is the entry point for all web requests. It is responsible for handling the request and returning the response.

Thus, we will create a new file called `SampleController.java` and move all the routes to the controller file. Remember to annotate the class with `@RestController`. This annotation tells Spring Boot that this is a controller class.

```java
@RestController
public class SampleController {

}
```

Test the endpoints again to make sure that they are working.

---

##  `application.properties`

The `application.properties` file is used to store configuration properties for the application. Typically we store properties such as database connection string, server port, etc.

```properties
# Server Configuration
server.port=8081
spring.application.name=Demo Spring Boot Application
```

We can use the `@Value` annotation to access the properties in the file.

```java
@Value("${spring.application.name}")
private String appName;

@Value("${server.port}")
private String port;

@GetMapping("/app-info")
public String getAppInfo() {
  return "App " + appName + " is running on port: " + port;
}
```

Default values can be specified using the `:` symbol.

```java
@Value("${spring.application.name:Demo Spring Boot Application}")
private String appName;

@Value("${server.port:8080}")
private String port;
```

Test the endpoint at `localhost:8080/app-info`. Remember to update the port number if you have changed it.

## Dependency Injection through annotations

Create a `SampleItem.java`.

```java
public class SampleItem {

  private int id;
  private String name;
  private double price;
  private String desc;

  // Add your getters and setters
}
```

In `SampleController.java`, create a new method that returns a `SampleItem`.

```java
// Instantiate a new SampleItem
SampleItem item = new SampleItem();

@GetMapping("/item")
public SampleItem getItem() {
  item.setId(1);
  item.setName("Apple");
  item.setPrice(1.99);
  item.setDesc("A red apple");
  return item;
}

```

Currently, we are creating a new `SampleItem` object in the controller. This is not ideal as we want to separate the creation of the object from the controller. We want to inject the object into the controller. This is known as **dependency injection**. To this, we will use the `@Autowired` annotation instead of the `new` keyword.

```java
@Autowired
private SampleItem item;
```

To use the `@Autowired` annotation, we need to annotate the `SampleItem` class with `@Component`.

```java
@Component
public class SampleItem {
  // ...
}
```

The `@Component` annotation tells Spring Boot that this class is a component that can be injected into other classes.

Test the endpoint at `localhost:8080/item`.

This is how dependency injection works:

1. Annotate the class using `@Component`.
2. Spring Boot will register this class as bean.
3. Use `@AutoWired` to inject the bean into the class that depends on it.

---

### Resource Links
- <a href="https://www.baeldung.com/spring-mvc-tutorial" target="_blank">Spring MVC Tutorial by Baeldung</a>
- <a href="https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc" target="_blank">Spring Framework Documentation: MVC</a>


