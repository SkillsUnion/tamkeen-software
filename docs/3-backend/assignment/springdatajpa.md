# Spring Data JPA with PostgreSQL Assignment:

## Assignment Objectives

In this assignment, you will refactor the **Product Management** project from the previous assignment to use **PostgreSQL** instead of an in-memory **ArrayList**. You will:

- **Set up PostgreSQL** as the database for your Spring Boot project.
- **Use JPA & Hibernate** to manage database persistence.
- **Implement CRUD operations** using **Spring Data JPA**.
- **Modify the service and repository layers** to interact with PostgreSQL.
- **Configure the database in `application.properties`**.

This is a **semi-complete** assignment where you will complete the sections marked with `TODO`.

---

### Steps to Complete the Assignment:

#### 1. **Fork and Clone the Existing Repository**

- Fork and clone the existing repository from <a href="https://github.com/SkillsUnion/product-crud-assignment.git" target="_blank"> product-crud-assignment </a>

- Open the project in your IDE (VS Code).

---

## 1. Project Setup

Ensure you have **PostgreSQL** installed and running on your system. You can use **DBeaver** to manage your database.

- **Create a new database** named `product_db` in PostgreSQL.

---

## 2. Add PostgreSQL Dependency

Add the **PostgreSQL driver** dependency to your `pom.xml` file:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
```

---

## 3. Configure `application.properties`

Modify `src/main/resources/application.properties` to configure the database connection:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/product_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

 **TODO:** Replace `yourpassword` with your actual PostgreSQL password.

---

## 4. Create the Entity Class

Modify the `Product` entity class to use **JPA annotations**:

```java
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;

    // TODO: Add Getters, Setters, Constructors
}
```

 **TODO:** Implement **Getters, Setters, and Constructors**.

---

## 5. Modify the Existing Repository Layer

**Refactor your existing `ProductRepository`** from the previous assignment to extend **Spring Data JPA**:

Modify `ProductRepository.java`:


```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // TODO: Add derived query methods (if needed)
}
```

 **TODO:** Implement any **custom query methods** if necessary.

---

## 6. Implement the Service Layer

Refactor the `ProductServiceImpl` class to interact with PostgreSQL:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
```

 **TODO:** Implement missing service methods if needed.

---

## 7. Implement the Controller Layer

Update the `ProductController` to interact with the service:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
```

---

## 8. Testing Your Application

1. **Start PostgreSQL** and ensure your `product_db` database is running.
2. **Run your Spring Boot application.**
3. Use **Postman** to test your API endpoints


---





