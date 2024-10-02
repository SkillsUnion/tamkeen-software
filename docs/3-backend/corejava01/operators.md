# Operators 

## Lesson Objectives
- Understand what operators are and their purpose in performing various operations on variables and values.

- Learn about the four category of operators (arithmetic, assignment, comparison, logical) and write programs to demonstrate the usage.

- Understand Operator Precedence and Associativity


## Introduction
Operators are symbols that perform operations on variables and values.

The basic types of operators:

- Arithmetic
- Unary
- Assignment
- Relational
- Logical / Conditional

You can create a LearnOperators.java file and code along as we go through these operators.
```java
public class LearnOperators {
  public static void main(String[] args) {

    int a = 10;
    int b = 20;
  }

}
```
## Arithmetic Operators:

| Operator              | Description                                             | Example |
| --------------------- | ------------------------------------------------------- | --------------- |
| `+`                   | Addition                                                | x+y             |
| `-`                   |Subtraction                                              | x-y             |
| `*`                   | Multiplication                                          | x*y             |
| `/`                   | Division                                                | x/y             |
| `%`                   | Remainder                                               | x%y             |


### Notes

 `+` is also used to concatenate strings e.g. "Hello" + "World"
  becomes "HelloWorld".
```java
System.out.println("a + b = " + (a + b));
System.out.println("a - b = " + (a - b));
System.out.println("a * b = " + (a * b));
System.out.println("a / b = " + (a / b));
System.out.println("b % a = " + (b % a));
```

## Unary Operators

| Operator               | Description                                             | Example |
| ---------------------  | ------------------------------------------------------- | --------------- |
| `+`                    | Plus                                                    | +x              |
| `-`                    | Minus                                                   | -x              |
| `++`                   | Increment                                               | ++x             |
| `--`                   | Decrement                                               | --x             |
| `!`                    | Not                                                     | !x              |

```java

int unaryPlus = +10;
int unaryMinus = -10;
System.out.println("unaryPlus: " + unaryPlus);
System.out.println("unaryMinus: " + unaryMinus);

int preIncrement = ++unaryPlus;
System.out.println("preIncrement: " + preIncrement);
int preDecrement = --unaryMinus;
System.out.println("preDecrement: " + preDecrement);

int postIncrement = unaryPlus++;
System.out.println("postIncrement: " + postIncrement);

int postDecrement = unaryMinus--;
System.out.println("postDecrement: " + postDecrement);

boolean isTrue = true;
System.out.println("isTrue: " + isTrue);
System.out.println("!isTrue: " + !isTrue);
```

Observe the output of the above code. What is the difference between pre and post increment/decrement?

## Pre vs Post Increment/Decrement Operators:

Pre-increment/decrement operators increment/decrement the value of the variable before returning the value.

Post-increment/decrement operators increment/decrement the value of the variable after returning the value.
```java
int x = 10;
int y = 10;

System.out.println("x: " + x);
System.out.println("y: " + y);

System.out.println("x++: " + x++);
System.out.println("++y: " + ++y);

System.out.println("x: " + x);
System.out.println("y: " + y);
```

## Assignment and Compound Assignment Operators :

* Assignment =
* Compound Assignment:

| Operator               | Description                                             | Example |
| :--------------------- | :-------------------------------------------------------| :---------------|
| `+=`                   | Addition                                                | x+=y;           |
| `-=`                   | Subtraction                                             | x-=y;           |
| `*=`                   | Multiplication                                          | x*=y;           |
| `\=`                   | Division                                                | x/=y            |
| `%=`                   | Remainer                                                | x%=y            |

### Notes:

- Compound assignment operators are shorthand for performing an operation and assigning the result to the same variable. For example, x += y is the same as x = x + y.
- Compound operators cannot be used to declare variables. For example, int x += 5 is invalid.
```java
int compoundAdd = 8;
compoundAdd += 10;
System.out.println("compoundAdd: " + compoundAdd);

int compoundSub = 10;
compoundSub -= 5;
System.out.println("compoundSub: " + compoundSub);
System.out.println();
```
## Relational Operators

| Operator               | Description                                             | Example |
| :--------------------- | :-------------------------------------------------------| :--------------- |
| `==`                   | `Equals`                                                |`x==y;`           |
| `!=`                   | `Not Equal`                                             |`x!=y;`           |
| `>`                    | `Greater`                                               |`x>y;`            |
| `>=`                   | `Greater or Equal`                                      |`x>=y`            |
| `<`                    | `Less Than`                                             |`x<y`             |
| `<=`                   | `Less Than Or Equal`                                    |`x<=y`            |

```java
System.out.println("a == b: " + (a == b));
System.out.println("a != b: " + (a != b));
System.out.println("a > b: " + (a > b));
System.out.println("a >= b: " + (a >= b));
System.out.println("a < b: " + (a < b));
System.out.println("a <= b: " + (a <= b));
```
## Logical/Conditional Operators

| Operator               | Description                                             | Example |
| :--------------------- | :-------------------------------------------------------| :---------------  |
| `&&`                   |  AND                                                    |  x && y           |
| `\|\|`                 |  OR                                                     |  x || y           |
| `!`                    |  NOT                                                    |  !x               |
| `? :`                  | Ternary                                                 |  x? y : z         |

```java
boolean value1 = true;
boolean value2 = false;
System.out.println("value1 && value2: " + (value1 && value2));
System.out.println("value1 || value2: " + (value1 || value2));
System.out.println("!value1: " + (!value1));
System.out.println(a > b ? "a is larger" : "b is larger");
```

## Type Comparison Operator

|  Operator  |    Example     |
| :--------: | :------------: |
| instanceof | x instanceof y |

You can use the `instanceof` operator to check whether an object is an instance of a specific class or an instance of a subclass of that class.

```java
String name = "John";
System.out.println("name is String?" + name instanceof String);
```

## Operator Precedence

Operator precedence determines the order in which operators are evaluated. Operators with higher precedence are evaluated first.

| Operator | Precedence |
| :------: | :--------: |
|    ()    |     15     |
|    !     |     13     |
|    \*    |     12     |
|    /     |     12     |
|    %     |     12     |
|    +     |     11     |
|    -     |     11     |

```java
int order1 = 10 + 5 * 2;
int order2 = (10 + 5) * 2;
System.out.println("10 + 5 * 2: " + order1);
System.out.println("(10 + 5) * 2: " + order2);
```

Complete Precedence Table:
https://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html










