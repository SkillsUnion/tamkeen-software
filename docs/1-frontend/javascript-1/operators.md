# Arithmetic Operators | Mathematical Expressions

## Learning Objectives

* Be familiarized with the list of arithmetic operators available
* Write your own mathematical expressions
* Learn how to concatenate strings

## Introduction

Arithmetic operators takes numerical values as their operands (the values on both sides of the operator) and returns a single numerical value.

`6 + 13 // '+' is the operator; both values, '6' and '13', are the operands`

In the case above, 13, being on the right side, is added to 6, on the left.

The standard arithmetic operators are addition (`+`), subtraction (`-`), multiplication (`*`), and division (`/`). These operators work as they do in most other programming languages when used with floating point numbers (decimals).

Here is a list of arithmetic operators:

| Operator                  | Description                                                                                                                  | Example                                              |
| ------------------------- | ---------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------- |
| Addition ( + )            | a + b<br>Result: adds b to a.                                   | 3 + 9<br>Result: 12 |
| Subtraction ( - )         | a - b<br>Result: subtracts b from a                                            | 6 - 8<br>Result: -2 |
| Multiplication ( * )     | a * b<br>Result: a is multiplied by b                                          | 4 * 2<br>Result: 8               |
| Division ( / )            | a / b<br>Result: a is divided by b                                             | 9 / 3<br>Result: 3  |
| Remainder or Modulo ( % ) | a % b<br>Result: remainder of a divided by b                                   | 10 % 6<br>Result: 4 |
| Increment ( ++ )          | a++<br>Result: adds 1 to a<                                                     |                                                      |
| Decrement ( -- )          | a--<br>Result: subtracts 1 from a                                                           |                                                      |
| Exponential ( ** )      | a ** b<br>Result: a is multiplied by itself by b number of times. |                                                      |

## String Concatenation (addition operator)

You are able to use the arithmetic addition operator to combine two strings together, this can also be known as concatenation of two strings. The same addition operator `+`  that is used on numbers are applied to strings in this case.

Though it should be noted that if you add two different data types together this can cause **type coercion**. Which is a fancy way of saying, JavaScript will alter the datatypes to accommodate the logic used. If you want to know more about type coercion please read about it [here.](https://www.geeksforgeeks.org/what-is-type-coercion-in-javascript/)

Using the addition operator we can assign a combined string to a variable.

```javascript
// String Concatenation using "+" operators

var string = 'Good morning' + ' ' + 'class';

console.log(string)
// 'Good morning class'

```

In the example above we are taking the strings:  `Good morning` ,  `' '`   and  `class` to create a single string reading  `Good morning class` . They are being combined / concatenated through the `+` sign which is the operator.
