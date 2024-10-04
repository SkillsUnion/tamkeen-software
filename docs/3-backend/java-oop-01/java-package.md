## Java Packages 

## Lesson Objective

- Understand how to organize Java classes and interfaces using packages.

- Learn aabout Java's built-in and User Defined Packages

## Introduction

A package is a collection of related classes and interfaces. You can think of packages as being similar to different folders on your computer.

### Why use packages?

Packages help us to organize our code. It also helps to prevent naming conflicts. For example, if we have two classes with the same name, we can place them in different packages to avoid naming conflicts.

There are two types of packages in Java: **built-in packages** and **user-defined packages**.

### Built-in packages

There are built-in packages in Java such as `java.lang`, `java.util`, etc. For example, the `java.util` package contains the `Scanner` and `ArrayList` classes. Hence, when we needed to use the `ArrayList` class, we had to import the `java.util` package.

```java
import java.util.ArrayList;
```

### User-defined packages

We can also create our own packages to organize our code.

The package declaration should be the first line of code in a Java source file. It is declared using the `package` keyword followed by the package name. For example:

```java
package mypackage;
```

The package name should be a unique identifier. It should match the directory structure where the package is stored i.e. if the package is stored in the directory `mypackage`, then the package name should be `mypackage`.

It is common to use the reverse domain name of the organization to name the package. For example, if the organization's domain name is `companyname.com`, then the package name should be `com.companyname`. In this case, the folder structure should be `com/companyname`.

The naming convention for packages is to use all lowercase letters. If the package name contains multiple words, we can use underscores to separate the words. For example, `com.companyname.project_name` is a valid package name.

Create a new folder called `mypackage` and adding a new file called `HelloWorld.java` with the following code:

```java
package mypackage;

public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello World from mypackage");
  }
}
```

To compile and run the code, we can use the "Run Java" button in VS Code.

Alternatively, we can compile and run it in the terminal:

```bash
javac HelloWorld.java
```

To run the file, we need to be in the parent directory of the package. In this case, we need to be in the parent directory of `mypackage` and we need to specify the fully qualified name of the class:

```bash
java mypackage.HelloWorld
```

Try removing the line `package mypackage;` and see what happens when you try to compile the code.

### Importing packages

To use a class or interface from a package, we need to import the package. The syntax for importing a package is:

```java
import package_name.class_name;
```

We can also import all the classes and interfaces in a package using the `*` wildcard. For example:

```java
import package_name.*;
```

Create a MyApp.java in the root folder with the following code:

```java
public class MyApp {
  public static void main(String[] args) {
    System.out.println("My App");
  }
}
```

Inside `mypackage` folder, let's add a new class called `House.java` (classes will be covered in more detail in the next lesson).

Since this file is in `mypackage` folder, we need to specify the package name at the top of the file.

```java
package mypackage;

public class House {
  // no code is needed here for now
}
```

Now we can use the `House` class in the `MyApp` class by importing it.

```java
import mypackage.House;

public class MyApp {
  public static void main(String[] args) {
    System.out.println("My App");
    House myHouse = new House();
    System.out.println(myHouse);
  }
}
```

Try removing the import statement and see what happens when you try to compile the code.
