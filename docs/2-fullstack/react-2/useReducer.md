# useReducer

## Learning Objectives

1. Use React useReducer hook to manage complex state and state transitions within a React Application
2. Learn how to maintain state logic outside of React components by utilising useReducer within the application.

## Introduction

When developing React applications, it is advised to break your application into small reusable Components. However, there will come a time when there are many state updates spread across all of these Components and their event handlers. 

If you find that is difficult to maintain your states across all of these Components, it might be a good time to implement **useReducer** to extract your updating logic from your functions.

Explore the link <a href="https://react.dev/learn/extracting-state-logic-into-a-reducer" target="_blank">React and Reducers</a> for the official React implementation and use of useReducer within a React Application. 

Before we delve into implementation, note that reducers in  React are just functions that take in the state so far, as well as an action to return the next state. This means that they accumulate actions over time and this will alter the state. This removes state and updating logic from React Components and allows developers to maintain this information in the Reducer files.

When moving from state logic to using reducers, we will need to follow these steps:

1. <a href="https://react.dev/learn/extracting-state-logic-into-a-reducer#step-1-move-from-setting-state-to-dispatching-actions" target="_blank">Move state updates into dispatcher functions</a>, this means that we need to alter the way that our components work, remove all of the logic that update states and use it within dispatcher functions. We dispatch these actions to the reducer to update and alter our state.
2. <a href="https://react.dev/learn/extracting-state-logic-into-a-reducer#step-2-write-a-reducer-function" target="_blank">Write a reducer function</a>that will now house all of the state updates within the React application, it takes in two arguments: **the action object as well as the current state**. React will align itself to whatever state is returned from the reducer.
3. <a href="https://react.dev/learn/extracting-state-logic-into-a-reducer#step-3-use-the-reducer-from-your-component" target="_blank">Use the reducer in your Components</a>, replace any useState methods with the useReducer  and get the required information for your components.
4. While useReducer takes a little more setup than using useState (because you need to write both a reducer function and dispatch actions), the reducer cuts down on code if many event handlers modify state in a similar fashion.

## useReducer

<a href="https://react.dev/reference/react/useReducer" target="_blank">React useReducer</a> is a React Hook that allows us to add a reducer into your Component. This method allows you to extract state from Components into a single store, ultimately improving on readability and code maintenance.

## Sample Implementation useContext and useReducer

Two examples have been provided to showcase the use of `useReducer` within our React components, a Shopping List Application has been developed first by using React state, the second developed using `useReducer`. Checkout both example to understand how you can implement and Reducers within React Applications.

<a href="https://github.com/SkillsUnion/react-reducer" target="_blank">ShoppingList application</a> without using useReducer.

<a href="https://github.com/SkillsUnion/react-reducer/tree/reducer" target="_blank">ShoppingList application</a> using useReducer.

The main difference between these repositories is that the updating that logic has been removed and replaced with reducer actions to maintain state. 

Check out the `ShoppingLists.jsx` file within the Reducer folder, within is all of the business logic that will maintain state within the application. When developing much larger projects that contain multiple sets of reducers and contexts, this system of extracting state into reducer files will make maintain state updating logic much more efficient instead of being spread throughout your Components. 

It should be noted that a new pattern of implementing useContext has been showcased in this example. Instead of implementing all of context code within the `App.jsx`, we have extracted it into its own file: `ShoppingListProvider.jsx` within the Provider folder. While this isnt necessary, it allows us to further separate React UI logic from state management.

## useReducer Challenge

Try this out yourself by trying out the <a href="https://react.dev/learn/extracting-state-logic-into-a-reducer#challenges" target="_blank">React official challenge</a>.

## States and Reducers

- Similar to useState hook
- Allows complex state management logic

| State | Reducer |
|---|---|
| `const [state, setState] = useState(initialState)` | `const [state, dispatchFunc] = useReducer(reducerFunc, initState, ...)` | 
| Main state management tool | Advanced state management tool |
| Independent data and states | Related data and states |
| Limited state updates | Complex state updates |
| De-centralised states functions | Centralised state functions |

## Application - Simple CRM

### Create Reducer Function

Copy the sample code [here](https://github.com/SkillsUnion/se-sample-react-reducers) and follow through the code guide.

Create a new folder `src\reducers` and create a new file `ProductReducers.jsx`, where it will export two objects:
- Default product parameters
- Reducer function, `productReducer(state, action)`

```js
// ProductReducers.jsx
export const defaultProduct = {
  count: 1,
  discount: 0,
  name: 'Bananas',
  price: 2.99
}

export function productReducer(state, action) {
  ...
}
```

The reducer function accepts two arguments, the current `state` and the `action` to be taken. The reducer will calculate and return the next state. React will store the next state, renders the component and updates the UI.

Actions can be of any user-defined form. Conventionally, we pass objects with a `type` property to identify to action. Once in the reducer function, the `action.type` supplied will determine how a new state is calculated and returned the caller function. The conditional branching can be achieved in code with a `switch` statement.

```js
// ProductReducer.jsx
export function productReducer(state, action) {
  switch (action.type) {
    ...
  }
}
```

Next, we port the state management functions from `Product.jsx` into the reducer function by moving following state variables `count`, `discount`, `name` and `price`. 

Let's start with the `handlerPlus` function which sets the `count` and `discount` state variables. 

```js
// Product (original code)
const handlerPlus = () => {
  setCount((prevCount) => {
    let count = prevCount + 1;
    if (count >= 5) {
      setDiscount(20);
    }
    return count;
  });
};
```

We define the `action.type` for the above actions as 'PLUS_COUNT' (or any other descriptive constant):

```js
// ProductReducer.jsx
export function productReducer(state, action) {
  switch (action.type) {
    case 'PLUS_COUNT': {
      let newState = { ...state };  // Copy the previous state
      newState.count = state.count + 1;
      if (newState.count >= 5) {
        newState.discount = 20;
      }
      return newState;  // Return the new updated state
    }
    default:{
      throw Error('productReducer - unknown action:', action.type);
    }
  }
}
```

In the reducer function, we must create a copy of the previous state object *before* making any changes to its properties, because the incoming state object is **immutable**. We can copy the state with the ES6 object spread operator `{...}`. Once the state calculations are completed, the reducer function returns with a new state object. 

### Add a Reducer to a Component

Call `useReducer` at the top-level `Product` component.

```js
// Product.jsx
import { useReducer } from 'react';
import { productReducer, defaultProduct } from '../reducers/ProductReducers';

function Product() {
  const [state, dispatch] = useReducer(productReducer, defaultProduct);
  ...
}
```

Since most of the state handling logic has moved the reducer function, we will use the `dispatch` function to trigger the action.

```js
// Product.jsx
const handlerPlus = () => {
  dispatch({ type: 'PLUS_COUNT' });
}
```

Finally, we update the JSX to show the reducer's state object properties (e.g. `state.count`), instead of the original state variables.

```js
// Product.jsx
return (
  <div>
    <Card
      ...
      count={state.count}
      discount={state.discount}
      ...
    >
  </div>
...
```
You can now test the '+' button functionality. 

### Passing Arguments to a Reducer Function

A reducer function can receive any number of arguments via `action` properties. For example, to pass `name` to `productReducer`, the caller function will pass a second parameter via `dispatch`:

```js
// Product.jsx
const handlerChangeName = (value) => {
  dispatch({ type: 'SET_NAME', name: value })
}
```

In the reducer function, the `name` property is received in the `action` object:

```js
// ProductReducer.jsx
case 'SET_NAME': {
  return {...state, name: action.name }
} 
```

Test the app's name field. Note how the values can be manipulated through the reducer functions.

## Combining Context and Reducer Functions

In this section, we will combine what we have learned and refactor `Product` and its component tree to use context as 'global' store for its data and handler functions.

### Create Context Provider

Create the context folder `src\context` and add the context file `ProductContext.jsx` where you will add the context object, define and export `ProductProvider` and `ProductContext` functions. 

```js
// ProductContext.jsx
import { createContext } from 'react';
const ProductContext = createContext();

export function ProductProvider({ children }) {
  ...   
}

export default ProductContext;
```

### Import Reducer Function

We must import the reducer function that we created previously, as this is where the state variables and handler functions are stored. Port the reducer function calls from `Product.jsx` into `ProductContext.jsx`: 

```js
// ProductContext.jsx
import { createContext, useReducer } from 'react';
import { defaultProduct, productReducer } from '../reducers/ProductReducer';

export function ProductProvider({ children }) {
  const [state, dispatch] = useReducer(productReducer, defaultProduct);
  
  const handlerPlus = () => {
    dispatch({ type: 'PLUS_COUNT' });
  };
  const handlerChangeName = (value) => {
    dispatch({ type: 'SET_NAME', name: value });
  };
  ...  
```

### Create Context Object

Complete the product context provider by defining the actual states that you want to store in the context component and pass it to the `ProductContext.Provider` object as a `value` prop:

```js
// ProductContext.jsx
...
export function ProductProvider({ children }) {
  ...
  const context = {
    count: state.count,
    discount: state.discount,
    name: state.name,
    price: state.price,
    handlerPlus: handlerPlus,
    handlerChangeName: handlerChangeName,
  }   
  return (
    <ProductContext.Provider value={context}>
      {children}
    </ProductContext.Provider>
  )
  ...
```

###  Mini-Exercise

In order for the app to completely work, the handlerMinus and handlerChangePrice should also be included in the reducer function. The exercise's goal is for the learners to implement the two functions.


### Add Context Provider to Top-Level Component

Recall how the Context Provider needs to be added to the top-level component

```js
// App.jsx
import { ProductProvider } from './context/ProductContext';

function App() {
  return (
  ...
    <ProductProvider>
      <Product />
    </ProductProvider>
...     

```
 
> To the top-level component, `ProductProvider` is a short form of `ProductContext.Provider` 

### Apply the `useContext` Hook

Refactor `Product.jsx` to use context:

```js
// Product.jsx
import { useState, useContext } from 'react';
import ProductContext from '../context/ProductContext';

function Product() {
  
  // Replace useReducer --> useContext
  //
  // const [state, dispatch] = useReducer(productReducer, defaultProduct);
  
  const ctx = useContext(ProductContext);

  // Remove all handlers functions as they have been moved to ProductContext
  //
  // const handlerPlus = () => {
  // const handlerMinus  ...
  // const handlerChangeName ... 
  // const handlerChangePrice ...
  
  // Rename all references to state --> ctx object 

  const handlerAddProduct = () => {
    const newItem = {
      name: ctx.name,
      quantity: ctx.count,
      price: ctx.price,
      discount: ctx.discount,
      total: ctx.count * ctx.price * (100-ctx.discount)/100,
    } 
  ...
  // Remove all props that have been moved to the context 

  return (
    <div className={styles.container}>
      <Card
        handlerAddProduct={handlerAddProduct}
      />
      <ViewList list={list} sum={sumTotal} />
    </div>    
  )
  export default Product;

```

Then modify Card.jsx to include the context:
```jsx
//Card.jsx
import { useContext } from "react";
import ProductContext from "../context/ProductContext";
import styles from "./Card.module.css";
import Button from "./Button";
import Input from "./Input";

function Card({
  handlerAddProduct
}) {
  const ctx = useContext(ProductContext);
  return (
    <div className={styles.container}>
      <div className={styles.name}>{ctx.name}</div>
      <div className={styles.counter}>
        <Button label="➖" onClick={ctx.handlerMinus} />
        <span className={styles.count}>{ctx.count}</span>
        <Button label="➕" onClick={ctx.handlerPlus} />
      </div>
      <div className={styles.price}>{`$ ${ctx.price}`} each</div>
      <div className={styles.discount}>{`Discount: ${ctx.discount}%`}</div>
      <div className={styles.form}>
        <Input value={ctx.name} label="Product Name" onChange={ctx.handlerChangeName} />
        <Input value={ctx.price} label="Price" onChange={ctx.handlerChangePrice} />
      </div>
      <Button label="Add Product" onClick={handlerAddProduct} />
    </div>
  );
}
export default Card;

```

Sometimes, if the application is small enough, simple state management using useState will be sufficient. However, if your application gets more complicated, then the use of useState and useReducer might be more beneficial to you and your team to handle complicated states.

