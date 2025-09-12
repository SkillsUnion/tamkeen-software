# The `useState` Hook

## Learning Objectives

- Apply the useState hook to create and manage state variables in React functional components.
- Apply the recommended naming convention for useState variables to improve code readability.
- Implement effective state management practices, including grouping related state variables and updating state based on its current value.

## Introduction to React Hooks

> React Hooks are a newer and more efficient syntax for React Components. They allow us to write all components as functional components, and use so-called "Hook" functions to replace class component functionality such as state management and lifecycle methods. Components with hooks are functionally the same as class components.
> 
> <a href="https://reactjs.org/docs/hooks-faq.html#should-i-use-hooks-classes-or-a-mix-of-both" target="_blank">React team recommends using Hooks for new projects</a>. They are <a href="https://react.dev/" target="_blank">re-writing the official React tutorials to use Hooks</a>. React Router v6 (the latest and greatest version of React Router) that we are about to learn only supports React Hooks syntax natively.
>
> Many companies are still using <a href="https://legacy.reactjs.org/docs/react-component.html" target="_blank">Class based React Components</a> in their code. It will be important for us to still understand class Components, but know how to write Components with Hooks for new code to take advantage of latest React functionality. If you want to explore how to use state and lifecycles in React Class based Components you can read <a href="https://legacy.reactjs.org/docs/state-and-lifecycle.html" target="_blank">this documentation</a>.

## <a href="https://react.dev/reference/react">Hooks</a> at a Glance

1. React Hooks provide all the functionality we need from React Class based Components that we didn't previously have with Functional Components of the past.
2. `useState` hook replaces `this.state` and `this.setState` with a new pair of variables for getting and setting a specific state value.
3. Note how the React team encourages us to use multiple `useState` Hooks in the same component for each type of state. There is no need to store all of a component's state in a single `this.state` object like we did previously.
4. Returning a cleanup function from `useEffect` is advanced functionality, we will be exploring it in later lessons
5. We will learn about `useContext` and `useReducer` hooks in a later submodule.

## <a href="https://react.dev/reference/rules/rules-of-hooks" target="_blank">Rules of Hooks</a>

There are some general rules that must be applied when using hooks in React. Take a look at the documentation for details, but here is the summary:

1. <a href="https://react.dev/reference/rules/rules-of-hooks#only-call-hooks-at-the-top-level" target="_blank">Only call Hooks at the top level</a> – Don’t call Hooks inside loops, conditions, or nested functions. Instead, always use Hooks at the top level of your React function, before any early returns.
2. <a href="https://react.dev/reference/rules/rules-of-hooks#only-call-hooks-from-react-functions" target="_blank">Only call Hooks from React functions</a> – Don’t call Hooks from regular JavaScript functions.


## Using the `useState` Hook

We will use the <a href="https://react.dev/reference/react/useState">`useState`</a> Hook most often. 

> Follow the naming convention of `X` and `setX` as the de-structured state variable names from `useState`. This makes our code more readable because other engineers will immediately know what each variable is for.

### Sample `useState` Hook

{% include youtube.html id="eb6HKsxHoas" %}
React Hooks `useState`

### React State management, `useState`

While creating your application and enlarging functionalities you will find that you are developing your components and states into much larger and complex files than you had before. It is important to manage state effectively and reduce redundant or duplicated states within your application.

Here is the documentation for <a href="https://react.dev/learn/managing-state" target="_blank">state management</a>

1. When using `useState` to manage component states, you can follow these steps:
   - Import the `useState` hook from the react package, at the top of the component file
   - Within your functional component declare a state variable and the updater function using the `useState` hook. As shown on <a href="https://react.dev/learn/managing-state#reacting-to-input-with-state" target="_blank">line 4</a>.
   - The initialValue of the state is passed into `useState`.
   - You can update this variable using the updater function.
2. We will take a deeper look onto `useContext` and `useReducer` later in this course.
3. When developing your states, group information of two state variables always change together, therefore unify them into a single state variable. Here are some more rules regarding <a href="https://react.dev/learn/choosing-the-state-structure" target="_blank">state structure</a>.
4. When updating a state variable, it's possible to use its current value, this is done by invoking a callback function on the updater function. Take a look at <a href="https://react.dev/reference/react/useState#updating-state-based-on-the-previous-state" target="_blank">these examples here</a>.

## useState Use Case - Simple CRM

Create a new React app called `my-app` with src/components folder:

```sh
npm create vite@latest
cd my-app/src
mkdir components
```
Clean up the files as described in previous chapter.

## Create the Base Code

Create a simple `Counter` component in the `components` folder:
```js
// Counter.jsx

function Counter() {
  return (
    <>
      <button>-</button>
      <span>0</span>
      <button>+</button>
    </>
  );
}
export default Counter;
```
Edit App.jsx
```js
import Counter from "./components/Counter";
import styles from "./App.css";

function App() {
  return (
    <div className="App">
      <h1>Counter</h1>
      <Counter />
    </div>
  );
}

export default App;
```

Update the style sheets in `App.css`
```css
.App {
  font-family: sans-serif;
  text-align: center;
}

button {
  font-size: 2rem;
  margin: 1rem;
  padding: 0.5rem 1rem;
}

span {
  font-size: 1.5rem;
}
```
You now have a static React page that doesn't really do anything! Let's add some functionality to the buttons.

## Add UI Interactivity

We will now add the `useState` hook into the `Counter` component to enable state management. 

```js
// Counter.jsx
import { useState } from 'react';

function Counter() {
  const state = useState(0);
  console.log(state)
  return (
    ...
  );
}
```
Before we use the state variable returned by `useState`, let's take a peek at the console.log to see what is useState returns, i.e. an array of 2 elements:

1. The state value
2. An update function which allows us to change the state value 

**IMPORTANT**: The state value must be changed via the update function --it cannot be changed directly!

Re-write the useState expression to use ES6 array destructuring to assign the state variable and update function respectively:

```js
// Counter.jsx
function Counter() {
  const [count, setCount] = useState(0);
  ...
}
```
Let's put the `setCount` function to use, by creating a '+' button handler `handlerPlus` and inserting `setCount` into the function:

```js
function Counter() {
  const [count, setCount] = useState(0);
  
  const handlerPlus = () => {
    setCount(1);
    console.log(count);
  }
  return (
    ...
      <button onClick={handlerPlus}>+</button>
    ...
  );
}
```
> Note: The `handlerPlus` function is written in ES6 arrow notation, which is equivalent to `function handlerPlus() {...}`. 

The '+' button will now update the state with a new value, which you can see on the console.log.

To complete the '-' and '+' handlers, `setCount` has to compute a new state using the previous state (prevCount), by passing a function to `setState`. 

### Activity (5 mins)

Try to implement the `handlerMinus` function on your own before we proceed to the next part. 

We complete the component by adding the '-' button handler `handlerMinus` and assigning `{count}` in between the `<span>` element to display the counter:

```js
function Counter() {
  const [count, setCount] = useState(0);

  const handlerPlus = () => {
    setCount(prevCount => {
      return (prevCount + 1)
    });
  };
  const handlerMinus = () => {
    setCount(prevCount => {
      return (prevCount - 1)
    });
  };

  return (
    <>
      <button onClick={handlerMinus}>-</button>
      <span>{count}</span>
      <button onClick={handlerPlus}>+</button>
    </>
  );
}
```
You now have a fully functional counter! 

## Objects as State Variables

State variables can be a primitive data type (e.g. numbers, strings) or complex data types, e.g. objects and arrays. Let's look at how to use objects as state variable. Change the `Counter` state variable and update function to an object `product` and `setProduct` respectively, and adapt the '+' handler:

```js
function Counter() {
  const [product, setProduct] = useState({
    name: 'Fruits',
    count: 0,
  });

  const handlerPlus = () => {
    setProduct(prevProduct => {
      return { 
        count: prevProduct.count + 1 
      }
    })
  }
  
  // Keep handlerMinus unchanged for the time being.

  return (
    <>
      <h2>{product.name}</h2>
      <button onClick={handlerMinus}>-</button>
      <span>{product.count}</span>
      <button onClick={handlerPlus}>+</button>
    </>
  );
}
```
Press the '+' button a few times to observe what is happening. 

You will see that the "Fruits" heading disappears when you press the button!

Explain your observation and suggest a solution. 

> Do not read ahead for the solution yet!

The `setProduct` update function will **overwrite** the previous state variable `product`. Therefore, you must make a copy of the previous state object before updating any field in the object. You can use the ES6 spread operator `{...}` on your return statement.

```js
// Counter.jsx

const handlerPlus = () => {
    setProduct(prevProduct => {
      return { 
        ...prevProduct,
        count: prevProduct.count + 1 
      }
    })
  }
```

Note that you might incur some performance overhead when using object state variables, so consider using multiple state variables with primitive data types as an alternative, if there are only a few states to manage. For exampe:

```js
  const [name, setName] = useState('Fruits');
  const [count, setCount] = useState(0);
```

### Activity (5 mins)

Implement the handlerMinus function similar to how handlerPlus is implemented.

## Further notes about Hooks

Create a new component `Discount.jsx` [code](./code/2.3-part-4-begin.jsx) where the app should display a discount value when the counter exceeds a pre-determined value. However, there are a few errors in the code. 

Why does the app crash? Read the following rules for some clues.

### Hooks at the Top
- Hooks only work from functional components
- Hooks must be called at the top level of the React function
- Do not call hooks from loops, conditions, nested function or blocks

Now that you understand the above rules, propose a solution to fix the code above. 

There are several ways to improve the code, here are some hints:
- Copy the previous state object (`prevState`) before updating the state variables (see Part 3)
- Move the discount calculation logic into the handlers
- Create a reset button to reset the values
- Use an `initialValues` object to store the default values 

Once you have made an attempted to a solution, here is a possible [solution code](https://github.com/SkillsUnion/se-sample-react-usestate/blob/main/2.3-part-4-final.jsx).