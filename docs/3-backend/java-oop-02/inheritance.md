# Learning Objective

- Define inheritance in object-oriented programming.

- Understand the "is-a" relationship between parent (superclass) and child (subclass) classes.

- Identify the extends keyword and how it is used to inherit from a superclass.

- Understand the access levels (private, protected, public) in the context of inheritance.

- Use the super keyword to call superclass constructors and methods.

##  Inheritance

### What is Inheritance?

Inheritance is organizing code into a parent-child hierarchy so that the child can inherit the properties and methods of the parent.

Take for example, a `Person` class. It is the base class of a hierarchy of classes for other child classes such as `Student`, `Teacher`, `Employee`, `Janitor` etc.

### Creating a child class

Let's create a `Student` class that inherits from the `Person` class. To do that, we use the `extends` keyword.

By inheriting from the `Person` class, the `Student` class will inherit all the fields and methods of the `Person` class. The `Person` class is also known as the **parent** class or **super** class. The `Student` class is also known as the **child** class or **sub** class.

In addition, we want to make `Student` different by declaring fields and methods specific to it.

```java
public class Student extends Person {
  private int studentId;
  private String course;
  private int yearEnrolled;
  private ArrayList<Double> grades;

  public Student(int studentId, String course, int yearEnrolled) {
    this.studentId = studentId;
    this.course = course;
    this.yearEnrolled = yearEnrolled;
    this.grades = new ArrayList<Double>();
  }


  // add getters and setters

  // add methods specific to Student
  public void addGrade(double grade) {
    this.grades.add(grade);
  }

  public double getAverageGrade() {
    double sum = 0;
    for (double grade : this.grades) {
      sum += grade;
    }
    return sum / this.grades.size();
  }
}
```

Note that a class may only extend from one parent class as Java does not support multiple inheritance.

```java
// ❌ This is not allowed
public class Student extends Person, Human {
  // ...
}
```

Let's modify our `greet()` method to show the class calling the method.

```java
public void greet() {
  System.out.println("👋 Hello, my name is " + this.name + " and I am a " + (2023 - this.birthYear) + " year old " + this.getClass().getSimpleName().toLowerCase() + ".");
}
```

Now we can test our `Student` class.

```java
public class App {
  public static void main(String[] args) {
    // Instantiating a Student object
    Student student = new Student(1, "Computer Science", 2022);

    // Calling methods from the Person (Parent) class
    student.setName("Tony");
    student.setBirthYear(1995);
    student.greet();
    student.doWork();

    // Calling methods from the Student (Child) class
    System.out.println("I am studying " + student.getCourse());
    student.addGrade(80);
    student.addGrade(90);
    System.out.println("My average grade is " + student.getAverageGrade());
  }
}
```

The `Student` instance has access to all the `public` methods of the `Person` class.

Currently, we have to manually initialize the `name` and `age` fields using the setter methods because they are in the `Person` class. We can improve this by calling a constructor that accepts those values as well.

But how do we initialize these values since the `Student` class does not have these fields?

### `super` keyword

The `super` keyword is like `this` but it refers to the parent class. It can be used to call the parent class constructor. Recall that the parent class is also known as the **super** class, hence that is what calling `super()` does.

Currently we are not using `super` yet but the `Student` class has default values for the `name` and `age` fields. This is because Java automatically called `super()` for us implicitly.

```java
public Student(int studentId, String course, int yearEnrolled) {
  super(); // This calls Person()
  this.studentId = studentId;
  this.course = course;
  this.yearEnrolled = yearEnrolled;
  this.grades = new ArrayList<Double>();
}
```

`super()` calls the no-argument constructor of the parent class when there are no arguments passed in. If we want to call a different constructor, we can do so by passing in the arguments. In this case we want to call the `Person` constructor that accepts `name` and `birthYear`.

Our student constructor will also take in `name` and `birthYear` as arguments. The `name` and `birthYear` will be passed to the `Person` constructor using `super(name, birthYear)`.

```java
public Student(String name, int birthYear, int studentId, String course, int yearEnrolled) {
  super(name, birthYear); // This calls Person(String name, int birthYear)
  this.studentId = studentId;
  this.course = course;
  this.yearEnrolled = yearEnrolled;
  this.grades = new ArrayList<Double>();
}
```

Note that we cannot call `super()` and `this()` in the same constructor. This is because both `super()` or `this()` must be the first statement in the constructor.

```java
public Student(String name, int birthYear, int studentId, String course, int yearEnrolled) {
  super(name, age); // This calls Person(String name, int age)
  this(studentId, course, yearEnrolled); // ❌ This is not allowed
}
```

Back to our `main`, we can now pass in the `name` and `birthYear` to the `Student` constructor.

```java
Student student = new Student("Tony", 1995, 1, "Computer Science", 2022);

// Calling methods from the Person (Parent) class
// student.setName("Tony");
// student.setBirthYear(1995);
student.greet();
student.doWork();

// Calling methods from the Student (Child) class
System.out.println("I am studying " + student.getCourse());
student.addGrade(80);
student.addGrade(90);
System.out.println("My average grade is " + student.getAverageGrade());
```

### The `protected` access modifier

In an earlier lesson we had mentioned about the `protected` access modifier. The `protected` access modifier allows the field to be accessed by the child class.

Let's add another method to `Student`.

```java
public void attendClass() {
  System.out.println(this.name + " is attending class.");
}
```

Notice that we cannot access it directly in the `Student` class. This is because the `name` field is declared in the `Person` class. We can only access it using the `getName()` method.

```java
public void attendClass() {
  System.out.println(this.getName() + " is attending class.");
}
```

If we want to access the `name` field directly, we can use the `protected` access modifier. The `protected` access modifier allows the field to be accessed by the child class.

```java
protected String name;
```