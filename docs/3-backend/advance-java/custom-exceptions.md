# Lesson Objective

- Define generic exceptions and specific exception

- Understand how specific exceptions target particular error conditions while generic exceptions cover a broader range of errors.

-  Learn about custom exception and steps involved in creating custom exceptions by extending the Exception or RuntimeException class.

- Learn how to throw custom exceptions using the throw keyword.


# General vs Specific Exception Type

General exception types are `Exception` or `RuntimeException`, which are the superclasses of all exceptions. Hence, we can use them to catch all exceptions.

Specific exception types are the subclasses of `Exception` or `RuntimeException`. For example, `FileNotFoundException` is a subclass of `IOException`, which is a subclass of `Exception`.

When we handle exceptions, we can either `catch` the general exception or the specific exception type.

For example, in our divide by zero example, we could `catch` the `ArithmeticException` or `Exception`.

```java
try {
  int result = 10 / 0;
  System.out.println(result);
} catch (Exception exception) {
  System.out.println(exception);
}
```

Both cases will work. However, it is better to catch the specific exception because it provides more information about the nature of the error and we can handle it accordingly. It also makes the code more readable and maintainable.

---

##  Custom Exception

We can also create our own custom exception. To create a checked exception, we need to create a class that extends `Exception`. To create an unchecked exception, we need to create a class that extends `RuntimeException`.

Let's create an unchecked `InvalidArrayIndexException`.

```java
public class InvalidArrayIndexException extends RuntimeException {
  public InvalidArrayIndexException(String message) {
    super(message);
  }
}
```

In our `main` method, we can throw this exception when the index is invalid.

```java
try {
  if (index < 0 || index > numbers.length - 1) {
    throw new InvalidArrayIndexException(index + " is not a valid index!");
  }
  System.out.println(numbers[index]);
} catch (InvalidArrayIndexException exception) {
  System.out.println(exception);
}
```

Another example is a `NegativeNumberException`.

```java
public class NegativeNumberException extends RuntimeException {
  public NegativeNumberException(String message) {
    super(message);
  }
}
```

Let's say we have a `dividePostiveNumbers` method that takes in two positive numbers and divides them and if the user passes in a negative number, we want to throw a `NegativeNumberException`. This will then be handled by the calling method.

```java
public static int dividePositiveNumbers(int a, int b) {
  if (a < 0 || b < 0) {
    throw new NegativeNumberException("Negative numbers are not allowed.");
  }
  return a / b;
}
```

In `main`:

```java
try {### General vs Specific Exception Type

General exception types are `Exception` or `RuntimeException`, which are the superclasses of all exceptions. Hence, we can use them to catch all exceptions.

Specific exception types are the subclasses of `Exception` or `RuntimeException`. For example, `FileNotFoundException` is a subclass of `IOException`, which is a subclass of `Exception`.

When we handle exceptions, we can either `catch` the general exception or the specific exception type.

For example, in our divide by zero example, we could `catch` the `ArithmeticException` or `Exception`.

```java
try {
  int result = 10 / 0;
  System.out.println(result);
} catch (Exception exception) {
  System.out.println(exception);
}
```

Both cases will work. However, it is better to catch the specific exception because it provides more information about the nature of the error and we can handle it accordingly. It also makes the code more readable and maintainable.

---

## Custom Exception

We can also create our own custom exception. To create a checked exception, we need to create a class that extends `Exception`. To create an unchecked exception, we need to create a class that extends `RuntimeException`.

Let's create an unchecked `InvalidArrayIndexException`.

```java
public class InvalidArrayIndexException extends RuntimeException {
  public InvalidArrayIndexException(String message) {
    super(message);
  }
}
```

In our `main` method, we can throw this exception when the index is invalid.

```java
try {
  if (index < 0 || index > numbers.length - 1) {
    throw new InvalidArrayIndexException(index + " is not a valid index!");
  }
  System.out.println(numbers[index]);
} catch (InvalidArrayIndexException exception) {
  System.out.println(exception);
}
```

Another example is a `NegativeNumberException`.

```java
public class NegativeNumberException extends RuntimeException {
  public NegativeNumberException(String message) {
    super(message);
  }
}
```

Let's say we have a `dividePostiveNumbers` method that takes in two positive numbers and divides them and if the user passes in a negative number, we want to throw a `NegativeNumberException`. This will then be handled by the calling method.

```java
public static int dividePositiveNumbers(int a, int b) {
  if (a < 0 || b < 0) {
    throw new NegativeNumberException("Negative numbers are not allowed.");
  }
  return a / b;
}
```

In `main`:

```java
try {
  int result = dividePositiveNumbers(10, -2);
  System.out.println(result);
} catch (NegativeNumberException exception) {
  System.out.println(exception);
}
```

Notice also that this is not a checked exception, hence the compiler does not require us to handle it. Try changing it to a checked exception and see what happens.

  int result = dividePositiveNumbers(10, -2);
  System.out.println(result);
} catch (NegativeNumberException exception) {
  System.out.println(exception);
}
```

Notice also that this is not a checked exception, hence the compiler does not require us to handle it. Try changing it to a checked exception and see what happens.
