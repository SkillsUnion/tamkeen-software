# Variables & Data Types

## Lesson Objectives

1. Understand the two categories of data types in Java, primitive and non-primitive.

2. Learn how to correctly use different primitive data types in Java, including  int, float, char, boolean.

3. Declare, initialize, and manipulate variables in a Java program.

4. Understand the concept of type casting (implicit and explicit) in Java.

## Variables

A variable in Java is a container that holds data values during the execution of a program. It acts as a named storage location in memory where a value can be assigned, retrieved, and modified. Each variable has a specific data type, which determines the kind of data it can store (e.g., int for integers, double for decimals, String for text).

```java
public class VariableExample {
    public static void main(String[] args) {
        // Declaring and initializing a variable
        int age = 25;    // 'age' is a variable of type int
        
        // Printing the value of the variable
        System.out.println("Age: " + age);
        
        // Modifying the value of the variable
        age = 30;
        System.out.println("Updated Age: " + age);
    }
}
```

## Data Types
In Java, data types are divided into two main categories: primitive and non-primitive (also known as reference types).These categories are important for understanding how data is stored, manipulated, and used in Java programs. 

### Primitive Data Type:

n Java, primitive data types are the basic data types that represent simple values, not objects. They are predefined by Java, occupy a fixed amount of memory, and are directly stored in memory locations for efficient access. Java has eight primitive data types:

<img src="data_type.png" width="450">


There are 8 primitive data types in Java:

| Whole Number | Decimal | Single Char | Boolean |
| :----------: | :-----: | :---------: | :-----: |
|     byte     |  float  |    char     | boolean |
|    short     | double  |
|     int      |         |
|     long     |         |

Each primitive type is used to store specific kinds of data based on its requirements. For instance, int is typically used for whole numbers, double for decimal numbers, and boolean for true/false values.

###  Create `LearnDataTypes.java`

#### Insert the following code

```java
public class LearnDataTypes{
    public static void main(String[] args) {
        // Integer types
        byte age = 25;
        short year = 2024;
        int population = 1000000;
        long distance = 123456789L;

        // Floating-point types
        float pi = 3.14f;
        double gravity = 9.80665;

        // Character type
        char grade = 'A';

        // Boolean type
        boolean isJavaFun = true;

        // Printing values
        System.out.println("Age (byte): " + age);
        System.out.println("Year (short): " + year);
        System.out.println("Population (int): " + population);
        System.out.println("Distance (long): " + distance);
        System.out.println("Pi (float): " + pi);
        System.out.println("Gravity (double): " + gravity);
        System.out.println("Grade (char): " + grade);
        System.out.println("Is Java fun? (boolean): " + isJavaFun);
    }
}
```
Each variable in this program is declared with a different primitive data type.
The program assigns values to each variable and prints them to demonstrate how each type stores and displays data.
Note that the long value is suffixed with L, and the float value with f, as required by Java syntax to specify these types explicitly.(We will see Numeric Literal Character Suffixes in the later sections.)

### Non-Primitive Data Type:
Non-primitive data types (also called reference types) are more complex types created by the programmer or provided by Java libraries. These include classes, interfaces, arrays, and enums. Unlike primitives, non-primitive types hold references (or addresses) to memory locations where the actual data is stored. Common examples are:

- Strings: Instances of the String class

- Arrays: Collections of values of the same type

- Objects: Instances of classes (e.g., Integer, StringBuilder, ArrayList)

Non-primitive data types offer more functionality and can store complex data structures, making them essential for object-oriented programming in Java.
**We will learn about non-primititive data types in subsequent lessons.**



## Casting

Casting is the process of converting a value from one data type to another.

Casting can be done **explicitly** or **implicitly**.

**Explicit casting** is done by the developer using the `()` operator.

```java
int a = 10;
double b = 1.5;
int result = a + (int) b;
```

**Implicit casting** is done automatically by the compiler.

```java
int a = 10;
double b = 1.5;
double result = a + b;
```

This is possible because the converted value (`int`) fits within the range of the new data type (`double`).

In Java, there are two types of casting:

- **Widening Casting** (automatically) - converting a smaller type to a larger type size.
- **Narrowing Casting** (manually) - converting a larger type to a smaller size type.

```java
// Widening Casting
int myInt = 9;
double myDouble = myInt; // Automatic casting: int to double

System.out.println(myInt);      // Outputs 9
System.out.println(myDouble);   // Outputs 9.0

// Narrowing Casting
double myDouble = 9.78;
int myInt = (int) myDouble; // Manual casting: double to int

System.out.println(myDouble);   // Outputs 9.78
System.out.println(myInt);      // Outputs 9
```

### Numeric Literal Character Suffixes

Numeric literal character suffixes are used to indicate the type of the numeric literal.

```java
// L suffix for long
long longNum = 10000000000L;

// F suffix for float
float floatNum = 1.5F;

// D suffix for double
double doubleNum = 1.5D;
```

Why do we need to specify the type of the numeric literal?

- Without the suffix, the compiler will generally treat a whole number as an `int`, and a decimal number as a `double`.

```java
// Compiler treats 1.5 as a double
float f = 1.5; // Error: incompatible types: possible lossy conversion from double to float

// For double, the suffix is optional
double d = 1.5; // No error
```

### Converting from `String` to `Integer`

In order to convert a `String` to an `Integer` one of the ways is using `Integer.parseInt()`. This is for converting a `String` to an `Integer`. It uses the `parseInt()` method from the `Integer` class. This is not the same as casting, which uses the `()` operator.

###  Create `ConvertToInt.java`

#### Insert the following code


```java
public class ConvertToInt {
    public static void main(String args[]){
        int num1 = 10;
        // The String needs to be converted into an Integer
        int num2 = Integer.parseInt(args[0]);
        System.out.println(num1 + num2);
    }
}
```
 Try replacing `Integer.parseInt(args[0])` with just `args[0]`. What happens and why?

You cannot perform `11 + "1"`. This expression adds a `String` value of `1` to `int` value of `11`, which would not work. Therefore, we had to perform `Integer.parseInt()` to parse a `String` to an `Integer`.