# Lesson Objectives

- Learn differences between sequential execution, conditional (branching), and iterative (looping) control flow in Java.

- Implement Conditional Statements :if, if-else, switch in Java programs.

- Use looping constructs such as for, while, and do-while to execute repetitive tasks in Java.

- Use Break and Continue Statements to control the flow within loops and switch cases.




##  Control Flow Statements

Control flow or conditional statements allow programs alter their outputs given different inputs.

The control flow statements:

1. Decision Making Statements

- if else
- switch

2. Loop Statements

- for
- while / do while

3. Jump/Branching Statements

- break
- continue

### Create `LearnControlFlow.java` and Code Along

```java
public class LearnControlFlow {
  public static void main(String[] args) {

    int budget = 1000;
    int expense = 90;
  }

}
```

### `if else`

```java
if(budget > expense) {
  System.out.println("You are within budget");
} else {
  System.out.println("You are over budget");
}
```

### `if else if`

```java
int score = 70;

if(score > 90) {
  System.out.println("A");
} else if (score > 80) {
  System.out.println("B");
} else if (score > 70) {
  System.out.println("C");
} else if (score > 60) {
  System.out.println("D");
} else {
  System.out.println("F");
}
```

### Nested `if else`

`if else` can be nested if needed.

```java
int age = 20;
int weight = 120;

if(age > 18) {
  if(weight > 100) {
    System.out.println("You are eligible to donate blood");
  } else {
    System.out.println("You are not eligible to donate blood");
  }
} else {
  System.out.println("You are not eligible to donate blood");
}
```

### On Comparing `String` Variables

Because the `String` is not a primitive type, when comparing `String` variables, you should use the `equals()` method instead of the `==` operator.

In Java, the `==` operator compares the memory addresses of the two objects, while the `equals()` method compares the values of the two objects.

We can test this out in JShell.

```java
String myFruit = "apple";
String hisFruit = new String("apple"); // this creates a new reference

myFruit == hisFruit; // false because different memory addresses
myFruit.equals(hisFruit); // true because commparing the contents
```

### `for` Loop

The `for`, `while` and `do while` statements are used for looping i.e. to execute a block of code repeatedly.

The `for` loop is used when the number of iterations is known.

```java
for (int i = 0; i < 5; i++) {
  System.out.println("i: " + i);
}
```

### `while` Loop

The `while` loop is used when the number of iterations is unknown.

```java
boolean isRunning = true;
int i = 0;
while (isRunning) {
  System.out.println("i: " + i);
  if (i == 5) {
    isRunning = false;
  }
  i++;
}
```

### `do while` Loop

The difference between `while` and `do while` is that the `do while` loop will always execute the code block at least once, even if the condition is false.

```java
boolean isRunning = false;
int i = 0;
do {
  System.out.println("i: " + i);
  if (i == 5) {
    isRunning = false;
  }
  i++;
} while (isRunning);
```

### `break` and `continue`

The `break` statement is used to terminate a loop. It is usually used with an `if` statement.

```java
for (int i = 0; i < 10; i++) {
  if (i == 5) {
    break;
    // The code below will not be executed and the loop will terminate
  }
  System.out.println("i: " + i);
}
```

The `continue` statement is used to skip the current iteration and continue with the next iteration.

```java
for (int i = 0; i < 10; i++) {
  if (i == 5) {
    continue;
    // The code below will not be executed and the loop will continue with the next iteration
  }
  System.out.println("i: " + i);
}
```



### `switch` Statement

The `switch` statement is used to perform different actions based on different conditions. It is similar to `if else` but is more concise when there are many conditions.

Create a new file `LearnSwitch.java`.

```java
public class LearnSwitch {
  public static void main(String[] args) {

    String direction = "N";

    switch (direction) {
    case "N":
      System.out.println("You have chosen North");
      break;
    case "E":
      System.out.println("You have chosen East");
      break;
    case "W":
      System.out.println("You have chosen West");
      break;
    case "S":
      System.out.println("You have chosen South");
      break;
    default:
      System.out.println("Invalid input");
    }
  }
}
```

The `break` statement is used to terminate a `case` statement. Without the `break` statement, the program will continue to execute the next `case` statement. This is known as "falling through".

`default` is used to specify the code to run if there is no case match.

Note that the `switch` statement can only be used with the following data types: `byte`, `short`, `char`, `int`, `String` and `enum` (to be discussed later). For other data types, you must use `if else` statements.

Multiple `case` statements can be combined too.

```java
switch (direction) {
  case "N":
  case "E":
  case "W":
  case "S":
    System.out.println("You have chosen a valid direction");
    break;
  default:
    System.out.println("Invalid input");
}
```

Another example of combining multiple cases:

```java
String month = "January";
String selectedQuarter = "";

switch (month) {
  case "January":
  case "February":
  case "March":
    selectedQuarter = "Q1";
    break;
  case "April":
  case "May":
  case "June":
    selectedQuarter = "Q2";
    break;
  case "July":
  case "August":
  case "September":
    selectedQuarter = "Q3";
    break;
  case "October":
  case "November":
  case "December":
    selectedQuarter = "Q4";
    break;
  default:
    selectedQuarter = "Unknown";

}
```

### Enhanced `switch` Statement

The enhanced `switch` statement, also known as a **switch expression**, was introduced in JDK 14. It is more concise than the traditional `switch` statement. If you are using earlier versions of Java, you should use the traditional `switch` statement.

We can modify the earlier example to use the enhanced `switch` statement.

```java
switch (direction) {
  case "N" -> System.out.println("You have chosen North");
  case "E" -> System.out.println("You have chosen East");
  case "W" -> System.out.println("You have chosen West");
  case "S" -> System.out.println("You have chosen South");
  default -> System.out.println("Invalid input");
}
```

The main differences are:

- The `case` statements are now written as `case value -> statement`.
- The `break` statement is no longer needed.
- The `default` statement is now written as `default -> statement`.

As with the traditional switch statement, cases can be combined as well.

```java
switch (direction) {
  case "N", "E", "W", "S" -> System.out.println("You have chosen a valid direction");
  default -> System.out.println("Invalid input");
}
```

The `switch` expression can return the value directly as well. Using the month example from above:

```java
String quarter = switch (month) {
  case "January", "February", "March" -> "Q1";
  case "April", "May", "June" -> "Q2";
  case "July", "August", "September" -> "Q3";
  case "October", "November", "December" -> "Q4";
  default -> "Unknown";
};

System.out.println("quarter: " + quarter);
```

To customize our return value, we can use the `yield` keyword.

```java
int ratingScore = 6;

String rating = switch (ratingScore) {
  case 1, 2, 3 -> "Bad";
  case 4 -> "OK";
  case 5 -> "Good";
  default -> {
    // return keyword does not work here
    // return ratingScore + " is not a valid rating score";
    yield ratingScore + " is not a valid rating score";
  }
};

System.out.println("rating is : " + rating);
```

### 👨‍💻 Activity: `ConditionalsPractice.java`



Recall in our previous lesson, we used `System.console().readLine()` to read user input. Using `if else`, we can check if a user name is entered correctly.

```java
String userName = System.console().readLine("Enter your user name: ");
System.out.println("userName: " + userName);

if(userName.equals("admin")) {
  System.out.println("😊 Welcome Admin");
} else {
  System.out.println("😡 Unauthorized user!");
}
```

#### Task 1

Use the `do while` loop to prompt the user to enter the user name. If the user name is not "admin", prompt the user to enter the user name again.

We will use the command line to compile and run this program as the IDE blocks `readline()`.

```bash
javac LearnControlFlow.java && java LearnControlFlow
```

🍀 Hint: You will need a variable to track if the user name is valid.

#### Task 2

If the user name is still incorrect after 3 tries, terminate the program.

🍀 Hint: You will need to `break` out of the loop.


---

## Part 3: `enum`

Java provides a special data type called `enum` to support enumeration. It is used to define a collection of constants. Enums are useful to represent a fixed set of values, such as days of the week, months of the year, etc.

Because it is a finite set of constants, it is more type safe than using `String` or `int` variables.

By convention, we use `SCREAMING_SNAKE_CASE` for enum constants.

```java
enum CompassDirection {
  N, S, E, W
}

enum Month {
  JAN, FEB, MAR, APR, JUN, JUL, AUG, SEP, OCT, NOV, DEC
}

Month nationalDayMonth = Month.AUG;
System.out.println("nationalDayMonth: " + nationalDayMonth);
```

---

## Part 4: `switch` Expression with Enums

As mentioned earlier, enum is one of the types supported by the switch statement.

```java
CompassDirection myDirection = CompassDirection.N;

switch (myDirection) {
  case N -> System.out.println("You have chosen North");
  case E -> System.out.println("You have chosen East");
  case W -> System.out.println("You have chosen West");
  case S -> System.out.println("You have chosen South");
  default -> System.out.println("Invalid input");
}
```

---

