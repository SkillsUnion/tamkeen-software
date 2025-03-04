# JavaScript ES6

## Learning Objectives

1. Know that ES6 is today's de-facto JavaScript language version
2. `let` and `const` in variable declaration
2. Block scope (ES6) vs function scope (ES5 and before)
3. Arrow functions
4. Template literals

## Introduction

[ES6](https://www.w3schools.com/js/js_es6.asp) is today's de-facto JavaScript language version. JS began with few features and has since included many more. Every coding language has maintainers that release new versions over time.

Browser compatibility is a primary consideration for JS version because frontend JS runs in our users' browsers, whose versions we do not control. Older browsers may not be able to run newer versions of JS. This is why later JS versions such as ES7 are not yet widely-adopted. We can still use ES7 with "compilation" programs such as Webpack to compile our code into browser-friendly syntax.

## `let` and `const` variable declaration

In Coding Basics we may have declared variables with `var`.

```javascript
var kilometers = 10;
var randomDiceRolls = [3, 2, 4, 5];
```

In ES6 we change variable declaration syntax to use `let` and `const` instead.

```javascript
let kilometers = 10;
const randomDiceRolls = [3, 2, 4, 1];
```

The following sections are guidelines on when to use `let` vs `const`.

### `let` for primitive values that change

Use `let` if the value in our variable is a primitive data type (e.g. number, string, or boolean) and we expect the value to be reassigned.

```javascript
let kilometers = 10;
```

### `const` for primitive values that don't change

Use `const` if our variable's value will not change.

```javascript
const sidesOfDice = 6;
```

Reassigning a `const` variable throws an error.

```javascript
const pi = 3.14;
pi = 99999; // you will get an error with this line
```

### `const` for arrays and objects

We typically use `const` for arrays and objects, even if we plan to mutate the values inside them. This is because arrays and objects (and other variable-size data types over than strings) are known as ["mutable" data types](https://developer.mozilla.org/en-US/docs/Glossary/Mutable), whose variable values are actually "pointers" to "memory addresses" that store the variable-size data type. When we modify arrays and objects, the contents at their addresses may change, but the addresses and pointers themselves do not change, thus `const` is appropriate for var declarations.

```javascript
const diceRolls = [3, 4, 1, 6, 1];
```

We can alter values inside arrays declared with `const`.

```javascript
const diceRolls = [4, 2, 1, 4];
// The following affects values inside diceRolls but not the address of diceRolls
diceRolls.push(5);
```

But we cannot reassign the value of array variables declared with `const`.

```javascript
const diceRolls = [4, 2, 1, 4];
// This will cause an error for reassignment of a const variable
diceRolls = [5];
```

> **Comparing mutable data types**
> 
> Because variables referring to data structures store addresses, we cannot compare the values in 2 arrays with `===` because `===` will compare their memory addresses and not values. To compare values in arrays we will need to write a loop.

```javascript
// This boolean statement will return false
[1, 2, 3] === [1, 2, 3];
```

## Block scope vs function scope

Variables declared with `let` and `const` in "blocks" like an if statement will not be available outside those blocks. A block is a section of code surrounded by curly braces `{}` such as conditional statements, loops and functions. `var` in ES5 uses "function scope", which makes variables declared with `var` accessible anywhere within a given function.

#### Old Way (Function Scope)

```javascript
var myFunc = function () {
  if (diceRoll === 6) {
    var win = true;
  }
  // This will return true
  console.log(win);
};
```

#### New Way (Block Scope)

```javascript
var myFunc = function () {
  if (diceRoll === 6) {
    let win = true;
  }
  // This will error because win does not exist outside the if statement
  console.log(win);
};
```

## Arrow functions

Arrow functions are a new way for writing functions in ES6 due to their conciseness and wide adoption. There are technical considerations for when to use arrow functions vs other function declaration syntax, but none of them should matter for the bootcamp.

### 1: Arrow function syntax

Arrow syntax is a concise syntax for initialising anonymous functions. Always use `const` when declaring a function variable (functions are a mutable data type).

```javascript
const rollDiceArrow = () => {
  var myRandomValue = Math.random();
  return myRandomValue;
};
```


> **Arrow functions with implicit return value**
> 
> If the right side of an arrow function is a single statement outside a block `{}`, the function will automatically return the evaluation of that statement. This allows us to write concise functions with arrow syntax.

```javascript
// Always get 5.
const rollDiceCheatArrowImplicitReturn = () => 5;

// Return result of Math.floor(Math.random() * 6 + 1)
const rollDiceArrowImplicitReturn = () => Math.floor(Math.random() * 6 + 1);
```

### 2: Regular anonymous function syntax

Like arrow function syntax except the function is declared with the `function` keyword.

```javascript
const rollDiceCheat = function () {
  // always return 6 to win.
  return 6;
};
```

### 3: Named function syntax

Explicitly name the function in the declaration after the `function` keyword.

```javascript
function rollDiceNamed() {
  var myRandomValue = Math.random();
  return myRandomValue;
}
```

## Template Literals

We strongly suggest using template literals for more concise string interpolation. This will help your code be more concise and readable.

Old way: string concatenation

```javascript
let output = "you rolled " + diceRoll + ". nice job!";
```

New way: template literals

```javascript
let output = `you rolled ${diceRoll}. nice job!`;
```

## Exercises

### `let` and `const`

Open the console in Chrome DevTools. Reproduce errors from `const` examples above. What do the error messages say?

### Arrow Functions

Turn the `main` function in any code from Coding Basics (or any function in other code you've written) into an arrow function. Verify the app still works.

### Template Literals

Change string output in previous code you've written from concatenation syntax to template literal syntax. Verify the syntax works as expected.


## Additional Resources

1. [History of JavaScript](https://auth0.com/blog/a-brief-history-of-javascript/)
2. [JavaScript version naming](https://flaviocopes.com/ecmascript/)
