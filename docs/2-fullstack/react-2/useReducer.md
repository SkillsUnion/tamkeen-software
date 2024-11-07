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

