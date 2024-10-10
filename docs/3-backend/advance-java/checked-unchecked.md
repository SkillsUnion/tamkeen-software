
# Checked And UnChecked Exceptions

## Lesson Objectives

- Understand the distinction between checked exceptions (compile-time) and unchecked exceptions (runtime).

- Learn how to handle checked exceptions using try, catch, and finally blocks.

- Understand the role of throws clause in method declarations for checked exceptions.

## Unchecked Exceptions

So far we have seen `ArithmeticException`, `ArrayIndexOutOfBoundsException`, and `InputMismatchException`. These types of exceptions are known as **unchecked exceptions**. Unchecked exceptions are exceptions that are not checked at compile time. They are also known as **runtime exceptions** because they occur at runtime i.e., when the program is running.

Runtime exceptions usually occur due to programming errors. These are errors that can be avoided by writing better code.

It is the developer's responsibility to anticipate such exceptions and write code that prevents them from being thrown. For example, if we are getting input from the user, we should check if the input is valid before we use it.

## Checked Exceptions

The other type is known as **checked exceptions**, which are checked at compile time. Hence, they are also known as **compile-time exceptions**.

The Java compiler checks and ensures that the code handles the checked exceptions. If the code does not handle the checked exceptions, the code will not compile.

Let's try to use the `FileInputStream` class to read a file.

```java
FileInputStream f = new FileInputStream("test.txt");
```

VSCode will show an error because the `FileInputStream` constructor throws a `FileNotFoundException`, which is a checked exception.

This means that this code could potentially throw a `FileNotFoundException` and Java requires us to handle this exception using a `try-catch` block.

```java
try {
  // Create a new FileInputStream object
  FileInputStream f = new FileInputStream("test.txt");
  // Create a new Scanner object and pass the FileInputStream object
  Scanner s = new Scanner(f);
  // Print the first line of the file
  System.out.println(s.nextLine());
  // Close the file
  s.close();
} catch (FileNotFoundException exception) {
  System.out.println(exception.getMessage());
}
```

### Propagating Exceptions Up the Call Stack

We can also propagate exceptions up the call stack. Let's say we put the previous file reading code into a method.

Instead of doing `try-catch` in this method, we can throw an exception from the method and let the calling method handle it.

To see this, let's put the code in a `readFileFirstLine` method.

```java
public static void readFileFirstLine(String filename) {

  // Create a new FileInputStream object
  FileInputStream f = new FileInputStream(filename);
  // Create a new Scanner object and pass the FileInputStream object
  Scanner s = new Scanner(f);

  if (s.hasNextLine()) {
    // Print the first line of the file
    System.out.println(s.nextLine());
  } else {
    System.out.println("File is empty");
  }
  // Close the scanner
  s.close();

}
```

Once the `try-catch` block is removed, we can see the unhandled exception error in VSCode because Java requires us to handle the checked exception.

We can propagate this exception using the `throws` keyword. With the `throws FileNotFoundException` clause, we are telling the compiler that this method could potentially throw a `FileNotFoundException` and we are not handling it here. Instead, the user who is calling this method needs to handle it.

```java
public static void readFileFirstLine(String filename) throws FileNotFoundException
```

And in our `main`:

```java
public static void main(String[] args) {
  try {
    readFileFirstLine("test.txt");
  } catch (FileNotFoundException exception) {
    System.out.println(exception.getMessage());
  }
}
```