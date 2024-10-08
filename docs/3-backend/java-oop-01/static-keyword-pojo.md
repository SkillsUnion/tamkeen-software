# Static Keyword & POJOs in Java

## Lesson Objectives

-Define the static keyword and explain its role in Java for variables, methods, and blocks.

-Declare and access static variables and methods in Java classes.

-Learn how to override toString() method

-Understand a POJO (Plain Old Java Object) and explain its role in simplifying object-oriented programming in Java.

##  Introduction

In the previous lesson we used the `static` keyword on methods. We can also use it on attributes.

Just like methods, `static` attributes are accessed using the class name while instance attributes are accessed using the object name.

Let's define a `static` attribute.

```java
public static final String scientificName = "Homo Sapien";
```

The `final` keyword is used to restrict modification of the variable.

And access them in our `main` method.

```java
// Printing out a static variable
System.out.println(Person.scientificName);
```

Let's add another static variable to keep track of the number of Person objects instantiated.

```java
private static int personCount = 0;
```

And a corresponding static method to get the value.

```java
public static int getPersonCount() {
  return personCount;
}
```

Now, we will increment it every time a new Person is instantiated.

```java
public Person(String name, int age, String gender, boolean isMarried) {
  this.name = name;
  this.age = age;
  this.gender = gender;
  this.isMarried = isMarried;
  personCount++;
}
```

We can now instantiate a few more persons and use the static method to display the count.

```java
Person peter = new Person("Peter Parker", 20, "male", false);
Person wanda = new Person("Wanda Maximoff", 25, "female", true);

System.out.println(Person.getPersonCount());

// Should not use instance to call a static method
System.out.println(peter.getPersonCount());
```

It is usually not recommended to call a static member with an instance variable instead of the class name. This is because it can be confusing and make the code less readable.

Static members are associated with the class, not with any particular instance of the class. Therefore, it is more consistent to access them using the class name. This also makes it clear that the member is static, which can be important for understanding the code.

---

##  `toString` and `@Override`

By default, if we try to print out an object, we will get the class name and the hashcode.

```java
System.out.println(tony);
```

We can override the `toString` method to return a string representation of the object. With VSCode, we can generate the `toString` method by right-clicking, "Source Action", "Generate toString()".

```java
@Override
public String toString() {
  return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", isMarried=" + isMarried + "]";
}
```

The `@Override` annotation is used to indicate that the method is overriding a method from the superclass. This is optional but it is good practice to include it. We will learn more about annotations in later lessons.

---

## POJO in Java

A Plain Old Java Object (POJO) is a simple object used to represent data in a Java program.

We define it using the `class` keyword with a set of attributes and corresponding getters and setters.

Take for example, an expense object.

```java
public class Expense {
  private String name;
  private double amount;

  public Expense() {

  }

  public Expense(String name, double amount) {
    this.name = name;
    this.amount = amount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
}
```

We could then create an `ArrayList` of expenses.

```java
ArrayList<Expense> expenses = new ArrayList<>();

expenses.add(new Expense("Food", 100));
expenses.add(new Expense("Transport", 500));
System.out.println(expenses);
```

But we will not be able to see the data. This is because the `toString` method is not overridden in the `Expense` class. So we can either override the `toString` method or loop through the `ArrayList` and print out the values.

By using a POJO, we can easily create objects to represent our data instead of using arrays or ArrayLists of strings or numbers. We could also use it to pass data between components or store data in a database.

---
