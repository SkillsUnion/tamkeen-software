##  Java Logging

## Lesson Objectives:

- Understand the purpose of logging and how it helps in debugging and monitoring applications.

- Learn how to use `java.util.logging` (JUL) to log messages at different levels.

- Configure logging to output messages to a file instead of the console.

Create a `LoggerDemo.java` and code along.

Logging is a way to record information about the program's execution. It is useful for debugging and monitoring the program.

### Java Logging API

Java provides a logging API called `java.util.logging` (JUL).

To use the logging API, we need to import the `java.util.logging` package.

```java
import java.util.logging.Logger;
```

Next, we need to create a `Logger` object. We can do this by calling the `getLogger` method in the `Logger` class.

```java
private final static Logger logger = Logger.getLogger(LoggerDemo.class.getName());
```

The `getLogger` method takes in a `String` argument, which is the name of the logger. This is usually the fully qualified class name, which we can get by calling `getName`. This helps in identifying the source of the log messages.

We use the `final` keyword so that `logger` cannot be changed once initialized. This prevents accidental changes to the `logger` object.

### Logging Levels

There are different logging levels:

| Level     | Description                                                                                                                                                                    |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `SEVERE`  | The highest level of logging. Used to indicate serious errors or failures that may prevent the application from functioning properly or require immediate attention.           |
| `WARNING` | Indicates potential problems or situations that might lead to errors or unexpected behavior in the future. The application can still continue running after logging a warning. |
| `INFO`    | Used to log informational messages about normal application behavior.                                                                                                          |
| `CONFIG`  | Used to log configuration-related information. For example, when your application initializes or configures components.                                                        |
| `FINE`    | information about the program's execution that is useful for debugging                                                                                                         |
| `FINER`   | more detailed information about the program's execution that is useful for debugging                                                                                           |
| `FINEST`  | the most detailed information about the program's execution that is useful for debugging                                                                                       |

<a href="https://docs.oracle.com/javase/8/docs/api/java/util/logging/class-use/Level.html" target = "_blank"> read more on logging here </a>

For JUL, by default, the logging level is `INFO`. This means that only all messages with a logging level of `INFO` or higher will be logged. Additional configuration is needed to log messages with a logging level lower than `INFO`.

### Logging Messages

We can use the `log` method to log messages. The `log` method takes in a `Level` argument and a `String` argument. The `Level` argument is the logging level and the `String` argument is the message to be logged.

```java
logger.log(Level.SEVERE, "🔴 This is a severe message.");
logger.log(Level.WARNING, "🟠 This is a warning message.");
logger.log(Level.INFO, "🟢 This is an info message.");
// In your free time, try to research how to log the following messages too
// logger.log(Level.CONFIG, "🟡 This is a config message.");
// logger.log(Level.FINE, "🟣 This is a fine message.");
```

We could also use the shorthand methods provided by JUL to log messages.

```java
logger.severe("🔴 This is a severe message.");
logger.warning("🟠 This is a warning message.");
logger.info("🟢 This is an info message.");
```

Try it with an `ArrayIndexOutOfBoundsException`.

```java
int[] arr1 = { 1, 2, 3, 4 };

try {
  System.out.println(arr1[4]);
} catch (ArrayIndexOutOfBoundsException e) {
  logger.severe("🔴 " + e.getMessage());
  System.out.println(e);
} finally {
  logger.warning("🟠 Be careful!");
}
```

### Logging to a File

By default, the log messages are printed to the console. We can configure the logger to print the log messages to a file instead.

To do this, we need to create a `FileHandler` object. The `FileHandler` object takes in a `String` argument, which is the path to the log file.

```java
try {
  Handler fileHandler = new FileHandler("mylogfile.log", true);
  // Format the log messages
  SimpleFormatter formatter = new SimpleFormatter();
  fileHandler.setFormatter(formatter);
  // add the handler to the logger
  logger.addHandler(fileHandler);
} catch (IOException e) {
  System.out.println(e);
}
```