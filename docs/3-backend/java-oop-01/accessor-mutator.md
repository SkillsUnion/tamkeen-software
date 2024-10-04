# Accessor and Mutator Methods

## Lesson Objectives

- Encapsulate class data by using private fields and understand how to access and modify the values using Accessor and Mutator methods.


## Introduction

In the previous lesson, we learned how to use access modifiers to control access to methods. We can also use access modifiers to control access to attributes. We refer to class attributes and methods as **class members**.

| Access Keyword | Description                                     |
| -------------- | ----------------------------------------------- |
| `public`       | accessible from anywhere                        |
| `private`      | accessible only from within the class           |
| `protected`    | accessible from within the class and subclasses |
| `blank`          | accessible from within the class and package    |

Currently, we can access attributes directly from the `App` class.

```java
System.out.println(tony.name);
System.out.println(tony.age);
System.out.println(tony.gender);
System.out.println(tony.isMarried);
```

Generally, we should keep all fields private because we do not want other classes to be able to access and modify the values directly.

```java
private String name;
private int age;
private String gender;
private boolean isMarried;
```

The moment we do this though, we will get an error in the `App` class because we can no longer access the attributes directly. This is because the attributes are now set to `private`.

How do we access them then? This is where **accessor** and **mutator** methods come in. These are more commonly known as **getters** and **setters** respectively. These methods are used to access and modify the values of the attributes.

A getter method is used to retrieve the value of an attribute. It is a public method that returns the value of the attribute.

```java
public String getName() {
  return name;
}
```

A setter method is used to change the value of an attribute. It is a public method that takes in a parameter and sets the value of the attribute.

```java
public void setName(String name) {
  this.name = name;
}
```

The naming convention for getters and setters is to prefix the attribute name with `get` and `set` respectively, except for boolean attributes. For boolean attributes, the prefix should be `is` instead of `get` e.g. `isMarried`.

In VSCode, we do not have to type these out but can instead generate them by right-clicking, "Source Action", "Generate Getters and Setters".

```java
public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public int getAge() {
  return age;
}

public void setAge(int age) {
  this.age = age;
}

public String getGender() {
  return gender;
}

public void setGender(String gender) {
  this.gender = gender;
}

public boolean isMarried() {
  return isMarried;
}

public void setMarried(boolean isMarried) {
  this.isMarried = isMarried;
}
```

Now, we can access the attributes using these methods.

```java
System.out.println(tony.getName());
System.out.println(tony.getAge());
System.out.println(tony.getGender());
System.out.println(tony.isMarried());
```

We could also set the values using the setter methods.

```java
tony.setName("Tony Stuck");
tony.setAge(25);
```

It is good practice to keep fields private and provide getters and setters to access and modify the values because it allows us to control how the values are accessed and modified.

This is one of the principles of Object Oriented Programming (OOP) - **Encapsulation**.

In OOP, encapsulation means two things:

1. The bundling of methods and attributes on a single object
2. The hiding of the internal representation, or state, of an object from the outside

The methods are usually public because we want to give users a way to interact with the object. The attributes are usually private because we do not want users to be able to access and modify the values directly.

This encapsulates our class which allows us to provide a public interface that never changes while the implementation details can change at any time without affecting the users.

For example, we might change the implementation of the `greet` method include the marital status. Or we might change the implementation of the `isMarried` attribute to return a string instead of a boolean.

```java
public void greet() {
  System.out.println("Hello world, I'm " + getName() + " and I'm a " + getAge() + " year old " + getGender() + ".");
  System.out.println(isMarried() ? "I'm married." : "I'm not married.");
}
```

To the users, the interface remains the same regardless of the changes. They can still call the `greet` method and get the same result.