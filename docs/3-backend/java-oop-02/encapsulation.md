# Encapsulation

# Learning Objective

-  Understand encapsulation and how it improves data security and abstraction.

-  Recognize the role of access modifiers (private, public, protected, default) in encapsulation.

-  Learn to use getter and setter methods to control access to class fields.

-  Write a Java class that encapsulates its fields using private access modifiers


## Introduction

Object Oriented Programming (OOP) is a programming paradigm that is based on the concept of objects. It is a way of organizing code into objects that have state (attributes) and behavior (methods).

OOP is based on 4 principles:

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction



## What is Encapsulation?

Encapsulation is

- Bundling of behaviours and attributes on a single object
- Hiding fields and some methods from public access

By setting fields to private, we are hiding them from public access. We can then provide public methods to access and modify the fields.

Let's define a `Person` class.

```java
public class Person {

  // FIELDS
  private String name;
  private int birthYear;

  // CONSTRUCTORS
  public Person() {
  }

  public Person(String name, int birthYear) {
    this.name = name;
    this.birthYear = birthYear;
  }

  // INSTANCE METHODS
  public void greet() {
    System.out.println("👋 Hello, my name is " + this.name + " and I am a " + (2023 - this.birthYear) + " year old person.");
  }

  public void doWork() {
    System.out.println(this.name + " is working.");
  }

  // GETTERS AND SETTERS
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBirthYear() {
    return this.birthYear;
  }

  public void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
  }
}

```

In this way, we can protect the fields from accidental changes and misuse.

For example we could prevent setting a negative age for a person.

```java
public void setBirthYear(int birthYear) {
  if (birthYear < 1900 || birthYear > 2021) {
    System.out.println("Invalid birth year.");
    return;
  }
  this.birthYear = birthYear;
}
```

If the `birthYear` field is public, we cannot prevent the user from setting an invalid value.

Create `App.java` and test this

```java
Person person = new Person("Tony Stark", 1975);
person.setBirthYear(0);
person.greet();
person.doWork();
```

The users of our public methods do not need to know how the method works. Even if we were to make some internal changes, the user would not be affected.

For example, if we were to change the criteria for a valid birth year, we would only need to change the `setBirthYear` method. The user would not need to change their code.

```java
public void setBirthYear(int birthYear) {
  // if (birthYear < 1900 || birthYear > 2021) {
  if (birthYear < 1970 || birthYear > 2020) {
    System.out.println("Invalid birth year.");
    return;
  }
  this.birthYear = birthYear;
}
```

---
