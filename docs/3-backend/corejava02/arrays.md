# Arrays

## Lesson Objectives

- Learn how to Declare, initialize, and access arrays in Java

- Perform basic operations on arrays, such as sorting and searching

- Learn how to copy arrays using utility methods 

## Introduction

The array is a data structure that allows you to store a sequence of values, all of the same type.

Arrays can store any of the 8 primitive types (`int`, `char`, etc.) as well as object references (`String`, `SomeCustomClass` etc.)

#### Create `LearnArrays.java` and code along.

### Declaring an Array

```java
// Declare an array of integers
int[] ageList;

// Declare an array of Strings
String[] namesList;

// Alternate syntax - less common
String namesList[];
```

### Instantiating an Array

One way to instantiate a new array is to use the `new` keyword. The number in the brackets is the size of the array.

```java
// Instantiate an array of 5 integers
int[] scoresList = new int[5];
Integer[] scoresList2 = new Integer[5];

// Instantiate an array of 10 Strings
String[] studentsList = new String[10];
```

### Initializing an Array

If we already know the values for our array, we can initialize it.

```java
String[] favMovies = new String[] {"Avengers","Infinity War", "Iron Man"};
```

The elements are separated by commas and enclosed in curly braces `{}`. Because the size of the array is determined by the number of elements, we do not need to specify the size in the brackets.

We can further simplify this by omitting the `new String[]` part if it is in a declaration statement.

```java
String[] favMovies = {"Avengers","Infinity War", "Iron Man"};
```

Note that this only works in a declaration statement.

If we need to assign values to an array that has already been declared, we must use `new String[]`.

```java
String[] favMovies;

favMovies = {"Avengers","Infinity War", "Iron Man"}; // ❌ ERROR

favMovies = new String[] {"Avengers","Infinity War", "Iron Man"}; // ✅ OK
```

### Accessing Elements

We can access elements in an array using the index. The index starts at 0 and ends at the size of the array minus 1.

```java
System.out.println(favMovies[0]); // Avengers
System.out.println(favMovies[1]); // Infinity War
System.out.println(favMovies[2]); // Iron Man
```

### Changing Elements

We can change the value of an element in an array by assigning a new value to it.

```java
favMovies[0] = "Endgame";
System.out.println(favMovies[0]); // Endgame
```

### Array Length

We can get the length of an array using the `length` property.

```java
System.out.println(favMovies.length); // 3
```

Note that an array's length is fixed. We cannot change it once it has been instantiated.

```java
favMovies.length = 5; // ❌ ERROR
favMovie[3] = "Captain America"; // ❌ ERROR
```

We cannot change the type of an array once it has been instantiated. All elements also have to be of the same type.

```java
favMovies = new int[5]; // ❌ ERROR
favMovies[0] = 1; // ❌ ERROR
```

Let us try to print out an array.

```java
System.out.println(favMovies); // [Ljava.lang.String;@39a054a5
System.out.println(scoresList); // [I@6d06d69c
```

### `java.util.Arrays`

Java's array type is very basic and does not provide useful methods. As you saw, what we can do is just to check the property length.

We were not able to print the array directly using `System.out.println(favMovies)`. Instead the output was something like `[I@6d06d69c`. This is actually the class name and hashcode of the array object.

Java provides a utility class called `java.util.Arrays` that contains useful methods for working with arrays.

We can import this class at the top of the file or use VSCode to import it.

```java
import java.util.Arrays;
```

We can then print the array using `Arrays.toString()`.

```java
System.out.println(Arrays.toString(scoresList)); // [0, 0, 0, 0, 0]

System.out.println(Arrays.toString(scoresList2)); // [null, null, null, null, null]
```

#### Note: Java initializes the array with default values. For primitive types, the default value is `0`. For object references, the default value is `null`.


### More utils - `sort`, `fill`, `copyOf`

We can sort an array using `Arrays.sort()`.

```java
scoresList = new int[] { 7, 3, 8, 4, 5 };

System.out.println("Before sort : " + Arrays.toString(scoresList));
Arrays.sort(scoresList);
System.out.println("After sort : " + Arrays.toString(scoresList));
```

We can fill an array with a value using `Arrays.fill()`.

```java
Arrays.fill(scoresList, 100);
System.out.println("After fill : " + Arrays.toString(scoresList)); // [100, 100, 100, 100, 100]
```

As you might have observed, these methods mutate the array. This means that the original array is changed, which might not be what we want.

We can create a copy of an array using `Arrays.copyOf()`.

This method takes in the array to copy and the length of the new array.

```java
String[] heroes = { "Ironman", "Captain America", "Hawkeye", "Hulk", "Black Widow", "Thor" };
System.out.println(Arrays.toString(heroes));

// Full Copy
String[] heroesCopy = Arrays.copyOf(heroes, heroes.length);
System.out.println("heroesCopy = " + Arrays.toString(heroesCopy));

// Partial Copy
String[] heroesPartialCopy = Arrays.copyOf(heroes, 3);
System.out.println("heroesPartialCopy = " + Arrays.toString(heroesPartialCopy));

// Copy and extend the array
String[] heroesExtendedCopy = Arrays.copyOf(heroes, heroes.length + 3);
System.out.println("heroesExtendedCopy = " + Arrays.toString(heroesExtendedCopy));
```

### Binary Search

We can search for an element in an array using `Arrays.binarySearch()`. This method returns the index of the element if it is found, or a negative number if it is not found. Note that the array **must be sorted** before we can use this method.

```java
// Sort
Arrays.sort(heroes);
System.out.println("Sorted " + Arrays.toString(heroes));

// Search
System.out.println("Search for Hulk " + Arrays.binarySearch(heroes, "Hulk"));
System.out.println("Search for Ironman " + Arrays.binarySearch(heroes, "Ironman"));
```

### Comparing Arrays

We can compare two arrays using `Arrays.equals()`. This method returns `true` if the arrays are equal, or `false` if they are not.

```java
int[] arr1 = {1, 2, 3};
int[] arr2 = {1, 2, 3};

System.out.println("arr1 == arr2 " + (arr1 == arr2)); // false
System.out.println("Array.equals(arr1, arr2) " + Arrays.equals(arr1, arr2)); // true
```

Just like `String`, we should not use `==` to compare arrays. This will only compare the references, not the contents of the arrays.

```java
arr1 == arr2; // false
```

---

