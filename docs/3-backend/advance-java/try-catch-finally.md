# Lesson Objective

- Define the purpose and syntax of Try and Catch and Finally blocks.

- Learn how to use try,catch,finally to manage exceptions effectively.




# Try-Catch-Finally
The other approach for handling exceptions is the  EAFP approach using a `try-catch` block.

```java
try {
  int result = divide(x, y);
  System.out.println(result);
} catch (ArithmeticException exception) {
  System.out.println(exception);
}
```

In this approach, we try to execute the code in the `try` block. If there is an exception, we catch it in the `catch` block and handle it there.

With this approach, we can also add a `finally` block to execute code that should always be executed, regardless of whether there is an exception or not.

```java
try {
  int result = divide(x, y);
  System.out.println(result);
} catch (ArithmeticException exception) {
  System.out.println(exception);
} finally {
  System.out.println("This is the finally block");
}
```

Let's look at an example with an array.

```java
int[] numbers = { 1, 2, 3, 4, 5 };
int index = 5;
System.out.println(numbers[index]);
```

Accessing the array with an index of 5 throws an `ArrayIndexOutOfBoundsException`.

We can use the LBYL approach to check if the index is within the bounds of the array.

```java
if (index >= 0 && index < numbers.length) {
  System.out.println(numbers[index]);
} else {
  System.out.println("Index is out of bounds");
}
```

Or the EAFP approach with a `try-catch` block.

```java
try {
  System.out.println(numbers[index]);
} catch (ArrayIndexOutOfBoundsException exception) {
  System.out.println(exception);
}
finally {
  System.out.println("This is the finally block");
}
```

Here is another example with a `Scanner`.

```java
Scanner scanner = new Scanner(System.in);
System.out.print("Enter a number: ");
int number = scanner.nextInt();
System.out.println("You have entered: " + number);
scanner.close();
```

This will throw an `InputMismatchException` if the input is not an integer.

Looking at the stack trace, we can see that the exception occurred in the `nextInt` method, which was called by the `main` method. We are only interested in where the exception occurred in our code, so we can ignore the other methods in the stack trace.

```java
Exception in thread "main" java.util.InputMismatchException
        at java.base/java.util.Scanner.throwFor(Scanner.java:939)
        at java.base/java.util.Scanner.next(Scanner.java:1594)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        at LearnExceptions.main(LearnExceptions.java:36)
```

We can use the LBYL approach to check if the input is an integer before we call the `nextInt` method.

```java
if (scanner.hasNextInt()) {
  int number = scanner.nextInt();
  System.out.println(number);
} else {
  System.out.println("Input is not an integer");
}
```

Or the EAFP approach with a `try-catch` block.

```java
try {
  int number = scanner.nextInt();
  System.out.println(number);
} catch (InputMismatchException exception) {
  System.out.println(exception);
}
```