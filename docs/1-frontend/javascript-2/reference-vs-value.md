# Reference vs Value

## Learning Objectives

1. Difference between mutable and immutable data types
2. Mutable data types are passed by reference (address) and immutable data types passed by value
3. How to make an independent copy of a mutable data type

## Introduction

What will `array2.length` return in the final line?

```javascript
var array1 = [1, 2, 3];
var array2 = array1;
array1.pop(); // Remove the last element from array1
console.log(array2.length);
```

`array2.length` above returns 2. We assigned `array2` to `array1` and arrays are mutable data types, hence `array2` references the same data as `array1`. Mutable data types are passed by reference and not by value.

If we wanted to copy `array1` into an independent `array2` variable, we could run the following code instead.

```javascript
var array1 = [1, 2, 3];
// "..." syntax in front of an array is called the spread operator
// The spread operator copies all elements in an array
// The surrounding [] encapsulates copies of array1's elements into a new array
var array2 = [...array1];
array1.pop(); // Remove the last element from array1
console.log(array2.length);
```

## Mutable and Immutable Data Types in JavaScript

Mutable data types are passed by reference. To make a copy we would use the JavaScript spread operator or a loop, not direct assignment to a new variable.

Immutable data types (aka primitive values) are passed by value. To make a copy we would assign the old variable to a new one, and any changes to either variable would not affect the other.

| Data type | Immutable / Mutable |
| --------- | ------------------- |
| Boolean   | Immutable           |
| Number    | Immutable           |
| String    | Immutable           |
| Array     | Mutable             |
| Object    | Mutable             |
| Function  | Mutable             |

## Mutable and Immutable Data Types in Computer Memory

Computers store data broadly in 2 places: memory (RAM) and drive (SSD or disk). Memory is smaller, faster storage and drive is larger, slower storage. Apps run in memory and persistent data is typically stored in drive.

JavaScript references mutable data types with memory addresses because we do not know beforehand how large these data structures will be. JS can store the value of immutable data types directly without a memory address because immutable data types have a fixed size.

Consider the 2 examples at the start of this submodule. The following diagrams illustrate conceptually what happens in memory after each line of code.

Example 1:

```javascript
var array1 = [1, 2, 3];
var array2 = array1;
array1.pop();
```

![array2 references the same data structure as array1](<../assets/Ref vs Value Example 1.png>)

Example 2:

```javascript
var array1 = [1, 2, 3];
// "..." syntax in front of an array is called the spread operator
// The spread operator copies all elements in an array
// The surrounding [] encapsulates copies of array1's elements into a new array
var array2 = [...array1];
array1.pop();
```

![array2 references a data structure independent from array1](<../assets/Ref vs Value Example 2.png>)

## Additional Resources

1. [This video](https://youtu.be/-hBJz2PPIVE) explains reference vs value with a live coding example.
2. [This video](https://youtu.be/fVVrfJM4JeY) explains in more detail how arrays are stored in memory.
