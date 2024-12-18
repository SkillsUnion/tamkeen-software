
## Logging in Spring Boot with SLF4J

**Lesson Objectives:**
1. Understand the importance of logging in Spring Boot applications.

2. Learn to integrate and use SLF4J for logging.

3. Practice implementing different log levels in a sample Spring Boot application.

---

### **Logging in Spring Boot**

Logging in Spring Boot is a way to track and record application events, errors, or information during runtime. It uses logging frameworks like Logback (default), SLF4J, or Log4j to help developers debug, monitor, and maintain applications. Logs are customizable and can be set to different levels like INFO, DEBUG, WARN, or ERROR, making it easy to focus on specific details when needed.

### **What is SLF4J?**

**SLF4J (Simple Logging Facade for Java)** provides a simple abstraction for logging frameworks like Logback, Log4j, and java.util.logging. Spring Boot uses SLF4J as its default logging API, making it easy to integrate logging into your application.

---

### **Why Logging is Important**
- **Debugging:** Helps track application behavior during development.
- **Monitoring:** Provides insights into application performance and errors in production.
- **Auditing:** Keeps records of user actions and system events for security and compliance.

---

### **Setting Up Logging in Spring Boot**

Spring Boot comes preconfigured with **SLF4J** and **Logback**, so no additional configuration is needed for basic usage.

### **Step 1: Adding Dependencies**

If you're starting a new project, ensure the following dependencies are included in your `pom.xml`:

```xml
<dependencies>
    <!-- Spring Boot Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>

    <!-- Logback Classic (Default with Spring Boot) -->
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
    </dependency>
</dependencies>
```

Spring Boot Starter already includes `slf4j-api` and `logback-classic`.

---

### **Using SLF4J in Your Application**

### **Step 2: Writing Logs**

1. Import the SLF4J Logger and LoggerFactory.

    ```java
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    ```

2. Create a logger instance in your class.

    ```java
    public class MyService {
        private static final Logger logger = LoggerFactory.getLogger(MyService.class);
    }
    ```

3. Use the logger to log messages at different levels.

    ```java
    public void performTask() {
        logger.debug("Debugging message");
        logger.info("Information message");
        logger.warn("Warning message");
        logger.error("Error message");
    }
    ```

---

### **Log Levels in SLF4J**

SLF4J supports the following log levels:
1. **TRACE:** Finest-grained information, typically for debugging.
2. **DEBUG:** Detailed information for development and debugging.
3. **INFO:** General information about application flow.
4. **WARN:** Indication of potential issues.
5. **ERROR:** Serious errors requiring immediate attention.

The default log level in Spring Boot is **INFO**. Messages at levels below INFO (DEBUG, TRACE) are not logged unless explicitly configured.

---

### **Configuring Logging**

### **Changing Log Levels**

1. Open your `application.properties` file and specify the log levels for packages or classes.

    ```properties
    logging.level.org.springframework=INFO
    logging.level.com.example.myapp=DEBUG
    ```

2. To customize further, use `logback-spring.xml` for advanced configuration.

---

#### **Hands-On Example**

#### Add the logging code to our entry file to test it

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MySpringbootProjectApplication {

	private static final Logger logger = LoggerFactory.getLogger(MySpringbootProjectApplication.class); // Name this according to your class name

	public static void main(String[] args) {
		logger.info("🟢 Starting MySpringbootProjectApplication");
		logger.warn("🟠 Test Warning");
		logger.error("🔴 Error Warning");
		SpringApplication.run(MySpringbootProjectApplication.class, args);
	}
    
```
### Best Practices for Logging

1. **Avoid Sensitive Data:** Do not log passwords, credit card details, or other sensitive information.
2. **Use Appropriate Log Levels:** Use DEBUG for development and WARN/ERROR for production issues.
3. **Consistent Message Structure:** Follow a consistent format for log messages (e.g., `Action: Status - Details`).

---

#### **Further Reading**
-  <a href="http://www.slf4j.org/" target="_blank">SLF4J Documentation</a>
-  <a href="https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.logging" target="_blank">Spring Boot Logging Reference</a>
- <a href="https://logback.qos.ch/manual/configuration.html" target="_blank"> Logback Configuration Guide </a>

---

