# Polymorphism

## Lesson Objective

- Understand Polymorphism and its significance in object-oriented programming (OOP).

- Distinguish between compile-time (static) and runtime (dynamic) polymorphism.

- Understand method overloading as a form of compile-time polymorphism.

- Understand method overriding as a form of runtime polymorphism.

## Introduction

Polymorphism means many forms i.e. the ability of a method to have different behaviours in different situations.

There are 2 types of polymorphism:

1. Static or compile-time polymorphism
2. Dynamic or run-time polymorphism

<iframe width="560" height="315" src="https://www.youtube.com/embed/gICOd0m84R0?si=SZSh3YN9HS8pWV8E&amp;start=378" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>





## Compile-time Polymorphism

Compile-time polymorphism is also known as **method overloading**. It occurs when there are multiple methods with the same name but different parameters.

It is called compile-time polymorphism because the compiler determines which method to call based on the number and type of arguments passed in.

```java
public class Calculator {
  public int add(int num1, int num2) {
    return num1 + num2;
  }

  public int add(int num1, int num2, int num3) {
    return num1 + num2 + num3;
  }

  public double add(double num1, double num2) {
    return num1 + num2;
  }
}
```

The `add()` method is overloaded 3 times. The compiler will determine which method to call based on the number and type of arguments passed in.

```java
Calculator calculator = new Calculator();
System.out.println(calculator.add(1, 2)); // 3
System.out.println(calculator.add(1, 2, 3)); // 6
System.out.println(calculator.add(1.5, 2.5)); // 4.0
```

Let's **overload** the `doWork()` method in `Student` class by accepting a `String` argument.

```java
public void doWork(String work) {
  System.out.println(this.name + " is doing " + work);
}
```

And run it in `main`.

```java
student.doWork("homework");
```

## Runtime Polymorphism

Runtime polymorphism is also known as **method overriding**. It occurs when a child class overrides a method of the parent class.

It is called runtime polymorphism because the JVM determines which method to call based on the object type.

Overriding is useful because it allows us to define a method in the child class that has the same name and signature as the method in the parent class. This allows us to call the same method on different types of objects and get different results.

Let's **override** the `doWork()` method in the `Student` class.

In the `Student` class file, right click, "Source Action, "Override/Implement Methods...".

```java
@Override
public void doWork() {
  System.out.println(this.name + " is studying.");
}
```

Now when we run the following code, the `doWork()` method in the `Student` class will be called instead of the `doWork()` method in the `Person` class.

```java
student.doWork();
```

## The `@Override` annotation

The `@Override` annotation is used to indicate that a method is being overridden. It is not required but it is good practice to use it.

## Runtime Polymorphism with `super`

In some cases, we may want to call the parent class method from the child class, in addition to defining a new behavior in the child class.

We can call the parent class method from the child class using the `super` keyword.

```java
public class Student extends Person {
  @Override
  public void doWork() {
    super.doWork();
    System.out.println("I am studying.");
  }
}
```