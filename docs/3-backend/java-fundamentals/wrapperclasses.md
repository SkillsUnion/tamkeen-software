##  Wrapper Classes, Boxing and Unboxing

## Lesson Objectives

1. Define and explain wrapper classes in Java and their importance in converting primitive data types into objects.

2. Understand the concept of boxing (converting a primitive type to its corresponding wrapper class object).

3. Understand the concept of unboxing (converting a wrapper class object back to its corresponding primitive type).

### Wrapper Classes

Recall Java has 8 primitive data types. For each of those types, there is a corresponding wrapper class (classes will be covered in more detail in a later lesson).

<img src="wrapperclasses.png" width="450" height="450">

In Java, wrapper classes are needed to convert primitive data types (such as int, float, char, and boolean) into objects. This is essential because Java’s collections framework (like ArrayList which we will see in subsequent lessons) only works with objects, not primitives. Wrapper classes, such as Integer, Double, Character, and Boolean, "wrap" these primitives in object form, enabling their use in collections, generics, and with features like Java’s automatic boxing and unboxing. Additionally, wrapper classes provide utility methods for converting strings to numeric types, comparing values, and handling constants like MAX_VALUE and MIN_VALUE.

For example, as you saw earlier, the `Integer` class provide a useful method to convert a `String` to an `Integer`.

```java
int num = Integer.parseInt("10");
```

You can also check the maximum and minimum values of an `Integer`.

```java
System.out.println(Integer.MAX_VALUE);
System.out.println(Integer.MIN_VALUE);
```

We can declare an `Integer` object like this instead using the primitive data type:

```java
Integer num = 10;
```

But as a rule of thumb, it is better to use the primitive data type unless you need to use the wrapper class methods.

### Boxing and Unboxing

Boxing is the process of converting a primitive data type to its corresponding wrapper class.

Java does autoboxing, which is the automatic conversion of a primitive data type to its corresponding wrapper class.

```java
Integer boxedNum = 10;
```

Unboxing is the process of converting a wrapper class to its corresponding primitive data type.

Java does auto-unboxing, which is the automatic conversion of a wrapper class to its corresponding primitive data type.

```java
int unboxedNum = boxedNum;
```