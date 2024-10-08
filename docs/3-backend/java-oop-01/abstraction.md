# Abstraction

# Learning Objectives

- Understand the concept of abstraction 

- Recognize the role of abstract classes and interfaces in achieving abstraction in Java.

- Implement abstract classes in Java, define abstract methods, and understand how to extend and use abstract classes.

- Explore the use of default methods in interfaces (introduced in Java 8).

## Introduction

Abstraction is when we generalize a set of characteristics and behaviors into a class.

For example, animals, vehicles, products, etc. are all abstract concepts. They are not tangible objects that we can touch or see. Of course, we know examples of vehicles such as cars, vans, lorries, buses but these are all more concrete objects. But it would be hard to say, draw a vehicle, without knowing what type of vehicle we are talking about. So, we say that a vehicle is an abstract concept.

Abstraction helps us to think about things as groups and generalize their functionalities.

We can do abstraction in Java using:

- Abstract classes
- Interfaces
- Superclasses

## Abstract Classes

An abstract class is a class that is declared with the `abstract` keyword. It can have abstract and non-abstract methods.

An abstract method is a method that is declared without an implementation. It is declared with the `abstract` keyword. The implementation **must** be provided by the subclass.

An abstract class cannot be instantiated. It can only be used as a superclass for other classes.

In the case of our `Person` class, we can make it an abstract class because we do not intend to instantiate it. We only want to use it as a superclass for other subclasses.

We can also make the `doWork()` method `abstract` because we do not want to define the behavior of the `doWork()` method in the `Person` class. We want to define the behavior of the `doWork()` method in the child classes.

```java
public abstract class Person {
  // ...

  public abstract void doWork();
}
```

Once we declare `Person` as `abstract`, it can only be used as a superclass for other classes.

Now when we try to instantiate the `Person` class, we will get an error.

```java
Person person = new Person("Tony Stark", 2000, 12345);
```

## Interfaces

An **interface** is a similar concept to an abstract class. It is declared with the `interface` keyword. Unlike abstract classes though, an interface cannot have instance variables. From Java 8 onwards, it can also have default methods and static methods.

An interface is usually named after the functionality that it provides. It is common to name interfaces with the suffix `able` e.g. Drivable, Runnable, Comparable, etc.

Interfaces allow us to specify what a class must do, without specifying how it should do it.

Using interfaces allows us to define a common behaviour that can be shared among multiple classes. This is useful when we want to define a common behavior for classes that are not related to each other.

For example, we might want to have a common behaviour, say `Trackable` for a `Car` as well as a `MobilePhone`. The `Car` and the `MobilePhone` are not related conceptually but yet we may need to implement a trackable behaviour for both. We can define a `Trackable` interface and have both the `Car` and `MobilePhone` classes implement the `Trackable` interface.

Create a file `LearnInterfaces.java` and code along. If you wish to do it in a single file, just omit the `public` keyword for the following interface and classes.

```java
public interface Trackable {
  // public abstract void track();
  // public and abstract are not required
  void track();
}
```

Any method declared in an interface is by default `public` and `abstract`. So, we do not need to specify the `public` and `abstract` keywords.

To use the `Trackable` interface, we need to implement it in the `Car` and `MobilePhone` classes with the `implements` keyword.

```java
public class Car implements Trackable {
  private String name;
  private int year;

  public Car() {
  }

  public Car(String name, int year) {
    this.name = name;
    this.year = year;
  }

  @Override
  public void track() {
    System.out.println("Tracking car " + this.name + " from " + this.year + ".");
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
```

```java
public class MobilePhone implements Trackable {
  private String model;

  public MobilePhone() {
  }

  public MobilePhone(String model) {
    this.model = model;
  }

  @Override
  public void track() {
    System.out.println("Tracking mobile phone " + this.model + ".");
  }
}
```

And test it out with the following code.

```java
Car car = new Car("Toyota", 2022);
car.track();

MobilePhone phone = new MobilePhone("iPhone 14");
phone.track();
```

Unlike inheritance, a class can implement multiple interfaces. A car can be `Trackable` as well as `Drivable`.

Let's define a `Drivable` interface.

```java
public interface Drivable {
  void drive();
  void stop();

  // Java 8 onwards - default method
  default void honk() {
    System.out.println("Honk!");
  }
}
```

Default methods were added in Java 8. This was because previously it was not possible to add new methods to an interface without breaking the existing implementations of the interface.

Now, the classes that implement the interface can choose to override the default method with their own implementation, or they can simply use the default implementation.

```java
public class Car implements Trackable, Drivable {
  // ...
  @Override
  public void track() {
    System.out.println("Tracking car...");
  }

  @Override
  public void drive() {
    System.out.println("Driving car...");
  }

  @Override
  public void stop() {
    System.out.println("Stopping car...");
  }
}
```

Test the `Car` class with the following code.

```java

Car car = new Car("Toyota", 2022);
car.track();
car.drive();
car.stop();
car.honk();
```
