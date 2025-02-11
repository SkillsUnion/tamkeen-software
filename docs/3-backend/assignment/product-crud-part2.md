## Product-CRUD Assignment-Part2 (Service and Repository Layers)

### Lesson Objectives:

- Learn how to implement **Service** and **Repository** layers in a Spring Boot application.
- Understand **dependency injection** and how to use `@Autowired` for managing dependencies.
- Refactor your application to separate concerns between **Controller**, **Service**, and **Repository** layers.

### Introduction:
This assignment builds upon the previous Product CRUD project. You will refactor the existing code to introduce a **service layer** to manage business logic and a **repository layer** to handle data storage. The project will still use an `ArrayList` to store `Product` objects since database integration will be covered in future lessons.

---

### Steps to Complete the Assignment:

### 🔹 Important Reminder:  
Do **not** fork and clone the repository again. You should continue working on the **same repository** that you forked and cloned during the first Spring Boot assignment (_Spring Boot Assignment: Product-CRUD_). Simply make the required changes for this assignment, **commit and push**, and submit your **GitHub repository link** as usual.  

---

#### 2. **Set Up the Repository Layer**

1. **Create a Repository Class:**
   - Navigate to `src/main/java/com/example/product_crud_assignment`.

   - Create a file named `ProductRepository.java`.

   - Implement the following code with TODO comments for students to complete:

```java
package com.example.product_crud_assignment;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        // TODO: Preload some products into the list.
    }

    // TODO: Implement the method to save a product to the list.
    public Product save(Product product) {
        return null; // Replace with your code
    }

    // TODO: Implement the method to return all products.
    public List<Product> findAll() {
        return null; // Replace with your code
    }

    // TODO: Implement the method to find a product by its ID.
    public Product findById(String id) {
        return null; // Replace with your code
    }

    // TODO: Implement the method to update a product by its ID.
    public Product update(String id, Product updatedProduct) {
        return null; // Replace with your code
    }

    // TODO: Implement the method to delete a product by its ID.
    public void delete(String id) {
        // Replace with your code
    }

    // Helper method to find the index of a product by ID
    private int getProductIndex(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
```

2. **What You Need to Do:**
   - Fill in the TODO sections to complete the `ProductRepository` class.

---

#### 3. **Set Up the Service Layer**

1. **Create a Service Class:**
   - Navigate to `src/main/java/com/example/product_crud_assignment`.
   - Create a file named `ProductService.java`.
   - Implement the following code with TODO comments for students to complete:

```java
package com.example.product_crud_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // TODO: Use @Autowired to inject the ProductRepository via constructor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // TODO: Implement the method to create a product.
    public Product createProduct(Product product) {
        return null; // Replace with your code
    }

    // TODO: Implement the method to return all products.
    public List<Product> getAllProducts() {
        return null; // Replace with your code
    }

    // TODO: Implement the method to return a product by its ID.
    public Product getProductById(String id) {
        return null; // Replace with your code
    }

    // TODO: Implement the method to update a product by its ID.
    public Product updateProduct(String id, Product updatedProduct) {
        return null; // Replace with your code
    }

    // TODO: Implement the method to delete a product by its ID.
    public void deleteProduct(String id) {
        // Replace with your code
    }
}
```

2. **What You Need to Do:**
   - Fill in the TODO sections to complete the `ProductService` class.

---

#### 4. **Refactor the Controller Layer**

1. **Modify the `ProductController` Class:**
   - Open the `ProductController.java` file.
   - Refactor the controller to use the `ProductService` for CRUD operations.
   - Replace the existing code with the following:

```java
package com.example.product_crud_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    // TODO: Use @Autowired to inject the ProductService via constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Create
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // Read all
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Read by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }
}
```

2. **What You Need to Do:**
   - Annotate the constructor with `@Autowired` to inject the `ProductService` dependency.

---

#### 5. **Test the Endpoints**

- Use **Postman** or any REST client to test the API.
- Ensure all CRUD operations work as expected.

---

