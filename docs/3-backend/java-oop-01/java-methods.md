
#  Java Methods

##  Lesson Objectives

- Define and call methods in Java using proper syntax.

- Understand the components of a method signature (return type, method name, parameters).

- Work with Return Types: Understand how methods can return values, including primitive types and objects.

##  Introduction

A method is a block of executable code which can be invoked. You can pass an optional set of arguments to the method. It may also optionally return data.

Java has two kinds of methods, predefined methods and user-defined methods.

Predefined methods are methods that are built-in with Java. An example would be the `println` method.

```java
System.out.println("Hello World");
```

User-defined methods are methods that developers create for the application.

Let's add a method `addNumbers` into our `MyApp.java` file. This should be within the class but outside the `main` method.

```java
public static void addNumbers (int a, int b) {
  System.out.println(a + b);
}
```

Inside the `main` method, we can call our method by using the method name and passing in the arguments.

```java
addNumbers(11, 77);
```
---
## Structure of a Method

A method has the following structure:

```java
<access modifier> <return type> <method name>(<parameters>) {
  // method body
}
```

#### Return Type

The **return type** is the data type of the value returned by the method. If the method does not return a value, the return type is `void`.

Let's modify the `addNumber` to return an `int`.

```java
public static int addNumbers (int a, int b) {
  return a + b;
}
```

#### Method Name

The convention is to use camelCase for method names.

#### Parameters

**Parameters** are variables that are passed into the method. They are optional. If the method does not require any parameters, we can leave the parentheses empty.

We may sometimes use the terms **parameters** and **arguments** interchangeably but there is a difference between the two. **Parameters** are the variables that are declared in the method signature. **Arguments** are the actual values that are passed into the method.

### `static` keyword

The `static` keyword is used to declare a static method. A static method belongs to the class and not to the object (instance of the class). This means that we can call a static method without creating an object of the class.

#### Static vs Non-static (Instance)

An instance method belongs to an object (instance of a class). This means that we need to create an object of the class before we can call an instance method.

| Static Method                      | Instance Method                    |
| ---------------------------------- | ---------------------------------- |
| Requires `static` keyword          | Omit `static` keyword              |
| Belongs to a class                 | Belongs to an object               |
| Can be invoked without an instance | Can only be invoked by an instance |
| Invoked with ClassName.methodName  | Invoked with objectName.methodName |

 For example, the `toString()` method from the `Arrays` class.

```java
int[] numbers = {1, 2, 3, 4, 5};
System.out.println(Arrays.toString(numbers));
```

And we have used instance methods with the `ArrayList` class. For example, we used the `add()` method by creating an object of the ArrayList class.

```java
// names is an instance of the ArrayList class
ArrayList<String> names = new ArrayList<String>();
names.add("John");
```

Let's create another class `Car.java` in the `mypackage` folder, and add a static method and an instance method to see the difference.

```java
package mypackage;

public class Car {

  // Static method
  public static void aboutCar() {
    System.out.println(
        "A car is a four-wheeled road vehicle.");
  }

  // Instance method
  public void drive() {
    System.out.println("Car moves ahead 1m.");
  }
}

```

We can call these methods in the `main` method of the `MyApp` class.

```java
public class MyApp {
  public static void main(String[] args) {
    Car.aboutCar();
    Car car = new Car();
    car.drive();
  }
}
```

Try to call the `drive()` method without creating an object of the `Car` class and see what happens.

```java
Car.drive();
```

Let's add a few more methods to our `Car` class.

```java
public void startEngine() {
  System.out.println("🚗 Starting engine...");
  System.out.println("✅ Engine started!");
}

public void startAircon() {
  System.out.println("💨 Aircon started!");
}

public void startRadio() {
  System.out.println("📻 Radio started!");
}

public void checkSeatBelts() {
  System.out.println("🪑 Seat belts checked!");
}
```

And call them in our app.

```java
myCar.startEngine();
myCar.startAircon();
myCar.startRadio();
myCar.checkSeatBelts();
```

#### Access Modifiers

An **access modifier** is a keyword that determines the accessibility of a method. There are four access modifiers in Java: `public`, `private`, `protected`, and `default`.

| Access Keyword | Description                                     |
| -------------- | ----------------------------------------------- |
| `public`       | accessible from anywhere                        |
| `private`      | accessible only from within the class           |
| `protected`    | accessible from within the class and subclasses |
| blank          | accessible from within the class and package    |

We may not always want our methods to be public. For example, we may want to restrict access to certain methods to prevent other classes from modifying the data in our class. In this case, we can use the `private` access modifier.

In our `Car` example, we want to restrict some of these methods because they should not be controlled directly. Let's change these 3 methods to be `private`.

```java
private void startAircon() {
  System.out.println("💨 Aircon started!");
}

private void startRadio() {
  System.out.println("📻 Radio started!");
}

private void checkSeatBelts() {
  System.out.println("🪑 Seat belts checked!");
}
```

Now if you try to call these methods in the `main` method, you will get an error. This is correct, because we should not be able to call these methods directly but only from within the class.

In this case, we want `startEngine()` to be the only method that can be called directly, which will in turn call these `private` methods.

```java
public void startEngine() {
  System.out.println("🚗 Starting engine...");
  System.out.println("✅ Engine started!");
  startAircon();
  startRadio();
  checkSeatBelts();
}
```

Our public method `startEngine()` will now call these private methods. We have now hidden some methods from public access. This is a concept called **encapsulation**, which we will cover in more detail in the next lesson.

### Method Overloading

A class can have multiple methods with the same name but declared with different parameters. This is called **method overloading**, which means providing 2 or more separate methods in a class with the same name but different parameters. This allows us to have different implementations of the same method.

Java can resolve which method it needs to execute, based on the arguments being passed.

There are 2 main rules to do method overloading:

1. The method name must be the same
2. The parameters must be different (either in number or data type)

### Valid vs Invalid Overloaded Method Signatures

The **method signature** consists of the method name and the parameter list. The return type is not part of the method signature.

```java
1 public static void myFn(int a)
2 public static void myFn(int b) // ❌ same parameter type as 1
3 public static void myFn(float a) // ✅
4 public static void myFn(double a) // ✅
5 public static void myFn(int a, int b) // ✅
6 public static void myFn(int b, int a) // ❌ same parameter types as 5
7 public static void myFn(int a, float b) // ✅
8 public static void myFn(int a, int b, int c) // ✅
9 public static int myFn(int a, int b, int c) // ❌ same parameter types as 8
```

### Method Overloading Example

Create a `LearnMethods.java` file and code along.

Let's create a method `calcBonus()` that calculates the bonus based on a salary.

```java
public static double calcBonus(double salary) {
  return salary * 0.1;
}
```

We can call this method in the `main` method.

```java

System.out.println("Employee bonus:" + calcBonus(5000));
```

Now let's create an overloaded method `calcBonus()` that calculates the bonus based on the salary and the bonus rate.

```java
public static double calcBonus(double salary, double bonusRate) {
  return salary * bonusRate;
}
```

We can call same method name with different parameters.

```java
System.out.println("Staff Bonus: " + calcBonus(5000, 0.2));
System.out.println("CEO Bonus: " + calcBonus(20000, 1.5));
```

Sidenote: we can use `printf` to format the decimal output.
https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Format-double-Java-printf-example

```java
System.out.printf("Staff Bonus: $%.2f\n", calcBonus(5000, 0.2));
System.out.printf("CEO Bonus: $%.2f\n", calcBonus(20000, 1.5));
```

END