# Class Attributes and Methods

## Lesson Objectives

- what are classes and their use cases.

- The difference between class and object.

- Learn about accessor methods and how are they are different from the typical method?

- Create a class and instantiate it.

- Implement private properties to the class and its accessor methods.

## Introduction

Create an `App.java` and code along.

We had been defining variables and methods previously in our code.

Let's define some variables to represent a person and `static` methods to greet and eat.

```java
public class App {
  public static void main(String[] args) {

    String name1 = "Tony Stark";
    int age1 = 35;
    String gender1 = "male";
    boolean isMarried1 = true;

    String name2 = "Bruce Banner";
    int age2 = 36;
    String gender2 = "male";
    boolean isMarried2 = false;

    greet(name1, age1, gender1, isMarried1);
    eat(name1, "burger");

    greet(name2, age2, gender2, isMarried2);
    eat(name2, "pizza");
  }

  public static void greet(String name, int age, String gender, boolean isMarried) {
    System.out.println("Hello world, I'm " + name + " and I'm a " + age + " year old " + gender + ".");
  }

  public static void eat(String name, String meal) {
    System.out.println(name + " is currently eating " + meal);
  }
}

```

If you observe the above code, these variables are related to each other. They are all attributes of a person.

We can group them together in a class so that we can create multiple objects of the same type. This is easier than having to define variables separately for each person. More importantly, this will make our code more organized and easier to maintain.

### Class

A class is a blueprint for creating objects. It defines the attributes and methods that an object will have.

There can only be one public class in a file. The name of the file should match the name of the public class.

Create a `Person.java` file and define a `Person` class.

```java
public class Person {

}
```

### Methods and Attributes

When we talk about objects in the real world e.g. a car, a dog, a house, etc. we can describe it in terms of its **state** and its **behaviour**.

For example, a dog has state like its color, weight, breed, etc. It also has behaviours like bark, eat, run and play.

In Java, the state of an object is represented by its **attributes** and its behaviour is represented by its **methods**.

Let's add some attributes and methods to our Person class.

```java
public class Person {

  String name;
  int age;
  String gender;
  boolean isMarried;

  public void greet() {
    System.out.println("Hello world, I'm " + name + " and I'm a " + age + " year old " + gender + ".");
  }

  public void eat(String meal) {
    System.out.println(name + " is currently eating " + meal);
  }
}
```

We can instantiate the `Person` class in our `main` method and invoke the instance methods.

```java
public class App {
  public static void main(String[] args) {
    Person personA = new Person();

    personA.greet();
    personA.eat("burger");

  }
}
```




