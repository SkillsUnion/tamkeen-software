## Part 5: Basic Routing

A route means the path to a resource. For example, the route to the homepage is `/` and the route to the about page is `/about`.

In our application class file, annotate it with `@RestController` to tell Spring Boot that this is a controller class that handles web requests.

```java
@SpringBootApplication
@RestController
public class DemoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);
	}

}
```

When you annotate a class with `@RestController`, it becomes the entry point for all web requests. This means that any object you return from this class will be serialized i.e., converted to JSON and returned to the client.

Under the hood, Spring Boot uses the Jackson library to convert the object to JSON for us.

### Basic Mapping

Let's add our first route. The route we want to define is `/hello`.

We will use the `@GetMapping` annotation to specify the route. The `@GetMapping` annotation is a shortcut for `@RequestMapping(method = RequestMethod.GET)`. This annotation tells Spring Boot that this method will handle GET requests to the `/hello` route.

```java
@GetMapping("/hello")
public String hello() {
  return "Hello World!";
}
```

### Accessing Endpoints

There are few ways to access the endpoints.

1. Open your browser and access the route at `localhost:8080/hello`.
1. Use Postman and send a GET request to `localhost:8080/hello`.
1. Use Thunder Client in VS Code to send a GET request to `localhost:8080/hello`.
1. Use YARC in Chrome to send a GET request to `localhost:8080/hello`.
1. Use the `curl` command in the terminal.

```bash
curl localhost:8080/hello
```

It will be useful to try out the different methods to access the endpoints.

Open your browser and access the route at `localhost:8080/hello`.

In the sidebar, open the Spring Boot dashboard and you can see that the endpoint `/hello` is listed.

### Basic Mapping with Query Parameters

Next let's add another route. The route we want to define is `/greet`. This time, we want to accept a query parameter `name`. This can be done by adding a parameter to the method and annotating it with `@RequestParam`. Spring Boot will automatically map the query parameter to the method parameter.

```java
@GetMapping("/greet")
public String greet(@RequestParam String name) {
  return "Hello " + name + "!";
}
```

Test the route by accessing `localhost:8080/greet?name=Tony`.

The portion after the `?` is known as the **query string** or **query parameters**.

It is used to pass data to the server. The query string is made up of key-value pairs. In this case, the key is `name` and the value is `Tony`.

We can add a default value by specifying the `defaultValue` attribute.

```java
@GetMapping("/greet")
public String greet(@RequestParam(defaultValue = "World") String name) {
  return "Hello " + name + "!";
}
```

We can accept additional query parameters by adding additional `@RequestParam` annotations.

```java
@GetMapping("/greet")
public String greet(@RequestParam(defaultValue = "World") String name, @RequestParam(defaultValue = "unknown") String role) {
  return "Hello " + name + "! You are a " + role + "!";
}
```

To pass additional query parameters, we can use the `&` symbol.

Test the route by accessing `localhost:8080/greet?name=Tony&role=inventor`.

### Basic Mapping with Path Variables

A **path variable** is a variable that is part of the route. For example, in the route `/users/1`, the `1` is a path variable.

We can create a dynamic path by adding a path variable to the route.

```java
@GetMapping("/users/{id}")
public String getUser(@PathVariable int id) {
  return "User ID: " + id;
}
```

Test the route by accessing `localhost:8080/users/1`.

---