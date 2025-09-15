# Conditional Rendering

## Learning Objectives

1. Differentiate between various methods of conditional rendering in React components.
2. Apply conditional statements and ternary operators to dynamically render JSX based on props or component state.
3. Design React components that adapt their UI based on different conditions, enhancing the user experience.

## Conditional Rendering

Components will often need to display different UI's depending on conditions passed down as props, or the information its processing. You are able to conditionally render JSX in React using various patterns within JavaScript including conditonal statements that return JSX, or <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Conditional_operator" target="_blank">ternary operators</a>.

1. Conditional rendering is one of the most powerful features of React, enabling us to use conditional logic to specify what a component should render.
2. You can use inline code for conditionals, `condition ? true : false` syntax is the <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Conditional_Operator" target="_blank">JavaScript conditional operator</a>.

React documentation for <a href="https://react.dev/learn/conditional-rendering" target="_blank">Conditional Rendering</a> is a good place to start learning about the topic.

React components have the ability to render UI elements according to its current state. In this example we will conditionally render our `Product` component UI in either light or dark mode, with the help of several ES6 operators.

### Application - Simple CRM

Copy the starter code [here](https://github.com/SkillsUnion/se-sample-react-condrendlist) for part-1 and start the React app.

```
cp -r part-1-begin work-1

cd work-1
npm run dev
```

> Note: we will see some folders like `context` and `reducers` in this starter code, but we will deal with how these work when we move to the Full Stack module.


There are three methods to do conditional rendering:
1. Using if-else statements
2. Using ternary conditions
3. Using short circuit evaluations

### Creating the state and handler function

For this demonstration, we will toggle the visibility of the ViewList component. In order to achieve this, we need to create the state and the handler function to toggle the state. We also need to create a button to handle the event.

In Product.jsx, create a new state called showItem and set its initial value to false. Then create the handler function called handleShowItem. 

```js
//Product.jsx
...
const [showItem, setShowItem] = useState(false);
...

const handleShowItem = () => {
  setShowItem(!showItem);
}
...

//In JSX
...
<Button label="Show Cart" onClick={handleShowItem}/>
<ViewList list={list} sum={sumTotal} />
...
```

### Method 1: Using if-else statements 
If-else statements can be used to determine which elements can be rendered. 

Add the following logic in Product.jsx, and replace the ViewList in JSX with listComponent
```js
//Product.jsx
let listComponent = null;
if(showItem){
  listComponent = <ViewList list={list} sum={sumTotal} />
} else {
  listComponent = null;
}

//In JSX
<Button label="Show Cart" onClick={handleShowItem}/>
{listComponent}
```
JSX can be assigned to variables and these variables can be used in the render function.

Test out the conditional rendering by clicking the button and see if the ViewList component toggles.

### Method 2: Using ternary conditions

Ternary conditions can be used to render components. The ternary component follows the syntax:

```
condition ? expression if true : expression if false
```

Using the state as the condition, different components can be displayed based on the value of the state.

In Product.jsx, remove / comment out the `if-else` and the `listComponent` created earlier and replace it with the following code:

```js
//Product.jsx
//In JSX
{ showItem ? <ViewList list={list} sum={sumTotal} /> : null }
```

Test out the conditional rendering by clicking the button and see if the ViewList component toggles.

### Method 3: Using short circuit evaluations 

Short circuit evaluation uses logical operations AND and OR (&& and ||) to determine the result. If the first condition is true, it will run the statement after the operation.

In Product.jsx, remove / comment out the ternary expression created earlier and replace it with the following code:

```js
{ showItem && <ViewList list={list} sum={sumTotal} />}
```
If the state is true, it will render the ViewList component. If the state is false, it will hide the component.

Test out the conditional rendering by clicking the button and see if the ViewList component toggles.
