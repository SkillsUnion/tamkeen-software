## Product-CRUD Assignment:

## Lesson Objectives:

- Learn how to implement Create, Read, Update, and Delete functionality in a Spring Boot application.  


- Gain hands-on experience by completing provided code to handle CRUD operations with an in-memory data structure.  

## Introduction:

You will work on a partially complete Spring Boot project for managing **Product** entities. The focus is to understand and implement **CRUD operations** (Create, Read, Update, Delete). You will use the provided **semi-complete code** and fill in the missing parts as instructed.

---

### Steps to Complete the Assignment:

## Instructions

###    Fork and clone a copy of <a href="https://github.com/SkillsUnion/product-crud-assignment.git" target="_blank">product-crud-assignment repo</a>


#### 1. **Set Up Your Spring Boot Project**
   1. **Create a New Spring Boot Project:**
      - Use **Spring Initializr** <a href ="https://start.spring.io" target="_blank"> start.spring.io </a> or the Spring Boot extension in VS Code.
      - Configure the project:
        - **Group ID**: `com.example`
        - **Artifact ID**: `product-crud-assignment`
        - **Dependencies**: Add `Spring Web` and `Lombok`.
        - **Open your project in VS Code**
      

   2. **Ensure Your Environment is Set Up:**
      - Ensure Java JDK 17 or higher is installed.
      - Confirm Maven is installed and configured.
      - Check that VS Code has the Java and Spring Boot extensions.

---

#### 2. **Copy the Provided Code**

##### **2.1: Product Class**
   - Navigate to `src/main/java/com/example/product_crud_assignment`.
   - Create a file named `Product.java` and copy the following code:

   ```java
   package com.example.product_crud_assignment;

   import lombok.Getter;
   import lombok.Setter;

   @Getter
   @Setter
   public class Product {
       private String id;
       private String name;
       private String description;
       private double price;
       private int quantity;

       public Product(String id, String name, String description, double price, int quantity) {
           this.id = id;
           this.name = name;
           this.description = description;
           this.price = price;
           this.quantity = quantity;
       }
   }
   ```

   - **This is the complete `Product` class. No modifications are needed.**

---

##### **2.2: Semi-Complete Product Controller**
   - Navigate to `src/main/java/com/example/product_crud_assignment`.
   - Create a file named `ProductController.java` and copy the following code:

   ```java
   package com.example.product_crud_assignment;

   import org.springframework.web.bind.annotation.*;

   import java.util.ArrayList;
   import java.util.List;

   @RestController
   @RequestMapping("/products")
   public class ProductController {

       private List<Product> products = new ArrayList<>();

       // Helper method to find the index of a product by ID
    private int getProductIndex(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return products.indexOf(product);
            }
        }
        // Not found
        return -1;
    }

       // TODO: Implement the method to add a new product
       @PostMapping
       public Product createProduct(@RequestBody Product product) {
           // Add your code here to add the product to the list
           return product; // Modify this line to return the added product
       }

       // TODO: Implement the method to get all products
       @GetMapping
       public List<Product> getAllProducts() {
           // Add your code here to return the list of products
           return null; // Replace null with the actual list
       }

       // TODO: Implement the method to get a product by ID
       @GetMapping("/{id}")
       public Product getProductById(@PathVariable String id) {
           // Add your code here to find and return the product by ID
           return null; // Replace null with the actual product
       }

       // TODO: Implement the method to update a product
       @PutMapping("/{id}")
       public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
           // Add your code here to update the product by ID
           return null; // Replace null with the updated product
       }

       // TODO: Implement the method to delete a product
       @DeleteMapping("/{id}")
       public void deleteProduct(@PathVariable String id) {
           // Add your code here to remove the product by ID
       }
   }
   ```

   - **Your task is to fill in the missing code where comments say `Add your code here`.**

---

#### 3. **Fill in the Missing Code**
   - Use an `ArrayList` to store products and implement the following CRUD methods:
     - **Create**: Add a new product to the list.
     - **Read**:
       - Return all products.
       - Find and return a specific product by its ID.
     - **Update**: Find a product by ID and update its details.
     - **Delete**: Remove a product from the list by its ID.

   - **Hints:**
     - Use the `add()` method to add products to the list.
     - Use Helper method to find the index of a product by ID
     - Use the `remove()` method to delete products.

---

#### 4. **Test the Endpoints**
   1. Use **Postman** or any REST client to test the API.
   
---







