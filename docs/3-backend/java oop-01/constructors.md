## Lesson Objectives

- Understand the role of Constructors and explain its function in initializing objects in Java.

- Write and implement both default and parameterized constructors in Java classes.

- Understand Constructor Overloading and learn how to overload constructors by creating multiple constructors with different parameter lists in a class.

- Understand the Role of the this Keyword in constructors and apply the this keyword to differentiate    between instance variables and constructor.
##  Constructors

A **constructor** is a special method that is called when an object is instantiated i.e. when the `new` keyword is used. The purpose of a constructor is to initialize values for the newly created object.

A constructor:

- is defined using the same syntax as a method
- does not have a return type.
- name must be the same as the class name.

Currently, we do not have a constructor defined in our `Person` class. But Java provides a default constructor that does not take in any parameters - this is called the **no-argument constructor**. Since there are no arguments, this constructor will initialize the attributes to their default values.

This is why we could instantiate the `Person` object without any errors. However, the attributes are not initialized to the values that we want.

We could also explicitly declare the no-argument constructor in our class.

```java
public class Person {

  // Explicitly declaring the no-argument constructor
  public Person() {

  }

}
```

Let's add a **parameterized constructor** to our `Person` class.

This can be done by right-clicking in VSCode, "Source Action", "Generate Constructors".

```java
public Person(String name, int age, String gender, boolean isMarried) {
  this.name = name;
  this.age = age;
  this.gender = gender;
  this.isMarried = isMarried;
}
```

With the constructor defined, we can now instantiate the `Person` object with the values that we want.

```java
public class App {
  public static void main(String[] args) {
    Person tony = new Person("Tony Stark", 35, "male", false);

    tony.greet();
    tony.eat("burger");

  }
}
```

Note that if an explicit constructor is defined, there will no longer be a default constructor implicitly defined.

Remove the no-argument constructor and try to instantiate the `Person` object again without any arguments. What happens?

### What is `this`?

The `this` keyword is used to refer to the current instance in a method or constructor.

In the `Person` class, we now have a constructor that takes in 4 parameters.

```java
public Person(String name, int age, String gender, boolean isMarried)
```

However, the parameters have the same name as the attributes. How does Java know e.g., whether the `name` variable refers to the argument or the attribute?

This is where the `this` keyword comes in. The `this` keyword refers to the current instance of the object. It can be used to refer to the attributes and methods of the object.

Using a constructor with arguments, we can initialize the attributes of the object with the values passed in.

### Constructor Overloading

We can define multiple constructors for a class. This is called **constructor overloading**.

In our previous lesson, we learned method overloading. The constructor is also a method, so we can apply the same concept here.

For example, we can define a constructor to take in two parameters and set default values for the other attributes.

```java
public Person(String name, int age) {
  this.name = name;
  this.age = age;
  this.gender = "Unknown";
  this.isMarried = false;
}
```

We could improve this further by calling the all-argument constructor from the two-argument constructor. Remember that our constructor is a method, so we can call it from another method.

```java
public Person(String name, int age) {
  this(name, age, "Unknown", false);
}
```

Test it out by instantiating the `Person` object with two arguments.

```java
Person bruce = new Person("Bruce Banner", 40);

bruce.greet();
bruce.eat("popcorn");
```

### Copy Constructor

A **copy constructor** is a constructor that takes in an object of the same class and copies its values to the new object. This is actually just another overloaded constructor.

```java
public Person(Person person) {
  this.name = person.name;
  this.age = person.age;
  this.gender = person.gender;
  this.isMarried = person.isMarried;
}
```

Or we can call the all-argument constructor.

```java
public Person(Person person) {
  this(person.name, person.age, person.gender, person.isMarried);
}
```

Then to invoke the copy constructor, we pass in an object of the same class.

```java
Person bruceClone = new Person(bruce);
```
