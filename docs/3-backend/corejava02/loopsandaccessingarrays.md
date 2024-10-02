Loops and Accessing arrays

Create a `LearnLoops.java` file and code along.

To loop over an `Array` or `ArrayList`, we can use a `for` loop.

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

### 👨‍💻 Activity

Create a new file called `ArrayActivity.java`.

Write a program to do the following:

- Allow a user to enter a list of suspect names
- Print out the list of suspect names
- Allow the user to enter the suspects with alibis
- Print out the updated list of suspects
- Find the suspect with the longest name
- Print out the suspect with the longest name

Hints:

- Use `ArrayLists` to store the suspect names and suspects with alibi names
- Use `while` loops to allow the user to enter the suspect names and suspects with alibi names
- Use `contains()` to check for repeats or an invalid suspect name
- Use `removeAll` to remove the suspects with alibis from the list of suspects
- Use a `for`/enhanced `for` loop to find the longest name (`String` length can be found using `.length()`)

---

## Part 4 - Lambda Expressions for ArrayLists (Optional)

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