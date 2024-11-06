
# Reading User Input

## Lesson Objectives

1. Understand how to use the scanner class and console class to read input from user

#### There are a few ways to read a user's input. Lets see two of the most common ways:

## 1. Using Scanner Class
##### The Scanner class provides a simple way to read input from the console in Java.

```java
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        
        scanner.close(); // Always close the scanner to avoid resource leak.
    }
}
```

## 2. Using `System.console().readLine()`.

##### Create `UserInputDemo.java` and insert the following code

```java
public class UserInputDemo {
  public static void main(String[] args) {
    String userInput = System.console().readLine("Enter your name:");
    System.out.println("Hello " + userInput);
  }
}
```
## Useful Tips

### Code Formatting

To configure Java code formatting in VS Code, when in a Java file, right click and select "Format Document With" and choose "Language Support for Java by Red Hat".

### Shortcuts

- Type "so" and press tab to generate `System.out.println()`
- Type "psvm" and press tab to generate `public static void main(String[] args)`

---
