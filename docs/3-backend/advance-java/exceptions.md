# Exception

# Lesson Objective

- Define what an exception is and understand its role in managing errors during program execution.

- Understand how exceptions propagate through the call stack.

- Learn about the different approaches to deal with exceptions.

## Introduction 

An exception (or exceptional event) is a problem that arises during the execution of a program. When an Exception occurs the normal flow of the program is disrupted and the program/Application terminates abnormally, which is not recommended, therefore, these exceptions are to be handled.

**<a href="https://docs.oracle.com/javase/tutorial/essential/exceptions/definition.html" target="_blank">Read more on Exceptions here</a>**

When an error occurs within a method, the method creates an object and hands it off to the runtime system. The object, called an **exception object**, contains information about the error, including its type and the state of the program when the error occurred. Creating an exception object and handing it to the runtime system is called **throwing an exception**.

<img src="https://www3.ntu.edu.sg/home/ehchua/programming/java/images/Exception_CallStack.png" width="450">

**<a href="https://www3.ntu.edu.sg/home/ehchua/programming/java/j5a_exceptionassert.html" target="_blank">Source</a>**


The runtime system searches the **call stack** for a method that contains a block of code that can handle the exception. This block of code is called an **exception handler**.

If no appropriate exception handler is found, then the program terminates.

### Advantages of Exceptions

1. Separating Error-Handling Code from "Regular" Code

   - The ability to throw exceptions makes it easy to separate error-handling code from regular code.

1. Propagating Errors Up the Call Stack

   - The ability to propagate errors up the call stack in this manner means that you do not have to check for errors immediately where they occur and handle them there. Instead, you can let a sequence of methods return from their work and pass the bug to their callers. This allows you to write your methods to handle the normal case and to simply propagate exceptions that are caused by boundary conditions or other unexpected situations.

1. Grouping and Differentiating Error Types

   - Each exception that occurs indicates a particular error condition. You can create your own exceptions to indicate to callers of your methods that your methods cannot achieve their stated goals.

## Looking at Our First Exception

Create a file `LearnExceptions.java` and code along.

Add a method `divide`.

```java
public static int divide(int x, int y) {
  return x / y;
}
```

And call it in the `main` method.

```java
public static void main(String[] args) {
  int x = 10;
  int y = 0;
  int result = divide(x, y);
  System.out.println(result);
}
```

Run the code and see what happens.

As you might expect, the code throws an exception because you cannot divide by zero.

Java prints something known as a **stack trace**. The stack trace shows what is known as the **call stack**. The call stack, in simple terms, is the list of methods that were called. The call stack is important because it shows you the order in which methods are called and where the error occurred.

In our example here, the call stack is: `main` -> `divide`.

By looking at the stack trace, we can tell that the exception occurred in the `divide` method, which was called by the `main` method.

```java
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at LearnExceptions.divide(LearnExceptions.java:15)
        at LearnExceptions.main(LearnExceptions.java:5)
```

## LBYL and EAFP Approaches

There are 2 main approaches to dealing with errors when programming.

1. Look Before You Leap (LBYL)
1. Easier to Ask for Forgiveness than Permission (EAFP)

LBYL means that you check for errors before you execute the code.

EAFP means that you let the code run, throw an exception if there is an error, and then handle the exception.

**<a href="https://programmingduck.com/articles/lbyl-eafp" target="_blank"> LBYL vs EAFP </a>**


Using the LBYL approach in our `main`, we can first check if the divisor is zero before we allow the `divide` method to be called.

```java
public static void main(String[] args) {
  int x = 10;
  int y = 0;

  if (y == 0) {
    System.out.println("Cannot divide by zero");
  } else {
    int result = divide(x, y);
    System.out.println(result);
  }
}
```

Now the code will run without any errors.

As you can see, with LBYL, the developer proactively checks the conditions before executing the code, which avoids the exception. This also makes the code readable and clear as to what preconditions need to be satisfied before an action is performed.

However, there are some disadvantages to LBYL. For example, if the condition is checked in one place, but the code is executed in another place, then the condition may change between the check and the execution. This can lead to unexpected results. It could also lead to unnecessary code duplication and increased complexity.

We shall look into the other approach (EAFP) in the next lesson.

