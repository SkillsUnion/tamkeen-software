#  Java Basic Concepts

## Learning Objectives

1. Get familiar with the key concepts of Java including class, objects, methods.

2. Identify the syntax for the public static void main(String[] args) method.

3. Learn how to use javac and java commands to compile and run java applications.


## Introduction

Java is a high-level, object-oriented programming language known for its platform independence, meaning Java code can run on any system that has a Java Virtual Machine (JVM). It is widely used for building applications ranging from desktop software to web and mobile applications.

## Class
Class: A blueprint or template that defines the structure and behavior of objects. It contains fields (variables) and methods (functions) that represent the properties and actions of an object.

## Object
An instance of a class. It is a concrete entity created based on the class definition, and it represents a specific element with distinct values for the fields defined in the class.

## Method
 A block of code or a function defined inside a class that performs a specific task or operation. Methods allow objects to interact with their data or perform actions.

In Java, classes, objects, and methods form the core structure of object-oriented programming, making it easier to model real-world entities and their interactions.

## Create a `Main.java` file

In the root folder, create a file named `Main.java`.

The naming convention for a `class` is to use **PascalCase**. This means that the first letter of each word is capitalized.

#### Click here to know more about naming conventions: <a href="https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html" target="_blank">Naming Conventions In Java</a>


##  Define a class `Main`. The class name must be identical to the filename.

```java
public class Main {
  public static void main(String args[]){
    System.out.println("Hello World");
  }
}
```

- `class` is used to define a class.
- `main` is the entry point of all Java projects.
- `System.out.println("Hello World")` will output the value "Hello World" to the console.
- `public` is an access modifier. It means that the class is accessible to all other classes.

---

##  Compile and Run

To compile the file, we use the `javac` command on the java file. This generates a `.class` file of the same name.

Then, we use the `java` command to run the `.class` file. String values can be passed into the `main` method as arguments.

```sh
$ javac Main.java
$ java Main 
```

You may also run the code directly from VSCode using the "Run Java" button.