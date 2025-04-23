# Using Postman to Test Endpoints in Spring Boot

## Objective
By the end of this lesson, students will:
- Understand what Postman is
- Learn how to send GET, POST, PUT, DELETE requests
- Use Postman, Postman Extension in VS Code, and Thunder Client to test Spring Boot endpoints

## What is Postman?

Postman is a free API testing tool that allows developers to send HTTP requests (like GET, POST, PUT, DELETE) to endpoints and view responses easily — without writing any frontend code.

## Prerequisites

- Spring Boot application with endpoints like `/hello`, `/greet`, `/users/{id}`
- Postman or Postman Extension installed
- Thunder Client extension (optional)
- Spring Boot app running on localhost <a href= "http://localhost:8080" target="_blank">
 http://localhost:8080 </a>

## Step-by-Step: Using Postman

### 1. Test a GET Request - `/hello`

```java
@GetMapping("/hello")
public String hello() {
  return "Hello World!";
}
```

In Postman:
- Select method: GET
- URL: <a href="http://localhost:8080/hello" target="_blank"> http://localhost:8080/hello </a>
- Click Send

### 2. Test a GET Request with Query Params - `/greet`

```java
@GetMapping("/greet")
public String greet(@RequestParam(defaultValue = "World") String name, @RequestParam(defaultValue = "unknown") String role) {
  return "Hello " + name + "! You are a " + role + "!";
}
```

In Postman:
- Method: GET
- URL: <a href= "http://localhost:8080/greet?name=Tony&role=inventor" target="_blank">
 http://localhost:8080/greet?name=Tony&role=inventor</a>
- Click Send

### 3. Test a GET Request with Path Variable - `/users/{id}`

```java
@GetMapping("/users/{id}")
public String getUser(@PathVariable int id) {
  return "User ID: " + id;
}
```

In Postman:
- Method: GET
- URL: <a href="http://localhost:8080/users/1" target="_blank"> http://localhost:8080/users/1 </a>
- Click Send

## Using Postman Extension in VS Code

1. Open the Extensions tab in VS Code.
2. Search and install **Postman **.(Streamline API development and testing with the power of Postman, directly in your favorite IDE.)
3. After installation, look at the left sidebar – you’ll see a Postman icon (it looks like the Postman logo).
4. Click the icon to open the extension panel.
5. Sign in to your Postman account to access your workspace, collections, and history.
6. Test your endpoints

GET <a href="http://localhost:8080/hello" target="_blank"> http://localhost:8080/hello </a>

5. Click `Send Request` above the line. Response will appear in the response panel.

## Using Thunder Client in VS Code

1. Go to Extensions and install **Thunder Client**.
2. Click the Thunder Client icon in the VS Code sidebar.
3. Click `New Request`.
4. Choose method (GET) and enter URL: for example :

<a href="http://localhost:8080/greet?name=Tony" target="_blank"> http://localhost:8080/greet?name=Tony 
</a>
5. Click Send to test the endpoint.

## Tips

- Always make sure your Spring Boot app is running.
- Use `GET` requests to test `/hello`, `/greet`, `/users/{id}`.
- Use default parameters or test different values using query and path parameters.

