## Unit Testing in Spring Boot

## Lesson Objectives:

1. Learn the purpose of unit testing, its importance in software development, and how to implement unit tests using JUnit and Mockito in a Spring Boot application.

2. Practice writing, organizing, and executing unit tests for different components, including service layers, following the Arrange-Act-Assert pattern to ensure robust and error-free code.

### Software Testing

Software testing is a process of executing a program or application with the intent of finding the software bugs. It can also be stated as the process of validating and verifying that a software program or application or product meets the business and technical requirements.

### Types Of Testing :

Spring Boot applications can be tested at various levels, including,

- **Unit Testing**: Tests individual components (e.g., services, repositories) in isolation using tools like JUnit and Mockito.  

- **Integration Testing**: Verifies interactions between components with a loaded application context using `@SpringBootTest`.  

- **Functional Testing**: Ensures specific features work as intended, often using `MockMvc` for simulating user actions.  

- **End-to-End Testing**: Validates the entire application flow, from UI to database, using tools like Selenium or Postman.  

This course will introduce learners to:

- Unit Testing on Service Layer using JUnit and Mockito

- Integration Testing on REST API using `MockMvc`



## Unit Testing

As of now, we test our application by running the application and manually testing the endpoints using Postman. Just calling an API endpoint does not guarantee that the code is working as expected. Because we may have complex logic in our service layer, we need to test the code in our service layer in isolation as well.

For bigger or more complex projects, this can be a problem because every time we make a change to the code, it requires a real person to look at the output and verify that it is correct.

Hence, we should automate our testing process by writing unit tests.

### What is Unit Testing?

Unit testing is a type of software testing where individual units or components of a software are tested. The purpose is to validate that each unit of the software performs as designed. Such tests are also independent of other units and can be run in isolation so that we can test each unit separately.

More importantly, these tests can be performed automatically and are reproduced easily. This is important because we want to be able to run these tests frequently and quickly.

With these tests in place, when we add new features or refactor our code, we can run these tests to ensure that our code is still working as expected. In addition, if team members leave the project, we can be sure that the new team members can run these tests to verify that the code is working as expected.

### Unit Testing Frameworks

We will be using these frameworks for our unit tests:

- <a href="https://junit.org/junit5/" target="_blank">JUnit</a>: a unit testing framework that allows us to create and run unit tests
- <a href="https://site.mockito.org/" target=_blank> Mockito </a>: a mocking framework that allows us to create mock objects for our unit tests

In Spring Boot, these frameworks are included in the `spring-boot-starter-test` dependency.

We use mock objects to simulate the behavior of real objects. This is useful when we want to test a class that depends on another class. Instead of creating an instance of the other class, we can create a mock object that simulates the behavior of the other class. This lets us test our class in isolation.

### Unit Test Example with `@Test`

Let's see a simple example of unit testing. We will use our `simple-crm` code base for this example so that we do not have to create another project.

Create a `DemoService.java`.

```java
public class DemoService {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}
```

We can then create a corresponding `DemoServiceTest.java` class in the `src/test/java` folder.

There are 3 steps in writing a unit test:

1. Setup - Create an instance of the class to be tested
2. Execute - Call the method to be tested
3. Assert - Check the result

This pattern is also known as the **Arrange-Act-Assert** pattern, or **Given-When-Then** pattern.
<a href="https://automationpanda.com/2020/07/07/arrange-act-assert-a-pattern-for-writing-good-tests/" target="_blank"> Arrange-Act-Assert </a>

We create a method annotated with `@Test` for each test case.

```java
public class DemoServiceTest {

  @Test
  public void testAdd() {
    // 1. SETUP
    // Create the instance of the class that we want to test
    DemoService demoService = new DemoService();

    // Define the expected result
    int expectedResult = 8;

    // 2. EXECUTE
    // Call the method that we want to test
    int actualResult = demoService.add(3, 5);

    // 3. ASSERT
    // Compare the actual result with the expected result
    assertEquals(expectedResult, actualResult, "3 + 5 should be 8");
  }

  @Test
  public void testSubtract() {
    // 1. SETUP
    // Create the instance of the class that we want to test
    DemoService demoService = new DemoService();

    // Define the expected result
    int expectedResult = 2;

    // 2. EXECUTE
    // Call the method that we want to test
    int actualResult = demoService.subtract(5, 3);

    // 3. ASSERT
    // Compare the actual result with the expected result
    assertEquals(expectedResult, actualResult, "5 - 3 should be 2");
  }

}
```

We use assertions to check if the actual result is the same as the expected result. If the actual result is not the same as the expected result, the test will fail.

To run the test, we can click on the green arrow next to the test method. Alternatively, we can type `mvn test` on the terminal.

Let's say we made a mistake in our code, like this:

```java
public int add(int a, int b) {
    return a * b;
}
```

Try to run the test again. You should see that the test fails.

Once you get more familiar with the process, the earlier code could be simplified to:

```java
public class DemoServiceTest {

    @Test
    public void testAdd() {
      DemoService demoService = new DemoService();
      assertEquals(8, demoService.add(3, 5), "3 + 5 should be 8");
    }

}
```

We will be using the longer version for now so that it is easier to understand.

Notice that we are not using dependency injection here. This is because we are testing without spinning up the Spring context. Hence, there are no beans available to be injected. One advantage of doing so is that the test will run faster since it does not involve Spring initialization and container startup.

### Assertions

JUnit has many assertion methods that we can use. Some of the commonly used ones are:

| Method                | Description                                          |
| --------------------- | ---------------------------------------------------- |
| `assertEquals()`      | Checks that two primitives/objects are equal         |
| `assertNotEquals()`   | Checks that two primitives/objects are not equal     |
| `assertTrue()`        | Checks that a condition is true                      |
| `assertFalse()`       | Checks that a condition is false                     |
| `assertNull()`        | Checks that an object is null                        |
| `assertNotNull()`     | Checks that an object is not null                    |
| `assertArrayEquals()` | Checks that two arrays are equal                     |
| `assertThrows()`      | Checks that an exception is thrown by the executable |

You can read more about JUnit assertions <a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions" target="_blank"> here</a>

### Lifecycle Methods

JUnit also has lifecycle methods that we can use to perform setup and teardown operations. These methods are annotated with `@BeforeAll`, `@BeforeEach`, `@AfterEach` and `@AfterAll`.

| Method        | Description                                                |
| ------------- | ---------------------------------------------------------- |
| `@BeforeAll`  | Executed once before all test methods in the current class |
| `@BeforeEach` | Executed before each test method in the current class      |
| `@AfterEach`  | Executed after each test method in the current class       |
| `@AfterAll`   | Executed once after all test methods in the current class  |

We could move the instantiation of the `DemoService` into the `@BeforeEach` method so that we do not have to repeat the code in every test method.

```java
public class DemoServiceTest {

  DemoService demoService;

  // This method is executed before each test method
  @BeforeEach
  public void init() {
    demoService = new DemoService();
  }
}
```

