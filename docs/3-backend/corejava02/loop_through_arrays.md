# Loop through an Array and ArrayList

## Lesson Objectives

- Learn how to iterate over an Array and ArrayList using for loop with index-based access.

- Implement the enhanced for-each loop for iterating through an ArrayList

## Introduction

To loop over an `Array` or `ArrayList`, we can use a `for` loop and use the length property to specify how many times the loop should run.

### Create a `LearnLoops.java` file and code along.

```java
int[] scoresList = { 74, 32, 82, 45, 56 };

// Looping over an Array
for (int i = 0; i < scoresList.length; i++) {
    System.out.println(scoresList[i]);
}

ArrayList<String> heroes = new ArrayList<>(
      Arrays.asList("Ironman", "Captain America", "Thor", "Hulk", "Black Widow", "Hawkeye"));


// Looping over an ArrayList
for (int i = 0; i < heroes.size(); i++) {
    System.out.println(heroes.get(i));
}
```

## Enhanced or **for-each** loop.

We can also use an enhanced for loop, which is also known as a **for-each** loop.

This is a special type of for loop that is used to iterate over a collection of elements.

The advantage of an enhanced for loop is that it is more concise and easier to read.

```java
// Looping over an Array
for (int score : scoresList) {
    System.out.println(score);
}

// Looping over an ArrayList
for (String hero : heroes) {
    System.out.println(hero);
}
```

Note that we cannot use an enhanced for loop to update elements.

```java
for (String hero : heroes) {
    hero = "Thanos"; // ❌ ERROR
}
```
---

### Lambda Expressions for ArrayLists (Optional)

Lambda expressions was introduced in Java 8. They are used to represent a block of code that can be passed around.

### Syntax

A lambda expression has the following syntax:

```java
// Single parameter
(parameter) -> expression

// No parameters
() -> expression

// Multiple parameters
(parameter1, parameter2) -> expression

// Multiple statements
(parameters) -> { statements }
```

Example with an `ArrayList`:

```java
ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

// Display all the numbers
numbers.forEach((number) -> System.out.println(number));

// Display all the even numbers
numbers.forEach((number) -> {
    if (number % 2 == 0) {
        System.out.println(number);
    }
});

// Remove all the odd numbers
numbers.removeIf((number) -> number % 2 != 0);
```