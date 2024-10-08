# Destructuring and Spread Operator

## Learning Objectives

1. What the destructuring and spread operators are and how to use them

## Introduction

ES6 Destructuring and Spread Operators provide more convenient syntax for extracting variables from and making copies of arrays and JS Objects.

## Destructuring Assignment

Assign array or object properties to new variables.

### Example: Array destructuring syntax

Assign and name variables according to their **position** in an array.

```javascript
const row = ["X", "O", "X"];
const [left, center] = row;
console.log(left); // Output 'X'
console.log(center); // Output 'O'
```

### Example: Object destructuring syntax

Assign and name variables according to their **key** in an object.

```javascript
const user = { name: "kai" };
const { name } = user; // Create a new variable called name
console.log(name); // Output 'kai'
```

### Example: Return Multiple Values from Functions

Occasionally we may need to return multiple values from a function. If we wrap those values in an object, we can use ES6 destructuring to re-initialise those values as local variables in the parent function. ES6 named imports work the same way.

```javascript
const conversions = (temperatureInFahrenheit) => {
  let temperatureInCelsius = 123; // calculation goes here
  let temperatureInKelvin = 456; // calculation goes here

  return {
    kelvin: temperatureInKelvin,
    celsius: temperatureInCelcius,
  };
};

const { kelvin, celsius } = conversions(20);
console.log(kelvin);
console.log(celsius);
```

### Example: Import Multiple Named Exports

ES6 `import` uses object destructuring to initialise variables for imported functions.

Given this file that exports 3 named functions...

```javascript
export const kilometersToMiles = (kilometers) => {
  /* ... */
};
export const celciusToFahrenheit = (temperatureCelcius) => {
  /* ... */
};
export const kilogramsToPounds = (kilograms) => {
  /* ... */
};
```

... we can import those functions using named imports in a client module.


```javascript
import {
  kilometersToMiles,
  celciusToFahrenheit,
  kilgramsToPounds,
} from "./temperatureConversion.js";

console.log(kilometersToMiles(3));
console.log(celciusToFahrenheit(3));
console.log(kilogramsToPounds(3));
```

## Spread Operator

Returns a [shallow copy](https://medium.com/@manjuladube/understanding-deep-and-shallow-copy-in-javascript-13438bad941c) of the elements or key-value pairs inside an array or object respectively.

### Example: Make Shallow Copy of Array

As we may have seen, assigning an array to a new variable creates a new reference to the original array, and does NOT make a copy of the original array.

```javascript
const temperatures = [23, 12, 45];
const temperaturesCopy = temperatures; // New var is reference to temperatures.
temperatureCopy.pop(); // This mutates the original temperatures array.
```

Spread operator syntax inside a new array declared with `[]` makes a shallow copy of the original array. The same syntax works for objects.

```javascript
const temperatures = [23, 12, 45];
const temperaturesCopy = [...temperatures]; // Make shallow copy of temperatures.
temperatureCopy.pop(); // This does NOT mutate the original temperatures array.
```


> **Shallow vs deep copy**
> 
> Shallow copies of arrays and objects are different from deep copies. A shallow copy is a new copy of values 1 level deep. A deep copy is a new copy of values no matter how many levels deep. Read more on shallow and deep copies in [this tutorial](https://www.javascripttutorial.net/object/3-ways-to-copy-objects-in-javascript/).

### Example: Concatenate Arrays

We can combine multiple arrays using the spread operator as below.

```javascript
const names = ["susan chan", "garfield"];
const names2 = ["alex", "chee kean"];
const combinedArray = [...names, ...names2]; // has all four elements inside
```

### Example: Concatenate Objects

Similarly, we can merge the contents of 2 objects using the spread operator as below.

```javascript
const userData = { name: "kai" };
const userData2 = { height: 6 };
const combinedUserData = { ...userData, ...userData2 }; // has both keys inside
```
